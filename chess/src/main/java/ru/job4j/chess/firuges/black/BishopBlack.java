package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", this.position(), dest)
            );
        }
        int size = Math.abs(this.position.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int dX = dest.getX() - this.position.getX() > 0 ? 1 : -1;
        int dY = dest.getY() - this.position.getY() > 0 ? 1 : -1;
        int x = this.position.getX() + dX;
        int y = this.position.getY() + dY;
        for (int i = 0; i < size; i++) {
            steps[i] = Cell.findBy(x + i * dX, y + i * dY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
