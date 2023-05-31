package player;

import java.util.List;

import com.skychess.board.Board;
import com.skychess.pieces.Piece;

public class BlackPlayer extends Player{
	
	public BlackPlayer(Board board, List<Piece> activePieces) {
		super(board);
		this.setActivePieces(activePieces);
	}
}