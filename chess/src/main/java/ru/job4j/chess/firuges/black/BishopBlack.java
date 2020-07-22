package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sqrt;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", source, dest)
            );
        }
        int size = Math.abs(dest.getX() - source.getX());
        Cell[] steps = new Cell[size];
        int deltaX = dest.getX() > source.getX() ? 1 : -1;
        int deltaY = dest.getY() > source.getY() ? 1 : -1;
        for (int index = 0; index < size; index++) {
            int x = deltaX * (index + 1) + source.getX();
            int y = deltaY * (index + 1) + source.getY();
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean rsl = false;
        if (Math.abs(source.getX() - dest.getX()) ==
                Math.abs(source.getY() - dest.getY())) {
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

}
