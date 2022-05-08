package com.nqueens;

import com.google.common.collect.ImmutableSet;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class BoardInfo {
    private final int _size;

    private BoardInfo(int size) {
        this._size = size;
    }

    public static BoardInfo of(int size) {
        return new BoardInfo(size);
    }

    private int getSize() {
        return _size;
    }

    public QueenPositionCandidate construct(QueenPosition position, int col) {
        Set<IndexCoordinate> candidates = getAllCoordinateForCol(col).stream().filter(position::isValid).collect(Collectors.toSet());
        return QueenPositionCandidate.of(ImmutableSet.copyOf(candidates));
    }

    private Set<IndexCoordinate> getAllCoordinateForCol(int col) {
        return IntStream.range(0, getSize())
                .mapToObj(row -> IndexCoordinate.of(row, col))
                .collect(Collectors.toSet());
    }
}
