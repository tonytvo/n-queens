package com.nqueens;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

class NQueens {
    public QueenPositions findQueenPositions(int boardSize) {
        ChessBoard board = ChessBoard.of(boardSize);
        Set<IndexCoordinate> candidates = board.constructCandidates(QueenPosition.of(ImmutableSet.of()), 0);
        QueenPositions allValidPositions = QueenPositions.of(ImmutableSet.of());
        for (IndexCoordinate candidate : candidates) {
            QueenPosition validPosition = QueenPosition.of(ImmutableSet.of(candidate));
            findQueenPosition(allValidPositions, validPosition, 0, board);
        }
        return allValidPositions;
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
                findQueenPosition(allValidPositions, currentPosition.addValidPosition(candidate), col, chessBoard);
            }
        }
    }

}
