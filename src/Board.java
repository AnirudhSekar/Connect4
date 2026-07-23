import java.util.Scanner;

public class Board {
    private final String[][] board;
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
        colNumber = colNumber - 1;
        for (int i = 5; i >= 0; i--) {
            if (board[i][colNumber].equals("-")) {
                index = i;
                break;
            }
        }
        String symbol;
        if (turn % 2 == 1) {
            symbol = "Y";
        }
        else {
            symbol = "R";
        }
        board[index][colNumber] = symbol;
        turn++;
    }

    public String checkWin() {


        // Horizontal Brute Force
        for (int i = 0; i < 6 ; i++) {
            for (int j = 0; j < 4; j++) {
                String piece = board[i][j];
                if (piece.equals(board[i][j+1]) && piece.equals(board[i][j+2]) && piece.equals(board[i][j+3]) && !piece.equals("-")) {
                    // There is a win
                    return piece;
                }
            }
        }

        // Vertical Brute force:
        for (int i = 5; i >= 3 ; i--) {
            for (int j = 6; j >=0; j--) {
                String piece = board[i][j];

                if (piece.equals(board[i-1][j]) && piece.equals(board[i-2][j]) && piece.equals(board[i-3][j]) && !piece.equals("-")) {
                    // There is a win
                    return piece;
                }
            }
        }

        // Down Right Diag
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                String piece = board[i][j];

                if (piece.equals(board[i+1][j+1]) && piece.equals(board[i+2][j+2]) && piece.equals(board[i+3][j+3]) && !piece.equals("-")) {
                    // There is a win
                    return piece;
                }
            }
        }
        // Top Right Diag
        for (int i = 5; i >= 3; i--) {
            for (int j = 3; j >= 0; j--) {
                String piece = board[i][j];

                if (piece.equals(board[i-1][j+1]) && piece.equals(board[i-2][j+2]) && piece.equals(board[i-3][j+3]) && !piece.equals("-")) {
                    // There is a win
                    return board[i][j];
                }
            }
        }
        return "";
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (String[] strings : board) {
            result.append("\n");
            for (int c = 0; c < board[0].length; c++) {
                result.append(" ").append(strings[c]).append(" ");
            }
        }
        result.append("\n---------------------\n 1  2  3  4  5  6  7  ");
        return result.toString();
    }

    static void main() {
        Board board1 = new Board();
        Scanner scanner = new Scanner(System.in);
        boolean hasWinner = false;
        String winner = "";
        while (!hasWinner) {
            System.out.println("Current State of the Board: ");
            System.out.println(board1);
            System.out.println("Pick a column to place your piece! ");
            int column = scanner.nextInt();
            board1.placePiece(column);
            winner = board1.checkWin();
            if (!winner.isEmpty()) {
                // Winner found
                hasWinner = true;
            }
        }
        System.out.println(board1);
        System.out.println("WE HAVE A WINNER!!!");
        System.out.println("The winner was: " + winner + "!" );


    }
}

