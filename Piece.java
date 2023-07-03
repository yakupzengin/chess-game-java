public abstract class Piece {
    protected int color;
    protected Square location;

    /**
     * Constructs a new Piece object with the specified color and location.
     *
     * Parameter :  color : the color of the piece
     * Parameter :  location : the initial location of the piece on the chessboard
     */
    public Piece(int color, Square location) {
        this.color = color;
        this.location = location;
    }

    //  Returns the color of the piece.
    public int getColor() {
        return color;
    }

    /**
     * Checks if the piece can move to the specified destination.
     *
     * Parameter:  destination : the destination square in algebraic notation ( "f6", "h7")
     */
    public abstract boolean canMove(String destination);

    public void move(String destination) {
        // Convert the destination string to row and column indices
        int col = destination.charAt(0) - 'a';
        int row =  (destination.charAt(1) - '0') -1;

        Square targetLocation = location.getBoard().getSquareAt(row, col);
        // Move the piece to the target location
        targetLocation.setPiece(this);
        location.setPiece(null);
        location = targetLocation;
    }
    // Returns the chess board where the piece is located
    public ChessBoard getBoard() {
        return location.getBoard();
    }
    // Returns the current location of the piece on the chess board
    public Square getLocation() {
        return location;
    }
}
