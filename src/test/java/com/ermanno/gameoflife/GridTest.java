package com.ermanno.gameoflife;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GridTest {
    @Test
    public void createGridTest() {
        boolean[][] cells = {
                {true, false, false},
                {false, true, false},
                {false, false, false}
        };
        Grid grid = Grid.create(cells);
        assertArrayEquals(cells, grid.getCells());
    }
    
    @Test
    public void createGridCopyTest() {
        boolean[][] cells = {
                {true, false, false},
                {false, true, false},
                {false, false, false}
        };
        Grid grid = Grid.create(cells);
        Grid newGrid = grid.copy();
        assertFalse(grid == newGrid);
        assertTrue(grid.equals(newGrid));
    }
    
    @Test
    public void countLiveNeighboursTest() {
        boolean[][] cells = {
                {true, false, false},
                {false, true, false},
                {false, false, false}
        };
        Grid grid = Grid.create(cells);
        int numLiveNeighbours = grid.numLiveNeighbours(1,1);
        assertEquals(1, numLiveNeighbours);
    }
    
    @Test
    public void nextStateOfLiveCellWithFewerThan2LiveNeighboursTest() {
        boolean[][] cells = {
                {true, false, false},
                {false, true, false},
                {false, false, false}
        };
        Grid grid = Grid.create(cells);
        assertTrue(grid.getCells()[1][1]);
        boolean nextState = grid.getNextState(1, 1);
        assertFalse(nextState);
    }

    @Test
    public void nextStateOfLiveCellWithMoreThan3LiveNeighboursTest() {
        boolean[][] cells = {
                {true, false, false},
                {false, true, true},
                {false, true, true}
        };
        Grid grid = Grid.create(cells);
        assertTrue(grid.getCells()[1][1]);
        boolean nextState = grid.getNextState(1, 1);
        assertFalse(nextState);
    }
    
    @Test
    public void nextStateOfLiveCellWith2To3LiveNeighboursTest() {
        boolean[][] cells = {
                {true, false, false},
                {false, true, true},
                {false, true, false}
        };
        Grid grid = Grid.create(cells);
        assertTrue(grid.getCells()[1][1]);
        boolean nextState = grid.getNextState(1, 1);
        assertTrue(nextState);
    }

    @Test
    public void nextStateOfDeadCellWithMoreThan3LiveNeighboursTest() {
        boolean[][] cells = {
                {true, false, false},
                {false, false, true},
                {false, true, true}
        };
        Grid grid = Grid.create(cells);
        assertFalse(grid.getCells()[1][1]);
        boolean nextState = grid.getNextState(1, 1);
        assertFalse(nextState);
    }

    @Test
    public void nextStateOfDeadCellWithLessThan3LiveNeighboursTest() {
        boolean[][] cells = {
                {true, false, false},
                {false, false, true},
                {false, false, false}
        };
        Grid grid = Grid.create(cells);
        assertFalse(grid.getCells()[1][1]);
        boolean nextState = grid.getNextState(1, 1);
        assertFalse(nextState);
    }
    
    @Test
    public void nextStateOfDeadCellWith3LiveNeighboursTest() {
        boolean[][] cells = {
                {true, false, false},
                {false, false, true},
                {false, true, false}
        };
        Grid grid = Grid.create(cells);
        assertFalse(grid.getCells()[1][1]);
        boolean nextState = grid.getNextState(1, 1);
        assertTrue(nextState);
    }
    
    @Test
    public void cannotAnalyseTheNodesOutsideTheGridTest() {
        boolean[][] cells = {
                {true, false, false},
                {false, false, true},
                {false, true, false}
        };
        Grid grid = Grid.create(cells);
        int numNeighbours= grid.numLiveNeighbours(0, 1);
        assertEquals(2, numNeighbours);
    }
}
