

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MF extends Data {

	/**
	 * @uml.property  name="data"
	 * @uml.associationEnd  multiplicity="(0 -1)" ordering="true" inverse="mF:Data"
	 */
	private List<Data> data;

	/**
	 * Getter of the property <tt>data</tt>
	 * @return  Returns the data.
	 * @uml.property  name="data"
	 */
	public List<Data> getData() {
		return data;
	}

	/**
	 * Returns the element at the specified position in this List<Data>.
	 * @param index  index of element to return.
	 * @return  the element at the specified position in this List<Data>.
	 * @see java.util.List<Data>#get(int)
	 * @uml.property  name="data"
	 */
	public Data getData(int i) {
		return (Data) data.get(i);
	}

	/**
	 * Returns an iterator over the elements in this List<Data> in proper sequence.
	 * @return  an iterator over the elements in this List<Data> in proper sequence.
	 * @see java.util.List<Data>#iterator()
	 * @uml.property  name="data"
	 */
	public Iterator dataIterator() {
		return data.iterator();
	}

	/**
	 * Returns <tt>true</tt> if this List<Data> contains no elements.
	 * @return  <tt>true</tt> if this List<Data> contains no elements.
	 * @see java.util.List<Data>#isEmpty()
	 * @uml.property  name="data"
	 */
	public boolean isDataEmpty() {
		return data.isEmpty();
	}

	/**
	 * Returns <tt>true</tt> if this List<Data> contains the specified element.
	 * @param element  element whose presence in this List<Data> is to be tested.
	 * @return  <tt>true</tt> if this List<Data> contains the specified element.
	 * @see java.util.List<Data>#contains(Object)
	 * @uml.property  name="data"
	 */
	public boolean containsData(Data data) {
		return this.data.contains(data);
	}

	/**
	 * Returns <tt>true</tt> if this List<Data> contains all of the elements of the specified collection.
	 * @param elements  collection to be checked for containment in this List<Data>.
	 * @return  <tt>true</tt> if this List<Data> contains all of the elements of the specified collection.
	 * @see java.util.List<Data>#containsAll(Collection)
	 * @uml.property  name="data"
	 */
	public boolean containsAllData(Collection data) {
		return this.data.containsAll(data);
	}

	/**
	 * Returns the number of elements in this List<Data>.
	 * @return  the number of elements in this List<Data>.
	 * @see java.util.List<Data>#size()
	 * @uml.property  name="data"
	 */
	public int dataSize() {
		return data.size();
	}

	/**
	 * Returns an array containing all of the elements in this List<Data> in proper sequence.
	 * @return  an array containing all of the elements in this List<Data> in proper sequence.
	 * @see java.util.List<Data>#toArray()
	 * @uml.property  name="data"
	 */
	public Data[] dataToArray() {
		return (Data[]) data.toArray(new Data[data.size()]);
	}

	/**
	 * Returns an array containing all of the elements in this List<Data> in proper sequence; the runtime type of the returned array is that of the specified array.
	 * @param a  the array into which the elements of this List<Data> are to be stored.
	 * @return  an array containing all of the elements in this List<Data> in proper sequence.
	 * @see java.util.List<Data>#toArray(Object[])
	 * @uml.property  name="data"
	 */
	public Data[] dataToArray(Data[] data) {
		return (Data[]) this.data.toArray(data);
	}

	/**
	 * Inserts the specified element at the specified position in this List<Data> (optional operation)
	 * @param index  index at which the specified element is to be inserted.
	 * @param element  element to be inserted.
	 * @see java.util.List<Data>#add(int,Object)
	 * @uml.property  name="data"
	 */
	public void addData(int index, Data data) {
		this.data.add(index, data);
	}

	/**
	 * Appends the specified element to the end of this List<Data> (optional operation).
	 * @param element  element to be appended to this List<Data>.
	 * @return  <tt>true</tt> (as per the general contract of the <tt>Collection.add</tt> method).
	 * @see java.util.List<Data>#add(Object)
	 * @uml.property  name="data"
	 */
	public boolean addData(Data data) {
		return this.data.add(data);
	}

	/**
	 * Removes the element at the specified position in this List<Data> (optional operation).
	 * @param index  the index of the element to removed.
	 * @return  the element previously at the specified position.
	 * @see java.util.List<Data>#remove(int)
	 * @uml.property  name="data"
	 */
	public Object removeData(int index) {
		return data.remove(index);
	}

	/**
	 * Removes the first occurrence in this List<Data> of the specified element  (optional operation).
	 * @param element  element to be removed from this List<Data>, if present.
	 * @return  <tt>true</tt> if this List<Data> contained the specified element.
	 * @see java.util.List<Data>#remove(Object)
	 * @uml.property  name="data"
	 */
	public boolean removeData(Data data) {
		return this.data.remove(data);
	}

	/**
	 * Removes all of the elements from this List<Data> (optional operation).
	 * @see java.util.List<Data>#clear()
	 * @uml.property  name="data"
	 */
	public void clearData() {
		data.clear();
	}

	/**
	 * Setter of the property <tt>data</tt>
	 * @param data  the data to set.
	 * @uml.property  name="data"
	 */
	public void setData(List<Data> data) {
		this.data = data;
	}

}
