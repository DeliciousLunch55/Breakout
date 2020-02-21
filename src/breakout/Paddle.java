package breakout;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.Rectangle2D;

public class Paddle {

    private int paddleHeight;
    private int paddleWidth;
    private int paddleX;
    private int paddleY;
    private Color padFillColor;
    private Color padDrawColor;
    private Rectangle2D paddleBounds;

    public Paddle() {
        this.paddleHeight=Constants.DEFAULT_PADDLE_HEIGHT;
        this.paddleWidth=Constants.DEFAULT_PADDLE_WIDTH;
        this.paddleX=Constants.DEFAULT_PADDLE_X;
        this.paddleY=Constants.DEFAULT_PADDLE_Y;
        this.padFillColor=Color.GREEN;
        this.padDrawColor=Color.BLUE;
    }

    public Paddle(int initX, int initY, int width, int height, Color fillColor, Color drawColor) {
        this.paddleHeight=height;
        this.paddleWidth=width;
        this.paddleX=initX;
        this.paddleY=initY;
        this.padFillColor=fillColor;
        this.padDrawColor=drawColor;
    }

    public void drawPaddle(Graphics2D g2) {

        RoundRectangle2D pad=new RoundRectangle2D.Double(paddleX-paddleWidth/2,paddleY,paddleWidth,
                paddleHeight,paddleHeight,paddleHeight);

        paddleBounds=pad.getBounds();

        Color origColor=g2.getColor();
        g2.setColor(padFillColor);
        g2.fill(pad);
        g2.setColor(padDrawColor);
        g2.draw(pad);
        g2.setColor(origColor);
    }

    public int getPaddleX() {
        return paddleX;
    }

    public int getPaddleY() {
        return paddleY;
    }

    public int getPaddleWidth() {
        return paddleWidth;
    }

    public int getPaddleHeight() {
        return paddleHeight;
    }

    public Rectangle2D getPaddleBounds() {
        return paddleBounds;
    }

    //Checks for collision with JPanel walls, and sets the paddle based off of result and method parameters.
    public void setPaddleX (int newPadX) {
        if((newPadX>paddleWidth/2)&&(newPadX+(this.getPaddleWidth()/2)<Constants.getWindowWidth())) {
            this.paddleX=newPadX;
        }else if(newPadX+(this.getPaddleWidth()/2)>=Constants.getWindowWidth()) {
            this.paddleX=Constants.getWindowWidth()-(this.getPaddleWidth()/2);
        }else if(newPadX<=(this.getPaddleWidth()/2)) {
            this.paddleX=this.getPaddleWidth()/2;
        }
    }

    public void setPaddleY (int newPadY) {
        this.paddleY=newPadY;
    }

    public void setPaddleFillColor(Color padFillColor) {
        this.padFillColor=padFillColor;
    }

    public void setPaddleDrawColor(Color padDrawColor) {
        this.padDrawColor=padDrawColor;
    }

    public void setPaddleWidth(int newWidth) {
        this.paddleWidth=newWidth;
    }

    public void setPaddleHeight(int newHeight) {
        this.paddleHeight=newHeight;
    }

    public void resizePaddle(int newWidth, int newHeight) {
        double tempPaddleWidth=(double)newWidth*((double)Constants.DEFAULT_PADDLE_WIDTH/Constants.DEFAULT_WINDOW_WIDTH);
        double tempPaddleHeight=(double)newHeight*((double)Constants.DEFAULT_PADDLE_HEIGHT/
                Constants.DEFAULT_WINDOW_HEIGHT);
        double tempPaddleX=(double)this.getPaddleX()*((double)newWidth/Constants.getWindowWidth());
        double tempPaddleY=(double)newHeight*((double)Constants.DEFAULT_PADDLE_Y/Constants.DEFAULT_WINDOW_HEIGHT);

        this.setPaddleWidth((int)tempPaddleWidth);
        this.setPaddleHeight((int)tempPaddleHeight);
        this.setPaddleX((int)tempPaddleX);
        this.setPaddleY((int)tempPaddleY);
    }
}
