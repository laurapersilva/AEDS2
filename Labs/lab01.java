//sequencia espelho
import java.util.*;

public class lab01 {
    public static int descobrirtam(int m, int tam) {
        if (m == 0) {
            return tam;
        }
        else {
           return descobrirtam(m/10, tam+1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inicio = sc.nextInt();
        int final = sc.nextInt();

        for(int i=inicio; i<final; i++) {
            System.out.print(inicio);
            inicio ++;
        }

        for(int i=final; i>inicio; i--) {
            int tam = descobrirtam(final, 0);

            for(int j=0; j<tam; j++) {
                int temp = final % 10;
                System.out.print(temp);
                final/=10;
            }
            
            final--;
        }
    }
}
