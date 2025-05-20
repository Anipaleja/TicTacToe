package tictactoe;
import java.util.Scanner;

public class Summative {
    public static void main(String[] args) {
        // Tic Tac Toe game
        Scanner sc = new Scanner(System.in);
        String[][] board = new String[3][3];
        
        // Initialize the board with empty spaces
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                board[r][c] = " ";
            }
        }

        System.out.println("Hello! I am AnishBot 3000! I will be your assistant today.");
        System.out.println("Welcome to Tic Tac Toe!");
        
        boolean gameOn = true;
        String currentPlayer = "X"; // Start with player X

        while (gameOn) {
            // Display the board
            System.out.println("Here is the current board:");
            for (int r = 0; r < board.length; r++) {
                for (int c = 0; c < board[r].length; c++) {
                    System.out.print(board[r][c]);
                    if (c < board[r].length - 1) System.out.print(" | ");
                }
                System.out.println();
                if (r < board.length - 1) System.out.println("--+---+--");
            }

            // Ask the current player for their move
            System.out.println("Player " + currentPlayer + ", enter your move (row and column, e.g., 1 2): ");
            int row = sc.nextInt() - 1; // Convert to 0 basrd index
            int col = sc.nextInt() - 1; // Convert to 0 based index

            // Check if the move is vakid
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col].equals(" ")) {
                board[row][col] = currentPlayer; // Place the player's mark
                // Check for a winner or a draw
                if (checkWinner(board, currentPlayer)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameOn = false;
                } else if (isBoardFull(board)) {
                    System.out.println("It's a draw!");
                    gameOn = false;
                } else {
                    // Switch to the other player
                    currentPlayer = currentPlayer.equals("X") ? "O" : "X";
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        System.out.println("Game over!");
    }

    // Method to check if the current player has won
    public static boolean checkWinner(String[][] board, String player) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) return true;
            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) return true;
        }
        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) return true;
        if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) return true;
        return false;
    }

    // Method to check if the board is full
    public static boolean isBoardFull(String[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c].equals(" ")) return false;
            }
        }
        return true;
    }
}