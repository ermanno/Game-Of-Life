package com.ermanno.gameoflife;

import java.util.Arrays;

public class Grid {
    private boolean[][] cells;
    
    private Grid() {}
    
    public static Grid create(boolean[][] cells) {
        Grid grid = new Grid();
        grid.cells = cells;
        return grid;
    }
    
    public boolean[][] getCells() {
        return cells;
    }
    
    @Override
    public boolean equals(Object grid) {
        Grid castedGrid = (Grid) grid;
        for (int row = 0; row < cells.length; row++) {
            for (int column = 0; column < cells[0].length; column++) {
                if (this.cells[row][column] != castedGrid.cells[row][column])
                    return false;
            }
        }
        return true;
    }

    public Grid copy() {
        boolean[][] cellsCopy = new boolean[this.cells.length][];
        for (int row = 0; row < this.cells.length; row++) {
            cellsCopy[row] = Arrays.copyOf(this.cells[row], this.cells[row].length);
        }
        Grid newGrid = Grid.create(cellsCopy);
        return newGrid;
    }

    public int numLiveNeighbours(int row, int column) {
        int numLiveNeighbours = 0;
        for (int rowChange = -1; rowChange <= 1; rowChange++) {
            for (int columnChange = -1; columnChange <= 1; columnChange++) {
                if (rowChange == 0 && columnChange == 0) continue;
                if (this.cells[row + rowChange][column + columnChange])
                    numLiveNeighbours++;
            }
        }
        return numLiveNeighbours;
    }

    public boolean getNextState(int row, int column) {
        int numLiveNeighbours = this.numLiveNeighbours(row, column);
        if (this.cells[row][column]) {
            if (numLiveNeighbours <= 2 || numLiveNeighbours > 3) {
                return false;
            } else {
                return true;
            }
        } else {
            if (numLiveNeighbours == 3) {
                return true;
            } else {
                return false;
            }
        }
    }
}
