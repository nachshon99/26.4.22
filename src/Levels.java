import java.awt.*;

public class Levels extends Level{
    public static final int LEVEL_1 = 1;
    public static final int LEVEL_2 = 2;

    public int level;

   public Levels(int level)
    {
        endLevel = new Car(END_LEVEL,3,6,Color.BLACK);
            switch (level) {
                case LEVEL_1 -> {
                    level1();
                }
                case LEVEL_2 -> {
                    level2();
                }
            }

    }
    public void level1(){
        xCar = new Car(CX,3,2,Color.red);
        aCar = new Car(CX,1,1,Color.green);
        bCar = new Car(CY,5,1,Color.orange);
        cCar = new Car(CX,5,5,Color.cyan);
        oTruck = new Car(TY,1,6,Color.yellow);
        pTruck = new Car(TY,2,1,Color.magenta);
        qTruck = new Car(TY,2,4,Color.blue);
        rTruck = new Car(TX,6,3,Color.green);

        setCars(new Car[]{xCar, aCar, bCar, cCar, oTruck, pTruck, qTruck, rTruck,endLevel});
    }
    public void level2(){
        xCar=new Car(CX,3,1, Color.red);
        aCar=new Car(CY,1,1,Color.green);
        bCar=new Car(CY,2,4,Color.orange);
        cCar=new Car(CY,3,5,Color.cyan);
        dCar=new Car(CY,5,3,Color.pink);
        eCar=new Car(CX,5,5,Color.magenta);
        fCar=new Car(CX,6,1,Color.green);
        gCar=new Car(CX,6,4,Color.black);
        oTruck=new Car(TX,1,4,Color.yellow);
        pTruck=new Car(TY,2,6,Color.magenta);
        qTruck=new Car(TX,4,1,Color.blue);

        setCars(new Car[]{xCar, aCar,bCar, cCar, dCar, eCar, fCar, gCar, oTruck, pTruck, qTruck,endLevel});
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}