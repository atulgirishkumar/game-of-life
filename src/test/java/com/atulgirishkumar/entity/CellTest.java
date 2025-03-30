package com.atulgirishkumar.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author atulgirishkumar
 */
class CellTest {

    @Test
    void test_equals_sameCoordinates_returnsTrue() {
        Cell a = new Cell(1, 2);
        Cell b = new Cell(1, 2);
        assertEquals(a, b);
    }

    @Test
    void test_equals_diffCoordinates_returnsTrue() {
        Cell a = new Cell(1, 2);
        Cell b = new Cell(1, 3);
        assertNotEquals(a, b);
    }

    @Test
    void test_hashCode_sameCoordinates_returnsTrue() {
        Cell a = new Cell(1, 2);
        Cell b = new Cell(1, 2);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    void test_hashCode_diffCoordinates_returnsTrue() {
        Cell a = new Cell(1, 2);
        Cell b = new Cell(1, 3);
        assertNotEquals(a.hashCode(), b.hashCode());
    }
}