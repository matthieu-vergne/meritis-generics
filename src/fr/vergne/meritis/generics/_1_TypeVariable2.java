package fr.vergne.meritis.generics;
import java.util.List;

@SuppressWarnings("unused")
public class _1_TypeVariable2 {

	abstract class MyClass<T> {
		static T t;// static hors scope instance

		<D> D method(D d) {
			return null;
		}
		D d;// champs hors scope méthode​
	}

}
