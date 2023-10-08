package Zadania;
import java.util.Scanner;
import java.util.Arrays;

public class Zadanie_5 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String word1 = input.nextLine();
        String word2 = input.nextLine();
        if(word1.length() == word2.length()){
            char[] tab1 = new char[word1.length()];
            char[] tab2 = new char[word1.length()];
            for(int i=0; i<word1.length(); i++){
                tab1[i] = word1.charAt(i);
                tab2[i] = word2.charAt(i);
            }
            Arrays.sort(tab1);
            Arrays.sort(tab2);
            boolean anagram = Arrays.equals(tab1, tab2);
            if(anagram){
                System.out.println("Anagramy");
            }
            else{
                System.out.println("Nie anagramy");
            }
        }
        else{
            System.out.println("Nie anagramy");
        }
    }
}
