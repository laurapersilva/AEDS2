
//o custo de insercao, remocao e pesquisa em uma arvore balanceada sempre será theta de lgN, por outro lado, em uma arvore nao balanceada o custo pode ser theta de N

class No {
    int elemento;
    No esq, dir;
    No(int elemento) {
        this(elemento, null, null);
    }
    No(int elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}

public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        raiz = null;
    }
    //nas linguagens c e java temos apenas a passagem de parametros por valor

    //o primeiro metodo de insercao na AB retorna o endereco de um nó para que esse (novo elemento) seja conectado na arvore

    
    //complexidade do insercao
    //melhor caso: theta de 1 comparacoes e acontece por exemplo inserindo na raiz
    //pior caso: theta de n comparacoes e acontece por exemplo quando inserimos os elementos na ordem crescente ou decrescente
    void inserir(int x) {
       raiz = inserir(x, raiz);
    }
    No inserir(int x, No i) {
        if(i==null) {
            i = new No(x);
        }else if(x < i.elemento) {
            i.esq = inserir(x, i.esq);
        } else if(x>i.elemento) {
            i.dir = inserir(x, i.dir);
        }
        return i;
    }

    void inserirPai(int x) throws Exception {
        if(raiz == null) {
            raiz = new No(x);
        }
        else if (x<raiz.elemento) {
            inserirPai(x, raiz.esq, raiz);
        }
        else if(x>raiz.elemento) {
            inserirPai(x, raiz.dir, raiz);
        }
    }
    void inserirPai(int x, No i, No pai) {
        if(i == null) {
            if(x<pai.elemento) {
                pai.esq = new No(x);
            }
            else {
                pai.dir = new No(x);
            }
        } else if (x<i.elemento) {
            inserirPai(x, i.esq, i);
        }
        else if(x>i.elemento) {
            inserirPai(x, i.dir, i);
        }
    }

    //complexidade pesquisa
    //melhor caso: theta de 1 comparacoes e acontece por exemplo na raiz
    //pior caso: theta de n comparacoes e acontece por exemplo quando pesquisamos os elementos em ordem e o elemento desejado está na folha
    //caso medio: theta de n e acontece por exemplo quando a arvore está balanceada e procuramos um elemento localizado em uma das folhas
    // Método para buscar um valor na árvore
    boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    // Método recursivo para buscar um valor na árvore
    boolean buscarRecursivo(No raiz, int valor) {
        // A árvore está vazia, valor não encontrado
        if (raiz == null) {
            return false;
        }

        // Se o valor for igual ao valor do nó, a busca é bem-sucedida
        if (valor == raiz.elemento) {
            return true;
        }

        // Se o valor for menor, percorre a subárvore esquerda
        if (valor < raiz.elemento) {
            return buscarRecursivo(raiz.esq, valor);
        }

        // Se o valor for maior, percorre a subárvore direita
        return buscarRecursivo(raiz.dir, valor);
    }
}

    boolean pesquisarDois(int x) {
        return pesquisarDois(raiz, x);
    }

    boolean pesquisarDois (No i, int x) {
        boolean resp;
        if(i!=null) {
            resp = pesquisarDois(i.primeiro.prox, x) || pesquisarDois(i.esq, x) || pesquisarDois(i.dir, x);
        }
    }

    //complexidade caminhar é theta de n
    //muitos metodos
    //central ou em ordem
    void caminharCentral(No i) {
        if(i != null) {
            caminharCentral(i.esq);
            System.out.print(i.elemento + " ");
            caminharCentral(i.dir);
        }
    }

    //pré-fixado ou pré-ordem
    void caminharPos(No i) {
        if(i != null) {
            caminharPos(i.esq);
            caminharPos(i.dir);
            System.out.print(i.elemento + " ");
        }
    }
    
    //pós-fixado ou pós-ordem
    void caminharPre(No i) {
        if(i != null) {
            System.out.print(i.elemento + " ");
            caminharPos(i.esq);
            caminharPos(i.dir);
        }
    }
}


void caminharPos(No i, int acc) {
    if(i != null) {
        while(acc!=0) {
            caminharPos(i.esq);
            caminharPos(i.dir);
            0--;
        }
        return i.valor;
    }
}