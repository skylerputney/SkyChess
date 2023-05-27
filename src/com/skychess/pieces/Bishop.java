package com.skychess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.skychess.BoardUtilities;
import com.skychess.board.Board;
import com.skychess.board.Move;
import com.skychess.board.Tile;

public class Bishop extends Piece{
	private final static int[] MOVE_VECTOR = {-1, 1};
    public Bishop(Tile currentTile, boolean isWhite) {
        super(currentTile, isWhite);
    }

	@Override
	public List<Move> getValidMoves(Board b) {
		List<Move> validMoves = new ArrayList<Move>();
		int startX = getCurrentTile().getRank();
		int startY = getCurrentTile().getFile();
		Tile t = b.getTile(startX, startY);
		for(int i : this.MOVE_VECTOR) {
			for(int j : this.MOVE_VECTOR) {
			while(startX + i < BoardUtilities.BOARD_WIDTH && startY + j < BoardUtilities.BOARD_WIDTH && !t.isOccupied()) {
				t = b.getTile(startX + i, startY + j);
				validMoves.add(new Move(b, getCurrentTile(), t));
			}
		}
		}
		return validMoves;
	}

}
