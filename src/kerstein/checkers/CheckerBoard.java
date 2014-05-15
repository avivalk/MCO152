package kerstein.checkers;

import java.util.ArrayList;
import java.util.List;

/**
 * This implementation of a game of Checkers should match
 * http://simple.wikipedia.org/wiki/Checkers
 * 
 * How to play Checkers: https://www.youtube.com/watch?v=SuQY1_fCVsA
 */
public class CheckerBoard {

	public static final int WIDTH = 8;
	public static final int HEIGHT = 8;
	private final Piece[][] board;

	public CheckerBoard() {
		this.board = new Piece[HEIGHT][WIDTH];
	}

	public Piece getPiece(final int x, final int y) {
		return board[y][x];
	}

	public void setPiece(final int x, final int y, final Piece piece) {
		board[y][x] = piece;
	}

	public void removePiece(final int x, final int y) {
		setPiece(x, y, null);
	}

	/**
	 * Returns true if the x,y coordinate is within the 8x8 board, otherwise
	 * false
	 */
	public boolean isOnBoard(final int x, final int y) {
		return x < 8 && y < 8 && x > 0 && y > 0;
	}

	/**
	 * Returns true if the square is null, otherwise false
	 */
	public boolean isEmptySquare(final int x, final int y) {
		return getPiece(x, y) == null;
	}

	/**
	 * Removes all pieces from the board
	 */
	public void clear() {
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				removePiece(i, j);
			}
		}
	}

	/**
	 * Sets the board to a starting configuration
	 */
	public void resetNewGame() {
		for (int x = 1; x < WIDTH; x += 2) {
			setPiece(0, x, Piece.WHITE_MAN);
		}
		for (int x = 1; x < WIDTH; x += 2) {
			setPiece(2, x, Piece.WHITE_MAN);
		}
		for (int x = 0; x < WIDTH; x += 2) {
			setPiece(1, x, Piece.WHITE_MAN);
		}

		for (int j = 0; j < WIDTH; j += 2) {
			setPiece(5, j, Piece.RED_MAN);
		}
		for (int j = 0; j < WIDTH; j += 2) {
			setPiece(7, j, Piece.RED_MAN);
		}
		for (int j = 1; j < WIDTH; j += 2) {
			setPiece(6, j, Piece.RED_MAN);
		}
	}

	@Override
	/**
	 * Returns a String representation of the board. Each row of the board should be on it's own line.
	 * A dash "-" represents an empty square. Pieces should be displayed using the .toString() method
	 * of the piece class.
	 */
	public String toString() {
		StringBuilder board = new StringBuilder();
		for (int x = 0; x < HEIGHT; x++) {
			for (int y = 0; y < WIDTH; y++) {
				if (getPiece(x, y) == null) {
					board.append("-");
				} else {
					board.append(getPiece(x, y).toString());
				}

			}
			board.append("\n");
		}
		return board.toString();
	}

	/**
	 * Do the Move, removing the piece from x1, y1 and setting the piece in x2,
	 * y2. If the piece is now on their "King's Row", then promote the piece
	 * should be promoted to a King
	 */
	public void execute(final Move move) {
		Piece piece = getPiece(move.getX1(), move.getY1());
		removePiece(move.getX1(), move.getY1());
		if (move.getY2() == 0 || move.getY2() == 7) {
			if (piece.equals(Piece.RED_MAN)) {
				setPiece(move.getX2(), move.getY2(), Piece.RED_KING);
			} else if (piece.equals(Piece.WHITE_MAN)) {
				setPiece(move.getX2(), move.getY2(), Piece.WHITE_KING);
			}
		} else {
			if (piece.equals(Piece.RED_MAN)) {
				setPiece(move.getX2(), move.getY2(), Piece.RED_MAN);
			} else if (piece.equals(Piece.WHITE_MAN)) {
				setPiece(move.getX2(), move.getY2(), Piece.WHITE_MAN);
			}
		}
	}

	/**
	 * Do the Jump, removing the piece from x1, y1 and setting the piece in x2,
	 * y2. Remove the piece from captureX, captureY as well. If the piece is now
	 * on their "King's Row", then promote the piece should be promoted to a
	 * King
	 */
	public void execute(final Jump jump) {
		Piece piece = getPiece(jump.getX1(), jump.getY1());
		removePiece(jump.getX1(), jump.getY1());
		removePiece(jump.getCaptureX(), jump.getCaptureY());
		if (jump.getY2() == 0 || jump.getY2() == 7) {
			if (piece.equals(Piece.RED_MAN)) {
				setPiece(jump.getX2(), jump.getY2(), Piece.RED_KING);
			} else if (piece.equals(Piece.WHITE_MAN)) {
				setPiece(jump.getX2(), jump.getY2(), Piece.WHITE_KING);
			}
		} else {
			if (piece.equals(Piece.RED_MAN)) {
				setPiece(jump.getX2(), jump.getY2(), Piece.RED_MAN);
			} else if (piece.equals(Piece.WHITE_MAN)) {
				setPiece(jump.getX2(), jump.getY2(), Piece.WHITE_MAN);
			}
		}
	}

	/**
	 * Returns a list of all possible moves from the piece at (x,y). If there is
	 * no piece on that square, or the piece cannot make a legal move then
	 * return an empty list
	 */
	public List<Move> getMoves(final int x, final int y) {
		List<Move> moves = new ArrayList<Move>();
		if (getPiece(x, y) != null) {
			if (getPiece(x, y) == Piece.WHITE_MAN) {
				if (isEmptySquare(x + 1, y + 1) && isOnBoard(x + 1, y + 1)) {
					moves.add(new Move(x, y, x + 1, y + 1));
				}
				if (isEmptySquare(x + 1, y - 1) && isOnBoard(x + 1, y - 1)) {
					moves.add(new Move(x, y, x - 1, y + 1));
				}
			} else if (getPiece(x, y) == Piece.RED_MAN) {
				if (isEmptySquare(x - 1, y - 1) && isOnBoard(x - 1, y - 1)) {
					moves.add(new Move(x, y, x - 1, y - 1));
				}
				if (isEmptySquare(x - 1, y + 1) && isOnBoard(x + 1, y - 1)) {
					moves.add(new Move(x, y, x + 1, y - 1));
				}
			} else if (getPiece(x, y).isKing()) {
				if (isOnBoard(x + 1, y + 1) && isEmptySquare(x + 1, y + 1)) {
					moves.add(new Move(x, y, x + 1, y + 1));
				}
				if (isOnBoard(x + 1, y - 1) && isEmptySquare(x + 1, y - 1)) {
					moves.add(new Move(x, y, x + 1, y - 1));
				}
				if (isOnBoard(x - 1, y - 1) && isEmptySquare(x - 1, y - 1)) {
					moves.add(new Move(x, y, x - 1, y - 1));
				}
				if (isOnBoard(x - 1, y + 1) && isEmptySquare(x - 1, y + 1)) {
					moves.add(new Move(x, y, x - 1, y + 1));
				}
			}
		}
		return moves;
	}

	/**
	 * Returns a list of all possible jumps from the piece at (x,y). If there is
	 * no piece on that square, or the piece cannot make a legal jump then
	 * return an empty list
	 */
	public List<Jump> getJumps(final int x, final int y) {
		List<Jump> jumps = new ArrayList<Jump>();
		if (getPiece(x, y) != null) {
			if (getPiece(x, y) == Piece.WHITE_MAN) {
				if (isEmptySquare(x + 2, y + 2) && isOnBoard(x + 2, y + 2)
						&& isOnBoard(x + 1, y + 1)
						&& !isEmptySquare(x + 1, y + 1)) {
					jumps.add(new Jump(x, y, x + 1, y + 1, x + 2, y + 2));
				}
				if (isEmptySquare(x + 2, y - 2) && isOnBoard(x + 2, y - 2)
						&& isOnBoard(x + 1, y - 1)
						&& isEmptySquare(x + 1, y - 1) == false) {
					jumps.add(new Jump(x, y, x + 1, y - 1, x + 2, y - 2));
				}
			} else if (getPiece(x, y) == Piece.RED_MAN) {
				if (isOnBoard(x + 2, y - 2) && isEmptySquare(x + 2, y - 2)
						&& isOnBoard(x - 1, y - 1)
						&& !isEmptySquare(x - 1, y - 1)) {
					jumps.add(new Jump(x, y, x - 1, y - 1, x + 2, y - 2));
				}
				if (isOnBoard(x + 2, y - 2) && isEmptySquare(x + 2, y - 2)
						&& isOnBoard(x + 1, y - 1)
						&& !isEmptySquare(x + 1, y - 1)) {
					jumps.add(new Jump(x, y, x + 1, y - 1, x + 2, y - 2));
				}
			} else if (getPiece(x, y).isKing()) {
				if (isEmptySquare(x + 2, y + 2) && isOnBoard(x + 2, y + 2)
						&& isOnBoard(x + 1, y + 1)
						&& !isEmptySquare(x + 1, y + 1)) {
					jumps.add(new Jump(x, y, x + 1, y + 1, x + 2, y + 2));
				}
				if (isEmptySquare(x + 2, y - 2) && isOnBoard(x + 2, y - 2)
						&& isOnBoard(x + 1, y - 1)
						&& !isEmptySquare(x + 1, y - 1)) {
					jumps.add(new Jump(x, y, x + 1, y - 1, x + 2, y - 2));
				}
				if (isEmptySquare(x - 2, y - 2) && isOnBoard(x - 2, y - 2)
						&& isOnBoard(x - 1, y - 1)
						&& !isEmptySquare(x - 1, y - 1)) {
					jumps.add(new Jump(x, y, x - 1, y - 1, x - 2, y - 2));
				}
				if (isEmptySquare(x - 2, y + 2) && isOnBoard(x - 1, y + 1)
						&& isOnBoard(x - 1, y + 1)
						&& !isEmptySquare(x - 1, y + 1)) {
					jumps.add(new Jump(x, y, x - 1, y + 1, x - 2, y + 2));
				}
			}
		}
		return jumps;

	}

}
