package com.skychess.board;

import java.awt.List;
import java.util.Date;

import com.skychess.pieces.Piece;

public class Board {
    private java.util.List<Tile> tilesOnBoard;
    final int BOARD_WIDTH = 8;
    Date creationDate;

    public Board(java.util.List<Tile> boardTiles) {
    }

    public Tile getTile(int tileNum) {
        return tilesOnBoard.get(tileNum);
    }
}
