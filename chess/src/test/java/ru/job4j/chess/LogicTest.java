package ru.job4j.chess;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.*;
import ru.job4j.chess.firuges.white.BishopWhite;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LogicTest {
    Logic logic;
    BishopBlack bishopBlack;

    @Before
    public void setUp() {
        this.logic = new Logic();
        bishopBlack = new BishopBlack(Cell.C1);
        this.logic.add(bishopBlack);
        this.logic.add(new PawnBlack(Cell.H6));
    }

    @Test
    public void trueMove() {
        boolean confirm = this.logic.move(Cell.C1, Cell.G5);
        assertThat(confirm, is(logic.getFigure(Cell.G5) instanceof BishopBlack));
    }

    @Test(expected = IllegalStateException.class)
    public void badMove() {
        boolean confirm = this.logic.move(Cell.C1, Cell.H6);
        assertThat(confirm, is(logic.getFigure(Cell.H6) instanceof BishopBlack));
    }
}