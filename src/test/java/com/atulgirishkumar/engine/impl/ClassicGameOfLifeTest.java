package com.atulgirishkumar.engine.impl;

import com.atulgirishkumar.engine.EvolutionStrategy;
import com.atulgirishkumar.engine.UniverseMode;
import com.atulgirishkumar.engine.rules.Rule;
import com.atulgirishkumar.engine.rules.impl.Rule1;
import com.atulgirishkumar.engine.rules.impl.Rule2;
import com.atulgirishkumar.entity.Board;
import com.atulgirishkumar.entity.Cell;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author atulgirishkumar
 */

class ClassicGameOfLifeTest {

    private static EvolutionStrategy evolutionStrategy;

    @BeforeAll
    static void setup() {
        List<Rule> ruleSet = new ArrayList<>();
        ruleSet.add(new Rule1());
        ruleSet.add(new Rule2());
        evolutionStrategy = new ClassicGameOfLife(ruleSet);
    }

    @Test
    void test_computeNextGeneration_deadCellWithThreeNeighbors_becomesAlive() {
        Set<Cell> seed = Set.of(
                new Cell(1, 0),
                new Cell(0, 1),
                new Cell(2, 1)
        );

        Board board = new Board(5, 5, seed, UniverseMode.FINITE);
        Set<Cell> nextGen = evolutionStrategy.computeNextGeneration(board);

        assertTrue(nextGen.contains(new Cell(1, 1)));
    }

    @Test
    void test_computeNextGeneration_liveCellWithFewerThanTwoNeighbors_dies() {
        Set<Cell> seed = Set.of(
                new Cell(1, 1),
                new Cell(1, 2)
        );
        Board board = new Board(5, 5, seed, UniverseMode.FINITE);
        Set<Cell> nextGen = evolutionStrategy.computeNextGeneration(board);

        assertFalse(nextGen.contains(new Cell(1, 1)));
    }

    @Test
    void test_computeNextGeneration_liveCellWithTwoOrThreeNeighbors_survives() {
        Set<Cell> seed = Set.of(
                new Cell(1, 1),
                new Cell(1, 0),
                new Cell(2, 1)
        );
        Board board = new Board(5, 5, seed, UniverseMode.FINITE);
        Set<Cell> nextGen = evolutionStrategy.computeNextGeneration(board);

        assertTrue(nextGen.contains(new Cell(1, 1)));
    }

    @Test
    void test_computeNextGeneration_liveCellWithMoreThanThreeNeighbors_dies() {
        Set<Cell> seed = Set.of(
                new Cell(1, 1),
                new Cell(0, 0),
                new Cell(0, 1),
                new Cell(0, 2),
                new Cell(1, 0)
        );
        Board board = new Board(5, 5, seed, UniverseMode.FINITE);
        Set<Cell> nextGen = evolutionStrategy.computeNextGeneration(board);

        assertFalse(nextGen.contains(new Cell(1, 1)));
    }

    @Test
    void test_computeNextGeneration_stillLife_remainsStable() {
        Set<Cell> seed = Set.of(
                new Cell(1, 1), // has 4 live neighbours
                new Cell(1, 2),
                new Cell(2, 1),
                new Cell(2, 2)
        );
        Board board = new Board(5, 5, seed, UniverseMode.FINITE);
        Set<Cell> nextGen = evolutionStrategy.computeNextGeneration(board);

        assertEquals(seed, nextGen);
    }

    // TODO: Add more complex test cases as how the patterns move

}