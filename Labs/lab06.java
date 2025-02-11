import java.util.*;

//quicksort
public class lab06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.out);

        int n = sc.nextInt();
        int[] vetor = new int[n];
        
        for(int i=0; i<n; i++) {
            vetor[i] = sc.nextInt();
        }

        

    }

    void swap(int[] vetor, int i, int j) {
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }

    public void pivoNoInicio(int[] vetor, int esq, int dir) {
        int i=esq, j=dir, pivo = vetor[esq];

        while(i<=j) {
            while(vetor[i] < pivo) {
                i++;
            }
            while(vetor[j] > pivo) {
                j--;
            }
            if(i<=j) {
                swap(vetor,i,j);
                i++;
                j--;
            } 

        }
        if(esq<j) {
            pivoNoInicio(vetor,esq,j);
        }
        if(i<dir) {
            pivoNoInicio(vetor,i, dir);
        }
    
    }

    public void pivoNoFinal(int[] vetor, int esq, int dir) {
        int i=esq, j=dir, pivo = vetor[dir];

        while(i<=j) {
            while(vetor[i] < pivo) {
                i++;
            }
            while(vetor[j] > pivo) {
                j--;
            }
            if(i<=j) {
                swap(vetor,i,j);
                i++;
                j--;
            } 

        }
        if(esq<j) {
            pivoNoFinal(vetor,esq,j);
        }
        if(i<dir) {
            pivoNoFinal(vetor,i, dir);
        }
    }

    public void pivoEhoMeio(int[] vetor, int esq, int dir) {
        int i=esq, j=dir, pivo = vetor[(esq + dir)/2];

        while(i<=j) {
            while(vetor[i] < pivo) {
                i++;
            }
            while(vetor[j] > pivo) {
                j--;
            }
            if(i<=j) {
                swap(vetor,i,j);
                i++;
                j--;
            } 

        }
        if(esq<j) {
            pivoEhoMeio(vetor,esq,j);
        }
        if(i<dir) {
            pivoEhoMeio(vetor,i, dir);
        }
    }

    public void pivoEhaMedia(int[] vetor, int esq, int dir) {
        int mediana = (esq + dir + ((esq + dir)/2)) / 3;
        int i=esq, j=dir, pivo = vetor[mediana];

        while(i<=j) {
            while(vetor[i] < pivo) {
                i++;
            }
            while(vetor[j] > pivo) {
                j--;
            }
            if(i<=j) {
                swap(vetor,i,j);
                i++;
                j--;
            } 

        }
        if(esq<j) {
            pivoEhoMeio(vetor,esq,j);
        }
        if(i<dir) {
            pivoEhoMeio(vetor,i, dir);
        }
    }
    
}
