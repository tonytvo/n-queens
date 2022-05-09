package com.nqueens;

import java.util.Objects;

public class IndexCoordinate {
    private final int row;
    private final int col;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndexCoordinate that = (IndexCoordinate) o;
        return row == that.row && col == that.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

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

    public boolean isSameRow(IndexCoordinate coord) {
        return this.row == coord.row;
    }

    public boolean isOnDiagonal(IndexCoordinate coord) {
        return Math.abs(this.row - coord.row) == Math.abs(this.col - coord.col);
    }

    public boolean isSameCol(IndexCoordinate coord) {
        return this.col == coord.col;
    }
}
