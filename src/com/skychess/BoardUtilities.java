package com.skychess;

import com.skychess.board.Board;
import com.skychess.board.Tile;
import com.skychess.pieces.Knight;
import com.skychess.pieces.Piece;
import com.skychess.pieces.Rook;

import java.util.ArrayList;
import java.util.List;

public class BoardUtilities {


    public static Board generateDefaultBoard(){
        Tile[][] piecesOnBoard = new Tile[8][8];
        piecesOnBoard[0][0].setPiece(new Rook(0, 0, false));
        piecesOnBoard[0][1].setPiece(new Knight(0, 0, false));
        List<Tile> tiles = new ArrayList<Tile>();
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                tiles.add(piecesOnBoard[i][j]);
            }
        }
        Board b = new Board(tiles);
        return b;
    }
}
