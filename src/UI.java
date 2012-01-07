

public class UI {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		 
		System.out.println("UI : Begin");
		
		/**** Initialisation des Variables****/
//		SF var1 = new SF();
//		SF var2 = new SF();
		
		/**** Initialisation des Components****/
		OpProd d1 = new OpProd(2);
		OpProd d2 = new OpProd(3);
		OpMaths e = new OpMaths(d1, d2);
		OpCons c = new OpCons(e);
		
		/**** Mise en place des Observers ****/
		d1.addObserver(e);//e observe d1
		d2.addObserver(e);//e observe d2
		e.addObserver(c);//c observe e
		
		d1.prod();
	//	e.update(d1, d1.getLastOutput(0) );
	//	e.update(d2, d2.getLastOutput(0) );
		
		
	//	System.out.println("On affiche les deux dernière valeurs : ");
	//	d1.printLastOutput();
	//	d2.printLastOutput();
		
	//	e.run();
		Thread.currentThread();
		Thread.sleep(5000);
		
		d2.prod();
		
		System.out.println("UI : Fin");
		

	}

}
