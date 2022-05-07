package com.nqueens;

import java.util.Set;

public class QueenPosition {
    private final Set<IndexCoordinate> coordinates;

    @Override
    public String toString() {
        return String.format("{%s}", coordinates);
    }

    private QueenPosition(Set<IndexCoordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public static QueenPosition of(Set<IndexCoordinate> coordinates) {
        return new QueenPosition(coordinates);
    }

    public boolean isValid(IndexCoordinate coordinate) {
        boolean isHorizontalOrDiagonalOrVerticalThreat = coordinates.stream().anyMatch(coord -> isHorizontalThreat(coord, coordinate) || isDiagonalThreat(coord, coordinate) || isVerticalThreat(coord, coordinate));
        return !isHorizontalOrDiagonalOrVerticalThreat;
    }

    private boolean isVerticalThreat(IndexCoordinate coord1, IndexCoordinate coord2) {
        return coord1.isSameCol(coord2);
    }

    private boolean isDiagonalThreat(IndexCoordinate coord1, IndexCoordinate coord2) {
        return coord1.isOnDiagonal(coord2);
    }

    private boolean isHorizontalThreat(IndexCoordinate coord1, IndexCoordinate coord2) {
        return coord1.isSameRow(coord2);
    }
}
