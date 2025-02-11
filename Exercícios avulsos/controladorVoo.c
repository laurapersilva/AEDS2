#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

typedef struct Celula{
    char elemento[10];
    Celula* prox;
} Celula;

typedef struct Fila {
    Celula* primeiro;
    Celula* ultimo;

} Fila;

Fila* criarFila() {
    Fila* fila = (Fila*)malloc(sizeof(Fila));
    fila->primeiro = NULL;
    fila->ultimo = NULL;
    return fila;
}

void inserir(Fila* fila, char x[10]) {
    Celula* tmp = (Celula*)malloc(sizeof(Celula));
    strcpy(tmp->elemento, x);
    tmp->prox = NULL;

    if(fila->ultimo) { //se a fila n estiver vazia
        fila->ultimo->prox = tmp;
    }
    fila->ultimo = tmp;

    if(fila->primeiro) {
        fila->primeiro = fila->ultimo;
    }
}

bool isEmpty(Fila* fila) {
    if(fila->primeiro == fila->ultimo) {
        return true;
    }
    return false;
}

char remover(Fila* fila) {
    Celula* tmp = (Celula*)malloc(sizeof(Celula));
    char removido[10];
    strcpy(removido, fila->primeiro->elemento);

    tmp->prox = fila->primeiro->prox;
    fila->primeiro->prox = NULL;
    fila->primeiro = tmp;
    tmp=NULL;

    return removido;
}


int main() {
    char n[10];
    scanf("%c", &n);

    Fila* oeste = criarFila();
    Fila* sul = criarFila();
    Fila* norte = criarFila();
    Fila* leste = criarFila();

    char direcao[10];

    while(n!=0) {
        fgets(n, sizeof(n), stdin);

        if(n[0] != 'A'){
            strcpy(direcao, n);            
        }
        //oeste
        if(direcao == -1) {
            inserir(oeste, n);
        }
        //sul
        if(direcao == -2) {
            inserir(sul, n);
        }
        //norte
        if(direcao == -3) {
            inserir(norte, n);
        }
        //leste
        if(direcao == -4) {
            inserir(leste, n);
        }
    }

    //impressao
    while(!isEmpty(oeste) || !isEmpty(sul) || !isEmpty(norte) || !isEmpty(leste)) {
        if(!isEmpty(oeste)) {
            printf("%s", remover(oeste->primeiro));
        }
        if(!isEmpty(sul)) {
            printf("%s", remover(sul->primeiro));
        }
        if(!isEmpty(norte)) {
            printf("%s", remover(norte->primeiro));
        }
        if(!isEmpty(leste)) {
            printf("%s", remover(leste->primeiro));
    }

    return 0;
}