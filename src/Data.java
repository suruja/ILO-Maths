

import java.util.Collection;
import java.util.Iterator;

public abstract class Data {

	/**
	 * @uml.property  name="value"
	 */
	protected Object value;

	/**
	 * Getter of the property <tt>value</tt>
	 * @return  Returns the value.
	 * @uml.property  name="value"
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * Setter of the property <tt>value</tt>
	 * @param value  The value to set.
	 * @uml.property  name="value"
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	/** 
	 * @uml.property name="componentAsInput"
	 * @uml.associationEnd multiplicity="(0 -1)" inverse="input:Component"
	 * @uml.association name="input"
	 */
	private Collection<Component> componentAsInput;

	/** 
	 * Getter of the property <tt>componentAsInput</tt>
	 * @return  Returns the componentAsInput.
	 * @uml.property  name="componentAsInput"
	 */
	public Collection<Component> getComponentAsInput() {
		return componentAsInput;
	}

	/**
	 * Returns an iterator over the elements in this collection. 
	 * @return  an <tt>Iterator</tt> over the elements in this collection
	 * @see java.util.Collection#iterator()
	 * @uml.property  name="componentAsInput"
	 */
	public Iterator<Component> componentAsInputIterator() {
		return componentAsInput.iterator();
	}

	/**
	 * Returns <tt>true</tt> if this collection contains no elements.
	 * @return  <tt>true</tt> if this collection contains no elements
	 * @see java.util.Collection#isEmpty()
	 * @uml.property  name="componentAsInput"
	 */
	public boolean isComponentAsInputEmpty() {
		return componentAsInput.isEmpty();
	}

	/**
	 * Returns <tt>true</tt> if this collection contains the specified element. 
	 * @param element  whose presence in this collection is to be tested.
	 * @see java.util.Collection#contains(Object)
	 * @uml.property  name="componentAsInput"
	 */
	public boolean containsComponentAsInput(Component component) {
		return componentAsInput.contains(component);
	}

	/**
	 * Returns <tt>true</tt> if this collection contains all of the elements in the specified collection.
	 * @param elements  collection to be checked for containment in this collection.
	 * @see java.util.Collection#containsAll(Collection)
	 * @uml.property  name="componentAsInput"
	 */
	public boolean containsAllComponentAsInput(Collection<?> componentAsInput) {
		return this.componentAsInput.containsAll(componentAsInput);
	}

	/**
	 * Returns the number of elements in this collection.
	 * @return  the number of elements in this collection
	 * @see java.util.Collection#size()
	 * @uml.property  name="componentAsInput"
	 */
	public int componentAsInputSize() {
		return componentAsInput.size();
	}

	/**
	 * Returns all elements of this collection in an array.
	 * @return  an array containing all of the elements in this collection
	 * @see java.util.Collection#toArray()
	 * @uml.property  name="componentAsInput"
	 */
	public Component[] componentAsInputToArray() {
		return (Component[]) componentAsInput
				.toArray(new Component[componentAsInput.size()]);
	}

	/**
	 * Returns an array containing all of the elements in this collection;  the runtime type of the returned array is that of the specified array.
	 * @param a  the array into which the elements of this collection are to be stored.
	 * @return  an array containing all of the elements in this collection
	 * @see java.util.Collection#toArray(Object[])
	 * @uml.property  name="componentAsInput"
	 */
	public Component[] componentAsInputToArray(Component[] componentAsInput) {
		return (Component[]) this.componentAsInput.toArray(componentAsInput);
	}

	/**
	 * Ensures that this collection contains the specified element (optional operation). 
	 * @param element  whose presence in this collection is to be ensured.
	 * @see java.util.Collection#add(Object)
	 * @uml.property  name="componentAsInput"
	 */
	public boolean addComponentAsInput(Component component) {
		return componentAsInput.add(component);
	}

	/** 
	 * Setter of the property <tt>componentAsInput</tt>
	 * @param componentAsInput  the componentAsInput to set.
	 * @uml.property  name="componentAsInput"
	 */
	public void setComponentAsInput(Collection<Component> componentAsInput) {
		this.componentAsInput = componentAsInput;
	}

	/**
	 * Removes a single instance of the specified element from this collection, if it is present (optional operation).
	 * @param element  to be removed from this collection, if present.
	 * @see java.util.Collection#add(Object)
	 * @uml.property  name="componentAsInput"
	 */
	public boolean removeComponentAsInput(Component component) {
		return componentAsInput.remove(component);
	}

	/**
	 * Removes all of the elements from this collection (optional operation).
	 * @see java.util.Collection#clear()
	 * @uml.property  name="componentAsInput"
	 */
	public void clearComponentAsInput() {
		componentAsInput.clear();
	}

	/**
	 * @uml.property  name="componentAsOutput"
	 * @uml.associationEnd  inverse="output:Component"
	 * @uml.association  name="output"
	 */
	private Component componentAsOutput;

	/**
	 * Getter of the property <tt>componentAsOutput</tt>
	 * @return  Returns the componentAsOutput.
	 * @uml.property  name="componentAsOutput"
	 */
	public Component getComponentAsOutput() {
		return componentAsOutput;
	}

	/**
	 * Setter of the property <tt>componentAsOutput</tt>
	 * @param componentAsOutput  The componentAsOutput to set.
	 * @uml.property  name="componentAsOutput"
	 */
	public void setComponentAsOutput(Component componentAsOutput) {
		this.componentAsOutput = componentAsOutput;
	}
	
	public void toString(Data data){		
		if(data.value.getClass() == Integer.class) //Si c'est un entier
			System.out.println((Integer) data.value);
	}

}
