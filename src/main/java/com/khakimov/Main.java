package com.khakimov;

import com.khakimov.board.Board;
import com.khakimov.board.BoardFactory;

public class Main {
    public static void main(String[] args) {
        Board board = new BoardFactory().fromFEN("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");

        BoardConsoleRenderer renderer = new BoardConsoleRenderer();
        renderer.render(board);

//        Game game = new Game(board);
//        game.gameLoop();
    }
}