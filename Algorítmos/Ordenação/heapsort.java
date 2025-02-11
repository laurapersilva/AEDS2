//existe heapsort invertido tambem, basicamente uma arvore binaria
// se a sua posicao é I, seu pai está na posicao I/2, seu filho1 está em 2I e eu filho2 está em 2I+1
//se um nó tem 0 filhos, nao existe F1 e F2 acima (oq é meio obvio mas ok)
//custo é lgN, melhor caso é theta de N e acontece quando todos os elementos sao menores ou iguais seus pais

public class heapsort {
    //(os arrays comecam com 1, pois nao se divide 0 por 2 -> array[1] é a raiz
    public void heapsort() {
        //construcao do heap
        for(int tam=2; tam<=n; tam++) {
            contruir(tam);
        }
        
         //a segunda etapa consiste em destruir o heap, ordenando o array de tras para frente. o custo da segunda etapa é theta de N*lgN para todos os casos

        //construcao propriamente dita
        int tam=n;
        while (tam>1) {
            swap(1, tam--);
            reconstruir(tam);
        }
    }
    
    public void construir(int tam) {
        for(int i=tam; i>1 && array[i]>array[i/2]; i/=2) {
            swap(i, i/2);
        }
    }

    public void reconstruir(int tam) {
        int i=1;
        while(hasFilho(i,tam) == true) {
            int filho = getMaiorFilho(i,tam);
            if(array[i]<array[filho]) {
                swap(i, filho);
                i=filho;
            }
            else {
                i=tam;
            }
        }
    }
}
