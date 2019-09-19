
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BreakoutPanel extends JPanel {

    int panelWidth=this.getWidth();
    int panelHeight=this.getHeight();

    Paddle gamePad=new Paddle();
    Ball gameBall=new Ball();

    InputMap im=this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    ActionMap am=this.getActionMap();

    public void addKeyBinding(JComponent comp, int keyCode, String id, ActionListener actionListener) {
        InputMap im=comp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am=comp.getActionMap();
        im.put(KeyStroke.getKeyStroke(keyCode,0,false),id);
        am.put(id, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionListener.actionPerformed(e);
            }
        });
    }

    //This packages all component resizing into one method. Eventually it will work off of a resizing action listener,
    //instead of the repaint method in the paint component.
    public void resizeComponents(int newWidth,int newHeight) {
        gamePad.resizePaddle(newWidth,newHeight);  //works great when aspect ratio is maintained, but if increase height
        gameBall.resizeBall(newWidth,newHeight);  //by itself, the ratio is fatally thrown off. Maybe maintain aspect somehow?
        Constants.setWindowHeight(newHeight);
        Constants.setWindowWidth(newWidth);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2=(Graphics2D)g;

        addKeyBinding(this,KeyEvent.VK_D,"padRight", (evt)-> {
            gamePad.setPaddleX(gamePad.getPaddleX()+10);
            repaint();
        });
        addKeyBinding(this,KeyEvent.VK_A,"padLeft",(evt)-> {
            gamePad.setPaddleX(gamePad.getPaddleX()-10);
            repaint();
        });
        addKeyBinding(this,KeyEvent.VK_W,"padUp",(evt)-> {
            gamePad.setPaddleY(gamePad.getPaddleY()-10);
            repaint();
        });
        addKeyBinding(this,KeyEvent.VK_S,"padDown",(evt)-> {
            gamePad.setPaddleY(gamePad.getPaddleY()+10);
            repaint();
        });

        this.setBackground(Color.BLACK);

        this.resizeComponents(this.getWidth(),this.getHeight());
        gamePad.setPaddleFillColor(Color.GREEN);
        gamePad.setPaddleDrawColor(Color.BLUE);
        gamePad.drawPaddle(g2);
        gameBall.drawBall(g2);

    }
}
