package br.com.grafico;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Grafico extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Grafico(DefaultCategoryDataset categotyDataSet) {
		super( "Rede Neural" );
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JFreeChart grafico = ChartFactory.createLineChart("Gráfico EMQ x Ciclo", "Ciclo", 
			    "Erro Médio Quadrático", categotyDataSet, PlotOrientation.VERTICAL, true, true, false);
		
		
		this.add( new ChartPanel( grafico));
		this.pack();
	}
}
