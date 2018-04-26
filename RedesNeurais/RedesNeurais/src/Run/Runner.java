package Run;

import java.util.ArrayList;
import java.util.List;

import Rede.NeuronioDegrau;

public class Runner {
	public static double[] geradorDePesos(int qtdEntrada) {
		double pesosGerados[] = new double[qtdEntrada];
		
		for(int cont = 0; cont < qtdEntrada; cont ++) {
			pesosGerados[cont] = (double)Math.round(Math.random() * 1); 
		}
		return pesosGerados;
	}
	
	public static void treinamentoRede() {
		/* Resolução para Percepto:
		 * O usuário informa a quantidades de entradas e os valores desejáveis, os pesos são gerados randomicamente
		 * pela funçaõ GeradorDePesos e este valor é armazenado para que o resultado da rede possa ser replicado. 
		 **/
		
		double entradasMatriz[][] = {{0,0},{0,1},{1,0},{1,1}};
		double saidaDesejada[] = {0,0,0,1};
		double saidaCalculada = 0;		
		double eQuadratico[] = {0,0,0,0};
		double semente[] = {0,3,3};
		List<Double> eMedioQuadratico = new ArrayList<>();
		double eMQ = 0;
		int contsainda = 0;
		//Passa como argumento o tamanho da coluna,que representa a quantidade de entrada.
		//O +1 é a entrada adicional o bias
		
		//semente = geradorDePesos(entradasMatriz[0].length + 1);
		
		
		
		NeuronioDegrau perceptron = new NeuronioDegrau();
		
		perceptron.pesosInicias(semente);
		
		for(int ciclo = 0;;ciclo++) {
			
			System.out.println("Ciclo: " + (ciclo+1));
			
			for(int exemplo = 0; exemplo < entradasMatriz.length; exemplo++) { 
				
				System.out.println("	Exemplo: " + (exemplo+1));
				
				saidaCalculada = perceptron.ativacao(entradasMatriz[exemplo]);
				
				if(saidaCalculada == 1 ) {
				
					perceptron.atualizacaoPadraoDePeso(entradasMatriz[exemplo], 1, saidaDesejada[exemplo], saidaCalculada);
					contsainda++;
				}
				//calculo de Erro;
				eQuadratico[exemplo] = Math.pow((saidaDesejada[exemplo] - saidaCalculada), 2);
				
				System.out.println("	erroQuadratico:" + eQuadratico[exemplo]);
				System.out.println("	saida:" + saidaCalculada);
			}
			
			eMQ = 0;
			for(int cont = 1; cont < eQuadratico.length; cont++) {
				eMQ += eQuadratico[cont];
				
			}
			
			eMedioQuadratico.add(eMQ / eQuadratico.length);
			
			System.out.println("	erroMedioQuadratico: " + eMedioQuadratico.get(ciclo));
			
			if(contsainda == 0) {
				break;
			}
			contsainda=0;
			//condição de saida do superLoop
			if(eMedioQuadratico.get(ciclo) >0.50)
				break;
			
		}		
	}
	
	public static void main(String[] args) {
		
		treinamentoRede();

	}

}
