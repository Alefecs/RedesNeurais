package Rede;



public class NeuronioSigmoide extends Neuronio{
	
	
	public double ativacao(double[] entradas) {
		double net = somatorio(entradas);
		
		net = 1/(1 + Math.pow(Math.E, -net)  );
		
		return net;
	}

}
