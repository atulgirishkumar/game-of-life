package com.atulgirishkumar.engine.rules.impl;

import com.atulgirishkumar.engine.rules.Rule;
import com.atulgirishkumar.entity.Cell;

import java.util.Set;

/**
 * @author atulgirishkumar
 */
public class Rule1 implements Rule {

    @Override
    public boolean applyRule(Set<Cell> liveCells, int liveNeighbours, Cell currCell) {
        if ((liveNeighbours == 2 && liveCells.contains(currCell))) return true;
        return false;
    }
}
