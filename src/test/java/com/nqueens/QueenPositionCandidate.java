package com.nqueens;

import com.google.common.collect.ImmutableSet;

public class QueenPositionCandidate {
    private final ImmutableSet<IndexCoordinate> _candidateCoordinates;

    public QueenPositionCandidate(ImmutableSet<IndexCoordinate> candidateCoordinates) {
        _candidateCoordinates = candidateCoordinates;
    }

    public static QueenPositionCandidate of(ImmutableSet<IndexCoordinate> candidateCoordinates) {
        return new QueenPositionCandidate(candidateCoordinates);
    }

    @Override
    public String toString() {
        return String.format("{%s}", _candidateCoordinates);
    }
}
