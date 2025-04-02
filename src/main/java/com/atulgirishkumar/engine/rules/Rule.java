package com.atulgirishkumar.engine.rules;

import com.atulgirishkumar.entity.Cell;

import java.util.Set;

/**
 * @author atulgirishkumar
 */
public interface Rule {

    boolean applyRule(Set<Cell> liveCells, int liveNeighbours, Cell currCell);
}
