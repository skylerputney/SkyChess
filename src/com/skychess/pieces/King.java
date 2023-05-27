package com.skychess.pieces;

import java.util.List;

import com.skychess.board.Board;
import com.skychess.board.Move;

public class King extends Piece {
    private boolean isFirstMove;

    public King(int rank, int file, boolean isWhite, boolean firstMove) {
    	super(rank, file, isWhite);
        this.isFirstMove = firstMove;
    }

	@Override
	public List<Move> getValidMoves(Board b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValidMove(Move move) {
		// TODO Auto-generated method stub
		return false;
	}
}
