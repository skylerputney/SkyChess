package player;

import java.util.List;

import com.skychess.pieces.Piece;

public class WhitePlayer extends Player{

	public WhitePlayer(List<Piece> activePieces) {
		this.setActivePieces(activePieces);
	}

}