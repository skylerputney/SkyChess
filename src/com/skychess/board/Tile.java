package com.skychess.board;

import com.skychess.pieces.Piece;

/**
 * tile on chess board
 * @author skyle
 *
 */
public class Tile {
    boolean isOccupied;
    private Piece pieceOnTile;
    private int rank, file;
    
    public Tile(int rank, int file) {
    	isOccupied = false;
    	rank = rank;
    	file = file;
    	pieceOnTile = null;
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
