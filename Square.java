import java.util.ArrayList;
import java.util.List;

public class Square {
    private int column;
    private int row;
    private Piece piece;
    private ChessBoard board;

    /*
    *   Constructs a Square  object with the specified row, column, and associated ChessBoard
    *   Takes 3 parameters: ChessBoard object, row index and column index
     */
    public Square(ChessBoard board, int row, int column) {
        this.board = board;
        this.row = row;
        this.column = column;
    }

    // Returns the row index.
    public int getRow(){
        return row;
    }
    // Returns the column index as a char

    public char getColumn(){
        return (char) ('a' + column);
    }

    // Checks if the Square is empty
    public boolean isEmpty() {
        return piece == null;
    }
    // Returns the Piece on the Square
    public Piece getPiece() {
        return piece;
    }

    // Sets the Piece on the Square
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    //  Checks whether the Square is on the same row  as the Square specified as a parameter
    public boolean isAtSameRow(Square other) {
        return this.row == other.row;
    }
    // Checks whether the Square is on the same column as the Square specified as a parameter
    public boolean isAtSameColumn(Square s) {
        return this.column == s.column;
    }

    // Returns the chessboard associated with the square
    public ChessBoard getBoard() {
        return board;
    }

    //  Calculates the row distance between the current Square and the specified Square
    public int getRowDistance(Square location) {
        return (this.row - location.row);
    }
    //   Calculates the column distance between the current Square and the specified Square.
    public int getColDistance(Square location){
        return (this.column-location.column);
    }

    /*
    * Checks if the Square is a neighboring column of the specified Square
    * Paramaters ( targetLocation ) is the other Square to check
    *
     */
    public boolean isNeighborColumn(Square targetLocation) {
        return Math.abs(this.column - targetLocation.column) == 1;
    }

    /*
    * Checks if the Square is at the last row for the specified color
     */
    public boolean isAtLastRow(int color) {
        if (color == ChessBoard.WHITE) {
            return row == 7;
        } else {
            return row == 0;
        }
    }

    /*
    *   Puts a new queen on the square (instead of pawn) for the given color
    *   Parameter is the color of the pawn and queen
     */
    public void putNewQueen(int color) {
        setPiece(new Queen(color, this));
    }


    // Clears the square by removing the piece from it
    public void clear() {
        piece = null;
    }

}
