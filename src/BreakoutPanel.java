
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class BreakoutPanel extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2=(Graphics2D)g;

        int panelWidth=this.getWidth();
        int panelHeight=this.getHeight();

        this.setBackground(Color.BLACK);

        Paddle gamePad=new Paddle(20,panelHeight-40,Constants.PADDLE_WIDTH,Constants.PADDLE_HEIGHT);

        gamePad.setPaddleFillColor(Color.GREEN);
        gamePad.setPaddleDrawColor(Color.BLUE);
        gamePad.drawPaddle(g2);


    }
}
