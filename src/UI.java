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
		
		/**** Initialisation des Variables****/
//		SF var1 = new SF();
//		SF var2 = new SF();
		
		/**** Initialisation des Components****/
		/*OpProd d1 = new OpProd(2);
		OpProd d2 = new OpProd(3);*/
		Constant a = new Constant(-1.);
		Constant step = new Constant(0.1);
		Constant b = new Constant(1.);
		
		OpArith c = new OpArith();
		OpArith d = new OpArith();
		OpArith e = new OpArith();
		OpMaths f = new OpMaths();
		OpMaths h = new OpMaths();
		OpMaths j = new OpMaths();
		OpMaths g = new OpMaths();
		OpProdCons y = new OpProdCons();
		OpProdCons x = new OpProdCons();
		OpCons v = new OpCons();
		OpCons p = new OpCons();
		
		OpProd k = new OpProd();
		VariableBuilder i = new VariableBuilder();
		

		//f.set("sin", new Object[] {e});
		x.set("buffer", new Object[] {i});
		y.set("buffer", new Object[] {g});
		
		//c.set("division", new Object[] {e, a});
		g.set("tan", new Object[] {i});
		//h.set("exp", new Object[] {e});
		//d.set("substraction", new Object[] {i, c});
		//e.set("addition", new Object[] {i, a});	
		//v.set("display", new Object[] {h});
		p.set("plot", new Object[] {x, y});
		i.set("produit",new Object[] {a, b, step});

	}

}
