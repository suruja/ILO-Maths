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
		Constant a = new Constant(1.);
		Constant step = new Constant(0.5);
		Constant b = new Constant(5.);
		
		Constant aa = new Constant(1.);
		Constant stepp = new Constant(1.);
		Constant bb = new Constant(5.);
		
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
		
		OpProd k = new OpProd();
		VariableBuilder i = new VariableBuilder();
		

		//f.set("sin", new Object[] {e});
		y.set("buffer", new Object[] {e});
		x.set("buffer", new Object[] {i});
		c.set("division", new Object[] {e, a});
		//v.set("plot", new Object[] {x,y});
		g.set("tan", new Object[] {i});
		h.set("exp", new Object[] {e});
		//d.set("substraction", new Object[] {i, c});
		e.set("addition", new Object[] {i, a});	
		
		/*
		c.set("pow", new Object[] {f, k});
		f.set("cos", new Object[] {i});*/
		//k.set("produit",new Object[] {a});
		i.set("produit",new Object[] {a,b,step});
		
		
		// Create a chart:  
	/*    Chart2D chart = new Chart2D();
	    // Create an ITrace: 
	    ITrace2D trace = new Trace2DSimple(); 
	    // Add the trace to the chart. This has to be done before adding points (deadlock prevention): 
	    chart.addTrace(trace);    
	    // Add all points, as it is static: 
	    Random random = new Random();
	    for(int z=100;z>=0;z--){
	      trace.addPoint(z,z*2);
	    }
	    // Make it visible:
	    // Create a frame.
	    JFrame frame = new JFrame("MinimalStaticChart");
	    // add the chart to the frame: 
	    frame.getContentPane().add(chart);
	    frame.setSize(400,300);
	    // Enable the termination button [cross on the upper right edge]: 
	    frame.addWindowListener(
	        new WindowAdapter(){
	          public void windowClosing(WindowEvent e){
	              System.exit(0);
	          }
	        }
	      );
	    frame.setVisible(true);
		
		*/
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
