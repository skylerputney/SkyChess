package com.skychess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.skychess.board.Board;
import com.skychess.board.BoardUtilities;
import com.skychess.board.Move;
import com.skychess.board.Tile;

public abstract class Piece {
	
    private boolean isWhite;
    private Tile currentTile;

    public Piece(Tile currentTile, boolean isWhite) {
        this.isWhite = isWhite;
        this.currentTile = currentTile;
    }

    public boolean isWhite() {
        return isWhite;
    }
    
//    public abstract List<Move> getValidMoves(Board b);
    
    public abstract int[][] getMoveVector();
    
	public List<Move> getValidMoves(Board b) {
		List<Move> validMoves = new ArrayList<Move>();
		Tile currentTile = getCurrentTile();
		int xPos = currentTile.getRank();
		int yPos = currentTile.getFile();
		int xIncr, yIncr;
		int newX, newY;
		for(int[] VECTOR : this.getMoveVector()) {
			xIncr = VECTOR[0];
			yIncr = VECTOR[1];
			newX = xPos + xIncr;
			newY = yPos + yIncr;
			while(BoardUtilities.isValidPosition(newX, newY)) {
				Tile targetTile = b.getTile(newX, newY);
				if(!targetTile.isOccupied()) {
						validMoves.add(new Move(b, currentTile, targetTile));
						if(this instanceof Knight || this instanceof King)
							break;
				}
				else {
					//logic if Tile is occupied
					if(targetTile.getPiece().isWhite() != this.isWhite()) {
						//logic if Piece is opposite color
						validMoves.add(new Move(b, currentTile, targetTile));
					}
					break; //break the while loop to prevent sliding further along line
				}
				newX += xIncr;
				newY += yIncr;
			}
		}
		return validMoves;
	}
	
	public List<Move> getAllValidMoves(Board b){
		var moves = getValidMoves(b);
		if(this instanceof King) {
			moves.addAll(((King) this).getCastleMoves(b));
		}
		return moves;
	}
	
	

	
    public int getDirection() {
    	if(this.isWhite())
    		return BoardUtilities.WHITE_DIRECTION;
    	return BoardUtilities.BLACK_DIRECTION;
    }
    
    public Tile getCurrentTile() {
    	return this.currentTile;
    }
    
    public void setCurrentTile(Tile tile) {
    	this.currentTile = tile;
    }
    
	public boolean isValidMove(Move move) {
		if(move.getBoard().getCurrentPlayer().isWhite() != this.isWhite())
			return false;
		if(getAllValidMoves(move.getBoard()).stream().anyMatch(m -> m.equals(move)))
			return true;
		return false;
	}
    
}
