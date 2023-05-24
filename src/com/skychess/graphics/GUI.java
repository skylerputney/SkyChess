package com.skychess.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {

    private final JFrame frame;

    public GUI() {
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
        }
    }

    private class ChessTile extends JButton {
        public ChessTile(int i) {
            super(i / 8 + "," + i % 8);
            this.setOpaque(true);
            this.setBorderPainted(false);
            if ((i / 8 + i % 8) % 2 == 1)
                this.setBackground(Color.BLACK);
        }
    }
}
