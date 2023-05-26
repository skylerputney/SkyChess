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
    	tiles[0][1].setPiece(new Knight(0, 1, false));
    	tiles[0][2].setPiece(new Bishop(0, 2, false));
    	tiles[0][3].setPiece(new Queen(0, 3, false));
    	tiles[0][4].setPiece(new King(0, 4, false, true));
    	tiles[0][5].setPiece(new Bishop(0, 5, false));
    	tiles[0][6].setPiece(new Knight(0, 6, false));
    	tiles[0][7].setPiece(new Rook(0, 7, false));
    	
    	tiles[7][0].setPiece(new Rook(7, 0, true));
    	tiles[7][1].setPiece(new Knight(7, 1, true));
    	tiles[7][2].setPiece(new Bishop(7, 2, true));
    	tiles[7][3].setPiece(new Queen(7, 3, true));
    	tiles[7][4].setPiece(new King(7, 4, true, true));
    	tiles[7][5].setPiece(new Bishop(7, 5, true));
    	tiles[7][6].setPiece(new Knight(7, 6, true));
    	tiles[7][7].setPiece(new Rook(7, 7, true));
    	
    	for(int i = 0; i < 8; i++) {
    		tiles[1][i].setPiece(new Pawn(1, i, false, true));
    		tiles[6][i].setPiece(new Pawn(6, i, true, true));
    	}
    	return tiles;
    }
    
    public static Tile[][] generateDefaultTileArray(){
        Tile[][] tiles = new Tile[8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                tiles[i][j] = new Tile();
            }
        }
        return tiles;
    }
}
