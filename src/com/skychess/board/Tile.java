package com.skychess.board;

import com.skychess.pieces.Piece;

/**
 * tile on chess board
 * @author skyle
 *
 */
public class Tile {
    private Piece pieceOnTile;
    private int rank, file;
    
    public Tile(int rank, int file) {
    	this.rank = rank;
    	this.file = file;
    	pieceOnTile = null;
    }
    public boolean isOccupied() {
        return (pieceOnTile != null);
    }

    public Piece getPiece() {
        return pieceOnTile;
    }
    public void setPiece(Piece p){
        this.pieceOnTile = p;
    }
    public void clearTile() {
    	this.pieceOnTile = null;
    }
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getFile() {
		return file;
	}
	public void setFile(int file) {
		this.file = file;
	}
    
}
