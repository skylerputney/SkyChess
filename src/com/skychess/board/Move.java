package com.skychess.board;

import java.util.ArrayList;
import java.util.List;

import com.skychess.pieces.King;
import com.skychess.pieces.Pawn;
import com.skychess.pieces.Piece;
import com.skychess.pieces.Rook;

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
	
	
	public boolean equals(Move m) {
		if (pieceToMove == m.getPieceToMove() && this.endTile == m.getDestTile() && this.b == m.getBoard())
			return true;
		return false;
	}
	
	public boolean isCastlingMove() {
		List<Move> possibleCastleMoves = new ArrayList<Move>();
		Piece toMove = this.getPieceToMove();
		if(toMove instanceof King) {
			King king = (King) toMove;
			possibleCastleMoves = king.getCastleMoves(b);
			if(possibleCastleMoves.stream().anyMatch(m -> m.equals(this)))
					return true;
		}
		return false;
	}
	
	public void executeMove(){
		boolean successfulMove = true;
		Piece toMove = this.getPieceToMove();
		Tile oldTile = this.getSourceTile();
		Tile destTile = this.getDestTile();
		if(!isCastlingMove()) {
			Piece killedPiece = destTile.setPiece(toMove);
			oldTile.clearTile();
			toMove.setCurrentTile(destTile);
			if(this.getBoard().getCurrentPlayer().isInCheck(this.getBoard())) {
				toMove.setCurrentTile(oldTile);
				destTile.setPiece(killedPiece);
				oldTile.setPiece(toMove);
				successfulMove = false;
			}
		}
		else {
			Piece assumedRook = destTile.getPiece();
			if(assumedRook instanceof Rook && toMove instanceof King) {
				Rook rook = (Rook) assumedRook;
				Tile rookTile = rook.getCurrentTile();
				int rookFile = rookTile.getFile();
				int rookRank = rookTile.getRank();
				switch(rookFile) {
				case 0:
					if(rookRank == 0) {
						b.getTile(2, 0).setPiece(toMove);
						toMove.setCurrentTile(b.getTile(2, 0));
						rook.setCurrentTile(b.getTile(3, 0));
						b.getTile(3, 0).setPiece(rook);
					}
					else if(rookRank == 7) {
						b.getTile(6, 0).setPiece(toMove);
						toMove.setCurrentTile(b.getTile(6, 0));
						rook.setCurrentTile(b.getTile(5, 0));
						b.getTile(5, 0).setPiece(rook);
					}
				case 7:
					if(rookRank == 0) {
						b.getTile(2, 7).setPiece(toMove);
						toMove.setCurrentTile(b.getTile(2, 7));
						rook.setCurrentTile(b.getTile(3, 7));
						b.getTile(3, 7).setPiece(rook);
					}
					else if(rookRank == 7) {
						b.getTile(6, 7).setPiece(toMove);
						toMove.setCurrentTile(b.getTile(6, 7));
						rook.setCurrentTile(b.getTile(5, 7));
						b.getTile(5, 7).setPiece(rook);
					}
				}
				rook.setFirstMove(false);
				oldTile.clearTile();
				destTile.clearTile();
			}
		}
		if(successfulMove) {
			this.getBoard().setEnPassantPawn(null);
			if(toMove instanceof Pawn) {
				((Pawn) toMove).setFirstMove(false);
				if(destTile.getFile() == oldTile.getFile() + ((Pawn)toMove).getDirection() * 2)
					this.getBoard().setEnPassantPawn((Pawn) toMove);
			}
			else if(toMove instanceof King) {
				((King)toMove).setFirstMove(false);
				System.out.println("Player: Castle Move for" + toMove);
			}
			else if(toMove instanceof Rook) {
				((Rook)toMove).setFirstMove(false);
			}
			this.getBoard().updateCurrentPlayer();
		}
	}

}
