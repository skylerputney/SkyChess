package com.skychess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.skychess.BoardUtilities;
import com.skychess.board.Board;
import com.skychess.board.Move;
import com.skychess.board.Tile;

import listeners.MoveListener;

public class Pawn extends Piece implements MoveListener{
    private boolean isFirstMove;
    private boolean isEnPassantCaptureEligible;
    private final int[][] PAWN_ATTACK_VECTOR = {{1, getDirection()}, {-1, getDirection()}};
    public Pawn(Tile currentTile, boolean isWhite, boolean firstMove) {
        super(currentTile, isWhite);
        this.isFirstMove = firstMove;
        this.isEnPassantCaptureEligible = false;
    }
    
	@Override
	public List<Move> getValidMoves(Board b) {
		var here = super.getValidMoves(b);
		List<Move> validMoves = new ArrayList<Move>();
		int xPos = getCurrentTile().getRank();
		int yPos = getCurrentTile().getFile();
		int yIncr = getDirection();
		yPos += yIncr;
		if(BoardUtilities.isValidPosition(xPos, yPos)) {
			if(!b.getTile(xPos, yPos).isOccupied()) {
				validMoves.add(new Move(b, getCurrentTile(), b.getTile(xPos, yPos)));
				}
			}
		if(this.isFirstMove) {
		yPos += yIncr;
		if(BoardUtilities.isValidPosition(xPos, yPos)) {
			if(!b.getTile(xPos, yPos).isOccupied()) {
				validMoves.add(new Move(b, getCurrentTile(), b.getTile(xPos, yPos)));
				}
		}
		yPos -= yIncr;
		}
		yPos -= yIncr;
		for(int[] v : PAWN_ATTACK_VECTOR) {
			int newX = xPos + v[0];
			int newY = yPos + v[1];
			if(BoardUtilities.isValidPosition(newX, newY)){
				if(b.getTile(newX, newY).isOccupied()) {
					if(b.getTile(newX, newY).getPiece().isWhite() != this.isWhite()) {
						validMoves.add(new Move(b, getCurrentTile(), b.getTile(newX, newY)));
			}
				}
			}
		}
		return validMoves;
	}

	@Override
	public int[][] getMoveVector() {
		final int[][] pawnMoveVector = {{0, getDirection()}, {1, getDirection()}, {-1, getDirection()}}; //move forward, diagonal forward
		return pawnMoveVector;
	}
	
	public boolean isFirstMove() {
		return isFirstMove;
	}
	
	public void setFirstMove(boolean isFirstMove) {
		this.isFirstMove = isFirstMove;
	}

	@Override
	public void moveExecuted() {
		// TODO Auto-generated method stub
		
	}
	

}
