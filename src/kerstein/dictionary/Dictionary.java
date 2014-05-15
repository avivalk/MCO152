package kerstein.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {
	private Map<String, String> words;// a hashmap is an interface that maps
										// keys to values-mapping words to
										// definitions

	// word is the key,definition is the value
	// would use a hashmap when have unique values like SS or ID number

	public Dictionary() throws FileNotFoundException {
		words = new HashMap<>();
		Scanner inputFile = new Scanner(new File("OWL.txt"));
		String word;
		while (inputFile.hasNext()) {
			words.put(inputFile.next(), inputFile.nextLine());// use put method
																// to add to map
		}
		inputFile.close();
	}

	public Iterator<String> iterator() {
		return words.keySet().iterator();
	}

	public int getDictionarySize() {
		return words.size();
	}

	public boolean exists(String word) {
		return words.containsKey(word.toUpperCase());// contains key is O(1)
	}

	public String getDefinition(String word) {
		return words.get(word);
	}

}
