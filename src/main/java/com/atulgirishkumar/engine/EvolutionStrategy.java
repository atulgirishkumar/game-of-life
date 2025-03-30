package com.atulgirishkumar.engine;

import com.atulgirishkumar.entity.Board;
import com.atulgirishkumar.entity.Cell;

import java.util.Set;

/**
 * @author atulgirishkumar
 */
public interface EvolutionStrategy {
    Set<Cell> computeNextGeneration(Board board);
}
