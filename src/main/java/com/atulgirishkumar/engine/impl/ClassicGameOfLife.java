package com.atulgirishkumar.engine.impl;

import com.atulgirishkumar.engine.EvolutionStrategy;
import com.atulgirishkumar.entity.Board;
import com.atulgirishkumar.entity.Cell;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author atulgirishkumar
 */
public class ClassicGameOfLife implements EvolutionStrategy {

    private static final int[][] NEIGHBOUR_DIRECTIONS =
            {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    @Override
    public Set<Cell> computeNextGeneration(Board board) {
        Set<Cell> liveCells = board.getLiveCells();
        Map<Cell, Integer> cellNeighbourFrequency = getNeighbourFrequency(board, liveCells);

        Set<Cell> nextGen = new HashSet<>();
        for (Map.Entry<Cell, Integer> entry : cellNeighbourFrequency.entrySet()) {
            Cell cell = entry.getKey();
            int liveNeighbourCount = entry.getValue();
            if (!board.isWithinBounds(cell)) continue;
            if ((liveNeighbourCount == 2 && liveCells.contains(cell)) || liveNeighbourCount == 3) nextGen.add(cell);
        }

        return nextGen;
    }

    private static Map<Cell, Integer> getNeighbourFrequency(Board board, Set<Cell> liveCells) {
        Map<Cell, Integer> cellNeighbourFrequency = new HashMap<>();

        for (Cell liveCell : liveCells) {
            for (int[] dir : NEIGHBOUR_DIRECTIONS) {
                int currNeighbourXPos = liveCell.getX() + dir[0];
                int currNeighbourYPos = liveCell.getY() + dir[1];
                Cell currentCellNeighbour = new Cell(currNeighbourXPos, currNeighbourYPos);
                if (!board.isWithinBounds(currentCellNeighbour)) continue;
                cellNeighbourFrequency.put(
                        currentCellNeighbour,
                        cellNeighbourFrequency.getOrDefault(currentCellNeighbour, 0) + 1
                );
            }
        }
        return cellNeighbourFrequency;
    }
}
