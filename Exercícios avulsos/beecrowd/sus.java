import java.util.*;

public class sus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int acc = 1;
        int critico = 0;

        while(true) {
            int n = sc.nextInt();
            sc.nextLine();

            String[] hmc = sc.nextLine().split(" ");
             
            //transformando tudo em minutos
            int horas = Integer.parseInt(hmc[0]);
            int minutos = Integer.parseInt(hmc[1]);
            int entrada = (horas*60) + minutos;

            for(int i=0; i<n-1; i++) {
                String[] hmc1 = sc.nextLine().split(" ");
                //transformando tudo em minutos
                int horas1 = Integer.parseInt(hmc1[0]);
                int minutos1 = Integer.parseInt(hmc1[1]);
                int entrada1 = (horas1*60) + minutos1;
                int tempoRestante1 = Integer.parseInt(hmc1[2]);

                int tempoEspera = tempoRestante1 + entrada1;

                int tempoAtual = entrada + 30*acc; //tempo que temos
                
                if(tempoAtual > tempoEspera) {
                    critico++;
                }

                acc++;
            }
            System.out.println(critico);
            break;
        }
        
    }    
}
