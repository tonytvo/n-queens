package com.nqueens;

public class Coordinate {
    private final int rankNumber;
    private final char fileLetter;

    private Coordinate(int rankNumber, char fileLetter) {
        this.rankNumber = rankNumber;
        this.fileLetter = fileLetter;
    }

    public static Coordinate of(char fileLetter, int rankNumber) {
        return new Coordinate(rankNumber, fileLetter);
    }

    @Override
    public String toString() {
        return String.format("{%c, %d}", fileLetter, rankNumber+'}');
    }
}
