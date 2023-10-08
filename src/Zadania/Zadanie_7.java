package Zadania;
import java.util.Scanner;
import java.util.Arrays;

public class Zadanie_7 {
    public static void main(String[] args){
        int[] tab = new int[3];
        Scanner input = new Scanner(System.in);
        for(int i=0; i<3; i++){
            tab[i] = input.nextInt();
        }
        Arrays.sort(tab);
        System.out.println(tab[0] + " " + tab[1] + " " + tab[2]);
    }
}
