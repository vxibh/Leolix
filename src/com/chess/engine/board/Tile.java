package com.chess.engine.board;
import com.chess.engine.pieces.Piece;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;

public abstract class Tile {
    protected final int tileCoordinate; //can only be accessed by subclasses

    private static final Map<Integer, EmptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();

    private static Map<Integer,EmptyTile> createAllPossibleEmptyTiles() {

        final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();
        for(int i=0; i < BoardUtils.NUM_TILES; i++)
        {
            emptyTileMap.put(i, new EmptyTile(i));
        }

        //Collections.unmodifiableMap(emptyTileMap);
        return ImmutableMap.copyOf(emptyTileMap);
    }

    public static Tile createTile(final int tileCoordinate, final Piece piece) {
        return piece != null ? new OccupiedTile(tileCoordinate, piece) : EMPTY_TILES_CACHE.get(tileCoordinate);
    }
    //tile constructor
    private Tile(final int tileCoordinate){
        this.tileCoordinate = tileCoordinate;
    }
    //check if given tile is occupied or not
    public abstract boolean isTileOccupied();

    //get the piece of a given tile
    public abstract Piece getPiece();

    public int getTileCoordinate() {
        return this.tileCoordinate;
    }

    //empty tile method
    public static final class EmptyTile  extends Tile {
        private EmptyTile(final int coordinate) {
            super(coordinate);
        }

        @Override
        public String toString() { //return the hyphen the tile is empty
            return "-";
        }

        @Override
        public boolean isTileOccupied() {
            return false;
        }

        @Override
        public Piece getPiece() {
            return null;
        }
    }
    //occupied tile method
    public static final class OccupiedTile extends Tile {

        private final Piece pieceOnTile; //can't be referenced outside this unless getPiece is called
        private OccupiedTile(int tileCoordinate, final Piece pieceOnTile) {
            super(tileCoordinate);
            this.pieceOnTile = pieceOnTile;
        }

        @Override
        public String toString() { //printing the toString of given piece
            return getPiece().getPieceAlliance().isBlack() ? getPiece().toString().toLowerCase() : getPiece().toString();
        }

        @Override
        public boolean isTileOccupied(){
            return true;
        }

        @Override
        public Piece getPiece() {
            return this.pieceOnTile;
        }
    }

}
