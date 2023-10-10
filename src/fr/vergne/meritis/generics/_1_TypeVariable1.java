package fr.vergne.meritis.generics;
import java.util.List;

@SuppressWarnings("unused")
public class _1_TypeVariable1 {

	// Déclaration sur classe ou méthode
	// Utilisation dans le scope associé
	static abstract class MyClass<T, U, V> {// Vrai aussi sur interface​
		private T t1;
		public T t2;
		private List<T> l1;

		V method1(T t, U u) {
			return null;
		}

		<D> D method2(D d, T t) {// D que dans la méthode
			return null;
		}

		abstract <D> D method3(D d, U u);// Vrai aussi sur interface​

		static <V, D> D myMethod(D d, V v) {
			return null;
		}
		
		public static void main(String[] args) {
			// Invocation avec types concrets au niveau classe
			MyClass<String, Integer, String> instance = new MyClass<String, Integer, String>() {

				@Override
				// U de la classe spécialisé
				// D de la méthode générique
				<D> D method3(D d, Integer u) {
					return null;
				}
			};
			// Invocation avec types concrets au niveau méthode
			// D de la méthode spécialisé
			instance.<String> method3("foo", 123);
			
			// Inférence de type pour réduire la verbosité
			// notation diamant + méthode implicite
		}
	}

}
