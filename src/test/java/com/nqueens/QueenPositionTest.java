package com.nqueens;

import com.google.common.collect.ImmutableSet;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QueenPositionTest {
    @Test
    void sameRow_shouldReturnFalse() {
        QueenPosition position = QueenPosition.of(ImmutableSet.of(IndexCoordinate.of(1, 2)));
        assertThat(position.isValid(IndexCoordinate.of(1, 3))).isFalse();
    }

    @Test
    void notSameRow_shouldReturnTrue() {
        QueenPosition position = QueenPosition.of(ImmutableSet.of(IndexCoordinate.of(1, 2)));
        assertThat(position.isValid(IndexCoordinate.of(3, 3))).isTrue();
    }

    @Test
    void sameCol_shouldReturnFalse() {
        QueenPosition position = QueenPosition.of(ImmutableSet.of(IndexCoordinate.of(1, 2)));
        assertThat(position.isValid(IndexCoordinate.of(3, 2))).isFalse();
    }

    @Test
    void notSameCol_shouldReturnTrue() {
        QueenPosition position = QueenPosition.of(ImmutableSet.of(IndexCoordinate.of(1, 2)));
        assertThat(position.isValid(IndexCoordinate.of(3, 3))).isTrue();
    }

    @Test
    void notDiagonalThreat_shouldReturnTrue() {
        QueenPosition position = QueenPosition.of(ImmutableSet.of(IndexCoordinate.of(0, 0)));
        assertThat(position.isValid(IndexCoordinate.of(2, 1))).isTrue();
    }

    @Test
    void onDiagonalThreat_shouldReturnFalse() {
        QueenPosition position = QueenPosition.of(ImmutableSet.of(IndexCoordinate.of(0, 0)));
        assertThat(position.isValid(IndexCoordinate.of(1, 1))).isFalse();
    }

}