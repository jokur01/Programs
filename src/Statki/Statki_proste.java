package Statki;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class Statki_proste {

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

    public static void wyswietlObiePlansze(String[][] planszaGracz, String[][] planszaBot){
        String[][] plansza = new String[22][11];
        String[] ramkaPozioma = new String[22];
        ramkaPozioma[0] = "   ";
        for(int i=1;i<11;i++){ramkaPozioma[i] = " " + (i-1) + " ";}
        ramkaPozioma[11] = "     ";
        for(int i=12;i<22;i++){ramkaPozioma[i] = " " +  (i-12) + " ";}

        for(int i=0;i<22;i++){
            plansza[i][0] = ramkaPozioma[i];
        }

        for(int i=1;i<11;i++){
            plansza[0][i] = " " + (i-1) + " ";
            plansza[11][i] = "   " + (i-1) + " ";
        }

        for(int i=1;i<11;i++){
            for(int j=1;j<11;j++){
                plansza[j][i] = " " + planszaGracz[i-1][j-1] + " ";
                plansza[i+11][j] = " " + planszaBot[i-1][j-1] + " ";
            }
        }
        System.out.println("           Plansza Gracza                      Plansza Bota");
        for(int i=0;i<11;i++){
            for(int j=0;j<22;j++){
                System.out.print(plansza[j][i]);
            }
            System.out.println();
        }

    }

    public static Object[] dodajStatkiGracz(String[][] plansza, int ileStatkow){
        Object[] arrays = new Object[2];
        int[][] cords = new int[2][ileStatkow];
        for(int i = 0; i<ileStatkow;i++) {
            System.out.println("Podaj koordynaty na których ma być statek: ");
            boolean flag;
            do{
                Scanner input = new Scanner(System.in);
                int x = input.nextInt();
                int y = input.nextInt();
                if(Objects.equals(plansza[y][x], "@") || Objects.equals(plansza[y][x], "#")){
                    flag = false;
                    System.out.println("Obecne koordynaty są już zajęte, podaj koordynaty ponownie: ");
                }
                else{
                    flag = true;
                    plansza[y][x] = "@";
                    cords[0][i] = y;
                    cords[1][i] = x;
                    if(x == 0 && y == 0){plansza[1][0] = "#"; plansza[0][1] = "#"; plansza[1][1] = "#";}
                    else if(x == 0 && y == 9){plansza[8][0] = "#"; plansza[8][1] = "#"; plansza[9][1] = "#";}
                    else if(x == 9 && y == 0){plansza[0][8] = "#"; plansza[1][8] = "#"; plansza[1][9] = "#";}
                    else if(x == 9 && y == 9){plansza[9][8] = "#"; plansza[8][8] = "#"; plansza[8][9] = "#";}

                    else if(x == 0){
                        plansza[y+1][x] = "#";
                        plansza[y-1][x] = "#";
                        plansza[y][x+1] = "#";
                        plansza[y-1][x+1] = "#";
                        plansza[y+1][x+1] = "#";
                    }
                    else if(x == 9){
                        plansza[y+1][x] = "#";
                        plansza[y-1][x] = "#";
                        plansza[y][x-1] = "#";
                        plansza[y-1][x-1] = "#";
                        plansza[y+1][x-1] = "#";
                    }
                    else if(y == 0){
                        plansza[y][x-1] = "#";
                        plansza[y][x+1] = "#";
                        plansza[y+1][x+1] = "#";
                        plansza[y+1][x-1] = "#";
                        plansza[y+1][x] = "#";
                    }
                    else if(y == 9){
                        plansza[y][x-1] = "#";
                        plansza[y][x+1] = "#";
                        plansza[y-1][x+1] = "#";
                        plansza[y-1][x-1] = "#";
                        plansza[y-1][x] = "#";
                    }
                    else{
                        plansza[y-1][x-1] = "#";
                        plansza[y-1][x] = "#";
                        plansza[y-1][x+1] = "#";
                        plansza[y][x-1] = "#";
                        plansza[y][x+1] = "#";
                        plansza[y+1][x-1] = "#";
                        plansza[y+1][x] = "#";
                        plansza[y+1][x+1] = "#";
                    }
                    wyswietlPlansze(plansza);
                    System.out.println("===============================");
                }
            }while(!flag);
            if(i == 3){System.out.println("Tak wygląda twoja plansza");}
        }
        for(int k=0; k<10; k++){
            for(int l=0; l<10; l++){
                if(Objects.equals(plansza[l][k], "#")){plansza[l][k] = "-";}
            }
        }
        arrays[0] = plansza;
        arrays[1] = cords;
        return arrays;
    }

    public static Object[] dodajStatkiBot(String[][] plansza, int ileStatkow) {
        Object[] arrays = new Object[2];
        int[][] cords = new int[2][ileStatkow];
        Random random = new Random();
        for (int i = 0; i < ileStatkow; i++) {
            boolean flag;
            do{
                int x = random.nextInt(10);
                int y = random.nextInt(10);
                if (Objects.equals(plansza[y][x], "@") || Objects.equals(plansza[y][x], "#")) { flag = false; }
                else {
                    flag = true;
                    plansza[y][x] = "@";
                    cords[0][i] = y;
                    cords[1][i] = x;
                    if (x == 0 && y == 0) {
                        plansza[1][0] = "#";
                        plansza[0][1] = "#";
                        plansza[1][1] = "#";
                    } else if (x == 0 && y == 9) {
                        plansza[8][0] = "#";
                        plansza[8][1] = "#";
                        plansza[9][1] = "#";
                    } else if (x == 9 && y == 0) {
                        plansza[0][8] = "#";
                        plansza[1][8] = "#";
                        plansza[1][9] = "#";
                    } else if (x == 9 && y == 9) {
                        plansza[9][8] = "#";
                        plansza[8][8] = "#";
                        plansza[8][9] = "#";
                    } else if (x == 0) {
                        plansza[y + 1][x] = "#";
                        plansza[y - 1][x] = "#";
                        plansza[y][x + 1] = "#";
                        plansza[y - 1][x + 1] = "#";
                        plansza[y + 1][x + 1] = "#";
                    } else if (x == 9) {
                        plansza[y + 1][x] = "#";
                        plansza[y - 1][x] = "#";
                        plansza[y][x - 1] = "#";
                        plansza[y - 1][x - 1] = "#";
                        plansza[y + 1][x - 1] = "#";
                    } else if (y == 0) {
                        plansza[y][x - 1] = "#";
                        plansza[y][x + 1] = "#";
                        plansza[y + 1][x + 1] = "#";
                        plansza[y + 1][x - 1] = "#";
                        plansza[y + 1][x] = "#";
                    } else if (y == 9) {
                        plansza[y][x - 1] = "#";
                        plansza[y][x + 1] = "#";
                        plansza[y - 1][x + 1] = "#";
                        plansza[y - 1][x - 1] = "#";
                        plansza[y - 1][x] = "#";
                    } else {
                        plansza[y - 1][x - 1] = "#";
                        plansza[y - 1][x] = "#";
                        plansza[y - 1][x + 1] = "#";
                        plansza[y][x - 1] = "#";
                        plansza[y][x + 1] = "#";
                        plansza[y + 1][x - 1] = "#";
                        plansza[y + 1][x] = "#";
                        plansza[y + 1][x + 1] = "#";
                    }
                }
            }while(!flag);
        }
        for(int k=0; k<10; k++) {
            for (int l = 0; l < 10; l++) {
                    plansza[l][k] = "-";
                }
            }
        arrays[0] = plansza;
        arrays[1] = cords;
        return arrays;
    }

    public static Object[] atakGracza(String[][] plansza, int[][] cords) {
        Object[] result = new Object[2];
        boolean trafiony = false;
        System.out.println("Podaj koordynaty które mają zostać atakowane: ");
        boolean flag;
        do{
            Scanner input = new Scanner(System.in);
            int y = input.nextInt();
            int x = input.nextInt();
            if (Objects.equals(plansza[y][x], "x") || Objects.equals(plansza[y][x], "#")) {
                flag = false;
                System.out.println("Obecne koordynaty są już zostaly zaatakowane: ");
            }
            else {
                flag = true;
                for(int i=0;i<cords[0].length;i++){
                    if(y == cords[0][i] && x == cords[1][i]){
                        trafiony = true;
                        plansza[y][x] = "x";
                        if (x == 0 && y == 0) {
                            plansza[1][0] = "#";
                            plansza[0][1] = "#";
                            plansza[1][1] = "#";
                        } else if (x == 0 && y == 9) {
                            plansza[8][0] = "#";
                            plansza[8][1] = "#";
                            plansza[9][1] = "#";
                        } else if (x == 9 && y == 0) {
                            plansza[0][8] = "#";
                            plansza[1][8] = "#";
                            plansza[1][9] = "#";
                        } else if (x == 9 && y == 9) {
                            plansza[9][8] = "#";
                            plansza[8][8] = "#";
                            plansza[8][9] = "#";
                        } else if (x == 0) {
                            plansza[y + 1][x] = "#";
                            plansza[y - 1][x] = "#";
                            plansza[y][x + 1] = "#";
                            plansza[y - 1][x + 1] = "#";
                            plansza[y + 1][x + 1] = "#";
                        } else if (x == 9) {
                            plansza[y + 1][x] = "#";
                            plansza[y - 1][x] = "#";
                            plansza[y][x - 1] = "#";
                            plansza[y - 1][x - 1] = "#";
                            plansza[y + 1][x - 1] = "#";
                        } else if (y == 0) {
                            plansza[y][x - 1] = "#";
                            plansza[y][x + 1] = "#";
                            plansza[y + 1][x + 1] = "#";
                            plansza[y + 1][x - 1] = "#";
                            plansza[y + 1][x] = "#";
                        } else if (y == 9) {
                            plansza[y][x - 1] = "#";
                            plansza[y][x + 1] = "#";
                            plansza[y - 1][x + 1] = "#";
                            plansza[y - 1][x - 1] = "#";
                            plansza[y - 1][x] = "#";
                        } else {
                            plansza[y - 1][x - 1] = "#";
                            plansza[y - 1][x] = "#";
                            plansza[y - 1][x + 1] = "#";
                            plansza[y][x - 1] = "#";
                            plansza[y][x + 1] = "#";
                            plansza[y + 1][x - 1] = "#";
                            plansza[y + 1][x] = "#";
                            plansza[y + 1][x + 1] = "#";
                        }
                        System.out.println("\u001B[32mTrafiony zatopiony!\u001B[0m");
                        break;
                    }
                }
                if(!trafiony){
                    System.out.println("\u001B[31m Pudlo! \u001B[0m");
                    plansza[y][x] = "#";
                }
            }
        }while(!flag);

        result[0] = plansza;
        result[1] = trafiony;
        return result;
    }

    public static Object[] atakBota(String[][] plansza, int[][] cords) {
        Object[] result = new Object[2];
        boolean trafiony = false;
        Random random = new Random();
        boolean flag;
        do{
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            if (Objects.equals(plansza[y][x], "x") || Objects.equals(plansza[y][x], "#")) { flag = false; }
            else {
                flag = true;
                for(int i=0;i<cords[0].length;i++){
                    if(y == cords[0][i] && x == cords[1][i]){
                        trafiony = true;
                        plansza[y][x] = "x";
                        if (x == 0 && y == 0) {
                            plansza[1][0] = "#";
                            plansza[0][1] = "#";
                            plansza[1][1] = "#";
                        } else if (x == 0 && y == 9) {
                            plansza[8][0] = "#";
                            plansza[8][1] = "#";
                            plansza[9][1] = "#";
                        } else if (x == 9 && y == 0) {
                            plansza[0][8] = "#";
                            plansza[1][8] = "#";
                            plansza[1][9] = "#";
                        } else if (x == 9 && y == 9) {
                            plansza[9][8] = "#";
                            plansza[8][8] = "#";
                            plansza[8][9] = "#";
                        } else if (x == 0) {
                            plansza[y + 1][x] = "#";
                            plansza[y - 1][x] = "#";
                            plansza[y][x + 1] = "#";
                            plansza[y - 1][x + 1] = "#";
                            plansza[y + 1][x + 1] = "#";
                        } else if (x == 9) {
                            plansza[y + 1][x] = "#";
                            plansza[y - 1][x] = "#";
                            plansza[y][x - 1] = "#";
                            plansza[y - 1][x - 1] = "#";
                            plansza[y + 1][x - 1] = "#";
                        } else if (y == 0) {
                            plansza[y][x - 1] = "#";
                            plansza[y][x + 1] = "#";
                            plansza[y + 1][x + 1] = "#";
                            plansza[y + 1][x - 1] = "#";
                            plansza[y + 1][x] = "#";
                        } else if (y == 9) {
                            plansza[y][x - 1] = "#";
                            plansza[y][x + 1] = "#";
                            plansza[y - 1][x + 1] = "#";
                            plansza[y - 1][x - 1] = "#";
                            plansza[y - 1][x] = "#";
                        } else {
                            plansza[y - 1][x - 1] = "#";
                            plansza[y - 1][x] = "#";
                            plansza[y - 1][x + 1] = "#";
                            plansza[y][x - 1] = "#";
                            plansza[y][x + 1] = "#";
                            plansza[y + 1][x - 1] = "#";
                            plansza[y + 1][x] = "#";
                            plansza[y + 1][x + 1] = "#";
                        }
                        System.out.println("\u001B[31m Trafiony zatopiony! \u001B[0m");
                        break;
                    }
                }
                if(!trafiony){ plansza[y][x] = "#"; }
            }
        }while(!flag);

        result[0] = plansza;
        result[1] = trafiony;
        return result;
    }

    public static void main(String[] args){
        String[][] boardGracz = stworzPlansze();
        String[][] boardBot = stworzPlansze();

        int ileStatkow = 3; //25 to maks ale nie ma co zbytnio liczyc ze zrobi ta plansze

        Object[] arraysBot = dodajStatkiBot(boardBot, ileStatkow);
        boardBot = (String[][]) arraysBot[0];
        int[][] cordsBot = (int[][]) arraysBot[1];

        Object[] arraysGracz = dodajStatkiGracz(boardGracz, ileStatkow);
        boardGracz = (String[][]) arraysGracz[0];
        int[][] cordsGracz = (int[][]) arraysGracz[1];

        int zyciaBota = ileStatkow;
        int zyciaGracza = ileStatkow;
        boolean trafBot = false;
        boolean trafGracz = false;

        while(zyciaGracza > 0 || zyciaBota > 0) {
            //TURA GRACZA
            if(!trafBot){
                wyswietlObiePlansze(boardGracz, boardBot);
                Object[] wynikAtakuGracza = atakGracza(boardBot, cordsBot);
                boardBot = (String[][]) wynikAtakuGracza[0];
                if ((boolean) wynikAtakuGracza[1]){
                    zyciaBota-=1;
                    trafGracz = true;
                }
                else{ trafGracz = false; }
                if(zyciaBota == 0){
                    System.out.println("Wygrałeś!");
                    return;
                }
            }

            //TURA BOTA
            if(!trafGracz){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Object[] wynikAtakuBota = atakBota(boardGracz, cordsGracz);
                boardGracz = (String[][]) wynikAtakuBota[0];
                if ((boolean) wynikAtakuBota[1]){
                    zyciaGracza-=1;
                    trafBot = true;
                }
                else{ trafBot = false; }
                if(zyciaGracza == 0){
                    System.out.println("Przegrałeś!");
                    return;
                }
            }
        }
    }
}