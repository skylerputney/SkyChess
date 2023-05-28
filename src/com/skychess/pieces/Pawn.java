package com.skychess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.skychess.BoardUtilities;
import com.skychess.board.Board;
import com.skychess.board.Move;
import com.skychess.board.Tile;

public class Pawn extends Piece {
    private boolean isFirstMove;
    public Pawn(Tile currentTile, boolean isWhite, boolean firstMove) {
        super(currentTile, isWhite);
        this.isFirstMove = firstMove;
    }
    
	@Override
	public List<Move> getValidMoves(Board b) {
		List<Move> validMoves = new ArrayList<Move>();
		int xPos = getCurrentTile().getRank();
		int yPos = getCurrentTile().getFile();
		int yIncr = getDirection();
		yPos += yIncr;
		if(xPos >=0 && yPos >= 0 && xPos < BoardUtilities.BOARD_WIDTH && yPos < BoardUtilities.BOARD_WIDTH) {
			if(!b.getTile(xPos, yPos).isOccupied()) {
				validMoves.add(new Move(b, getCurrentTile(), b.getTile(xPos, yPos)));
				System.out.println("Valid move added for pawn at " + xPos + " " + yPos);
				if(isFirstMove && !b.getTile(xPos, yPos + yIncr).isOccupied()) {
					validMoves.add(new Move(b, getCurrentTile(), b.getTile(xPos, yPos + yIncr)));
				}
			}
		}
		return validMoves;
	}

	@Override
	public int[][] getMoveVector() {
		// TODO Auto-generated method stub
		return null;
	}

}
