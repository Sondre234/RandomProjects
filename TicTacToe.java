package com.example.tictactoe;

import java.util.Scanner;

public class TicTacToe {


    public static void main(String[] args) {
        TicTacToe logic = new TicTacToe();
        String[][] board = logic.createBoard();
        logic.printBoard(board);
        String player = "X";
        while (true) {
            int[] move = logic.getMove();
            int row = move[0];
            int col = move[1];
            if (!logic.isValidMove(board, row, col)) {
                System.out.println("Invalid move. Try again.");
                continue;
            }
            logic.makeMove(board, row, col, player);
            logic.printBoard(board);
            if (logic.isWinner(board, player)) {
                System.out.println("Player " + player + " wins!");
                break;
            }
            if (logic.isBoardFull(board)) {
                System.out.println("It's a tie!");
                break;
            }
            player = player.equals("X") ? "O" : "X";
        }
    }

    public int[] getMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your move (row and column): ");
        int row = scanner.nextInt() - 1;
        int col = scanner.nextInt() - 1;
        return new int[]{row, col};
    }

    public boolean isWinner(String[][] board, String player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) {
                return true;
            }
        }
        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
            return true;
        }
        return board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player);
    }

    public String[][] createBoard() {
        String[][] board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = " ";
            }
        }
        return board;
    }

    public void printBoard(String[][] board) {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  -----");
            }
        }
    }

    public boolean isBoardFull(String[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidMove(String[][] board, int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }
        return board[row][col].equals(" ");
    }

    public void makeMove(String[][] board, int row, int col, String player) {
        board[row][col] = player;
    }

}
