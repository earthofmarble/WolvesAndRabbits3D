package sample;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        System.out.println("ВВЕДИТЕ РАЗМЕР ПОЛЯ X: ");
        int sizeX=scan.nextInt();
        System.out.println("ВВЕДИТЕ РАЗМЕР ПОЛЯ Y: ");
        int sizeY=scan.nextInt();
        System.out.println("ВВЕДИТЕ КОЛИЧЕСТВО ВОЛКОВ: ");
        int wolvesCount=scan.nextInt();
        System.out.println("ВВЕДИТЕ КОЛИЧЕСТВО ЗАЙЦЕВ: ");
        int rabbitsCount=scan.nextInt();


      //  Field obekt = new Field();
           // obekt.createField(5,5,3,5);
	Field.initField(sizeX,sizeY,wolvesCount,rabbitsCount);
        System.out.println("ИГРЫ КОНЧИЛИСЬ");
    }
}
