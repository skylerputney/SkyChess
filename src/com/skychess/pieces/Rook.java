package com.skychess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.skychess.board.Board;
import com.skychess.board.Move;
import com.skychess.board.Tile;

public class Rook extends Piece{
	
	private static final int[][] MOVE_VECTOR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
    public Rook(Tile currentTile, boolean isWhite) {
        super(currentTile, isWhite);
    }

	@Override
	public List<Move> getValidMoves(Board b) {
		List<Move> validMoves = new ArrayList<Move>();
		Tile currentTile = getCurrentTile();
		int xPos = currentTile.getRank();
		int yPos = currentTile.getFile();
		int xIncr, yIncr;
		int newX, newY;
		for(int[] VECTOR : MOVE_VECTOR) {
			xIncr = VECTOR[0];
			yIncr = VECTOR[1];
			newX = xPos + xIncr;
			newY = yPos + yIncr;
			while(newX >= 0 && newX < 8 && newY >= 0 && newY < 8) {
				Tile targetTile = b.getTile(newX, newY);
				if(!targetTile.isOccupied()) {
						validMoves.add(new Move(b, currentTile, targetTile));
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

}
