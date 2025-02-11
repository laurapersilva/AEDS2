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

public class lista {
    private Celula primeiro, ultimo;
    public lista() {
        primeiro = new Celula();
        ultimo = primeiro;
    }

    public void inserirFim(int x) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    public int removerInicio() throws Exception{
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
    public void inserirInicio(int x) {
        Celula tmp = new Celula(x);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;

        if(primeiro==ultimo) {
            ultimo=tmp;
        }
        tmp = null;
    }

    public int removerFim() throws Exception {
        if(primeiro == ultimo) {
            throw new Exception("Erro");
        }
        Celula i;
        for(i=primeiro; i.prox!=ultimo; i=i.prox);

        int elemento = ultimo.elemento;
        ultimo=i;
        i = ultimo.prox = null;
        return elemento;
    }

    public void inserirPos(int x, int pos) throws Exception {
        int tamanho = tamanho();
        
    }
}
