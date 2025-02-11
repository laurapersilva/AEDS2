//combinador
import java.util.*;

public class lab02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String string1 = sc.next();
        String string2 = sc.next();

        int comp1 = string1.length();
        int comp2 = string2.length();

        for(int i=0; i<(comp1 + comp2); i++) {
            System.out.print(string1.charAt(i));
            System.out.print(string2.charAt(i));
        }

        sc.close();
    }
}
