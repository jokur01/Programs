package Sortowania;
import java.util.Random;
//O(n^2)
public class SelectionSort {
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
        for(int i=0; i<tab.length; i++){
            int curr_min = tab[i];
            int index = 0;
            for(int j=i+1; j<tab.length; j++){
                if(tab[j]<curr_min){
                    curr_min = tab[j];
                    index = j;
                }
            }
            int temp = tab[i];
            tab[i] = tab[index];
            tab[index] = temp;
        }
        System.out.print("\nPo posortowaniu: ");
        for (int i = 0; i < 20; i++) {
            System.out.print(tab[i] + " ");
        }
    }
}
