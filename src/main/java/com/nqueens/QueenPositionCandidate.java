package com.nqueens;

import com.google.common.collect.ImmutableSet;

import java.util.Objects;
import java.util.Set;

public class QueenPositionCandidate {
    private final ImmutableSet<IndexCoordinate> _candidateCoordinates;

    public QueenPositionCandidate(ImmutableSet<IndexCoordinate> candidateCoordinates) {
        _candidateCoordinates = candidateCoordinates;
    }

    public static QueenPositionCandidate of(ImmutableSet<IndexCoordinate> candidateCoordinates) {
        return new QueenPositionCandidate(candidateCoordinates);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueenPositionCandidate that = (QueenPositionCandidate) o;
        return _candidateCoordinates.equals(that._candidateCoordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_candidateCoordinates);
    }

    @Override
    public String toString() {
        return String.format("{%s}", _candidateCoordinates);
    }

    public Set<IndexCoordinate> getCandidates() {
        return _candidateCoordinates;
    }
}
