package fr.vergne.meritis.generics;
import java.util.LinkedList;
import java.util.List;

public class _A_DiffSpecialisationContrainte1 {
	class C {}
	class D extends C {}
	
	// Différence ?
	void methodBound(List<? extends C> list) {/*...*/}
	<T extends C> void methodDef(List<T> list) {/*...*/}
	<T extends C> void methodBoundDef(List<? extends T> list) {/*...*/}
	
	class Answer {
		// Aucune différence pour 1 usage du generics
		void methodBound(List<? extends C> list) {/*...*/}
		<T extends C> void methodDef(List<T> list) {/*...*/}
		<T extends C> void methodBoundDef(List<? extends T> list) {/*...*/}
		
		void Object() {
			List<Object> list = new LinkedList<Object>();
			methodBound(list);
			methodDef(list);
			methodBoundDef(list);
		}
		void C() {
			List<C> list = new LinkedList<C>();
			methodBound(list);
			methodDef(list);
			methodBoundDef(list);
		}
		void D() {
			List<D> list = new LinkedList<D>();
			methodBound(list);
			methodDef(list);
			methodBoundDef(list);
		}
		
		class Answer2 {
			// Comme classe nommée permet réutilisation de l'implémentation pour plusieurs instances,
			// type nommé permet réutilisation du type pour plusieurs utilisations.
			
			// Type anonyme = pas de synchronisation des types
			void methodBound(List<? extends C> list1, List<? extends C> list2) {/*...*/}
			void casesBound() {
				List<C> c = new LinkedList<C>();
				List<D> d = new LinkedList<D>();
				
				methodBound(c, c);
				methodBound(d, d);
				methodBound(c, d);
				methodBound(d, c);
			}
			
			// Type nommé = synchronise les types
			<T extends C> void methodDef(List<T> list1, List<T> list2) {/*...*/}
			void casesDef() {
				List<C> c = new LinkedList<C>();
				List<D> d = new LinkedList<D>();
				
				methodDef(c, c); // T = C
				methodDef(d, d); // T = D
				methodDef(c, d); // T ne peut pas être résolu sans erreur
				methodDef(d, c); // T ne peut pas être résolu sans erreur
			}
			// /!\ Ne factorisez pas vos generics pour être DRY, ce n'est pas équivalent
			
			// Nomme une partie de la hiérarchie pour la réutiliser
			<T extends C> void methodBoundDef(List<? extends T> list1, List<T> list2) {/*...*/}
			void casesBoundDef() {
				List<C> c = new LinkedList<C>();
				List<D> d = new LinkedList<D>();
				
				methodBoundDef(c, c); // T = C
				methodBoundDef(d, d); // T = D
				methodBoundDef(c, d); // T ne peut pas être résolu sans erreur
				methodBoundDef(d, c); // T = C
			}
		}
	}
}
