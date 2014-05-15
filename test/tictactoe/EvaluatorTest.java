package kerstein.tictactoe;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class EvaluatorTest {

	@Test
	public void testTopRow() {
		TicTacToeBoard tic = new TicTacToeBoard();
		tic.setSquare(new Location(0, 0), Symbol.O);
		tic.setSquare(new Location(0, 1), Symbol.O);
		tic.setSquare(new Location(0, 2), Symbol.O);
		Evaluator eval = new Evaluator(tic);
		eval.evaluate();
		Symbol winner = eval.getWinner();
		Assert.assertEquals(Symbol.O, winner);
	}

	@Test
	public void testMiddleRow() {
		TicTacToeBoard tic = new TicTacToeBoard();
		tic.setSquare(new Location(1, 0), Symbol.O);
		tic.setSquare(new Location(1, 1), Symbol.O);
		tic.setSquare(new Location(1, 2), Symbol.O);
		Evaluator eval = new Evaluator(tic);
		eval.evaluate();
		Symbol winner = eval.getWinner();
		Assert.assertEquals(Symbol.O, winner);
	}

	@Test
	public void testBottomRow() {
		TicTacToeBoard tic = new TicTacToeBoard();
		tic.setSquare(new Location(2, 0), Symbol.O);
		tic.setSquare(new Location(2, 1), Symbol.O);
		tic.setSquare(new Location(2, 2), Symbol.O);
		Evaluator eval = new Evaluator(tic);
		eval.evaluate();
		Symbol winner = eval.getWinner();
		Assert.assertEquals(Symbol.O, winner);
	}

	@Test
	public void testDiagonalUp() {
		TicTacToeBoard tic = new TicTacToeBoard();
		tic.setSquare(new Location(2, 0), Symbol.O);
		tic.setSquare(new Location(1, 1), Symbol.O);
		tic.setSquare(new Location(0, 2), Symbol.O);
		Evaluator eval = new Evaluator(tic);
		eval.evaluate();
		Symbol winner = eval.getWinner();
		Assert.assertEquals(Symbol.O, winner);
	}

	@Test
	public void testDiagonalDown() {
		TicTacToeBoard tic = new TicTacToeBoard();
		tic.setSquare(new Location(0, 0), Symbol.O);
		tic.setSquare(new Location(1, 1), Symbol.O);
		tic.setSquare(new Location(2, 2), Symbol.O);
		Evaluator eval = new Evaluator(tic);
		eval.evaluate();
		Symbol winner = eval.getWinner();
		Assert.assertEquals(Symbol.O, winner);
	}

	@Test
	public void testFirstColumn() {
		TicTacToeBoard tic = new TicTacToeBoard();
		tic.setSquare(new Location(0, 0), Symbol.O);
		tic.setSquare(new Location(1, 1), Symbol.O);
		tic.setSquare(new Location(2, 2), Symbol.O);
		Evaluator eval = new Evaluator(tic);
		eval.evaluate();
		Symbol winner = eval.getWinner();
		Assert.assertEquals(Symbol.O, winner);
	}

	@Test
	public void testMiddleColumn() {
		TicTacToeBoard tic = new TicTacToeBoard();
		tic.setSquare(new Location(0, 1), Symbol.O);
		tic.setSquare(new Location(1, 1), Symbol.O);
		tic.setSquare(new Location(2, 1), Symbol.O);
		Evaluator eval = new Evaluator(tic);
		eval.evaluate();
		Symbol winner = eval.getWinner();
		Assert.assertEquals(Symbol.O, winner);
	}

	@Test
	public void testThirdColumn() {
		TicTacToeBoard tic = new TicTacToeBoard();
		tic.setSquare(new Location(0, 2), Symbol.O);
		tic.setSquare(new Location(1, 2), Symbol.O);
		tic.setSquare(new Location(2, 2), Symbol.O);
		Evaluator eval = new Evaluator(tic);
		eval.evaluate();
		Symbol winner = eval.getWinner();
		Assert.assertEquals(Symbol.O, winner);

	}

	@Test
	public void testNoWinnerEmptyBoard() {
		TicTacToeBoard tic = new TicTacToeBoard();
		Evaluator eval = new Evaluator(tic);
		eval.evaluate();
		Symbol winner = eval.getWinner();
		Assert.assertEquals(null, winner);
	}

	@Test
	public void testNoWinnerFullBoard() {
		TicTacToeBoard tic = new TicTacToeBoard();
		tic.setSquare(new Location(0, 0), Symbol.X);
		tic.setSquare(new Location(0, 1), Symbol.O);
		tic.setSquare(new Location(0, 2), Symbol.X);
		tic.setSquare(new Location(1, 0), Symbol.O);
		tic.setSquare(new Location(1, 1), Symbol.X);
		tic.setSquare(new Location(1, 2), Symbol.O);
		tic.setSquare(new Location(2, 0), Symbol.O);
		tic.setSquare(new Location(2, 1), Symbol.X);
		tic.setSquare(new Location(2, 2), Symbol.O);
		Evaluator eval = new Evaluator(tic);
		eval.evaluate();
		Symbol winner = eval.getWinner();
		Assert.assertEquals(null, winner);
	}

	@Test
	public void testGetWinningSquares() {
		TicTacToeBoard tic = new TicTacToeBoard();
		tic.setSquare(new Location(0, 0), Symbol.O);
		tic.setSquare(new Location(1, 1), Symbol.O);
		tic.setSquare(new Location(2, 2), Symbol.O);
		Evaluator eval = new Evaluator(tic);
		eval.evaluate();
		List<Location> winningSquares = eval.getWinningSquares();
		List<Location> squares = new ArrayList<Location>();
		squares.add(new Location(0, 0));
		squares.add(new Location(1, 1));
		squares.add(new Location(2, 2));
		StringBuilder wins = new StringBuilder();
		StringBuilder expected = new StringBuilder();
		for (int i = 0; i < squares.size(); i++) {
			wins.append(winningSquares.get(i).getX()
					+ winningSquares.get(i).getY());
			expected.append(squares.get(i).getX() + squares.get(i).getY());
		}
		Assert.assertEquals(wins.toString(), expected.toString());

	}

	@Test
	public void testGetWinningSquaresEmptyBoard() {
		TicTacToeBoard tic = new TicTacToeBoard();
		Evaluator eval = new Evaluator(tic);
		eval.evaluate();
		Assert.assertEquals(null, eval.getWinningSquares());
	}

	@Test
	public void testGetWinningSquaresFullBoardNoWinner() {
		TicTacToeBoard tic = new TicTacToeBoard();
		tic.setSquare(new Location(0, 0), Symbol.X);
		tic.setSquare(new Location(0, 1), Symbol.O);
		tic.setSquare(new Location(0, 2), Symbol.X);
		tic.setSquare(new Location(1, 0), Symbol.O);
		tic.setSquare(new Location(1, 1), Symbol.X);
		tic.setSquare(new Location(1, 2), Symbol.O);
		tic.setSquare(new Location(2, 0), Symbol.O);
		tic.setSquare(new Location(2, 1), Symbol.X);
		tic.setSquare(new Location(2, 2), Symbol.O);
		Evaluator eval = new Evaluator(tic);
		eval.evaluate();
		Assert.assertEquals(null, eval.getWinningSquares());

	}
}
