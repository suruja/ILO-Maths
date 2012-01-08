import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Observable;



public class Operation extends Component {
	private String name;
	private ArrayList<Observable> required;
	
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
		this.name = "";
		this.setInput(new ArrayList<Data>());
		this.setOutput(new ArrayList<Data>());
		this.required = new ArrayList<Observable>();
	}
	
	
	public synchronized void set(String op, Object[] obj) {
		this.name = op;
		for(Object o : obj) {
			if(o instanceof Data) this.addInput((Data) o);
			else if(o instanceof Component) {
				((Component) o).addObserver(this);
				this.required.add((Observable) o);
			}
		}
		System.out.println("Operation \""+this.getName()+"\" : a déjà "+this.getInput().size()+" entrée(s) et observe "+ this.required.size() +" composant(s)");
		Thread t = new Thread(this);
		t.start();
	}
	
	public void eval(String op) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		String res = this.getName() + "(";
		int n = this.getInput().size();
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

	
	@Override
	public synchronized void update(Observable o, Object arg) {
		//setVar((Data) arg);
		try {
			for(Data d : (Iterable<Data>)arg) {
				this.addInput(d);
				System.out.println("Operation \""+this.getName()+"\" : résultat de \""+ ((Operation) o).getName() +"\" obtenu et vaut " + d.getValue());
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.notify();
		//arg.toString();
		//System.out.println((Data)arg.value);
	}
	
	/*public Integer calcul(){
		//Class<? extends Object> a = this.getLastOutput(0).value.getClass();
		//Class<? extends Object> b = this.getLastOutput(1).value.getClass();
		
		if(var1.value.getClass()==var2.value.getClass()){ //S'ils ont le même type
			if(var1.value.getClass()== Integer.class){ //Si ce sont deux entiers
				int i = (Integer) var1.value + (Integer) var2.value;
				//System.out.print("Operation \""+this.getName()+"\" : On renvoie : ");
				//System.out.println(i);
				return i;
			}
			else
				System.out.println("Ce ne sont pas des entiers!");
		}
		else
			System.out.println("Les deux variables ne sont pas de même type!");
		
		return null;
		
	}*/
	
	public synchronized void run() {
		System.out.println("Operation \""+this.getName()+"\" : on crée un nouveau thread");

		try {
			for(Observable r : this.required) {
				if(((Component) r).isOutputEmpty()) {
					System.out.println("Operation \""+this.getName()+"\" : on attend \""+ ((Operation) r).getName() +"\"");
					this.wait();
				}
				else {
					System.out.println("Operation \""+this.getName()+"\" : on a déjà \""+((Operation) r).getName()+"\"");
					for(Data d : ((Component) r).getOutput()) {
						this.addInput(d);
					}
				}
			}
			this.eval(this.name);
			this.setChanged();
			this.notifyObservers(this.getOutput());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
