package Rede;



public class NeuronioSigmoide extends Neuronio{
	
	
	public double ativacao(double[] entradas) {
		double net = funcao(entradas);
		
		net = 1/(1 + Math.pow(Math.E, -net)  );
		
		return net;
	}
	
	public void atualizacaoPadraoDePeso(double[] entrada,double alpha,double saidaDesejada,double saidaCalculada ) {
		//alpha é a taxa de aprendizagem da rede
		
		double derivadaSigmoideLogistica = 0;
		derivadaSigmoideLogistica = saidaCalculada*(saidaCalculada - 1);
		
		for(int i = 0 ; i < pesos.length;i++) {
			
			
			if(i == 0)
				pesos[0] = pesos[0] + alpha * (saidaDesejada - saidaCalculada)*derivadaSigmoideLogistica;	
			else
				pesos[i] = pesos[i] + alpha * (saidaDesejada - saidaCalculada)*derivadaSigmoideLogistica*entrada[i-1];
		
			System.out.println("	w1"+ i + ": "  + pesos[i]);
		}
	}

}
