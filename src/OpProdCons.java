import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Observable;



public class OpProdCons extends Operation {
	private ArrayList<Object> a = new ArrayList<Object>(100); 
	int i=0;
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
	
	public Object buffer(){
		return this.a;
	}
	
	public synchronized void run() {
		int i=0;
		int n=1;
		System.out.println("Buffer : On commence le thread buffer "+this.a.size());
		//if(this.getName()=="produit")	n=1;
		while(i<5){ //On effectue la boucle qu'une seule fois pour le moment
			//for( Data d : this.arguments.values()){
			try {
				this.wait();
				for( Data d : this.arguments.values()) this.a.add(d);
				
			this.eval(this.name);										//normal
			this.setChanged();											
			System.out.println("Plot : On prévient que ça a changé "+i);			
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

		}
		this.clearInput();												//On nettoie l'Input
		n=this.arguments.values().size();
		System.out.println("Taille du tableau : "+n);
		this.notifyObservers(this.a);
		//}
	}

}
