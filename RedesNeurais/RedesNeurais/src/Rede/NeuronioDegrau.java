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
}
