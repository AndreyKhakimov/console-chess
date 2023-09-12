package com.khakimov;

import com.khakimov.board.Board;
import com.khakimov.board.Move;

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

            Move move = InputCoordinates.inputMove(board, isWhiteToMove ? Color.WHITE : Color.BLACK, renderer);

            // make move
            board.makeMove(move);

            // pass move
            isWhiteToMove =! isWhiteToMove;
        }
    }
}
