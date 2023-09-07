package com.khakimov.piece;

import com.khakimov.Color;
import com.khakimov.Coordinates;

import java.util.Set;

public class Bishop extends LongRangePiece implements IBishop{
    public Bishop(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
       return getBishopMoves();
    }
}
