package Sortowania;
import java.util.Random;
//O(n^2)
public class BubbleSort{
    public static void main(String[] args){
        int[] tab = new int[20];
        Random random = new Random();
        for(int i=0; i<20; i++){
            tab[i] = random.nextInt(100);
        }
        System.out.print("Przed posortowaniem: ");
        for(int i=0; i<20; i++){
            System.out.print(tab[i] + " ");
        }

        boolean sorted = false;
        int step = 0;
        while(!sorted){
            int swaps = 0;
            for(int i=1; i<tab.length-step; i++){
                if(tab[i]<tab[i-1]){
                    int temp = tab[i];
                    tab[i] = tab[i-1];
                    tab[i-1] = temp;
                    swaps++;
                }
            }
            if(swaps == 0){
                sorted = true;
            }
            step+=1;
        }
        System.out.print("\nPo posortowaniu: ");
        for(int i=0; i<20; i++){
            System.out.print(tab[i] + " ");
        }

    }
}
