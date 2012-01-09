

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
/*
	public void toString(Data data){		
		if(data.value.getClass() == Integer.class) //Si c'est un entier
			System.out.println((Integer) data.value);
	}*/

	/**
	 * @uml.property  name="mF"
	 * @uml.associationEnd  aggregation="composite" inverse="data:MF"
	 */
	private MF mf;

	/**
	 * Getter of the property <tt>mF</tt>
	 * @return  Returns the mf.
	 * @uml.property  name="mF"
	 */
	public MF getMF() {
		return mf;
	}

	/**
	 * Setter of the property <tt>mF</tt>
	 * @param mF  The mf to set.
	 * @uml.property  name="mF"
	 */
	public void setMF(MF mf) {
		this.mf = mf;
	}

}
