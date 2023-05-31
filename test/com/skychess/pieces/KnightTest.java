package com.skychess.pieces;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.skychess.board.Board;
import com.skychess.board.BoardUtilities;

class KnightTest {

	Knight k;
	Board b;
	
	@BeforeAll
	void initializePiece() {
		b = BoardUtilities.generateDefaultBoard();
		k = (Knight) b.getTile(0, 1).getPiece();
		
	}
	
	
	
	
	
	@Test
	void testLegalPositions() {
		k.getValidMoves(b);
	}

}
