class CelulaDupla {
    public int elemento;
    public CelulaDupla prox, ant; //n entendi pq prox e ant tem que ser do tipo celuladupla
    public CelulaDupla() {
        this(0);
    }
    public CelulaDupla(int x) {
        this.elemento = x;
        this.prox = this.ant = null;

    }
}

public class listadupla {
    private CelulaDupla primeiro, ultimo;
    public listadupla() {
        primeiro = new CelulaDupla();
        ultimo = primeiro;
    }

    public void inserirInicio(int x) {
        CelulaDupla tmp = new CelulaDupla(x);

    }
    public void inserirFim(int x) {
        ultimo.prox = new CelulaDupla(x);
        ultimo.prox.ant = ultimo;
        ultimo = ultimo.prox;
    }
}
