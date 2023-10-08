package Statki;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Arrays;
import java.util.Scanner;

public class Statki {
    public static String[][] stworzPlansze(){
        String[][] plansza = new String[10][10];
        for(int i=0; i<10; i++){
            Arrays.fill(plansza[i], "-");
        }
        return plansza;
    }
    public static void wyswietlPlansze(String[][] plansza){
        String[][] planszaRamka = new String[11][11];
        planszaRamka[0][0] = "  ";
        for(int i=9; i>=1; i--){
            int temp = i-1;
            planszaRamka[0][i] = " " + temp + " ";
            planszaRamka[i+1][0] = " " + i;
        }
        planszaRamka[0][10] = " 9";
        planszaRamka[1][0] = " 0";
        for(int i=1; i<11; i++){
            for(int j=1; j<11; j++){
                planszaRamka[i][j] = " " + plansza[i-1][j-1] + " ";
            }
        }

        for(int i=0; i<11; i++){
            for(int j=0; j<11; j++){
                System.out.print(planszaRamka[i][j]);
            }
            System.out.println();
        }

    }

    public static String[][] dodajStatki(String[][] plansza){
        Scanner input = new Scanner(System.in);
        System.out.println("Wybierz koordynaty statku (x,y)");
        int x = input.nextInt();
        int y = input.nextInt();
        plansza[y][x] = "@";
        return plansza;
    }

    public static String[][] weryfikujPole(String[][] plansza, int l){
        int[][] prev_cords = new int[l-1][2];
        for(int i=0; i<l; i++){
            int x = 11;
            int y = 11;
            boolean flag = false;
            while(plansza[y][x].equals("@") || x>9 || x<0 || y>9 || y<0 || !flag){
                Scanner input = new Scanner(System.in);
                System.out.println("Wybierz koordynaty statku (x,y)");
                x = input.nextInt();
                y = input.nextInt();
                if(plansza[y][x].equals("@")){ System.out.println("Podano koordynaty spoza zakresu lub już zajęte"); }
                else{
                    if(i==0){
                        plansza[y][x] = "@";
                        prev_cords[i][0] = y;
                        prev_cords[i][1] = x;
                    }
                    else{
                        if(prev_cords[0][0] == 0 && prev_cords[0][1] == 0){}
                        else if(prev_cords[0][0] == 0 && prev_cords[0][1] == 9){}
                        else if(prev_cords[0][0] == 9 && prev_cords[0][1] == 0){}
                        else if(prev_cords[0][0] == 9 && prev_cords[0][1] == 9){}
                    }
                }
            }
        }
       return null;
    }


    public static void main(String[] args){

        String[][] board = stworzPlansze();
        wyswietlPlansze(board);
        dodajStatki(board);
        wyswietlPlansze(board);

    }

}
