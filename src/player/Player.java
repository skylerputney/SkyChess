package player;

import java.util.List;

import com.skychess.board.Board;
import com.skychess.board.Move;
import com.skychess.board.Tile;
import com.skychess.pieces.King;
import com.skychess.pieces.Pawn;
import com.skychess.pieces.Piece;
import com.skychess.pieces.Rook;

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
	 
	
	public List<Piece> getActivePieces(){
		return activePieces;
	}
	
	public void setActivePieces(List<Piece> activePieces) {
		this.activePieces = activePieces;
	}
	
	public void executeMove(Move m){
		Piece toMove = m.getPieceToMove();
		Tile oldTile = m.getBoard().getTiles()[m.getSourceTile().getRank()][m.getSourceTile().getFile()];
		Tile destTile = m.getDestTile();
		destTile.setPiece(toMove);
		oldTile.clearTile();
		toMove.setCurrentTile(destTile);
		if(toMove instanceof Pawn) {
			((Pawn) toMove).setFirstMove(false);
			if(destTile.getFile() == oldTile.getFile() + ((Pawn)toMove).getDirection() * 2)
				m.getBoard().setEnPassantPawn((Pawn) toMove);
		}
		else if(toMove instanceof King)
			((King)toMove).setFirstMove(false);
		else if(toMove instanceof Rook)
			((Rook)toMove).setFirstMove(false);
	}
}
