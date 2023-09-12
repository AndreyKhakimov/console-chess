package com.khakimov.board;

import com.khakimov.Coordinates;
import com.khakimov.File;
import com.khakimov.PieceFactory;

public class BoardFactory {

    private PieceFactory pieceFactory = new PieceFactory();

    public Board fromFEN(String fen) {
        Board board = new Board(fen);

        String[] parts = fen.split(" ");
        String fenPiecePositions = parts[0];

        String[] fenRows = fenPiecePositions.split("/");

        for (int i = 0; i < fenRows.length; i++) {
            String row = fenRows[i];
            int rank = 8 - i;

            int fileIndex = 0;
            for (int j = 0; j < row.length(); j++) {
                char fehChar = row.charAt(j);

                if (Character.isDigit(fehChar)) {
                    fileIndex += Character.getNumericValue(fehChar);
                } else {
                    File file = File.values()[fileIndex];
                    Coordinates coordinates = new Coordinates(file, rank);

                    board.setPiece(coordinates, pieceFactory.fromFenChar(fehChar, coordinates));
                    fileIndex++;
                }

            }
        }

        return board;
    }

    public Board copy(Board source) {
        Board clone = fromFEN(source.startingFen);

        for (Move move : source.moves) {
            clone.makeMove(move);
        }

        return clone;
    }
}
