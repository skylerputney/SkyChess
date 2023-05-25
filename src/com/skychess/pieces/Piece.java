package com.skychess.pieces;

public abstract class Piece {
    private int rank; // x-position
    private int file; // y-position
    private boolean isWhite;

    public Piece(int rank, int file, boolean isWhite) {
        this.rank = rank;
        this.file = file;
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return isWhite;
    }
}
