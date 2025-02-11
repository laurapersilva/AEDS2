import java.io.*;
import java.util.*;

public class arquivo {
    public static void main(String[] args) throws Exception{
        // Abre o arquivo para leitura e escrita
        RandomAccessFile arq = new RandomAccessFile("arquivo.txt", "rw");
            Scanner scanf = new Scanner(System.in);

            // Leitura do número de entradas
            int n = scanf.nextInt();
            scanf.nextLine(); // Consumir o newline após o número

            // Escreve os números flutuantes no arquivo
            for (int i = 0; i < n; i++) {
                String temp = scanf.nextLine();
            
                float numero = mudarString(temp);
                arq.writeFloat(numero);
            }

            // Move o ponteiro do arquivo para o final
            long tamLinha = arq.length();

            // Lê o arquivo de trás para frente e imprime os valores
            while (tamLinha > 0) {
                tamLinha -= 4;
                arq.seek(tamLinha);
                float guardar = arq.readFloat();
                
                if((guardar - (int)guardar) == 0) System.out.println((int)guardar);
                else System.out.println(guardar);
            }

            scanf.close();
        } 
    

    // Função para converter uma string com vírgula para float
    public static float mudarString(String temp) {
        // Substitui vírgulas por pontos
        String resultado = temp.replace(',', '.');
        return Float.parseFloat(resultado); 
    }

}
