
//a variavel ultimo gerencia insercoes e a primeiro gerencia remocoes

class Fila {
    int[] array;
    int primeiro, ultimo;

    Fila() {
        this(5);
    }

    Fila(int tamanho) {
        array = new int[tamanho+1];
        primeiro = ultimo = 0;
    }

    void inserir(int x) throws Exception{
        if (((ultimo+1)% array.length) == primeiro) {
           throw new Exception("Erro!");
        }

        array[ultimo] = x;
        ultimo = (ultimo+1) % array.length;
    }

    int remover() throws Exception{ //é uma fila, logo, o que será removido sera o primeiro
        if(primeiro == ultimo) {
            throw new Exception("Erro!");
        }
        
        int removido = array[primeiro];
        primeiro = (primeiro+1) % array.length;
        return removido;
    }

    void mostrar() {
        
    }
}
