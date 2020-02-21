package breakout;
/*A basic brick that has one 'life' (will destroy after being hit one time).*/

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Rectangle2D;

public class SimpleBrick extends Brick {
    public SimpleBrick(int brickXPos, int brickYPos) {
        super();

        setBrickX(brickXPos);
        setBrickY(brickYPos);
        setBrickLife((byte)1);
    }

    @Override
    public void drawBrick(Graphics2D g2) {
        if(getBrickLife()>0) {
            Rectangle2D brick=new Rectangle2D.Float((float)getBrickX(),(float)getBrickY(),(float)getBrickWidth(),
                    (float)getBrickHeight());
            setBrickBounds(brick.getBounds());

            Color origColor=g2.getColor();
            g2.setColor(getBrickFillColor());
            g2.fill(brick);
            g2.setColor(getBrickDrawColor());
            g2.draw(brick);
            g2.setColor(origColor);
        }
    }

    @Override
    public void checkCollision(Ball gameBall) {
        if((getBrickBounds()!=null)&&(getBrickBounds().intersects(gameBall.getBallBounds()))) {
            setBrickLife((byte)0);

            Rectangle2D brickInt=gameBall.getBallBounds().createIntersection(getBrickBounds());

            //System.out.println(brickInt.toString());

            //This seems to be working roughly half of the time. For some reason, some collisions take place so far into
            //the block that this ceases to work, and the ball continues in the same direction as before collision.
            if((gameBall.getBallBounds().getY()+(gameBall.getBallBounds().getHeight()/2))<
                    (brickInt.getY()+(brickInt.getHeight()/2)) && gameBall.getBallYDir()==Constants.DOWN) {
                gameBall.setBallYDir(Constants.UP);
            }
            if((gameBall.getBallBounds().getY()+(gameBall.getBallBounds().getHeight()/2))>
                    (brickInt.getY()+(brickInt.getHeight()/2)) && gameBall.getBallYDir()==Constants.UP) {
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

            setBrickBounds(null);
        }
    }
}
