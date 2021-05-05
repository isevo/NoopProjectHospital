package view;

import java.awt.BorderLayout;
import java.awt.Dimension;


import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;




/**
 * @author Ivana
 *Panel u kojem se nalazi txtArea
 */
public class panel_center extends JPanel {
	/**
	 * objekt klase JTextArea
	 */
	private JTextArea txtArea;
	private JScrollBar sb;
	
	
	
	

	/**
	 * konstruktor klase Panel_center
	 */
	public panel_center() {
		
		setLayout(new BorderLayout());
		
			
		setDimension();
		creteComp();
	
	
	}

	

	/**
	 * metoda u kojoj se instancira klasa
	 */
	private void creteComp() {
	txtArea=new JTextArea();
	
	
//	txtArea.setPreferredSize(new Dimension(500, 230));
	
	add(new JScrollPane(txtArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS),
			BorderLayout.CENTER);
	

		
	}

	/**
	 * metoda kojom se postavlja dimenzija panela
	 */
	private void setDimension() {
		// TODO Auto-generated method stub
		Dimension dim=new Dimension();
		dim.height=100;
		
	}
	
	
	/**
	 * @param t varijabla tipa string 
	 * ispisuje string na txtArea
	 */
	public void Ispis(String t) {
		txtArea.setText(t);
	}
	/**
	 * metoda koja brise sve sto je na txtArea
	 */
	public void Brisanje() {
		txtArea.setText(null);
	}
	
	
	
}
