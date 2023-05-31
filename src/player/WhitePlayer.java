package player;

import java.util.List;

import com.skychess.board.Board;
import com.skychess.pieces.Piece;

public class WhitePlayer extends Player{

	public WhitePlayer(Board board, List<Piece> activePieces) {
		super(board);
		this.setActivePieces(activePieces);
	}

}