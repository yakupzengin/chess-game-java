import java.util.ArrayList;
import java.util.List;

public class ChessBoard  {
    public static final int WHITE = 0;
    public static final int BLACK = 1;
    private Square[][] board;
    private boolean whitePlaying = true;

    public ChessBoard() {
        board = new Square[8][8];
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = new Square(this, row, col);
            }
        }
    }


        // Initialize the board with chess pieces
    public void initialize() {
        // Place WHITE pieces with the start point
        board[0][0].setPiece(new Rook(WHITE, board[0][0]));
        board[0][1].setPiece(new Knight(WHITE, board[0][1]));
        board[0][2].setPiece(new Bishop(WHITE, board[0][2]));
        board[0][3].setPiece(new Queen(WHITE, board[0][3]));
        board[0][4].setPiece(new King(WHITE, board[0][4]));
        board[0][5].setPiece(new Bishop(WHITE, board[0][5]));
        board[0][6].setPiece(new Knight(WHITE, board[0][6]));
        board[0][7].setPiece(new Rook(WHITE, board[0][7]));
        for (int col = 0; col < 8; col++) {
            board[1][col].setPiece(new Pawn(WHITE, board[1][col]));
        }

        // Place BLACK pieces with the start point
        board[7][0].setPiece(new Rook(BLACK, board[7][0]));
        board[7][1].setPiece(new Knight(BLACK, board[7][1]));
        board[7][2].setPiece(new Bishop(BLACK, board[7][2]));
        board[7][3].setPiece(new Queen(BLACK, board[7][3]));
        board[7][4].setPiece(new King(BLACK, board[7][4]));
        board[7][5].setPiece(new Bishop(BLACK, board[7][5]));
        board[7][6].setPiece(new Knight(BLACK, board[7][6]));
        board[7][7].setPiece(new Rook(BLACK, board[7][7]));
        for (int col = 0; col < 8; col++) {
            board[6][col].setPiece(new Pawn(BLACK, board[6][col]));
        }
    }
    // Prints the current version of the chessboard
    public void printBoard() {
        System.out.println(this);
    }

    // Checks if the game is ended.
    public boolean isGameEnded() {
        boolean whiteHasPieces = false;
        boolean blackHasPieces = false;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col].getPiece();
                if (piece != null) {
                    if (piece.getColor() == WHITE) {
                        whiteHasPieces = true;
                    } else {
                        blackHasPieces = true;
                    }
                }
            }
        }

        if (!whiteHasPieces) {
            System.out.println(" * Game is ended ! * \n The BLACK player won the game.");
            return true;
        } else if (!blackHasPieces) {
            System.out.println(" * Game is ended ! * \n The WHİTE player won the game.");
            return true;
        }

        return false;
    }


    // Checks if it is the white player's turn.

    public boolean isWhitePlaying() {
        return whitePlaying;
    }

    /*
     *  Retrieves the piece at the specified location
     *  The parameter type is string
     *  Returns the chess piece at the specified position
     */
    public Piece getPieceAt(String from) {
        // Convert the location string to row and column indices
        int col = from.charAt(0) - 'a';
        int row =  (from.charAt(1) - '0') -1;
        return board[row][col].getPiece();
    }

    /*
    *   Get the square at the specified row and column.
    *   Takes row and column index as parameters
    *   Returns the square at the specified row and column
     */
    public Square getSquareAt(int row, int col) {
        return board[row][col];
    }

    /*
    *   Get the square at the given position in algebraic notation.
    *   The parameter type is string
    *   Returns The square at the specified position
     */
    public Square getSquareAt(String location) {
        int col = location.charAt(0) - 'a';
        int row =  (location.charAt(1) - '0')-1;
        return getSquareAt(row, col);
    }

    public Square getSquareAt(char column, int row) {
        return board[row - 1][column - 'a'];
    }

    //Returns the string representation of the chessboard

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("    A   B   C   D   E   F   G   H\n");
        sb.append(" ---------------------------------\n");
        for (int row = 7; row >= 0; row--) {
            sb.append((row + 1) + " |");
            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col].getPiece();
                if (piece == null) {
                    sb.append("  ");
                } else {
                    sb.append(" "+piece);
                }
                sb.append(" |");
            }
            sb.append(" " + ( row + 1) + "\n");
            sb.append(" ---------------------------------\n");
        }
        sb.append("    A   B   C   D   E   F   G   H\n");
        return sb.toString();
    }



     // Switches the turn to the next player.

    public void nextPlayer() {
        whitePlaying = !whitePlaying;
    }


    /*
    *   Gets the squares between two locations on the board.
    *   Returns an array of squares that are the located between the specified location and the target location
    *   Takes 2 parameters.
    *   1-  location is the starting location
    *   2-  targetLocation is the target location
     */
    public Square[] getSquaresBetween(Square location, Square targetLocation) {
        List<Square> squares = new ArrayList<>();
        int columnDistance = targetLocation.getColDistance(location);
        int rowDistance = targetLocation.getRowDistance(location);

        if (location.isAtSameColumn(targetLocation)) {
            int startRow = Math.min(location.getRow(), targetLocation.getRow()) + 1;
            int endRow = Math.max(location.getRow(), targetLocation.getRow());
            for (int row = startRow; row < endRow; row++) {
                squares.add(getSquareAt(location.getColumn(), row + 1));
            }
        } else if (location.isAtSameRow(targetLocation)) {
            char startColumn = (char) (Math.min(location.getColumn(), targetLocation.getColumn()) + 1);
            char endColumn = (char) Math.max(location.getColumn(), targetLocation.getColumn());
            for (char column = (char) (startColumn + 1); column < endColumn; column++) {
                squares.add(getSquareAt(column, location.getRow() + 1));
            }
        } else if (Math.abs(columnDistance) == Math.abs(rowDistance)) {
            int columnStep = columnDistance / Math.abs(columnDistance);
            int rowStep = rowDistance / Math.abs(rowDistance);
            int steps = Math.abs(columnDistance);

            for (int i = 1; i < steps; i++) {
                char column = (char) (location.getColumn() + i * columnStep);
                int row = location.getRow() + i * rowStep;
                squares.add(getSquareAt(column, row + 1));
            }
        }
        return squares.toArray(new Square[0]);
    }
}
