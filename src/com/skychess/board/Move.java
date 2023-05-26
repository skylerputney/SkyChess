package com.skychess.board;

import com.skychess.pieces.Piece;

public class Move {
	Piece p;
	Tile endTile;
	public Move(Piece pieceToMove, Tile endTile) {
		this.p = pieceToMove;
		this.endTile = endTile;
	}
	
	public void executeMove(Board b) {
		b.getTile(p.getRank(), p.getFile()).clearTile();
		endTile.clearTile();
		endTile.setPiece(p);
	}

	public boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}

}
