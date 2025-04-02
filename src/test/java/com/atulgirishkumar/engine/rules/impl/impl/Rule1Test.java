package com.atulgirishkumar.engine.rules.impl.impl;

import com.atulgirishkumar.engine.rules.Rule;
import com.atulgirishkumar.engine.rules.impl.Rule1;
import com.atulgirishkumar.entity.Cell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author atulgirishkumar
 */
class Rule1Test {

    Rule rule;

    @BeforeAll
    void setup(){
        rule = new Rule1();
    }

    @Test
    void test_applyRule_whenEmptyLiveCellAndNoNeighbour_returnFalse(){
        Set<Cell> liveCells = new HashSet<>();
        assertFalse(rule.applyRule(liveCells, 0, new Cell(1,2)));
    }

}