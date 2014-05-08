package kerstein.tictactoe;

public class TicTacToeBoard {
	private Symbol[][] board;
	private static final int ROWS = 3;
	private static final int COLUMNS = 3;

	public TicTacToeBoard() {
		this.board = new Symbol[ROWS][COLUMNS];

	}

	public void reset() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				board[i][j] = null;
			}
		}
	}

	public boolean isFull() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				if (board[i][j] == null) {
					return false;
				}
			}
		}
		return true;
	}

	public void setSquare(Location loc, Symbol sym) {
		board[loc.getX()][loc.getY()] = sym;
	}

	public Symbol getSquare(Location loc) {
		return board[loc.getX()][loc.getY()];
	}
}
