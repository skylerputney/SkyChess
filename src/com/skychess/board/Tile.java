package com.skychess.board;

import com.skychess.pieces.Piece;

public class Tile {
    boolean isOccupied;
    Piece pieceOnTile;
    public boolean isOccupied() {
        return isOccupied;
    }

    public Piece getPiece() {
        return pieceOnTile;
    }
    public void setPiece(Piece p){
        this.pieceOnTile = p;
    }
}
