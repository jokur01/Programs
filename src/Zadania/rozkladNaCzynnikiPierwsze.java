package Zadania;
import java.util.ArrayList;

public class rozkladNaCzynnikiPierwsze {
    public static void main(String[] args){
        int num = 100;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 2; i<num+1; i++){
            if(num%i==0){
                list.add(i);
                num/=i;
                if(num == i){
                    list.add(i);
                    break;
                }
                i=1;
            }
        }
        System.out.println(list);
    }
}
