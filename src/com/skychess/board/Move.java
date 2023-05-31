package com.skychess.board;

import com.skychess.pieces.Piece;

public class Move {
	private Piece pieceToMove;
	private Piece pieceToKill;
	private Tile startTile;
	private Tile endTile;
	private Board b;
	public Move(Board b, Tile startTile, Tile endTile) {
		this.startTile = startTile;
		this.endTile = endTile;
		this.b = b;
		this.pieceToMove = startTile.getPiece();
	}
	
	public Piece getPieceToMove() {
		return pieceToMove;
	}
	public Tile getDestTile() {
		return endTile;
	}
	public Tile getSourceTile() {
		return startTile;
	}

	public boolean isValid() {
		if(pieceToMove == null)
			return false;
		if (pieceToMove.isValidMove(this))
			return true;
		return false;
	}
	public Board getBoard() {
		return b;
	}
	
	
//	public boolean equals(Move m) {
//		if (p == m.getPieceToMove() && this.endTile == m.getDestTile() && this.b == m.getBoard())
//			return true;
//		return false;
//	}
	

}
