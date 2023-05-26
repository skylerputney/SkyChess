package com.skychess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.skychess.BoardUtilities;
import com.skychess.board.Board;
import com.skychess.board.Move;

public class Pawn extends Piece {
    private boolean isFirstMove;

    public Pawn(int rank, int file, boolean isWhite, boolean firstMove) {
        super(rank, file, isWhite);
        this.isFirstMove = firstMove;
    }

	public List<Move> getValidMoves(Board b) {
		List<Move> validMoves = new ArrayList<Move>();
		for(int j = this.getFile(); j < BoardUtilities.BOARD_WIDTH; j++) {
			if(!b.getTile(this.getRank(), j).isOccupied()) {
				validMoves.add(new Move(this, b.getTile(this.getRank(), j)));
			}
			else {
				if (b.getTile(this.getRank(), j).getPiece().isWhite() != this.isWhite()) {
					//logic for en-passant Pawns
				}
			}
		}
		return validMoves;
	}
}
