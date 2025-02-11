import java.util.*;

public class papaiNoel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> pilha = new Stack<>();

        int n = Integer.parseInt(sc.nextLine()); //tirar o /n

        while(n!=0) {
            String operacao = sc.nextLine();

            if(operacao.charAt(0) == 'P' && operacao.charAt(1) == 'U') { //se for PUSH
                //vou separar o PUSH do numero
                String[] separar = operacao.split(" ");
                
                int diversao = Integer.parseInt(separar[1]);
                pilha.push(diversao); //adiciona o numero à pilha
            }
            else if(operacao.equals("MIN")) {
                //temos que mostrar qual o menor item da pilhar
                int menor = 109;
                if(pilha.isEmpty()) {
                    break;
                }
                for(int i=0; i<pilha.size(); i++) {
                    if(pilha.get(i) < menor) {
                        menor = pilha.get(i);
                    }
                }
                System.out.println(menor);
            }
            else if(operacao.equals("POP")) {
                if (!pilha.isEmpty()) {
                    pilha.pop();
                }
            }
            
            n--;
        }
    }
}
