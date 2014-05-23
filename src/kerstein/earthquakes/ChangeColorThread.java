package kerstein.earthquakes;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JList;

public class ChangeColorThread extends Thread {

	private Map<String, Color> numbers;
	private JList list;

	public ChangeColorThread(JList list) {
		numbers = new HashMap<String, Color>();
		numbers.put("10", Color.MAGENTA);
		numbers.put("9", Color.RED);
		numbers.put("8", Color.ORANGE);
		numbers.put("7", Color.CYAN);
		numbers.put("6", Color.YELLOW);
		numbers.put("5", Color.GRAY);
		numbers.put("4", Color.GREEN);
		numbers.put("3", Color.LIGHT_GRAY);
		numbers.put("2", Color.BLUE);
		numbers.put("1", Color.BLACK);
		this.list = list;
	}

	@Override
	public void run() {

	}
}
