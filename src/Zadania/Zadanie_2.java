package Zadania;
//Wyswietlanie tekstu od tylu
public class Zadanie_2 {
    //iteracyjnie
    public static String reverse(String s){
        StringBuilder nowys = new StringBuilder();
        for(int i = s.length()-1; i >= 0; i--){
            nowys.append(s.charAt(i));
        }
        return nowys.toString();
    }
    //rekurencyjnie
    public static String reverse_rek(String s, int index, StringBuilder nowys){
        if (index == -1){ //albo < 0
            return nowys.toString();
        }
        return reverse_rek(s, index-1, nowys.append(s.charAt(index)));
    }
    
    public static void main(String[] args){
        String slowo = "abcd";
        System.out.println(reverse(slowo));

        StringBuilder nowys_rek = new StringBuilder();
        System.out.println(reverse_rek(slowo, slowo.length()-1, nowys_rek));


    }

}
