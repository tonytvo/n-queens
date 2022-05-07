package com.nqueens;

import java.util.Set;

public class QueenPosition {
    private final Set<Coordinate> coordinates;

    @Override
    public String toString() {
        return String.format("{%s}", coordinates);
    }

    private QueenPosition(Set<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public static QueenPosition of(Set<Coordinate> coordinates) {
        return new QueenPosition(coordinates);
    }
}
