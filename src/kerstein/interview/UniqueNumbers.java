package kerstein.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UniqueNumbers {

	public static void main(String[] args) {

		/*
		 * Scanner scanner = new Scanner(System.in); List<Integer> list = new
		 * ArrayList<Integer>(); for (int i = 0; i < 10; i++) { int num =
		 * scanner.nextInt(); if (!list.contains(num)); list.add(num); } } //the
		 * efficiency for this algorithm is n squared=searched through 10 //and
		 * then searches through the unique list also each time
		 */

		// more efficient way is to use a set-an interface that doesnt contain
		// duplicates
		// efficiency for a set is O(1)=only go through the set once-dont need
		// to
		// loop through it
		// however-sets do not guarantee order-wont give back the order that was
		// given in
		/*
		 * Scanner scanner = new Scanner(System.in); Set<Integer> set = new
		 * HashSet<Integer>(); for (int i = 0; i < 10; i++) { int num =
		 * scanner.nextInt(); if (!set.contains(num)) { set.add(num); } } //
		 * System.out.println(set.toString());
		 */
		Scanner scanner = new Scanner(System.in);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < 10; i++) {
			int num = scanner.nextInt();
			if (!map.containsKey(num)) {
				map.put(num, 1);
			} else {
				map.put(num, map.get(num) + 1);
			}
		}
		System.out.println(map.toString());
	}
}
