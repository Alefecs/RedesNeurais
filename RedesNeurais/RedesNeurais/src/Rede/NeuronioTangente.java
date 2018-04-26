package Rede;

public class NeuronioTangente extends Neuronio{
	
	public double ativacao(double[] entradas) {
		double net = somatorio(entradas);
		
		net = (Math.pow(Math.E, net) - Math.pow(Math.E, -net))/(Math.pow(Math.E, net) + Math.pow(Math.E, -net));
		
		return net;
	}
	
	
	public void atualizacaoPadraoDePeso(double[] entrada,double alpha,double[] saidaDesejada,double[] saidaCalculada ) {
		//alpha é a taxa de aprendizagem da rede
		
		double derivadaTangenteHiperbolica = 0;
		
		for(int i = 0 ; i < pesos.length;i++) {
			derivadaTangenteHiperbolica = (1 - saidaCalculada[i]*saidaCalculada[i]);
			if(i == 0)
				pesos[i] = pesos[i] + alpha * (saidaDesejada[i] - saidaCalculada[i])*derivadaTangenteHiperbolica;
			else	
				pesos[i] = pesos[i] + alpha * (saidaDesejada[i] - saidaCalculada[i])*entrada[i]*derivadaTangenteHiperbolica;
			
		}
	}
}
