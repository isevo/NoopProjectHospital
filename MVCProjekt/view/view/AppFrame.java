package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



/**
 * @author Ivana
 *U ovoj klasi je samo smjesten Panel_start
 */
public class AppFrame extends JFrame {
	
	
	/**
	 * Objekt klase Panel_start
	 */
	private Panel_start pstg;

	
	
	
	/**
	 * @throws Exception
	 * 
	 * Konstruktor(postavljena velicina okvira,pozicija,postavljen okvir na vidljivo)
	 */
	public AppFrame() throws Exception {
		setUndecorated(true);
		//super("GAME");
		setLayout(new GridBagLayout());
		setLayout(new BorderLayout());
		setSize(650,350);
		setVisible(true);
		setResizable(false);
	//	setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		CreateComp();
		
	
	}

	/**
	 * Metoda za kreiranje objekata
	 */
	private void CreateComp() {
		pstg=new Panel_start();
		add(pstg);
		
	}

	
	
	
	
	
	
	
	
}
