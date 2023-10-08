package Zadania;

public class Zadanie_3 {
    public static boolean prime(int num){
        for(int i = 2; i<=Math.ceil(Math.sqrt(num)); i++){
            if (num%i==0){ return false; }
        }
        return true;
    }

//    public static boolean prime_rek(int num, int dzielnik){
//        if (dzielnik<=Math.ceil(Math.sqrt(num)) || num%dzielnik!=0){
//            return prime_rek(num, dzielnik+1);
//        }
//        else return false;
//        }
    public static boolean prime_rek(int n) {
    if (n <= 1) {
        return false;
    }
    return czyPierwsza(n, n-1);
}

    private static boolean czyPierwsza(int n, int i) {
        if (i == 1) {
            return true;
        }
        if (n % i == 0) {
            return false;
        }
        return czyPierwsza(n, i-1);
    }

    public static void main(String[] args){
    int number = 24;
    System.out.println(prime(number));
    System.out.println(prime_rek(number));

    }
}
