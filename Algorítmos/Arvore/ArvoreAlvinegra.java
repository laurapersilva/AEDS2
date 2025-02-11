public class ArvoreAlvinegra {

}

class NoAN {
    public boolean cor;
    public int elemento;
    public NoAN esq, dir;
    public NoAN () {
        this(-1);
    }
    // nos slides de AN false será a cor branca e true será preta
    public NoAN (int elemento) {
        this(elemento, false, null, null);
    }
    public NoAN (int elemento, boolean cor){
        this(elemento, cor, null, null);
    }
    public NoAN (int elemento, boolean cor, NoAN esq, NoAN dir) {
        this(elemento, cor, esq, dir);
    }
}
