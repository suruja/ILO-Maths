import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Observable;



public class OpProdCons extends Operation {

	private ArrayList<Number> table = new ArrayList<Number>();
	
	public ArrayList<Number> buffer(double a){
		this.table.add(a);
		return this.table;
	}
	
}
