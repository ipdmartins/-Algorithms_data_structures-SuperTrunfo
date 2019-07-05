/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Esta classe define os objetos criados a partir da classe Carro
 *
 * @author: Igor Martins
 * @since: 03/09/2018
 * @version: 1.0
 */
public class TesteTrunfo {

    public static void main(String[] args) {
        Game g = new Game();
        User u = new User(g);
        Computer c = new Computer(g);
        Scanner imput = new Scanner(System.in);

        u.computer = c;
        c.user = u;

        float userAnswer = 0;
        float computerAnswer = 0;
        boolean player1 = true;
        boolean player2 = true;
        int option1 = 0;

        g.cardSeter();
        g.cardDistributor();
        u.handSeter();
        c.handSeter();

        while (u.getUserHand().size() > 0 && c.getComputerHand().size() > 0) {
            System.out.println("");
            System.out.println("###############################");
            System.out.println("SUPER TRUNFO - COUNTRIES' CARDS");
            System.out.println("###############################");
            System.out.println("");
            if (player1) {
                System.out.println("YOU START! Choose your card typing its ''CODE NUMBER''");
                System.out.println("");

                for (int i = 0; i < u.getUserHand().size(); i++) {
                    System.out.println("USER CARD "+(i+1));
                    System.out.println(u.getUserHand().get(i).toString());
                    
                }
                
                option1 = imput.nextInt();
                u.cardShower(option1);
                System.out.println("");

                System.out.println("Now choose your preferred attribute. TYPE: ");
                System.out.println("0 - Freedom index");
                System.out.println("1 - Life expectancy");
                System.out.println("2 - Pib per capita");
                System.out.println("3 - Population");
                System.out.println("4 - Territory");
                option1 = imput.nextInt();
                System.out.println("");

                userAnswer = u.attributeShower(option1);
                System.out.println("");
                c.cardChooser((player2 == false), option1);
                System.out.println("");
                computerAnswer = c.avgCardCalculator(0, 0);
                player1 = false;
            } else {
                System.out.println("COMPUTER START! Choose your card typing its ''CODE NUMBER''");
                System.out.println("");

                for (int i = 0; i < u.getUserHand().size(); i++) {
                    System.out.println("USER CARD "+(i+1));
                    System.out.println(u.getUserHand().get(i).toString());
                }
                
                option1 = imput.nextInt();
                u.cardShower(option1);
                System.out.println("");

                c.cardChooser(player2 == true, 0);
                computerAnswer = c.getRetorno();
                userAnswer = u.attributeShower(c.getComputerAttribOpt());
                player1 = true;
            }

            boolean winner = true;
            if (userAnswer > computerAnswer) {
                System.out.println("");
                System.out.println("### USER WON ###");
                System.out.println("");
                u.userTurn(winner);
                c.computerTurn(!winner);
            } else {
                System.out.println("");
                System.out.println("### COMPUTER WON ###");
                System.out.println("");
                c.computerTurn(winner);
                u.userTurn(!winner);
            }
            System.out.println("User's cards pile size: " + g.getP1().size());
            System.out.println("Computer's cards pile size: " + g.getP2().size());
        }
    }
}
