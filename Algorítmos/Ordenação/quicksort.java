public class quicksort {
    public void quicksort(int esq, int dir) {
        int i=esq, j=dir, pivo = array((esq+dir)/2);

        while(i<=j) {
            while(array[i] < pivo) {
                i++;
            }
            while(array[j] > pivo) {
                j--;
            }
            if(i<=j) {
                swap(i,j);
                i++;
                j--;
            } 

        }
        if(esq<j) {
            quicksort(esq,j);
        }
        if(i<dir) {
            quicksort(i, dir);
        }
    }
}
