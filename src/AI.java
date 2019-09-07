public class AI extends Player {

    public AI(char playerMark) {
        super(playerMark);
    }

    public void playTurn(Board board) {
        minimax(board,getMark());
    }

    private int minimax(Board board, char mark) {
        if(board.checkForWin(mark)){
            return 1;
        } else if(board.checkForWin(invertMark(mark))) {
            return -1;
        }

        int[] move = {-1,-1};
        int score = -2;

        for(int r = 0; r < board.getSize(); r++){
            for(int c = 0; c < board.getSize(); c++) {
                if (board.isSquareEmpty(r, c)) {
                    Board boardCopy = board.copy();
                    boardCopy.setSquare(r,c,mark);
                    int scoreForTheMove = -(minimax(boardCopy,invertMark(mark)));
                    if(scoreForTheMove > score) {
                        score = scoreForTheMove;
                        move[0] = r;
                        move[1] = c;
                    }
                }
            }
        }

        if(move[0] == -1) {
            return 0;
        } else {
            board.setSquare(move[0],move[1],getMark());
        }
        return score;
    }

    private char invertMark(char mark) {
        if(mark == 'X') {
            return 'O';
        } else {
            return 'X';
        }
    }
}
