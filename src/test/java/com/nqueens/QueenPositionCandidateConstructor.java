package com.nqueens;

import com.google.common.collect.ImmutableSet;

public class QueenPositionCandidateConstructor {
    public QueenPositionCandidate construct(QueenPosition position, int col) {
        return QueenPositionCandidate.of(ImmutableSet.of(IndexCoordinate.of(2, 1)));
    }
}
