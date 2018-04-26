package Rede;

import javax.swing.JOptionPane;

public abstract class Neuronio {
	//conexão do neuronio com outro(s) relação a entrada
	protected double[] pesos;

	public abstract double ativacao(double[] entradas);
	
	public void pesosInicias(double[] semente) {
		pesos = new double[semente.length];
		for(int i = 0; i < semente.length; i++)
			pesos[i] = semente[i];
	}
	
	
	protected double somatorio(double[] entradas) {
		double net = 0;
		//contadores
		int quantidadeDeEntradas = entradas.length;
		int quantidadeDePesos = pesos.length;
		
		if(quantidadeDeEntradas+1  != quantidadeDePesos) {
			try {
				throw new Exception("Houve um erro!");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		for(int contador = 0 ; contador < quantidadeDeEntradas; contador ++) {
			net = net + entradas[contador]*pesos[contador];
			
		}

		return net;
	}
}
