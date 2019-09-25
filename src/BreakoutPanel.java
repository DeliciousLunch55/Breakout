
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class BreakoutPanel extends JPanel {

    int panelWidth=this.getWidth();
    int panelHeight=this.getHeight();

    Paddle gamePad=new Paddle();
    Ball gameBall=new Ball();
    BrickStructure gameStructure=new BrickStructure();

    Timer gameLoop=new Timer(Constants.DEFAULT_REFRESH_RATE,new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            gameTick(gameBall,BreakoutPanel.this,gameStructure);
        }
    });

    InputMap im=this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    ActionMap am=this.getActionMap();

    public BreakoutPanel() {
        gameLoop.setInitialDelay(0);
        gameLoop.start();
    }

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

    public void gameTick(Ball gameBall,JPanel panel,BrickStructure gameStructure) {
        gameBall.moveBall(gamePad);
        gameStructure.checkBrickStrCollision(gameBall);

        panel.repaint();
        Toolkit.getDefaultToolkit().sync();
    }

    //This packages all component resizing into one method. Eventually it will work off of a resizing action listener,
    //instead of the repaint method in the paintComponent.
    public void resizeComponents(int newWidth,int newHeight) {
        gamePad.resizePaddle(newWidth,newHeight);
        gameBall.resizeBall(newWidth,newHeight);
        gameStructure.resizeBrickStructure(newWidth,newHeight);

        Constants.setWindowHeight(newHeight);
        Constants.setWindowWidth(newWidth);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2=(Graphics2D)g;

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                gamePad.setPaddleX(e.getX());
            }
        });

        this.setBackground(Color.BLACK);
        this.resizeComponents(this.getWidth(),this.getHeight());

        gamePad.setPaddleFillColor(Color.GREEN);
        gamePad.setPaddleDrawColor(Color.BLUE);
        gamePad.drawPaddle(g2);
        gameBall.drawBall(g2);

        gameStructure.drawBrickStr(g2);

    }
}


