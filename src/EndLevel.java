import javax.swing.*;
import java.awt.*;

public class EndLevel extends JPanel {
    private Car endLevel;
    private String cx;

    public EndLevel(){
        endLevel = new Car(cx,3,7, Color.black);
    }
}
