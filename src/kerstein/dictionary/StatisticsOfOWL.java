package kerstein.dictionary;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Iterator;

public class StatisticsOfOWL {

	public String getStatistics(Dictionary diction, Iterator iter) {
		StringBuilder stats = new StringBuilder();
		DecimalFormat formatter = new DecimalFormat("##.00");
		char[] alphabet = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
				'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
				'U', 'V', 'W', 'X', 'Y', 'Z' };

		for (int i = 0; i < alphabet.length; i++) {
			stats.append(alphabet[i] + " ");
			int numOccurrencesOfLetter = 0;
			int numWordsWithLetter = 0;

			while (iter.hasNext()) {
				String word = (String) iter.next();
				int amountOfLetterInWord = 0;
				for (int k = 0; k < word.length(); k++) {
					if (alphabet[i] == word.charAt(k)) {
						numOccurrencesOfLetter++;
						amountOfLetterInWord++;
					}
				}
				if (amountOfLetterInWord > 0) {
					numWordsWithLetter++;
				}
			}

			stats.append(numOccurrencesOfLetter + " ");
			int size = diction.getDictionarySize();
			double percentage = (numWordsWithLetter * 100.0) / size;
			stats.append(formatter.format(percentage) + "%");
			stats.append("\n");

		}
		return stats.toString();
	}

	public static void main(String[] args) {
		Dictionary diction = null;
		try {
			diction = new Dictionary();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		StatisticsOfOWL stats = new StatisticsOfOWL();
		Iterator<String> iter = diction.iterator();
		System.out.println(stats.getStatistics(diction, iter));
	}

}
