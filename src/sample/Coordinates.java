package sample;

public class Coordinates {
    private Wolves[] wolvesArray;
    private Rabbits[] rabbitsArray;


    public Coordinates(Wolves[] wolvesArray, Rabbits[] rabbitsArray) {
        this.wolvesArray = wolvesArray;
        this.rabbitsArray = rabbitsArray;
    }


    public Wolves[] getWolvesArray() {
        return wolvesArray;
    }

    public Rabbits[] getRabbitsArray() {
        return rabbitsArray;
    }

    public int getWolvesPosX(int id) {
        int posX = wolvesArray[id].coordX;
        return posX;
    }

    public int getWolvesPosY(int id) {
        int posY = wolvesArray[id].coordY;
        return posY;
    }
}
