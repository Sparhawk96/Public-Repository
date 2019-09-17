package NonGUI.Pieces;

import NonGUI.Enums.EnumValues;
import NonGUI.GameParts.Board;
import NonGUI.GameParts.Player;
import NonGUI.GameParts.StartUp.Pair;

import java.awt.*;
import java.util.ArrayList;

public class Pawn extends Piece {

    private ArrayList<Pair<Point, Boolean>> startLocations;

    public Pawn(){
        super(EnumValues.pieceType.Pawn);

        int playerRow = (getPlayer() == EnumValues.currentPlayer.Player1 ? 1 : 6);

        startLocations = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            startLocations.add(new Pair(new Point(i, playerRow), false));
        }
    }

    @Override
    public ArrayList<Pair<Point, Boolean>> getStartLocations() {
        ArrayList<Pair<Point, Boolean>> copy = startLocations;
        return copy;
    }

    @Override
    public void move(Point moveTo) {

    }

    @Override
    public ArrayList<Point> getNextLocations(Board board, Player player) {
        return null;
    }

    @Override
    public void addPossiblePieceLocation(Point location) {

    }
}
