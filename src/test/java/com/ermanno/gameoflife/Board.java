package com.ermanno.gameoflife;

public class Board {
    private int width;
    private int height;
    private boolean[][] board = new boolean[width][height];
    
    public Board(boolean[][] board) {
        int width = board.length;
        if (width > 0) {
            height = board[0].length;
        }
        this.board = board;
    }
    
    public void evolve() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int numAliveNeighbours = countAliveNeighbours(x, y);
                if (numAliveNeighbours <= 1 || numAliveNeighbours >= 4) {
                    board[x][y] = false;
                } else {
                    board[x][y] = true;
                }
            }
        }
    }

    private boolean isInsideBoard(int posX, int posY) {
        return (posX >= 0 && posX < width && posY >= 0 && posY < height);
    }
    
    public int countAliveNeighbours(int cellX, int cellY) {
        int numAlive = 0;
        for (int x = -1; x <= 1; x += 2) {
            for (int y = -1; y <= 1; y += 2) {
                int posX = cellX + x;
                int posY = cellY + y;
                if (isInsideBoard(posX, posY)) {
                    if (board[posX][posY])
                        numAlive++;
                }
            }
        }
        return numAlive;
    }
}
