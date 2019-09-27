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
            gameBall.moveBall(gamePaddle);
            gameBoard.checkBrickStrCollision(gameBall);
        }
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
}
