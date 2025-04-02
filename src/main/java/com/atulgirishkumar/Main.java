package com.atulgirishkumar;

import com.atulgirishkumar.engine.UniverseMode;
import com.atulgirishkumar.engine.*;
import com.atulgirishkumar.engine.impl.ClassicGameOfLife;
import com.atulgirishkumar.engine.rules.Rule;
import com.atulgirishkumar.engine.rules.impl.Rule1;
import com.atulgirishkumar.engine.rules.impl.Rule2;
import com.atulgirishkumar.entity.Board;
import com.atulgirishkumar.entity.Cell;
import com.atulgirishkumar.renderer.ConsoleRenderer;
import com.atulgirishkumar.renderer.Renderer;
import com.atulgirishkumar.utils.PatternHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author atulgirishkumar
 */
public class Main {

    public static void main(String[] args) {
        int size = 25;

        int centerX = size / 2;
        int centerY = size / 2;
        Set<Cell> glidePatternLiveCells = PatternHelper.getGliderPatternLiveCells(centerX, centerY);
        Board boardWithGlidePattern = new Board(size, size, glidePatternLiveCells, UniverseMode.FINITE);

        Set<Cell> lwssPatternLiveCells = PatternHelper.getLightweightSpaceshipPatternLiveCells(centerX, centerY);
        Board boardWithLWSSPattern = new Board(size, size, lwssPatternLiveCells, UniverseMode.INFINITE);

        List<Rule> ruleSet = new ArrayList<>();
        ruleSet.add(new Rule1());
        ruleSet.add(new Rule2());
        EvolutionStrategy evolutionStrategy = new ClassicGameOfLife(ruleSet);
        Renderer renderer = new ConsoleRenderer();

        Game game = new Game(boardWithGlidePattern, evolutionStrategy, renderer);

        game.run();
    }
}


