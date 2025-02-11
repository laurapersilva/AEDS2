import java.util.Scanner;

public class pali {
    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);
        boolean eh_palindromo = true, end = true;

        while (end) {
            eh_palindromo = true;
            String palindromo = scanf.nextLine();
            int comp = palindromo.length();
            
            int i = 0, j = comp-1;

            //checando se é palindromo
            while (eh_palindromo == true && i < j) {
                if(palindromo.charAt(i) != palindromo.charAt(j)) {
                    eh_palindromo = false;
                }        
                i++;
                j--;
            }
            
            if (eh_palindromo) {
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
