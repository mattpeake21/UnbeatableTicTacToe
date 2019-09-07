import java.util.concurrent.TimeUnit;

public class Game {
    private Board board;

    // Game States
    private boolean gameOver = false;
    private boolean draw = false;
    private boolean win = false;
    private char winMark = ' ';

    private Player player;
    private AI ai;

    public Game() {
        board = new Board();

        // Random Mark Allocation
        if(Math.random() * 2 <= 1){
            player = new Player('O');
            ai = new AI('X');
        } else {
            player = new Player('X');
            ai = new AI('O');
        }

        newRound();
    }

    public void newRound() {
        board.reset();

        // Reset Conditions
        gameOver = false;
        draw = false;
        win = false;
        winMark = ' ';

        // 50% Chance AI Plays First
        if(Math.random() * 2 <= 1){
            ai.playTurn(board);
        }
    }

    public void setDraw() {
        gameOver = true;
        draw = true;
    }

    public void setWin(Player winner) {
        gameOver = true;
        win = true;
        winMark = winner.getMark();
        winner.increaseScore();
    }

    public boolean isOver() { return gameOver; }
    public boolean isDraw() { return draw; }
    public boolean isWin() { return win; }

    public char getWinMark() { return winMark; }

    public Board getBoard() { return board; }
    public Player getPlayer() { return player; }
    public AI getAI() { return ai; }
}
