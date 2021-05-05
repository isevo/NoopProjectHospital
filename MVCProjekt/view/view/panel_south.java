package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Ivana
 *	panel na kojem se nalazi botun za izlistavanje svih pacijenata iz baze
 */
public class panel_south extends JPanel {

	/**
	 * objekt tipa Jlabel
	 */
	private JLabel labela_file;
	/**
	 * objekt tipa ImageIcon u kojem je postavljena slika
	 */
	private ImageIcon img;
	/**
	 * botun klikom na kojeg se prikazuju pacijenti iz baze
	 */
	protected JButton showPatients;
	
//	private JLabel time;
	
	/**
	 * konstruktor klase panel_south
	 */
	public panel_south() {
		// TODO Auto-generated constructor stub
		
		setDimension();
		
		
		CreateComp();
	
		
		
		
		
	}

	/**
	 * metoda u kojoj nastaju objekti i razmjestaju se na panelu preko kordinata
	 */
	private void CreateComp() {
		// TODO Auto-generated method stub
		
		
		labela_file=new JLabel();
		showPatients=new JButton("Izlistaj sve pacijente");
	//	time=new JLabel();
		
		
		
		img =new ImageIcon("icon.png");
		labela_file.setIcon(img);
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.weightx = 0;
		gbc.weighty = 0.1;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(labela_file,gbc);
		
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(showPatients,gbc);
		
		
		
		
		
		
	}

	/**
	 * postavljanje dimenzija frame-a
	 */
	private void setDimension() {
		Dimension dim=new Dimension();
		dim.height=120;
		setPreferredSize(dim);
		
		
	}
	
	
	
}
