import java.util.*;

class Motorista {
    public int entrada;
    public int saida;

    public Motorista() {
        entrada = 0;
        saida = 0;
    }

    public Motorista(int entrada, int saida) {
        this.entrada = entrada;
        this.saida = saida;
    }
}

public class estacionamento {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Motorista> fila = new ArrayList<>();

        int n = 0, k = 0;
        while(true) {
            n = sc.nextInt();
            k = sc.nextInt();
            if(n==0 && k==0) break;

            int e, s;
            for(int i=0; i<n; i++) {
                e = sc.nextInt();
                s = sc.nextInt();

                Motorista motorista = new Motorista(e, s);
                fila.add(motorista);

                if(i!=0) {
                    if(fila.size() <= k) {
                        fila.removeFirst();
                    }
                    else {
                        //a saida do anterior for menor que a entrada do atual significa que ele pode sair
                        if(fila.elementAt(i-1).get(motorista.saida)) {
                            
                        }
                    }
                }
            }
        }
    }
}
