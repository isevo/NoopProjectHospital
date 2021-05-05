package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * @author Ivana
 *ovo je frame na kojem je smejsten PieChartPanel
 */
public class PieChartFrame extends JFrame {
	
	
	/**
	 * objekt klase PieChartPanel
	 */
	private PieChartPanel pcp;
	/**
	 * objekt klase PieChart-u njemu se crta Pie  Chart
	 */ 
	
	protected PieChart barchart;
	
	/**
	 * konstruktor klase PieChartFrame
	 */
	public PieChartFrame() {
		
		
		
		setLayout(new BorderLayout());
		
	    setSize(350, 450);
	     setVisible(true);
	     setResizable(false);
	     setLocationRelativeTo(null);
	     setAlwaysOnTop(true);
	     
	     
	     CreateComp();
	     
	     AddComp();
	     
	     
	     
	     
	}

	/**
	 * metoda kojom se objekti postavljaju na frame
	 */
	private void AddComp() {
		add(pcp,BorderLayout.SOUTH);
		add(barchart,BorderLayout.CENTER);
	}

	/**
	 * metoda u kojoj nastaju objekti
	 */
	private void CreateComp() {
		pcp=new PieChartPanel();
		barchart=new PieChart();
	}
	
	
	
	
}
