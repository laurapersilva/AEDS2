#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>

#define MAX_TYPES 2
#define MAX_ABILITIES 10
#define MAX_POKEMONS 802

typedef struct {
    int id;
    int generation;
    char name[50];
    char description[200];
    char types[MAX_TYPES][20];
    char abilities[MAX_ABILITIES][20];
    double weight;
    double height;
    int captureRate;
    bool isLegendary;
    struct tm captureDate;
} Pokemon;

// Função que atua como construtor
Pokemon *criarPokemon(int id, int generation, char *nome, char *description, char *types, char *abilities, char *peso, char *altura, int captureRate, bool isLegendary, char *captureDate) {
    Pokemon *pokemon = NULL;
    pokemon = (Pokemon*)malloc(sizeof(Pokemon));
    
    pokemon->id = id; 
    pokemon->generation = generation;
    pokemon->name = nome; 
    pokemon->description = description;
    pokemon->types = types; 
    pokemon->abilities = abilities; 
    pokemon->weight = peso; 
    pokemon->height = altura;
    pokemon->captureRate = captureRate; 
    pokemon->isLegendary = isLegendary;
    pokemon->captureDate = captureDate;



    return pokemon;
}

// Função para liberar a memória
void liberarPokemon(Pokemon* pokemon) {
    free(pokemon);
}

// Função para ler o arquivo CSV e retornar um array de Pokémon
int readCsv(const char *filename, Pokemon pokemons[], int maxPokemons) {
    FILE *file = fopen(filename, "r");
    if (!file) return -1; // Erro ao abrir arquivo

    char *linha = (char*) malloc(1000 * sizeof(char));;
    int acc = 0;

    // Pular o cabeçalho
    fgets(linha, sizeof(linha), file);
    linha[strcspn(linha,"\n")]='\0';

    // Ler linha por linha
    while (fgets(linha, sizeof(linha), file) && acc < maxPokemons) {
        // Processar a linha
        char *separar = strtok(linha, ",");
        pokemons[acc].id = atoi(separar);
        separar = strtok(NULL, ",");
        pokemons[acc].generation = atoi(separar);
        separar = strtok(NULL, ",");
        strcpy(pokemons[acc].name, separar);
        separar = strtok(NULL, ",");
        strcpy(pokemons[acc].description, separar);
        
        // Processar tipos
        for (int i = 0; i < MAX_TYPES; i++) {
            separar = strtok(NULL, ",");
            if (separar) {
                strcpy(pokemons[i].types[i], separar);
            } else {
                break;
            }
        }

        // Processar habilidades
        separar = strtok(NULL, ",");
        for (int i = 0; i < MAX_ABILITIES && separar != NULL; i++) {
            strcpy(pokemons[i].abilities[i], separar);
            separar = strtok(NULL, ",");
        }

        // Processar peso, altura, taxa de captura, e legendário
        separar = strtok(NULL, ",");
        pokemons[acc].weight = atof(separar);
        separar = strtok(NULL, ",");
        pokemons[acc].height = atof(separar);
        separar = strtok(NULL, ",");
        pokemons[acc].captureRate = atoi(separar);
        separar = strtok(NULL, ",");
        pokemons[acc].isLegendary = atoi(separar) == 1;

        // Processar data de captura
        separar = strtok(NULL, ",");
        if (separar && strlen(separar) > 0) {
            strptime(separar, "%d/%m/%Y", &pokemons[acc].captureDate);
        }

        acc++;
    }

    fclose(file);
    free(linha);
    return acc; // Retornar o número de pokémons lidos
}

// Função para buscar Pokémon pelo ID
Pokemon* searchPokemonId(Pokemon pokemons[], int count, int id) {
    for (int i = 0; i < count; i++) {
        if (pokemons[i].id == id) {
            return &pokemons[i];
        }
    }
    return NULL;
}

// Função para imprimir os detalhes do Pokémon
void printPokemon(const Pokemon *p) {
    char dateStr[20];
    strftime(dateStr, sizeof(dateStr), "%d/%m/%Y", &p->captureDate);
    printf("[#%d -> %s: %s - %s - %s - %.2fkg - %.2fm - %d%% - %s - %d gen] - %s\n",
           p->id, p->name, p->description, p->types[0],
           p->types[1], p->weight, p->height,
           p->captureRate, p->isLegendary ? "true" : "false",
           p->generation, dateStr);
}

int main() {
    Pokemon pokemons[MAX_POKEMONS];
    int pokemonCount = readCsv("/tmp/pokemon.csv", pokemons, MAX_POKEMONS);
    
    if (pokemonCount < 0) {
        printf("Erro ao ler o arquivo.\n");
        return 1;
    }

    char *id = (char*) calloc(100 * sizeof(char));
    while (true) {
        scanf("%s", id);
        if (strcmp(id, "FIM") == 0) break;

        int id = atoi(id);
        Pokemon *p = searchPokemonId(pokemons, pokemonCount, id);
        if (p) {
            printPokemon(p);
        } else {
            printf("Pokémon não encontrado.\n");
        }
    }

    free(id);
    return 0;
}
