package com.atulgirishkumar.utils;

import com.atulgirishkumar.entity.Cell;

import java.util.HashSet;
import java.util.Set;

/**
 * @author atulgirishkumar
 */
// TODO: Convert to a factory
public class PatternHelper {

    public static Set<Cell> getGliderPatternLiveCells(int x, int y) {
        Set<Cell> liveCells = new HashSet<>();
        liveCells.add(new Cell(x, y + 1));
        liveCells.add(new Cell(x + 1, y + 2));

        liveCells.add(new Cell(x + 2, y));
        liveCells.add(new Cell(x + 2, y + 1));
        liveCells.add(new Cell(x + 2, y + 2));
        return liveCells;
    }

    public static Set<Cell> getLightweightSpaceshipPatternLiveCells(int x, int y) {
        Set<Cell> liveCells = new HashSet<>();

        liveCells.add(new Cell(x, y + 1));

        liveCells.add(new Cell(x + 1, y));
        liveCells.add(new Cell(x + 1, y + 1));

        liveCells.add(new Cell(x + 2, y + 1));
        liveCells.add(new Cell(x + 2, y + 2));
        return liveCells;
    }
}
