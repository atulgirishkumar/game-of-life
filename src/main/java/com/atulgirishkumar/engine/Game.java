package com.atulgirishkumar.engine;

import com.atulgirishkumar.entity.Board;
import com.atulgirishkumar.entity.Cell;
import com.atulgirishkumar.renderer.Renderer;

import java.util.Set;

/**
 * @author atulgirishkumar
 */

// TODO: remove hardcoded configurations
// TODO: Add logging instead of sout
public class Game {
    private final Board board;
    private final EvolutionStrategy evolutionStrategy;
    private final Renderer renderer;

    public Game(Board board, EvolutionStrategy evolutionStrategy, Renderer renderer) {
        this.board = board;
        this.evolutionStrategy = evolutionStrategy;
        this.renderer = renderer;
    }

    // nit: can add custom exception
    public void run() {
        int generation = 0;
        while (true) {
            try {
                renderer.render(board, generation++);
                Set<Cell> nextGenLiveCells = evolutionStrategy.computeNextGeneration(board);
                board.setLiveCells(nextGenLiveCells);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.err.println("Error Occurred. Aborting Game!");
                break;
            }
        }
    }

}
