
import java.awt.Graphics;
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

    public Paddle(int initX, int initY, int width, int height) {
        this.paddleHeight=height;
        this.paddleWidth=width;
        this.paddleX=initX;
        this.paddleY=initY;
        padFillColor=Color.WHITE;
        padDrawColor=Color.WHITE;
    }

    public void drawPaddle(Graphics2D g2) {

        RoundRectangle2D pad=new RoundRectangle2D.Double(paddleX,paddleY,paddleWidth,
                paddleHeight,paddleHeight,paddleHeight);

        Color origColor=g2.getColor();
        g2.setColor(padFillColor);
        g2.fill(pad);
        g2.setColor(padDrawColor);
        g2.draw(pad);
        g2.setColor(origColor);
    }

    public void setPaddleFillColor(Color padFillColor) {
        this.padFillColor=padFillColor;
    }

    public void setPaddleDrawColor(Color padDrawColor) {
        this.padDrawColor=padDrawColor;
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

    public void setPaddleX (int newPadX) {
        this.paddleX=newPadX;
    }

    public void setPaddleY (int newPadY) {
        this.paddleY=newPadY;
    }
}
