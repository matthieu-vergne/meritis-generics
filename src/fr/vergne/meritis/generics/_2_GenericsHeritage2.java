package fr.vergne.meritis.generics;

import static fr.vergne.meritis.generics.__Annexes.*;

@SuppressWarnings({ "unused", "serial" })
public interface _2_GenericsHeritage2 {

	class A<T>              {T doA(T t) {return null;}}
	class B<T> extends A<T> {T doB(T t) {return null;}}
	static void process(A<Number> a) {/*...*/}
	
	public static void main(String[] args) {
		// Compile ou pas ? Pourquoi ?
//		 process(new Object());
//		 process(new_Number());
//		 process(new A<Number>());
//		 process(new B<Number>());
	}
	
	class Answer {
		static void process(A<Number> a) {
			Number number = a.doA(new_Number());
		}
		
		public static void main(String[] args) {
			 process(new Object()); // méthode doA(Number) non définie
			 process(new_Number()); // méthode doA(Number) non définie
			 process(new A<Number>()); // méthode doA(Number) définie par définition
			 process(new B<Number>()); // méthode doA(Number) définie par héritage
		}
	}
}
