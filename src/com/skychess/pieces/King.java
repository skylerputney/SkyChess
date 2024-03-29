package com.skychess.pieces;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.skychess.board.Board;
import com.skychess.board.BoardUtilities;
import com.skychess.board.Move;
import com.skychess.board.Tile;

public class King extends Piece {
    private boolean isFirstMove;

    public King(Tile occupiedTile, boolean isWhite, boolean firstMove) {
    	super(occupiedTile, isWhite);
        this.isFirstMove = firstMove;
    }

	@Override
	public int[][] getMoveVector() {
		int[][] moveVector = new int[BoardUtilities.STRAIGHT_MOVE_VECTOR.length + BoardUtilities.DIAGONAL_MOVE_VECTOR.length][];
		System.arraycopy(BoardUtilities.STRAIGHT_MOVE_VECTOR, 0, moveVector, 0, BoardUtilities.STRAIGHT_MOVE_VECTOR.length);
		System.arraycopy(BoardUtilities.DIAGONAL_MOVE_VECTOR, 0, moveVector, BoardUtilities.STRAIGHT_MOVE_VECTOR.length, BoardUtilities.DIAGONAL_MOVE_VECTOR.length);
		return moveVector;
	}
	
	public boolean canCastle(Board b) {
		/**
		 * Castling can occur if the following conditions are met:
		 * King nor Rook has previously moved
		 * No pieces exist between the king and the rook
		 * the king is NOT in check
		 * the king cannot pass over a tile which is currently under threat by an enemy piece
		 */
		
		return true;
	
	}
	
	public boolean isInCheck(Board b) {
		return this.getCurrentTile().isUnderThreat(b);
	}
	
	public List<Move> getCastleMoves(Board b) {
		List<Move> validMoves = new ArrayList<Move>();
		if(!this.isFirstMove)
			return validMoves;
		validMoves.add(getKingSideCastleMove(b));
		validMoves.add(getQueenSideCastleMove(b));
		return validMoves.stream().filter(Objects::nonNull).toList();
	}
	
	
	public Move getQueenSideCastleMove(Board b) {
		Piece queenSide;
		Tile currTile = this.getCurrentTile();
		Tile rookTile;//currently makes it s.t. have to click tile to side of Rook to properly Castle (Broken)
		Tile destTile;
		int currRank = currTile.getRank() - 1;
		if(this.isWhite()) {
			rookTile = b.getTile(0, 7);
			destTile = b.getTile(0, 7);
		}
		else {
			rookTile = b.getTile(0, 0);
			destTile = b.getTile(0, 0);
		}
		queenSide = rookTile.getPiece();
		if(!(queenSide instanceof Rook))
			return null;
		if(!((Rook) queenSide).isFirstMove())
			return null;
		while(currRank > 0) {
			System.out.println(b.getTile(currRank, currTile.getFile()).isUnderThreat(b));
			if(b.getTile(currRank, currTile.getFile()).isOccupied() || b.getTile(currRank, currTile.getFile()).isUnderThreat(b)) {
				break;
			}
			currRank--;
		}
		if(currRank == 0 && !b.getTile(currRank, currTile.getFile()).isUnderThreat(b))
			return new Move(b, currTile, destTile);
		else
			return null;
	}
	
	
	public Move getKingSideCastleMove(Board b) {
		Piece kingSide;
		Tile currTile = this.getCurrentTile();
		Tile rookTile;
		Tile destTile;
		int currRank = currTile.getRank() + 1;
		if(this.isWhite()) {
			rookTile = b.getTile(7, 7);
			destTile = b.getTile(7, 7);
		}
		else {
			rookTile = b.getTile(7, 0);
			destTile = b.getTile(7, 0);
		}
		kingSide = rookTile.getPiece();
		if(!(kingSide instanceof Rook))
			return null;
		if(!((Rook) kingSide).isFirstMove())
			return null;
		while(currRank < BoardUtilities.BOARD_WIDTH - 1) {
			System.out.println("kingSide: " + b.getTile(currRank, currTile.getFile()).isUnderThreat(b));
			if(b.getTile(currRank, currTile.getFile()).isOccupied() || b.getTile(currRank, currTile.getFile()).isUnderThreat(b)) {
				break;
			}
			currRank++;
		}
		if(currRank == BoardUtilities.BOARD_WIDTH - 1 && !b.getTile(currRank, currTile.getFile()).isUnderThreat(b))
			return new Move(b, currTile, destTile);
		return null;
	}

	public void setFirstMove(boolean firstMoveFlag) {
		this.isFirstMove = firstMoveFlag;
		
	}
		
}
