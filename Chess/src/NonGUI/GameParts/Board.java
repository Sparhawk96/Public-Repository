package NonGUI.GameParts;

import NonGUI.Enums.EnumValues;
import NonGUI.Pieces.King;
import NonGUI.Pieces.Piece;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Board {

    private EnumValues.pieceType[][] pieceLocations;
    private EnumValues.currentPlayer[][] playerLocations;
    private int[][] pieceNumbers;
    private int boardSize;
    private Player one;
    private Player two;

    /**
     * Sets up the initial board layout
     * @param one being the first player
     * @param two being the second player
     * @param boardSize size of the board to play on
     */
    public Board(Player one, Player two, int boardSize){
        pieceLocations = new EnumValues.pieceType[boardSize][boardSize];
        playerLocations = new EnumValues.currentPlayer[boardSize][boardSize];
        pieceNumbers = new int[boardSize][boardSize];
        this.boardSize = boardSize;
        Board instance = this;
        one.setPiecesOnBoard(instance);
        two.setPiecesOnBoard(instance);

        this.one = one;
        this.two = two;

        for(int i = 0; i < pieceLocations.length; i++){
            for(int j = 0; j < pieceLocations.length; j++){
                if(pieceLocations[i][j] == null) {
                    playerLocations[i][j] = EnumValues.currentPlayer.Empty;
                    pieceLocations[i][j] = EnumValues.pieceType.Empty;
                }
            }
        }
    }

    /**
     * Allows the player object to set the initial pieces on the board
     * @param location point with x=0, y=0 being the top left corner
     * @param piece piece to place
     */
    public void setPieceLocation(Point location, Piece piece, int pieceNumber){
        pieceLocations[(int)location.getY()][(int)location.getX()] = piece.getType();
        playerLocations[(int)location.getY()][(int)location.getX()] = piece.getPlayer();
        pieceNumbers[(int)location.getY()][(int)location.getX()] = pieceNumber;
    }

    /**
     * Prints the current boards state
     */
    public void printBoard(){
        String rowSeparator = "";
        //Determines the row length to be printed
        for(int num = 0; num < Math.pow(pieceLocations.length + 1, 2); num++){
            rowSeparator += "-";
        }

        //Determines spacing needed for empty boxes
        String emptyValues = "";
        for(int num = 0; num < pieceLocations.length + 1; num++){
            emptyValues += " ";
        }

        /* Makes a buffer between the row and location info
        String rowBuffer = "";
        for(int num = 0; num < rowSeparator.length(); num++){
            if(num%10 == 0){
                rowBuffer = "|" + rowBuffer;
            }else{
                rowBuffer = " " + rowBuffer;
            }
        }
        */

        //Loops through all the board locations
        for(int i = 0; i < pieceLocations.length; i++){
            System.out.println(rowSeparator);
            //System.out.println(rowBuffer);
            int j;
            // Prints each piece info in the right column
            for(j = 0; j < pieceLocations.length; j++){
                if(pieceLocations[i][j] != EnumValues.pieceType.Empty) {
                    String pieceName = pieceLocations[i][j].toString() + pieceNumbers[i][j];
                    int spaceOne = 9 - pieceName.length();
                    //Puts the info in the middle of the box
                    for (int kOne = 0; kOne < spaceOne; kOne++) {
                        if (spaceOne / 2 > kOne) {
                            pieceName = " " + pieceName;
                        } else {
                            pieceName = pieceName + " ";
                        }
                    }
                    System.out.print("|" + pieceName + (j == pieceLocations.length - 1 ? "|\n" : ""));
                }else{
                    System.out.print("|" + emptyValues + (j == pieceLocations.length - 1 ? "|\n" : ""));
                }
            }
            // Prints each pieces player info under piece info in the right column
            for(j = 0; j < pieceLocations.length; j++){
                if(pieceLocations[i][j] != EnumValues.pieceType.Empty) {
                    String playerName = playerLocations[i][j].toString();
                    int spaceTwo = 9 - playerName.length();
                    //Puts the info in the middle of the box
                    for (int kTwo = 0; kTwo < spaceTwo; kTwo++) {
                        if (spaceTwo / 2 > kTwo) {
                            playerName = " " + playerName;
                        } else {
                            playerName = playerName + " ";
                        }
                    }
                    System.out.print("|" + playerName + (j == pieceLocations.length - 1 ? "|\n" : ""));
                }else{
                    System.out.print("|" + emptyValues + (j == pieceLocations.length - 1 ? "|\n" : ""));
                }
            }
            //System.out.println(rowBuffer);
        }
        System.out.println(rowSeparator);
    }

    /**
     * Determines if the location being checked is open, occupied by
     * the players piece, or occupied by the opposite players piece
     * @param locCheck space to check
     * @param playerToCheck player checking availability
     * @return Open if empty, SamePlayerPiece if player already has a piece there,
     *         OppositePlayerPiece if opposite player has a piece that occupies that space
     */
    public EnumValues.spaceOccupation getSpaceAvailability(Point locCheck, Player playerToCheck){
        if(pieceLocations[(int)locCheck.getY()][(int)locCheck.getX()].equals(EnumValues.pieceType.Empty)){
            return EnumValues.spaceOccupation.Open;
        }else{
            if(playerLocations[(int)locCheck.getY()][(int)locCheck.getX()].equals(EnumValues.currentPlayer.Player1) && playerToCheck.getPlayer().equals(EnumValues.currentPlayer.Player1)){
                return EnumValues.spaceOccupation.SamePlayerPiece;
            }else{
                return EnumValues.spaceOccupation.OppositePlayerPiece;
            }
        }
    }

    /**
     * @return Size of board
     */
    public int getBoardSize(){
        return boardSize;
    }

    /**
     * Determines if the location should be added to possible locations or not
     * @param availability determining factor
     * @param loc location to add
     * @return true to stop added location in a direction, false to keep adding locations
     */
    public boolean addLocation(EnumValues.spaceOccupation availability, Point loc, Piece piece){
        switch (availability) {
            case OppositePlayerPiece:
                piece.addPossiblePieceLocation(loc);
                return true;
            case SamePlayerPiece:
                return true;
            default:
                piece.addPossiblePieceLocation(loc);
                return false;
        }
    }

    public boolean testCheckMate(EnumValues.pieceType[][] pieces, EnumValues.currentPlayer[][] playerPieces, EnumValues.turn turn){
        for(int i = 0; i < getBoardSize(); i++){
            for(int j = 0; j < getBoardSize(); j++){

            }
        }
        return false;
    }

}
