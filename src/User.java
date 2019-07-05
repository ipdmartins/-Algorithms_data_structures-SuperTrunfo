/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Esta classe define os metodos do jogo Super Trunfo para usuario
 *
 * @author: Igor Martins
 * @since: 06/09/2018
 * @version: 1.0
 */
public class User {

    private ArrayList_trabalho<Country> userHand = new ArrayList_trabalho<>();
    private Game g1 = new Game();
    private Country c1 = null;
    public Computer computer;
    private int cardOption1;
    
    public User(Game g) {
        this.g1 = g;
    }

    //Define a primeira mao do jogador com 5 cartas
    public void handSeter() {
        if (g1.getP1().size() >= 5) {// verifica se o baralho maior que 5.
            for (int i = 0; i < 5; i++) {
                userHand.add(g1.getP1().first());//guarda 1 na mao do jogador
                g1.getP1().removeFirst();//retira uma carta de cima da pilha
            }
        }
    }
  
    //Repoe uma carta ao jogador ao fim de cada rodada
    public void handRepositor(int j) {
        if (userHand.size() == 4 && g1.getP1().size() > 0) {
            //verifica o tamanho da mao e se ainda ha cartas na pilha
            userHand.add(j, g1.getP1().first());//guarda 1 na mao do jogador
            g1.getP1().removeFirst();
        } else if (userHand.size() == 3 && g1.getP1().size() > 1) {
            //verifica o tamanho da mao e se ainda ha cartas na pilha
            userHand.add(j, g1.getP1().first());//guarda 1 na mao do jogador
            g1.getP1().removeFirst();//retira uma carta de cima da pilha
            userHand.add(j, g1.getP1().first());//guarda 1 na mao do jogador
            g1.getP1().removeFirst();//retira uma carta de cima da pilha
        } else {
            System.out.println("There's no more cards to replace.");
            System.out.println("### COMPUTER WON THE GAME ###");
        }

    }

    //Verifica condicao quando o usuario vence ou ganha. Entao, faz a insercao
    //da carta da mao de volta no baralho do usuario.
    public void userTurn(boolean cond) {
        if (cond) {
            g1.getP1().addLast(userHand.get(cardOption1));
            userHand.remove(cardOption1, userHand.get(cardOption1));

            g1.getP1().addLast((Country) computer.getComputerHand().get(computer.getCardOption()));
            computer.getComputerHand().remove(computer.getCardOption(), computer.getComputerHand().get(computer.getCardOption()));

            handRepositor(cardOption1);
        } else {
            handRepositor(cardOption1);
        }
    }
    
    //Mostra os atributos da carta escolhida
    public void cardShower(float option1) {
        for (int i = 0; i < userHand.size(); i++) {
            if (userHand.get(i).getCod() == option1) {
                System.out.println("Card Option: " + userHand.get(i).toString());
                this.cardOption1 = i;
            }
        }
    }

    //Mostra o atributo escolhido
    public float attributeShower(int option1) {
        float answer = 0;
        switch (option1) {
            case 0:
                answer = userHand.get(cardOption1).getFreedon();
                System.out.println("0-attribute USER: " + userHand.get(cardOption1).getFreedon());
                break;
            case 1:
                answer = userHand.get(cardOption1).getLife();
                System.out.println("1-attribute USER: " + userHand.get(cardOption1).getLife());
                break;
            case 2:
                answer = userHand.get(cardOption1).getPibCap();
                System.out.println("2-attribute USER: " + userHand.get(cardOption1).getPibCap());
                break;
            case 3:
                answer = userHand.get(cardOption1).getPopulation();
                System.out.println("3-attribute USER: " + userHand.get(cardOption1).getPopulation());
                break;
            case 4:
                answer = userHand.get(cardOption1).getTerritory();
                System.out.println("4-attribute USER: " + userHand.get(cardOption1).getTerritory());
                break;
        }
        return answer;
    }

    public ArrayList_trabalho<Country> getUserHand() {
        return userHand;
    }

    public int getCardOption1() {
        return cardOption1;
    }

}
