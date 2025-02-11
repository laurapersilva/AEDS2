#include <stdio.h>

int metodo(int& x, int y) {
    int z;
    printf("%i %i", x, y);
    x = y = z = 2;
    printf("\n %i %i %i", x, y, z);
    return z;
}

int main(int argc, char** argv) {
    int a, b, c;
    a = b = 1;
    printf("%i %i", a, b);
    
    c = metodo(a,b); //o A, por ser passado como 

    printf("\n %i %i %i", a, b, c);
}