import java.util.ArrayList;
import java.util.Observable;



public class OpMaths extends Operation {

	private Data var1;
	private Data var2;
	private int cpt=0;
	
	@Override
	public synchronized void update(Observable o, Object arg) {
		System.out.println("OpMaths : On a été notifiés donc update : ");
		setVar((Data) arg);
		this.notify();
		arg.toString();
		//System.out.println((Data)arg.value);
		
	}
	private void setVar(Data arg) {
		if(cpt==0){
			var1 = arg;
			cpt++;
		}
		else{
			var2 = arg;
			cpt=0;
		}	
	}
	
	public OpMaths(){
		this.output = new ArrayList<Data>();
		Thread t = new Thread(this);
		t.start();
	}
	
	public OpMaths(Operation d1, Operation d2) {
		this.output = new ArrayList<Data>();
		Thread t = new Thread(this);
		t.start();
	}
	
	public Integer calcul(){
		//Class<? extends Object> a = this.getLastOutput(0).value.getClass();
		//Class<? extends Object> b = this.getLastOutput(1).value.getClass();
		
		if(var1.value.getClass()==var2.value.getClass()){ //S'ils ont le même type
			if(var1.value.getClass()== Integer.class){ //Si ce sont deux entiers
				int i = (Integer) var1.value + (Integer) var2.value;
				//System.out.print("OpMaths : On renvoie : ");
				//System.out.println(i);
				return i;
			}
			else
				System.out.println("Ce ne sont pas des entiers!");
		}
		else
			System.out.println("Les deux variables ne sont pas de même type!");
		
		return null;
		
	}
	
	public synchronized void run() {
		System.out.println("OpMaths : On a lancé le thread");
		while(true){
			try {
				System.out.println("OpMaths : On attend");
				this.wait();
				System.out.println("OpMaths : Première interruption de l'attente, on attend encore");
				this.wait();
				System.out.println("OpMaths : Deuxième interruption de l'attente, on a les deux variables, on notifie le calcul");
				this.setChanged();
				this.notifyObservers(this.calcul());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	

}
