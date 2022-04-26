import javax.swing.*;

public abstract class Level extends JFrame {

    public final String CX ="xCar";
    public final String CY ="yCar";
    public final String TX ="xTruck";
    public final String TY ="yTruck";
    public final String END_LEVEL = "endLevel";

    protected Car endLevel;

    protected Car xCar;
    protected Car aCar;
    protected Car bCar;
    protected Car cCar;
    protected Car dCar;
    protected Car eCar;
    protected Car fCar;
    protected Car gCar;
    protected Car hCar;
    protected Car iCar;
    protected Car jCar;
    protected Car kCar;
    protected Car oTruck;
    protected Car pTruck;
    protected Car qTruck;
    protected Car rTruck;

    public Car[] cars;

    public Car[] getCars()
    {
        return cars;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }

    public Car getxCar() {
        return xCar;
    }

}
