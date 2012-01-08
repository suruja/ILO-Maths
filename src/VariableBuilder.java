

public class VariableBuilder extends Operation {
	
	public Integer[] increment(Integer a, Integer b, Integer p) {
		Integer[] n = new Integer[(b-a)/p];
		int j = 0;
		for(int i=a; i<b; i+=p) {
			n[j] = i;
			j++;
		}
		return n;
	}
}
