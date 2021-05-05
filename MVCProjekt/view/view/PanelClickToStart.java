package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author Ivana
 * panel u kojem se odvija logiranje
 */
public class PanelClickToStart extends JPanel {
	/**
	 * botun za prelazak na drugi frame-Panel_doctor
	 */
	protected JButton button_next;
	/**
	 * botun kojim se izlazi iz aplikacije
	 */
	/**
	 * botun klikom na kojeg se izlazi iz frame-a
	 */
	protected JButton button_quit;
	/**
	 * text field na kojem se unosi ime
	 */
	protected JTextField tf_name;
	/**
	 * text field na kojem se unosi prezime
	 */
	protected JTextField tf_surname;
	
	/**
	 * text field na kojem se unosi lozinka
	 */
	protected JPasswordField tf_password;
	/**
	 * objekt tipa JLabel-odnosi se na ime
	 */
	private JLabel labela_name;
	/**
	 * objekt tipa JLabel koji se odnosi na prezime
	 */
	private JLabel labela_surname;
	/**
	 * objekt tipa JLabel-odnosi se na lozinku
	 */
	private JLabel labela_password;

	
	/**
	 * konstruktor klase PanelclickToStart
	 */
	public PanelClickToStart() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		
		createComp();
		setDimension();
		
	}

	

	/**
	 * metoda u kojoj se postavlja dimenzija panel
	 */
	private void setDimension() {
		Dimension dim=new Dimension();
		dim.width=310;
		setPreferredSize(dim);
		setBackground(Color.DARK_GRAY);
	}

	/**
	 * metoda kojom se komponenete smjestaju na panel
	 */
	private void createComp() {
		
	 	
	 	setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.weightx = 0;
		gbc.weighty = 0.1;
		
		
		labela_name=new JLabel("IME");
		labela_name.setForeground(Color.white);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(labela_name,gbc);
		
		labela_surname=new JLabel("SURNAME");
		labela_surname.setForeground(Color.white);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor=GridBagConstraints.CENTER;
		add(labela_surname,gbc);
		
		labela_password=new JLabel("PASSWORD");
		labela_password.setForeground(Color.white);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor=GridBagConstraints.CENTER;
		add(labela_password,gbc);
	
		
		tf_name=new JTextField(20);
		tf_name.setBackground(new Color(166, 166, 166));
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor=GridBagConstraints.CENTER;
		add(tf_name,gbc);
		
		
		tf_surname=new JTextField(20);
		tf_surname.setBackground(new Color(166, 166, 166));
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor=GridBagConstraints.CENTER;
		add(tf_surname,gbc);
		
		tf_password=new JPasswordField(20);
		tf_password.setBackground(new Color(166, 166, 166));
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor=GridBagConstraints.CENTER;
		add(tf_password,gbc);
		
		button_next=new JButton("DALJE");
	
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.anchor=GridBagConstraints.CENTER;
		button_next.setPreferredSize(new Dimension(200, 30));
		add(button_next,gbc);
		
		
		button_quit=new JButton("KRAJ");
		
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.anchor=GridBagConstraints.CENTER;
		button_quit.setPreferredSize(new Dimension(200, 30));
		add(button_quit,gbc);
		
		
	}



	/**
	 * @return tf_name
	 * metoda koja omogucuje dohvacanje text field-a iz druge klase
	 */
	public JTextField getTf_name() {
		return tf_name;
	}

	/**
	 * @return tf_surname
	 * metoda koja omogucuje dohvacanje text field-a iz druge klase
	 */

	public JTextField getTf_surname() {
		return tf_surname;
	}

	/**
	 * @return tf_password
	 * metoda koja omogucuje dohvacanje text field-a iz druge klase
	 */

	public JPasswordField getTf_password() {
		return tf_password;
	}
	
	
	
	

	
	
}
