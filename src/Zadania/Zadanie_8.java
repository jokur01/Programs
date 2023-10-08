package Zadania;
import java.util.Random;
import java.util.Scanner;

public class Zadanie_8 {
    public static void main(String[] args){
        int ilosc_kosci = 3;
        int[] tab = new int[3];
        int suma = 0;
        Random random = new Random();
        do{
            for(int i=0; i<ilosc_kosci; i++){
                tab[i] = random.nextInt(6)+1;
            }
            System.out.println("Mozliwe do wziecia kosci: ");
            for(int i=0;i<ilosc_kosci;i++){
                System.out.println(tab[i]);
            }
            System.out.println("ile chesz wziac kosci?");
            Scanner input = new Scanner(System.in);
            int zostawic = input.nextInt();
            System.out.println("Ktore kosci chcesz wziac?");
            for(int i=0; i<zostawic; i++){
                suma+= tab[input.nextInt()-1];
            }
            ilosc_kosci-=zostawic;
            System.out.println();
        }while(ilosc_kosci != 0);
        System.out.println(suma);
    }
}
