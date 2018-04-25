package Rede;



public class NeuronioLinear extends Neuronio{
	

	public double ativacao(double[] entradas) {
		double net = somatorio(entradas);
		
		return net;
	}
	
	public void atualizacaoPadraoDePeso(double[] entrada,double alpha,double[] saidaDesejada,double[] saidaCalculada ) {
		//alpha é a taxa de aprendizagem da rede
		
		double derivadaLinear = 1;
		for(int i = 0 ; i < pesos.length;i++) 
			pesos[i] = pesos[i] + alpha * (saidaDesejada[i] - saidaCalculada[i])*derivadaLinear;	
	}
	/*
	public double attPesoBatch(double[] entrada,double taxaDeAprendizagem) {
		
	}*/
	
}
