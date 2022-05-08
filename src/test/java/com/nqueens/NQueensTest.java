package com.nqueens;

import com.google.common.collect.ImmutableSet;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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

        QueenPositionCandidate candidates = BoardInfo.of(3).construct(position, 1);

        assertThat(candidates).isEqualTo(QueenPositionCandidate.of(ImmutableSet.of(IndexCoordinate.of(2, 1))));
    }

    @Test
    void givenBoardSize4AndQueenPlacedAt00_shouldReturnQueenCandidatesAt21And31() {
        QueenPosition position = QueenPosition.of(ImmutableSet.of(IndexCoordinate.of(0, 0)));

        QueenPositionCandidate candidates = BoardInfo.of(4).construct(position, 1);

        assertThat(candidates).isEqualTo(QueenPositionCandidate.of(ImmutableSet.of(IndexCoordinate.of(2, 1),
                IndexCoordinate.of(3, 1))));
    }

    @Test
    void givenBoardSize4AndQueenPlacedAt20And01_shouldReturnQueenCandidatesAt32() {
        QueenPosition position = QueenPosition.of(ImmutableSet.of(IndexCoordinate.of(2, 0), IndexCoordinate.of(0, 1)));

        QueenPositionCandidate candidates = BoardInfo.of(4).construct(position, 2);

        assertThat(candidates).isEqualTo(QueenPositionCandidate.of(ImmutableSet.of(IndexCoordinate.of(3, 2))));
    }

}
