package fr.vergne.meritis.generics;

import java.util.Arrays;
import java.util.List;

public class _E_Varargs {
	static class NoGenericsNoVarargs {
		static class A {void doA() {}}
		static class B {void doB() {}}
		public static void process(A[] args) {
			Object[] objectArray = args; // Valide par héritage
			objectArray[0] = new B(); // ArrayStoreException car A != B, pollution attrapée
			args[0].doA();
		}
		public static void main(String[] args) {
			process(new A[] {new A(), new A()});
		}
	}
	static class NoGenerics {
		static class A {void doA() {}}
		static class B {void doB() {}}
		public static void process(A... args) {
			Object[] objectArray = args; // Valide par héritage
			objectArray[0] = new B(); // ArrayStoreException car A != B, pollution attrapée
			args[0].doA();
		}
		public static void main(String[] args) {
			process(new A(), new A());
		}
	}
	static class Generics {
		static class A {void doA() {}}
		static class B {void doB() {}}
		public static <T extends A> void process(T... args) {
			Object[] objectArray = args; // Valide par héritage
			objectArray[0] = new B(); // ArrayStoreException car A != B, pollution attrapée
			args[0].doA();
		}
		public static void main(String[] args) {
			process(new A(), new A());
		}
	}
	static class GenericClass {
		static class A {void doA() {}}
		static class B {void doB() {}}
		static class C<T> {
			final T sub;
			C(T sub) {this.sub = sub;}
		}
		public static void process(C<A>... args) {
			Object[] objectArray = args; // Valide par héritage
			objectArray[0] = new C<B>(new B()); // Pas de contrôle sur generics (type erasure), ça passe
			args[0].sub.doA(); // Conséquence pollution : ClassCastException
		}
		
		public static void main(String[] args) {
			process(new C<A>(new A()), new C<A>(new A()));
			// Ne peut pas arriver hors varargs car ne peut pas créer de C<A>[]
		}
	}
	static class GenericClassWithoutVarargs {
		static class A {void doA() {}}
		static class B {void doB() {}}
		static class C<T> {
			T sub;
			C(T sub) {this.sub = sub;}
			T getSub() {return sub;}
		}
		public static void process(List<C<A>> args) {
			// Ne compile jamais : List<C<A>>, List<C<B>>, List<C<?>>, List<Object>, List<?>
			// Raw type compile (contrôle désactivé) mais warning pour le rappeler
			List objectArray = args;
			objectArray.set(0, new C<B>(new B()));
			args.get(0).getSub().doA();
		}
		
		public static void main(String[] args) {
			process(Arrays.asList(new C<A>(new A()), new C<A>(new A())));
		}
	}
	
	// Résumé :
	// - l'effacement de type rend impossible la création de tableau d'une classe avec generics
	// - les varargs offrent un moyen détourné de créer ce genre de tableau
	// - l'héritage offre un moyen d'utiliser le tableau avec un type plus abstrait sans l'info de generics
	// - seul un contrôle au runtime peut alors déceler l'instruction polluante
	// - l'effacement de type perd les generics au runtime, donc pas de contrôle au runtime à ce niveau
	// - il devient alors possible de faire une instruction polluante passant les contrôles
	// - la pollution peut ensuite affecter le bon déroulement des opérations
}
