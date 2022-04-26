import javax.swing.*;
import java.awt.*;

public class EndLevel extends JPanel {
    public Car endLevel;
    private String cx;

    public EndLevel(){
        endLevel = new Car(cx,3,7, Color.black);
    }
}
