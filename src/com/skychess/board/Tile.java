package com.skychess.board;

import com.skychess.pieces.Piece;

public class Tile {
    boolean isOccupied;
    private Piece pieceOnTile;
    
    public Tile() {
    	isOccupied = false;
    }
    public boolean isOccupied() {
        return isOccupied;
    }

    public Piece getPiece() {
        return pieceOnTile;
    }
    public void setPiece(Piece p){
        this.pieceOnTile = p;
        this.isOccupied = true;
    }
    public void clearTile() {
    	this.pieceOnTile = null;
    	this.isOccupied = false;
    }
    
}
