#include <stdio.h>
#include <stdlib.h>

int comparacao(int* inicioCorrida, int* finalCorrida, int n) {
    int ultrapassagens = 0;

    // Count overtakes based on initial and final positions
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            // Check if i overtook j
            if (inicioCorrida[i] < inicioCorrida[j] && finalCorrida[i] > finalCorrida[j]) {
                ultrapassagens++;
            }
        }
    }
    return ultrapassagens;
}

int main() {
    int n = 0;

    while (scanf("%d", &n) == 1 && n != 0) {
        
        // Read the initial array
        int* inicioCorrida = (int*)malloc(n * sizeof(int));
        for (int i = 0; i < n; i++) {
            scanf("%d", &inicioCorrida[i]);
        }

        // Read the final array
        int* finalCorrida = (int*)malloc(n * sizeof(int));
        for (int i = 0; i < n; i++) {
            scanf("%d", &finalCorrida[i]);
        }

        // Calculate overtakes
        int ultrapassagem = comparacao(inicioCorrida, finalCorrida, n);

        // Output the result
        printf("%d\n", ultrapassagem);

        // Free allocated memory
        free(inicioCorrida);
        free(finalCorrida);
    }
    return 0;
}
