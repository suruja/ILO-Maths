import java.util.ArrayList;
import java.util.Observable;



public class OpProd extends Operation {

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
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

}
