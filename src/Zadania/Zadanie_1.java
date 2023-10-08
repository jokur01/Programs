package Zadania;
//Obliczanie sredniej
public class Zadanie_1 {
    //rekurencyjne
    public static double srednia_rek(int tab[], int index, double suma){
        if(index == tab.length){
            return suma/tab.length;
        }
        return srednia_rek(tab, index+1, suma+=tab[index]);
    }
    //iteracyjne
    public static double srednia(int[] tab){
        double suma = 0;
        for(int i = 0; i<tab.length; i++){
            suma += tab[i];
        }
        return suma/tab.length;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] liczby = new int[5];
        liczby[0] = 5;
        liczby[1] = 5;
        liczby[2] = 5;
        liczby[3] = 5;
        liczby[4] = 20;

        double wynik_rek = srednia_rek(liczby, 0, 0);
        System.out.println(wynik_rek);

        double wynik = srednia(liczby);
        System.out.println(wynik);
    }
}