import java.util.ArrayList;
import java.util.Observable;



public class OpCons extends Operation {

	@Override
	public void update(Observable o, Object arg) {
		Data p = (Data) arg;
		System.out.println("On update!");
		System.out.println(p.value);
		
	}
	public OpCons(){
		this.output = new ArrayList<Data>();
		
	}
	
	public OpCons(Operation e) {
		this.output = new ArrayList<Data>();
		
	}
	public void print(){
		
	}

}
