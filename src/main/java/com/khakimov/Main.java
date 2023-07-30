package com.khakimov;

import com.khakimov.piece.Piece;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Board board = new BoardFactory().fromFEN("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");

        BoardConsoleRenderer renderer = new BoardConsoleRenderer();
        renderer.render(board);

//        Game game = new Game(board);
//        game.gameLoop();
    }
}