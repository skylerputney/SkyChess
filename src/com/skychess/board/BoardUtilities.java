package com.skychess.board;

import com.skychess.pieces.Bishop;
import com.skychess.pieces.King;
import com.skychess.pieces.Knight;
import com.skychess.pieces.Pawn;
import com.skychess.pieces.Queen;
import com.skychess.pieces.Rook;

public class BoardUtilities {

	public static final int BOARD_WIDTH = 8;
	public static final int BLACK_DIRECTION = 1;
	public static final int WHITE_DIRECTION = -1;
	public static final int[][] STRAIGHT_MOVE_VECTOR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	public static final int[][] DIAGONAL_MOVE_VECTOR = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
	
    public static Board generateDefaultBoard(){
        var pieceTiles = generateDefaultPieceTiles();
        Board b = new Board(pieceTiles);
        return b;
    }

    public static Tile[][] generateDefaultPieceTiles(){
    	var tiles = generateDefaultTileArray();
    	tiles[0][0].setPiece(new Rook(tiles[0][0], false, true));
    	tiles[1][0].setPiece(new Knight(tiles[1][0], false));
    	tiles[2][0].setPiece(new Bishop(tiles[2][0], false));
    	tiles[3][0].setPiece(new Queen(tiles[3][0], false));
    	tiles[4][0].setPiece(new King(tiles[4][0], false, true));
    	tiles[5][0].setPiece(new Bishop(tiles[5][0], false));
    	tiles[6][0].setPiece(new Knight(tiles[6][0], false));
    	tiles[7][0].setPiece(new Rook(tiles[7][0], false, true));
    	
    	tiles[0][7].setPiece(new Rook(tiles[0][7], true, true));
    	tiles[1][7].setPiece(new Knight(tiles[1][7], true));
    	tiles[2][7].setPiece(new Bishop(tiles[2][7], true));
    	tiles[3][7].setPiece(new Queen(tiles[3][7], true));
    	tiles[4][7].setPiece(new King(tiles[4][7], true, true));
    	tiles[5][7].setPiece(new Bishop(tiles[5][7], true));
    	tiles[6][7].setPiece(new Knight(tiles[6][7], true));
    	tiles[7][7].setPiece(new Rook(tiles[7][7], true, true));
    	
    	for(int i = 0; i < 8; i++) {
    		tiles[i][1].setPiece(new Pawn(tiles[i][1], false, true));
    		tiles[i][6].setPiece(new Pawn(tiles[i][6], true, true));
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
    
    public static final boolean isValidPosition(int x, int y) {
    	if(x >= 0 && x < BOARD_WIDTH && y >= 0 && y < BOARD_WIDTH)
    		return true;
    	return false;
    }

}
