package breakout;
/*This is a parent class for all brick objects.  It is not meant to be called directly. */

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;

public class Brick {
    private int brickXPos;
    private int brickYPos;
    private byte brickLifeCounter;
    private int brickWidth;
    private int brickHeight;
    private Color brickFillColor;
    private Color brickDrawColor;
    private Rectangle2D brickBounds;

    public Brick() {
        brickWidth=Constants.DEFAULT_BRICK_WIDTH;
        brickHeight=Constants.DEFAULT_BRICK_HEIGHT;
        brickFillColor=Color.BLUE;
        brickDrawColor=Color.BLACK;
    }

    public int getBrickX() {
        return brickXPos;
    }

    public int getBrickY() {
        return brickYPos;
    }

    public int getBrickWidth() {
        return brickWidth;
    }

    public int getBrickHeight() {
        return brickHeight;
    }

    public byte getBrickLife() {
        return brickLifeCounter;
    }

    public void drawBrick(Graphics2D g2) {
        if(getBrickLife()>0) {
            Rectangle2D brick = new Rectangle2D.Float((float) getBrickX(), (float) getBrickY(), (float) getBrickWidth(),
                    (float) getBrickHeight());
            setBrickBounds(brick.getBounds());

            Color origColor = g2.getColor();
            g2.setColor(getBrickFillColor());
            g2.fill(brick);
            g2.setColor(getBrickDrawColor());
            g2.draw(brick);
            g2.setColor(origColor);
        }
    }

    //ADD DEFAULT CHECK COLLISION FUNCTIONALITY
    public void checkCollision(Ball gameBall) {

    }

    public Color getBrickFillColor() {
        return brickFillColor;
    }

    public Color getBrickDrawColor() {
        return brickDrawColor;
    }

    public Rectangle2D getBrickBounds() {
        return brickBounds;
    }

    public void resizeBrick(int newWinWidth,int newWinHeight) {
        double tempNewHeight=(double)newWinHeight*((double)Constants.DEFAULT_BRICK_HEIGHT/
                Constants.DEFAULT_WINDOW_HEIGHT);
        double tempNewWidth=(double)newWinWidth*((double)Constants.DEFAULT_BRICK_WIDTH/Constants.DEFAULT_WINDOW_WIDTH);
        double tempBrickX=(double)newWinWidth*((double)getBrickX()/Constants.getWindowWidth());
        double tempBrickY=(double)newWinHeight*((double)getBrickY()/Constants.getWindowHeight());

        setBrickWidth((int)tempNewWidth);
        setBrickHeight((int)tempNewHeight);
        setBrickX((int)tempBrickX);
        setBrickY((int)tempBrickY);
    }

    public void setBrickX(int newX) {
        brickXPos=newX;
    }

    public void setBrickY(int newY) {
        brickYPos=newY;
    }

    public void setBrickWidth(int newWidth) {
        brickWidth=newWidth;
    }

    public void setBrickHeight(int newHeight) {
        brickHeight=newHeight;
    }

    public void setBrickLife(byte lifeCount) {
        brickLifeCounter=lifeCount;
    }

    public void setBrickFillColor(Color fillColor) {
        brickFillColor=fillColor;
    }

    public void setBrickDrawColor(Color drawColor) {
        brickDrawColor=drawColor;
    }

    public void setBrickBounds(Rectangle2D bounds) {
        brickBounds=bounds;
    }
}
