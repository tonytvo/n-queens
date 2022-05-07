package com.nqueens;

public class IndexCoordinate {
    private final int row;
    private final int col;

    private IndexCoordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public static IndexCoordinate of(int row, int col) {
        return new IndexCoordinate(row, col);
    }

    @Override
    public String toString() {
        return String.format("{%d, %d}", row, col);
    }
}
