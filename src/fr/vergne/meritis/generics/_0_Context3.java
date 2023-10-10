package fr.vergne.meritis.generics;

public class _0_Context3 {

	public static void main(String[] args) {
		ListOfItems<Integer> myInts = new LinkedListOfItems<Integer>();
		myInts.add(1);
		myInts.add(2);
		myInts.add(3);
		System.out.println(sumInts(myInts));

		ListOfItems<String> myStrings = new LinkedListOfItems<String>();
		myStrings.add("1");
		myStrings.add("2");
		myStrings.add("3");
		System.out.println(sumStrings(myStrings));

		// Ne compile plus
		sumInts(myStrings);
		sumStrings(myInts);
	}

	interface ListOfItems<T> {
		int size();
		void add(T value);
		T get(int index);
	}

	static class LinkedListOfItems<T> implements ListOfItems<T> {
		class LinkedValue {
			T value;
			LinkedListOfItems<T> next;
		}

		LinkedValue current = null;

		@Override
		public int size() {
			return current == null ? 0 : 1 + current.next.size();
		}

		@Override
		public void add(T value) {
			if (current == null) {
				current = new LinkedValue();
				current.value = value;
				current.next = new LinkedListOfItems<T>();
			} else {
				current.next.add(value);
			}
		}

		@Override
		public T get(int index) {
			return index == 0 ? current.value : current.next.get(index - 1);
		}
	}

	private static int sumInts(ListOfItems<Integer> myList) {
		int total = 0;
		for (int i = 0; i < myList.size(); i++) {
			int operand = myList.get(i);
			total += operand;
		}
		return total;
	}

	private static int sumStrings(ListOfItems<String> myList) {
		int total = 0;
		for (int i = 0; i < myList.size(); i++) {
			String operand = myList.get(i);
			total += Integer.parseInt(operand);
		}
		return total;
	}
}
