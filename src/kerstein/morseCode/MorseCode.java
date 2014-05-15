package kerstein.morseCode;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MorseCode {
	private Map<String, String> morse;

	public MorseCode() {
		morse = new HashMap<String, String>();
		morse.put("A", ".- ");
		morse.put("B", "-... ");
		morse.put("C", "-.-. ");
		morse.put("D", "-.. ");
		morse.put("E", ". ");
		morse.put("F", "..-. ");
		morse.put("G", "--. ");
		morse.put("H", ".... ");
		morse.put("I", ".. ");
		morse.put("J", ".--- ");
		morse.put("K", "-.- ");
		morse.put("L", ".-.. ");
		morse.put("M", "-- ");
		morse.put("N", "-. ");
		morse.put("O", "--- ");
		morse.put("P", ".--. ");
		morse.put("Q", "--.- ");
		morse.put("R", ".-. ");
		morse.put("S", "... ");
		morse.put("T", "- ");
		morse.put("U", "..- ");
		morse.put("V", "...- ");
		morse.put("W", ".-- ");
		morse.put("X", "-..- ");
		morse.put("Y", "-.-- ");
		morse.put("Z", "--.. ");
		morse.put("0", "----- ");
		morse.put("1", ".---- ");
		morse.put("2", "..--- ");
		morse.put("3", "...-- ");
		morse.put("4", "....- ");
		morse.put("5", "..... ");
		morse.put("6", "-.... ");
		morse.put("7", "--... ");
		morse.put("8", "---.. ");
		morse.put("9", "----. ");
		morse.put(" ", "/ ");
		morse.put(".-", "A");
		morse.put("-...", "B");
		morse.put("-.-.", "C");
		morse.put("-..", "D");
		morse.put(".", "E");
		morse.put("..-.", "F");
		morse.put("--.", "G");
		morse.put("....", "H");
		morse.put("..", "I");
		morse.put(".---", "J");
		morse.put("-.-", "K");
		morse.put(".-..", "L");
		morse.put("--", "M");
		morse.put("-.", "N");
		morse.put("---", "O");
		morse.put(".--.", "P");
		morse.put("--.-", "Q");
		morse.put(".-.", "R");
		morse.put("...", "S");
		morse.put("-", "T");
		morse.put("..-", "U");
		morse.put("...-", "V");
		morse.put(".--", "W");
		morse.put("-..-", "X");
		morse.put("-.--", "Y");
		morse.put("--..", "Z");
		morse.put("-----", "0");
		morse.put(".----", "1");
		morse.put("..---", "2");
		morse.put("...--", "3");
		morse.put("....-", "4");
		morse.put(".....", "5");
		morse.put("-....", "6");
		morse.put("--...", "7");
		morse.put("---..", "8");
		morse.put("----.", "9");
		morse.put("/", " ");

	}

	public String toMorseCode(String input) {
		StringBuilder output = new StringBuilder();
		String letter;
		for (int i = 0; i < input.length(); i++) {
			letter = String.valueOf(input.toUpperCase().charAt(i));
			output.append(morse.get(letter));
		}
		return output.toString().trim();
	}

	public String toPlainText(String input) {
		StringTokenizer st = new StringTokenizer(input, " ");
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			while (st.hasMoreTokens()) {
				String code = st.nextToken();
				output.append(morse.get(code));
			}
		}
		return output.toString();
	}
}