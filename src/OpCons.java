import java.util.ArrayList;
import java.util.Observable;



public class OpCons extends Operation {

	@Override
	public synchronized void update(Observable o, Object arg) {
		System.out.print("OpCons : On a été notifié donc on affiche le resultat : ");
		//Data p = (Data) arg;
		//arg.toString();
		int pwet = (Integer) arg; //On suppose pour le test que c'est un integer
		System.out.println(pwet);
		
	}
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
	}

}
