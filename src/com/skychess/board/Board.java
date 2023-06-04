package com.skychess.board;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.skychess.pieces.King;
import com.skychess.pieces.Pawn;
import com.skychess.pieces.Piece;

import player.BlackPlayer;
import player.Player;
import player.WhitePlayer;


public class Board {
    private Tile[][] tilesOnBoard;
    final int BOARD_WIDTH = 8;
    Date creationDate;
    private Pawn enPassantPawn;
	private WhitePlayer whitePlayer;
	private BlackPlayer blackPlayer;
	private Player currentPlayer;

    private Board(Tile[][] boardTiles) {
    	this.tilesOnBoard = boardTiles;
    }
    
    /*
     * Returns a new instance of a board with whiteplayer automatically currentPlayer
     */
    public static Board createNewBoard(Tile[][] boardTiles) {
    	//Tile[][] copyTiles = new Tile[boardTiles.length][boardTiles[0].length];
    	//Arrays.stream(boardTiles).flatMap(t -> Arrays.stream(t)).forEach(t -> {copyTiles[t.getRank()][t.getFile()] = new Tile(t.getRank(), t.getFile()); if(t.getPiece() != null) copyTiles[t.getRank()][t.getFile()].setPiece(t.getPiece()); });
    	Board b = new Board(boardTiles);
    	WhitePlayer wp = new WhitePlayer(b.getActiveWhitePieces());
    	BlackPlayer bp = new BlackPlayer(b.getActiveBlackPieces());
    	wp.setPlayerKing(); bp.setPlayerKing();
    	b.setWhitePlayer(wp);
    	b.setBlackPlayer(bp);
    	b.setCurrentPlayer(wp);
    	return b;
    }
    
	public static Board createNewBoard(Board b) {
		Board board = createNewBoard(b.getTiles());
    	board.setCurrentPlayer(b.getCurrentPlayer());
    	return board;
	}
	
	public void setCurrentPlayer(Player p) {
		this.currentPlayer = p;
	}

    public Tile getTile(int rank, int file) {
        return tilesOnBoard[rank][file];
    }
    public void setWhitePlayer(WhitePlayer wp) {
    	this.whitePlayer = wp;
    }
    public void setBlackPlayer(BlackPlayer bp) {
    	this.blackPlayer = bp;
    }

	public Tile[][] getTiles() {
		return tilesOnBoard;
	}
	
	public boolean isKingInCheck(King k) {
		return true;
	}
	
	public List<Piece> getActiveWhitePieces(){
		List<Piece> activePieces = new ArrayList<Piece>();
		for(int i = 0; i < BoardUtilities.BOARD_WIDTH; i++) {
			for(int j = 0; j < BoardUtilities.BOARD_WIDTH; j++) {
				Piece p = this.tilesOnBoard[i][j].getPiece();
				if(p != null)
					if(p.isWhite())
						activePieces.add(p);
			}
		}
		return activePieces;
		//return Arrays.stream(this.getTiles()).flatMap(p -> Arrays.stream(p)).map(t -> t.getPiece()).filter(Objects::nonNull).filter(p -> p.isWhite()).toList();
	}
	
	public List<Piece> getActiveBlackPieces(){
		List<Piece> activePieces = new ArrayList<Piece>();
		for(int i = 0; i < BoardUtilities.BOARD_WIDTH; i++) {
			for(int j = 0; j < BoardUtilities.BOARD_WIDTH; j++) {
				Piece p = this.tilesOnBoard[i][j].getPiece();
				if(p != null)
					if(!p.isWhite())
						activePieces.add(p);
			}
		}
		return activePieces;
		//return Arrays.stream(this.getTiles()).flatMap(p -> Arrays.stream(p)).map(t -> t.getPiece()).filter(Objects::nonNull).filter(p -> !p.isWhite()).toList();
	}
	
	public List<Piece> getActivePieces(){
		List<Piece> pieces = new ArrayList<Piece>();
		getActiveWhitePieces().forEach(p -> pieces.add(p));
		getActiveBlackPieces().forEach(p -> pieces.add(p));
		return pieces;
	}
	
	public Pawn getEnPassantPawn() {
		return enPassantPawn;
	}
	
	public void setEnPassantPawn(Pawn p) {
		this.enPassantPawn = p;
	}
	
	public Player getCurrentPlayer() {
		return (currentPlayer instanceof WhitePlayer) ? whitePlayer : blackPlayer;
	}
	
	public void updateCurrentPlayer() {
		currentPlayer = (currentPlayer instanceof WhitePlayer) ? blackPlayer : whitePlayer;
	}

	public Player getOpponent() {
		return (currentPlayer instanceof WhitePlayer) ? blackPlayer : whitePlayer;
	}
	
}
