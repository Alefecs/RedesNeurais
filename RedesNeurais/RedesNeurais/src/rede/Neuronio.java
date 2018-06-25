package rede;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public abstract class Neuronio {
	//conexão do neuronio com outro(s) relação a entrada
	protected double[] pesos;
	protected double delta;


	
	public abstract double ativacao(double[] entradas);
	
	public void pesosInicias(double[] semente) {
		pesos = new double[semente.length];
		for(int i = 0; i < semente.length; i++)
			pesos[i] = semente[i];
	}
	

	//public void pesosIniciasMLP(double[] );
	
	public String mostrarPeso(int pos) {
		String mostra = String.valueOf(pesos[pos]);
		return mostra;
	}
	
	public double funcao(double[] entradas) {
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
			net = net + 1*pesos[0];
		for(int contador = 1 ; contador < quantidadeDePesos; contador ++) {
			net = net + entradas[contador - 1]*pesos[contador];
			
		}

		return net;
	}
}
