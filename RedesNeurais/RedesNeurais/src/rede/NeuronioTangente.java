package rede;

public class NeuronioTangente extends Neuronio{
	
	public double ativacao(double[] entradas) {
		double net = funcao(entradas);
		
		net = (Math.pow(Math.E, net) - Math.pow(Math.E, -net))/(Math.pow(Math.E, net) + Math.pow(Math.E, -net));
		
		return net;
	}
	
	
	public void atualizacaoPadraoDePeso(double[] entrada,double alpha,double saidaDesejada,double saidaCalculada ) {
		//alpha é a taxa de aprendizagem da rede
		
		double derivadaTangenteHiperbolica = 0;
		derivadaTangenteHiperbolica = (1 - saidaCalculada*saidaCalculada);
		for(int i = 0 ; i < pesos.length;i++) {

			if(i == 0)
				pesos[i] = pesos[i] + alpha * (saidaDesejada - saidaCalculada)*derivadaTangenteHiperbolica;
			else	
				pesos[i] = pesos[i] + alpha * (saidaDesejada - saidaCalculada)*entrada[i-1]*derivadaTangenteHiperbolica;
			
		}
	}
}
