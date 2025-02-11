#include <stdio.h>
#include <stdlib.h>

int main() {
    float num;
    int n;

    scanf("%d", &n);

    FILE *arquivo = fopen("arquivo.txt", "w");
    if (arquivo == NULL) {
        perror("Erro ao abrir o arquivo");
        return 1;
    }

    for(int i = 0; i < n; i++) {
        scanf("%f", &num);
        if(num / 1.0 == (int)(num / 1.0)) {
            fprintf(arquivo, "%.0f\n", num);  
        } else {
            fprintf(arquivo, "%.3f\n", num);  
        }
    }

    fclose(arquivo);

    arquivo = fopen("arquivo.txt", "r");
    if (arquivo == NULL) {
        perror("Erro ao abrir o arquivo");
        return 1;
    }

    fseek(arquivo, 0, SEEK_END);
    long position = ftell(arquivo);
    char ch;
    int start_of_line = 1;

    while (position > 0) {
        fseek(arquivo, --position, SEEK_SET);
        ch = fgetc(arquivo);

        if (ch == '\n' || position == 0) {
            if (!start_of_line) {
                if (position != 0) {
                    fseek(arquivo, position + 1, SEEK_SET);
                } else {
                    fseek(arquivo, 0, SEEK_SET);  
                }

                while ((ch = fgetc(arquivo)) != '\n' && ch != EOF) {
                    putchar(ch);
                }
                putchar('\n');
            }
            start_of_line = 0;
        }
    }

    fclose(arquivo);
    return 0;
}