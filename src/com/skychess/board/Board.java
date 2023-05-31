package com.skychess.board;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.skychess.pieces.King;
import com.skychess.pieces.Piece;

import player.BlackPlayer;
import player.WhitePlayer;


public class Board {
    private Tile[][] tilesOnBoard;
    final int BOARD_WIDTH = 8;
    Date creationDate;
    WhitePlayer whitePlayer;
    BlackPlayer blackPlayer;

    public Board(Tile[][] boardTiles) {
    	this.tilesOnBoard = boardTiles;
    	this.whitePlayer = new WhitePlayer(this, getActiveWhitePieces());
    	this.blackPlayer = new BlackPlayer(this, getActiveBlackPieces());
    }

    public Tile getTile(int rank, int file) {
        return tilesOnBoard[rank][file];
    }

	public Tile[][] getTiles() {
		return tilesOnBoard;
	}
	
	public boolean isKingInCheck(King k) {
		return true;
	}
	
	public List<Piece> getActiveWhitePieces(){
		return Arrays.stream(this.getTiles()).flatMap(p -> Arrays.stream(p)).map(t -> t.getPiece()).filter(p -> p.isWhite()).toList();
	}
	
	public List<Piece> getActiveBlackPieces(){
		return Arrays.stream(this.getTiles()).flatMap(p -> Arrays.stream(p)).map(t -> t.getPiece()).filter(p -> !p.isWhite()).toList();
	}
}
