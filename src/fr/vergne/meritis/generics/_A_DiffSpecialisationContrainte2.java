package fr.vergne.meritis.generics;
import java.util.List;

public class _A_DiffSpecialisationContrainte2 {
	class C {}
	interface T1 {}
	interface T2 {}
	
	// Ne compile pas
	
//	void methodExtends(List<? extends C & T1 & T2> list) {/*...*/}
//	void methodSuper(List<? super C & T1 & T2> list) {/*...*/}
	
	// Compile, mais veut dire quoi ?
	
	<T extends C & T1 & T2> void withStrictType(List<T> list, T t) {
//		list.add(new Object());
//		Object a = list.get(0);
		
//		list.add(new C());
//		C b = list.get(0);
		
//		list.add(new_T1());
//		T1 c = list.get(0);
		
//		list.add(new_T2());
//		T2 d = list.get(0);
		
//		list.add(new All());
//		All e = list.get(0);
		
//		list.add(t);
//		T f = list.get(0);
	}
	<T extends C & T1 & T2> void withExtends(List<? extends T> list, T t) {
//		list.add(new Object());
//		Object a = list.get(0);
//		
//		list.add(new C());
//		C b = list.get(0);
//		
//		list.add(new_T1());
//		T1 c = list.get(0);
//		
//		list.add(new_T2());
//		T2 d = list.get(0);
//		
//		list.add(new All());
//		All e = list.get(0);
//		
//		list.add(t);
//		T f = list.get(0);
	}
	<T extends C & T1 & T2> void withSuper(List<? super T> list, T t) {
//		list.add(new Object());
//		Object a = list.get(0);
//		
//		list.add(new C());
//		C b = list.get(0);
//		
//		list.add(new_T1());
//		T1 c = list.get(0);
//		
//		list.add(new_T2());
//		T2 d = list.get(0);
//		
//		list.add(new All());
//		All e = list.get(0);
//		
//		list.add(t);
//		T f = list.get(0);
	}
	
	static T1 new_T1() {
		return null;
	}
	
	static T2 new_T2() {
		return null;
	}
	
	class All extends C implements T1, T2 {}
}
