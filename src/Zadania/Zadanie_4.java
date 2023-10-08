package Zadania;
import java.util.Scanner;

public class Zadanie_4 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj n: ");
        int n = input.nextInt();
        int[] digits = new int[n+1];
        digits[0] = 1;
        digits[1] = 1;
        int i = 2;
        while(i < n+1){
            digits[i] = digits[i-1] + digits[i-2];
            i++;
        }
        System.out.println(digits[n-1]);
    }

}
