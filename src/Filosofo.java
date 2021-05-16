//Trabalho problema dos filosofos - Sistemas Operacionais
//Gabriel Braz e Santos - 260569

import java.util.Random;

public class Filosofo
{
    // status 1 - Filosofando
    // status 2 - Comendo
    // status 3 - Esperando
    private int status = 1;
    private int garfo_esquerda;
    private int garfo_direita; //Garfo main.

    Filosofo(int garfo_direita, int garfo_esquerda){
        this.garfo_direita = garfo_direita;
        this.garfo_esquerda = garfo_esquerda;
    }

    public void decisionLogic(Garfo[] listaGarfos){
        //Caso o filosofo estiver comendo, e voltou para a vez dele, ele termina de comer e volta a filosofar.
        //Em outras palavras, status 2 dura uma volta na mesa dos filosofos.
        if (status == 2){
            System.out.println("Filosofo #" + garfo_direita + " terminou de comer e soltou os garfos #" + garfo_direita + " e #" + garfo_esquerda);

            listaGarfos[garfo_direita].setStatus(1);
            listaGarfos[garfo_esquerda].setStatus(1);
            status = 1;

            System.out.println("\nFilosofo #" + garfo_direita + " Esta FILOSOFANDO. - Status garfo #" + garfo_direita + ": " + listaGarfos[garfo_direita].getTypeStatus()
                    + " - Status garfo #" + garfo_esquerda + ": " + listaGarfos[garfo_esquerda].getTypeStatus());
            System.out.println("----------");
            return;
        }

        //Caso o filosofo estiver esperando, ele verifica o status de ambos os garfos que ele precisa usar.
        //Se um ou ambos os garfos estiver ocupado ele continua esperando.
        //Caso ambos estiverem disponiveis ele comeca a comer.
        //Nao tem limite de tempo neste status, pois o filosofo esta esta com fome e eh teimoso.
        if (status == 3){
            System.out.println("Filosofo #" + garfo_direita + " quer comer e esta esperando os garfos #" + garfo_direita + " e #" + garfo_esquerda + " ficarem Disponiveis.");

            if(listaGarfos[garfo_direita].getStatus() == 2 || listaGarfos[garfo_esquerda].getStatus() == 2){
                System.out.println("Filosofo #" + garfo_direita + " notou que o garfo #" + garfo_direita + " esta '" + listaGarfos[garfo_direita].getTypeStatus()
                        + "' e o garfo #" + garfo_esquerda + " esta '" + listaGarfos[garfo_esquerda].getTypeStatus() + "' logo nao pode comer. Continua esperando.");

                System.out.println("\nFilosofo #" + garfo_direita + " Esta ESPERANDO. - Status garfo #" + garfo_direita + ": " + listaGarfos[garfo_direita].getTypeStatus()
                        + " - Status garfo #" + garfo_esquerda + ": " + listaGarfos[garfo_esquerda].getTypeStatus());
            } else {
                System.out.println("Filosofo #" + garfo_direita + " notou que o garfo #" + garfo_direita + " e o garfo #" + garfo_esquerda + " estao ambos disponiveis. Entao comecou a comer");

                listaGarfos[garfo_direita].setStatus(2);
                listaGarfos[garfo_esquerda].setStatus(2);
                status = 2;

                System.out.println("\nFilosofo #" + garfo_direita + " Esta COMENDO. - Status garfo #" + garfo_direita + ": " + listaGarfos[garfo_direita].getTypeStatus()
                        + " - Status garfo #" + garfo_esquerda + ": " + listaGarfos[garfo_esquerda].getTypeStatus());
            }
            System.out.println("----------");
            return;
        }

        //O filosofo esta filosofando.
        //Tem 50% de chance de bater uma fome e decidir comer.
        //Caso decida comer verifica o status dos garfos, se algum estiver ocupado ele comeca a esperar para liberar os garfos, e comecara a comer na primeira oportunidade.
        //Se ambos os garfos estiverem livres, ele toma posse dos garfos e comeca a comer.
        if (status == 1){
            Random rand = new Random();

            //Gera um numero aleatorio e verifica se e par ou impar.
            //Se for par, decide comer.
            if ((rand.nextInt() % 2) == 0){
                //Caso par decide comer.
                System.out.println("Filosofo #" + garfo_direita + " decidiu comer! - Status garfo #" + garfo_direita + ": " + listaGarfos[garfo_direita].getTypeStatus()
                        + " - Status garfo #" + garfo_esquerda + ": " + listaGarfos[garfo_esquerda].getTypeStatus());

                if(listaGarfos[garfo_direita].getStatus() == 2 || listaGarfos[garfo_esquerda].getStatus() == 2)
                {
                    //Caso um dos garfos estar ocupado, comeca a esperar.
                    System.out.println("Filosofo #" + garfo_direita + " notou que um dos garfos esta ocupado! Por isso decidiu esperar ate ambos ficarem disponiveis.");

                    status = 3;

                    System.out.println("\nFilosofo #" + garfo_direita + " Esta ESPERANDO. - Status garfo #" + garfo_direita + ": " + listaGarfos[garfo_direita].getTypeStatus()
                            + " - Status garfo #" + garfo_esquerda + ": " + listaGarfos[garfo_esquerda].getTypeStatus());
                } else {
                    //Caso ambos garfoes estejam disponiveis, comeca a comer.
                    System.out.println("Filosofo #" + garfo_direita + " tomou os garfos #" + garfo_direita + " e #" + garfo_esquerda + " para comecar a comer.");

                    listaGarfos[garfo_direita].setStatus(2);
                    listaGarfos[garfo_esquerda].setStatus(2);
                    status = 2;

                    System.out.println("\nFilosofo #" + garfo_direita + " esta COMENDO. - Status garfo #" + garfo_direita + ": " + listaGarfos[garfo_direita].getTypeStatus()
                            + " - Status garfo #" + garfo_esquerda + ": " + listaGarfos[garfo_esquerda].getTypeStatus());
                }
            } else {
                //Caso impar, continua filosofando.
                System.out.println("Filosofo #" + garfo_direita + " resolveu continuar pensando.");
                System.out.println("\nFilosofo #" + garfo_direita + " esta FILOSOFANDO. - Status garfo #" + garfo_direita + ": " + listaGarfos[garfo_direita].getTypeStatus()
                        + " - Status garfo #" + garfo_esquerda + ": " + listaGarfos[garfo_esquerda].getTypeStatus());
            }

            System.out.println("----------");
            return;
        }
    }
}
