package com.skychess;

import com.skychess.board.Board;
import com.skychess.board.BoardUtilities;
import com.skychess.graphics.GUI;

public class SkyChess {
    public static void main(String[] args) {
    	Board b = BoardUtilities.generateDefaultBoard();
        SkyChess game = new SkyChess(b);
    }
    
	private Board board;
	private GUI gui;
	
	public SkyChess(Board b) {
		this.board = b;
		this.gui = new GUI(this);
	}
	
	public Board getBoard() {
		return this.board;
	}

}