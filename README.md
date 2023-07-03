## Chess Game ♟️
ChessGame is a Java-based command-line chess program that lets you experience the thrill of chess in a simplified form. The program is composed of various classes that represent the chessboard, pieces, and game logic.

## 🎮 How to Play
Fire up the program in your command-line interface.
The initial chessboard will be displayed, showcasing the positions of the pieces.
The program will indicate whose turn it is (White or Black).
Enter the location of the piece you want to move, following the real-life chessboard coordinates (e.g., A1, E5).
Enter the new location where you want to move the piece.
The program will validate the move and update the chessboard accordingly.
The turn will switch to the other player, and the process repeats.
If an invalid move is entered, an error message will be displayed, and you can retry the move.
## ♜ Features
🏁 Endgame control: The game will conclude when no pieces remain for one color.

👑 Promotion: Pawns will be automatically promoted to Queens when they reach the last row.

🐎 Basic movement rules for all pieces: The game allows legal moves for each piece type (excluding complex rules like checkmate, en passant, and absolute pin).

## 💻 Board Representation
The chessboard is represented in the command-line interface as a grid of squares. Each square can contain a piece, represented by specific symbols:

♙ P for White Pawn ♜ R for White Rook ♞ N for White Knight ♝ B for White Bishop ♛ Q for White Queen ♚ K for White King For Black pieces, the symbols are represented in lowercase.

## Example Execution
 A   B   C   D   E   F   G   H
 ---------------------------------
8 | r | n | b | q | k | b | n | r | 8
 ---------------------------------
7 | p | p | p | p | p | p | p | p | 7
 ---------------------------------
6 |   |   |   |   |   |   |   |   | 6
 ---------------------------------
5 |   |   |   |   |   |   |   |   | 5
 ---------------------------------
4 |   |   |   |   |   |   |   |   | 4
 ---------------------------------
3 |   |   |   |   |   |   |   |   | 3
 ---------------------------------
2 | P | P | P | P | P | P | P | P | 2
 ---------------------------------
1 | R | N | B | Q | K | B | N | R | 1
 ---------------------------------
    A   B   C   D   E   F   G   H

It is White's turn
Enter the location of the piece:
