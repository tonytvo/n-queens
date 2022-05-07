package com.nqueens;

import com.google.common.collect.ImmutableSet;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class NQueensTest {

    @Disabled
    @Test
    public void givenBoardSizeOf4_shouldReturn2QueenPositions() {
        NQueens nQueens = new NQueens();

        Set<QueenPosition> queenPositions = nQueens.findQueenPositions(4);

        Approvals.verify(queenPositions);
    }

    @Test
    void givenBoardSize3AndQueenPlacedAt00_shouldReturnQueenCandidatesAt21() {
        QueenPosition position = QueenPosition.of(ImmutableSet.of(IndexCoordinate.of(0, 0)));

        QueenPositionCandidate candidates = new QueenPositionCandidateConstructor().construct(position, 1);

        Approvals.verify(candidates);
    }
}
