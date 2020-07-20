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
        int deltaX;
        int deltaY;
        int size = Math.abs(dest.getX() - source.getX());
        Cell[] steps = new Cell[size];
        for (int index = 0; index < size; index++) {
            if (dest.getX() > source.getX()) {
                deltaX = source.getX() + index + 1;
            } else deltaX = source.getX() - index - 1;
            if (dest.getY() > source.getY()) {
                deltaY = source.getY() + index + 1;
            } else deltaY = source.getY() - index - 1;
            int x = deltaX;
            int y = deltaY;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean rsl = false;
        if (Math.abs(source.getX() - source.getY()) ==
                Math.abs(dest.getX() - dest.getY()) ||
        source.getX() + source.getY() ==
                dest.getX() + dest.getY()) {
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

}
