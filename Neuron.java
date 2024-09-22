
public class Neuron {
	
	double[] c;
	double[] b;
	double l;

	public Neuron(int n, double l) {
		c = new double[n];
		b = new double[n];
		this.l = l;
		for (int i = 0; i < n; i++) {
			c[i] = 1.0; 
			b[i] = l/(l-1+n);
		}
		
	}
	
	public double getY(int[] x) {
		double scalar = 0;
		for (int i = 0; i < x.length; i++) {
			scalar += b[i]*x[i];
		}
		return scalar;
	}
	
	public double getMetric(int[] x) {
		double scalar1 = 0;
		double scalar2 = 0;
		for (int i = 0; i < x.length; i++) {
			scalar1 += c[i]*x[i];
			scalar2 += x[i];
		}
		double scalar = scalar1/scalar2;
		return Double.isNaN(scalar) ? 1 : scalar;
		
	}

	public void recalc(int[] x) {
		int scalar = 0;
		for (int i = 0; i < c.length; i++) {
			scalar += c[i]*x[i];
		}
		for (int i = 0; i < c.length; i++) {
			b[i] = (l*c[i]*x[i])/(l-1+scalar);
			c[i] = c[i]*x[i];
		}
	}
}
