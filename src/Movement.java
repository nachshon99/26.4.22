import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Movement implements MouseListener, MouseMotionListener {

    private final int MAX_CAR_SIZE = 360;
    public Component[] components;
    private int x, y;
    private Point previousPoint = new Point();
    private boolean canMove;
    boolean isWin;


    public Movement(Component... components)
    {


        canMove = true;
        for (Component component : components) {
            JPanel jPanel = (JPanel) component;
            this.components = components;
            jPanel.addMouseListener(this);
            jPanel.addMouseMotionListener(this);
        }


    }



    public void mouseDragged(MouseEvent e) {
        Rectangle endingPlace = components[components.length - 1].getBounds();// תמיד באינדקס הזה  יהיה הפאנל של הנק סיום
        Rectangle startingCar = components[0].getBounds();// תמיד באינדקס הזה  יהיה הפאנל של הנק התחלה
        final int CORRECTION = 1;
        final int MAX_X = Board.BOARD_WIDTH_HEIGHT + Board.BOARD_START_X - e.getComponent().getWidth() + CORRECTION;
        final int MAX_Y = Board.BOARD_WIDTH_HEIGHT + Board.BOARD_START_Y - e.getComponent().getHeight() + CORRECTION;
        final int MIN_X = Board.BOARD_START_X + Board.LINE_THICKNESS - CORRECTION;
        final int MIN_Y = Board.BOARD_START_Y + Board.LINE_THICKNESS - CORRECTION;


        canMove= !e.getComponent().contains((int) endingPlace.getX(),(int) endingPlace.getY());

        if (canMove) {
            if (e.getComponent().getWidth() <= MAX_CAR_SIZE && e.getComponent().getHeight() <= MAX_CAR_SIZE) {
                //בודק שהמצביע בתוך האובייקט
                collision(components, e.getComponent(), previousPoint);
                previousPoint = e.getComponent().getLocation();
                if (e.getComponent().contains(e.getPoint())) {
                    //בודק שלא עבר את מקס X
                    if (e.getComponent().getX() < MAX_X && e.getX() < MAX_X) {
                        if (e.getComponent().getX() > MIN_X) {
                            if (e.getComponent().getY() < MAX_Y && e.getY() < MAX_Y) {
                                if (e.getComponent().getY() > MIN_Y) {
                                    //יזוז רק ב-X
                                    if (e.getComponent().getWidth() > e.getComponent().getHeight()) {
                                        //יזוז רק ב-Y
                                        e.getComponent().setLocation(e.getX() + e.getComponent().getX() - x, e.getComponent().getY());
                                    } else {
                                        e.getComponent().setLocation(e.getComponent().getX(), e.getY() + e.getComponent().getY() - y);
                                    }
                                } else if (e.getY() > y) {
                                    e.getComponent().setLocation(e.getComponent().getX(), e.getY() + e.getComponent().getY() - y);
                                }
                            } else if (e.getY() < y) {
                                e.getComponent().setLocation(e.getComponent().getX(), e.getY() + e.getComponent().getY() - y);
                            }
                        } else if (e.getX() > x) {
                            e.getComponent().setLocation(e.getX() + e.getComponent().getX() - x, e.getComponent().getY());
                        }
                    } else if (e.getX() < x) {
                        e.getComponent().setLocation(e.getX() + e.getComponent().getX() - x, e.getComponent().getY());
                    }
                }
            }
            collision(components, e.getComponent(), previousPoint);
        }
        if (startingCar.intersects(endingPlace))
        {
            isWin=true;
            System.out.println("winning");

        }
    }





    public boolean collision(Component[] components, Component component, Point previousPoint)
    {

        boolean collision = false;
        int counter=0;
        for ( int i =0;i<components.length-1;i++)
        {
            Component value=components[i];
            if (value.getHeight() <= MAX_CAR_SIZE && value.getWidth() <= MAX_CAR_SIZE)
            {
                Rectangle valueRect = new Rectangle(value.getX(), value.getY(), value.getWidth(), value.getHeight());
                Rectangle componentRect = new Rectangle(component.getX(), component.getY(), component.getWidth(), component.getHeight());

                if (componentRect.intersects(valueRect))
                {

                    counter++;
                }

            }
            if (counter > 1) {
                collision = true;
                component.setLocation(previousPoint);
            }
        }


        return collision;
    }

    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {

    }

    public boolean isCanMove() {
        return canMove;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }
}