package TADF;

import javax.crypto.NullCipher;


public class ponteiros {

    Cliente c1 = new Cliente(1, "aa");
    Cliente c2 = null;

    c2=c1;
    c2=null;

    c2=c1.clone();
    //em OO temos o metodo clone em nossas classes. Esse metodo cria um novo objeto cujos atributos tem os mesmos valores do objeto referenciado. Esse metodo retorna o endereco de memoria do novo objeto
}

// pratica

class Celula {
    public int elemento;
    public Celula prox;
    public Celula() {
        this(0);
    }
    public Celula(int x) {
        this.elemento = x;
        this.prox = null;
    }
}

class Pilha {
    private Celula topo;
    public Pilha() {
        topo = null;
    }

    public void inserir(int x) {
        Celula tmp = new Celula(x);
        tmp.prox = topo;
        topo = tmp;
        tmp = null;
    }

    public int remover() throws Exception {
        if(topo == null) {
            throw new Exception("Erro!");
        }
        int elemento = topo.elemento;
        Celula tmp = topo;
        topo = topo.prox;
        tmp.prox = null;
        tmp = null;
        return elemento;
        //no metodo remover da pilha, em java, deixa uma caixinha como nao referenciada. Em java, todo objeto nao referenciado se torna apto ou disponivel para a coleta automatica de lixo. Em C, antes do comando "tmp=null" devemos efetuar um free(tmp)para desalocar ou remover fisicamente a caixinha.
    }

    public void mostrar() {
        System.out.print("[");
        for(Celula i = topo; i!=null; i=i.prox) {
            System.out.print(i.elemento + " ");
        }
        System.out.print("]");
    }
}