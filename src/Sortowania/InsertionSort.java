package Sortowania;
import java.util.Random;
//O(n^2)
public class InsertionSort {
    public static void main(String[] args) {
        int[] tab = new int[20];
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            tab[i] = random.nextInt(100);
        }
        System.out.print("Przed posortowaniem: ");
        for (int i = 0; i < 20; i++) {
            System.out.print(tab[i] + " ");
        }

        for(int i=1; i < tab.length; i++){
            for(int j=i; j>0; j--){
                if(tab[j]<tab[j-1]){
                    int temp = tab[j];
                    tab[j] = tab[j-1];
                    tab[j-1] = temp;
                }
                else{
                    break;
                }
            }
        }
        System.out.print("\nPo posortowaniu: ");
        for (int i = 0; i < 20; i++) {
            System.out.print(tab[i] + " ");
        }

    }
}
