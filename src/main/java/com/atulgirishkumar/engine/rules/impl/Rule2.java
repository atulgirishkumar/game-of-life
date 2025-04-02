package com.atulgirishkumar.engine.rules.impl;

import com.atulgirishkumar.engine.rules.Rule;
import com.atulgirishkumar.entity.Cell;

import java.util.Set;

/**
 * @author atulgirishkumar
 */
public class Rule2 implements Rule {

    @Override
    public boolean applyRule(Set<Cell> liveCells, int liveNeighbours, Cell currCell) {
        if (liveNeighbours == 3) return true;
        return false;
    }
}
