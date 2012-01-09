import java.lang.reflect.Method;



public class OpMaths extends Operation {

	public Method exec_method(String op, Class[] types) throws SecurityException, NoSuchMethodException {
		return Math.class.getDeclaredMethod(op, types);
	}
		
		
}
