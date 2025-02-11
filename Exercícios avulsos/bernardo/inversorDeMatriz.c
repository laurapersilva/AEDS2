#include <stdio.h>
#include <stdlib.h>

float** criarMatriz(int n) {
    float** matriz = (float**)malloc(n * sizeof(float*));
    for (int i = 0; i < n; i++) {
        matriz[i] = (float*)malloc(n * sizeof(float));
    }
    return matriz;
}

void freeMatriz(float** matriz, int n) {
    for (int i = 0; i < n; i++) {
        free(matriz[i]);
    }
    free(matriz);
}

void inverterMatriz(float** matrix, float** inverse, int n) {
    // Inicializa a matriz inversa como a matriz identidade
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i == j) {
                inverse[i][j] = 1.0;
            } else {
                inverse[i][j] = 0.0;
            }
        }
    }

    // Aplicando a eliminação de Gauss-Jordan
    for (int i = 0; i < n; i++) {
        // Busca o pivô
        float pivo = matrix[i][i];
        if (pivo == 0) {
            printf("A matriz não é inversível, burro\n");

        }

        // Normaliza a linha do pivô
        for (int j = 0; j < n; j++) {
            matrix[i][j] /= pivo;
            inverse[i][j] /= pivo;
        }

        // Elimina as outras linhas
        for (int k = 0; k < n; k++) {
            if (k != i) {
                float factor = matrix[k][i];
                for (int j = 0; j < n; j++) {
                    matrix[k][j] -= factor * matrix[i][j];
                    inverse[k][j] -= factor * inverse[i][j];
                }
            }
        }
    }
}


int main () {
    int linhas=0, colunas=0;
    printf("Oi buceta, insira aqui a caralha do numero de linhas:\n");
    scanf("%d", &linhas);
    printf("Agora insira o numero de colunas porra:\n");
    scanf("%d", &colunas);

    printf("Eu sei que eu poderia ter pedido só um deles, pq ela é quadrática, mas percebi isso depois e agora to com preguica de mudar tudo ;)\n");

    if(linhas!=colunas) {
        printf("Ai nao né porra");
        return 0;
    }

    float** matriz = criarMatriz(linhas);

    printf("Agora coloca os numeros da matriz aí (da um enter quando for mudar de linha)\n");

    for (int i = 0; i < linhas; i++) {
        for (int j = 0; j < colunas; j++) {
            scanf("%f", &matriz[i][j]);
        }
    }

    //invertendo a matriz
    float** matrizInversa = criarMatriz(linhas);
    inverterMatriz(matriz, matrizInversa, linhas);

    //printando a nova matriz
    printf("Toma bernardo:\n");

    for(int i=0; i<linhas; i++) {
        for(int j=0; j<colunas; j++) {
            printf("%d", matrizInversa[i,j]);
        }
        printf("\n");
    }

    freeMatriz(matriz, linhas);
    freeMatriz(matrizInversa, linhas);
    return 0;
}