import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;



public class Operation extends Component {
	protected String name = "";
	protected ArrayList<Observable> required = new ArrayList<Observable>();
	protected HashMap<Object, Data> arguments = new HashMap<Object, Data>();
	protected Integer argument_count = 0;
	protected Integer current_argument_count = 0;
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public ArrayList<Observable> getRequired() {
		return required;
	}


	public void setRequired(ArrayList<Observable> required) {
		this.required = required;
	}


	public Operation(){
		this.setInput(new ArrayList<Data>());
		this.setOutput(new ArrayList<Data>());
	}
	
	
	public synchronized void set(String op, Object[] obj) {
		this.name = op;
		this.argument_count = obj.length;
		this.current_argument_count = this.argument_count;
		int i = 0;
		for(Object o : obj) {
			if(o instanceof Data) {
				this.arguments.put(o, (Data) o);
				this.current_argument_count--;
			}
			else if(o instanceof Component) {
				((Component) o).addObserver(this);
				this.required.add((Observable) o);
				this.arguments.put(o, null);
			}
			i++;
		}
		System.out.println("Operation \""+this.getName()+"\" : on crée un nouveau thread");
		System.out.println("Operation \""+this.getName()+"\" : a "+this.getInput().size()+" entrée(s) et observe "+ this.required.size() +" composant(s)");
		Thread t = new Thread(this);
		t.start();
	}
	
	public Method exec_method(String op, Class[] types) throws SecurityException, NoSuchMethodException {
		return this.getClass().getDeclaredMethod(op, types);
	}
	
	public synchronized void eval(String op) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		this.getOutput().clear();
		String res = this.getName() + "(";
		int n = this.getInput().size();
		@SuppressWarnings("rawtypes")
		Class[] types = new Class[n];
		Object[] params = new Object[n];
		int i = 0;
		for(Data d : this.getInput()) {
			types[i] = d.getValue().getClass();
			if(types[i] == Integer.class) types[i] = int.class;
			else if(types[i] == Float.class) types[i] = float.class;
			else if(types[i] == Double.class) types[i] = double.class;
			else if(types[i] == Long.class) types[i] = long.class;
			else if(types[i] == Boolean.class) types[i] = boolean.class;
			params[i] = d.getValue();
			res += params[i];
			i++;
			if(i!=n) res += ", ";
		}
		res += ") = ";
		Method method;
		method = this.exec_method(op, types);
		this.addOutput(new SF(method.invoke(this, params)));
		i = 0;
		n = this.getOutput().size();
		for(Data d : this.getOutput()) {
			res += d.getValue();
			i++;
			if(i!=n) res += ", ";
		}
		System.out.println(res);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public synchronized void update(Observable o, Object arg) {
		try {
			for(Data d : (Iterable<Data>)arg) {
				this.arguments.put(o, d);
				System.out.println("Operation \""+this.getName()+"\" : résultat de \""+ ((Operation) o).getName() +"\" obtenu et vaut " + d.getValue());
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		this.notify();
	}
	
	public synchronized void run() {
		int i;
		try {
			while(true) {
				for(i=0 ; i<this.current_argument_count ; i++){
					this.wait();//On attend de récupérer toutes nos données
				}
				for( Data d : this.arguments.values()) this.addInput(d);//Une fois qu'elles sont récupérées, on les met dans Input
				this.eval(this.name);//On execute le calcul et on met le résultat dans Output
				this.setChanged();
				this.notifyObservers(this.getOutput());//On préviens les autres que le calcul a été exectué
				
				this.getInput().clear();//On nettoie le input()
				this.getOutput().clear();//On nettoie le output()
				this.required.clear();
				this.current_argument_count = this.argument_count; //On remet à jour le compteur
			}
			
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
	}

}
