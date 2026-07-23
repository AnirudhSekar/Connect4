public class Board {
    private String[][] board;
    private int turn;
    // Initialize the board
    public Board() {
        board = new String[6][7];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = "-";
            }
        }
        turn  = 1;
    }
    // Helper methods to manage


    // Takes in column number
    public void placePiece(int colNumber) {
        // Go through the column from bottom up
        int index = 0;
        for (int i = 0; i < 6; i++) {
            if (!board[i][colNumber].equals("-")) {
                index = i - 1;
            }
        }
        String symbol = "";
        if (turn % 2 == 1) {
            symbol = "Y";
        }
        else {
            symbol = "R";
        }
        board[index][colNumber] = symbol;
    }

    public String checkWin() {


        // Horizontal Brute Force
        for (int i = 5; i >= 0 ; i--) {
            for (int j = 6; j >= 0; j++) {
                if (board[i][j].equals(board[i][j+1]) && board[i][j+1].equals(board[i][j+2]) && board[i][j+2].equals(board[i][j+3]) && !board[i][j].equals("-")) {
                    // There is a win
                    return board[i][j];
                }
            }
        }

        // Vertical Brute force:
        for (int i = 5; i >= 3 ; i--) {
            for (int j = 6; j >=0; j++) {
                if (board[i][j].equals(board[i-1][j]) && board[i-1][j].equals(board[i-2][j]) && board[i-2][j].equals(board[i-3][j]) && !board[i][j].equals("-")) {
                    // There is a win
                    return board[i][j];
                }
            }
        }



        return "";

    }
}
