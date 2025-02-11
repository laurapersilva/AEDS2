#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool eh_palindromo(int i, int j, char palindromo[]) {
    if (i >= j) {
        return true;
    } else {
        if (palindromo[i] != palindromo[j]) {
            return false;
        }
        return eh_palindromo(i + 1, j - 1, palindromo);
    }
}

int main()
{
    char palindromo[100];
    while (true)
    {
        fgets(palindromo, sizeof(palindromo), stdin);
        palindromo[strlen(palindromo) - 1] = 0;

        if (!(strcmp(palindromo, "FIM")))
        {
            return 0;
        }

        int tam = strlen(palindromo);
        bool teste = eh_palindromo(0,tam-1,palindromo);
        if (teste == true )
        {
            printf("SIM\n");
        }
        else
        {
            printf("NAO\n");
        }
    }
    return 0;
}