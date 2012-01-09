import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Observable;



public class OpProdCons extends Operation {
	//private ArrayList<Object> table = new ArrayList<Object>();
	private ArrayList<Number> table = new ArrayList<Number>();
	//int i=0;
	/*@Override
	public synchronized void update(Observable o, Object arg) {
		try {
			//for(Data d : arg) {
				this.a.add(arg);
				System.out.println("Operation \""+this.getName()+"\" : résultat de \""+ ((Operation) o).getName() +"\" obtenu et vaut " + this.a.get(i).toString() );
				//System.out.println("Buffer : Update "+this.a.size());
			//}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		i++;
		this.notify();
	}*/
	
	public ArrayList<Number> buffer(double a){
		this.table.add(a);
		return this.table;
	}
	/*
	public synchronized void run() {
		int i=0;
		int n=1;
		//System.out.println("Buffer : On commence le thread buffer "+this.a.size());
		while(i<100){ //On effectue la boucle qu'une seule fois pour le moment
			//for( Data d : this.arguments.values()){
			try {
				this.wait();
				for( Data d : this.arguments.values()) this.a.add(d.getValue());
				
			this.eval(this.name);										//normal
			this.setChanged();			
			this.notifyObservers(this.a);
			//System.out.println("Plot :On prévient que ça a changé "+i);			
			this.notifyObservers(this.getOutput());						//On annonce le changement
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		i++;
		n=this.arguments.values().size();

		}
		//this.clearInput();												//On nettoie l'Input
		System.out.println("Taille du tableau : "+n);
		
		//}
	}
*/
}
