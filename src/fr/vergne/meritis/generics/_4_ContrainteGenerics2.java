package fr.vergne.meritis.generics;
import java.util.List;

public class _4_ContrainteGenerics2 {

	<T extends Number> void process1() {/*...*/}
	<T super Number> void process2() {/*...*/}
	
	class X<T extends Number> {}
	class Y<T super Number> {}
}
