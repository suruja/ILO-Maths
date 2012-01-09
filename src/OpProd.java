import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Observable;



public class OpProd extends Operation {

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
/*	
	public OpProd(int a){
		this.output = new ArrayList<Data>();
		SF tmp = new SF(a);
		this.output.add(tmp);
		System.out.println("OpProd : Production de valeurs : ");
		System.out.println(tmp.value);
		
	}
	
	
	public Data prod(){
		Data tmp = this.getLastOutput(0);
		System.out.println("OpProd : On notifie");
		this.setChanged();
		this.notifyObservers(tmp);
		return tmp;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
*/
	@Override
	public synchronized void run() {
		Double i=0.0;
		while(i<1){ //On effectue la boucle qu'une seule fois pour le moment
		try {
			for( Data d : this.arguments.values()) this.addInput(d);	//Même procédure qu'un composant
			this.eval(this.name);										//normal
			this.setChanged();											
			System.out.println("On prévient que ça a changé");			
			this.notifyObservers(this.getOutput());						//On annonce le changement
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
		for( Data d : this.arguments.values()) d.setValue(i);			//On affecte les nouvelles valeures
		//this.clearOutput();
		this.clearInput();												//On nettoie l'Input
		}
	}
	public double produit(double a){
		return a;
	}
}
