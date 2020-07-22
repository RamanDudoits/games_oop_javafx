package ru.job4j.chess.firuges.black;


import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest  {

    @Test
    public void whenPosition() {
        BishopBlack bishop = new BishopBlack(Cell.C8);
        assertThat(bishop.position(), is(Cell.C8));
    }

    @Test
    public void whenCopy() {
        BishopBlack bishop = new BishopBlack(Cell.C8);
        Figure bishop2 = bishop.copy(Cell.C3);
        assertThat(bishop2.position(), is(Cell.C3));
    }

    @Test
    public void whenWay() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell[] cells = bishop.way(Cell.C1, Cell.G5);
        assertThat(cells, is(new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }

    @Test(expected = IllegalStateException.class)
    public void whenIsDiagonal() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        assertThat(bishop.way(Cell.C1, Cell.E4), is(
                String.format("Could not move by diagonal from  to ",
                        Cell.C1, Cell.E4)));
    }
}