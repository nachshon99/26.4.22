import javax.swing.*;

public class Main extends JFrame{

    public static final int WINDOW_WIDTH = 900;
    public static final int WINDOW_HEIGHT = 900;

    Main() {
        this.setTitle("RUSH HOUR");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        GameScene gameScene = new GameScene(this,1,false);
        this.add(gameScene);
        this.setVisible(true);
    }

    public static void main(String[] args) {
         Main main = new Main();
    }
}