import java.util.*;

public class lista {

    class Lista {
        int[] array;
        int n;

        Lista () { this(6); }

        Lista (int tamanho){
        array = new int[tamanho];
        n = 0;
        }

        void inserirInicio(int x) throws Exception {
            if (n >= array.length) {
                throw new Exception ("Erro!");
            }

            //levar elementos para uma posicao acima
            for (int i=n; i>0; i--){
                array[i] = array[i-1];
            }

            array[0] = x;
            n++;
        }

        void inserirFim(int x) throws Exception{ 
            if (n >= array.length) {
                throw new Exception ("Erro!");
            }
            array[n] = x;
            n++;
        }

        void inserirPos(int x, int pos) throws Exception{
            if (n >= array.length || pos < 0 || pos > n) {
                throw new Exception("Erro!");
            }

            //levar elementos para o fim do array
            for(int i = n; i>0; i--) {
                array[i] = array[i-1];
            }

            array[pos] = x;
            n++;
        }

        int removerInicio() throws Exception{
            if (n == 0) {
                throw new Exception("Erro!");
            }

            int resp = array[0];
            n--;

            //voltando os elementos
            for(int i=0; i<n; i++) {
                array[i] = array[i+1];
            }
            return resp;
        }

        int removerFim() throws Exception{
            if (n == 0) {
                throw new Exception("Erro!");
            }

            return array[--n];
        }
        
        int remover(int pos) throws Exception{
            if(n == 0 || pos >= n || pos < 0) {
                Environment.Exit(0);
            }

            int resp = array[pos];
            n--;

            for(int i=pos; i<n; i++) {
                array[i] = array[i+1];
            }

            return pos;
        }

        void mostrar () {
            for(int i=0; i<n; i++) {
                System.out.print(array[i] + " ");
            }
        }
    }


    public static void main (String[] args) {

        System.out.println("==== LISTA LINEAR ====");

        Lista lista = new Lista();
        int x1, x2, x3;

        lista.inserirInicio(1);
        lista.inserirFim(7);
        lista.inserirFim(9);
        lista.inserirInicio(3);
        lista.inserir(8, 3);
        lista.inserir(4, 2);
        lista.mostrar();

        x1 = lista.removerInicio();
        x2 = lista.removerFim();
        x3 = lista.remover(2);

        System.out.print(x1 + ", " + x2 + ", " + x3);

        lista.mostrar();
    }
}