package com.ermanno.gameoflife;

public class Board {
    private int width;
    private int height;
    private boolean[][] board = new boolean[height][width];

    public Board(boolean[][] board) {
        height = board.length;
        if (height > 0) {
            width = board[0].length;
        }
        this.board = board;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void evolve() {
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                int numAliveNeighbours = countAliveNeighbours(row, column);
                updateCellNextState(row, column, numAliveNeighbours);
            }
        }
    }

    private void updateCellNextState(int row, int column, int numAliveNeighbours) {
        if (board[row][column]) {
            if (numAliveNeighbours <= 1 || numAliveNeighbours >= 4) {
                board[row][column] = false;
            }
        } else {
            if (numAliveNeighbours == 3)
                board[row][column] = true;
        }
    }

    private boolean isInsideBoard(int posX, int posY) {
        return (posX >= 0 && posX < width && posY >= 0 && posY < height);
    }

    public boolean isAlive(int row, int col) {
        return board[row][col];
    }

    private int countAliveNeighbours(int row, int column) {
        int numAlive = 0;
        for (int rowIncr = -1; rowIncr <= 1; rowIncr++) {
            for (int colIncr = -1; colIncr <= 1; colIncr++) {
                if (rowIncr == 0 && colIncr == 0) continue;
                int rowPos = row + rowIncr;
                int colPos = column + colIncr;
                if (isInsideBoard(rowPos, colPos)) {
                    if (board[rowPos][colPos])
                        numAlive++;
                }
            }
        }
        return numAlive;
    }
}
