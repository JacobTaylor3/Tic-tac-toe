
package tictactoe;

import java.util.Scanner;

public class Game {

    private static final String EMPTY = ".";
    private static final String X = "X";
    private static final String O = "O";
    

    String currentPlayer;

    String[][] board;

    public Game() {

        this.board = new String[3][3];

        this.currentPlayer = X;

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {
                board[row][col] = EMPTY;
            }
            
        }

    }

    public String toString() {
        String result = "";
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                result += "|" + board[row][col]; 

            }
            
            result += "|" + "\n";
        }
        return result;
    }

    private boolean isGameOver() {
        return (isWinner(X) || isWinner(O)) || isDraw();
    }

    private boolean isDraw() {

        for (int rows = 0; rows < 3; rows++) {

            for (int col = 0; col < 3; col++) {

                if (!(this.board[rows][col].equals(X) || this.board[rows][col].equals(O))) {
                    return false;
                }

            }

        }

        return true;

    }

    private boolean isWinner(String symbol) {

        if (this.board[0][0].equals(symbol) && this.board[0][1].equals(symbol) && this.board[0][2].equals(symbol)) {
            return true;
        } else if (this.board[1][0].equals(symbol) && this.board[1][1].equals(symbol)
                && this.board[1][2].equals(symbol)) {
            return true;
        } else if (this.board[2][0].equals(symbol) && this.board[2][1].equals(symbol)
                && this.board[2][2].equals(symbol)) {
            return true;

        } else if (this.board[0][0].equals(symbol) && this.board[1][0].equals(symbol)
                && this.board[2][0].equals(symbol)) {
            return true;
        } else if (this.board[0][1].equals(symbol) && this.board[1][1].equals(symbol)
                && this.board[2][1].equals(symbol)) {
            return true;
        } else if (this.board[0][2].equals(symbol) && this.board[1][2].equals(symbol)
                && this.board[2][2].equals(symbol)) {
            return true;
        }

        else if (this.board[0][0].equals(symbol) && this.board[1][1].equals(symbol)
                && this.board[2][2].equals(symbol)) {
            return true;
        } else if (this.board[2][0].equals(symbol) && this.board[1][1].equals(symbol)
                && this.board[0][2].equals(symbol)) {
            return true;
        }

        return false;

    }

    private String getCurrentPlayer() {

        return (this.currentPlayer);

    }

    private void move(int move) {

        int row = move / 3;

        int col = move % 3;

        if (board[row][col].equals(O) || board[row][col].equals(X)) {

            System.out.println("Tile has already been claimed by player " + this.board[row][col] + "! Try Again");

        } else {
            board[row][col] = currentPlayer;
            if (currentPlayer.equals(X)) {
                currentPlayer = O;
            } else {
                currentPlayer = X;
            }

        }

    }

    private String getResult() {
        if (isWinner(X)) {
            return ("The winner is X!");
        } else if (isWinner(O)) {
            return ("The winner is O!");
        }
        return ("A draw!");
    }

    public void runGame() {

        try (Scanner s = new Scanner(System.in)) {

            while (!this.isGameOver()) {
                System.out.println(this.toString());
                System.out.print("Player " + this.getCurrentPlayer() + ",choose a move(0-8): ");
                int move = s.nextInt();

                this.move(move);
                

            }
            System.out.println();
            System.out.println(this.toString());
            System.out.println("Game result:" + this.getResult());

        }

    }

}