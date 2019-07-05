/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Esta classe define os metodos do jogo Super Trunfo para usuario
 *
 * @author: Igor Martins
 * @since: 10/09/2018
 * @version: 1.0
 */
//Um super atributo eh aquele superior a todas outras cartas do baralho
public class Computer {

    private ArrayList_trabalho<Country> computerHand = new ArrayList_trabalho<>();
    private Game g2;
    private Country c2 = null;
    public User user;
    private int cardOption2 = 0;
    private float computerRetorno = 0;
    private int computerAttribOpt = 0;

    public Computer(Game g2) {
        this.g2 = g2;
    }

    //Define a primeira mao do computador com 5 cartas
    public void handSeter() {
        if (g2.getP2().size() >= 5) {// verifica se o baralho maior que 5.
            for (int i = 0; i < 5; i++) {
                avgCardCalculator(1, 0);//calcula a nota da carda com base nos atributos
                computerHand.add(g2.getP2().first());//guarda 1 na mao do jogador
                g2.getP2().removeFirst();//retira uma carta de cima da pilha
            }
        }
    }

    //Repoe uma carta ao jogador ao fim de cada rodada
    public void handRepositor(int j) {
        if (computerHand.size() == 4 && g2.getP2().size() > 0) {
        //verifica o tamanho da mao do computador e se ainda ha cartas em seu baralho
            avgCardCalculator(1, 0); //calcula a media dos atributos da carta
            computerHand.add(j, (g2.getP2().first()));//guarda 1 na mao do jogador
            g2.getP2().removeFirst();//retira uma carta de cima da pilha

        } else if (computerHand.size() == 3 && g2.getP2().size() > 1) {
        //verifica o tamanho da mao do computador e se ainda ha cartas em seu baralho
            avgCardCalculator(1, 0); //calcula a media dos atributos da carta
            computerHand.add(j, (g2.getP2().first()));//guarda 1 na mao do jogador
            g2.getP2().removeFirst();//retira uma carta de cima da pilha
            computerHand.add(j + 1, (g2.getP2().first()));//guarda 1 na mao do jogador
            g2.getP2().removeFirst();//retira uma carta de cima da pilha
        } else {
            System.out.println("There's no more cards to replace. ");
            System.out.println("### USER WON THE GAME ###");
        }
    }

    //calcula nota da carta conforme media atributos e guarda no lugar do codigo
    public float avgCardCalculator(int num, int num2) {
        float grade2 = 0;
        float vetor[] = new float[5];
        
        //condicional que calcula a media geral da carta e guarda resultado em 'grade'
        if (num == 1) {
            vetor[0] = g2.getP2().first().getFreedon() / g2.getAvgfreedom();
            grade2 = grade2 + vetor[0];
            vetor[1] = g2.getP2().first().getLife() / g2.getAvglife();
            grade2 = grade2 + vetor[1];
            vetor[2] = g2.getP2().first().getPibCap() / g2.getAvgpib();
            grade2 = grade2 + vetor[2];
            vetor[3] = g2.getP2().first().getPopulation() / g2.getAvgpop();
            grade2 = grade2 + vetor[3];
            vetor[4] = g2.getP2().first().getTerritory() / g2.getAvgTerrit();
            grade2 = grade2 + vetor[4];
            grade2 = grade2 / 5;
            g2.getP2().first().setGrade(grade2);
            
        //condicional que verifica o melhor atributo da carta ja escolhida pelo computador    
        } else if (num == -1) {
            computerAttribOpt = 0;
            vetor[0] = computerHand.get(cardOption2).getFreedon() / g2.getAvgfreedom();
            vetor[1] = computerHand.get(cardOption2).getLife() / g2.getAvglife();
            if (vetor[1] > vetor[computerAttribOpt]) {
                computerAttribOpt = 1;
            }
            vetor[2] = computerHand.get(cardOption2).getPibCap() / g2.getAvgpib();
            if (vetor[2] > vetor[computerAttribOpt]) {
                computerAttribOpt = 2;
            }
            vetor[3] = computerHand.get(cardOption2).getPopulation() / g2.getAvgpop();
            if (vetor[3] > vetor[computerAttribOpt]) {
                computerAttribOpt = 3;
            }
            vetor[4] = computerHand.get(cardOption2).getTerritory() / g2.getAvgTerrit();
            if (vetor[4] > vetor[computerAttribOpt]) {
                computerAttribOpt = 4;
            }
        }
        
        //condicional encontra o retorno de acordo com o atributo opcao do usuario 
        if (num == 99) {
            System.out.println("computer Atrib option: " + computerAttribOpt);
            switch (num2) {
                case 0:
                    computerRetorno = computerHand.get(cardOption2).getFreedon();
                    System.out.println("0-Computer avgAttribute = Country: " + computerHand.get(cardOption2).getNome()
                            + ", attribute freedom: " + computerRetorno);
                    break;
                case 1:
                    computerRetorno = computerHand.get(cardOption2).getLife();
                    System.out.println("1-Computer avgAttribute = Country: " + computerHand.get(cardOption2).getNome()
                            + ", attribute life expectancy: " + computerRetorno);
                    break;
                case 2:
                    computerRetorno = computerHand.get(cardOption2).getPibCap();
                    System.out.println("2-Computer avgAttribute = Country: " + computerHand.get(cardOption2).getNome()
                            + ", attribute PIB: " + computerRetorno);
                    break;
                case 3:
                    computerRetorno = computerHand.get(cardOption2).getPopulation();
                    System.out.println("3-Computer avgAttribute = Country: " + computerHand.get(cardOption2).getNome()
                            + ", attribute population: " + computerRetorno);
                    break;
                case 4:
                    computerRetorno = computerHand.get(cardOption2).getTerritory();
                    System.out.println("4-Computer avgAttribute = Country: " + computerHand.get(cardOption2).getNome()
                            + ", attribute territory: " + computerRetorno);
                    break;
            }
        }
        return computerRetorno;
    }

    //Verifica condicao quando o computador vence ou ganha. Entao, faz a insercao
    //da carta da mao de volta no baralho do usuario.
    public void computerTurn(boolean cond) {
        if (cond) {
            g2.getP2().addLast(computerHand.get(cardOption2));
            computerHand.remove(cardOption2, computerHand.get(cardOption2));

            g2.getP2().addLast((Country) user.getUserHand().get(user.getCardOption1()));
            user.getUserHand().remove(user.getCardOption1(), user.getUserHand().get(user.getCardOption1()));

            handRepositor(cardOption2);
        } else {
            handRepositor(cardOption2);
        }
    }

    //Verifica se alguma das cartas da mao contem super atributo;
    public boolean superAttributeChooser(int num) {
        boolean test = true;

        if (computerHand.get(num).getCod() == 14) {
            computerAttribOpt = 4;
            return test;
        }
        if (computerHand.get(num).getCod() == 13) {
            computerAttribOpt = 3;
            return test;
        }

        if (computerHand.get(num).getCod() == 1) {
            computerAttribOpt = 2;
            return test;
        }

        if (computerHand.get(num).getCod() == 4) {
            computerAttribOpt = 0;
            return test;
        }

        if (computerHand.get(num).getCod() == 8) {
            computerAttribOpt = 1;
            return test;
        }
        return test = false;
    }

    //Define qual carta sera escolhida pelo computador
    public void cardChooser(boolean first, int userAttrib) {
        cardOption2 = 0;

        if (first) {
            //percorre as cartas da mao do PC para buscar super atributo
            for (int i = 0; i < computerHand.size(); i++) {
                if (superAttributeChooser(i)) {
                    this.cardOption2 = i;
                    break;
                }
                //caso nao tenha super atributo, busca a carta de maior nota e depois seu melhor atributo
                avgCardCalculator(-1, 0);
                if (computerHand.get(cardOption2).getGrade() < computerHand.get(i).getGrade()) {
                    this.cardOption2 = i;
                    avgCardCalculator(-1, 0);
                }
            }
        //caso o usuario escolha o atributo, busca a carta de maior nota na mao  
        } else {
            avgCardCalculator(-1, 0);
            for (int j = 0; j < computerHand.size(); j++) {
                if (computerHand.get(cardOption2).getGrade() < computerHand.get(j).getGrade()) {
                    this.cardOption2 = j;
                    avgCardCalculator(-1, 0);
                }
            }
        }

        if (first) {
            avgCardCalculator(99, computerAttribOpt);
        } else {
            avgCardCalculator(99, userAttrib);
        }
    }

    public ArrayList_trabalho<Country> getComputerHand() {
        return computerHand;
    }

    public int getCardOption() {
        return cardOption2;
    }

    public Game getG2() {
        return g2;
    }

    public Country getC2() {
        return c2;
    }

    public float getRetorno() {
        return computerRetorno;
    }

    public int getComputerAttribOpt() {
        return computerAttribOpt;
    }

}
