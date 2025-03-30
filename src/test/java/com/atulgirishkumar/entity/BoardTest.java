package com.atulgirishkumar.entity;

import com.atulgirishkumar.engine.UniverseMode;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author atulgirishkumar
 */
class BoardTest {

    @Test
    void test_isWithinBounds_cellInsideFiniteBoard_returnsTrue() {
        Board board = new Board(10, 10, new HashSet<>(), UniverseMode.FINITE);
        assertTrue(board.isWithinBounds(new Cell(0, 0)));
        assertTrue(board.isWithinBounds(new Cell(6, 7)));
    }

    @Test
    void test_isWithinBounds_cellOutsideFiniteBoard_returnsFalse() {
        Board board = new Board(10, 10, new HashSet<>(), UniverseMode.FINITE);
        assertFalse(board.isWithinBounds(new Cell(10, 10)));
        assertFalse(board.isWithinBounds(new Cell(-1, 5)));
    }

    @Test
    void test_isWithinBounds_cellInsideInFiniteBoard_returnsTrue() {
        Board board = new Board(10, 10, new HashSet<>(), UniverseMode.INFINITE);
        assertTrue(board.isWithinBounds(new Cell(999, 999)));
        assertTrue(board.isWithinBounds(new Cell(-444, -444)));
    }


}