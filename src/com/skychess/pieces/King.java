package com.skychess.pieces;

public class King extends Piece {
    private boolean isFirstMove;

    public King(int rank, int file, boolean isWhite, boolean firstMove) {
        super(rank, file, isWhite);
        this.isFirstMove = firstMove;
    }
}
