package com.skychess;

import com.skychess.board.Board;
import com.skychess.board.Tile;
import com.skychess.pieces.Bishop;
import com.skychess.pieces.King;
import com.skychess.pieces.Knight;
import com.skychess.pieces.Pawn;
import com.skychess.pieces.Queen;
import com.skychess.pieces.Rook;

public class BoardUtilities {

	public static final int BOARD_WIDTH = 8;
	
    public static Board generateDefaultBoard(){
        var pieceTiles = generateDefaultPieceTiles();
        Board b = new Board(pieceTiles);
        return b;
    }

    public static Tile[][] generateDefaultPieceTiles(){
    	var tiles = generateDefaultTileArray();
    	tiles[0][0].setPiece(new Rook(0, 0, false));
    	tiles[1][0].setPiece(new Knight(1, 0, false));
    	tiles[2][0].setPiece(new Bishop(2, 0, false));
    	tiles[3][0].setPiece(new Queen(3, 0, false));
    	tiles[4][0].setPiece(new King(4, 0, false, true));
    	tiles[5][0].setPiece(new Bishop(5, 0, false));
    	tiles[6][0].setPiece(new Knight(6, 0, false));
    	tiles[7][0].setPiece(new Rook(7, 0, false));
    	
    	tiles[0][7].setPiece(new Rook(0, 7, true));
    	tiles[1][7].setPiece(new Knight(1, 7, true));
    	tiles[2][7].setPiece(new Bishop(2, 7, true));
    	tiles[3][7].setPiece(new Queen(3, 7, true));
    	tiles[4][7].setPiece(new King(4, 7, true, true));
    	tiles[5][7].setPiece(new Bishop(5, 7, true));
    	tiles[6][7].setPiece(new Knight(6, 7, true));
    	tiles[7][7].setPiece(new Rook(7, 7, true));
    	
    	for(int i = 0; i < 8; i++) {
    		tiles[i][1].setPiece(new Pawn(i, 1, false, true));
    		tiles[i][6].setPiece(new Pawn(i, 6, true, true));
    	}
    	return tiles;
    }
    
    public static Tile[][] generateDefaultTileArray(){
        Tile[][] tiles = new Tile[8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                tiles[j][i] = new Tile(j, i);
            }
        }
        return tiles;
    }
}
