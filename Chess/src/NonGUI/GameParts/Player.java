package NonGUI.GameParts;

import NonGUI.Enums.EnumValues;
import NonGUI.GameParts.StartUp.Pair;
import NonGUI.Pieces.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Player {

    private HashMap<String, Piece> pieces;
    private EnumValues.currentPlayer player;

    /**
     * Sets up the player with the right pieces
     * @param player
     */
    public Player(EnumValues.currentPlayer player, ArrayList<Pair<Pair<EnumValues.pieceType, Integer>, Class<? extends Piece>>> necessaryPieces){
        this.player = player;

        pieces = new HashMap<>();

        for(int i = 0; i < necessaryPieces.size(); i++){
            for(int j = 0; j < necessaryPieces.get(i).getA().getB(); j++){
                Piece piece = null;
                try {
                    piece = necessaryPieces.get(i).getB().getDeclaredConstructor().newInstance();
                }catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e){}
                piece.setPlayer(getPlayer());
                pieces.put(necessaryPieces.get(i).getA().getA().toString() + j, piece);
            }
        }

    }

    /**
     * Sets the pieces on the board and gives each piece a starting location
     * @param board on which the players will play
     */
    public void setPiecesOnBoard(Board board){
        for(Map.Entry<String, Piece> entry : pieces.entrySet()){
        }
    }

    /**
     * @return playerName either one or two
     */
    public EnumValues.currentPlayer getPlayer(){
        return player;
    }

    /**
     * @return Hashmap of players pieces
     */
    public HashMap<String, Piece> getPieces(){
        HashMap<String, Piece> copy = pieces;
        return copy;
    }
   
}
