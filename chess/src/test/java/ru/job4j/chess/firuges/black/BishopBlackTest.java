package ru.job4j.chess.firuges.black;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {
    BishopBlack bishopBlack;

    @Before
    public void setUp() {
        bishopBlack = new BishopBlack(Cell.C8);
    }

    @Test
    public void whenCallPositionThenIsCreatePosition() {
        assertThat(this.bishopBlack.position(), is(Cell.C8));
    }

    @Test
    public void whenCallCopyWhenItPositionChange() {
        Figure copyBishop = this.bishopBlack.copy(Cell.C1);
        assertThat(copyBishop.position(), is(Cell.C1));
    }

    /* Сигнатура метода такова, что начальное положение фигуры передается при вызове метода,
    а значит реальное положение объекта при тестированиее роли не играет.
    Полноценное тестирование, в текущем положении, возможно только в связке с методом move()*/
    @Test
    public void way() {
        Cell[] steps = this.bishopBlack.way(Cell.C1, Cell.G5);
        Cell[] except = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(steps, is(except));
    }

    @Test(expected = IllegalStateException.class)
    public void impossibleMoveException() {
        this.bishopBlack.way(Cell.E1, Cell.G5);
    }


}