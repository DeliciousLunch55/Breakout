
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Ellipse2D;

public class Ball {

    private Color fillColor;
    private Color drawColor;
    private int ballX;
    private int ballY;
    private int ballSize;

    public Ball() {
        this.ballSize=Constants.DEFAULT_BALL_SIZE;
        this.ballX=Constants.DEFAULT_BALL_X;
        this.ballY=Constants.DEFAULT_BALL_Y;
        this.fillColor=Color.WHITE;
        this.drawColor=Color.BLUE;
    }

    public Ball(int ballX, int ballY, int ballSize, Color fillColor, Color drawColor) {
        this.ballX=ballX;
        this.ballY=ballY;
        this.ballSize=ballSize;
        this.fillColor=fillColor;
        this.drawColor=drawColor;
    }

    public void drawBall(Graphics2D g2) {
        Ellipse2D.Double ball=new Ellipse2D.Double(ballX,ballY,ballSize,ballSize);

        Color origColor=g2.getColor();
        g2.setColor(fillColor);
        g2.fill(ball);
        g2.setColor(drawColor);
        g2.draw(ball);
        g2.setColor(origColor);
    }

    public void setBallX(int newX) {
        this.ballX=newX;
    }

    public void setBallY(int newY) {
        this.ballY=newY;
    }

    public void setBallSize(int newSize) {
        this.ballSize=newSize;
    }

    public void setBallFillColor(Color newFill) {
        this.fillColor=newFill;
    }

    public void setDrawColor(Color newDraw) {
        this.drawColor=newDraw;
    }

    public int getBallX() {
        return ballX;
    }

    public int getBallY() {
        return ballY;
    }

    public void resizeBall(int newWidth, int newHeight) {
        double tempBallSize=(double)newWidth*((double)Constants.DEFAULT_BALL_SIZE/Constants.DEFAULT_WINDOW_WIDTH);
        double tempBallX=(double)newWidth*((double)this.getBallX()/Constants.getWindowWidth());
        double tempBallY=(double)newHeight*((double)this.getBallY()/Constants.getWindowHeight());

        this.setBallSize((int)tempBallSize);
        this.setBallX((int)tempBallX);
        this.setBallY((int)tempBallY);
    }
}
