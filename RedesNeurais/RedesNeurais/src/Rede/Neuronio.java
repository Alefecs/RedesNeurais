package Rede;

import javax.swing.JOptionPane;

public abstract class Neuronio {
	protected double[] pesos;

	public abstract double ativacao(double[] entradas);

	protected double somatorio(double[] entradas) {
		double net = 0;
		//contadores
		int quantidadeDeEntradas = entradas.length;
		int quantidadeDePesos = pesos.length;
		
		if(quantidadeDeEntradas != quantidadeDePesos) {
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
