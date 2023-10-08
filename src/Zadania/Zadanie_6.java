package Zadania;
import java.util.Scanner;

public class Zadanie_6 {
    public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int a = input.nextInt();
    int b = input.nextInt();
    if(a%b==0){ System.out.println("a jest podzielne przez b"); }
    else{ System.out.println("a nie jest podzielne przez b"); }
    }
}
