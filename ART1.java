import java.util.ArrayList;

public class ART1 {
	
	ArrayList<Neuron> neurons = new ArrayList<Neuron>();
	
	int n;
	double l;
	double r;

	public ART1(int n, double l, double r) {
		this.n = n;
		this.l = l;
		this.r = r;
		createQualif();
	}
	
	public int getNeuron(int[] x) {
		double maxY = -1;
		int maxNeuronId = 0;
		for (int i = 0; i < neurons.size(); i++) {
			double y = neurons.get(i).getY(x);
			if (y > maxY) {
				maxY = y;
				maxNeuronId = i;
			}
		}
//		if (maxNeuronId < neurons.size()-1) {
//			System.out.println(neurons.get(maxNeuronId).getMetric(x)+" "+r);
//		}
		if (neurons.get(maxNeuronId).getMetric(x) >= r) {
			neurons.get(maxNeuronId).recalc(x);
			if (maxNeuronId == neurons.size()-1) {
				createQualif();
			}
			return maxNeuronId;
		} else {
			//System.out.println("это случилось? "+maxNeuronId+" "+(neurons.size()-1)+" ");
			neurons.get(neurons.size()-1).recalc(x);
			createQualif();
			return neurons.size()-2;
		}
	}
	
	private void createQualif() {
		neurons.add(new Neuron(n,l));
	}

}
