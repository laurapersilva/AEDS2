class No {
    public int valor;
    public No esq;
    public No dir;

    No(int valor) {
        this.valor = valor;
        esq = null;
        dir = null;
    }
}

class ArvoreAVL {
    private No raiz;

    ArvoreAVL() {
        raiz = null;
    }

    private int altura(No i) {
        if (i == null) {
            return 0;

        } else {
            int alturaEsq = altura(i.esq);
            int alturaDir = altura(i.dir);
            return 1 + Math.max(alturaEsq, alturaDir);
        }
    }

    private int fatorBalanceamento(No i) {
        return altura(i.dir) - altura(i.esq);
    }

    public void inserir(int valor) {
        raiz = inserir(raiz, valor);

    }

    private No rotacionarDir(No no) {
        No noEsq = no.esq;
        No noEsqDir = noEsq.dir;

        noEsq.dir = no;
        no.esq = noEsqDir;

        return noEsq;

    }

    private No rotacionarEsq(No no) {
        No noDir = no.dir;
        No noDirEsq = noDir.esq;
        noDir.esq = no;
        no.dir = noDirEsq;
        return noDir;

    }

    private No inserir(No i, int valor) {
        if (i == null) {
            i = new No(valor);
        } else if (valor < i.valor) {
            i.esq = inserir(i.esq, valor);

        } else {
            i.dir = inserir(i.dir, valor);
        }

        int balanco = fatorBalanceamento(i);

        if (balanco < -1 && valor < i.valor) {
            return rotacionarDir(i);

        }
        if (balanco > 1 && valor > i.valor) {
            return rotacionarEsq(i);

        }
        if (balanco < -1 && valor > i.valor) {
            i.esq = rotacionarEsq(i.esq);
            return rotacionarDir(i);

        }
        if (balanco > 1 && valor < i.valor) {
            i.dir = rotacionarDir(i.dir);
            return rotacionarEsq(i);
        }

        return i;
    }

    public void mostrar() {
        emOrdem(raiz);

    }

    private void emOrdem(No i) {
        if (i != null) {
            emOrdem(i.esq);
            System.out.print(i.valor + " ");
            emOrdem(i.dir);
        }

    }
}

class Teste11 {
    public static void main(String[] args) {

        ArvoreAVL arvore = new ArvoreAVL();
        arvore.inserir(12);
        arvore.inserir(5);
        arvore.inserir(8);
        arvore.inserir(3);
        arvore.inserir(11);

        arvore.mostrar();

    }

}