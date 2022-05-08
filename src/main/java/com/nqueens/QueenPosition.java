package com.nqueens;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QueenPosition {
    private Set<IndexCoordinate> validQueenPositionsOnBoard;

    @Override
    public String toString() {
        return String.format("{%s}", validQueenPositionsOnBoard);
    }

    private QueenPosition(Set<IndexCoordinate> coordinates) {
        this.validQueenPositionsOnBoard = coordinates;
    }

    public static QueenPosition of(Set<IndexCoordinate> coordinates) {
        return new QueenPosition(coordinates);
    }

    public boolean isValid(IndexCoordinate coordinate) {
        boolean isHorizontalOrDiagonalOrVerticalThreat = validQueenPositionsOnBoard.stream().anyMatch(coord -> isHorizontalThreat(coord, coordinate) || isDiagonalThreat(coord, coordinate) || isVerticalThreat(coord, coordinate));
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
        return validQueenPositionsOnBoard.size() >= boardSize;
    }

    public QueenPosition addValidPosition(IndexCoordinate candidate) {
        return of(Stream.concat(validQueenPositionsOnBoard.stream(), Stream.of(candidate)).collect(Collectors.toSet()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueenPosition that = (QueenPosition) o;

        return validQueenPositionsOnBoard.equals(that.validQueenPositionsOnBoard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(validQueenPositionsOnBoard);
    }
}
