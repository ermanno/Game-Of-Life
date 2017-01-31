package com.ermanno.gameoflife;

import static org.junit.Assert.*;

import org.junit.Test;

public class EngineTest {

    @Test
    public void testSolitude() {
        boolean[][] cells = { 
                { true, false, false },
                { false, true, false },
                { false, false, false } 
                };
        Board board = new Board(cells);
        assertEquals(1, board.countAliveNeighbours(1, 1));
        board.evolve();
    }

}
