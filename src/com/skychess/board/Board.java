package com.skychess.board;

import java.util.Date;

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

	public Tile[][] getTiles() {
		return tilesOnBoard;
	}
}
