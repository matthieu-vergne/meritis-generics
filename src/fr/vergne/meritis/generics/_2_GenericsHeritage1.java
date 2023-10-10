package fr.vergne.meritis.generics;

public interface _2_GenericsHeritage1 {

	class A           {void doA() {}}
	class B extends A {void doB() {}}
	static void process(A a) {/*...*/}
	
	public static void main(String[] args) {
		// Compile ou pas ? Pourquoi ?
		process(new Object());
		process(new A());
		process(new B());
	}
	
	class Answer {
		static void process(A a) {
			a.doA();
		}
		
		public static void main(String[] args) {
			process(new Object()); // méthode doA() non définie
			process(new A()); // méthode doA() définie par définition
			process(new B()); // méthode doA() définie par héritage
		}
	}
}