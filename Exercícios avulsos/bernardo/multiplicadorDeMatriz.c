#include <stdio.h>
#include <stdlib.h>

float** criarMatriz(int n, int m) {
    float** matriz = (float**)malloc(n * sizeof(float*));
    for (int i = 0; i < m; i++) {
        matriz[i] = (float*)malloc(m * sizeof(float));
    }
    return matriz;
}

void freeMatriz(float** matriz, int co) {
    for (int i = 0; i < co; i++) {
        free(matriz[i]);
    }
    free(matriz);
}

int main () {
    int linhas=0, colunas=0;
    printf("Oi buceta, insira aqui a caralha do numero de linhas (DA PRIMEIRA MATRIZ):\n");
    scanf("%d", &linhas);
    printf("Agora insira o numero de colunas porra (DA PRIMEIRA MATRIZ):\n");
    scanf("%d", &colunas);

    float** matriz = criarMatriz(linhas, colunas);

    printf("Agora coloca os numeros da matriz aí (da um enter quando for mudar de linha)\n");

    for (int i = 0; i < linhas; i++) {
        for (int j = 0; j < colunas; j++) {
            scanf("%f", &matriz[i][j]);
        }
    }

    int linhas2=0, colunas2=0;
    printf("Insira aqui a caralha do numero de linhas (DA SEGUNDA MATRIZ):\n");
    scanf("%d", &linhas2);
    printf("Agora insira o numero de colunas porra (DA SEGUNDA MATRIZ):\n");
    scanf("%d", &colunas2);

    float** matriz2 = criarMatriz(linhas2, colunas2);

    printf("Agora coloca os numeros da matriz aí (da um enter quando for mudar de linha)\n");

    for (int i = 0; i < linhas; i++) {
        for (int j = 0; j < colunas; j++) {
            scanf("%f", &matriz2[i][j]);
        }
    }

    float** resultado = criarMatriz(linhas, colunas2);

    for (int i = 0; i < linhas; i++) {
        for (int j = 0; j < colunas2; j++) {
            resultado[i][j] = 0;  // Inicializa a posição do resultado
            for (int k = 0; k < colunas; k++) {
                resultado[i][j] += matriz[i][k] * matriz2[k][j];
            }
        }
    }

    //printando a nova matriz
    printf("Toma bernardo:\n");

    for(int i=0; i<linhas; i++) {
        for(int j=0; j<colunas; j++) {
            printf("%d", resultado[i,j]);
        }
        printf("\n");
    }

    freeMatriz(matriz, colunas);
    freeMatriz(matriz2, colunas2);

    return 0;
}