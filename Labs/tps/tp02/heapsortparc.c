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
void heapsortPokemons(Pokemon pokemons[], int n);
void heapify(Pokemon pokemons[], int n, int i);
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

int compararPokemons(const Pokemon *p1, const Pokemon *p2) {
    if (p1->height != p2->height) {
        return p1->height < p2->height; // menor altura primeiro
    }
    return strcmp(p1->name, p2->name) < 0; // em caso de empate, ordena pelo nome
}

void heapify(Pokemon pokemons[], int n, int i) {
    int largest = i; // Inicializa o maior como raiz
    int left = 2 * i + 1; // filho esquerdo
    int right = 2 * i + 2; // filho direito

    if (left < n && compararPokemons(&pokemons[left], &pokemons[largest])) {
        largest = left;
    }
    comparacoes++; // Incrementa comparação

    if (right < n && compararPokemons(&pokemons[right], &pokemons[largest])) {
        largest = right;
    }
    comparacoes++; // Incrementa comparação

    if (largest != i) {
        Pokemon temp = pokemons[i];
        pokemons[i] = pokemons[largest];
        pokemons[largest] = temp;
        movimentacoes += 3; // Troca de posição

        // Recursivamente heapify o subárvore afetado
        heapify(pokemons, n, largest);
    }
}

void heapsortPokemons(Pokemon pokemons[], int n) {
    // Construir o heap
    for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(pokemons, n, i);
    }

    // Um a um extrai os elementos do heap
    for (int i = n - 1; i > 0; i--) {
        Pokemon temp = pokemons[0];
        pokemons[0] = pokemons[i];
        pokemons[i] = temp;
        movimentacoes += 3; // Troca de posição
        heapify(pokemons, i, 0);
    }
}

void logPerformance(int numComparacoes, int numMovimentacoes, double execTime) {
    FILE *logFile = fopen("matrícula_heapsort.txt", "w");
    if (logFile != NULL) {
        fprintf(logFile, "854946\t%d\t%d\t%.2f\n", numComparacoes, numMovimentacoes, execTime); // Substitua "854946" pela sua matrícula
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
    Pokemon encontrados[100]; // Array para armazenar todos os Pokémon encontrados
    int encontradosCount = 0;

    // Leitura de IDs até "FIM"
    while (true) { // Continuar até "FIM"
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

    // Ordena os Pokémon encontrados
    heapsortPokemons(encontrados, encontradosCount);

    // Imprime apenas os 10 primeiros Pokémon encontrados
    for (int i = 0; i < (encontradosCount < 10 ? encontradosCount : 10); i++) {
        printPokemon(&encontrados[i]); // Imprime cada Pokémon
    }

    clock_t end = clock();
    double executionTime = (double)(end - start) / CLOCKS_PER_SEC * 1000; // Tempo em milissegundos

    // Log da performance
    logPerformance(comparacoes, movimentacoes, executionTime);

    return 0;
}
