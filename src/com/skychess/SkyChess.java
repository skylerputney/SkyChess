package com.skychess;

import com.skychess.graphics.GUI;

public class SkyChess {
    public static void main(String[] args) {
        GUI game = new GUI(BoardUtilities.generateDefaultBoard());
    }
}