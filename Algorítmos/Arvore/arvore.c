#include <stdio.h>
#include <stdlib.h>

//no terceiro metodo de insercao utilizamos ponteiro de ponteiro para passarmos (por valor) o endereco da raiz. O endereco da raiz antes de depois do metodo inserir recursivo continuará sendo 65bh
//no metodo inserir recursivo, a variavel i é um ponteiro de ponteiro. Quando i recebe 65bh, fazemos com que *i seja igual ao conteudo da posicao 65bh