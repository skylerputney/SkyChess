package com.skychess.board;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.skychess.pieces.King;
import com.skychess.pieces.Pawn;
import com.skychess.pieces.Piece;


public class Board {
    private Tile[][] tilesOnBoard;
    final int BOARD_WIDTH = 8;
    Date creationDate;
    private Pawn enPassantPawn;

    public Board(Tile[][] boardTiles) {
    	this.tilesOnBoard = boardTiles;
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
		return Arrays.stream(this.getTiles()).flatMap(p -> Arrays.stream(p)).map(t -> t.getPiece()).filter(Objects::nonNull).filter(p -> p.isWhite()).toList();
	}
	
	public List<Piece> getActiveBlackPieces(){
		return Arrays.stream(this.getTiles()).flatMap(p -> Arrays.stream(p)).map(t -> t.getPiece()).filter(Objects::nonNull).filter(p -> !p.isWhite()).toList();
	}
	
	public Pawn getEnPassantPawn() {
		return enPassantPawn;
	}
	
	public void setEnPassantPawn(Pawn p) {
		this.enPassantPawn = p;
	}
	
}
