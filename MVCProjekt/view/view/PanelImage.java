package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Ivana
 *	panel na kojem je smjestena slika(prilikom logiranja)
 */
public class PanelImage extends JPanel{
	
	  /**
	 * objekt klase ImageIcon u kojem je smjestena slika
	 */
	ImageIcon img;
	  /**
	 * Objekt klase JLabel-na nju je postavljena slika
	 */
	private JLabel labela;
	
	/**
	 * konstruktor u kojem je pozvana metoda setDimension
	 */
	public PanelImage() {
		
		SetDimension();
	}

	/**
	 * metoda u kojoj su komponenete smjestene na panel te odredena dimenzija panela
	 */
	private void SetDimension() {
		Dimension dim =new Dimension();
		dim.width=340;
		setPreferredSize(dim);
		
		// pozadina
		labela=new JLabel();
		img =new ImageIcon("Pharmacy-logo.jpg");
		labela.setIcon(img);
		
		GroupLayout glu=new GroupLayout(this);
	 	setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.weightx = 0;
		gbc.weighty = 0.1;
		
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor=GridBagConstraints.CENTER;
		
		
		add(labela,gbc);
		
		
		setBackground(Color.WHITE);
		
		
	}
	 
	

}
