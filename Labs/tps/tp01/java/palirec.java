import java.util.Scanner;

public class palirec {

    public static boolean eh_palindromo(String palindromo, int i, int j) {
        if(palindromo.charAt(i) != palindromo.charAt(j)) {
            return false;
        }
        else if (i<j){
            return true;
        }
        else {
            return eh_palindromo(palindromo, i+1, j-1);
        }   
    }
    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);
        boolean end = true;

        while (end) {
            String palindromo = scanf.nextLine();
            int comp = palindromo.length();
            
            int i = 0, j = comp-1;

            //checando se é palindromo
            boolean eh_palindromo = eh_palindromo(palindromo, 0, comp-1);
            
            if (eh_palindromo == true) {
                System.out.println("SIM");
            }
            else {
                System.out.println("NAO");
            }

            if(palindromo.charAt(0)=='F' && palindromo.charAt(1)=='I' && palindromo.charAt(2)=='M') {
                end = false; //quando chegar em fim para o loop
            }
        }

        scanf.close();
    }
}

