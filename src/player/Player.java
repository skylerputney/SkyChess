package player;

import java.util.List;

import com.skychess.board.Board;
import com.skychess.pieces.King;
import com.skychess.pieces.Piece;

public class Player {

	private int id;
	private List<Piece> activePieces;
	private King playerKing;
	
	public Player() {
		this.id = this.hashCode();
	}
	
	
	public int getPlayerID() {
		return this.id;
	}
	 
	
	public List<Piece> getActivePieces(){
		return activePieces;
	}
	
	public void setPlayerKing() {
		activePieces.forEach(p -> {if(p instanceof King) this.playerKing = (King) p; });
	}
	public void setActivePieces(List<Piece> activePieces) {
		this.activePieces = activePieces;
	}
	

	public boolean isWhite() {
		return (this instanceof WhitePlayer);
	}

	public boolean isInCheck(Board b) {
		return playerKing.isInCheck(b);
	}
}
