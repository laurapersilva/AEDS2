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

public class fila {
    private Celula primeiro, ultimo;
    public fila() {
        primeiro = new Celula();
        ultimo = primeiro;
    }

    public void inserir(int x) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    public int remover() throws Exception{
        if(primeiro == ultimo) {
            throw new Exception("Erro!");
        }
        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        int elemento = primeiro.elemento;
        tmp.prox = null;
        tmp = null;
        return elemento;
    }

    public int mostrar() {
        Celula i = primeiro.prox;
        while(i!=null) {
            System.out.print(i.elemento + " ");
            i=i.prox;
        }
    }

    
}

