public class Knight extends Piece {
    /**
     * Constructs a new Knight with the specified color and location.
     *
     * Parameter :  color : the color  of the piece
     * Parameter :  location : the initial location of the piece on the chessboard
     */
    public Knight(int color, Square location) {
        super(color, location);
    }

    //  Checks if the knight can move to the destination "to"
    @Override
    public boolean canMove(String to) {
        boolean validMove = false;
        Square targetLocation = getBoard().getSquareAt(to);

        int rowDistance = Math.abs(targetLocation.getRowDistance(location));
        int colDistance = Math.abs(targetLocation.getColDistance(location));

        //  Checks if the knight is moving in an L shape
        if ((rowDistance == 2 && colDistance == 1) || (rowDistance == 1 && colDistance == 2)) {

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
        return color == ChessBoard.WHITE ? "N" : "n";
    }
}