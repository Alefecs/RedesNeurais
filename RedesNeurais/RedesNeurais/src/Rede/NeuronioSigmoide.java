package Rede;



public class NeuronioSigmoide extends Neuronio{
	
	
	public double ativacao(double[] entradas) {
		double net = somatorio(entradas);
		
		net = 1/(1 + Math.pow(Math.E, -net)  );
		
		return net;
	}
	
	public void atualizacaoPadraoDePeso(double[] entrada,double alpha,double saidaDesejada,double saidaCalculada ) {
		//alpha é a taxa de aprendizagem da rede
		
		double derivadaSigmoideLogistica = 0;
		
		for(int i = 0 ; i < pesos.length;i++) {
			derivadaSigmoideLogistica = saidaCalculada*(saidaCalculada - 1);
			pesos[i] = pesos[i] + alpha * (saidaDesejada - saidaCalculada)*derivadaSigmoideLogistica;
			
		}
	}

}
