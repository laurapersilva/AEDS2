import java.util.*;

//custo é theta de N^2 - no melhor caso é apenas N

public class bubblesort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] vet = sc.nextInt(n); //nao declarei o n pq ele só ta ai de exemplo

        //bubble sort
        boolean houveTroca = true;
        for(int rep = 0; rep < n-1 && houveTroca = true; rep++) {
            houveTroca = false;
            for(int i = 0; i < n-(rep+1); i++) {
                if(vet[i] > vet[i+1]) {
                    //swap
                    int temp = vet[i];
                    vet[i] = vet[i+1];
                    vet[i+1] = temp;
                    houveTroca = true;
                }
            }
        }
    }
}
