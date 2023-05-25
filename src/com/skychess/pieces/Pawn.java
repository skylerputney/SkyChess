package com.skychess.pieces;

public class Pawn extends Piece {
    private boolean isFirstMove;

    public Pawn(int rank, int file, boolean isWhite, boolean firstMove) {
        super(rank, file, isWhite);
        this.isFirstMove = firstMove;
    }
}
