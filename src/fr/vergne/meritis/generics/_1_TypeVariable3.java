package fr.vergne.meritis.generics;

import java.util.List;
import java.util.Map;

public interface _1_TypeVariable3 {
	// 2 classes, 8 structures de données différentes
	// (/!\ Primitive obsession)
	// Generics permet d'assurer la cohérence malgré la complexité
	<T, U, V> Map<Map<T, Map<U, V>>, Map<U, Map<T, V>>> process(List<T> tList, List<U> uList, List<V> vList);
	
	// Fournit un contrôle bien spécifique
	<T> void method(T a, T b);
	default void typeInference() {
		// Compile ? Pourquoi ?
		// method(1, List.of(1, 3));
	}
	
	interface Answer {
		<T> void method(T a, T b);
		default void typeInference() {
			// T = Object
			method(1, List.of(1, 3));
			// Précision de la définition = précision du contrôle à la compilation
			// Une méthode générique bien définie utilisera les bons generics
		}
	}
}
