package kerstein.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Evaluator {
	private TicTacToeBoard aBoard;
	private Symbol winner;
	private ArrayList<Location> winningSquares;

	public Evaluator(TicTacToeBoard board) {
		this.aBoard = board;
		winner = null;
		winningSquares = new ArrayList<Location>();

	}

	public void evaluate() {
		if (aBoard.getSquare(new Location(0, 0)) != null
				&& aBoard.getSquare(new Location(0, 0)) == aBoard
						.getSquare(new Location(1, 1))
				&& aBoard.getSquare(new Location(1, 1)) == aBoard
						.getSquare(new Location(2, 2))) {
			winningSquares.add(new Location(0, 0));
			winningSquares.add(new Location(1, 1));
			winningSquares.add(new Location(2, 2));
			winner = aBoard.getSquare(new Location(0, 0));
		} else if (aBoard.getSquare(new Location(0, 0)) != null
				&& aBoard.getSquare(new Location(0, 0)) == aBoard
						.getSquare(new Location(1, 0))
				&& aBoard.getSquare(new Location(1, 0)) == aBoard
						.getSquare(new Location(2, 0))) {
			winningSquares.add(new Location(0, 0));
			winningSquares.add(new Location(1, 0));
			winningSquares.add(new Location(2, 0));
			winner = aBoard.getSquare(new Location(0, 0));
		} else if (aBoard.getSquare(new Location(0, 0)) != null
				&& aBoard.getSquare(new Location(0, 0)) == aBoard
						.getSquare(new Location(0, 1))
				&& aBoard.getSquare(new Location(0, 1)) == aBoard
						.getSquare(new Location(0, 2))) {
			winningSquares.add(new Location(0, 0));
			winningSquares.add(new Location(0, 1));
			winningSquares.add(new Location(0, 2));
			winner = aBoard.getSquare(new Location(0, 0));
		} else if (aBoard.getSquare(new Location(0, 1)) != null
				&& aBoard.getSquare(new Location(0, 1)) == aBoard
						.getSquare(new Location(1, 1))
				&& aBoard.getSquare(new Location(1, 1)) == aBoard
						.getSquare(new Location(2, 1))) {
			winningSquares.add(new Location(0, 1));
			winningSquares.add(new Location(1, 1));
			winningSquares.add(new Location(2, 1));
			winner = aBoard.getSquare(new Location(0, 1));
		} else if (aBoard.getSquare(new Location(0, 2)) != null
				&& aBoard.getSquare(new Location(0, 2)) == aBoard
						.getSquare(new Location(1, 1))
				&& aBoard.getSquare(new Location(1, 1)) == aBoard
						.getSquare(new Location(2, 0))) {
			winningSquares.add(new Location(0, 2));
			winningSquares.add(new Location(1, 1));
			winningSquares.add(new Location(2, 0));
			winner = aBoard.getSquare(new Location(0, 2));
		} else if (aBoard.getSquare(new Location(0, 2)) != null
				&& aBoard.getSquare(new Location(0, 2)) == aBoard
						.getSquare(new Location(1, 2))
				&& aBoard.getSquare(new Location(1, 2)) == aBoard
						.getSquare(new Location(2, 2))) {
			winningSquares.add(new Location(0, 2));
			winningSquares.add(new Location(1, 2));
			winningSquares.add(new Location(2, 2));
			winner = aBoard.getSquare(new Location(0, 2));
		} else if (aBoard.getSquare(new Location(2, 0)) != null
				&& aBoard.getSquare(new Location(2, 0)) == aBoard
						.getSquare(new Location(2, 1))
				&& aBoard.getSquare(new Location(2, 1)) == aBoard
						.getSquare(new Location(2, 2))) {
			winningSquares.add(new Location(2, 0));
			winningSquares.add(new Location(2, 1));
			winningSquares.add(new Location(2, 2));
			winner = aBoard.getSquare(new Location(2, 0));
		} else if (aBoard.getSquare(new Location(1, 0)) != null
				&& aBoard.getSquare(new Location(1, 0)) == aBoard
						.getSquare(new Location(1, 1))
				&& aBoard.getSquare(new Location(1, 1)) == aBoard
						.getSquare(new Location(1, 2))) {
			winningSquares.add(new Location(1, 0));
			winningSquares.add(new Location(1, 1));
			winningSquares.add(new Location(1, 2));
			winner = aBoard.getSquare(new Location(1, 0));
		} else {
			winner = null;
		}
	}

	public Symbol getWinner() {
		return winner;

	}

	public List<Location> getWinningSquares() {
		if (getWinner() == null) {
			return null;
		}
		return winningSquares;

	}

}
