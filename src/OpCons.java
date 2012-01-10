import info.monitorenter.gui.chart.Chart2D;
import info.monitorenter.gui.chart.ITrace2D;
import info.monitorenter.gui.chart.traces.Trace2DSimple;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Random;

import javax.swing.JFrame;



public class OpCons extends Operation {
	private Chart2D chart = new Chart2D();
    private ITrace2D trace = new Trace2DSimple();
    private JFrame frame = new JFrame("MinimalStaticChart");
	private HashMap<Number, Number> entries = new HashMap<Number, Number>();
		
	public void display(int a) {
		System.out.println(a);
	}
	
	public void display(float a) {
		System.out.println(a);
	}
	
	public void display(double a) {
		System.out.println(a);
	}
	
	public synchronized void plot(ArrayList<Number> x, ArrayList<Number> y){
		for(int i=0; i<x.size(); i++) {	
			this.entries.put(y.get(i), y.get(i));
		}
		this.print();
	}
		
	public synchronized void print(){
	     
	    // Add the trace to the chart. This has to be done before adding points (deadlock prevention): 
	    this.chart.addTrace(this.trace);    
	    // Add all points, as it is static: 
	    
	    for( Entry<Number, Number> e : this.entries.entrySet()){
	      this.trace.addPoint(e.getKey().doubleValue(), e.getValue().doubleValue());
	    }
	    // Make it visible:
	    // Create a frame.
	    // add the chart to the frame: 
	    this.frame.getContentPane().add(this.chart);
	    this.frame.setSize(400,300);
	    // Enable the termination button [cross on the upper right edge]: 
	    this.frame.addWindowListener(
	        new WindowAdapter(){
	          public void windowClosing(WindowEvent e){
	              System.exit(0);
	          }
	        }
	      );
	    this.frame.setVisible(true);
	}
}