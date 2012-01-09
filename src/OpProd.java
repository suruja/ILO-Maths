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
		int i=0;
		int n=1;
		
		//if(this.getName()=="produit")	n=1;
		while(i<n){ //On effectue la boucle qu'une seule fois pour le moment
			for( Data d : this.arguments.values()){
			try {
				if(i==0){
					for( Data x : this.arguments.values()){ this.addInput(x);}
				}
				else{
					this.addInput(d);	//Même procédure qu'un composant
				}
				
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
		n=this.arguments.values().size();
		System.out.println("Taille du tableau : "+n);
		}
		}
	}
	public double produit(double a){
		return a;
	}
	public double produit(double a, double b, double c){
		double[] n = new double[100]; 
		n=this.increment(a,b,c);
		int i=0;
		System.out.println("On crée le tableau des valeurs "+n[4]+n[5]+n[6]);
		for( Data d : this.arguments.values()){ d.setValue(n[i]);i++;System.out.println(n[i]);}
		return a;
	}
	
	public double[] increment(double a, double b, double p) {
		System.out.println("pppppppppppppppppppppppppp");
		int m = (int) ((b-a)/p);
		this.argument_count = m;
		double[] n = new double[m];
		int j = 0;
		for(double i=a; i<b; i+=p) {
			System.out.println("i="+i+";a="+a+";b="+b+"p="+p);
			n[j] = i;
			j++;
		}
		System.out.println("Taille entre "+a+" et "+b+" avec un pas de "+p+" et donc une taille de "+j);
		return n;
	}

}
