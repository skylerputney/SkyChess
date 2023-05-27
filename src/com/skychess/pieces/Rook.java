package com.skychess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.skychess.board.Board;
import com.skychess.board.Move;

public class Rook extends Piece{
    public Rook(int rank, int file, boolean isWhite) {
        super(rank, file, isWhite);
    }

	@Override
	public List<Move> getValidMoves(Board b) {
		List<Move> validMoves = new ArrayList<Move>();
		return validMoves;
	}

	@Override
	public boolean isValidMove(Move move) {
		// TODO Auto-generated method stub
		return true;
	}
}
