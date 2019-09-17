
import javax.swing.JFrame;

public class BreakFrame extends JFrame {
    public BreakFrame() {
        super("Super Breakout 3001");

        BreakoutPanel breakPanel=new BreakoutPanel();

        setSize(Constants.DEFAULT_WINDOW_WIDTH,Constants.DEFAULT_WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(breakPanel);

        setVisible(true);
    }
}
