package NonGUI.Pieces;

import NonGUI.Enums.EnumValues;
import NonGUI.Exceptions.InvalidSpaceLocationException;
import NonGUI.GameParts.Board;
import NonGUI.GameParts.Player;
import NonGUI.GameParts.StartUp.Pair;

import java.awt.*;
import java.util.ArrayList;

public abstract class Piece {

    private EnumValues.pieceType type;
    private Point location;
    private EnumValues.currentPlayer player;

    public Piece(EnumValues.pieceType piece){
        type = piece;
    }

    /**
     * Provides positions each piece will need to start at depending on the player
     * @return a list of possible starting positions for the piece
     */
    public abstract ArrayList<Pair<Point, Boolean>> getStartLocations();

    /**
     * Will move the piece to the desired location
     * @param moveTo X and Y locations of location to move
     * @throws InvalidSpaceLocationException when given an invalid location to move to
     */
    public abstract void move(Point moveTo) throws InvalidSpaceLocationException;

    /**
     * Provides a list of surrounding locations the piece can move to.
     * @return An ArrayList of Points the piece can move to
     */
    public abstract ArrayList<Point> getNextLocations(Board board, Player player);

    /**
     * Adds a location to an array that holds all possible locations the piece could move to
     * @param location to be added
     */
    public abstract void addPossiblePieceLocation(Point location);

    /**
     * Gets the pieces player
     * @return player that controls the piece
     */
    public EnumValues.currentPlayer getPlayer(){
        return player;
    }

    /**
     * Sets the pieces alliance to a specific player
     * @param player one ot two
     */
    public void setPlayer(EnumValues.currentPlayer player){
     this.player = player;
    }

    /**
     * Provides the Piece type for the current piece
     * @return Piece object type
     */
    public EnumValues.pieceType getType(){
        return type;
    }

    /**
     * Provides the pieces current location
     * @return X and Y location of piece
     */
    public Point getPieceLocation(){
        Point copy = location;
        return copy;
    }

    /**
     * Sets the Pieces Location
     */
    public void setPieceLocation(Point location){
        this.location = location;
    }
}
