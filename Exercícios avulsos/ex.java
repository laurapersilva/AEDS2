
class Lista {
    CelulaLista inicio;
    CelulaLista fim;

    CelulaLista maiorPilha() {
        int tam = 0;
        int maiorPilha = 0;
        CelulaLista maior;

        //percorrendo as colunas
        for(CelulaLista i=inicio; i==fim; i=i.prox) {
            //andando por pilhas
            for(CelulaPilha j = i.topo; j!=null; j=j.prox) {
                tam++;
            }
            //comparando
            if(tam>maiorPilha) {
                maior = i;
            }
        }        
        return maior;
    }
}

class CelulaLista {
    CelulaPilha topo;
    CelulaLista prox;
}

class CelulaPilha {
    public int elemento;
    CelulaPilha prox;
}
