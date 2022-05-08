package com.nqueens;

import com.google.common.collect.ImmutableSet;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NQueensTest {

    @Test
    public void givenBoardSizeOf4_shouldReturn2QueenPositions() {
        NQueens nQueens = new NQueens();

        QueenPositions queenPositions = nQueens.findQueenPositions(4);

        QueenPosition validPosition1 = createQueenPosition(
                IndexCoordinate.of(3, 2),
                IndexCoordinate.of(0, 1),
                IndexCoordinate.of(1, 3),
                IndexCoordinate.of(2, 0)
        );
        QueenPosition validPosition2 = createQueenPosition(
                IndexCoordinate.of(1, 0),
                IndexCoordinate.of(2, 3),
                IndexCoordinate.of(0, 2),
                IndexCoordinate.of(3, 1)
        );

        assertThat(queenPositions).isEqualTo(QueenPositions.of(ImmutableSet.of(validPosition1, validPosition2)));
    }

    @Test
    public void givenBoardSizeOf8_shouldReturn92QueenPositions() {
        NQueens nQueens = new NQueens();

        QueenPositions queenPositions = nQueens.findQueenPositions(8);

        assertThat(queenPositions.totalSolutions()).isEqualTo(92);
    }

    @Test
    public void givenBoardSizeOf6_shouldReturn4QueenPositions() {
        NQueens nQueens = new NQueens();

        QueenPositions queenPositions = nQueens.findQueenPositions(6);

        assertThat(queenPositions.totalSolutions()).isEqualTo(4);
    }

    @Test
    public void givenBoardSizeOf7_shouldReturn40QueenPositions() {
        NQueens nQueens = new NQueens();

        QueenPositions queenPositions = nQueens.findQueenPositions(7);

        assertThat(queenPositions.totalSolutions()).isEqualTo(40);
    }

    private QueenPositions createSingleQueenPositions(IndexCoordinate... coordinates) {
        return QueenPositions.of(ImmutableSet.of(QueenPosition.of(ImmutableSet.copyOf(coordinates))));
    }

    private QueenPosition createQueenPosition(IndexCoordinate... coordinates) {
        return QueenPosition.of(ImmutableSet.copyOf(coordinates));
    }

    @Test
    public void givenBoardSizeOf5_shouldReturn10Solution() {
        NQueens nQueens = new NQueens();

        QueenPositions queenPositions = nQueens.findQueenPositions(5);

        QueenPosition validPosition1 = createQueenPosition(
                IndexCoordinate.of(1, 0),
                IndexCoordinate.of(2, 2),
                IndexCoordinate.of(3, 4),
                IndexCoordinate.of(0, 3),
                IndexCoordinate.of(4, 1)
        );
        QueenPosition validPosition2 = createQueenPosition(
                IndexCoordinate.of(1, 0),
                IndexCoordinate.of(4, 4),
                IndexCoordinate.of(2, 3),
                IndexCoordinate.of(0, 2),
                IndexCoordinate.of(3, 1)
        );

        QueenPosition validPosition3 = createQueenPosition(
                IndexCoordinate.of(2, 1),
                IndexCoordinate.of(0, 0),
                IndexCoordinate.of(3, 4),
                IndexCoordinate.of(1, 3),
                IndexCoordinate.of(4, 2)
        );

        QueenPosition validPosition4 = createQueenPosition(
                IndexCoordinate.of(4, 3),
                IndexCoordinate.of(0, 0),
                IndexCoordinate.of(1, 2),
                IndexCoordinate.of(2, 4),
                IndexCoordinate.of(3, 1)
        );

        QueenPosition validPosition5 = createQueenPosition(
                IndexCoordinate.of(2, 1),
                IndexCoordinate.of(3, 3),
                IndexCoordinate.of(0, 2),
                IndexCoordinate.of(1, 4),
                IndexCoordinate.of(4, 0)
        );

        QueenPosition validPosition6 = createQueenPosition(IndexCoordinate.of(3, 2),
                IndexCoordinate.of(1, 1),
                IndexCoordinate.of(2, 4),
                IndexCoordinate.of(0, 3),
                IndexCoordinate.of(4, 0));

        QueenPosition validPosition7 = createQueenPosition(IndexCoordinate.of(1, 1),
                IndexCoordinate.of(2, 3),
                IndexCoordinate.of(0, 4),
                IndexCoordinate.of(3, 0),
                IndexCoordinate.of(4, 2));

        QueenPosition validPosition8 = createQueenPosition(IndexCoordinate.of(4, 3),
                IndexCoordinate.of(2, 2),
                IndexCoordinate.of(0, 1),
                IndexCoordinate.of(1, 4),
                IndexCoordinate.of(3, 0));

        QueenPosition validPosition9 = createQueenPosition(IndexCoordinate.of(3, 2),
                IndexCoordinate.of(4, 4),
                IndexCoordinate.of(0, 1),
                IndexCoordinate.of(1, 3),
                IndexCoordinate.of(2, 0));

        QueenPosition validPosition10 = createQueenPosition(IndexCoordinate.of(3, 3),
                IndexCoordinate.of(1, 2),
                IndexCoordinate.of(0, 4),
                IndexCoordinate.of(4, 1),
                IndexCoordinate.of(2, 0));

        assertThat(queenPositions).isEqualTo(QueenPositions.of(ImmutableSet.of(
                validPosition1,
                validPosition2,
                validPosition3,
                validPosition4,
                validPosition5,
                validPosition6,
                validPosition7,
                validPosition8,
                validPosition9,
                validPosition10
        )));
    }

    @Test
    public void givenCurrentPositionIsAt10_findQueenPositionShouldReturnThePosition10230231() {
        NQueens nQueens = new NQueens();

        QueenPosition queenPosition = QueenPosition.of(ImmutableSet.of(IndexCoordinate.of(1, 0)));
        QueenPositions validPositions = QueenPositions.of(ImmutableSet.of());
        nQueens.findQueenPosition(validPositions, queenPosition, 0, ChessBoard.of(4));

        QueenPositions expected = createSingleQueenPositions(
                IndexCoordinate.of(1, 0),
                IndexCoordinate.of(2, 3),
                IndexCoordinate.of(0, 2),
                IndexCoordinate.of(3, 1)
        );
        assertThat(validPositions).isEqualTo(expected);
    }

    @Test
    public void givenCurrentPositionIsAt10And41_findQueenPositionShouldReturnThePosition10230231() {
        NQueens nQueens = new NQueens();

        QueenPosition queenPosition = QueenPosition.of(ImmutableSet.of(IndexCoordinate.of(1, 0),
                IndexCoordinate.of(4, 1)));
        QueenPositions validPositions = QueenPositions.of(ImmutableSet.of());
        nQueens.findQueenPosition(validPositions, queenPosition, 1, ChessBoard.of(5));

        QueenPositions expected = createSingleQueenPositions(
                IndexCoordinate.of(1, 0),
                IndexCoordinate.of(2, 2),
                IndexCoordinate.of(3, 4),
                IndexCoordinate.of(0, 3),
                IndexCoordinate.of(4, 1)
        );
        assertThat(validPositions).isEqualTo(expected);
    }

    @Test
    public void givenCurrentPositionIsAt20_findQueenPositionShouldReturnThePosition() {
        NQueens nQueens = new NQueens();

        QueenPositions validPositions = QueenPositions.of(ImmutableSet.of());
        QueenPosition queenPosition = QueenPosition.of(ImmutableSet.of(IndexCoordinate.of(2, 0)));
        nQueens.findQueenPosition(validPositions, queenPosition, 0, ChessBoard.of(4));

        QueenPositions expected = createSingleQueenPositions(
                IndexCoordinate.of(3, 2),
                IndexCoordinate.of(0, 1),
                IndexCoordinate.of(1, 3),
                IndexCoordinate.of(2, 0)
        );
        assertThat(validPositions).isEqualTo(expected);
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
