#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

bool stop(char* s){ 
    if(strlen(s)==3 && s[0]=='F' && s[1]=='I' && s[2]=='M') return true;
    else return false;
}


int main () {
    bool eh_palindromo = true, end = true;
    char *palindromo;
    
    while (end) {
        eh_palindromo = true;
        palindromo = malloc (100 * sizeof(char));
        scanf(" %100[^\n]", palindromo);
        int comp = strlen(palindromo);
        int i = 0, 
            j = comp-1;

        //checando se é palindromo mesmo
        while (eh_palindromo && i < j) {
            if(palindromo[i] != palindromo[j]) {
                eh_palindromo = false;
            }
            i++;
            j--;
        }

        if(stop(palindromo)) {
            end = false;
        }

        else if(eh_palindromo) {
            printf("SIM\n");
        }
        else {
            printf("NAO\n");
        }
        free(palindromo);
    }

    return 0;
}