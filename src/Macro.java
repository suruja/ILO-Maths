

import java.util.Collection;
import java.util.Iterator;
import java.util.Observable;

public class Macro extends Component{

	/**
	 * @uml.property  name="components"
	 * @uml.associationEnd  multiplicity="(0 -1)" inverse="macro:Component"
	 */
	private Collection<Component> components;

	/**
	 * Getter of the property <tt>components</tt>
	 * @return  Returns the components.
	 * @uml.property  name="components"
	 */
	public Collection<Component> getComponents() {
		return components;
	}

	/**
	 * Returns an iterator over the elements in this collection. 
	 * @return  an <tt>Iterator</tt> over the elements in this collection
	 * @see java.util.Collection#iterator()
	 * @uml.property  name="components"
	 */
	public Iterator<Component> componentsIterator() {
		return components.iterator();
	}

	/**
	 * Returns <tt>true</tt> if this collection contains no elements.
	 * @return  <tt>true</tt> if this collection contains no elements
	 * @see java.util.Collection#isEmpty()
	 * @uml.property  name="components"
	 */
	public boolean isComponentsEmpty() {
		return components.isEmpty();
	}

	/**
	 * Returns <tt>true</tt> if this collection contains the specified element. 
	 * @param element  whose presence in this collection is to be tested.
	 * @see java.util.Collection#contains(Object)
	 * @uml.property  name="components"
	 */
	public boolean containsComponents(Component component) {
		return components.contains(component);
	}

	/**
	 * Returns <tt>true</tt> if this collection contains all of the elements in the specified collection.
	 * @param elements  collection to be checked for containment in this collection.
	 * @see java.util.Collection#containsAll(Collection)
	 * @uml.property  name="components"
	 */
	public boolean containsAllComponents(Collection<?> components) {
		return this.components.containsAll(components);
	}

	/**
	 * Returns the number of elements in this collection.
	 * @return  the number of elements in this collection
	 * @see java.util.Collection#size()
	 * @uml.property  name="components"
	 */
	public int componentsSize() {
		return components.size();
	}

	/**
	 * Returns all elements of this collection in an array.
	 * @return  an array containing all of the elements in this collection
	 * @see java.util.Collection#toArray()
	 * @uml.property  name="components"
	 */
	public Component[] componentsToArray() {
		return (Component[]) components
				.toArray(new Component[components.size()]);
	}

	/**
	 * Returns an array containing all of the elements in this collection;  the runtime type of the returned array is that of the specified array.
	 * @param a  the array into which the elements of this collection are to be stored.
	 * @return  an array containing all of the elements in this collection
	 * @see java.util.Collection#toArray(Object[])
	 * @uml.property  name="components"
	 */
	public Component[] componentsToArray(Component[] components) {
		return (Component[]) this.components.toArray(components);
	}

	/**
	 * Ensures that this collection contains the specified element (optional operation). 
	 * @param element  whose presence in this collection is to be ensured.
	 * @see java.util.Collection#add(Object)
	 * @uml.property  name="components"
	 */
	public boolean addComponents(Component component) {
		return components.add(component);
	}

	/**
	 * Setter of the property <tt>components</tt>
	 * @param components  the components to set.
	 * @uml.property  name="components"
	 */
	public void setComponents(Collection<Component> components) {
		this.components = components;
	}

	/**
	 * Removes a single instance of the specified element from this collection, if it is present (optional operation).
	 * @param element  to be removed from this collection, if present.
	 * @see java.util.Collection#add(Object)
	 * @uml.property  name="components"
	 */
	public boolean removeComponents(Component component) {
		return components.remove(component);
	}

	/**
	 * Removes all of the elements from this collection (optional operation).
	 * @see java.util.Collection#clear()
	 * @uml.property  name="components"
	 */
	public void clearComponents() {
		components.clear();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
