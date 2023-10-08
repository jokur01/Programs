package Zadania;

public class fib_rek {
    public static int fib(int index){
        if(index <= 1) return 1;
        return fib(index-1) + fib(index-2);
    }
    public static void main(String[] args){
        System.out.println(fib(5));
    }
}
