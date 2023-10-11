package fr.vergne.meritis.generics;
import static fr.vergne.meritis.generics.__Annexes.*;

import java.util.List;

public abstract class _C_OubliGenerics1 {
	void methodWithRawType(List list) {
		list.add(new Object()); // Cas rétrocompatible
		Object a = list.get(0); // Cas rétrocompatible
		
		list.add(new_Number()); // Cas rétrocompatible
		Number b = list.get(0);
		
		list.add(new_Integer()); // Cas rétrocompatible
		Integer c = list.get(0);
	}
	void methodWithObject(List<Object> list) {
		list.add(new Object());
		Object a = list.get(0);
		
		list.add(new_Number());
		Number b = list.get(0);
		
		list.add(new_Integer());
		Integer c = list.get(0);
	}
	// /!\ Object le plus proche de type brut, mais pas equivalent !
}
