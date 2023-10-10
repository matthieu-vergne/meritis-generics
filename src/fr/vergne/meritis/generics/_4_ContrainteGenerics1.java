package fr.vergne.meritis.generics;

import static fr.vergne.meritis.generics.__Annexes.*;

import java.util.List;

@SuppressWarnings({ "unused", "serial" })
public class _4_ContrainteGenerics1 {
	class Extends {
		void method(List<? extends Number> list) {
			list.add(new Object());
			Object a = list.get(0);
			
			list.add(new_Number());
			Number b = list.get(0);
			
			list.add(new_Integer());
			Integer c = list.get(0);
		}
	}

	class Super {
		void methodWithSuper(List<? super Number> list) {
			list.add(new Object());
			Object a = list.get(0);
			
			list.add(new_Number());
			Number b = list.get(0);
			
			list.add(new_Integer());
			Integer c = list.get(0);
		}
	}

	class Both {
		void methodWithStrictType(List<Number> list) {
//			list.add(new Object());
//			Object a = list.get(0);
//			
//			list.add(new_Number());
//			Number b = list.get(0);
//			
//			list.add(new_Integer());
//			Integer c = list.get(0);
		}
	}
}
