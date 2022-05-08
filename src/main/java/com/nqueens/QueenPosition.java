package com.nqueens;

import java.util.Set;

public class QueenPosition {
    private final Set<IndexCoordinate> validPositions;

    @Override
    public String toString() {
        return String.format("{%s}", validPositions);
    }

    private QueenPosition(Set<IndexCoordinate> coordinates) {
        this.validPositions = coordinates;
    }

    public static QueenPosition of(Set<IndexCoordinate> coordinates) {
        return new QueenPosition(coordinates);
    }

    public boolean isValid(IndexCoordinate coordinate) {
        boolean isHorizontalOrDiagonalOrVerticalThreat = validPositions.stream().anyMatch(coord -> isHorizontalThreat(coord, coordinate) || isDiagonalThreat(coord, coordinate) || isVerticalThreat(coord, coordinate));
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
