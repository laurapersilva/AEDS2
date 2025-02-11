
public class Arvore234 {
    //na insercao da 234 quando utilizamos fragmentacao na ascensao poderemos ter uma cascata de fragmentacoes. O que acontece quando o galho de insercao for composto apenas por nós do tipo 4
    void insercaoAscencao (int x) {

    }


    void insercaoDescida(int x) {
        //a insercao na descida é uma tecnica pró-ativa. Nesse caso, durante a descida se passarmos por um nó no tipo 4, esse será fragmentado. Fazemos isso para garantir que em qualquer fragmentacao o pai tenha espaco para receber um novo elemento

        //a fragmentacao da descida pode criar nós do tipo 4 e isso acontece quando o pai for do tipo 3
    }
}
