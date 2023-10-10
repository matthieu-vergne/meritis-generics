package fr.vergne.meritis.generics;

import static fr.vergne.meritis.generics.__Annexes.new_Number;

@SuppressWarnings("unused")
public interface _2_GenericsHeritage3 {

	class A<T>              {T doA(T t) {return null;}}
	class B<T> extends A<T> {T doB(T t) {return null;}}
	static void process(A<Number> a) {/*...*/}
	
	public static void main(String[] args) {
		// Compile ou pas ? Pourquoi ?
//		process(new A<Object>());
		process(new A<Number>());
//		process(new A<Integer>());
	}
	
	class Answer {
		static void process(A<Number> a) {
			Number number = a.doA(1.3);
		}
		
		public static void main(String[] args) {
			process(new A<Object>()); // Pas de garantie de Number
			process(new A<Number>());
			process(new A<Integer>()); // valeur 1.3 non compatible
			// L'héritage ne s'applique pas implicitement aux generics
		}
	}
}
