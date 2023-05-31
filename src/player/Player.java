package player;

import java.util.List;

import com.skychess.board.Board;
import com.skychess.board.Move;
import com.skychess.pieces.Piece;

public class Player {

	private int id;
	private Board board;
	private boolean isPlayerTurn;
	private List<Piece> activePieces;
	
	public Player(Board board) {
		this.board = board;
		this.id = this.hashCode();
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
	
	public void makeMove(Move m) {
		if(isPlayerTurn)
			m.executeMove(this);
	}
	
	public List<Piece> getActivePieces(){
		return activePieces;
	}
	
	public void setActivePieces(List<Piece> activePieces) {
		this.activePieces = activePieces;
	}
	
	
}
