import java.util.*;

public class insertion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] vet = sc.nextInt(n); //nao declarei o n pq ele só ta ai de exemplo

        for(int i=1; i<n; i++) {
            int temp = vet[i];
            int j = i-1;

            while(j>=0 && vet[j]>temp) {
                vet[j+1] = vet[j];
                j--;
            }
            vet[j+1] = temp;
        }
    }
}
