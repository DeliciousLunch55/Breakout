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

        public final static int DEFAULT_WINDOW_WIDTH=600;
        public final static int DEFAULT_WINDOW_HEIGHT=400;

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
}
