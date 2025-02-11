#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>
#include <time.h>

// Atributos de um Pokemon
typedef struct {
    int id;
    int generation;
    char name[80];
    char description[80];
    char type1[80];
    char type2[80];
    char abilities[200];
    double weight;
    double height;
    int captureRate;
    bool isLegendary;
    char captureDate[12];
} Pokemon;

// Variáveis globais para contagens
int comparacoes = 0;
int movimentacoes = 0;

// Declaração das funções
void printPokemon(const Pokemon *pokemon);
char *strsep(char **stringp, const char *delim);
void formatarString(char *str);
void adicionarPokemon(char *linha, Pokemon *pokemon);
void lerArquivo(const char *nomeArquivo, Pokemon pokemons[], int *totalPokemons);
int buscarPokemonIDRecursivo(int id, Pokemon pokemons[], int totalPokemons, int index);
void shellsort(Pokemon pokemons[], int totalPokemons);
void logPerformance(int numComparacoes, int numMovimentacoes, double execTime);

void printPokemon(const Pokemon *pokemon) {
    printf("[#%d -> %s: %s - ['%s'", 
           pokemon->id, 
           pokemon->name, 
           pokemon->description, 
           pokemon->type1);
    
    if (strcmp(pokemon->type2, "") != 0) {
        printf(", '%s']", pokemon->type2);
    } else {
        printf("]");
    }

    printf(" - %s - %.1fkg - %.1fm - %d%% - %s - %d gen] - %s", 
           pokemon->abilities, 
           pokemon->weight, 
           pokemon->height, 
           pokemon->captureRate, 
           pokemon->isLegendary ? "true" : "false", 
           pokemon->generation, 
           pokemon->captureDate);
}

char *strsep(char **stringp, const char *delim) {
    char *start = *stringp;
    char *p;

    if (start == NULL) {
        return NULL;
    }

    p = strpbrk(start, delim);
    if (p) {
        *p = '\0';
        *stringp = p + 1;
    } else {
        *stringp = NULL;
    }

    return start;
}

void formatarString(char *str) {
    int dentroColchetes = 0;  
    int j = 0;  

    for (int i = 0; str[i] != '\0'; i++) {
        if (str[i] == '[') {
            dentroColchetes = 1;  
        } else if (str[i] == ']') {
            dentroColchetes = 0; 
        }

        if (str[i] == ',' && dentroColchetes == 0) {
            str[j++] = ';';
        } else if (str[i] != '"') {
            str[j++] = str[i];
        }
    }

    str[j] = '\0'; 
}

void adicionarPokemon(char *linha, Pokemon *pokemon) {
    char *token;
    token = strsep(&linha, ";");
    pokemon->id = atoi(token);

    token = strsep(&linha, ";");
    pokemon->generation = atoi(token);

    token = strsep(&linha, ";");
    strcpy(pokemon->name, token);

    token = strsep(&linha, ";");
    strcpy(pokemon->description, token);

    token = strsep(&linha, ";");
    strcpy(pokemon->type1, token);

    token = strsep(&linha, ";");
    if (token[0] != 0) strcpy(pokemon->type2, token);

    token = strsep(&linha, ";");
    strcpy(pokemon->abilities, token);

    token = strsep(&linha, ";");
    pokemon->weight = atof(token);  

    token = strsep(&linha, ";");
    pokemon->height = atof(token);

    token = strsep(&linha, ";");
    pokemon->captureRate = atoi(token);

    token = strsep(&linha, ";");
    pokemon->isLegendary = atoi(token);  

    token = strsep(&linha, ";");
    strcpy(pokemon->captureDate, token);
}

void lerArquivo(const char *nomeArquivo, Pokemon pokemons[], int *totalPokemons) {
    FILE *arquivo = fopen(nomeArquivo, "r");
    if (arquivo == NULL) {
        printf("Erro ao abrir o arquivo %s\n", nomeArquivo);
        return;
    }

    char linha[512];
    *totalPokemons = 0;

    while (fgets(linha, sizeof(linha), arquivo)) {
        formatarString(linha);  
        adicionarPokemon(linha, &pokemons[*totalPokemons]);
        (*totalPokemons)++;
    }

    fclose(arquivo);
}

int buscarPokemonIDRecursivo(int id, Pokemon pokemons[], int totalPokemons, int index) {
    if (index >= totalPokemons) {
        return -1; // Não encontrado
    }
    comparacoes++; // Incrementa comparação
    if (pokemons[index].id == id) {
        return index; // Encontrado
    }
    return buscarPokemonIDRecursivo(id, pokemons, totalPokemons, index + 1); // Chamada recursiva
}

void shellsort(Pokemon pokemons[], int totalPokemons) {
    int gap, i, j;
    Pokemon temp;

    for (gap = totalPokemons / 2; gap > 0; gap /= 2) {
        for (i = gap; i < totalPokemons; i++) {
            temp = pokemons[i];
            j = i;

            while (j >= gap && (temp.weight < pokemons[j - gap].weight || 
                                (temp.weight == pokemons[j - gap].weight && strcmp(temp.name, pokemons[j - gap].name) < 0))) {
                comparacoes++; // Incrementa comparação
                pokemons[j] = pokemons[j - gap];
                j -= gap;
                movimentacoes++; // Incrementa movimentação
            }
            pokemons[j] = temp;
            movimentacoes++; // Incrementa movimentação
        }
    }
}

void logPerformance(int numComparacoes, int numMovimentacoes, double execTime) {
    FILE *logFile = fopen("matrícula_shellsort.txt", "w");
    if (logFile != NULL) {
        fprintf(logFile, "855476\t%d\t%d\t%.2f\n", numComparacoes, numMovimentacoes, execTime); 
        fclose(logFile);
    } else {
        printf("Erro ao criar o arquivo de log.\n");
    }
}

int main(void) {
    Pokemon pokemons[1000];
    int totalPokemons;

    lerArquivo("/tmp/pokemon.csv", pokemons, &totalPokemons);

    char input[10];
    Pokemon encontrados[1000]; // Array para armazenar os Pokémon encontrados
    int encontradosCount = 0;

    // Leitura de IDs até "FIM"
    while (true) {
        scanf(" %s", input);
        if (strcmp(input, "FIM") == 0) {
            break;
        }

        int id = atoi(input);
        int index = buscarPokemonIDRecursivo(id, pokemons, totalPokemons, 0);
        if (index != -1) {
            encontrados[encontradosCount++] = pokemons[index]; // Armazena o Pokémon encontrado
        }
    }

    // Tempo de execução da ordenação
    clock_t start = clock();

    // Ordena todos os Pokémon encontrados pelo weight e nome
    shellsort(encontrados, encontradosCount);

    // Imprime todos os Pokémon encontrados
    for (int i = 0; i < encontradosCount; i++) {
        printPokemon(&encontrados[i]); // Imprime cada Pokémon
    }

    clock_t end = clock();
    double executionTime = (double)(end - start) / CLOCKS_PER_SEC * 1000; // Tempo em milissegundos

    // Log da performance
    logPerformance(comparacoes, movimentacoes, executionTime);

    return 0;
}
