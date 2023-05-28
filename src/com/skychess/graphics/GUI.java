package com.skychess.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.skychess.BoardUtilities;
import com.skychess.board.Board;
import com.skychess.board.Move;
import com.skychess.board.Tile;
import com.skychess.pieces.Bishop;
import com.skychess.pieces.Knight;
import com.skychess.pieces.Pawn;
import com.skychess.pieces.Piece;
import com.skychess.pieces.Queen;
import com.skychess.pieces.Rook;

public class GUI {

    private final JFrame frame;
    private List<ChessTile> tileList = new ArrayList<ChessTile>();
    private ChessTile[][] tileArray = new ChessTile[8][8];
    private Board board;
    private Tile sourceTile, destTile;
    private Piece pieceToMove;
    public GUI(Board board) {
        this.board = board;
        this.frame = new JFrame("Sky Chess");
        frame.setSize(600, 600);
        frame.add(new BoardPanel());
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * graphic representation of Board
     * @author skyle
     *
     */
    private class BoardPanel extends JPanel {
        public BoardPanel() {
            super(new GridLayout(8, 8));
            this.setPreferredSize(new Dimension(8 * 50, 8 * 50));
            for (int i = 0; i < 8; i++) {
            	for(int j = 0; j < 8; j++) {
                ChessTile ct = (new ChessTile(this, j, i));
                this.add(ct);
                tileArray[j][i] = ct;
                tileList.add(ct);
            	}
            }
         
        }
        
        /**
         * redraws board
         * @param b
         */
        public void drawBoard(Board b) {
        	removeAll();
//        	tileList.clear();
//        	var tiles = b.getTiles();
//        	for(int i = 0; i < BoardUtilities.BOARD_WIDTH; i++) {
//        		for(int j = 0; j < BoardUtilities.BOARD_WIDTH; j++) {
//        			tileList.add(new ChessTile(this, tiles[i][j].getRank(), tiles[i][j].getFile()));
//        		}
//        	}
        	for(int i = 0; i < BoardUtilities.BOARD_WIDTH; i++) {
        		for(int j = 0; j < BoardUtilities.BOARD_WIDTH; j++) {
        			tileArray[j][i].drawTile(b);
        			add(tileArray[j][i]);
        		}
//        	}
        	validate();
        	repaint();
        }
        
    }
   }
    
    /**
     * graphic representation of tile
     * @author skyle
     *
     */
  public class ChessTile extends JPanel {
        private int tileRank, tileFile;
        private BoardPanel bp;
        public ChessTile(BoardPanel b, int i, int j) {
        	super(new GridBagLayout());
            bp = b;
            tileRank = i;
            tileFile = j;
            if ((i + j) % 2 == 1)
                this.setBackground(Color.BLACK);
            assignTilePiece(board);
            setPreferredSize(new Dimension(10, 10));
            this.add(new JLabel(this.tileRank + " " + this.tileFile)); //tile-coord labels
            setOpaque(true);
            this.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(final MouseEvent e) { //refractor into GameEngine as clickedTile(ChessTile tile) -> call here clickedTile(this)
					if(SwingUtilities.isRightMouseButton(e)) {
						sourceTile = null;
						destTile = null;
						pieceToMove = null;
					}
					else if(SwingUtilities.isLeftMouseButton(e)) {
						if(sourceTile == null) {
							sourceTile = board.getTile(tileRank, tileFile);
							pieceToMove = sourceTile.getPiece();
							if(pieceToMove == null)
								sourceTile = null;
						}
						else {
							destTile = board.getTile(tileRank, tileFile);
							Move move = new Move(board, sourceTile, destTile);
							if(move.isValid()) {
								sourceTile = null;
								destTile = null;
								pieceToMove = null;
								board.executeMove(move);
							}
							else {//logic if move is not valid
								sourceTile = null;
								destTile = null;
								pieceToMove = null;
							}
						}
					}
					SwingUtilities.invokeLater(new Runnable() {

						@Override
						public void run() {
						bp.drawBoard(board);
						}
						
					});
					
 				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
            	
            });
            validate();
        }
        
        /**
         * draws tiles with proper color and piece, if applicable
         * @param b
         */
        public void drawTile(Board b) {
        	assignTilePiece(b);
        	  if ((tileRank + tileFile) % 2 == 1)
                  this.setBackground(Color.BLACK);
        	  validate();
        }

        /**
         * adds a JLabel graphical representation of chess piece to tile
         * @param b
         */
        private void assignTilePiece(Board b){
            removeAll();
            Tile t = b.getTile(tileRank, tileFile);
            if(t == null)
                return;
            if(t.isOccupied()){
                Piece p = t.getPiece();
                StringBuilder imagePath = new StringBuilder("Images/w");
                if(!p.isWhite())
                   imagePath = new StringBuilder("Images/b");
                if(p instanceof Pawn)
                    imagePath.append("p");
                else if(p instanceof Bishop)
                    imagePath.append("b");
                else if(p instanceof Rook)
                    imagePath.append("r");
                else if(p instanceof Knight)
                    imagePath.append("n");
                else if(p instanceof Queen)
                    imagePath.append("q");
                 else
                    imagePath.append("k");
                imagePath.append(".png");
                try {
                    final BufferedImage pieceImage = ImageIO.read(new File(imagePath.toString()));
                    add(new JLabel(new ImageIcon(pieceImage)));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
