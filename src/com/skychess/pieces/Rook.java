package com.skychess.pieces;

import com.skychess.BoardUtilities;
import com.skychess.board.Tile;

public class Rook extends Piece{
	
	private boolean firstMove;
	
    public Rook(Tile currentTile, boolean isWhite, boolean isFirstMove) {
        super(currentTile, isWhite);
        this.firstMove = isFirstMove;
    }

	@Override
	public int[][] getMoveVector() {
		return BoardUtilities.STRAIGHT_MOVE_VECTOR;
	}
	
	public boolean isFirstMove() {
		return this.firstMove;
	}

}
