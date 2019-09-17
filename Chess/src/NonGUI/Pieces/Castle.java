package NonGUI.Pieces;

import NonGUI.Enums.EnumValues;
import NonGUI.Exceptions.InvalidSpaceLocationException;
import NonGUI.GameParts.Board;
import NonGUI.GameParts.Player;
import NonGUI.GameParts.StartUp.Pair;

import java.awt.*;
import java.util.ArrayList;

public class Castle extends Piece{

    private ArrayList<Pair<Point, Boolean>> startLocations;
    private boolean moved;
    private ArrayList<Point> nextLocations;
    private boolean nextLocationsFound;

    public Castle(){
        super(EnumValues.pieceType.Castle);
        moved = false;

        int playerRow = (getPlayer() == EnumValues.currentPlayer.Player1 ? 0 : 7);

        startLocations = new ArrayList<>();
        startLocations.add(new Pair(new Point(0, playerRow), false));
        startLocations.add(new Pair(new Point(7, playerRow), false));
    }

    @Override
    public ArrayList<Pair<Point, Boolean>> getStartLocations() {
        ArrayList<Pair<Point, Boolean>> copy = startLocations;
        return copy;
    }

    @Override
    public void move(Point moveTo) throws InvalidSpaceLocationException{
        if(nextLocations.contains(moveTo)){
            moved = true;
            setPieceLocation(moveTo);
            nextLocationsFound = false;
        }else{
            throw new InvalidSpaceLocationException(String.format("The location | X=%d Y=%d | is invalid for the %s", moveTo.getX(), moveTo.getY(), "Castle"));
        }
    }

    @Override
    public ArrayList<Point> getNextLocations(Board board, Player player) {
        if(nextLocationsFound){
            return nextLocations;
        }else{
            nextLocations.clear();

            if(!moved){
                King king = (King) player.getPieces().get("King");
                if(king.getMoved()){
                    //Determines number of spaces between Castle and King
                    int distance = Math.abs((int)(getPieceLocation().getX() - king.getPieceLocation().getX()) - 1);
                    int numEmptySpaces = 0;

                    //Figures out if spaces between Castle and King are open
                    for(int i = (distance == 3 ? 1 : 5); i < (distance == 3 ? 4 : 7); i++){
                        if(board.getSpaceAvailability(new Point(i, (int)getPieceLocation().getY()), player) == EnumValues.spaceOccupation.Open){
                          numEmptySpaces++;
                        }
                    }

                    //If true it's possible to do Castling
                    if((numEmptySpaces == 3 && distance == 3) || (numEmptySpaces == 2 && distance == 2)){

                    }
                }
            }

            //false means keep adding nothing encountered
            //true means stop adding something encountered
            boolean top = false;
            boolean bottom = false;
            boolean right = false;
            boolean left = false;

            Point t, b, l, r;
            t = b = l = r = getPieceLocation();

            for(int i = 0; !top || !bottom || !right || !left; i++){
                if(!top && t.getY() > 0){
                    t.translate(0, -1);
                    EnumValues.spaceOccupation availability = board.getSpaceAvailability(t, player);
                    top = board.addLocation(availability, t, this);
                }
                if(!bottom && b.getY() < board.getBoardSize() - 1){
                    b.translate(0, 1);
                    EnumValues.spaceOccupation availability = board.getSpaceAvailability(b, player);
                    bottom = board.addLocation(availability, b, this);
                }
                if(!right && r.getX() < board.getBoardSize() - 1){
                    r.translate(1, 0);
                    EnumValues.spaceOccupation availability = board.getSpaceAvailability(r, player);
                    right = board.addLocation(availability, r, this);
                }
                if(!left && l.getX() > 0){
                    l.translate(-1, 0);
                    EnumValues.spaceOccupation availability = board.getSpaceAvailability(l, player);
                    left = board.addLocation(availability, l, this);
                }
            }
            nextLocationsFound = true;
            return nextLocations;
        }
    }

    /**
     * @return if the Castle has moved or not
     */
    public boolean getMoved(){
        return moved;
    }

    @Override
    public void addPossiblePieceLocation(Point location) {
        nextLocations.add(location);
    }
}
