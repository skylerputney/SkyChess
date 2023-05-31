package com.skychess;

import java.util.List;

import com.skychess.pieces.Piece;

public class Player {

	private int id;
	private String userName;
	private boolean isPlayerTurn;
	private List<Piece> activePiecees;
	
	public Player(String userName) {
		this.userName = userName;
		this.id = userName.hashCode();
	}
	
	public boolean isPlayerTurn() {
		return isPlayerTurn;
	}
	
	public void setPlayerTurn(boolean turnFlag) {
		isPlayerTurn = turnFlag;
	}
	
	public int getPlayerID() {
		return this.id;
	}
	
}
