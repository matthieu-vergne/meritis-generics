package fr.vergne.meritis.generics;

public class _0_Context2 {

	public static void main(String[] args) {
		ListOfItems myInts = new LinkedListOfItems();
		myInts.add(1);
		myInts.add(2);
		myInts.add(3);
		System.out.println(sumInts(myInts));

		ListOfItems myStrings = new LinkedListOfItems();
		myStrings.add("1");
		myStrings.add("2");
		myStrings.add("3");
		System.out.println(sumStrings(myStrings));

		// Compile, mais échoue au cast
		sumInts(myStrings);
		sumStrings(myInts);
	}

	interface ListOfItems {
		int size();
		void add(Object value);
		Object get(int index);
	}

	static class LinkedListOfItems implements ListOfItems {
		class LinkedValue {
			Object value;
			LinkedListOfItems next;
		}

		LinkedValue current = null;

		@Override
		public int size() {
			return current == null ? 0 : 1 + current.next.size();
		}

		@Override
		public void add(Object value) {
			if (current == null) {
				current = new LinkedValue();
				current.value = value;
				current.next = new LinkedListOfItems();
			} else {
				current.next.add(value);
			}
		}

		@Override
		public Object get(int index) {
			return index == 0 ? current.value : current.next.get(index - 1);
		}
	}

	private static int sumInts(ListOfItems myList) {
		int total = 0;
		for (int i = 0; i < myList.size(); i++) {
			int operand = (int) myList.get(i);
			total += operand;
		}
		return total;
	}

	private static int sumStrings(ListOfItems myList) {
		int total = 0;
		for (int i = 0; i < myList.size(); i++) {
			String operand = (String) myList.get(i);
			total += Integer.parseInt(operand);
		}
		return total;
	}
}
