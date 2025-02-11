import java.util.*;

public class ls{

    public static boolean tem_vogal(String palavra) {
        int tam = palavra.length();
        String vogais = "aeiouAEIOU";

        for (int i = 0; i < tam; i++) {
            char c = palavra.charAt(i);
            if (vogais.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean tem_consoante(String palavra) {
        int tam = palavra.length();
        String vogais = "aeiouAEIOU";

        for (int i = 0; i < tam; i++) {
            char c = palavra.charAt(i);
            if (Character.isLetter(c) == true) {
                if (vogais.indexOf(c) != -1) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean eh_real(String palavra) {
        int tam = palavra.length();
        int erro = 0;

        for (int i = 0; i < tam; i++) {
                if ( palavra.charAt(i) == '.' ||  palavra.charAt(i) == ',') {
                    erro++;
                    if (erro > 1) {
                        return false;
                    } 
                }else if ( palavra.charAt(i) < '0' ||  palavra.charAt(i)> '9') {
                    return false;
                }   
        }
        return true;
    }
    
    public static boolean eh_inteiro(String palavra) {
        int tam = palavra.length();
        for (int i = 0; i < tam; i++) {
            char c = palavra.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
            String palavra;
            while (true) {
                palavra = MyIO.readLine();
                if (palavra.equals("FIM")) {
                    break;
                }
                if (tem_vogal(palavra)) {
                    MyIO.print("SIM ");
                } else {
                    MyIO.print("NAO ");
                }

                if (tem_consoante(palavra)) {
                    MyIO.print("SIM ");
                } else {
                    MyIO.print("NAO ");
                }
                if (eh_inteiro(palavra)) {
                    MyIO.print("SIM ");
                } else {
                    MyIO.print("NAO ");
                }
                if (eh_real(palavra)) {
                    MyIO.print("SIM");
                } else {
                    MyIO.print("NAO");
                }
                MyIO.print("\n");
            }
        }
    }

