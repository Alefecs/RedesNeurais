package Rede;

public class NeuronioTangente extends Neuronio{
	
	public double ativacao(double[] entradas) {
		double net = somatorio(entradas);
		
		net = (Math.pow(Math.E, net) - Math.pow(Math.E, -net))/(Math.pow(Math.E, net) + Math.pow(Math.E, -net));
		
		return net;
	}

}
