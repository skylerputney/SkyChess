package com.skychess.pieces;

import java.util.List;

import com.skychess.board.Board;
import com.skychess.board.Move;

public abstract class Piece {
	
    private boolean isWhite;
    private int rank; //x-coord
    private int file; //y-coord

    public Piece(int rank, int file, boolean isWhite) {
    	this.setRank(rank);
    	this.setFile(file);
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return isWhite;
    }
    
    public abstract List<Move> getValidMoves(Board b);

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getFile() {
		return file;
	}

	public void setFile(int file) {
		this.file = file;
	}
}
