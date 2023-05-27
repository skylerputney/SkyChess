package com.skychess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.skychess.BoardUtilities;
import com.skychess.board.Board;
import com.skychess.board.Move;
import com.skychess.board.Tile;

public class Bishop extends Piece{
	private final static int[] MOVE_VECTOR = {-1, 1};
    public Bishop(int rank, int file, boolean isWhite) {
        super(rank, file, isWhite);
    }

	@Override
	public List<Move> getValidMoves(Board b) {
		List<Move> validMoves = new ArrayList<Move>();
		int startX = getRank();
		int startY = getFile();
		Tile t = b.getTile(startX, startY);
		for(int i : this.MOVE_VECTOR) {
			for(int j : this.MOVE_VECTOR) {
			while(startX + i < BoardUtilities.BOARD_WIDTH && startY + j < BoardUtilities.BOARD_WIDTH && !t.isOccupied()) {
				t = b.getTile(startX + i, startY + j);
				validMoves.add(new Move(b, this, t));
			}
		}
		}
		return validMoves;
	}

	@Override
	public boolean isValidMove(Move move) {
		if(getValidMoves(move.getBoard()).contains(move))
			return true;
		return false;
	}
}
