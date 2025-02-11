class No {
    public int elemento;
    public int contador;
    No esq, dir;
}

class Arvore {
    private No raiz;

    public void inserir(int x) {
        raiz = inserir(x, raiz);
    }
    No inserir(int x, No i) {
        if(i == null && x != i.elemento) {
            i = new No(x);
        }
        else if(i.elemento == x) {
            i.contador++;
        }
        else if(i.elemento > x) {
            inserir(x, i.esq);
        }
        else if(i.elemento < x) {
            inserir(x, i.dir);
        }
        return i;
    }
}
