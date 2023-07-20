package com.khakimov.piece;

import com.khakimov.Color;
import com.khakimov.Coordinates;

abstract public class Piece {
    public final Color color;
    public Coordinates coordinates;

    public Piece(Color color, Coordinates coordinates) {
        this.color = color;
        this.coordinates = coordinates;
    }
}
