package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;



public class Panel_west extends JPanel{
	
	/**
	 * botun klikom na kojeg se prikazuje broj narucenih za dansnji dan
	 */
	protected JButton button_br_narucenih;
	/**
	 * botun kojem se narucuje pacijent
	 */
	protected JButton booking;
	/**
	 * objekt tipa Jlabel
	 */
	private JLabel labela;
	
	//private JLabel labela_text;
	/**
	 * botun klikom na kojeg se izlazi iz frame-a
	 */
	protected JButton kraj;
	private ImageIcon icon;
	private int broj_narucenih=0;
	

	
	public Panel_west() {
		setBackground(new Color(179, 179, 179));
		
		setDimension();
		
		
	}

	



	/**
	 * metoda kojom se postavlja dimenzija panela
	 */
	private void setDimension() {
		Dimension dim=new Dimension();
		dim.width=150;
		//dim.height=350;
		setPreferredSize(dim);
		try {
			CreateComp();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @throws SQLException
	 * 
	 * metoda kojom se prave objekti i razmjestaju na panel
	 */
	private void CreateComp() throws SQLException {
		Controller controller=new Controller();
	//	int br=controller.getNumbOFdailyPatients();
		
		//labela=new JLabel(br,new ImageIcon("CIRCLE.png"),JLabel.CENTER);
		//icon=new ImageIcon("CIRCLE.png");
		
		
		//labela_text=new JLabel("broj narucenih za danas: ");
		booking=new JButton("Naruci pacijenta");
		button_br_narucenih=new JButton("Narucen za danas");
		
		//labela.setIcon(icon);
		kraj=new JButton("kraj");
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.weightx = 0;
		gbc.weighty = 0.1;
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(button_br_narucenih,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(booking,gbc);
		
		

		//gbc.gridx = 0;
		//gbc.gridy = 3;
		//gbc.anchor=GridBagConstraints.WEST;
		//labela_text.setBackground(Color.white);
		//add(labela_text,gbc);		
		
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor=GridBagConstraints.WEST;
		
		
		
		labela=new JLabel(""+broj_narucenih,new ImageIcon("CIRCLE.png"),JLabel.CENTER);
		
		labela.setHorizontalTextPosition(JLabel.CENTER);
		add(labela);

		
		

		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(kraj,gbc);
		
		
	}



	
	/**
	 * @return broj_narucenih 
	 * metoda koja dohvaca broj narucenih korisnika
	 */
	public int getBroj_narucenih() {
		return broj_narucenih;
	}



	/**
	 * @param broj_narucenih
	 * metoda kojom se postavlja broj narucenih pacijenata
	 */
	public void setBroj_narucenih(int broj_narucenih) {
		this.broj_narucenih = broj_narucenih;
	}



	/**
	 * @return
	 * get metoda za dohvacanje labele iz neke druge klase
	 * koristila sam je u controlleru 
	 */
	public JLabel getLabela() {
		return labela;
	}
	
	
	
	
	
}
