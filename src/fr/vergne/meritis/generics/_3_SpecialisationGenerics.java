package fr.vergne.meritis.generics;

public class _3_SpecialisationGenerics {

	class C      {void stuffFromC() {}}
	interface I1 {void stuffFromI1();}
	interface I2 {void stuffFromI2();}
	
	class X<T extends C & I1 & I2> {}
	
	<T extends C & I1 & I2> void method(T t) {
		t.stuffFromC();
		t.stuffFromI1();
		t.stuffFromI2();
	}
	
	// Comme pour l'héritage et l'implémentation
	// Juste pas de "implements" pour les interface
}