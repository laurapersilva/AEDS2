import java.util.*;

public class organizadorVag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        while(n!=0) {
            int L = sc.nextInt();
            sc.nextLine();
            String vagoes = sc.nextLine();
            String[] posicao = vagoes.split(" ");
            int trocas = 0;

            for(int i=0; i<L-1; i++) {
                //int x = Integer.parseInt(posicao[i]); //trocando para inteiros para conseguir fazer a comparacao
                for(int j=0; j<L-1-i; j++) {
                    //int y = Integer.parseInt(posicao[j]);

                    if(Integer.valueOf(posicao[j]) > Integer.valueOf(posicao[j+1])) {
                        //swap
                        String tmp = posicao[j];
                        posicao[j] = posicao[j+1];
                        posicao[j+1] = tmp;

                        trocas++;
                    }
                }
            }

            System.out.println("Optimal train swapping takes " + trocas + " swaps.");
            n--;
        }
    }
}
