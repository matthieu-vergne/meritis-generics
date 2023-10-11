package fr.vergne.meritis.generics;

import static fr.vergne.meritis.generics.__Annexes.*;

import java.util.List;

@SuppressWarnings({ "unused", "serial" })
public class _4_ContrainteGenerics1 {
	class Extends {
		static void method(List<? extends Number> list) {
			list.add(new Object());
			Object a = list.get(0);
			
			list.add(new_Number());
			Number b = list.get(0);
			
			list.add(new_Integer());
			Integer c = list.get(0);
		}
		
		public static void main(String[] args) {
			List<Object> objects;
			List<Number> numbers;
			List<Integer> integers;
			
			method(objects);
			method(numbers);
			method(integers);
		}
	}

	class Super {
		static void method(List<? super Number> list) {
			list.add(new Object());
			Object a = list.get(0);
			
			list.add(new_Number());
			Number b = list.get(0);
			
			list.add(new_Integer());
			Integer c = list.get(0);
		}
		
		public static void main(String[] args) {
			List<Object> objects;
			List<Number> numbers;
			List<Integer> integers;
			
			method(objects);
			method(numbers);
			method(integers);
		}
	}

	class Both {
		static void method(List<Number> list) {
//			list.add(new Object());
//			Object a = list.get(0);
//			
//			list.add(new_Number());
//			Number b = list.get(0);
//			
//			list.add(new_Integer());
//			Integer c = list.get(0);
		}
		
		public static void main(String[] args) {
			List<Object> objects;
			List<Number> numbers;
			List<Integer> integers;
			
//			method(objects);
//			method(numbers);
//			method(integers);
		}
	}
}
