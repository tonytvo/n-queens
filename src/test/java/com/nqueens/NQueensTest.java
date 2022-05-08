package com.nqueens;

import com.google.common.collect.ImmutableSet;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class NQueensTest {

    @Test
    public void givenBoardSizeOf4_shouldReturn2QueenPositions() {
        NQueens nQueens = new NQueens();

        Set<QueenPosition> queenPositions = nQueens.findQueenPositions(4);

        QueenPosition validPosition1 = QueenPosition.of(ImmutableSet.of(
                IndexCoordinate.of(3, 2),
                IndexCoordinate.of(0, 1),
                IndexCoordinate.of(1, 3),
                IndexCoordinate.of(2, 0)
        ));
        QueenPosition validPosition2 = QueenPosition.of(ImmutableSet.of(
                IndexCoordinate.of(1, 0),
                IndexCoordinate.of(2, 3),
                IndexCoordinate.of(0, 2),
                IndexCoordinate.of(3, 1)
        ));

        assertThat(queenPositions).isEqualTo(ImmutableSet.of(validPosition1, validPosition2));
    }

    @Test
    public void givenCurrentPositionIsAt10_findQueenPositionShouldReturnThePosition10230231() {
        NQueens nQueens = new NQueens();

        QueenPosition queenPosition = QueenPosition.of(ImmutableSet.of(IndexCoordinate.of(1, 0)));
        nQueens.findQueenPosition(queenPosition, 0, ChessBoard.of(4));

        QueenPosition validPosition = QueenPosition.of(ImmutableSet.of(
                IndexCoordinate.of(1, 0),
                IndexCoordinate.of(2, 3),
                IndexCoordinate.of(0, 2),
                IndexCoordinate.of(3, 1)
        ));
        assertThat(queenPosition).isEqualTo(validPosition);
    }

    @Test
    public void givenCurrentPositionIsAt00_findQueenPositionShouldReturnThePositionWithOnly3Coordinates() {
        NQueens nQueens = new NQueens();

        QueenPosition queenPosition = QueenPosition.of(ImmutableSet.of(IndexCoordinate.of(0, 0)));
        nQueens.findQueenPosition(queenPosition, 0, ChessBoard.of(4));

        assertThat(queenPosition).isEqualTo(QueenPosition.of(ImmutableSet.of(IndexCoordinate.of(2, 1), IndexCoordinate.of(0, 0), IndexCoordinate.of(3, 1))));
    }

    @Test
    public void givenCurrentPositionIsAt20_findQueenPositionShouldReturnThePosition() {
        NQueens nQueens = new NQueens();

        QueenPosition queenPosition = QueenPosition.of(ImmutableSet.of(IndexCoordinate.of(2, 0)));
        nQueens.findQueenPosition(queenPosition, 0, ChessBoard.of(4));

        QueenPosition validPosition = QueenPosition.of(ImmutableSet.of(
                IndexCoordinate.of(3, 2),
                IndexCoordinate.of(0, 1),
                IndexCoordinate.of(1, 3),
                IndexCoordinate.of(2, 0)
        ));
        assertThat(queenPosition).isEqualTo(validPosition);
    }

    @Test
    void givenBoardSize3AndQueenPlacedAt00_shouldReturnQueenCandidatesAt21() {
        QueenPosition position = QueenPosition.of(ImmutableSet.of(IndexCoordinate.of(0, 0)));

        QueenPositionCandidate candidates = ChessBoard.of(3).construct(position, 1);

        assertThat(candidates).isEqualTo(QueenPositionCandidate.of(ImmutableSet.of(IndexCoordinate.of(2, 1))));
    }

    @Test
    void givenBoardSize4AndQueenPlacedAt00_shouldReturnQueenCandidatesAt21And31() {
        QueenPosition position = QueenPosition.of(ImmutableSet.of(IndexCoordinate.of(0, 0)));

        QueenPositionCandidate candidates = ChessBoard.of(4).construct(position, 1);

        assertThat(candidates).isEqualTo(QueenPositionCandidate.of(ImmutableSet.of(IndexCoordinate.of(2, 1),
                IndexCoordinate.of(3, 1))));
    }

    @Test
    void givenBoardSize4AndQueenPlacedAt20And01_shouldReturnQueenCandidatesAt32() {
        QueenPosition position = QueenPosition.of(ImmutableSet.of(IndexCoordinate.of(2, 0), IndexCoordinate.of(0, 1)));

        QueenPositionCandidate candidates = ChessBoard.of(4).construct(position, 2);

        assertThat(candidates).isEqualTo(QueenPositionCandidate.of(ImmutableSet.of(IndexCoordinate.of(3, 2))));
    }

}
