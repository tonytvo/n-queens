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
}
