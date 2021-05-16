//Trabalho problema dos filosofos - Sistemas Operacionais
//Gabriel Braz e Santos - 260569

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int posicao_loop = 0;
        int qtd_filosofos = 0;
        Scanner scan = new Scanner(System.in);

        //Precisamos decidir quantos filosofos ter.
        do
        {
            System.out.println("Insira a quantidade de filosofos para usar neste problema: (Ex. 6)");
            System.out.println("-> Pelo menos 2! <-");
            qtd_filosofos = scan.nextInt();
        } while(qtd_filosofos < 2);

        Filosofo[] filosofo_array = new Filosofo[qtd_filosofos];
        Garfo[] garfo_array = new Garfo[qtd_filosofos];

        //Atribuindo os garfos que cada filosofo tem alcance.
        for (int i = 0; i < qtd_filosofos; i++){
            if (i == 0) {
                filosofo_array[i] = new Filosofo(i, qtd_filosofos-1);
            } else {
                filosofo_array[i] = new Filosofo(i, i-1);
            }

            garfo_array[i] = new Garfo(i);
        }


        //Executa o problema do filosofo infinitamente,
        //Mate o programa para terminar.
        do{
            filosofo_array[posicao_loop].decisionLogic(garfo_array);

            posicao_loop++;

            //Se chegou no ultimo filosofo, volta ao primeiro para decidir o que fazer,
            //Filosofos sao um bando educado, esperam na vez para tomar decisoes.
            if (posicao_loop == qtd_filosofos){
                posicao_loop = 0;
            }

            try
            {
                Thread.sleep(5000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        } while (true);
    }
}
