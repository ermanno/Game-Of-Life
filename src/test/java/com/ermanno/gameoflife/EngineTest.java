package com.ermanno.gameoflife;

import static org.junit.Assert.*;

import org.junit.Test;

public class EngineTest {

    @Test
    public void testSolitude() {
        Cell[][] cells = { 
                { new Cell(0, 0, true), new Cell(0, 1, false), new Cell(0, 2, false) },
                { new Cell(1, 0, false), new Cell(1, 1, true), new Cell(1, 2, false) },
                { new Cell(2, 0, false), new Cell(2, 1, false), new Cell(2, 2, false) } 
                };
        Board board = new Board(cells);
        assertEquals(1, board.countAliveNeighbours(board.cells(1, 1)));
        board.evolve();
        
    }

}
