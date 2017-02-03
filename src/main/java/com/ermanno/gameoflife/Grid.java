package com.ermanno.gameoflife;

import java.util.Arrays;

public class Grid {
    private boolean[][] cells;
    private int gridHeight;
    private int gridWidth;
    
    private Grid() {}
    
    public static Grid create(boolean[][] cells) {
        Grid grid = new Grid();
        grid.cells = cells;
        grid.gridHeight = cells.length;
        grid.gridWidth = (grid.gridHeight > 0) ? grid.cells[0].length : 0;
        return grid;
    }
    
    public boolean[][] getCells() {
        return cells;
    }
    
    @Override
    public boolean equals(Object grid) {
        Grid castedGrid = (Grid) grid;
        for (int row = 0; row < gridHeight; row++) {
            for (int column = 0; column < gridWidth; column++) {
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
                int neighbourRow = row + rowChange;
                int neighbourColumn = column + columnChange;
                
                if (neighbourRow >= gridHeight || neighbourRow < 0) continue;
                if (neighbourColumn >= gridWidth || neighbourColumn < 0) continue;
                if (rowChange == 0 && columnChange == 0) continue;
                
                if (this.cells[neighbourRow][neighbourColumn])
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
