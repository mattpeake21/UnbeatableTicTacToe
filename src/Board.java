public class Board implements Cloneable {
    char[][] board;
    private int boardSize = 3;

    public Board(){
        reset();
    }

    public Board copy() {
        Board cloneBoard = new Board();
        for(int row = 0; row < boardSize; row++) {
            for(int col = 0; col < boardSize; col++){
                cloneBoard.setSquare(row,col,board[row][col]);
            }
        }
        return cloneBoard;
    }

    public void reset() {
        board = new char[boardSize][boardSize];

        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board.length; c++) {
                board[r][c] = ' ';
            }
        }
    }

    public char getSquare(int row, int col) { return board[row][col]; }
    public void setSquare(int row, int col, char mark) { board[row][col] = mark; }
    public boolean isSquareEmpty(int row, int col) {
        char square = getSquare(row,col);

        if(square == ' '){
            return true;
        }

        return false;
    }

    public boolean isFull() {
        int emptyCount = 0;

        for(int row = 0; row < boardSize; row++) {
            for(int col = 0; col < boardSize; col++){
                if(isSquareEmpty(row,col)){
                    emptyCount++;
                }
            }
        }

        if(emptyCount == 0) {
            return true;
        }
        return false;
    }

    public boolean checkForWin(char mark) {
        if(checkRowsForWin(mark)) {
            return true;
        } else if(checkColumnsForWin(mark)) {
            return true;
        } else if(checkDiagonalsForWin(mark)) {
            return true;
        }
        return false;
    }

    private boolean checkRowsForWin(char mark) {
        for(int r = 0; r < boardSize; r++){
            if(mark == board[r][0] && board[r][0] == board[r][1] && board[r][1] == board[r][2]){
                return true;
            }
        }
        return false;
    }

    private boolean checkColumnsForWin(char mark) {
        for(int c = 0; c < boardSize; c++){
            if(mark == board[0][c] && board[0][c] == board[1][c] && board[1][c] == board[2][c]){
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalsForWin(char mark) {
        if(mark == board[0][0] && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        } else if (mark == board[0][2] && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }



    public int getSize() { return boardSize; }
}
