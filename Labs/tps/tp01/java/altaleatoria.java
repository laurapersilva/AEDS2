import java.util.*;

public class altaleatoria {
    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);
        boolean end = true;

        while (end) {

            String palavra = scanf.nextLine();
            int comp = palavra.length();
            int acc=0;
            
            Random gerador = new Random();
            gerador.setSeed(4);
            char letra1 = (char)('a' + Math.abs(gerador.nextInt()) % 26);
            char letra2 = (char)('a' + Math.abs(gerador.nextInt()) % 26);
            
            for (int i=0; i<comp; i++) {
                
                if (palavra.charAt(i) == letra1) {
                    acc++;
                }
            }
            if (acc!=0){ //só trocará as letras se houver as letras em primeiro lugar
                palavra.replace(letra1, letra2);
            }

            System.out.println(palavra);


            if(palavra.charAt(0)=='F' && palavra.charAt(1)=='I' && palavra.charAt(2)=='M') {
                end = false; //quando chegar em fim para o loop
            }
        }

        scanf.close();
    }
}