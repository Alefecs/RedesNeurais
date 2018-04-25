package Rede;

public class NeuronioDegrau extends Neuronio{
	@Override
	public double ativacao(double[] entradas) {
		double net = somatorio(entradas);

		if(net >= 0)
			return 1;
		else
			return 0;
	}
	public void atualizacaoPadraoDePeso(double[] entrada,double alpha,double[] saidaDesejada,double[] saidaCalculada ) {
		//alpha é a taxa de aprendizagem da rede
		
		for(int i = 0 ; i < pesos.length;i++) 
			pesos[i] = pesos[i] + alpha * (saidaDesejada[i] - saidaCalculada[i])*entrada[i];
	}
	
}
