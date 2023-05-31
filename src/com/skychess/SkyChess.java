package com.skychess;

import com.skychess.board.Board;
import com.skychess.graphics.GUI;

import player.BlackPlayer;
import player.WhitePlayer;

public class SkyChess {
    public static void main(String[] args) {
    	Board b = BoardUtilities.generateDefaultBoard();
        SkyChess game = new SkyChess(b, new WhitePlayer(b, b.getActiveWhitePieces()) ,new BlackPlayer(b, b.getActiveBlackPieces()));
    }
    
	private Board board;
	private WhitePlayer whitePlayer;
	private BlackPlayer blackPlayer;
	private GUI gui;
	
	public SkyChess(Board b, WhitePlayer whitePlayer, BlackPlayer blackPlayer) {
		this.board = b;
		this.whitePlayer = whitePlayer;
		this.blackPlayer = blackPlayer;
		this.gui = new GUI(board);
	}
}