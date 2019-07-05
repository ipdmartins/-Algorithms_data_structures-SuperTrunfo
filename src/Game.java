/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Esta classe define os algoritmos do jogo Super Trunfo
 * @author: Igor Martins
 * @since: 06/09/2018
 * @version: 1.0
 */
public class Game {

    private float avgTerrit;
    private float avgpib;
    private float avglife;
    private float avgpop;
    private float avgfreedom;
    private boolean cond = true;

    private Country c1 = null;
    private List<Country> L1 = new ArrayList<>();
    private CircularlyLinkedList_trabalho<Country> p1 = new CircularlyLinkedList_trabalho<>();
    private CircularlyLinkedList_trabalho<Country> p2 = new CircularlyLinkedList_trabalho<>();

    //Define atributos das cartas e guarda numa Lista comum.
    public void cardSeter() {
        c1 = new Country(0, 13, "China", 9600001, 8109, 76, 1376048943, 58);
        L1.add(c1);
        avgCalculator(c1);
        c1 = new Country(0, 14, "Russia", 17098240, 9243, 70, 143456918, 58);
        L1.add(c1);
        avgCalculator(c1);
        c1 = new Country(0, 8, "Canada", 9984670, 43206, 84f, 35939927, 78);
        L1.add(c1);
        avgCalculator(c1);
        c1 = new Country(0, 1, "Ireland", 70280, 60514, 81, 4688465, 80);
        L1.add(c1);
        avgCalculator(c1);
        c1 = new Country(0, 10, "India", 3287260, 1614, 68, 1311050527, 54);
        L1.add(c1);
        avgCalculator(c1);
        c1 = new Country(0, 4, "Singapore", 710, 52239, 83, 5603740, 89);
        L1.add(c1);
        avgCalculator(c1);
        c1 = new Country(0, 2, "Brazil", 8515759, 8528, 74, 204450649, 51);
        L1.add(c1);
        avgCalculator(c1);
        c1 = new Country(0, 3, "Tunisia", 163610, 3661, 75, 11253554, 59);
        L1.add(c1);
        avgCalculator(c1);
        c1 = new Country(0, 5, "Israel", 22070, 37129, 82.3f, 8064036, 80);
        L1.add(c1);
        avgCalculator(c1);
        c1 = new Country(0, 6, "North Corea", 120540, 642, 70, 25155317, 6);
        L1.add(c1);
        avgCalculator(c1);
        c1 = new Country(0, 7, "Bolivia", 1098580, 3077, 68, 10724705, 44);
        L1.add(c1);
        avgCalculator(c1);
        c1 = new Country(0, 9, "United States", 9831510, 56054, 79, 321773631, 76);
        L1.add(c1);
        avgCalculator(c1);

        c1 = new Country(0, 11, "South Corea", 99900, 27397, 82.2f, 50293439, 74);
        L1.add(c1);
        avgCalculator(c1);
        c1 = new Country(0, 12, "Senegal", 197720, 901, 66, 15129273, 56);
        L1.add(c1);
        avgCalculator(c1);
        c1 = new Country(0, 15, "Chile", 756096, 13416, 82.0f, 17948141, 75);
        L1.add(c1);
        avgCalculator(c1);
        c1 = new Country(0, 16, "Colombia", 1141750, 6056, 74, 48228704, 69);
        L1.add(c1);
        avgCalculator(c1);
        c1 = new Country(0, 17, "Panama", 75420, 13268, 78, 3929141, 67);
        L1.add(c1);
        avgCalculator(c1);
        c1 = new Country(0, 18, "Franca", 549190, 36304, 82.1f, 64395345, 64);
        L1.add(c1);
        avgCalculator(c1);
        c1 = new Country(0, 19, "Jordania", 89320, 4940, 74, 7594547, 65);
        L1.add(c1);
        avgCalculator(c1);
        c1 = new Country(0, 0, "South Africa", 1219090, 5773, 57, 54490406, 63);
        L1.add(c1);
        avgCalculator(c1);

        cond = false;
        avgCalculator(c1);
    }

    //Calcula a media dos atributos das cartas
    public void avgCalculator(Country country) {
        if (cond) {
            avgTerrit = avgTerrit + country.getTerritory();
            avgpib = avgpib + country.getPibCap();
            avglife = avglife + country.getLife();
            avgpop = avgpop + country.getPopulation();
            avgfreedom = avgfreedom + country.getFreedon();
        } else {
            avgTerrit = avgTerrit / L1.size();
            avgpib = avgpib / L1.size();
            avglife = avglife / L1.size();
            avgpop = avgpop / L1.size();
            avgfreedom = avgfreedom / L1.size();
        }
    }

    //Embaralha as cartas do ArrayList e distribui metade para cada jogador
    public void cardDistributor() {
        Collections.shuffle(L1);
        for (int i = 0; i < L1.size(); i += 2) {
            this.p1.addFirst(L1.get(i));
            this.p2.addFirst(L1.get(i + 1));
        }
    }

    public CircularlyLinkedList_trabalho<Country> getP1() {
        return p1;
    }

    public CircularlyLinkedList_trabalho<Country> getP2() {
        return p2;
    }

    public List<Country> getL1() {
        return L1;
    }

    public float getAvgTerrit() {
        return avgTerrit;
    }

    public float getAvgpib() {
        return avgpib;
    }

    public float getAvglife() {
        return avglife;
    }

    public float getAvgpop() {
        return avgpop;
    }

    public float getAvgfreedom() {
        return avgfreedom;
    }

}
