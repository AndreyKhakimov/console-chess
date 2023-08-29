package com.khakimov;

import java.util.ArrayList;
import java.util.List;

public class BoardUtils {
    public static List<Coordinates> getDiagonalCoordinatesBetween(Coordinates source, Coordinates target) {
        List<Coordinates> result = new ArrayList<>();

        // vertical shift, 1 right, -1 left
        int fileShift = source.file.ordinal() < target.file.ordinal() ? 1 : -1;
        // horizontal shift
        int rankShift = source.rank < target.rank ? 1 : -1;

        for (
                int fileIndex = source.file.ordinal() + fileShift,
                rank = source.rank + rankShift;

                fileIndex != target.file.ordinal() && rank != target.rank;

                fileIndex += fileShift, rank += rankShift
        ) {
            result.add(new Coordinates(File.values()[fileIndex], rank));
        }

        return result;
    }
}
