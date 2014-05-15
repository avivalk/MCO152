package kerstein.morseCode;

import org.junit.Assert;
import org.junit.Test;

public class MorseCodeTest {

	@Test
	public void testAlphabetToMorse() {
		MorseCode morseCode = new MorseCode();
		String alphabet = "three blind mice";
		String code = morseCode.toMorseCode(alphabet);
		String expected = "- .... .-. . . / -... .-.. .. -. -.. / -- .. -.-. .";

		Assert.assertEquals(expected, code);
	}

	@Test
	public void testMorseToAlphabet() {
		MorseCode morseCode = new MorseCode();
		String code = "- .... .-. . . / -... .-.. .. -. -.. / -- .. -.-. .";
		String alphabet = morseCode.toPlainText(code);
		String expected = "THREE BLIND MICE";

		Assert.assertEquals(expected, alphabet);
	}
}
