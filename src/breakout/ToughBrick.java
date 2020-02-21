package breakout;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Rectangle2D;

public class ToughBrick extends Brick {

    private Color textColor=Color.WHITE;

    public ToughBrick(int xPos, int yPos) {
        super();
        setBrickX(xPos);
        setBrickY(yPos);
        setBrickLife((byte)2);
    }

    public ToughBrick(int xPos, int yPos, int lives) {
        super();
        setBrickX(xPos);
        setBrickY(yPos);
        setBrickLife((byte)lives);
    }

    @Override
    public void drawBrick(Graphics2D g2) {
        if(getBrickLife()>0) {

            Rectangle2D brick=new Rectangle2D.Float((float)getBrickX(),(float)getBrickY(),
                    (float)getBrickWidth(),(float)getBrickHeight());
            setBrickBounds(brick.getBounds());

            Color origColor=g2.getColor();
            g2.setColor(getBrickFillColor());
            g2.fill(brick);
            g2.setColor(getBrickDrawColor());
            g2.draw(brick);

            if(getBrickLife()>1) {
                String life=String.format("%d",getBrickLife());
                //g2.setFont(new Font("Arial",Font.CENTER_BASELINE,5));

                g2.setColor(getTextColor());
                g2.drawString(life,getBrickX()+(getBrickWidth()/2),getBrickY()+(getBrickHeight()/2));
            }
            g2.setColor(origColor);
        }
    }

    //I believe this works, but since it's checking for collision at every paint instance, it detects multiple collisions
    //every time a collision takes place
    @Override
    public void checkCollision(Ball gameBall) {
        if((getBrickBounds()!=null)&&(getBrickBounds().intersects(gameBall.getBallBounds()))) {

            setBrickLife(((byte)(getBrickLife()-1)));
            Rectangle2D brickInt=gameBall.getBallBounds().createIntersection(getBrickBounds());

            //System.out.println(brickInt.toString());

            //This seems to be working roughly half of the time. For some reason, some collisions take place so far into
            //the block that this ceases to work, and the ball continues in the same direction as before collision.
            if((gameBall.getBallBounds().getY()+(gameBall.getBallBounds().getHeight()/2))<
                    (brickInt.getY()+(brickInt.getHeight()/2))) {
                gameBall.setBallYDir(Constants.UP);
            }
            if((gameBall.getBallBounds().getY()+(gameBall.getBallBounds().getHeight()/2))>
                    (brickInt.getY()+(brickInt.getHeight()/2))) {
                gameBall.setBallYDir(Constants.DOWN);
            }
            if(gameBall.getBallBounds().getX()+(gameBall.getBallBounds().getWidth()/2)<
                    (brickInt.getX()+(brickInt.getWidth()/2))) {
                gameBall.setBallXDir(Constants.LEFT);
            }
            if(gameBall.getBallBounds().getX()+(gameBall.getBallBounds().getWidth()/2)>
                    (brickInt.getX()+(brickInt.getWidth()/2))) {
                gameBall.setBallXDir(Constants.RIGHT);
            }

            if(!(getBrickLife()>1)) {
                setBrickBounds(null);
            }
        }
    }

    public Color getTextColor() {
        return textColor;
    }
    public void setTextColor(Color newTextColor) {
        this.textColor=newTextColor;
    }
}
