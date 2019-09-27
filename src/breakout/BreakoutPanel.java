package breakout;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Timer;
import java.util.TimerTask;

public class BreakoutPanel extends JPanel implements Runnable{

    int panelWidth=this.getWidth();
    int panelHeight=this.getHeight();

    Paddle gamePad=new Paddle();
    Ball gameBall=new Ball();
    BrickStructure gameStructure=new BrickStructure();
    GameMaster gm=new GameMaster(gamePad,gameBall,gameStructure);
    InputMap im=this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    ActionMap am=this.getActionMap();

    Timer paintLoop=new Timer();
    Timer simLoop=new Timer();

    TimerTask paintTask=new TimerTask() {
        public void run() {
            try {
                SwingUtilities.invokeAndWait(BreakoutPanel.this);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    };

    TimerTask simTask=new TimerTask() {
        public void run() {
            try{
                SwingUtilities.invokeAndWait(gm);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    };


    public void start() {
        paintLoop.scheduleAtFixedRate(paintTask,0,Constants.DEFAULT_PAINT_REFRESH_RATE);
        simLoop.scheduleAtFixedRate(simTask,0,Constants.DEFAULT_SIM_REFRESH_RATE);
    }

    public void run() {   //Implements Runnable for the paint timer invokeAndWait method
        this.paintTick();
    }

    public void paintTick() {
        BreakoutPanel.this.repaint();
        Toolkit.getDefaultToolkit().sync();
    }

    public BreakoutPanel() {
        start();
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

    //This packages all component resizing into one method. Eventually it will work off of a resizing action listener,
    //instead of the repaint method in the paintComponent.
    public void resizeComponents(int newWidth,int newHeight) {
        gamePad.resizePaddle(newWidth,newHeight);
        gameBall.resizeBall(newWidth,newHeight);
        gameStructure.resizeBrickStructure(newWidth,newHeight);

        Constants.setWindowHeight(newHeight);
        Constants.setWindowWidth(newWidth);
    }

    //Draws a line of text centered in the middle of the JPanel
    public void drawCenteredString(String s, Graphics2D g2, int windowWidth, int windowHeight, Font font) {
        Font origFont=g2.getFont();
        FontMetrics fontMetrics=g2.getFontMetrics(font);

        int xStart=(windowWidth-fontMetrics.stringWidth(s))/2;
        int yStart=((windowHeight-fontMetrics.getHeight())/2)+fontMetrics.getAscent();

        g2.setFont(font);
        g2.drawString(s,xStart,yStart);
        g2.setFont(origFont);
    }

    public void drawBoardText(Graphics2D g2, GameMaster gm) {

        float lifeIndicatorSpacing=(float)Constants.getWindowWidth()*((float)20/Constants.DEFAULT_WINDOW_WIDTH);
        float lifeIndicatorHeight=Constants.getWindowHeight()-(float)Constants.getWindowHeight()*
                ((float)20/Constants.DEFAULT_WINDOW_HEIGHT);

        String scoreString=String.format("Score: %d",gm.getPlayerScore());

        Color origColor=g2.getColor();
        g2.setColor(Constants.DEFAULT_TEXT_COLOR);

        g2.setFont(Constants.GENERAL_TEXT_FONT);
        g2.drawString(scoreString,10,18);

        for(int i=0;i<gm.getPlayerLives();i++) {
            Ellipse2D lifeIndicator=new Ellipse2D.Float((int)lifeIndicatorSpacing+((int)lifeIndicatorSpacing*i),
                    (int)lifeIndicatorHeight, gameBall.getBallSize(),gameBall.getBallSize());
            g2.fill(lifeIndicator);
            g2.draw(lifeIndicator);
        }

        if(gm.getPauseState()==true) {
            drawCenteredString("GAME PAUSED",g2,Constants.getWindowWidth(),Constants.getWindowHeight(),
                    Constants.PAUSE_FONT);
        }

        g2.setColor(origColor);
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
        addKeyBinding(this,KeyEvent.VK_SPACE,"space",(e) -> gm.flipPauseState());

        this.setBackground(Color.BLACK);
        this.resizeComponents(this.getWidth(),this.getHeight());

        gamePad.drawPaddle(g2);
        gameBall.drawBall(g2);
        gameStructure.drawBrickStr(g2);

        this.drawBoardText(g2,gm);
    }
}


