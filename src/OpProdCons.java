import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Observable;



public class OpProdCons extends Operation {
	private ArrayList a = new ArrayList<Object>(100); 

	@Override
	public synchronized void update(Observable o, Object arg) {
		try {
			for(Data d : (Iterable<Data>)arg) {
				a.add(arg);
				System.out.println("Operation \""+this.getName()+"\" : résultat de \""+ ((Operation) o).getName() +"\" obtenu et vaut " + d.getValue());
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		this.notify();
	}
	
	public synchronized void run() {
		int i=0;
		int n=1;
		
		//if(this.getName()=="produit")	n=1;
		while(i<this.a.size()){ //On effectue la boucle qu'une seule fois pour le moment
			//for( Data d : this.arguments.values()){
			try {
				this.wait();
				
			this.eval(this.name);										//normal
			this.setChanged();											
			System.out.println("On prévient que ça a changé");			
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
	/*	if(this.getName()=="iterateur"){
			Data a[],b,c;
			Double d;
			a=(Data[]) this.arguments;
			d = (Double) a[1].value;
			
		}*/
		//for( Data d : this.arguments.values()) d.setValue(n[i]);			//On affecte les nouvelles valeures
		//this.clearOutput();
		this.clearInput();												//On nettoie l'Input
		n=this.arguments.values().size();
		System.out.println("Taille du tableau : "+n);
		this.notifyObservers(this.a);
		}
		//}
	}

}
