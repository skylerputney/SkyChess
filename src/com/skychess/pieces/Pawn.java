package com.skychess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.skychess.board.Board;
import com.skychess.board.Move;

public class Pawn extends Piece {
    private boolean isFirstMove;
    private static final int BLACK_DIRECTION = 1;
    private static final int WHITE_DIRECTION = -1;;


    public Pawn(int rank, int file, boolean isWhite, boolean firstMove) {
        super(rank, file, isWhite);
        this.isFirstMove = firstMove;
    }
    
    private int getDirection() {
    	if(this.isWhite())
    		return WHITE_DIRECTION;
    	return BLACK_DIRECTION;
    }

	@Override
	public List<Move> getValidMoves(Board b) {
		List<Move> validMoves = new ArrayList<Move>();
		int xPos = getRank();
		int yPos = getFile();
		int yIncr = getDirection();
		yPos += yIncr;
		while(yPos >= 0 && yPos < 8 && xPos >=0 && xPos < 8) {
		if(b.getTile(xPos, yPos).isOccupied()) {
			//if tile is occupied, en-passant logic
		}
		else {
			if(this.isFirstMove && (yPos == getFile() + yIncr || yPos == getFile() + yIncr * 2))
				validMoves.add(new Move(b, this, b.getTile(xPos, yPos)));
			System.out.println("Valid move added for pawn from " + xPos + ", " + yPos + " to " + xPos + ", " + (yPos + yIncr) );
		}
		yPos += yIncr;
		}
		return validMoves;
	}

	@Override
	public boolean isValidMove(Move move) {
		for(Move m : getValidMoves(move.getBoard())) {
			if(m.getBoard() == move.getBoard() && m.getDestTile() == move.getDestTile() && m.getPieceToMove() == move.getPieceToMove()) {
			System.out.println("true");
			return true;
			}
		}
		System.out.println("false");
		return false;
	}
}
