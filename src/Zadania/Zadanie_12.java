package Zadania;

public class Zadanie_12 {
    public static void main(String[] args) {
        String word = "kajak";
        boolean palindrom = true;
        for(int i=0; i<word.length()/2; i++){
            if(word.charAt(i) != word.charAt(word.length()-1-i)){
                palindrom = false;
            }
        }
        if(palindrom){System.out.println("palindrom");}
        else{System.out.println("nie palindrom");}
    }
}
