package com.khakimov;

import com.khakimov.piece.Piece;

import java.util.Set;

public class Game {

    private final Board board;

    private final BoardConsoleRenderer renderer = new BoardConsoleRenderer();

    public Game(Board board) {
        this.board = board;
    }

    public void gameLoop() {
        boolean isWhiteToMove = true;

        while (true) {
            renderer.render(board);

            if (isWhiteToMove) {
                System.out.println("White to move");
            } else {
                System.out.println("Black to move");
            }
            // read input
            Coordinates sourceCoordinates = InputCoordinates.inputPieceCoordinatesForColor(
                    isWhiteToMove ? Color.WHITE : Color.BLACK, board
            );

            Piece piece = board.getPiece(sourceCoordinates);
            Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquares(board);

            Coordinates targetCoordinates = InputCoordinates.inputAvailableSquare(availableMoveSquares);

            // make move
            board.movePiece(sourceCoordinates, targetCoordinates);

            // pass move
            isWhiteToMove =! isWhiteToMove;
        }
    }
}
