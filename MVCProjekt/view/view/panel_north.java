package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;




/**
 * @author Ivana
 * panel na kojem je smjesten menu
 */
public class panel_north extends JPanel{
	
	/**
	 * objekt tipa JMenuBar
	 */
	private JMenuBar menuBar ;
	/**
	 * objekt tipa JMenuItem klikom na kojeg se prikazuje frame sa tortnim grafom
	 */
	protected JMenuItem pogledaj_statistiku;
	

	
	
	//protected JMenuItem narudzbaLjekova;
	/**
	 * objekt tipa JMenuItem
	 */
	private JMenu statistika;
	/**
	 * 
	 */
	
	//private JMenu Ljekovi;
	
	
	/**
	 * konstruktor kojim se postavlja velicina frame-a i boja
	 */
	public panel_north() {
		setBackground(new Color(230, 230, 230));
		setDimension();
		MenuBar();
		setBackground(Color.DARK_GRAY);
	}

	

	/**
	 * metoda kojim pravi tool bar
	 */
	private void MenuBar() {
		menuBar=new JMenuBar();
		setLayout(new BorderLayout());
		
		 statistika = new JMenu("Statistika");
	   
	    // Ljekovi=new JMenu("Naruci ljekove");
	    pogledaj_statistiku = statistika.add("Ispis podataka");
	    
	  
	    statistika.addSeparator();
   
	 //   narudzbaLjekova=Ljekovi.add("Naruciti ljekove");
	    

	    menuBar.add(statistika); 
	   // menuBar.add(Ljekovi);
	   
	    add(menuBar,BorderLayout.NORTH);
		
	}

	/**
	 * metoda kojom se odreduje dimenzija frame-a
	 */
	private void setDimension() {
		// TODO Auto-generated method stub
		Dimension dim=new Dimension();
		dim.height=70;
		setPreferredSize(dim);
	}
	
	
	
}
