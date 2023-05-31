package com.skychess.pieces;

import com.skychess.board.BoardUtilities;
import com.skychess.board.Tile;

public class Bishop extends Piece{
    public Bishop(Tile currentTile, boolean isWhite) {
        super(currentTile, isWhite);
    }
	@Override
	public int[][] getMoveVector() {
		return BoardUtilities.DIAGONAL_MOVE_VECTOR;
	}

}
