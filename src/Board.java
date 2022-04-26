import java.awt.*;

public class Board{
    public final static int LINE_THICKNESS=12;
    public final static int BOARD_START_X=75;
    public final static int BOARD_START_Y=30;
    public final static int BOARD_WIDTH_HEIGHT=720;
    public final int LINE_DISTANCE=120;

    private final CustomRectangle boardBase =new CustomRectangle(BOARD_START_X,BOARD_START_Y,BOARD_WIDTH_HEIGHT,BOARD_WIDTH_HEIGHT, Color.LIGHT_GRAY);

    private final CustomRectangle line1=new CustomRectangle(BOARD_START_X,BOARD_START_Y,BOARD_WIDTH_HEIGHT,LINE_THICKNESS,Color.gray);
    private final CustomRectangle line2=new CustomRectangle(BOARD_START_X,BOARD_START_Y+LINE_DISTANCE,BOARD_WIDTH_HEIGHT,LINE_THICKNESS,Color.gray);
    private final CustomRectangle line3=new CustomRectangle(BOARD_START_X,BOARD_START_Y+2*LINE_DISTANCE,BOARD_WIDTH_HEIGHT,LINE_THICKNESS,Color.gray);
    private final CustomRectangle line4=new CustomRectangle(BOARD_START_X,BOARD_START_Y+3*LINE_DISTANCE,BOARD_WIDTH_HEIGHT,LINE_THICKNESS,Color.gray);
    private final CustomRectangle line5=new CustomRectangle(BOARD_START_X,BOARD_START_Y+4*LINE_DISTANCE,BOARD_WIDTH_HEIGHT,LINE_THICKNESS,Color.gray);
    private final CustomRectangle line6=new CustomRectangle(BOARD_START_X,BOARD_START_Y+5*LINE_DISTANCE,BOARD_WIDTH_HEIGHT,LINE_THICKNESS,Color.gray);
    private final CustomRectangle line7=new CustomRectangle(BOARD_START_X,BOARD_START_Y+6*LINE_DISTANCE,BOARD_WIDTH_HEIGHT,LINE_THICKNESS,Color.gray);

    private final CustomRectangle line8=new CustomRectangle(BOARD_START_X+LINE_DISTANCE,BOARD_START_Y,LINE_THICKNESS,BOARD_WIDTH_HEIGHT,Color.gray);
    private final CustomRectangle line9=new CustomRectangle(BOARD_START_X+2*LINE_DISTANCE,BOARD_START_Y,LINE_THICKNESS,BOARD_WIDTH_HEIGHT,Color.gray);
    private final CustomRectangle line10=new CustomRectangle(BOARD_START_X+3*LINE_DISTANCE,BOARD_START_Y,LINE_THICKNESS,BOARD_WIDTH_HEIGHT,Color.gray);
    private final CustomRectangle line11=new CustomRectangle(BOARD_START_X+4*LINE_DISTANCE,BOARD_START_Y,LINE_THICKNESS,BOARD_WIDTH_HEIGHT,Color.gray);
    private final CustomRectangle line12=new CustomRectangle(BOARD_START_X+5*LINE_DISTANCE,BOARD_START_Y,LINE_THICKNESS,BOARD_WIDTH_HEIGHT,Color.gray);
    private final CustomRectangle line13=new CustomRectangle(BOARD_START_X,BOARD_START_Y,LINE_THICKNESS,BOARD_WIDTH_HEIGHT,Color.gray);

    private final CustomRectangle line14=new CustomRectangle(BOARD_START_X+6*LINE_DISTANCE,BOARD_START_Y,LINE_THICKNESS,BOARD_WIDTH_HEIGHT+LINE_THICKNESS,Color.gray);
    private final CustomRectangle line15=new CustomRectangle(BOARD_START_X+6*LINE_DISTANCE,BOARD_START_Y+2*LINE_DISTANCE+LINE_THICKNESS,LINE_DISTANCE*4,LINE_DISTANCE-LINE_THICKNESS,Color.white);

    private final CustomRectangle[] board =new CustomRectangle[16];

    public CustomRectangle[] getBoard() {
        board[15]=boardBase;
        board[1]=line1;
        board[2]=line2;
        board[3]=line3;
        board[4]=line4;
        board[5]=line5;
        board[6]=line6;
        board[7]=line7;
        board[8]=line8;
        board[9]=line9;
        board[10]=line10;
        board[11]=line11;
        board[12]=line12;
        board[13]=line13;
        board[14]=line14;
        board[0]=line15;

        return board;
    }
}