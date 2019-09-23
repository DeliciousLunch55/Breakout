
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

    //Need to find a way to check these in loop. During first frame the bounds don't exist, so game errors out
    // fatally on null pointer.
    public void checkCollision(Ball gameBall) {
        if(getBrickBounds().intersects(gameBall.getBallBounds())) {
            setBrickLife((byte)0);
        }
    }
}
