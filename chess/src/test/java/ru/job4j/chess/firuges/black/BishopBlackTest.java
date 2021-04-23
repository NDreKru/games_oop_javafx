package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void position() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A3);
        assertThat(bishopBlack.position(), is(Cell.A3));
    }

    @Test
    public void way() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertArrayEquals(new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5}, bishopBlack.way(Cell.G5));
    }

    @Test
    public void copy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.B2);
        assertThat(bishopBlack.copy(Cell.A3).position(), is(Cell.A3));
    }

    @Test (expected = ImpossibleMoveException.class)
    public void ifNotDiagonal() {
        new BishopBlack(Cell.C1).way(Cell.B3);
    }

    @Test
    public void ifDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertTrue(bishopBlack.isDiagonal(bishopBlack.position(), Cell.G5));
    }
}