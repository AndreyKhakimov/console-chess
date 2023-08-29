package com.khakimov.piece;

import com.khakimov.Board;
import com.khakimov.BoardUtils;
import com.khakimov.Color;
import com.khakimov.Coordinates;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bishop extends Piece {
    public Bishop(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        Set<CoordinatesShift> result = new HashSet<>();

        // bottom-left to top-right
        for (int i = -7; i <= 7 ; i++) {
            // skip the actual position of the bishop
            if (i == 0) continue;

            result.add(new CoordinatesShift(i, i));
        }

        // top-left to bottom-right
        for (int i = -7; i <= 7 ; i++) {
            // skip the actual position of the bishop
            if (i == 0) continue;

            result.add(new CoordinatesShift(i, -i));
        }

        return result;
    }

    @Override
    protected boolean isSquareAvailableForMove(Coordinates coordinates, Board board) {
        boolean result = super.isSquareAvailableForMove(coordinates, board);

        if (result) {
            List<Coordinates> coordinatesBetween = BoardUtils.getDiagonalCoordinatesBetween(this.coordinates, coordinates);

            for (Coordinates c : coordinatesBetween) {
                if (!board.isSquareEmpty(c)) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }


    }
}
