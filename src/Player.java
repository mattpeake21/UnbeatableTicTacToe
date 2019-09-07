public class Player {
    private char mark;
    private int score;

    public Player(char playerMark) {
        mark = playerMark;
        score = 0;
    }

    public void playTurn(int row, int col, Board board) {
        board.setSquare(row,col,getMark());
    }

    public void increaseScore() { score++;}
    public int getScore() { return score; }
    public char getMark() { return mark; }
}
