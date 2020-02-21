package breakout;

/*A manager class for all brick objects in play.*/

import java.awt.Graphics2D;

public class BrickStructure {

    Brick[][] brickStr=new Brick[Constants.DEFAULT_BRICK_STR_ROWS][Constants.DEFAULT_BRICK_STR_COLUMNS];
    int brickStrX=Constants.DEFAULT_BRICK_START_X;
    int brickStrY=Constants.DEFAULT_BRICK_START_Y;

    public BrickStructure() {
        for(int i=0;i<brickStr.length;i++) {
            for(int j=0;j<brickStr[i].length;j++) {
                brickStr[i][j]=new SimpleBrick(brickStrX+(j*Constants.DEFAULT_BRICK_WIDTH),
                        brickStrY+(i*Constants.DEFAULT_BRICK_HEIGHT));
            }
        }
    }

    public void resetBrickStructure() {
        for(int i=0;i<brickStr.length;i++) {
            for(int j=0;j<brickStr[i].length;j++) {
                brickStr[i][j]=new SimpleBrick(brickStrX+(j*Constants.DEFAULT_BRICK_WIDTH),
                        brickStrY+(i*Constants.DEFAULT_BRICK_HEIGHT));
            }
        }
    }

    public void resizeBrickStructure(int newWidth,int newHeight) {
        double tempBrickWidth=(double)newWidth*((double)Constants.DEFAULT_BRICK_WIDTH/Constants.DEFAULT_WINDOW_WIDTH);
        double tempBrickHeight=(double)newHeight*((double)Constants.DEFAULT_BRICK_HEIGHT/Constants.DEFAULT_WINDOW_HEIGHT);
        double tempBrickStrX=(double)newWidth*((double)Constants.DEFAULT_BRICK_START_X/Constants.DEFAULT_WINDOW_WIDTH);
        double tempBrickStrY=(double)newHeight*((double)Constants.DEFAULT_BRICK_START_Y/Constants.DEFAULT_WINDOW_HEIGHT);

        for(int i=0;i<brickStr.length;i++) {
            for(int j=0;j<brickStr[i].length;j++) {
                brickStr[i][j].setBrickWidth((int)tempBrickWidth);
                brickStr[i][j].setBrickHeight((int)tempBrickHeight);
                brickStr[i][j].setBrickX((int)tempBrickStrX+(j*(int)tempBrickWidth));
                brickStr[i][j].setBrickY((int)tempBrickStrY+(i*(int)tempBrickHeight));
            }
        }
    }

    public void drawBrickStr(Graphics2D g2) {
        for(int i=0;i<brickStr.length;i++) {
            for(int j=0;j<brickStr[i].length;j++) {
                brickStr[i][j].drawBrick(g2);
            }
        }
    }

    public void checkBrickStrCollision(Ball gameBall) {
        for(int i=0;i<brickStr.length;i++) {
            for(int j=0;j<brickStr[i].length;j++) {
                brickStr[i][j].checkCollision(gameBall);
            }
        }
    }

    public void setBrickStrX(int newX) {
        brickStrX=newX;
    }

    public void setBrickStrY(int newY) {
        brickStrY=newY;
    }

    public int getBrickStrX() {
        return brickStrX;
    }

    public int getBrickStrY() {
        return brickStrY;
    }
}
