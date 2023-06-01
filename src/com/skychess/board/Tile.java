package com.skychess.board;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
    
	//returns true if this tile is at risk of being captured by an enemy piece
	public boolean isUnderThreat(Board b) {
		List<Move> l = Arrays.stream(b.getTiles()).flatMap(t -> Arrays.stream(t)).map(t -> t.getPiece()).filter(Objects::nonNull).filter(p -> p.isWhite() == b.getOpponent().isWhite()).map(p -> p.getValidMoves(b)).flatMap(m -> m.stream()).toList();
		for(Move m : l) {
			if(m.getDestTile().equals(this))
				return true;
		}
		return false;
	}
	
	public boolean equals(Object o) {
		if(!(o instanceof Tile))
			return false;
		if(this.getRank() == ((Tile) o).getRank() && ((Tile) o).getFile() == this.getFile())
			return true;
		return false;
	}
}
