

import java.util.Observable;
import java.util.Observer;
import java.util.Collection;
import java.util.Iterator;


public abstract class Component extends Observable implements Observer {

	/** 
	 * @uml.property name="input"
	 * @uml.associationEnd multiplicity="(0 -1)" inverse="componentAsInput:Data"
	 * @uml.association name="input"
	 */
	private Collection<Data> input;

	/** 
	 * Getter of the property <tt>input</tt>
	 * @return  Returns the input.
	 * @uml.property  name="input"
	 */
	public Collection<Data> getInput() {
		return input;
	}

	/**
	 * Returns an iterator over the elements in this collection. 
	 * @return  an <tt>Iterator</tt> over the elements in this collection
	 * @see java.util.Collection#iterator()
	 * @uml.property  name="input"
	 */
	public Iterator<Data> inputIterator() {
		return input.iterator();
	}

	/**
	 * Returns <tt>true</tt> if this collection contains no elements.
	 * @return  <tt>true</tt> if this collection contains no elements
	 * @see java.util.Collection#isEmpty()
	 * @uml.property  name="input"
	 */
	public boolean isInputEmpty() {
		return input.isEmpty();
	}

	/**
	 * Returns <tt>true</tt> if this collection contains the specified element. 
	 * @param element  whose presence in this collection is to be tested.
	 * @see java.util.Collection#contains(Object)
	 * @uml.property  name="input"
	 */
	public boolean containsInput(Data data) {
		return input.contains(data);
	}

	/**
	 * Returns <tt>true</tt> if this collection contains all of the elements in the specified collection.
	 * @param elements  collection to be checked for containment in this collection.
	 * @see java.util.Collection#containsAll(Collection)
	 * @uml.property  name="input"
	 */
	public boolean containsAllInput(Collection<?> input) {
		return this.input.containsAll(input);
	}

	/**
	 * Returns the number of elements in this collection.
	 * @return  the number of elements in this collection
	 * @see java.util.Collection#size()
	 * @uml.property  name="input"
	 */
	public int inputSize() {
		return input.size();
	}

	/**
	 * Returns all elements of this collection in an array.
	 * @return  an array containing all of the elements in this collection
	 * @see java.util.Collection#toArray()
	 * @uml.property  name="input"
	 */
	public Data[] inputToArray() {
		return (Data[]) input.toArray(new Data[input.size()]);
	}

	/**
	 * Returns an array containing all of the elements in this collection;  the runtime type of the returned array is that of the specified array.
	 * @param a  the array into which the elements of this collection are to be stored.
	 * @return  an array containing all of the elements in this collection
	 * @see java.util.Collection#toArray(Object[])
	 * @uml.property  name="input"
	 */
	public Data[] inputToArray(Data[] input) {
		return (Data[]) this.input.toArray(input);
	}

	/**
	 * Ensures that this collection contains the specified element (optional operation). 
	 * @param element  whose presence in this collection is to be ensured.
	 * @see java.util.Collection#add(Object)
	 * @uml.property  name="input"
	 */
	public boolean addInput(Data data) {
		return input.add(data);
	}

	/** 
	 * Setter of the property <tt>input</tt>
	 * @param input  the input to set.
	 * @uml.property  name="input"
	 */
	public void setInput(Collection<Data> input) {
		this.input = input;
	}

	/**
	 * Removes a single instance of the specified element from this collection, if it is present (optional operation).
	 * @param element  to be removed from this collection, if present.
	 * @see java.util.Collection#add(Object)
	 * @uml.property  name="input"
	 */
	public boolean removeInput(Data data) {
		return input.remove(data);
	}

	/**
	 * Removes all of the elements from this collection (optional operation).
	 * @see java.util.Collection#clear()
	 * @uml.property  name="input"
	 */
	public void clearInput() {
		input.clear();
	}

	/**
	 * @uml.property  name="output"
	 * @uml.associationEnd  multiplicity="(0 -1)" inverse="componentAsOutput:Data"
	 * @uml.association  name="output"
	 */
	protected Collection<Data> output;

	/**
	 * Getter of the property <tt>output</tt>
	 * @return  Returns the output.
	 * @uml.property  name="output"
	 */
	public Collection<Data> getOutput() {
		return output;
	}
	public Data getLastOutput(int i) {
		return (Data) output.toArray()[i];
	}

	/**
	 * Returns an iterator over the elements in this collection. 
	 * @return  an <tt>Iterator</tt> over the elements in this collection
	 * @see java.util.Collection#iterator()
	 * @uml.property  name="output"
	 */
	public Iterator<Data> outputIterator() {
		return output.iterator();
	}

	/**
	 * Returns <tt>true</tt> if this collection contains no elements.
	 * @return  <tt>true</tt> if this collection contains no elements
	 * @see java.util.Collection#isEmpty()
	 * @uml.property  name="output"
	 */
	public boolean isOutputEmpty() {
		return output.isEmpty();
	}

	/**
	 * Returns <tt>true</tt> if this collection contains the specified element. 
	 * @param element  whose presence in this collection is to be tested.
	 * @see java.util.Collection#contains(Object)
	 * @uml.property  name="output"
	 */
	public boolean containsOutput(Data data) {
		return output.contains(data);
	}

	/**
	 * Returns <tt>true</tt> if this collection contains all of the elements in the specified collection.
	 * @param elements  collection to be checked for containment in this collection.
	 * @see java.util.Collection#containsAll(Collection)
	 * @uml.property  name="output"
	 */
	public boolean containsAllOutput(Collection<?> output) {
		return this.output.containsAll(output);
	}

	/**
	 * Returns the number of elements in this collection.
	 * @return  the number of elements in this collection
	 * @see java.util.Collection#size()
	 * @uml.property  name="output"
	 */
	public int outputSize() {
		return output.size();
	}

	/**
	 * Returns all elements of this collection in an array.
	 * @return  an array containing all of the elements in this collection
	 * @see java.util.Collection#toArray()
	 * @uml.property  name="output"
	 */
	public Data[] outputToArray() {
		return (Data[]) output.toArray(new Data[output.size()]);
	}

	/**
	 * Returns an array containing all of the elements in this collection;  the runtime type of the returned array is that of the specified array.
	 * @param a  the array into which the elements of this collection are to be stored.
	 * @return  an array containing all of the elements in this collection
	 * @see java.util.Collection#toArray(Object[])
	 * @uml.property  name="output"
	 */
	public Data[] outputToArray(Data[] output) {
		return (Data[]) this.output.toArray(output);
	}

	/**
	 * Ensures that this collection contains the specified element (optional operation). 
	 * @param element  whose presence in this collection is to be ensured.
	 * @see java.util.Collection#add(Object)
	 * @uml.property  name="output"
	 */
	public boolean addOutput(Data data) {
		return output.add(data);
	}

	/**
	 * Setter of the property <tt>output</tt>
	 * @param output  the output to set.
	 * @uml.property  name="output"
	 */
	public void setOutput(Collection<Data> output) {
		this.output = output;
	}

	/**
	 * Removes a single instance of the specified element from this collection, if it is present (optional operation).
	 * @param element  to be removed from this collection, if present.
	 * @see java.util.Collection#add(Object)
	 * @uml.property  name="output"
	 */
	public boolean removeOutput(Data data) {
		return output.remove(data);
	}

	/**
	 * Removes all of the elements from this collection (optional operation).
	 * @see java.util.Collection#clear()
	 * @uml.property  name="output"
	 */
	public void clearOutput() {
		output.clear();
	}

	/**
	 * @uml.property  name="macro"
	 * @uml.associationEnd  inverse="components:Macro"
	 */
	private Macro macro;

	/**
	 * Getter of the property <tt>macro</tt>
	 * @return  Returns the macro.
	 * @uml.property  name="macro"
	 */
	public Macro getMacro() {
		return macro;
	}

	/**
	 * Setter of the property <tt>macro</tt>
	 * @param macro  The macro to set.
	 * @uml.property  name="macro"
	 */
	public void setMacro(Macro macro) {
		this.macro = macro;
	}
	
	public void printLastOutput(){
		Iterator<Data> it = this.outputIterator();
		if(it.hasNext()){
			System.out.println("on va afficher une variable");
			System.out.println(it.next().value);
		}
	}
	
	public static void main(String[] args){
		System.out.print("Hey coucou!");
		 
		/**** Initialisation ****/
		OpProd d1 = new OpProd(2);
		OpProd d2 = new OpProd(3);
		OpMaths e = new OpMaths(d1,d2);
		OpCons c = new OpCons(e);
		
		/**** Mise en place des Observers ****/
		d1.addObserver(e);//e observe d1
		d2.addObserver(e);//e observe d2
		e.addObserver(c);//c observe e
		
		d1.prod();
		e.update(d1, d1.getLastOutput(0) );
		e.update(d2, d2.getLastOutput(0) );
		
		
		System.out.println("On affiche les deux dernière valeurs : ");
		d1.printLastOutput();
		d2.printLastOutput();
		
		e.run();

	}

}
