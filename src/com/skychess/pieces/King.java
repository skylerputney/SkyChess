package com.skychess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.skychess.BoardUtilities;
import com.skychess.board.Board;
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
	
	public List<Move> getCastleMoves(Board b) {
		List<Move> validMoves = new ArrayList<Move>();
		if(!this.isFirstMove)
			return validMoves;
		validMoves.add(getKingSideCastleMove(b));
		validMoves.add(getQueenSideCastleMove(b));
		System.out.println("Valid castling moves: " + validMoves);
		return validMoves;
	}
	
	
	public Move getQueenSideCastleMove(Board b) {
		Piece queenSide;
		Tile currTile = this.getCurrentTile();
		Tile destTile;
		int currRank = currTile.getRank() - 1;
		if(this.isWhite())
			destTile = b.getTile(0, 7);
		else
			destTile = b.getTile(0, 0);
		queenSide = destTile.getPiece();
		if(!(queenSide instanceof Rook))
			return null;
		if(!((Rook) queenSide).isFirstMove())
			return null;
		while(currRank > 0) {
			System.out.println(currRank);
			if(b.getTile(currRank, currTile.getFile()).isOccupied()) //add logic for not under threat of check
				break;
			currRank--;
		}
		if(currRank == 0)
			return new Move(b, currTile, destTile);
		else
			return null;
	}
	
	
	public Move getKingSideCastleMove(Board b) {
		Piece kingSide;
		Tile currTile = this.getCurrentTile();
		Tile destTile;
		int currRank = currTile.getRank() + 1;
		if(this.isWhite())
			destTile = b.getTile(7, 7);
		else
			destTile = b.getTile(7, 0);
		kingSide = destTile.getPiece();
		if(!(kingSide instanceof Rook))
			return null;
		if(!((Rook) kingSide).isFirstMove())
			return null;
		while(currRank < BoardUtilities.BOARD_WIDTH - 1) {
			if(b.getTile(currRank, currTile.getFile()).isOccupied()) //add logic for not under threat of check
				break;
			currRank++;
		}
		if(currRank == BoardUtilities.BOARD_WIDTH - 1)
			return new Move(b, currTile, destTile);
		return null;
	}
		
}
