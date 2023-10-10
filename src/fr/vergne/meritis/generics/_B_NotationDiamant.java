package fr.vergne.meritis.generics;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class _B_NotationDiamant {
	void withExplicitGenerics() {
		List<Number> list = new LinkedList<Number>();
	}
	
	void withDiamond() {
		List<Number> list = new LinkedList<>();
	}
	
	void withDiamondOnSplitDeclaration() {
		List<Number> list;
		// ...
		list = new LinkedList<>();
	}
	
	void noDiamondOnType() {
		List<> list = new LinkedList<Number>();
	}
	
	void withDiamondOnMoreAbstractType() {
		// Quel type pour le generics ?
		Object list = new LinkedList<>();
	}
	
	void useToReducedVerbosity() {
		Map<String, Map<String, Map<String, Number>>> longMap = new HashMap<String, Map<String, Map<String, Number>>>();
		Map<String, Map<String, Map<String, Number>>> shortMap = new HashMap<>();
		// Attention à utiliser les bons niveaux d'abstraction (primitive obsession)
	}

	class UnreliableInferenceVarKeyword {
		// /!\ Attention au mot clé "var" depuis Java 10
		
		void withExplicitGenerics() {
			// Quel type pour list ?
			var list = new LinkedList<Number>();
		}

		void withDiamond() {
			// Quel type pour list ?
			var list = new LinkedList<>();
		}
		
		// Pour aller plus loin sur "var" :
		// https://meritis.fr/le-mot-cle-var-introduit-en-java-10/
	}

	class UnreliableInferenceOnChainedCalls {
		public static void main(String[] args) {
			// Quel type pour value ?
			var value = Stream.of(1, 2, 3)//
					.collect(//
							() -> new LinkedList<>(), // Diamant = infère selon le contexte
							(list, i) -> list.add(i), //
							(list1, list2) -> list1.addAll(list2)//
					)//
					.get(0);
		}
		
		class NoDiamond {
			public static void main(String[] args) {
				// Tous les types sont explicites, on n'a plus besoin de contexte
				int value = Stream.of(1, 2, 3) //
						.collect(//
								() -> new LinkedList<Integer>(),
								(list, i) -> list.add(i), //
								(list1, list2) -> list1.addAll(list2)//
						)//
						.get(0);
				// Solution la plus simple,
				// mais ne s'applique que quand le soucis vient du diamant
			}
		}
		class ExplicitGenericsOnMethod {
			public static void main(String[] args) {
				// On donne l'information de contexte manquante à collect()
				int value = Stream.of(1, 2, 3) //
						.<List<Integer>> collect(//
								() -> new LinkedList<>(),
								(list, i) -> list.add(i), //
								(list1, list2) -> list1.addAll(list2)//
						)//
						.get(0);
				// Solution générique,
				// mais le(s) generics de la méthode peuvent être nombreux/complexes
			}
		}
		class IntermediaryVariables {
			public static void main(String[] args) {
				// On donne l'information de contexte manquante à collect()
				Stream<Integer> stream = Stream.of(1, 2, 3);
				List<Integer> collector = stream.collect(//
						() -> new LinkedList<>(), //
						(list, i) -> list.add(i), //
						(list1, list2) -> list1.addAll(list2)//
				);
				int value = collector.get(0);
				// Solution générique,
				// mais code globalement plus verbeux
			}
		}
		class RefactorToAssmueMoreContextInfo {
			public static void main(String[] args) {
				// On utilise des méthodes plus restrictives sur les solutions possibles
				int value = Stream.of(1, 2, 3)//
						.findFirst() //
						.get();
				// Si dispo ou si implémentable
			}
		}
	}

}
