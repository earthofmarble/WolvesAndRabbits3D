package sample;

import java.util.Objects;
import java.util.Scanner;

enum Direction {
       NORTH(-1,0),
       NORTHWEST(-1,-1),
       WEST(0,-1),
       SOUTHWEST(1,-1),
       SOUTH(1,0),
       SOUTHEAST(1,1),
       EAST(0,1),
       NORTHEAST(-1,1),
       NONE(0,0);
    //config
    private final int xSteps;
    private final int ySteps;

    private Direction(int xSteps, int ySteps) {
        this.xSteps = xSteps;
        this.ySteps = ySteps;
    }

    public int getNewXId(int currentXId)  {
        return  (currentXId + getXSteps());
    }
    public int getNewYId(int currentYId)  {
        return  (currentYId + getYSteps());
    }
    public int getXSteps()  {
        return  xSteps;
    }
    public int getYSteps()  {
        return  ySteps;
    }

}


public class Field {
  int sizeX;
   int sizeY;
    public static int rabbitDeathCount=0;
     public static int wolfDeathCount=0;

    public static void initPlayers(int sizeX, int sizeY, int wolvesCount, int rabbitsCount, String[][] fieldArray) {
        int wolkRandomX=0 + (int) (Math.random() * sizeX);
        int wolkRandomY=0 + (int) (Math.random() * sizeY);
        int zayacRandomX=0 + (int) (Math.random() * sizeX);
        int zayacRandomY=0 + (int) (Math.random() * sizeY);

        Wolves[] wolvesArray = new Wolves[wolvesCount];
        Rabbits[] rabbitsArray = new Rabbits[rabbitsCount];


        boolean zayacAlreadyExists = true;
        for (int i = 0; i < rabbitsCount; i++) {
            rabbitsArray[i] = new Rabbits(i, zayacRandomX, zayacRandomY, 20, true);
            //     System.out.println("САМЫЙ СТАРТОВЫЙ СТОК СТОК"+"___Х:"+zayacRandomX+"____Y:" +zayacRandomY);
            while (zayacAlreadyExists) {
                zayacRandomX = 0 + (int) (Math.random() * sizeX);
                zayacRandomY = 0 + (int) (Math.random() * sizeY);
                //  System.out.println("СТОК"+"___Х:"+zayacRandomX+"____Y:" +zayacRandomY);

                for (int j = 0; j <= i; j++) {

                    if ((zayacRandomX == rabbitsArray[j].coordX) && (zayacRandomY == rabbitsArray[j].coordY)){
                        zayacAlreadyExists=true;
                        break;
                    }  else {  zayacAlreadyExists = false;}
                    if (i == rabbitsArray.length - 1) {
                        zayacAlreadyExists = false;
                    }
                }
//                System.out.println("bool после фора: " + zayacAlreadyExists);
            }
            zayacAlreadyExists = true;

        }



        boolean wolkAlreadyExists = true;
        boolean startingWolkAlreadyExists=true;
        boolean isFound=false;
        for (int i = 0; i < wolvesCount; i++) {
            while (startingWolkAlreadyExists) {
                wolkRandomX = 0 + (int) (Math.random() * sizeX);
                wolkRandomY = 0 + (int) (Math.random() * sizeY);
                for (int z = 0; z < rabbitsArray.length; z++) {
                    if ((wolkRandomX == rabbitsArray[z].coordX) && (wolkRandomY == rabbitsArray[z].coordY)) {
                        startingWolkAlreadyExists = true;
                        break;
                    } else {
                        startingWolkAlreadyExists = false;
                    }
                }
            }

            wolvesArray[i] = new Wolves(i, wolkRandomX, wolkRandomY, 10, true);
            while (wolkAlreadyExists) {
                wolkRandomX = 0 + (int) (Math.random() * sizeX);
                wolkRandomY = 0 + (int) (Math.random() * sizeY);

                for (int j = 0; j <= i; j++) {

                    if ((wolkRandomX == wolvesArray[j].coordX) && (wolkRandomY == wolvesArray[j].coordY)){
                        wolkAlreadyExists=true;
                        isFound=true;
                        break;
                    }  else {  //wolkAlreadyExists = false;
                        isFound=false;}
                    if (i == wolvesArray.length - 1) {
                        wolkAlreadyExists = false;
                    }
                }
                if (!isFound) {
                    System.out.println(rabbitsArray.length);
                    for (int k = 0; k < rabbitsArray.length; k++) {
                        if ((wolkRandomX == rabbitsArray[k].coordX) && (wolkRandomY == rabbitsArray[k].coordY)) {
                            wolkAlreadyExists = true;
                            break;
                        } else {
                            wolkAlreadyExists=false;
                        }
                        if (k == rabbitsArray.length - 1) {
                            wolkAlreadyExists = false;
                        }
                    }
                }
            }
            wolkAlreadyExists = true;

        }




//123
//        for (int i=0; i<wolvesCount; i++){
//            System.out.println("Волк: "+i+"___X:"+wolvesArray[i].coordX + " Y:" + wolvesArray[i].coordY );
//        }
//        //  System.out.println(rabbitsArray.length);
//
//        //НУЖНОЕ
//
//        for (int i=0; i<rabbitsCount; i++){
//            System.out.println("Заяц: "+i+"___X:"+rabbitsArray[i].coordX + " Y:" + rabbitsArray[i].coordY );
//        }
        // return new Coordinates(wolvesArray, rabbitsArray);

        for (int i=0; i<fieldArray.length; i++){                     //заполнить поле звездами
            for (int j=0; j<fieldArray[i].length; j++){
                fieldArray[i][j]="*";
            }
        }

//        for (int i=0; i<fieldArray.length; i++){                     //вывести поле
//            for (int j=0; j<fieldArray[i].length; j++){
//                System.out.print(fieldArray[i][j]+"\t");
//            }
//            System.out.println("\n");
//        }



//
//        for (int i=0; i<wolvesCount; i++){
//           fieldArray[wolvesArray[i].coordX][wolvesArray[i].coordY]="В";
//        }
//
//
//        for (int j=0; j<rabbitsCount; j++){
//            fieldArray[rabbitsArray[j].coordX][rabbitsArray[j].coordY]="З";
//        }
//
//
//
//        System.out.println();
//        System.out.println();
//
//
//        for (int i=0; i<fieldArray.length; i++){                     //вывести поле
//            for (int j=0; j<fieldArray[i].length; j++){
//                System.out.print(fieldArray[i][j]+"\t");
//            }
//            System.out.println("\n");
//        }
//
//        System.out.println();
//        System.out.println();



        drawField(fieldArray, wolvesCount, rabbitsCount, rabbitsArray, wolvesArray);
        printField(fieldArray, wolvesCount, rabbitsCount, rabbitsArray, wolvesArray);
//
//        makeMoveWolf(fieldArray, wolvesCount, rabbitsCount, rabbitsArray, wolvesArray, sizeX, sizeY);
//        makeMoveRabbit(fieldArray, wolvesCount, rabbitsCount, rabbitsArray, wolvesArray, sizeX, sizeY);

     makeMove(fieldArray, wolvesCount, rabbitsCount,rabbitsArray, wolvesArray, sizeX, sizeY);

    }


    public static void drawField(String[][] fieldArray, int wolvesCount, int rabbitsCount, Rabbits[] rabbitsArray, Wolves[] wolvesArray){
        for (int i=0; i<wolvesCount; i++){
            if (wolvesArray[i].hp>0)
            fieldArray[wolvesArray[i].coordX][wolvesArray[i].coordY]="В";
            else continue;
        }


        for (int j=0; j<rabbitsArray.length; j++){
            if (rabbitsArray[j].hp>0)
            fieldArray[rabbitsArray[j].coordX][rabbitsArray[j].coordY]="З";
            else continue;
        }

    }


    public static void printField(String[][] fieldArray, int wolvesCount, int rabbitsCount, Rabbits[] rabbitsArray, Wolves[] wolvesArray){

        System.out.println();
        System.out.println();


        for (int i=0; i<fieldArray.length; i++){                     //вывести поле
            for (int j=0; j<fieldArray[i].length; j++){
                System.out.print(fieldArray[i][j]+"\t");
            }
            System.out.println("\n");
        }

        System.out.println();
        System.out.println();
    }



    public static void makeMove(String[][] fieldArray, int wolvesCount, int rabbitsCount, Rabbits[] rabbitsArray, Wolves[] wolvesArray, int sizeX, int sizeY){
        int aliveWolfCount=0;
        int aliveRabbitCount=0;

        makeMoveWolf(fieldArray, wolvesCount, rabbitsCount,rabbitsArray, wolvesArray, sizeX, sizeY);
        makeMoveRabbit(fieldArray, wolvesCount, rabbitsCount, rabbitsArray, wolvesArray, sizeX, sizeY);

     //   System.out.println(aliveRabbitCount+ "<-- rabb.length");
        for (int i = 0; i < fieldArray.length; i++) {
          //  System.out.println(fieldArray[i].length+ "<-- fieldArray.length");
            for (int j = 0; j < fieldArray[i].length; j++) {





              if (fieldArray[i][j].contains("В")){
                  aliveWolfCount++;
           //   System.out.println("КОЛВО ЖИВЫХ ВОЛКОВ: " + aliveWolfCount);

              }

//              else {
//             //    System.out.println("не нашло волка");
//              }

                if (fieldArray[i][j].equals("З")){
                    aliveRabbitCount++;
           //         System.out.println("КОЛВО ЖИВЫХ КРОЛЕЙ: " + aliveRabbitCount);
                }
//                else {
//                    //    System.out.println("не нашло зайца");
//                }
            }


        }

        printField(fieldArray, wolvesCount, rabbitsCount, rabbitsArray, wolvesArray);
     //   System.out.println(aliveWolfCount+ "<-- alive wolf count");
        if ((aliveWolfCount>0)&&(aliveRabbitCount>0)){
            makeMove(fieldArray, wolvesCount, rabbitsCount, rabbitsArray, wolvesArray, sizeX, sizeY);
            drawField(fieldArray, wolvesCount, rabbitsCount, rabbitsArray, wolvesArray);
        } else if ((aliveWolfCount>0)&&(aliveRabbitCount<=0)){
            System.out.println("Волки ПОБЕДИЛИ, зайцы ПРОИГРАЛИ");
        } else  if ((aliveRabbitCount>0)&&(aliveWolfCount<=0)){
            System.out.println("Зайцы ПОБЕДИЛИ, волки ПРОИГРАЛИ");
        } else if ((aliveWolfCount<=0)&&(aliveRabbitCount<=0)){
            System.out.println("НИЧЬЯ");
        }


    }

    public static void makeMoveWolf(String[][] fieldArray, int wolvesCount, int rabbitsCount, Rabbits[] rabbitsArray, Wolves[] wolvesArray, int sizeX, int sizeY){

       wolfDeath: for (int i=0; i<wolvesArray.length; i++) {

         drawField(fieldArray, wolvesCount, rabbitsCount, rabbitsArray, wolvesArray);
            if (wolvesArray[i].hp > 0){

                boolean cantMove = true;

            while (cantMove) {

                int tempX;
                int tempY;
                                                                                            //ЭТО ВСЕ МОЖНО БЫЛО ВЫНЕСТИ В ОТДЕЛЬНЫЙ МЕТОД, КАК И МНОГОЕ ДРУГОЕ
                                                                                            //НО ИМЕЕМ ЧТО ИМЕЕМ
                int randomDirection = 1 + (int) (Math.random() * 8);
                Direction direct;
                switch (randomDirection) {
                    case 1:
                        direct = Direction.NORTH;
                      //  System.out.println(direct);
                        break;
                    case 2:
                        direct = Direction.NORTHWEST;
                     //   System.out.println(direct);
                        break;
                    case 3:
                        direct = Direction.WEST;
                       // System.out.println(direct);
                        break;
                    case 4:
                        direct = Direction.SOUTHWEST;
                       // System.out.println(direct);
                        break;
                    case 5:
                        direct = Direction.SOUTH;
                       // System.out.println(direct);
                        break;
                    case 6:
                        direct = Direction.SOUTHEAST;
                      //  System.out.println(direct);
                        break;
                    case 7:
                        direct = Direction.EAST;
                     //   System.out.println(direct);
                        break;
                    case 8:
                        direct = Direction.NORTHEAST;
                      //  System.out.println(direct);
                        break;
                    default:
                        direct = Direction.NONE;
                    //    System.out.println(direct);
                }


                if ((!isEdgeForDirectionWolf(direct, rabbitsArray, wolvesArray, i, sizeX, sizeY)) &&
                        (!isTakenWolf(direct, rabbitsArray, wolvesArray, i, sizeX, sizeY))) {
                    tempX = wolvesArray[i].coordX;
                    tempY = wolvesArray[i].coordY;
                 //   System.out.println("СТАРОЕ ЗНАЧЕНИЕ Х:" + tempX + " старое У:" + tempY);
                    wolvesArray[i].coordX = direct.getNewXId(wolvesArray[i].coordX);
                    wolvesArray[i].coordY = direct.getNewYId(wolvesArray[i].coordY);
                 //   System.out.println("НОВОЕ ЗНАЧЕНИЕ Х:" + wolvesArray[i].coordX + " НОВОЕ У:" + wolvesArray[i].coordY);
                    fieldArray[tempX][tempY] = "*";
                  //  System.out.println("ХП ВОЛКА: " + wolvesArray[i].hp);
                   if (isKillingWolf(direct, rabbitsArray, wolvesArray, i, sizeX, sizeY)) {
                        for (int k=0; k<rabbitsArray.length; k++){
                          if ((rabbitsArray[k].coordX==wolvesArray[i].coordX)&&(rabbitsArray[k].coordY==wolvesArray[i].coordY)&&(rabbitsArray[k].hp>0)){
                              rabbitsArray[k].hp=0;
                              System.out.println("ПРОИЗОШЛО УБИЙСТВО");
                          //    System.out.println("ХП ВОЛКА ДО УБИЙСТВА: " +  wolvesArray[i].hp);
                              wolvesArray[i].hp += 2;
                          //    System.out.println("хп добавился");
                         //     System.out.println("ХП ВОЛКА ПОСЛЕ УБИЙСТВА: " +  wolvesArray[i].hp);

                          }

//                          else {
//
//                              wolvesArray[i].hp-= 1;
//
//                              System.out.println("хп отнялся внутри "  + wolvesArray[i].hp);
//                          }
                        }


                        //rabbitDeathCount++;
                    }
//                    else {
//
//                        wolvesArray[i].hp-= 1;
//
//                        System.out.println("хп отнялся снаружи  "  + wolvesArray[i].hp);
//                    }

                 //   System.out.println("хп отнялся снаружи1  "  + wolvesArray[i].hp);
                    wolvesArray[i].hp-= 1;
                 //   System.out.println("хп отнялся снаружи2  "  + wolvesArray[i].hp);
                    drawField(fieldArray, wolvesCount, rabbitsCount, rabbitsArray, wolvesArray);
                    cantMove = false;

                } else cantMove = true;

                }
           } else {
                continue wolfDeath;
                  }


        }

    }

    public static void makeMoveRabbit(String[][] fieldArray, int wolvesCount, int rabbitsCount, Rabbits[] rabbitsArray, Wolves[] wolvesArray, int sizeX, int sizeY){

        rabbitDeath: for (int i=0; i<rabbitsArray.length; i++) {
            drawField(fieldArray, wolvesCount, rabbitsCount, rabbitsArray, wolvesArray);
            if (rabbitsArray[i].hp > 0){
            boolean cantMove = true;

            while (cantMove) {

                int tempX;
                int tempY;

                int randomDirection = 1 + (int) (Math.random() * 8);
                Direction direct;
                switch (randomDirection) {
                    case 1:
                        direct = Direction.NORTH;
                      //  System.out.println(direct);
                        break;
                    case 2:
                        direct = Direction.NORTHWEST;
                    //    System.out.println(direct);
                        break;
                    case 3:
                        direct = Direction.WEST;
                   //     System.out.println(direct);
                        break;
                    case 4:
                        direct = Direction.SOUTHWEST;
                    //    System.out.println(direct);
                        break;
                    case 5:
                        direct = Direction.SOUTH;
                     //   System.out.println(direct);
                        break;
                    case 6:
                        direct = Direction.SOUTHEAST;
                    //    System.out.println(direct);
                        break;
                    case 7:
                        direct = Direction.EAST;
                    //    System.out.println(direct);
                        break;
                    case 8:
                        direct = Direction.NORTHEAST;
                     //   System.out.println(direct);
                        break;
                    default:
                        direct = Direction.NONE;
                  //      System.out.println(direct);
                }


                if ((!isEdgeForDirectionRabbit(direct, rabbitsArray, wolvesArray, i, sizeX, sizeY)) &&
                        (!isTakenByWolfToRabbit(direct, rabbitsArray, wolvesArray, i, sizeX, sizeY)) && (!isTakenRabbit(direct, rabbitsArray, wolvesArray, i, sizeX, sizeY))) {
                    tempX = rabbitsArray[i].coordX;
                    tempY = rabbitsArray[i].coordY;
               //     System.out.println("СТАРОЕ ЗНАЧЕНИЕ  Х:" + tempX + " старое У:" + tempY);
                    rabbitsArray[i].coordX = direct.getNewXId(rabbitsArray[i].coordX);
                    rabbitsArray[i].coordY = direct.getNewYId(rabbitsArray[i].coordY);
                //    System.out.println("НОВОЕ ЗНАЧЕНИЕ  Х:" + rabbitsArray[i].coordX + " НОВОЕ У:" + rabbitsArray[i].coordY);
                    fieldArray[tempX][tempY] = "*";

                 //   System.out.println("ХП КРОЛЯ: " +rabbitsArray[i].hp);
                    rabbitsArray[i].hp-=1;
                    drawField(fieldArray, wolvesCount, rabbitsCount, rabbitsArray, wolvesArray);

                    cantMove = false;
                } else cantMove = true;


            }
         //   rabbitsArray[i].hp-=1;
         } else {

                continue rabbitDeath;
            }

        }

    }




    //тут, короче говоря, можно поменять параметры входные(массивы) на Players[] array, и этот метод будет универсальным,
    // но чето стремно, я лучше по-деревенски
    public  static boolean isEdgeForDirectionWolf(Direction dir, Rabbits[] rabbitsArray, Wolves[] wolvesArray, int i, int sizeX, int sizeY )  {
      if ((dir.getNewXId(wolvesArray[i].coordX)<0)||(dir.getNewYId(wolvesArray[i].coordY)<0)||
              (dir.getNewXId(wolvesArray[i].coordX)>(sizeX-1))||(dir.getNewYId(wolvesArray[i].coordY)>(sizeY-1))){
          return true; // возвращает что это будет край

      }  else
          return false; //или нет

    }
    public  static boolean isTakenWolf(Direction dir, Rabbits[] rabbitsArray, Wolves[] wolvesArray, int i, int sizeX, int sizeY )  {

       for (int j=0; j<wolvesArray.length; j++){
           if ((dir.getNewXId(wolvesArray[i].coordX)==wolvesArray[j].coordX)&&(dir.getNewYId(wolvesArray[i].coordY)==wolvesArray[j].coordY)){

               return true; // возвращает что это занято
           }
       }
        return false;


    }

    public  static boolean isTakenByWolfToRabbit(Direction dir, Rabbits[] rabbitsArray, Wolves[] wolvesArray, int i, int sizeX, int sizeY )  {

        for (int j=0; j<wolvesArray.length; j++){
            if ((dir.getNewXId(rabbitsArray[i].coordX)==wolvesArray[j].coordX)&&(dir.getNewYId(rabbitsArray[i].coordY)==wolvesArray[j].coordY)){

                return true; // возвращает что это занято
            }
        }
        return false;


    }

    public static boolean isKillingWolf(Direction dir, Rabbits[] rabbitsArray, Wolves[] wolvesArray, int i, int sizeX, int sizeY ){
        for (int j=0; j<rabbitsArray.length; j++){
            if ((rabbitsArray[j].coordX==wolvesArray[i].coordX)&&(rabbitsArray[j].coordY==wolvesArray[i].coordY)&&(rabbitsArray[j].hp>0)){
                return true; // возвращает что ПРОИЗОЙДЕТ СМЕРТЬ ЗАЙЦА
            }
        }
        return false;
    }


    public  static boolean isEdgeForDirectionRabbit(Direction dir, Rabbits[] rabbitsArray, Wolves[] wolvesArray, int i, int sizeX, int sizeY )  {
        if ((dir.getNewXId(rabbitsArray[i].coordX)<0)||(dir.getNewYId(rabbitsArray[i].coordY)<0)||
                (dir.getNewXId(rabbitsArray[i].coordX)>(sizeX-1))||(dir.getNewYId(rabbitsArray[i].coordY)>(sizeY-1))){
            return true; // возвращает что это будет край

        }  else
            return false; //или нет

    }
    public  static boolean isTakenRabbit(Direction dir, Rabbits[] rabbitsArray, Wolves[] wolvesArray, int i, int sizeX, int sizeY )  {

        for (int j=0; j<rabbitsArray.length; j++){
            if ((dir.getNewXId(rabbitsArray[i].coordX)==rabbitsArray[j].coordX)&&(dir.getNewYId(rabbitsArray[i].coordY)==rabbitsArray[j].coordY)){

                return true; // возвращает что это занято
            }
        }
        return false;

    }


//    public static void movePlayer(String[][] fieldArray, int wolvesCount, int rabbitsCount, Rabbits[] rabbitsArray, Wolves[] wolvesArray){
//
////        Direction move;
////        for (int i=0; i<wolvesArray.length; i++) {
////            if ((wolvesArray[i].coordX==0)&&(wolvesArray[i].coordY==0)
////
////
////           int temp =  1 + (int) (Math.random() * 8);
////            temp= Integer.parseInt(String.valueOf(temp));
////            switch (temp) {
////                case 1: {
////                    for i
////                }
////
////            }
////        }
//    }


   public static void initField(int sizeX, int sizeY, int wolvesCount, int rabbitsCount){
       String[][] fieldArray = new String[sizeX][sizeY];
        initPlayers(sizeX,sizeY,wolvesCount,rabbitsCount,fieldArray);

   }


    }
