import java.util.Scanner;

public class lab04 {
    public static void swap(int i, int j, int[] vet) {
        int temp = vet[i];
        vet[i] = vet[j];
        vet[j] = temp;
    }

    public static void ordenar(int[] vetorzin, int n) {
        for (int i = 0; i < (n - 1); i++) {
            int menor = i; 
            for (int j = (i + 1); j < n; j++){
                if (vetorzin[menor] > vetorzin[j]){
                    menor = j;
                }
            }
            swap(menor, i, vetorzin);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {

            int n = sc.nextInt();
            int m = sc.nextInt();

            if (n == 0 && m == 0) break;
            
            int[] vetor = new int[n];
            for (int i = 0; i < n; i++) {
                vetor[i] = sc.nextInt();
            }
            
            int[] newvet = new int[n];

            //colocando os modulos em um novo vetor
            for(int i=0; i<n; i++) {
                newvet[i] = ((vetor[i] % m) + m) % m; //garantindo que nao seja negativo
            }

            //colocando os modulos em ordem
            ordenar(newvet, n);

            //colocando os numeros em ordem
            ordenar(vetor, n);

            //aplicando os ifs
            for (int i = 0; i < n-1; i++) {
                //se forem iguais e os dois forem impar
                if ((newvet[i] == newvet[i+1]) && (vetor[i]%2 == 1) && (vetor[i+1]%2 == 1)) {
                    if (vetor[i] < vetor[i+1]) {
                        swap(i, i+1, vetor);
                    }
                }
                //se forem iguais e os dois forem par
                if ((newvet[i] == newvet[i+1]) && (vetor[i]%2 == 0) && (vetor[i+1]%2 == 0)) {
                    if (vetor[i] > vetor[i+1]) {
                        swap(i, i+1, vetor);
                    }
                }
                //se forem iguais e um for impar e outro par
                if ((newvet[i] == newvet[i+1]) && (vetor[i]%2 == 0) && (vetor[i+1]%2 == 1)) {
                    swap(i, i+1, vetor); 
                }
            }

            System.out.println(n + " " + m);
            for(int i=0; i<n; i++) {
                System.out.println(vetor[i]);
            }
        }
        System.out.println(0 + " " + 0);
    }
}