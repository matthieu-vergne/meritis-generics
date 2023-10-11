package fr.vergne.meritis.generics;
import static fr.vergne.meritis.generics.__Annexes.*;

import java.util.List;

public abstract class _C_OubliGenerics2 {
	abstract void consumeListOfNumbers(List<Number> list);
	abstract void consumeListOfObjects(List<Object> list);
	abstract void consumeListOfWildcard(List<?> list);
	abstract void consumeListRaw(List list);
	
	void methodWithRawType(List list) {
		consumeListOfNumbers(list);
		consumeListOfObjects(list);
		consumeListOfWildcard(list);
		consumeListRaw(list); // Cas rétrocompatible
	}
	void methodWithObject(List<Object> list) {
		consumeListOfNumbers(list);
		consumeListOfObjects(list);
		consumeListOfWildcard(list);
		consumeListRaw(list); // Cas rétrocompatible
	}
	void methodWithGenerics(List<Number> list) {
		consumeListOfNumbers(list);
		consumeListOfObjects(list);
		consumeListOfWildcard(list);
		consumeListRaw(list); // Cas rétrocompatible
	}
	void methodWithWildcard(List<?> list) {
		consumeListOfNumbers(list);
		consumeListOfObjects(list);
		consumeListOfWildcard(list);
		consumeListRaw(list); // Cas rétrocompatible
	}
	// Joker toujours compatible ?
}
