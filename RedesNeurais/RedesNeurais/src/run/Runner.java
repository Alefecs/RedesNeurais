package run;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jfree.data.category.DefaultCategoryDataset;

import br.com.grafico.Grafico;
import rede.NeuronioDegrau;
import rede.NeuronioLinear;

public class Runner {
	public static double[] geradorDePesos(int qtdEntrada) {
		double pesosGerados[] = new double[qtdEntrada];
		
		for(int cont = 0; cont < qtdEntrada; cont ++) {
			pesosGerados[cont] = (double)Math.round(Math.random() * 1); 
		}
		return pesosGerados;
	}

	public static void treinamentoRedeMLPDegrau(DefaultCategoryDataset categotyDataSet3) {
		/* Resolução Rede MLP com uma camada escondida:
		 * O usuário informa a quantidades de entradas e os valores desejáveis, os pesos são gerados randomicamente
		 * pela função GeradorDePesos e este valor é armazenado para que o resultado da rede possa ser replicado. 
		 **/
		
		double entradasMatriz[][] = {{0,0},{0,1},{1,0},{1,1}};
		double saidaDesejada[] = {1,0,0,1};
		double saidaCalculada = 0;		
		double eQuadratico[] = {0,0,0,0};
		List<Double> eMedioQuadratico = new ArrayList<>();
		double eMQ = 0;
		
		//para neuronio degrau
		int contsainda = 0;
		String a ="";
		
		//Cria o Objeto Neuronio
		NeuronioDegrau perceptron = new NeuronioDegrau();
		
		//Cria a rede de Objetos com relação aos niveis : 
		//Redes[Nivel1[ob 1,ob 2,ob 3,..ob n],Nivel2[ob 1,ob 2,ob 3,..ob n],...,NivelN[ob 1,ob 2,ob 3,..ob n]]
		ArrayList<ArrayList<NeuronioDegrau>> rede = new ArrayList<ArrayList<NeuronioDegrau>>();
		
		//Cria o nivel 1 (camada escondida)
		ArrayList<NeuronioDegrau> n1 = new ArrayList<NeuronioDegrau>();
		NeuronioDegrau meio = new NeuronioDegrau();
		n1.add(meio);
		rede.add(n1);
		double pesoN1[] = new double[3]; 
		pesoN1 = geradorDePesos(3);
		meio.pesosInicias(pesoN1);
			
		//Cria o nivel 2 ( camada saida )
		ArrayList<NeuronioDegrau> n2 = new ArrayList<NeuronioDegrau>();
 		NeuronioDegrau saida = new NeuronioDegrau();
		n2.add(saida);
		rede.add(n2);
		double pesoN2[] = new double[2];
		pesoN2 = geradorDePesos(2);
		saida.pesosInicias(pesoN2);
				
		for(int ciclo = 0;;ciclo++) {
			
			System.out.println("Ciclo: " + (ciclo+1));
			
			for(int exemplo = 0; exemplo < entradasMatriz.length; exemplo++) { 
				
				System.out.println("	Exemplo: " + (exemplo+1));

				for(int i=0; i <  rede.size(); i++) { 
					double saidas[] = new double[rede.get(i).size()];
				
					for(int j=0 ; j < rede.get(i).size(); j++) {
						if( i == 0) {
							saidas[j] = perceptron.ativacao(entradasMatriz[exemplo]);
							
						}else {
						
						}
					}	
				}
	
				
				/*
				if( saidaN2 != saidaDesejada[exemplo] ) {
					//calcular media ponderada
					
					saida.atualizacaoPadraoDePeso(entradasMatriz[exemplo], 1, saidaDesejada[exemplo], saidaCalculada);
					
					
					contsainda++;
				}else {
					a = perceptron.mostrarPeso(0);
					System.out.println("	w10 : "  + a);
					a = perceptron.mostrarPeso(1);
					System.out.println("	w11 : "  + a);
					a = perceptron.mostrarPeso(2);
					System.out.println("	w12 : "  + a);
					
				}		
				*/			
				//calculo de Erro;
				eQuadratico[exemplo] = Math.pow((saidaDesejada[exemplo] - saidaCalculada), 2);
				
				System.out.println("	erroQuadratico:" + eQuadratico[exemplo]);
				System.out.println("	saida:" + saidaCalculada);
			}
			
			eMQ = 0;
			for(int cont = 1; cont < eQuadratico.length; cont++) {
				eMQ += eQuadratico[cont];
				
			}
			
			eMQ /= eQuadratico.length;
			eMedioQuadratico.add(eMQ);
			categotyDataSet3.addValue(eMQ, "maximo", String.valueOf(ciclo + 1));
			
			
			System.out.println("	erroMedioQuadratico: " + eMedioQuadratico.get(ciclo));
			
			if(contsainda == 0) {
				System.out.println("\n Sementes:");
				//System.out.println("	w10 : "  + semente[0]);
				//System.out.println("	w11 : "  + semente[1]);
				//System.out.println("	w12 : "  + semente[2]);
				System.out.println("\n Pesos Gerados:");
				a = perceptron.mostrarPeso(0);
				System.out.println("	w10 : "  + a);
				a = perceptron.mostrarPeso(1);
				System.out.println("	w11 : "  + a);
				a = perceptron.mostrarPeso(2);
				System.out.println("	w12 : "  + a);
				
				System.out.println("\n Resultado Final:");
				saidaCalculada = perceptron.ativacao(entradasMatriz[0]);
				System.out.println("	entradas: 0 0 /saida: "  + saidaCalculada);
				saidaCalculada = perceptron.ativacao(entradasMatriz[1]);
				System.out.println("	entradas: 0 1 /saida: "  + saidaCalculada);
				saidaCalculada = perceptron.ativacao(entradasMatriz[2]);
				System.out.println("	entradas: 1 0 /saida: "  + saidaCalculada);
				saidaCalculada = perceptron.ativacao(entradasMatriz[3]);
				System.out.println("	entradas: 1 1 /saida: "  + saidaCalculada);
				break;
			}
			contsainda=0;
			//condição de saida do superLoop
			//if(eMedioQuadratico.get(ciclo) >0.50)
				//break;	
		}		
	}
	
	public static void treinamentoRedeDegrau(DefaultCategoryDataset categotyDataSet2) {
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
		//para neuronio degrau
		int contsainda = 0;
		//Passa como argumento o tamanho da coluna,que representa a quantidade de entrada.
		//O +1 é a entrada adicional o bias
		String a ="";
		//semente = geradorDePesos(entradasMatriz[0].length + 1);
		
		
		
		NeuronioDegrau perceptron = new NeuronioDegrau();
		
		perceptron.pesosInicias(semente);
		
		for(int ciclo = 0;;ciclo++) {
			
			System.out.println("Ciclo: " + (ciclo+1));
			
			for(int exemplo = 0; exemplo < entradasMatriz.length; exemplo++) { 
				
				System.out.println("	Exemplo: " + (exemplo+1));
				
				saidaCalculada = perceptron.ativacao(entradasMatriz[exemplo]);
				
				if(saidaCalculada != saidaDesejada[exemplo] ) {
					
					perceptron.atualizacaoPadraoDePeso(entradasMatriz[exemplo], 1, saidaDesejada[exemplo], saidaCalculada);
					contsainda++;
				}else {
					a = perceptron.mostrarPeso(0);
					System.out.println("	w10 : "  + a);
					a = perceptron.mostrarPeso(1);
					System.out.println("	w11 : "  + a);
					a = perceptron.mostrarPeso(2);
					System.out.println("	w12 : "  + a);
					
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
			
			eMQ /= eQuadratico.length;
			eMedioQuadratico.add(eMQ);
			categotyDataSet2.addValue(eMQ, "maximo", String.valueOf(ciclo + 1));
			
			
			System.out.println("	erroMedioQuadratico: " + eMedioQuadratico.get(ciclo));

			if(contsainda == 0) {
				System.out.println("\n Sementes:");
				System.out.println("	w10 : "  + semente[0]);
				System.out.println("	w11 : "  + semente[1]);
				System.out.println("	w12 : "  + semente[2]);
				System.out.println("\n Pesos Gerados:");
				a = perceptron.mostrarPeso(0);
				System.out.println("	w10 : "  + a);
				a = perceptron.mostrarPeso(1);
				System.out.println("	w11 : "  + a);
				a = perceptron.mostrarPeso(2);
				System.out.println("	w12 : "  + a);
				
				System.out.println("\n Resultado Final:");
				saidaCalculada = perceptron.ativacao(entradasMatriz[0]);
				System.out.println("	entradas: 0 0 /saida: "  + saidaCalculada);
				saidaCalculada = perceptron.ativacao(entradasMatriz[1]);
				System.out.println("	entradas: 0 1 /saida: "  + saidaCalculada);
				saidaCalculada = perceptron.ativacao(entradasMatriz[2]);
				System.out.println("	entradas: 1 0 /saida: "  + saidaCalculada);
				saidaCalculada = perceptron.ativacao(entradasMatriz[3]);
				System.out.println("	entradas: 1 1 /saida: "  + saidaCalculada);
				break;
			}
			contsainda=0;
			//condição de saida do superLoop
			if(eMedioQuadratico.get(ciclo) >0.50)
				break;
			
		}		
	}
	
	public static void treinamentoRedeLinear(DefaultCategoryDataset categotyDataSet) {
		/* Resolução para Percepto:
		 * O usuário informa a quantidades de entradas e os valores desejáveis, os pesos são gerados randomicamente
		 * pela funçaõ GeradorDePesos e este valor é armazenado para que o resultado da rede possa ser replicado. 
		 **/
		
		double entradasMatriz[][] = {{0.30,0.10,0.10},
									 {0.03,0.02,0.00},
									 {1.00,1.00,1.00},
									 {0.40,0.15,1.00},
									 {0.90,0.80,0.10},
									 {0.50,0.50,0.90}
									 };
		double saidaDesejada[] = {0.19,0.11,0.60,0.31,0.52,0.39};
		double saidaCalculada = 0;		
		double eQuadratico[] = new double[entradasMatriz.length];
		double semente[] = new double[entradasMatriz[0].length+1];
		List<Double> eMedioQuadratico = new ArrayList<>();
		double eMQ = 0;
		//para neuronio degrau

		//Passa como argumento o tamanho da coluna,que representa a quantidade de entrada.
		//O +1 é a entrada adicional o bias
		String a ="";
		semente = geradorDePesos(entradasMatriz[0].length + 1);
		
		
		
		NeuronioLinear perceptron2 = new NeuronioLinear();
		
		perceptron2.pesosInicias(semente);
		
		for(int ciclo = 0;;ciclo++) {
			
			System.out.println("Ciclo: " + (ciclo+1));
			
			for(int exemplo = 0; exemplo < entradasMatriz.length; exemplo++) { 
				saidaCalculada = perceptron2.ativacao(entradasMatriz[exemplo]);
				
				System.out.println("	Exemplo: " + (exemplo+1));
				
				perceptron2.atualizacaoPadraoDePeso(entradasMatriz[exemplo], 0.5, saidaDesejada[exemplo], saidaCalculada);

				//calculo de Erro;
				eQuadratico[exemplo] = (saidaDesejada[exemplo] - saidaCalculada)*(saidaDesejada[exemplo] - saidaCalculada);
				
				System.out.println("	erroQuadratico:" + eQuadratico[exemplo]);
				System.out.println("	saida:" + saidaCalculada);
			}
			
			eMQ = 0;
			for(int cont = 1; cont < eQuadratico.length; cont++) {
				eMQ += eQuadratico[cont];
				
			}
			
			eMQ /= eQuadratico.length;
			categotyDataSet.addValue(eMQ, "maximo", String.valueOf(ciclo + 1));
			eMedioQuadratico.add(eMQ);
			
			System.out.println("	erroMedioQuadratico: " + eMedioQuadratico.get(ciclo));

			//condição de saida do superLoop
			if(eMedioQuadratico.get(ciclo) < 0.001) {
				System.out.println("\n Sementes:");
				for(int cont = 0 ; cont < semente.length; cont ++) 
					System.out.println("	w1"+cont+" : "  + semente[cont]);
				

				System.out.println("\n Pesos Gerados:");
				
				for(int cont = 0 ; cont < semente.length; cont ++) {
					a = perceptron2.mostrarPeso(cont);
					System.out.println("	w1"+cont+" : "  + a);
				}
			
				System.out.println("\n Resultado Final:");
				for(int i = 0 ; i < entradasMatriz.length; i ++) {
					saidaCalculada = perceptron2.ativacao(entradasMatriz[i]);
					System.out.println("	entradas:"+ Arrays.toString(entradasMatriz[i])+" /saida: "  + saidaCalculada);
				}
				break;
			}
		}		
	}
	
	public static void main(String[] args) {
		DefaultCategoryDataset categotyDataSet = new DefaultCategoryDataset();
		DefaultCategoryDataset categotyDataSet2 = new DefaultCategoryDataset();
		//DefaultCategoryDataset categotyDataSet3 = new DefaultCategoryDataset();

		new Grafico(categotyDataSet).setVisible(true);
		new Grafico(categotyDataSet2).setVisible(true);
		//new Grafico(categotyDataSet3).setVisible(true);
		
		treinamentoRedeLinear(categotyDataSet);
		treinamentoRedeDegrau(categotyDataSet2);
		//treinamentoRedeMLPDegrau(categotyDataSet3);
		


	}

}
