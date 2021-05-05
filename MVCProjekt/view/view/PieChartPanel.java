package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Ivana
 * ovo je panel u kojem se nalazi tortni grafikon koji pokazuje odnose godina pacijenata
 */
public class PieChartPanel extends JPanel {
	
	
	/**
	 * objekt tipa JLabel
	 */
	private JLabel label;
	
	/**
	 * labela koja prikazuje dio legende za godine 30-50 i 10-20
	 */
	private JLabel boje1;
	/**
	 * labela koja prikazuje dio legende za godine 0-10,20-30 i 50+
	 */
	private JLabel boje2;
	
	
	/**
	 * konstruktor klase PieChart
	 * u njemu je pozvana metoda LaoutComponents
	 */
	public PieChartPanel() {
		// TODO Auto-generated constructor stub
		
		//setLayout(new BorderLayout());
		
		
		
		
		label=new JLabel("LEGENDA PACIJENATA PO GODINAMA: ");
		Dimension dim=new Dimension();
		dim.height=150;
		setPreferredSize(dim);
		
		// add(new BarChart());
		
		boje1=new JLabel("Crna  "+"30-50god"+" Bijela:  "+"10-20 god");
		boje2=new JLabel(" siva: "+"0-10 "+ " Tamnosiva: "+" 20-30 svijetlo siva: 50+");
		LaoutComponents();
	}



	/**
	 * metoda kojom se preko kordinata razmjestaju komponenete na frame-u
	 */
	private void LaoutComponents() {

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.weightx = 0;
		gbc.weighty = 0.1;
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(label,gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor=GridBagConstraints.CENTER;
		
		
		add(boje1,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor=GridBagConstraints.CENTER;
		
		
		add(boje2,gbc);
		
		
		
		
	}
	
	

}
