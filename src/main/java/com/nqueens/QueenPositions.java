package com.nqueens;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QueenPositions {
    private Set<QueenPosition> validQueenPositions;

    @Override
    public String toString() {
        return String.format("{%s}", validQueenPositions);
    }

    private QueenPositions(Set<QueenPosition> validPositions) {
        this.validQueenPositions = validPositions;
    }

    public static QueenPositions of(Set<QueenPosition> validPositions) {
        return new QueenPositions(validPositions);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueenPositions that = (QueenPositions) o;
        return validQueenPositions.equals(that.validQueenPositions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(validQueenPositions);
    }

    public void add(QueenPosition currentPosition) {
        validQueenPositions = Stream.concat(validQueenPositions.stream(), Stream.of(currentPosition)).collect(Collectors.toSet());
    }

    public int totalSolutions() {
        return validQueenPositions.size();
    }

    public QueenPositions merge(QueenPositions that) {
        return QueenPositions.of(Stream.concat(validQueenPositions.stream(), that.validQueenPositions.stream()).collect(Collectors.toSet()));
    }
}
