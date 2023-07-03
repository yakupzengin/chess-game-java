import java.util.Scanner;

public class Main {

    public static void main(String[]  args)  {
        // Creates a new Scanner object
        Scanner reader = new Scanner(System.in);

        // Creates a new ChessBoard object
        ChessBoard board = new ChessBoard();

        // Initializes the chess board
        board.initialize();

        // Game continues playing until the game ends
        while (!board.isGameEnded()) {
            // Prints the game board
            board.printBoard();
            System.out.println("It is " + (board.isWhitePlaying() ? "White" : "Black") + "'s turn");
            Piece piece = null;
            boolean hasValidMove = false;
            do {
                System.out.print("Enter the location of the piece:");
                String from = reader.next();

                // Verifies the input for the location of the piece.
                if (from.length() != 2 || from.charAt(0) < 'a' || from.charAt(0) > 'h' || from.charAt(1) < '1' || from.charAt(1) > '8') {
                    continue;
                }

                //  Gets the piece at the specified location
                piece = board.getPieceAt(from);
                if (piece != null && piece.getColor() == (board.isWhitePlaying() ? ChessBoard.WHITE : ChessBoard.BLACK)) {

                    // Check if the piece has any valid moves
                    for (int row = 0; row < 8; row++) {
                        for (int col = 0; col < 8; col++) {
                            String to = "" + (char) ('a' + col) + (row + 1);
                            if (piece.canMove(to)) {
                                hasValidMove = true;
                                break;
                            }
                        }
                        if (hasValidMove) {
                            break;
                        }
                    }
                }
            } while (piece == null || !hasValidMove);

            String to = null;
            do {
                System.out.print("Enter the new location of the piece:");
                to = reader.next();

                // Verifies the input for the location of the piece.
                if (to.length() != 2 || to.charAt(0) < 'a' || to.charAt(0) > 'h' || to.charAt(1) < '1' || to.charAt(1) > '8') {
                    continue;
                }

            } while (!piece.canMove(to));

            // Moves the piece to the location
            piece.move(to);

            // Switches the turn to the next player
            board.nextPlayer();
        }

        // Closes the Scanner object
        reader.close();

    }
}