

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
		return this.value;
		/*		if(this.value instanceof Integer)
		 return ((Integer) value).intValue();
		 else if(this.value instanceof Float)
		 return ((Float) value).floatValue();
		 else if(this.value instanceof Double)
		 return ((Double) value).doubleValue();
		 else return (Number)value;*/
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
