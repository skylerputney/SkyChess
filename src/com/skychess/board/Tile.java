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
    //updates current piece and returns previous piece
    public Piece setPiece(Piece p){
    	Piece current = this.pieceOnTile;
        this.pieceOnTile = p;
        return current;
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
		List<Move> l = Arrays.stream(b.getTiles()).flatMap(t -> Arrays.stream(t)).map(t -> t.getPiece()).filter(Objects::nonNull).map(p -> p.getValidMoves(b)).flatMap(m -> m.stream()).toList();	//.filter(p -> b.getOpponent().isWhite() == p.isWhite()  )
																																		//logic here is only returning white pieces
		for(Move m : l) {
			if(m.getDestTile().equals(this) && b.getOpponent().isWhite() == m.getPieceToMove().isWhite())
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
