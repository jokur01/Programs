package Sortowania;

import java.util.Random;

public class MergeSort {
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
    }
}