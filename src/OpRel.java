
public class OpRel extends Operation {
	public boolean equality(int a, int b) {
		return a==b;
	}
	
	public boolean equality(float a, float b) {
		return a==b;
	}
	
	public boolean equality(double a, double b) {
		return a==b;
	}
	
	public boolean greater(int a, int b) {
		return a>=b;
	}
	
	public boolean greater(float a, float b) {
		return a>=b;
	}
	
	public boolean greater(double a, double b) {
		return a>=b;
	}
	
	public boolean lower(int a, int b) {
		return a<=b;
	}
	
	public boolean lower(float a, float b) {
		return a<=b;
	}
	
	public boolean lower(double a, double b) {
		return a<=b;
	}
	
	public boolean strictly_greater(int a, int b) {
		return a>b;
	}
	
	public boolean strictly_greater(float a, float b) {
		return a>b;
	}
	
	public boolean strictly_greater(double a, double b) {
		return a>b;
	}
	
	public boolean strictly_lower(int a, int b) {
		return a<b;
	}
	
	public boolean strictly_lower(float a, float b) {
		return a<b;
	}
	
	public boolean strictly_lower(double a, double b) {
		return a<b;
	}
}
