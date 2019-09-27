package breakout;

import java.awt.Color;
import java.awt.Font;

public class Constants {

    private Constants() {}


        public static void setWindowWidth(int newWidth) {
            WINDOW_WIDTH=newWidth;
        }

        public static void setWindowHeight(int newHeight) {
            WINDOW_HEIGHT=newHeight;
        }

        public static int getWindowWidth() {
            return WINDOW_WIDTH;
        }

        public static int getWindowHeight() {
            return WINDOW_HEIGHT;
        }

        public final static int DEFAULT_WINDOW_WIDTH=653;
        public final static int DEFAULT_WINDOW_HEIGHT=400;
        public final static int DEFAULT_PAINT_REFRESH_RATE=34;
        public final static int DEFAULT_SIM_REFRESH_RATE=12;

        private static int WINDOW_WIDTH=DEFAULT_WINDOW_WIDTH; //these are one iteration of window size behind during
        private static int WINDOW_HEIGHT=DEFAULT_WINDOW_HEIGHT; //resizing, so that components have a basis for their
                                                                //resizing ratio calculations
        public final static int DEFAULT_PADDLE_WIDTH=50;
        public final static int DEFAULT_PADDLE_HEIGHT=7;
        public final static int DEFAULT_PADDLE_X=30;
        public final static int DEFAULT_PADDLE_Y=DEFAULT_WINDOW_HEIGHT-30;

        public final static int DEFAULT_BALL_SIZE=5;
        public final static int DEFAULT_BALL_X=DEFAULT_WINDOW_WIDTH/2;
        public final static int DEFAULT_BALL_Y=DEFAULT_WINDOW_HEIGHT-100;
        public final static int DEFAULT_BALL_X_VELOCITY=2;
        public final static int DEFAULT_BALL_Y_VELOCITY=1;

        public final static int UP=-1;
        public final static int DOWN=1;
        public final static int RIGHT=1;
        public final static int LEFT=-1;

        public final static int DEFAULT_BRICK_STR_COLUMNS=17;
        public final static int DEFAULT_BRICK_STR_ROWS=6;

        public final static int DEFAULT_BRICK_WIDTH=33;
        public final static int DEFAULT_BRICK_HEIGHT=15;
        public final static int DEFAULT_BRICK_START_X=46;
        public final static int DEFAULT_BRICK_START_Y=45;

        public final static int DEFAULT_PLAYER_LIVES=3;

        public final static Color DEFAULT_TEXT_COLOR=Color.WHITE;
        public final static Font GENERAL_TEXT_FONT=new Font("text font",Font.TRUETYPE_FONT,12);
        public final static Font PAUSE_FONT=new Font("pause font",Font.CENTER_BASELINE,30);

        public final static int GAMESTATE_PLAYING=1;
        public final static int GAMESTATE_LOST=0;
        public final static int GAMESTATE_WON=2;

}
