import java.util.*;

public class trilhos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> pilhaInicial = new Stack();
        Stack<Character> pilhaFinal = new Stack();
        
        while(true) {
            int n = sc.nextInt();
            if(n == 0) break;
            sc.nextLine(); 

            String[] stringInicial = sc.nextLine().split(" ");
            //colocando todos os elementos na pilha inicial
            for(int i=0; i<n; i++) {
                pilhaInicial.push(stringInicial[i].charAt(0));
            }

            String stringFinal = sc.nextLine();
            
            for(int i=0; i<n; i++) {
                //enquanto a pilha inicial nao está vazia
                if(!pilhaInicial.isEmpty()) {
                    for(int j=0; j<n; j++) {
                        //é necessario pesquisar na string inicial a letra necessaria da string final
                        if(stringInicial[j].charAt(0) != stringFinal.charAt(i)) {
                            pilhaFinal.push(pilhaInicial.elementAt(j));
                            pilhaInicial.pop();
                            System.out.print("I");
                        }
                        else {
                            pilhaFinal.push(pilhaInicial.elementAt(j));
                            pilhaInicial.pop();
                            System.out.print("I");
                            pilhaFinal.pop();
                            System.out.print("R");
                            break; //passar para a proxima iteracao de i
                        }
                    }
                }
                //agora todos os elementos estao na estacao e podem ser retirados para o outro trem
                else if(!pilhaFinal.isEmpty()) {
                    //enquatno a pilha final n está vazia
                    if(pilhaFinal.lastElement() == stringFinal.charAt(i)) {
                        pilhaFinal.pop();
                        System.out.print("R");    
                        break;                    
                    }
                }
            }
        }
    }
}
