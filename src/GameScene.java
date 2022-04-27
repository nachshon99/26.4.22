import javax.swing.*;
import java.awt.*;

public class GameScene extends JPanel implements  Runnable {


    Thread mainLoop;
    public MenuPanel menuPanel;
    public Car[] cars;
    public Levels levels;
    public JPanel[] panels;
    public JPanel jPanel;
    public Movement mv;
    public EndLevel endLevel;
    public NextLevelPanel nextLevelPanel;
    public Board board;
    public Main main;
    public boolean changeLevel;
    public int levelNum;
    boolean isNewLevel;




    public GameScene(Main main,int levelNum,boolean isNewLevel){

        this.menuPanel =new MenuPanel(0, 0, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);
        this.levelNum=levelNum;
        this.main=main;
        this.levels = new Levels(levelNum);
        this.cars = levels.getCars();
        this.endLevel=new EndLevel();
        mv = new Movement();
        MenuPanel menuPanel = new MenuPanel(0, 0, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);
        this.add(menuPanel);
        this.setBounds(0, 0, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);
        this.setBackground(Color.white);
        this.setLayout(null);

        NextLevelPanel nextLevelPanel = new NextLevelPanel(levels,mv,this);
        this.nextLevelPanel=nextLevelPanel;
        nextLevelPanel.setVisible(false);
        this.add(nextLevelPanel);
        this.getPanels();
        this.getBoard();

        this.startMainLoop();

        mv = new Movement(panels);
        this.menuPanel();

        menuPanel.setVisible(!isNewLevel);
        //אם זה לבל חדש הוא לא מציג את הפאנל של התפריט הראשי



        setVisible(true);

    }

    public void menuPanel()
    {
        JButton backButton = new JButton("Back");
        backButton.setBounds(810, 700, 70, 70);
        Font backButtonFont = new Font("Arial", Font.ITALIC, 15);
        backButton.setFont(backButtonFont);
        this.add(backButton);
        backButton.addActionListener((event) ->
        {
            JFrame frame = new JFrame();
            if (JOptionPane.showConfirmDialog(frame, "Are you sure that you want to exit?", "EXIT", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                menuPanel.setVisible(true);
            }
        });
    }



    public void getBoard()
    {
        this.board=new Board();
        for (int i = 0; i < board.getBoard().length; i++)
        {
            JPanel panelBoard = new JPanel();
            panelBoard.setBackground(board.getBoard()[i].getColor());
            panelBoard.setSize(board.getBoard()[i].getWidth(), board.getBoard()[i].getHeight());
            panelBoard.setLocation(board.getBoard()[i].getX(), board.getBoard()[i].getY());
            this.add(panelBoard);
        }
    }


    public void getPanels()
    {
        this.panels = new JPanel[cars.length];
        for (int i = 0; i < cars.length; i++)
        {
            this.jPanel = new JPanel();
            this.jPanel.setBackground(cars[i].getCar().getColor());
            this.jPanel.setSize(cars[i].getCar().getWidth(), cars[i].getCar().getHeight());
            this.jPanel.setLocation(cars[i].getCar().getX(), cars[i].getCar().getY());
            this.panels[i] = jPanel;
            this.add(jPanel);
        }
    }


    public void  startMainLoop()
    //מתחיל את המיין לופ של המשחק
    {
        mainLoop=new Thread(this);
        mainLoop.start();
    }

    public  void update()
    {


        if (mv.isWin)
        {
            nextLevelPanel.setVisible(true);
            mv.setCanMove(false);
            mv.isWin=false;

        }
        if (changeLevel) {
            this.changeLevel();
        }


    }



    public void changeLevel()
    {

        this.isNewLevel=true;
        this.setVisible(false);
        this.levelNum++;
        GameScene gameScene=new GameScene(main,levelNum,isNewLevel);
        main.add(gameScene);
        changeLevel=false;
    }

    public void run()
            //מחשב את כמות הפריימים בשניה ומחשב כמה פעמים בשניה לקרוא ל-update ול repaint
    {
        int _FPS = 60;
        double drawInterval=1000000000/ _FPS; //0.016666
        double delta=0;
        long lastTime=System.nanoTime();
        long currentTime;
        long timer=0;
        int drawCount=0;// כמה פעמים בשניה הוא יצייר
        while(mainLoop!=null) {
            currentTime=System.nanoTime();
            delta+=(currentTime-lastTime)/drawInterval;
            timer+=(currentTime-lastTime);
            lastTime=currentTime;

            if(delta>=1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer>=1000000000)
            {
                //System.out.println("FPS :" + drawCount);
                drawCount=0;
                timer=0;
            }
        }
    }

}

