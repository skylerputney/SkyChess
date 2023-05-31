package com.skychess.board;

import java.util.Date;

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

	public void executeMove(Move m) {
		Piece toMove = m.getPieceToMove();
		Tile oldTile = tilesOnBoard[m.getSourceTile().getRank()][m.getSourceTile().getFile()];
		Tile destTile = m.getDestTile();
		destTile.setPiece(toMove);
		oldTile.clearTile();
		toMove.setCurrentTile(destTile);
		//add logic to change bln flag isFirstMove
	}

	public Tile[][] getTiles() {
		return tilesOnBoard;
	}
}
