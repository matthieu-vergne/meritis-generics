package fr.vergne.meritis.generics;

import java.util.Arrays;

public class __Annexes {
	@SuppressWarnings("serial")
	public static Number new_Number() {
		return new Number() {

			@Override
			public long longValue() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int intValue() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public float floatValue() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public double doubleValue() {
				// TODO Auto-generated method stub
				return 0;
			}
		};
	}
	public static Integer new_Integer() {
		return Integer.valueOf(0);
	}
	public static void displayArray(Object[] array) {
		System.out.println(Arrays.toString(array));
	}
}
