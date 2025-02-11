public class HashReHash {
    public static final int NULO = 0x7FFFFFF;
    public int[] tabela;
    int tamTabela, tamReserva;
    int numReserva;

    HashReHash() {
        this(0);
    }
    HashReHash(int tam) {
        tamTabela = tam;
        for(int i=0; i<tam; i++) {
            tabela[i] = NULO;
        }
    }

    //exemplo hash e rehash
    int hash(int x) {
        return x%7;
    }
    int rehash(int x) {
        return x%5;
    }

    void inserir(int x) {
        int i = hash(x);
        
        if(tabela[i] == NULO) {
            tabela[i] = x;
        } 
        else { //tabela ja está ocupada
            i = rehash(x);
            if(tabela[i] == NULO) {
                tabela[i] = x;
            } 
            else {
                System.out.println("deu pra inserir nao");
            }
        }
    }

    int pesquisar(int x) {
        int resp = NULO;
        int i = hash(x);
        if(tabela[i] == x) {
            resp = i;
        }
        else { //se tiver qualquer outra coisa na tabela
            i = rehash(x);
            if(tabela[i] == x) {
                resp = i;
            }
            else {
                System.out.println("tem nao");
            }
        }
        return resp;
    }

    void remover(int x) {
        int i = hash(x);
        if(tabela[i] == x) {
            tabela[i] = NULO;
        } else {
            i = rehash(x);
            if(tabela[i] == x) {
                tabela[i] = NULO;
            }   
        }
    }
}
