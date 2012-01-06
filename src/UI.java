

public class UI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print("Hey coucou!");
		 
		/**** Initialisation ****/
		OpProd d1 = new OpProd(2);
		OpProd d2 = new OpProd(3);
		OpMaths e = new OpMaths(d1, d2);
		OpCons c = new OpCons(e);
		
		/**** Mise en place des Observers ****/
		d1.addObserver(e);//e observe d1
		d2.addObserver(e);//e observe d2
		e.addObserver(c);//c observe e
		
		d1.prod();
		e.update(d1, d1.getLastOutput(0) );
		e.update(d2, d2.getLastOutput(0) );
		
		
		System.out.println("On affiche les deux dernière valeurs : ");
		d1.printLastOutput();
		d2.printLastOutput();
		
		e.run();

	}

}
