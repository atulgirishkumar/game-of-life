package com.atulgirishkumar.entity;

import com.atulgirishkumar.engine.UniverseMode;

import java.util.Set;

/**
 * @author atulgirishkumar
 */
public class Board {

    private final int initWidth;
    private final int initHeight;
    private Set<Cell> liveCells;
    private final UniverseMode mode;


    public Board(int width, int height, Set<Cell> liveCells, UniverseMode universeMode) {
        this.initWidth = width;
        this.initHeight = height;
        this.liveCells = liveCells;
        this.mode = universeMode;
    }


    public int getInitWidth() {
        return initWidth;
    }

    public int getInitHeight() {
        return initHeight;
    }

    public void setLiveCells(Set<Cell> liveCells) {
        this.liveCells = liveCells;
    }

    public Set<Cell> getLiveCells() {
        return liveCells;
    }

    public UniverseMode getMode() {
        return mode;
    }

    public boolean isWithinBounds(Cell cell) {
        if (mode.equals(UniverseMode.INFINITE)) return true;

        return cell.getX() >= 0 && cell.getX() < initWidth &&
                cell.getY() >= 0 && cell.getY() < initHeight;
    }
}
