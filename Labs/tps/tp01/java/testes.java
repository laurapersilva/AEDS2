import java.util.Scanner;

public class testes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double media = 0;
        double[] num = new double[3];
        
        for (int i = 0; i < 3; i++) {
            num[i] = sc.nextDouble();
            media += num[i]; 
        }
        
        media /= 3; 
        System.out.println("MEDIA = " + media);
        sc.close();
    }
}
