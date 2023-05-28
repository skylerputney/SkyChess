package com.skychess.pieces;

import com.skychess.board.Tile;

public class Knight extends Piece{
	
	private static final int[][] VALID_MOVES = {{2, 1}, {1, 2}, {2, -1}, {1, -2}, {-2, -1}, {-1, -2}, {-2, 1}, {-1, 2}};
    public Knight(Tile currentTile, boolean isWhite) {
        super(currentTile, isWhite);
    }
	@Override
	public int[][] getMoveVector() {
		return VALID_MOVES;
	}

	

}
