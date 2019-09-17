package NonGUI.Pieces;

import NonGUI.Enums.EnumValues;
import NonGUI.GameParts.Board;
import NonGUI.GameParts.Player;
import NonGUI.GameParts.StartUp.Pair;

import java.awt.*;
import java.util.ArrayList;

public class Queen extends Piece{

    private ArrayList<Pair<Point, Boolean>> startLocations;

    public Queen(){
        super(EnumValues.pieceType.Queen);

        int playerRow = (getPlayer() == EnumValues.currentPlayer.Player1 ? 0 : 8);

        startLocations = new ArrayList<>();
        startLocations.add(new Pair(new Point(3, playerRow), false));
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
