package Zadania;
import java.util.Scanner;

public class Zadanie_10 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = -1;
        System.out.println("Podaj liczbę dla której ma być obliczona silnia: ");
        n = input.nextInt();
        do{
            if(n<0){
                System.out.println("Musisz podac liczbe nieujemna: ");
                n = input.nextInt();
            }
        }while(n<0);
        int suma = 1;
        if(n == 0){
            System.out.println("Silnia 0 jest równa 1");
        }
        else{
            for(int i=1; i<n+1; i++){
                suma*=i;
            }
            System.out.println("Silnia "+ n + " jest rowna: " + suma);
        }
    }
}
