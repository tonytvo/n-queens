package com.nqueens;

import com.google.common.collect.ImmutableSet;

import java.util.HashSet;
import java.util.Set;

class NQueens {
    public Set<QueenPosition> findQueenPositions(int boardSize) {
        ChessBoard board = ChessBoard.of(boardSize);
        QueenPositionCandidate candidates = board.construct(QueenPosition.of(ImmutableSet.of()), 0);
        Set<QueenPosition> positions = new HashSet<>();
        for (IndexCoordinate candidate : candidates.getCandidates()) {
            QueenPosition validPosition = QueenPosition.of(ImmutableSet.of(candidate));
            findQueenPosition(validPosition, 0, board);
            if (validPosition.isValidSolution(boardSize)) {
                positions.add(validPosition);
            }
        }
        return positions;
    }

    public void findQueenPosition(QueenPosition currentPosition, int col, ChessBoard chessBoard) {
        // if valid solution -> process solution
        // if not
        //   construct candidates
        //   go through each candidate and update the currentPosition
        //
        if (currentPosition.isValidSolution(chessBoard.getSize())) {
            System.out.println("NQueens.findQueenPosition, a solution, currentPosition = " + currentPosition);
        } else {
            col++;
            QueenPositionCandidate candidates = chessBoard.construct(currentPosition, col);

            for (IndexCoordinate candidate : candidates.getCandidates()) {
                currentPosition.addValidPosition(candidate);
                findQueenPosition(currentPosition, col, chessBoard);
            }
        }
    }

}
