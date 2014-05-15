package kerstein.tictactoe;

import org.junit.Assert;
import org.junit.Test;

public class TicTacToeBoardTest {

	@Test
	public void testNotFull() {
		TicTacToeBoard board = new TicTacToeBoard();
		boolean full = board.isFull();
		Assert.assertFalse(full);

	}

	@Test
	public void testIsFull() {
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
		boolean full = tic.isFull();
		Assert.assertTrue(full);
	}

	@Test
	public void testSetSquare() {
		TicTacToeBoard board = new TicTacToeBoard();
		Location loc = new Location(1, 1);
		board.setSquare(loc, Symbol.X);
		Symbol sym = board.getSquare(loc);
		Assert.assertEquals(Symbol.X, sym);
	}

}
