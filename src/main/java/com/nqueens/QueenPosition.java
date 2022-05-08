package com.nqueens;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QueenPosition {
    private Set<IndexCoordinate> validPositions;

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

    public boolean isValidSolution(int boardSize) {
        return validPositions.size() >= boardSize;
    }

    public void addValidPosition(IndexCoordinate candidate) {
        validPositions = Stream.concat(validPositions.stream(), Stream.of(candidate)).collect(Collectors.toSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueenPosition that = (QueenPosition) o;
        return validPositions.equals(that.validPositions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(validPositions);
    }
}
