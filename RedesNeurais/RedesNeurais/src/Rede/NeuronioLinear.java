package Rede;



public class NeuronioLinear extends Neuronio{
	

	public double ativacao(double[] entradas) {
		double net = somatorio(entradas);
		
		return net;
	}
	
	public void atualizacaoPadraoDePeso(double[] entrada,double alpha,double saidaDesejada,double saidaCalculada ) {
		//alpha é a taxa de aprendizagem da rede
		
		double derivadaLinear = 1;
		pesos[0] = pesos[0] + alpha * (saidaDesejada - saidaCalculada)*derivadaLinear;
		
		for(int i = 1 ; i < pesos.length;i++) 
			pesos[i] = pesos[i] + alpha * (saidaDesejada - saidaCalculada)*entrada[i - 1]*derivadaLinear;	
	}
	/*
	public double attPesoBatch(double[] entrada,double taxaDeAprendizagem) {
		
	}*/
	
}
