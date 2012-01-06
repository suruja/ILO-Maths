import java.util.ArrayList;
import java.util.Observable;



public class OpMaths extends Operation {

	@Override
	public void update(Observable o, Object arg) {
		System.out.print("appel d'updateOpMaths : ");
		Data p = (Data) arg;
		System.out.println(p.value);
		
	}
	public OpMaths(){
		this.output = new ArrayList<Data>();
	}
	
	public OpMaths(Operation d1, Operation d2) {
		this.output = new ArrayList<Data>();
		// TODO Auto-generated constructor stub
	}
	
	public Integer calcul(){
		Class<? extends Object> a = this.getLastOutput(0).value.getClass();
		Class<? extends Object> b = this.getLastOutput(1).value.getClass();
		
		if(a==b){
			if(a== Integer.class)
				return (Integer) this.getLastOutput(0).value + (Integer) this.getLastOutput(1).value;
		}
		return null;
		
	}
	
	public void run() {
		System.out.println("On a lancé le thread OpMaths");
		while(true){
			try {
				this.wait();
			} catch (InterruptedException e) {
				//On avertit les observateurs que l'heure a été mise à jour !
				this.notifyObservers(this.calcul());
			}
		}
	}
	

}
