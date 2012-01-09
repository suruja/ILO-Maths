import info.monitorenter.gui.chart.Chart2D;
import info.monitorenter.gui.chart.ITrace2D;
import info.monitorenter.gui.chart.traces.Trace2DSimple;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import javax.swing.JFrame;



public class OpCons extends Operation {

	private double[][] t = new double[2][100];
	private int t_count = 0;
	/*@Override
	public synchronized void update(Observable o, Object arg) {
		System.out.print("OpCons : On a été notifié donc on affiche le resultat : ");
		//Data p = (Data) arg;
		//arg.toString();
		int pwet = (Integer) arg; //On suppose pour le test que c'est un integer
		System.out.println(pwet);
		
	}*/
	
	public Object[] plot(Object[] h){
		
		h[this.t_count] = h;
		this.t_count++;
		return h;
	}
	
	@Override
	public synchronized void run(){
		try {
			System.out.println("Plot attend");
			this.wait();
			for( Data d : this.arguments.values()) this.addInput(d);//Une fois qu'elles sont récupérées, on les met dans Input
			System.out.println("Plot vient de recevoir un premier tableau");
			try {
				this.eval(this.name);
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			this.wait();
			for( Data d : this.arguments.values()) this.addInput(d);//Une fois qu'elles sont récupérées, on les met dans Input
			System.out.println("Plot vient de recevoir un dernier tableau, on affiche");
			try {
				this.eval(this.name);
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			print();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void print(){
	    Chart2D chart = new Chart2D();
	    // Create an ITrace: 
	    ITrace2D trace = new Trace2DSimple(); 
	    // Add the trace to the chart. This has to be done before adding points (deadlock prevention): 
	    chart.addTrace(trace);    
	    // Add all points, as it is static: 
	    Random random = new Random();
	    for(int z=0;z<100;z++){
	      trace.addPoint(this.t[0][z],this.t[1][z]);
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
	}
	
	
	/*
	public OpCons(){
		this.output = new ArrayList<Data>();
		Thread t = new Thread(this);
		t.start();
	}
	
	public OpCons(Operation e) {
		this.output = new ArrayList<Data>();
		Thread t = new Thread(this);
		t.start();
	}
	public void print(){
		
	}
	@Override
	public synchronized void run() {
		System.out.println("OpCons : On a lancé le thread");
		while(true){
			try {
				System.out.println("OpCons : On attend");
				this.wait();
				System.out.println("OpCons : On a reçu la valeur!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}*/

}
