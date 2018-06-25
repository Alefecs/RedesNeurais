package rede;

import java.util.ArrayList;

public class NeuronioDegrau extends Neuronio{
	@Override
	public double ativacao(double[] entradas) {
		double net = funcao(entradas);

		if(net >= 0)
			return 1.0;
		else
			return 0.0;
	}
	

	
	public void calculoDelta(ArrayList<ArrayList<NeuronioDegrau>> rede, double erroQ) {
		int nivelRede = 0;	
		for(ArrayList<NeuronioDegrau> c : rede) { 
				for(NeuronioDegrau elem :c) {
					if(nivelRede == 0) {
						delta = erroQ * 1; //erroQuadrático vezes a derivada da função
					}
					
				}
				nivelRede++;
		}			
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
	public void atualizacaoPadraoDePesoBackPropagation(double[] entrada,double alpha) {
		//alpha é a taxa de aprendizagem da rede
		
		//Bias - Alteração de peso para o limiar.

	
		
		for(int i = 0 ; i < pesos.length;i++) {
			if(i == 0)
				pesos[0] = pesos[0] + alpha * delta*1;	
			else
				pesos[i] = pesos[i] + alpha * delta*entrada[i - 1];
			
			System.out.println("	w1"+i+ ": "  + pesos[i]);
		}
	}
}
