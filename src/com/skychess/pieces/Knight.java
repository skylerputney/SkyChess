package com.skychess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.skychess.board.Board;
import com.skychess.board.Move;
import com.skychess.board.Tile;

public class Knight extends Piece{
	
	private static final int[][] VALID_MOVES = {{2, 1}, {1, 2}, {2, -1}, {1, -2}, {-2, -1}, {-1, -2}, {-2, 1}, {-1, 2}};
    public Knight(Tile currentTile, boolean isWhite) {
        super(currentTile, isWhite);
    }

	@Override
	public List<Move> getValidMoves(Board b) {
		List<Move> validMoves = new ArrayList<Move>();
		Tile currentTile = getCurrentTile();
		int xPos = currentTile.getRank();
		int yPos = currentTile.getFile();
		System.out.println("Current xPos" + xPos + " current yPos" + yPos);
		for(int[] MOVE_VECTOR : VALID_MOVES) {
			int newX = xPos + MOVE_VECTOR[0];
			int newY = yPos + MOVE_VECTOR[1];
			System.out.println("New X:" + newX + " newY:" + newY);
			if(newX < 0 || newX >= 8 || newY < 0 || newY >= 8) {
				continue;
			}
			Tile targetTile = b.getTile(newX, newY);
			if(!targetTile.isOccupied()) {
					validMoves.add(new Move(b, currentTile, targetTile));
					System.out.println("Valid move added for Knight at" + newX + " " + newY);
			}
			else {
				//Logic if tile is occupied
				if(targetTile.getPiece().isWhite() != this.isWhite()) {
					validMoves.add(new Move(b, currentTile, targetTile));
				}
			}
		}
		return validMoves;
	}

}
