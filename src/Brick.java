
/*This is a parent class for all brick objects.  It is not meant to be called directly. */

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import javax.swing.JPanel;

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
        brickFillColor=Color.RED;
        brickDrawColor=Color.BLUE;
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

    public Color getBrickFillColor() {
        return brickFillColor;
    }

    public Color getBrickDrawColor() {
        return brickDrawColor;
    }

    public Rectangle2D getBrickBounds() {
        return brickBounds;
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
