package com.skychess.pieces;

import com.skychess.BoardUtilities;
import com.skychess.board.Tile;

public class Queen extends Piece{
	
	
    public Queen(Tile currentTile, boolean isWhite) {
        super(currentTile, isWhite);
    }

	@Override
	public int[][] getMoveVector() {
		int[][] moveVector = new int[BoardUtilities.STRAIGHT_MOVE_VECTOR.length + BoardUtilities.DIAGONAL_MOVE_VECTOR.length][];
		System.arraycopy(BoardUtilities.STRAIGHT_MOVE_VECTOR, 0, moveVector, 0, BoardUtilities.STRAIGHT_MOVE_VECTOR.length);
		System.arraycopy(BoardUtilities.DIAGONAL_MOVE_VECTOR, 0, moveVector, BoardUtilities.STRAIGHT_MOVE_VECTOR.length, BoardUtilities.DIAGONAL_MOVE_VECTOR.length);
		return moveVector;
	}

}
