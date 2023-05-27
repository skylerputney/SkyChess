package com.skychess.pieces;

import java.util.List;

import com.skychess.board.Board;
import com.skychess.board.Move;

public class Queen extends Piece{
    public Queen(int rank, int file, boolean isWhite) {
        super(rank, file, isWhite);
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
