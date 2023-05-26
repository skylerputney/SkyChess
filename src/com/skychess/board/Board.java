package com.skychess.board;

import java.util.Date;

import com.skychess.BoardUtilities;
import com.skychess.pieces.Piece;

public class Board {
    private Tile[][] tilesOnBoard;
    final int BOARD_WIDTH = 8;
    Date creationDate;

    public Board(Tile[][] boardTiles) {
    	this.tilesOnBoard = boardTiles;
    }

    public Tile getTile(int rank, int file) {
        return tilesOnBoard[rank][file];
    }
    public Tile getTile(int pos) {
    	return tilesOnBoard[pos / BoardUtilities.BOARD_WIDTH][pos % BoardUtilities.BOARD_WIDTH];
    }
    
	public void executeMove(Move m) {
		Piece toMove = m.getPieceToMove();
		Tile oldTile = this.getTile(toMove.getRank(), toMove.getFile());
		oldTile.clearTile();
		Tile destTile = m.getDestTile();
		//Need to update file,rank of Piece here
		destTile.setPiece(toMove);
	}
}
