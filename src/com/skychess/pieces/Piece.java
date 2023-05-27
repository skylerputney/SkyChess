package com.skychess.pieces;

import java.util.List;

import com.skychess.BoardUtilities;
import com.skychess.board.Board;
import com.skychess.board.Move;
import com.skychess.board.Tile;

public abstract class Piece {
	
    private boolean isWhite;
    private Tile currentTile;

    public Piece(Tile currentTile, boolean isWhite) {
        this.isWhite = isWhite;
        this.currentTile = currentTile;
    }

    public boolean isWhite() {
        return isWhite;
    }
    
    public abstract List<Move> getValidMoves(Board b);

	
    public int getDirection() {
    	if(this.isWhite())
    		return BoardUtilities.WHITE_DIRECTION;
    	return BoardUtilities.BLACK_DIRECTION;
    }
    
    public Tile getCurrentTile() {
    	return this.currentTile;
    }
    
    public void setCurrentTile(Tile tile) {
    	this.currentTile = tile;
    }
    
	public boolean isValidMove(Move move) {
		for(Move m : getValidMoves(move.getBoard())) {
			if(m.getDestTile() == move.getDestTile() && m.getPieceToMove() == move.getPieceToMove())
				return true;
		}
		System.out.println("false");
		return false;
	}
    
}
