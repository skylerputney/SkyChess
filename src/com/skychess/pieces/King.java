package com.skychess.pieces;

import com.skychess.BoardUtilities;
import com.skychess.board.Board;
import com.skychess.board.Tile;

public class King extends Piece {
    private boolean isFirstMove;

    public King(Tile occupiedTile, boolean isWhite, boolean firstMove) {
    	super(occupiedTile, isWhite);
        this.isFirstMove = firstMove;
    }

	@Override
	public int[][] getMoveVector() {
		int[][] moveVector = new int[BoardUtilities.STRAIGHT_MOVE_VECTOR.length + BoardUtilities.DIAGONAL_MOVE_VECTOR.length][];
		System.arraycopy(BoardUtilities.STRAIGHT_MOVE_VECTOR, 0, moveVector, 0, BoardUtilities.STRAIGHT_MOVE_VECTOR.length);
		System.arraycopy(BoardUtilities.DIAGONAL_MOVE_VECTOR, 0, moveVector, BoardUtilities.STRAIGHT_MOVE_VECTOR.length, BoardUtilities.DIAGONAL_MOVE_VECTOR.length);
		return moveVector;
	}
	
	public boolean canCastle(Board b) {
		/**
		 * Castling can occur if the following conditions are met:
		 * King nor Rook has previously moved
		 * No pieces exist between the king and the rook
		 * the king is NOT in check
		 * the king cannot pass over a tile which is currently under threat by an enemy piece
		 */
		Piece queenSide;
		Piece kingSide;
		if(!this.isFirstMove)
			return false;
		if(this.isWhite()) {
			queenSide = b.getTile(0, 7).getPiece();
			kingSide = b.getTile(7, 7).getPiece();
		}
		else {
			queenSide = b.getTile(0, 0).getPiece();
			kingSide = b.getTile(7, 0).getPiece();
		}
		
		return true;
	
	}
}
