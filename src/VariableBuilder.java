import java.lang.reflect.InvocationTargetException;
import java.util.Observable;



public class VariableBuilder extends Operation {
	public synchronized double[] increment(double a, double b, double p) {
		
		int m = (int)(((b-a)/p)+1);
		double[] n = new double[m];
		int j = 0;
		for(double i=a; i<b; i+=p) {
			System.out.println("m = "+m+"; i="+i+";a="+a+";b="+b+"p="+p);
			n[j] = i;
			j++;
		}
		
		return n;
	}
/*	public Double[] increment(Double a, Double b, Double p) {
		Integer m = (int) ((b-a)/p);
		Double[] n = new Double[m];
		int j = 0;
		for(Double i=a; i<b; i+=p) {
			n[j] = i;
			j++;
		}
		return n;
	}*/
	@Override
	public synchronized void run() {
		int i=0;
		int d=1;
		System.out.println("Le producteur est lancé");
		//if(this.getName()=="produit")	n=1;
		while(i<d){ 
			try {
				this.addInput(new SF(this.n[i]));	//Même procédure qu'un composant
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
	/*	if(this.getName()=="iterateur"){
			Data a[],b,c;
			Double d;
			a=(Data[]) this.arguments;
			d = (Double) a[1].value;
			
		}*/
		//for( Data d : this.arguments.values()) d.setValue(n[i]);			//On affecte les nouvelles valeures
		//this.clearOutput();
		this.clearInput();												//On nettoie l'Input
		d=this.n.length;

		//Thread.currentThread();
		/*try {
			//Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		System.out.println("Taille du tableau : "+d);
		}
	}
	public double iterate(double a){
		return a;
	}
	public double iterate(double a, double b, double c){
		double[] n = new double[100]; 
		n=this.increment(a,b,c);
		int i=0;
		System.out.println("On crée le tableau des valeurs "+n[4]+n[5]+n[6]);
		for( Data d : this.arguments.values()){ d.setValue(n[i]);i++;System.out.println(n[i]);}
		return a;
	}

	private double n[];
	@Override
	public synchronized void set(String op, Object[] obj) {
		this.name = op;
		this.argument_count = obj.length;
		int i = 0;
		double[] tabi=new double[3];
		
		for(Object o : obj) {
			tabi[i]= (Double) ((Data) o).getValue();
			i++;
		}
		this.n=this.increment(tabi[0], tabi[1], tabi[2]);

		System.out.println("Operation \""+this.getName()+"\" : on crée un nouveau thread");
		System.out.println("Operation \""+this.getName()+"\" : a "+this.getInput().size()+" entrée(s) et observe "+ this.required.size() +" composant(s)");
		Thread t = new Thread(this);
		t.start();
	}

}
