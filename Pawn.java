public class Pawn extends Piece {
    private boolean initialLocation = true;


    /**
     * Constructs a new Pawn with the specified color and location.
     *
     * Parameter :  color : the color  of the piece
     * Parameter :  location : the initial location of the piece on the chessboard
     */
    public Pawn(int color, Square location) {
        super(color, location);
    }

    // Checks if the pawn can move to the destination " to "
    @Override
    public boolean canMove(String to) {

        boolean validMove = false;

        Square targetLocation = location.getBoard().getSquareAt(to);

        int rowDistance = targetLocation.getRowDistance(location);

        // Check if the pawn is moving forward
        if (this.location.isAtSameColumn(targetLocation)) {
            if (color == ChessBoard.WHITE && rowDistance > 0 && rowDistance <= 2) {
                // WHİTE pawn moves
                if (rowDistance == 2) {

                    // Checks if  the pawn is at initial location and squares in front are empty
                    if (initialLocation) {
                        Square[] between = location.getBoard().getSquaresBetween(location,targetLocation);
                        validMove = targetLocation.isEmpty() && between.length > 0 && between[0].isEmpty();
                    }

                } else {
                    validMove = targetLocation.isEmpty();
                }

                return validMove;


            } else if (color == ChessBoard.BLACK && rowDistance < 0 && rowDistance >= -2) {
                // BLACK pawn moves
                if (rowDistance == -2) {
                    // Checks if the pawn is at initial location and squares in front are empty
                    if (initialLocation) {

                        //pawn is moving twice, check two squares in front are empty
                        Square[] between = location.getBoard().getSquaresBetween(location,targetLocation);

                        validMove = targetLocation.isEmpty() && between.length > 0 && between[0].isEmpty();
                    }
                } else {
                    validMove = targetLocation.isEmpty();
                }
            }


            // Attacks diagonals
        } else if (this.location.isNeighborColumn(targetLocation)) {
            // WHİTE pawn attacks
            if (color == ChessBoard.WHITE && rowDistance == 1) {
                validMove = !targetLocation.isEmpty() && targetLocation.getPiece().getColor() == ChessBoard.BLACK;
                // BLACK pawn attacks
            } else if (color == ChessBoard.BLACK && rowDistance == -1) {
                validMove = !targetLocation.isEmpty() && targetLocation.getPiece().getColor() == ChessBoard.WHITE;
            }

        }

        return validMove;
    }


    @Override
    public void move(String to) {

        Square targetLocation = location.getBoard().getSquareAt(to);
        // if the pawn reaches the last row , promoto to queen
        if (targetLocation.isAtLastRow(color)) {
            targetLocation.putNewQueen(color);
        } else {
            targetLocation.setPiece(this);
        }
        // Clears the previous location
        location.clear();
        //  Uppdates the current location
        location = targetLocation;
        initialLocation = false;
    }


    @Override
    public String toString() {
        return color == ChessBoard.WHITE ? "P" : "p";
    }
}
