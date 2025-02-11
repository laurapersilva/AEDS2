

public class ciframento2 {
    public static void main(String[] args) {
        boolean end = true;

        while (end) {
            String codigo = MyIO.readLine();
            int comp = codigo.length();
            
            if(codigo.charAt(0)=='F' && codigo.charAt(1)=='I' && codigo.charAt(2)=='M') {
                break; //quando chegar em fim para o loop
            }
            
            String temp = "";
            int ascii = 0;

            for(int i=0; i<comp; i++) {
                ascii = codigo.charAt(i);
                temp = temp + (char)(ascii+3);
                
            }
            MyIO.println(temp);
        }
    }

}
