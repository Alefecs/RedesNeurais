package Rede;



public class NeuronioLinear extends Neuronio{
	

	public double ativacao(double[] entradas) {
		double net = funcao(entradas);
		
		return net;
	}
	
	public void atualizacaoPadraoDePeso(double[] entrada,double alpha,double saidaDesejada,double saidaCalculada ) {
		//alpha é a taxa de aprendizagem da rede
		

		for(int i = 0 ; i < pesos.length;i++){
			if(i == 0)
				pesos[0] = pesos[0] + alpha * (saidaDesejada - saidaCalculada);	
			else
				pesos[i] = pesos[i] + alpha * (saidaDesejada - saidaCalculada)*entrada[i - 1];
		
			System.out.println("	w1"+ i + ": "  + pesos[i]);
		}
	}
	/*
	public double attPesoBatch(double[] entrada,double taxaDeAprendizagem) {
		
	}*/
	
}
