import java.lang.reflect.InvocationTargetException;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.JFrame;
import info.monitorenter.gui.chart.Chart2D;
import info.monitorenter.gui.chart.ITrace2D;
import info.monitorenter.gui.chart.traces.Trace2DSimple;

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
				
		/**** Instanciation des variables ****/
		Constant cte1 = new Constant(-1.);
		Constant cte2 = new Constant(3.);
		Constant cte3 = new Constant(2.);
		Constant cte4 = new Constant(true);
		Constant pas = new Constant(1.);
		
		/**** Instanciation des composants ****/
		OpArith addition = new OpArith();
		OpBool et_logique = new OpBool(); 
		OpMaths tangente = new OpMaths();
		OpMaths exponentielle = new OpMaths();
		OpRel inferieur_strict = new OpRel();
		
		/**** Instanciation des producteurs et/ou consommateurs de données ****/
		OpProdCons buffer1 = new OpProdCons();
		OpProdCons buffer2 = new OpProdCons();
		OpCons affichage = new OpCons();
		OpCons graphique = new OpCons();
		OpProd cte1_notifiee = new OpProd();
		OpProd cte2_notifiee = new OpProd();
		OpProd x_ = new OpProd();
		VariableBuilder x = new VariableBuilder();
	
		/**** Définition des composants dans n'importe quel ordre (mettre en 2ème paramètre de
		 * la méthode set l'ensemble des arguments de la fonction appelée).
		 */
		buffer1.set("buffer", new Object[] {addition});
		inferieur_strict.set("strictly_lower", new Object[] {tangente, exponentielle});
		et_logique.set("and", new Object[] {inferieur_strict, cte2_notifiee});
		buffer2.set("buffer", new Object[] {exponentielle});
		exponentielle.set("exp", new Object[] {addition});
		tangente.set("tan", new Object[] {x});
		addition.set("addition", new Object[] {tangente, cte1_notifiee});
		affichage.set("display", new Object[] {tangente});
		
		
		/**** Affichage du graphique (non fonctionnel) ****/
		//p.set("plot", new Object[] {x, y});
		
		/**** Lancement des opérations par les définitions des variables et constantes ****/
		cte1_notifiee.set("produce", new Object[] {cte3});
		cte2_notifiee.set("produce", new Object[] {cte4});
		x.set("iterate", new Object[] {cte1, cte2, pas});
		

	}

}
