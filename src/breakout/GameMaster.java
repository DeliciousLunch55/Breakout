package breakout;

/* Holds the game state and manages game object simulation. */

public class GameMaster implements Runnable {
    private boolean isPaused;
    private int playerScore;
    private int playerLives;
    private int gameState;
    private BrickStructure gameBoard;
    private Ball gameBall;
    private Paddle gamePaddle;

    public GameMaster(Paddle gamePad, Ball gameBall, BrickStructure gameBoard) {
        isPaused=true;
        playerScore=0;
        playerLives=Constants.DEFAULT_PLAYER_LIVES;
        gameState=Constants.GAMESTATE_PLAYING;

        this.gamePaddle=gamePad;
        this.gameBall=gameBall;
        this.gameBoard=gameBoard;
    }

    public void run() {
        this.tickGameSimulation();
    }

    public void flipPauseState() {
        isPaused=!isPaused;
    }

    public void tickGameSimulation() {
        if(!isPaused) {
            if(gameBall.getBallY()<Constants.getWindowHeight())
            {
                gameBall.moveBall(gamePaddle);
                gameBoard.checkBrickStrCollision(gameBall);
            }else{
                if(getPlayerLives()>0) {
                    setPlayerLives(getPlayerLives()-1);
                    resetBallState();
                }else {   //This should be called only when the player loses on his last life.  Need to add lose mechanic.
                    setPlayerLives(0);
                    gameState=Constants.GAMESTATE_LOST;
                    isPaused=true;
                }
            }
        }
    }

    public void resetBallState() {
        isPaused=true;
        gameState=Constants.GAMESTATE_PLAYING;

        float tempBallY=(float)Constants.getWindowHeight()*
                ((float)Constants.DEFAULT_BALL_Y/Constants.DEFAULT_WINDOW_HEIGHT);
        this.gameBall.setBallX(Constants.getWindowWidth()/2);
        this.gameBall.setBallY((int)tempBallY);
        this.gameBall.setBallXDir(Constants.RIGHT);
        this.gameBall.setBallYDir(Constants.UP);
    }

    public void resetBallAndGame() {
        isPaused=true;
        gameState=Constants.GAMESTATE_PLAYING;

        gameBoard.resetBrickStructure();
        setPlayerLives(Constants.DEFAULT_PLAYER_LIVES);

        float tempBallY=(float)Constants.getWindowHeight()*
                ((float)Constants.DEFAULT_BALL_Y/Constants.DEFAULT_WINDOW_HEIGHT);
        this.gameBall.setBallX(Constants.getWindowWidth()/2);
        this.gameBall.setBallY((int)tempBallY);
        this.gameBall.setBallXDir(Constants.RIGHT);
        this.gameBall.setBallYDir(Constants.UP);
    }

    public void setPlayerScore(int newScore) {
        this.playerScore=newScore;
    }

    public void setPlayerLives(int newLives) {
        this.playerLives=newLives;
    }

    public boolean getPauseState() {
        return isPaused;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getPlayerLives() {
        return playerLives;
    }

    public int getGameState() {
        return gameState;
    }
}
