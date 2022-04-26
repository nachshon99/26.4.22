import javax.swing.*;
import java.awt.*;

public class GameScene extends JPanel   {

    public static final int SLEEP_TIME = 15000;

    private Car[] cars;
    public Levels levels;
    private JPanel[] panels;
    private JPanel jPanel;
    public Movement mv;
    public  EndLevel endLevel;




    public GameScene (){

        levels = new Levels();
        cars = levels.getCars();
        endLevel=new EndLevel();
        mv = new Movement();
        MenuPanel menuPanel = new MenuPanel(0, 0, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);
        this.add(menuPanel);

        this.setBounds(0, 0, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);
        this.setBackground(Color.white);
        this.setLayout(null);





        Board board = new Board();


        NextLevelPanel nextLevelPanel = new NextLevelPanel(levels,mv);
        nextLevelPanel.setVisible(false);
        this.add(nextLevelPanel);

        //Next Level Panel
        Thread thread1 = new Thread(() ->
        {
            while (true) {
                if(mv.isWin){

                    nextLevelPanel.setVisible(true);
                    mv.setCanMove(false);
                    mv.isWin=false;
                }

            }
        });thread1.start();


        for (int i = 0; i < cars.length; i++) {
            panels = new JPanel[cars.length];
            jPanel = new JPanel();
            jPanel.setBackground(cars[i].getCar().getColor());
            jPanel.setSize(cars[i].getCar().getWidth(), cars[i].getCar().getHeight());
            jPanel.setLocation(cars[i].getCar().getX(), cars[i].getCar().getY());
            panels[i] = jPanel;

            this.add(jPanel);
        }
        mv = new Movement(this.getComponents());

        for (int i = 0; i < board.getBoard().length; i++) {
            JPanel panelBoard = new JPanel();
            panelBoard.setBackground(board.getBoard()[i].getColor());
            panelBoard.setSize(board.getBoard()[i].getWidth(), board.getBoard()[i].getHeight());
            panelBoard.setLocation(board.getBoard()[i].getX(), board.getBoard()[i].getY());
            this.add(panelBoard);
        }

        JButton backButton = new JButton("Back");
        backButton.setBounds(810, 700, 70, 70);
        Font backButtonFont = new Font("Arial", Font.ITALIC, 15);
        backButton.setFont(backButtonFont);
        this.add(backButton);

        backButton.addActionListener((event) -> {
            JFrame frame = new JFrame();
            if (JOptionPane.showConfirmDialog(frame, "Do you sure to Exit?", "EXIT", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                menuPanel.setVisible(true);
            }
        });

        setVisible(true);

    }





    /*public boolean endGame(Rectangle car) {
        boolean end = false;
        if (car.getX() > 400) {
            end = true;
        }
        return end;
    }*/
}

