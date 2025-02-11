import java.util.Scanner;
class Parentese{
    public static void main(String [] args){
        Scanner scanf = new Scanner(System.in);
    while(true){
         String str= scanf.nextLine();
    int size= str.length();
    if(str.equals("FIM")){
            break;
        }
    int cont=0;
     int cont2=0;
    for(int i=0; i<size; i++){
        if(str.charAt(i)=='('){
            for(int j=i; j<size; j++){
                 if(str.charAt(j)==')'){
                   cont+=2;
                   break;
                 }                 
            }
        }
    }
     for(int i=0; i<size; i++){
        if(str.charAt(i)==')'||str.charAt(i)=='('){
           cont2++;
        }
     }
    if(cont==cont2){
        System.out.println("correto");
    } else {System.out.println("incorreto");
    }
    }
    scanf.close();
    }
}