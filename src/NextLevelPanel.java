import javax.swing.*;
import java.awt.*;

public class NextLevelPanel extends JPanel
{
    public boolean nextLevel;


    public NextLevelPanel(Levels level,Movement movement){



        this.setBounds(Main.WINDOW_WIDTH/4,Main.WINDOW_HEIGHT/3,500,250);
        this.setBackground(Color.gray);
        this.setLayout(null);
        this.setDoubleBuffered(true);

        JLabel title = new JLabel("You Win!");
        title.setBounds(150,50,250,50);
        Font titleButtonFont = new Font("Arial", Font.ITALIC, 50);
        title.setFont(titleButtonFont);
        this.add(title);

        JButton nextLevelButton = new JButton("Next");
        nextLevelButton.setBounds(50,150,150,70);
        nextLevelButton.addActionListener((event) ->
        {

            int nextLv = 1 + level.getLevel();
            level.setLevel(nextLv);
            movement.setCanMove(true);
            this.setVisible(false);
        });
        this.add(nextLevelButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(300,150,150,70);
        exitButton.addActionListener((event) -> {
            System.exit(0);
        });
        this.add(exitButton);

    }
}
