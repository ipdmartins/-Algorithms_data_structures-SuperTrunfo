/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * Esta classe define os atributos e metodos do simulador de jogo Super Trunfo
 *
 * @author: Igor Martins
 * @since: 01/09/2018
 * @version: 1.0
 */
public class Country {

    private float cod;
    private String nome;
    private float territory;
    private float pibCap;
    private float life;
    private float population;
    private float freedon;
    private float grade;
    
    public Country(float grade,float cod, String nome, float territory, float pibCap,
            float life, float population, float freedon) {
        this.grade = grade;
        this.cod = cod;
        this.nome = nome;
        this.territory = territory;
        this.pibCap = pibCap;
        this.life = life;
        this.population = population;
        this.freedon = freedon;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
    
    public float getCod() {
        return cod;
    }

    public void setCod(float cod) {
        this.cod = cod;
    }

    public float getTerritory() {
        return territory;
    }

    public void setTerritory(float territory) {
        this.territory = territory;
    }

    public float getPibCap() {
        return pibCap;
    }

    public void setPibCap(float pibCap) {
        this.pibCap = pibCap;
    }

    public float getLife() {
        return life;
    }

    public void setLife(float life) {
        this.life = life;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPopulation() {
        return population;
    }

    public void setPopulation(float population) {
        this.population = population;
    }

    public float getFreedon() {
        return freedon;
    }

    public void setFreedon(float freedon) {
        this.freedon = freedon;
    }

    @Override
    public String toString() {
        return "Code: "+cod+", nota: "+grade+", name: "+nome+", territory: "+territory
                + ", Pib per Capita: "+pibCap+"\nLife expectancy: "+life
                + ", Population: "+population+", Freedon index: "+freedon;
    }

}
