#include <stdio.h>
#include <stdlib.h>

int main() {
    int n = 0;
    scanf("%d", &n);

    while(n!=0) {
        int tam = 0, trocas;
        scanf("%d", &tam);

        //alocando espaco para o array de vagoes
        int *vagoes = (int*)malloc(tam * sizeof(int));
        for(int i=0; i<tam; i++) {
            scanf("%d", &vagoes[i]);
        }

        for(int i=0; i<tam; i++) {
            for(int j=i+1; j<tam; j++) {
                if(vagoes[i] > vagoes[j]) {
                    trocas++; //n há necessidade de fazer o swap pq n é o que o exercicio pede, apenas saber que há uma troca sendo feita
                }
            }
        }

        printf("Optimal train swapping takes %d swaps.\n", trocas);
        n--;
    }
    return 0;
}