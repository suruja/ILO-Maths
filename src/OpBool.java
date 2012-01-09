public class OpBool extends Operation {

	public boolean equality(boolean a, boolean b) {
		return a==b;
	}
	
	public boolean and(boolean a, boolean b) {
		return a && b;
	}
	
	public boolean or(boolean a, boolean b) {
		return a || b;
	}
	
	public boolean not(boolean a) {
		return ! a;
	}
}
