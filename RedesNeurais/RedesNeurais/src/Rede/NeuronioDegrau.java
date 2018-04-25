package Rede;

import javax.swing.JOptionPane;

public class NeuronioDegrau extends Neuronio{
	public double funcDegrau(double[] entradas, double[] pesos) {
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
		if(net >= 0)
			return 1;
		else
			return 0;
	}
}
