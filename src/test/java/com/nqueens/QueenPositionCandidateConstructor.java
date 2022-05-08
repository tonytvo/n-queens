package com.nqueens;

import com.google.common.collect.ImmutableSet;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QueenPositionCandidateConstructor {
    public QueenPositionCandidate construct(QueenPosition position, int col, BoardInfo boardInfo) {
        Set<IndexCoordinate> candidates = getAllCoordinateForCol(col, boardInfo).stream().filter(position::isValid).collect(Collectors.toSet());
        return QueenPositionCandidate.of(ImmutableSet.copyOf(candidates));
    }

    private Set<IndexCoordinate> getAllCoordinateForCol(int col, BoardInfo boardInfo) {
        return IntStream.range(0, boardInfo.getSize())
                .mapToObj(row -> IndexCoordinate.of(row, col))
                .collect(Collectors.toSet());
    }
}
