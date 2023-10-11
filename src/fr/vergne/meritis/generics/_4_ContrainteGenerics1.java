package fr.vergne.meritis.generics;

import static fr.vergne.meritis.generics.__Annexes.*;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings({ "unused", "serial" })
public class _4_ContrainteGenerics1 {
	class Extends {
		static void method(List<? extends Number> list) {
			list.add(new Object());
			Object a = list.get(0);
			
			list.add(new_Number());
			Number b = list.get(0); // <- point d'intérêt (extract = extend)
			
			list.add(new_Integer());
			Integer c = list.get(0);
		}
		
		public static void main(String[] args) {
			List<Object> objects = new LinkedList<>();
			List<Number> numbers = new LinkedList<>();
			List<Integer> integers = new LinkedList<>();
			
			method(objects);
			method(numbers);
			method(integers);
		}
	}

	class Super {
		static void method(List<? super Number> list) {
			list.add(new Object());
			Object a = list.get(0);
			
			list.add(new_Number()); // <- point d'intérêt (supply = super)
			Number b = list.get(0);
			
			list.add(new_Integer());
			Integer c = list.get(0);
		}
		
		public static void main(String[] args) {
			List<Object> objects = new LinkedList<>();
			List<Number> numbers = new LinkedList<>();
			List<Integer> integers = new LinkedList<>();
			
			method(objects);
			method(numbers);
			method(integers);
		}
	}

	class Both {
		static void method(List<Number> list) {
			list.add(new Object());
			Object a = list.get(0);
			
			list.add(new_Number()); // supply + = super + = strict
			Number b = list.get(0); // extract    extends   type
			
			list.add(new_Integer());
			Integer c = list.get(0);
		}
		
		public static void main(String[] args) {
			List<Object> objects = new LinkedList<>();
			List<Number> numbers = new LinkedList<>();
			List<Integer> integers = new LinkedList<>();
			
			method(objects);
			method(numbers);
			method(integers);
		}
	}
	
	class IllustrativeExample {
		static void method(List<? extends Number> source, List<? super Number> destination) {
			Number number = source.get(0);
			destination.add(number);
		}
		
		public static void main(String[] args) {
			List<Object> objects = new LinkedList<>();
			List<Number> numbers = new LinkedList<>();
			List<Integer> integers = new LinkedList<>();
			
			method(numbers, numbers);
			method(numbers, objects);
			method(integers, numbers);
			method(integers, objects);
		}
		// En pratique, on démarre d'un type stricte.
		// Quand un cas légitime ne compile pas, on voit pour réduire les contraintes.
	}
}
