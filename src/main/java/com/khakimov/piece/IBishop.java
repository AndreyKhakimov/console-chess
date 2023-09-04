package com.khakimov.piece;

import java.util.HashSet;
import java.util.Set;

public interface IBishop {
    default Set<CoordinatesShift> getBishopMoves() {
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
}
