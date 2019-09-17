package NonGUI.Enums;

public class EnumValues {

    public enum pieceType {King, Queen, Bishop, Knight, Castle, Pawn, Empty};

    public enum currentPlayer {Player1, Player2, Empty};

    public enum spaceOccupation {Open, SamePlayerPiece, OppositePlayerPiece, KingInCheck};

    public enum checkmate {PlayerOne, PlayerTwo, Nobody};

    public enum turn {PlayerOne, PlayerTwo};
}
