package com.skychess.board;

import com.skychess.pieces.Piece;

public class Move {
	Piece p;
	Tile endTile;
	public Move(Piece pieceToMove, Tile endTile) {
		this.p = pieceToMove;
		this.endTile = endTile;
	}
	
	public Piece getPieceToMove() {
		return p;
	}
	public Tile getDestTile() {
		return endTile;
	}

	public boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}

}
