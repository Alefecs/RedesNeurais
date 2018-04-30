package rede;

public class NeuronioDegrau extends Neuronio{
	@Override
	public double ativacao(double[] entradas) {
		double net = funcao(entradas);

		if(net >= 0)
			return 1.0;
		else
			return 0.0;
	}
	public void atualizacaoPadraoDePeso(double[] entrada,double alpha,double saidaDesejada,double saidaCalculada ) {
		//alpha é a taxa de aprendizagem da rede
		
		//Bias - Alteração de peso para o limiar.

	
		
		for(int i = 0 ; i < pesos.length;i++) {
			if(i == 0)
				pesos[0] = pesos[0] + alpha * (saidaDesejada - saidaCalculada)*1;	
			else
				pesos[i] = pesos[i] + alpha * (saidaDesejada - saidaCalculada)*entrada[i - 1];
			
			System.out.println("	w1"+i+ ": "  + pesos[i]);
		}
	}
	
}
