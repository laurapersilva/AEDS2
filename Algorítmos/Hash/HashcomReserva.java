public class HashcomReserva { //tabela hash direta com area de reserva
    public static final int NULO = 0x7FFFFFF;
    public int[] tabela;
    int tamTabela;
    int numReserva;
    int tamReserva;

    HashcomReserva() {
        this(0,0);
    }
    HashcomReserva(int tam1, int tam2) {
        this.tamTabela = tam1;
        this.tamReserva = tam2;
        this.numReserva = 0;
        for(int i=0; i<(tam1+tam2); i++) {
            tabela[i] = 0;
        }
    }

    // exemplo formula
    int hash(int x) {
        return x%7;
    }

    //inserir
    void inserir(int x) throws Exception {
        int i = hash(x);

        if(x==NULO){
            throw new Exception ("Erro!");
        }
        else if(tabela[i] == NULO) {
            tabela[i] = x;
        }
        else if(numReserva<tamTabela) {
            tabela[tamReserva + numReserva] = x;
            numReserva++;   //o valor inicial de numReserva é zero
        } 
        else { 
           throw new Exception ("Erro!"); 
        }    
    }

    int pesquisar(int x) {
        int i = hash(x), resp = NULO;
        if(tabela[i] == x) {
            resp = i;
        }
        else if(tabela[i] == NULO) { //se na tabela tiver qualquer outro numero
            for(int j=0; j<tamReserva; j++) {
                if(tabela[tamTabela+i] == x) {
                    resp = tamTabela+i;
                    j = tamReserva;
                }
            }
        }
        return resp;
    }

    void remover(int x) throws Exception{
        int i = hash(x);
        if(tabela[i] == NULO) {throw new Exception("Esse numero nem ta na tabela burro");}
        else if (tabela[i] == x) {
            tabela[i] = NULO;
            //realocando o numero da reserva para o lugar do numero retirado (se tiver)
            for(int j=0; j<tamReserva; j++) {
                if (hash(tabela[tamTabela+j]) == i) {
                    tabela[i] = tabela[tamTabela+j];
                    tabela[tamTabela+j] = NULO;
                    j = tamReserva;
                }
            }
        }
    }
}
