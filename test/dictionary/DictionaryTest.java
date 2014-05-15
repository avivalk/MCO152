package kerstein.dictionary;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

public class DictionaryTest {

	@Test
	public void testReadInWords() throws FileNotFoundException {
		Dictionary diction = new Dictionary();
	}

	@Test
	public void testExists() {
		boolean exists = false;
		try {
			Dictionary diction = new Dictionary();
			exists = diction.exists("Yay");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(exists);
	}
}
