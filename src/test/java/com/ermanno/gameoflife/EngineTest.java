package com.ermanno.gameoflife;

import static org.junit.Assert.*;

import org.junit.Test;

public class EngineTest {

    @Test
    public void withAliveAndOneNeighbourThenStarvesTest() {
        boolean[][] cells = { 
                { true, false, false },
                { false, true, false },
                { false, false, false } 
                };
        Board board = new Board(cells);
        assertTrue(board.isAlive(1, 1));
        board.evolve();
        assertFalse(board.isAlive(1, 1));
    }
    
    @Test
    public void withDeadAndThreeNeighboursThenLives() {
        boolean[][] cells = { 
                { true, false, false },
                { true, false, true },
                { false, false, false } 
                };
        Board board = new Board(cells);
        assertFalse(board.isAlive(1, 1));
        board.evolve();
        assertTrue(board.isAlive(1, 1));
    }
}
