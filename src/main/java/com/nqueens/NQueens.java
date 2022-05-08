package com.nqueens;

import com.google.common.collect.ImmutableSet;

import java.util.HashSet;
import java.util.Set;

class NQueens {
    public QueenPositions findQueenPositions(int boardSize) {
        ChessBoard board = ChessBoard.of(boardSize);
        QueenPositionCandidate candidates = board.construct(QueenPosition.of(ImmutableSet.of()), 0);
        QueenPositions allValidPositions = QueenPositions.of(ImmutableSet.of());
        for (IndexCoordinate candidate : candidates.getCandidates()) {
            QueenPosition validPosition = QueenPosition.of(ImmutableSet.of(candidate));
            findQueenPosition(allValidPositions, validPosition, 0, board);
            if (validPosition.isValidSolution(boardSize)) {
                allValidPositions.add(validPosition);
            }
        }
        return allValidPositions;
    }

    public void findQueenPosition(QueenPositions allValidPositions, QueenPosition currentPosition, int col, ChessBoard chessBoard) {
        // if valid solution -> process solution
        // if not
        //   construct candidates
        //   go through each candidate and update the currentPosition
        //
        if (currentPosition.isValidSolution(chessBoard.getSize())) {
            allValidPositions.add(currentPosition);
        } else {
            col++;
            QueenPositionCandidate candidates = chessBoard.construct(currentPosition, col);
            for (IndexCoordinate candidate : candidates.getCandidates()) {
                findQueenPosition(allValidPositions, currentPosition.addValidPosition(candidate), col, chessBoard);
            }
        }
    }

}
