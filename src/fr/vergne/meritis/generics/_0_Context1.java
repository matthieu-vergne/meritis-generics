package fr.vergne.meritis.generics;

public class _0_Context1 {

	public static void main(String[] args) {
		ListOfInts myInts = new LinkedListOfInts();
		myInts.add(1);
		myInts.add(2);
		myInts.add(3);
		System.out.println(sumInts(myInts));

		ListOfStrings myStrings = new LinkedListOfStrings();
		myStrings.add("1");
		myStrings.add("2");
		myStrings.add("3");
		System.out.println(sumStrings(myStrings));

		// Ne compile pas
//		sumInts(myStrings);
//		sumStrings(myInts);
	}

	interface ListOfStrings {
		int size();
		void add(String value);
		String get(int index);
	}

	interface ListOfInts {
		int size();
		void add(int value);
		int get(int index);
	}

	static class LinkedListOfStrings implements ListOfStrings {
		class LinkedValue {
			String value;
			LinkedListOfStrings next;
		}
		LinkedValue current = null;

		@Override
		public int size() {
			return current == null ? 0 : 1 + current.next.size();
		}

		@Override
		public void add(String value) {
			if (current == null) {
				current = new LinkedValue();
				current.value = value;
				current.next = new LinkedListOfStrings();
			} else {
				current.next.add(value);
			}
		}

		@Override
		public String get(int index) {
			return index == 0 ? current.value : current.next.get(index - 1);
		}
	}

	static class LinkedListOfInts implements ListOfInts {
		class LinkedValue {
			Integer value;
			LinkedListOfInts next;
		}
		LinkedValue current = null;

		@Override
		public int size() {
			return current == null ? 0 : 1 + current.next.size();
		}

		@Override
		public void add(int value) {
			if (current == null) {
				current = new LinkedValue();
				current.value = value;
				current.next = new LinkedListOfInts();
			} else {
				current.next.add(value);
			}
		}

		@Override
		public int get(int index) {
			return index == 0 ? current.value : current.next.get(index - 1);
		}
	}
	
	private static int sumInts(ListOfInts myList) {
		int total = 0;
		for (int i = 0; i < myList.size(); i++) {
			int operand = myList.get(i);
			total += operand;
		}
		return total;
	}
	
	private static int sumStrings(ListOfStrings myList) {
		int total = 0;
		for (int i = 0; i < myList.size(); i++) {
			String operand = myList.get(i);
			total += Integer.parseInt(operand);
		}
		return total;
	}
}
