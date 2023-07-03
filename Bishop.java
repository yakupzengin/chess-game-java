public class Bishop extends Piece {
    /**
     * Constructs a  new Bishop with the   specified color and location.
     *
     * Parameter :  color : the color of the piece
     * Parameter :  location : the initial location of the piece on the chessboard
     */
    public Bishop(int color, Square location) {
        super(color, location);
    }


    // Checks if the bishop can move to the destination "to"
    @Override
    public boolean canMove(String to) {
        boolean validMove = false;
        Square targetLocation = getBoard().getSquareAt(to);
        Square currentLocation = getLocation();

        int rowDistance = Math.abs(targetLocation.getRowDistance(location));
        int colDistance = Math.abs(targetLocation.getColDistance(location));

        // Checks if the bishop is moving diagonally
        if (rowDistance==colDistance){
            // Check if all squares between current and target locations are empty
            for (Square square : getBoard().getSquaresBetween(currentLocation,targetLocation)){
                if (!square.isEmpty()){
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
        return color == ChessBoard.WHITE ? "B" : "b";
    }
}
