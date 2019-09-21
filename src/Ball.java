
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Ellipse2D;

public class Ball {

    private Color fillColor;
    private Color drawColor;
    private int ballX;
    private int ballY;
    private int ballXVel;
    private int ballYVel;
    private int ballXDirection=1;
    private int ballYDirection=-1;
    private int ballSize;

    public Ball() {
        this.ballSize=Constants.DEFAULT_BALL_SIZE;
        this.ballX=Constants.DEFAULT_BALL_X;
        this.ballY=Constants.DEFAULT_BALL_Y;
        this.ballXVel=Constants.DEFAULT_BALL_X_VELOCITY;
        this.ballYVel=Constants.DEFAULT_BALL_Y_VELOCITY;
        this.fillColor=Color.WHITE;
        this.drawColor=Color.BLUE;
    }

    public Ball(int ballX, int ballY, int ballXVel, int ballYVel, int ballSize, Color fillColor, Color drawColor) {
        this.ballX=ballX;
        this.ballY=ballY;
        this.ballXVel=ballXVel;
        this.ballYVel=ballYVel;
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

    public void setBallXVel(int newVel) {
        this.ballXVel=newVel;
    }

    public void setBallYVel(int newVel) {
        this.ballYVel=newVel;
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

    public int getBallSize() {
        return ballSize;
    }

    public int getBallX() {
        return ballX;
    }

    public int getBallY() {
        return ballY;
    }

    public int getBallXVel() {
        return ballXVel;
    }

    public int getBallYVel() {
        return ballYVel;
    }

    public void moveBall(Paddle paddle) {
        //First, check for wall collisions
        if(this.getBallX()+this.getBallSize()>=Constants.getWindowWidth()||this.getBallX()<=0) {
            ballXDirection=ballXDirection*-1;
        }

        //THIS WILL NEED TO CHANGE ONCE WIN/LOSE CONDITION IS IMPLEMENTED (BALL SHOULD FALL OFF OF BOTTOM OF SCREEN)
        if(this.getBallY()+this.getBallSize()>=Constants.getWindowHeight()||this.getBallY()<=0) {
            ballYDirection=ballYDirection*-1;
        }

        //TO ADD, CHECK FOR PADDLE COLLISION__REPLACE THIS WITH RECTANGLE2D INTERSECT CHECKING
        if(this.getBallX()>=(paddle.getPaddleX()-paddle.getPaddleWidth()/2)&&
                (this.getBallX()+this.getBallSize())<=(paddle.getPaddleX()+paddle.getPaddleWidth()-(paddle.getPaddleWidth()/2))) {
            if((this.getBallY()+this.getBallSize())>=paddle.getPaddleY()&&
                    (this.getBallY()+this.getBallSize())<=(paddle.getPaddleY()+paddle.getPaddleHeight()) &&
                        ballYDirection==1) {
                ballYDirection=-1;
            }
        }

        //Increments balls position one interval of velocity
        this.setBallX(this.getBallX()+(this.getBallXVel()*ballXDirection));
        this.setBallY(this.getBallY()+(this.getBallYVel()*ballYDirection));
    }

    public void resizeBall(int newWidth, int newHeight) {
        double tempBallSize=(double)newWidth*((double)Constants.DEFAULT_BALL_SIZE/Constants.DEFAULT_WINDOW_WIDTH);
        double tempBallX=(double)newWidth*((double)this.getBallX()/Constants.getWindowWidth());
        double tempBallY=(double)newHeight*((double)this.getBallY()/Constants.getWindowHeight());
        double tempXVel=(double)newWidth*((double)Constants.DEFAULT_BALL_X_VELOCITY/Constants.DEFAULT_WINDOW_WIDTH);
        double tempYVel=(double)newWidth*((double)Constants.DEFAULT_BALL_Y_VELOCITY/Constants.DEFAULT_WINDOW_HEIGHT);

        this.setBallSize((int)tempBallSize);
        this.setBallX((int)tempBallX);
        this.setBallY((int)tempBallY);
        this.setBallXVel((int)tempXVel);
        this.setBallYVel((int)tempYVel);
    }
}
