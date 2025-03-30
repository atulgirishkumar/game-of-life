package com.atulgirishkumar.entity;

import java.util.Objects;

/**
 * @author atulgirishkumar
 */
public class Cell {

    private final int x;
    private final int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cell)) return false;
        Cell p = (Cell) o;
        return x == p.x && y == p.y;
    }
}
