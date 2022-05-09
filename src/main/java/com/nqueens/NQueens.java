package com.nqueens;

import com.google.common.collect.ImmutableSet;

import java.util.Optional;
import java.util.Set;

class NQueens {
    public QueenPositions findQueenPositions(int boardSize) {
        ChessBoard board = ChessBoard.of(boardSize);
        Set<IndexCoordinate> candidates = board.constructCandidates(QueenPosition.of(ImmutableSet.of()), 0);
        Optional<QueenPositions> queenPositionsForFirstColumnCandidates = candidates.parallelStream()
                .map(candidate -> findAllQueenPositionsForSingleCandidate(candidate, board))
                .reduce(QueenPositions::merge);
        return queenPositionsForFirstColumnCandidates.get();
    }

    public void findQueenPosition(QueenPositions allValidPositions,
                                  QueenPosition currentPosition,
                                  int col,
                                  ChessBoard chessBoard) {
        // if valid solution -> process solution
        // if not
        //   construct candidates
        //   go through each candidate and update the currentPosition
        //
        if (chessBoard.isValidSolution(currentPosition)) {
            //todo is there a way to avoid side effects?
            allValidPositions.add(currentPosition);
        } else {
            col++;
            Set<IndexCoordinate> candidates = chessBoard.constructCandidates(currentPosition, col);
            for (IndexCoordinate candidate : candidates) {
                findQueenPosition(allValidPositions, currentPosition.addValidQueenPosition(candidate), col, chessBoard);
            }
        }
    }

    private QueenPositions findAllQueenPositionsForSingleCandidate(IndexCoordinate candidate, ChessBoard board) {
        QueenPositions allValidPositions = QueenPositions.of(ImmutableSet.of());
        QueenPosition currentPosition = QueenPosition.of(ImmutableSet.of(candidate));
        findQueenPosition(allValidPositions, currentPosition, 0, board);
        return allValidPositions;
    }

}
