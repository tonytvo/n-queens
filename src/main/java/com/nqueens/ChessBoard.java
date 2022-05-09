package com.nqueens;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class ChessBoard {
    private final int _size;

    private ChessBoard(int size) {
        this._size = size;
    }

    public static ChessBoard of(int size) {
        return new ChessBoard(size);
    }

    public boolean isValidSolution(QueenPosition queenPosition) {
        return queenPosition.isValidSolution(getSize());
    }

    public Set<IndexCoordinate> constructCandidates(QueenPosition position, int col) {
        return getAllCoordinateForCol(col).stream().filter(position::canPlaceQueenAt).collect(Collectors.toSet());
    }

    private Set<IndexCoordinate> getAllCoordinateForCol(int col) {
        return IntStream.range(0, getSize())
                .mapToObj(row -> IndexCoordinate.of(row, col))
                .collect(Collectors.toSet());
    }

    private int getSize() {
        return _size;
    }
}
