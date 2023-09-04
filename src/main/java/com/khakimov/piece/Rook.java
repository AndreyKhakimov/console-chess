package com.khakimov.piece;

import com.khakimov.Color;
import com.khakimov.Coordinates;

import java.util.HashSet;
import java.util.Set;

public class Rook extends LongRangePiece {

    public Rook(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        Set<CoordinatesShift> result = new HashSet<>();

        // left to right
        for (int i = -7; i <= 7 ; i++) {
            // skip the actual position of the rook
            if (i == 0) continue;

            result.add(new CoordinatesShift(i, 0));
        }

        // bottom to top
        for (int i = -7; i <= 7 ; i++) {
            // skip the actual position of the rook
            if (i == 0) continue;

            result.add(new CoordinatesShift(0, i));
        }

        return result;
    }
}
