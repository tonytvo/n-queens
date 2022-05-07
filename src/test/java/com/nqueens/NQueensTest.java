package com.nqueens;

import com.google.common.collect.ImmutableSet;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class NQueensTest {

    @Test
    public void foo() {
        NQueens nQueens = new NQueens();

        Set<QueenPosition> queenPositions = nQueens.findQueenPositions(4);

        Approvals.verify(queenPositions);
    }
}
