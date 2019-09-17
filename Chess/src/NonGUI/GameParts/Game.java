package NonGUI.GameParts;

import NonGUI.Enums.EnumValues;
import NonGUI.GameParts.StartUp.Pair;
import NonGUI.GameParts.StartUp.StartingPieces;
import NonGUI.Pieces.*;

import java.util.HashMap;

public class Game {

    public static EnumValues.turn turn;

    public static void main(String[] args){
        Pair<Pair<EnumValues.pieceType, Integer>, Class<? extends Piece>> pairKing = new Pair<>(new Pair<>(EnumValues.pieceType.King, 1), new King().getClass());
        Pair<Pair<EnumValues.pieceType, Integer>, Class<? extends Piece>> pairQueen = new Pair<>(new Pair<>(EnumValues.pieceType.Queen, 1), new Queen().getClass());
        Pair<Pair<EnumValues.pieceType, Integer>, Class<? extends Piece>> pairBishop = new Pair<>(new Pair<>(EnumValues.pieceType.Bishop, 2), new Bishop().getClass());
        Pair<Pair<EnumValues.pieceType, Integer>, Class<? extends Piece>> pairKnight = new Pair<>(new Pair<>(EnumValues.pieceType.Knight, 2), new Knight().getClass());
        Pair<Pair<EnumValues.pieceType, Integer>, Class<? extends Piece>> pairCastle = new Pair<>(new Pair<>(EnumValues.pieceType.Castle, 2), new Castle().getClass());
        Pair<Pair<EnumValues.pieceType, Integer>, Class<? extends Piece>> pairPawn = new Pair<>(new Pair<>(EnumValues.pieceType.Pawn, 8), new Pawn().getClass());

        StartingPieces sp = new StartingPieces();

        sp.addPiece(pairKing);
        sp.addPiece(pairQueen);
        sp.addPiece(pairBishop);
        sp.addPiece(pairKnight);
        sp.addPiece(pairCastle);
        sp.addPiece(pairPawn);

        Player one = new Player(EnumValues.currentPlayer.Player1, sp.getPairs());
        Player two = new Player(EnumValues.currentPlayer.Player2, sp.getPairs());

        Board board = new Board(one, two, 8);
        board.printBoard();
        turn = EnumValues.turn.PlayerOne;
    }
}
