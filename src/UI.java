import java.lang.reflect.InvocationTargetException;


public class UI {

	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws NoSuchMethodException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 */
	public static void main(String[] args) throws InterruptedException, SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		 
		System.out.println("UI : Begin");
		
		/**** Initialisation des Variables****/
//		SF var1 = new SF();
//		SF var2 = new SF();
		
		/**** Initialisation des Components****/
		/*OpProd d1 = new OpProd(2);
		OpProd d2 = new OpProd(3);*/
		Constant a = new Constant(2.);
		Constant init = new Constant(1.);
		Constant step = new Constant(1.);
		Constant b = new Constant(5.);
		OpMaths c = new OpMaths();
		OpMaths d = new OpMaths();
		OpMaths e = new OpMaths();
		OpMaths f = new OpMaths();
		OpMaths h = new OpMaths();
		OpMaths j = new OpMaths();
		OpBool g = new OpBool();
		
		OpProd k = new OpProd();
		OpProd i = new OpProd();
		//VariableBuilder a = new VariableBuilder();
		
		//a.set("increment", new Object[] {init, b, step});
		

		f.set("sin", new Object[] {e});
		c.set("division", new Object[] {i, k});
		g.set("tan", new Object[] {i});
		h.set("exp", new Object[] {e});
		d.set("substraction", new Object[] {i, c});
		e.set("addition", new Object[] {c, d});	
		i.set("produit",new Object[] {a});
		k.set("produit",new Object[] {b});
		
		
		
		
		
		/*OpCons c = new OpCons(e);*/
		
		/**** Mise en place des Observers ****/
		/*d1.addObserver(e);//e observe d1
		d2.addObserver(e);//e observe d2
		e.addObserver(c);//c observe e
		
		d1.prod();
	//	e.update(d1, d1.getLastOutput(0) );
	//	e.update(d2, d2.getLastOutput(0) );
		
		
	//	System.out.println("On affiche les deux dernière valeurs : ");
	//	d1.printLastOutput();
	//	d2.printLastOutput();
		
	//	e.run();*/
		/*Thread.currentThread();
		Thread.sleep(5000);*/
		
		/*d2.prod();*/
		
		/*System.out.println("UI : Fin");*/
		

	}

}
