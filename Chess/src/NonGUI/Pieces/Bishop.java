package NonGUI.Pieces;

import NonGUI.Enums.EnumValues;
import NonGUI.Exceptions.InvalidSpaceLocationException;
import NonGUI.GameParts.Board;
import NonGUI.GameParts.Player;
import NonGUI.GameParts.StartUp.Pair;

import java.awt.*;
import java.util.ArrayList;

public class Bishop extends Piece {

    private ArrayList<Pair<Point, Boolean>> startLocations;
    private ArrayList<Point> nextLocations;
    private boolean nextLocationsFound;

    public Bishop(){
        super(EnumValues.pieceType.Bishop);
        nextLocations = new ArrayList<>();
        nextLocationsFound = false;

        int playerRow = (getPlayer() == EnumValues.currentPlayer.Player1 ? 0 : 7);

        startLocations = new ArrayList<>();
        startLocations.add(new Pair(new Point(2, playerRow), false));
        startLocations.add(new Pair(new Point(5, playerRow), false));
    }


    @Override
    public ArrayList<Pair<Point, Boolean>> getStartLocations() {
        ArrayList<Pair<Point, Boolean>> copy = startLocations;
        return copy;
    }

    @Override
    public void move(Point moveTo) throws InvalidSpaceLocationException{
        if(nextLocations.contains(moveTo)){
            setPieceLocation(moveTo);
            nextLocationsFound = false;
        }else{
            throw new InvalidSpaceLocationException(String.format("The location | X=%d Y=%d | is invalid for the %s", moveTo.getX(), moveTo.getY(), "Bishop"));
        }
    }

    @Override
    public ArrayList<Point> getNextLocations(Board board, Player player) {
        if(nextLocationsFound){
            return nextLocations;
        }else {
            nextLocations.clear();

            //false means keep adding nothing encountered
            //true means stop adding something encountered
            boolean leftTop = false;
            boolean leftBottom = false;
            boolean rightTop = false;
            boolean rightBottom = false;

            Point lt, tb, rt, rb;
            lt = tb = rt = rb = getPieceLocation();

            for (int i = 0; !leftTop || !leftBottom || !rightTop || !rightBottom; i++) {
                if (!leftTop && lt.getX() > 0 && lt.getY() > 0) {
                    lt.translate(-1, -1);
                    EnumValues.spaceOccupation availability = board.getSpaceAvailability(lt, player);
                    leftTop = board.addLocation(availability, lt, this);
                }
                if (!leftBottom && tb.getX() > 0 && tb.getY() < board.getBoardSize() - 1) {
                    tb.translate(-1, 1);
                    EnumValues.spaceOccupation availability = board.getSpaceAvailability(tb, player);
                    leftBottom = board.addLocation(availability, tb, this);
                }
                if (!rightTop && rt.getX() < board.getBoardSize() - 1 && rt.getY() > 0) {
                    rt.translate(1, -1);
                    EnumValues.spaceOccupation availability = board.getSpaceAvailability(rt, player);
                    rightTop = board.addLocation(availability, rt, this);
                }
                if (!rightBottom && rb.getX() < board.getBoardSize() - 1 && rb.getY() < board.getBoardSize() - 1) {
                    rb.translate(1, 1);
                    EnumValues.spaceOccupation availability = board.getSpaceAvailability(rb, player);
                    rightBottom = board.addLocation(availability, rb, this);
                }
            }
            nextLocationsFound = true;
            return nextLocations;
        }
    }

    @Override
    public void addPossiblePieceLocation(Point location) {
        nextLocations.add(location);
    }
}
