import java.util.*;

public class lsrec{

    public static boolean tem_vogal(String palavra, int tam, int i) {
        String vogais = "aeiouAEIOU";

        if (i>=tam) {
            return true;
        }

        char ch = palavra.charAt(i);
        if (vogais.indexOf(ch) == -1) {
            return false;
            
        }
        
        return tem_vogal(palavra, tam, i+1);
    }

    public static boolean tem_consoante(String palavra, int tam, int i) {
        String vogais = "aeiouAEIOU";

        if (i>=tam) {
            return true;
        }

        char c = palavra.charAt(i);
        if (Character.isLetter(c) == true) {
            if (vogais.indexOf(c) != -1) {
                return false;
            }
        } else {
            return false;
        }

        return tem_consoante(palavra, tam, i+1);
    }

    public static boolean eh_real(String palavra, int tam, int i) {
        int erro = 0;

        if (i>=tam) {
            return true;
        }

        if ( palavra.charAt(i) == '.' ||  palavra.charAt(i) == ',') {
            erro++;
            if (erro > 1) {
                return false;
            } 
        }else if ( palavra.charAt(i) < '0' ||  palavra.charAt(i)> '9') {
            return false;
        }   
        
        return eh_real(palavra, tam, i+1);
    }
    
    public static boolean eh_inteiro(String palavra, int tam, int i) {
        if (i>=tam) {
            return true;
        }

        char c = palavra.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        
        return eh_inteiro(palavra, tam, i+1);
    }
    public static void main(String[] args) {
            String palavra;
            
            while (true) {
                
                palavra = MyIO.readLine();
                int tam = palavra.length();
                if (palavra.equals("FIM")) {
                    break;
                }
                if (tem_vogal(palavra, tam, 0)) {
                    MyIO.print("SIM ");
                } else {
                    MyIO.print("NAO ");
                }

                if (tem_consoante(palavra, tam, 0)) {
                    MyIO.print("SIM ");
                } else {
                    MyIO.print("NAO ");
                }
                if (eh_inteiro(palavra, tam, 0)) {
                    MyIO.print("SIM ");
                } else {
                    MyIO.print("NAO ");
                }
                if (eh_real(palavra, tam, 0)) {
                    MyIO.print("SIM");
                } else {
                    MyIO.print("NAO");
                }
                MyIO.print("\n");
            }
        }
    }

