package com.ermanno.gameoflife;

public class Board {
    private int width;
    private int height;
    private Cell[][] board = new Cell[width][height];
    
    public Board(Cell[][] board) {
        int width = board.length;
        if (width > 0) {
            height = board[0].length;
        }
        this.board = board;
    }
    
    public Cell cells(int x, int y) {
        return board[x][y];
    }
    
    public void evolve() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int numAliveNeighbours = countAliveNeighbours(board[x][y]);
                if (numAliveNeighbours <= 1 || numAliveNeighbours >= 4) {
                    board[x][y].setAlive(false);
                } else {
                    board[x][y].setAlive(true);
                }
            }
        }
    }

    private boolean isInsideBoard(int posX, int posY) {
        return (posX >= 0 && posX < width && posY >= 0 && posY < height);
    }
    
    public int countAliveNeighbours(Cell cell) {
        int numAlive = 0;
        for (int x = -1; x <= 1; x += 2) {
            for (int y = -1; y <= 1; y += 2) {
                int posX = cell.getX() + x;
                int posY = cell.getY() + y;
                if (isInsideBoard(posX, posY)) {
                    if (board[posX][posY].isAlive())
                        numAlive++;
                }
            }
        }
        return numAlive;
    }
}
