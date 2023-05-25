package com.skychess.graphics;

import com.skychess.board.Board;
import com.skychess.board.Tile;
import com.skychess.pieces.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GUI {

    private final JFrame frame;
    private Board board;
    public GUI(Board board) {
        this.board = board;
        this.frame = new JFrame("Sky Chess");
        frame.setSize(600, 600);
        frame.add(new BoardPanel());
        frame.pack();
        frame.setVisible(true);
    }

    private class BoardPanel extends JPanel {
        public BoardPanel() {
            super(new GridLayout(8, 8));
            this.setPreferredSize(new Dimension(8 * 50, 8 * 50));
            for (int i = 0; i < 64; i++) {
                this.add(new ChessTile(i));
            }
            this.setPreferredSize(new Dimension(350, 350));
        }
    }

    private class ChessTile extends JPanel {
        private int tileNum;
        public ChessTile(int i) {
            super(new GridBagLayout());
            tileNum = i;
            if ((i / 8 + i % 8) % 2 == 1)
                this.setBackground(Color.BLACK);
            assignTilePiece(board);
            this.setOpaque(true);
        }

        private void assignTilePiece(Board b){
            removeAll();
            Tile t = b.getTile(tileNum);
            if(t == null)
                return;
            if(t.isOccupied()){
                Piece p = t.getPiece();
                String imagePath = "Images/w";
                if(!p.isWhite())
                   imagePath = "Images/b";
                if(p instanceof Pawn)
                    imagePath.concat("p");
                else if(p instanceof Bishop)
                    imagePath.concat("b");
                else if(p instanceof Rook)
                    imagePath.concat("r");
                else if(p instanceof Knight)
                    imagePath.concat("n");
                else if(p instanceof Queen)
                    imagePath.concat("q");
                 else
                    imagePath.concat("k");
                imagePath.concat(".svg");
                try {
                    final Image pieceImage = ImageIO.read(new File(imagePath));
                    add(new JLabel(new ImageIcon(pieceImage)));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
