package player;

import java.util.List;

import com.skychess.pieces.Piece;

public class BlackPlayer extends Player{
	
	public BlackPlayer(List<Piece> activePieces) {
		this.setActivePieces(activePieces);
	}
}