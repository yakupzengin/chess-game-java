public class Rook extends Piece {
    /**
     * Constructs a new Rook with the specified color and location.
     *
     * Parameter :  color : the color of the piece
     * Parameter :  location : the initial location of the piece on the chessboard
     */
    public Rook(int color, Square location) {
        super(color, location);
    }

    // Checks if the rook  can move to the destination "to"
    @Override
    public boolean canMove(String to) {
        boolean validMove = false;

        Square targetLocation = getBoard().getSquareAt(to);
        Square currentLocation = getLocation();

        // Checks if the rook is moving in a straight line
        if (currentLocation.isAtSameColumn(targetLocation) || currentLocation.isAtSameRow(targetLocation)) {

            // Checks if all squares between current locations and target locations are empty
            for (Square square : getBoard().getSquaresBetween(currentLocation, targetLocation)) {
                if (!square.isEmpty()) {
                    return false;
                }
            }
            // Check if there is a piece of the same color at the target location
            if (!targetLocation.isEmpty() && targetLocation.getPiece().getColor() == color) {
                return false;
            }
            validMove = true;
        }
        return validMove;
    }

    @Override
    public String toString() {
        return color == ChessBoard.WHITE ? "R" : "r";
    }
}
