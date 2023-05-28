package com.skychess.pieces;

import com.skychess.BoardUtilities;
import com.skychess.board.Tile;

public class Rook extends Piece{
	
	boolean firstMove;
	
    public Rook(Tile currentTile, boolean isWhite, boolean isFirstMove) {
        super(currentTile, isWhite);
        this.firstMove = firstMove;
    }

	@Override
	public int[][] getMoveVector() {
		return BoardUtilities.STRAIGHT_MOVE_VECTOR;
	}

}
