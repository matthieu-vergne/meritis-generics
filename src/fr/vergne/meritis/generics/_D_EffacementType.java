package fr.vergne.meritis.generics;

import static fr.vergne.meritis.generics.__Annexes.*;

import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
public class _D_EffacementType {
	void onTypedGenerics_atCompilationTime(Number num) {
		List<Number> list = new LinkedList<Number>();
		list.add(num);
		Number number = list.get(0);
	}
	void onTypedGenerics_atRunTime(Number num) {
		List/*Object*/ list = new LinkedList/*Object*/();
		list.add(/*Object*/ num);
		Number number = (Number) /*Object*/ list.get(0);
	}
	
	<N extends Number> void onGenericsDefinition_atCompilationTime(N num) {
		List<N> list = new LinkedList<N>();
		list.add(num);
		N number = list.get(0);
	}
	void onGenericsDefinition_atRunTime(Number num) {
		// Comment le code évolue ?
	}
	
	class IncompatibleWithOverloading {
		void process(List<Integer> list) {/*...*/}
		void process(List<String> list) {/*...*/}
	}
	class IncompatibleWithInstanceOf {
		void noGenerics(Object t) {
			if(t instanceof Integer) {/*...*/}
		}
		<T> void generics(Object t) {
			if(t instanceof T) {/*...*/}
		}
		void rawGenericType(Object t) {
			if(t instanceof List) {/*...*/}
		}
		void typedGenericType(Object t) {
			if(t instanceof List<Integer>) {/*...*/}
		}
		<T> void untypedGenericType(Object t) {
			if(t instanceof List<T>) {/*...*/}
		}
	}
	class IncompatibleWithClassObject {
		void noGenerics() {
			Class<Integer> clazzInt = Integer.class;
		}
		<T> void generics() {
			Class<T> clazz = T.class;
		}
		void rawGenericType() {
			Class<List> clazzList = List.class;
		}
		void typedGenericType() {
			Class<List<Integer>> clazzListInts = List<Integer>.class;
		}
		<T> void untypedGenericType() {
			Class<List<T>> clazzListT = List<T>.class;
		}
		
		<T> void ifBuiltStillUsable(Class<T> clazz, Object t) {
			clazz.isInstance(t);
		}
	}
	class IncompatibleWithArray {
		void noGenerics() {
			Integer[] arrayInts = new Integer[0];
		}
		<T> void generics() {
			T[] array = new T[0];
		}
		void rawGenericType() {
			List[] arrayLists = new List[0];
		}
		void typedGenericType() {
			List<Integer>[] arrayListsInts = new List<Integer>[0];
		}
		<T> void untypedGenericType() {
			List<T>[] arrayListsT = new List<T>[0];
		}
		
		<T> void ifBuiltStillUsable(T[] array, Object t) {
			T value = array[0];
		}
	}
	class LimitedReflection {
		class X<T extends Number> {}
		public static void main(String[] args) {
			displayArray(X.class.getTypeParameters());
			displayArray(X.class.getTypeParameters()[0].getBounds());
		}
		// Si besoin du type à l'exécution, fournir le Class<T> pour le retrouver​
	}
}
