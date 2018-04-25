package Rede;



public class NeuronioLinear extends Neuronio{
	

	public double ativacao(double[] entradas) {
		double net = somatorio(entradas);
		
		return net;
	}
	
	public double attPeso(double pesoAntigo,double entrada,double taxaDeAprendizagem) {
		
		return 0.0;
	}
	
}
