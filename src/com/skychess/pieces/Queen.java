package com.skychess.pieces;

import java.util.List;

import com.skychess.board.Board;
import com.skychess.board.Move;
import com.skychess.board.Tile;

public class Queen extends Piece{
    public Queen(Tile currentTile, boolean isWhite) {
        super(currentTile, isWhite);
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
