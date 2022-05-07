package com.nqueens;

public class Coordinate {
    private final int rankNumber;
    private final char fileLetter;

    public Coordinate(int rankNumber, char fileLetter) {
        this.rankNumber = rankNumber;
        this.fileLetter = fileLetter;
    }

    @Override
    public String toString() {
        return String.format("{%c, %d}", fileLetter, rankNumber+'}');
    }
}
