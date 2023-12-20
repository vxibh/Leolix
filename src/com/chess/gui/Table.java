package com.chess.gui;

import com.chess.engine.board.Board;
import com.chess.engine.board.BoardUtils;
import com.chess.engine.board.Move;
import com.chess.engine.board.Tile;
import com.chess.engine.pieces.Piece;
import com.chess.engine.player.MoveTransition;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.SwingUtilities.isLeftMouseButton;
import static javax.swing.SwingUtilities.isRightMouseButton;


public class Table {

    private final JFrame gameFrame;
    private final BoardPanel boardPanel;
    private Board chessBoard = Board.createStandardBoard();
    private Tile sourceTile;
    private Tile destinationTile;
    private Piece humanMovedPiece;
    private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(600, 600);
    private final   static Dimension BOARD_PANEL_DIMENSION = new Dimension( 400, 350);
    private final static Dimension TILE_PANEL_DIMENSION = new Dimension(13, 13);
    private static String defaultPieceImagesPath = "./art/fancy/";
    private Color lightTileColor = Color.decode("#f8dcb4");
    private Color darkTileColor = Color.decode("#b88c64");

    public Table() {
        this.gameFrame = new JFrame("Leolix-Chess");
        this.gameFrame.setLayout(new BorderLayout());
        final JMenuBar tableMenuBar = createTableMenuBar();
        this.gameFrame.setJMenuBar(tableMenuBar);
        this.gameFrame.setSize((OUTER_FRAME_DIMENSION));
        this.chessBoard = chessBoard;
        this.boardPanel = new BoardPanel();
        this.gameFrame.add(this.boardPanel, BorderLayout.CENTER);
        this.gameFrame.setVisible(true);
    }

    private JMenuBar createTableMenuBar() {
        final JMenuBar tableMenuBar = new JMenuBar();
        tableMenuBar.add(createFileMenu());
        return tableMenuBar;
    }

    private JMenu createFileMenu() {
        final JMenu fileMenu = new JMenu("File");
        final JMenuItem openPGN = new JMenuItem("Load PGN File");
        openPGN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Open the PGN");
            }
        });
        fileMenu.add(openPGN);

        final JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(exitMenuItem);
        return fileMenu;
    }

    private class BoardPanel extends JPanel {
        final List<TilePanel> boardTiles;

        BoardPanel() {
            super(new GridLayout(8, 8));
            this.boardTiles = new ArrayList<>();
            for(int i = 0; i< BoardUtils.NUM_TILES; i++) {
                final TilePanel tilePanel = new TilePanel(this, chessBoard, i);
                this.boardTiles.add(tilePanel);
                add(tilePanel);
            }
            setPreferredSize(BOARD_PANEL_DIMENSION);
            validate();
        }
    }

    private class TilePanel extends JPanel {
        private final int tileId;
        TilePanel(final BoardPanel boardPanel, final Board chessBoard, final int tileId) {
            super(new GridBagLayout());
            this.tileId = tileId;
            setPreferredSize(TILE_PANEL_DIMENSION);
            assignTileColor();
            assignTilePieceIcon(chessBoard);

            addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(final MouseEvent e) {
                    if (isRightMouseButton(e)) {

                        sourceTile = null;
                        destinationTile = null;
                        humanMovedPiece = null;
                        //first click
                    } else if (isLeftMouseButton(e)) {

                        if (sourceTile == null) {
                            sourceTile = chessBoard.getTile(tileId);
                            humanMovedPiece = sourceTile.getPiece();
                            if (humanMovedPiece == null) {
                                sourceTile = null;
                            }
                        } else {
                            destinationTile = chessBoard.getTile(tileId);
                            final Move move = null;
                        }
                    }
                }
                @Override
                public void mousePressed(final MouseEvent e) {

                }

                @Override
                public void mouseReleased(final MouseEvent e) {

                }

                @Override
                public void mouseEntered(final MouseEvent e) {

                }

                @Override
                public void mouseExited(final MouseEvent e) {

                }
            });

            validate();
        }


//        private void assignTilePieceIcon(final Board board) {
//            this.removeAll();
//            if (board != null && board.getTile(this.tileId).isTileOccupied()) {
//                try {
//                    String imagePath = defaultPieceImagesPath +
//                            board.getTile(this.tileId).getPiece().getPieceAlliance().toString().substring(0, 1) +
//                            board.getTile(this.tileId).getPiece().toString() + ".png"; // Assuming PNG format
//
//                    ImageIcon icon = new ImageIcon(imagePath);
//                    double scaleFactor = 5.0;
//
//                    int scaledWidth = (int) (TILE_PANEL_DIMENSION.width * scaleFactor);
//                    int scaledHeight = (int) (TILE_PANEL_DIMENSION.height * scaleFactor);
//                    Image scaledImage = icon.getImage().getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
//                    icon = new ImageIcon(scaledImage);
//
//                    JLabel label = new JLabel(icon);
//                    add(label);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        private void assignTilePieceIcon(final Board board) {
            this.removeAll();
            if (board != null && board.getTile(this.tileId).isTileOccupied()) {
                try {
                    String imagePath = defaultPieceImagesPath +
                            board.getTile(this.tileId).getPiece().getPieceAlliance().toString().substring(0, 1) +
                            board.getTile(this.tileId).getPiece().toString() + ".png"; // Assuming PNG format

                    ImageIcon icon = new ImageIcon(imagePath);

                    int scaledWidth = (int) (TILE_PANEL_DIMENSION.width * 5.0);
                    int scaledHeight = (int) (TILE_PANEL_DIMENSION.height * 5.0);

                    Image image = icon.getImage();
                    BufferedImage bufferedImage = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_ARGB);

                    Graphics2D g2d = bufferedImage.createGraphics();

                    // Set rendering hints for higher quality
                    g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                    AffineTransform transform = AffineTransform.getScaleInstance(
                            (double) scaledWidth / image.getWidth(null),
                            (double) scaledHeight / image.getHeight(null)
                    );

                    g2d.drawImage(image, transform, null);
                    g2d.dispose();

                    ImageIcon scaledIcon = new ImageIcon(bufferedImage);

                    JLabel label = new JLabel(scaledIcon);
                    add(label);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }



        private void assignTileColor() {
            if(BoardUtils.EIGHTH_RANK[this.tileId] ||
                    BoardUtils.SIXTH_RANK[this.tileId] ||
                    BoardUtils.FOURTH_RANK[this.tileId] ||
                    BoardUtils.SECOND_RANK[this.tileId]) {
                setBackground(this.tileId % 2 == 0 ? lightTileColor : darkTileColor);
            } else if(BoardUtils.SEVENTH_RANK[this.tileId] ||
                    BoardUtils.FIFTH_RANK[this.tileId] ||
                    BoardUtils.THIRD_RANK[this.tileId] ||
                    BoardUtils.FIRST_RANK[this.tileId]) {
                setBackground(this.tileId % 2 != 0 ? lightTileColor : darkTileColor);

            }
        }
    }
}
