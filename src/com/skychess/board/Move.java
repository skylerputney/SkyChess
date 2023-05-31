package com.skychess.board;

import com.skychess.pieces.King;
import com.skychess.pieces.Pawn;
import com.skychess.pieces.Piece;
import com.skychess.pieces.Rook;

import player.Player;

public class Move {
	Piece pieceToMove;
	Piece pieceToKill;
	Tile startTile;
	Tile endTile;
	Board b;
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
	
	public void executeMove(Player moveMaker){
		moveMaker.setPlayerTurn(false);
		Piece toMove = this.getPieceToMove();
		Tile oldTile = b.getTiles()[this.getSourceTile().getRank()][this.getSourceTile().getFile()];
		Tile destTile = this.getDestTile();
		destTile.setPiece(toMove);
		oldTile.clearTile();
		toMove.setCurrentTile(destTile);
		//add logic to change bln flag isFirstMove
		if(toMove instanceof Pawn)
			((Pawn) toMove).setFirstMove(false);
		else if(toMove instanceof King)
			((King)toMove).setFirstMove(false);
		else if(toMove instanceof Rook)
			((Rook)toMove).setFirstMove(false);
	}
	
//	public boolean equals(Move m) {
//		if (p == m.getPieceToMove() && this.endTile == m.getDestTile() && this.b == m.getBoard())
//			return true;
//		return false;
//	}
	

}
