import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;



public class Operation extends Component {
	private String name = "";
	private ArrayList<Observable> required = new ArrayList<Observable>();
	private HashMap<Object, Data> arguments = new HashMap<Object, Data>();
	private Integer var_count = 0;
	
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
		this.var_count = obj.length;
		int i = 0;
		for(Object o : obj) {
			if(o instanceof Data) this.arguments.put(o, (Data) o);
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
	
	public synchronized void eval(String op) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		String res = this.getName() + "(";
		int n = this.getInput().size();
		@SuppressWarnings("rawtypes")
		Class[] types = new Class[n];
		Object[] params = new Object[n];
		int i = 0;
		for(Data d : this.getInput()) {
			types[i] = d.getValue().getClass();
			params[i] = d.getValue();
			res += params[i];
			i++;
			if(i!=n) res += ", ";
		}
		res += ") = ";
		Method method = this.getClass().getDeclaredMethod(op, types);
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
				this.var_count--;
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
		try {
			for(Observable r : this.required) {
				synchronized(this) {
					if(this.var_count != 0) {
						if(((Component) r).isOutputEmpty()) {
							System.out.println("Operation \""+this.getName()+"\" : on attend \""+ ((Operation) r).getName() +"\"");
							this.wait();
						}
						else {
							System.out.println("Operation \""+this.getName()+"\" : on a déjà \""+((Operation) r).getName()+"\"");
							for(Data d : ((Component) r).getOutput()) {
								this.arguments.put(r, d);
								this.var_count--;
							}
						}
					}
				}
			}
			for( Data d : this.arguments.values()) this.addInput(d);
			this.eval(this.name);
			this.setChanged();
			this.notifyObservers(this.getOutput());
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
