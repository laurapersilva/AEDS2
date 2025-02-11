#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int trocarLetras(char frase[100], int i, int tam, int letra1, int letra2){
    if(i>=tam) printf("%s\n", frase);
    else {
        if (frase[i] == letra1) {
            frase[i] == letra2;
        }
        return trocarLetras(frase, i+1, tam, letra1, letra2);
    }
}

int main (){
    char frase[100];

    while(1) {
        fgets(frase, sizeof(frase), stdin);
        frase[strlen(frase) - 1] = 0;

        if(strcmp(frase,"FIM") == 0){
            break;
        }

        char letra1 = 'a' + (rand() % 26);
        char letra2 = 'a' + (rand() % 26);

        int tam = strlen(frase);
    
        trocarLetras(frase,0,tam,letra1,letra2);
    }
    
    return 0;
}