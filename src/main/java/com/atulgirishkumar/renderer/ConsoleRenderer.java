package com.atulgirishkumar.renderer;

import com.atulgirishkumar.entity.Board;
import com.atulgirishkumar.entity.Cell;

/**
 * @author atulgirishkumar
 */
public class ConsoleRenderer implements Renderer {

    @Override
    public void render(Board board, int generation) {
        clearConsole();
        System.out.println("Generation " + generation + " | Population: " + board.getLiveCells().size());

        int minX = 0;
        int minY = 0;
        int maxX = board.getInitWidth() - 1;
        int maxY = board.getInitHeight() - 1;

        // In case of IN_FINITE mode, expanding the boundaries for live cells living outside.
        for (Cell p : board.getLiveCells()) {
            if (p.getX() < minX) minX = p.getX();
            if (p.getX() > maxX) maxX = p.getX();
            if (p.getY() < minY) minY = p.getY();
            if (p.getY() > maxY) maxY = p.getY();
        }


        for (int y = minY; y <= maxY; y++) {
            for (int x = minX; x <= maxX; x++) {
                if (board.getLiveCells().contains(new Cell(x, y))) {
                    System.out.print("O ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    private void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
