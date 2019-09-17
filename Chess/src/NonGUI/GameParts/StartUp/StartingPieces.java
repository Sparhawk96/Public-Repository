package NonGUI.GameParts.StartUp;

import NonGUI.Enums.EnumValues;
import NonGUI.Pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class StartingPieces {

    private ArrayList<Pair<Pair<EnumValues.pieceType, Integer>, Class<? extends Piece>>> listPairs;

    /**
     * Sets up an object that holds the pieces needed for the game
     * as well as number needed. This is per player.
     */
    public StartingPieces(){
        listPairs = new ArrayList<>();
    }

    /**
     * Adds pieces to the pieces needed to start the game.
     * This list that is getting added to will hold for each
     * index the type of object, quantity, and class of object
     * @param type enumValue
     * @param number quantity
     * @param pieceClass class of the piece
     */
    public void addPiece(EnumValues.pieceType type, int number, Class pieceClass){
        Pair<EnumValues.pieceType, Integer> pairOne = new Pair<>(type, number);
        Pair<Pair<EnumValues.pieceType, Integer>, Class<? extends Piece>> pairTwo = new Pair<>(pairOne, pieceClass);
        listPairs.add(pairTwo);
    }

    /**
     * Adds pieces to the pieces needed to start the game
     * @param pair holds piece type and number needed
     * @param pieceClass class of the piece
     */
    public void addPiece(Pair<EnumValues.pieceType, Integer> pair, Class pieceClass){
        Pair<Pair<EnumValues.pieceType, Integer>, Class<? extends Piece>> pairTwo = new Pair<>(pair, pieceClass);
        listPairs.add(pairTwo);
    }

    /**
     * Adds pieces to the pieces needed to start the game
     * @param pair holds piece type, quantity, and piece class
     */
    public void addPiece(Pair<Pair<EnumValues.pieceType, Integer>, Class<? extends Piece>> pair){
        listPairs.add(pair);
    }

    /**
     * @return List of all pieces needed with quantity
     */
    public ArrayList<Pair<Pair<EnumValues.pieceType, Integer>, Class<? extends Piece>>> getPairs(){
        ArrayList<Pair<Pair<EnumValues.pieceType, Integer>, Class<? extends Piece>>> copy = listPairs;
        return copy;
    }
}
