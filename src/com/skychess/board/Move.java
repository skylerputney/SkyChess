package com.skychess.board;

import com.skychess.pieces.Piece;

public class Move {
	Piece p;
	Tile endTile;
	Board b;
	public Move(Board b, Piece pieceToMove, Tile endTile) {
		this.p = pieceToMove;
		this.endTile = endTile;
		this.b = b;
	}
	
	public Piece getPieceToMove() {
		return p;
	}
	public Tile getDestTile() {
		return endTile;
	}

	public boolean isValid() {
		if (p.isValidMove(this))
			return true;
		return false;
	}
	public Board getBoard() {
		return b;
	}
	
	public boolean equals(Move m) {
		if (p == m.getPieceToMove() && this.endTile == m.getDestTile() && this.b == m.getBoard())
			return true;
		return false;
	}

}
