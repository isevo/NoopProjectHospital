package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sun.jdi.connect.Connector;

import controller.Controller;
import model.Lijecnik;

/**
 * @author Ivana
 *frame u kojem se korisnik registrira
 */
public class Registracija extends JFrame {
	
	
	/**
	 * komponenta u kojoj korisnik unosi ime
	 */
	private JTextField tf_name;
	/**
	 *  komponenta u kojoj korisnik unosi prezime
	 */
	private JTextField tf_surname;
	/**
	 * komponenta u kojoj korisnik unosi lozinku
	 */
	private JPasswordField tf_password;
	/**
	 * objekt tipa JLabel-odnosi se na ime
	 */
	private JLabel labela_name;
	/**
	 * objekt tipa JLabel-odnosi se na prezime
	 */
	private JLabel labela_surname;
	/**
	 * objekt tipa JLabel-odnosi se na lozinku
	 */
	private JLabel labela_password;
	/**
	 * objekt tipa JLabel-odnosi se na ponovljenu lozinku 
	 */
	private JLabel labela_repeat_password;
	/**
	 * komponenta u koju se unosi ponovljena lozinka koja mora biti ista
	 * kao i ona u tf_password 
	 */
	private JPasswordField tf_repeat_password;
	
	/**
	 * botun klikom na kojeg se korisnik registrira
	 */
	private JButton registriraj_me;
	/**
	 * botun klikom na kojeg korisnik izlazi iz frame-a
	 */
	private JButton kraj;
	
	
	
	/**
	 * konstruktor klase Registracija u kojoj je postavljena dimenzija frame-a,
	 * pozicija,pozvane metode CreateComp,loadComp i Akcija
	 */
	public Registracija() {
		
		
		setVisible(true);
		setSize(450, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setAlwaysOnTop(true);
		
		
		CreateComp();
		loadComp();
		
		Akcija();
		
		
		
	}

	/**
	 * metoda u kojoj se odvijaju dogadaj registracije i izlaska iz frame-a
	 *
	 */
	private void Akcija() {
		kraj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
				
			}
		});
		
		registriraj_me.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				checkDate();
				
				
			}
		});
			
	
		
		
		
	}

	/**
	 * metoda kojom se postavljaju kordinate komponenata tj razmjestaj na frame-u
	 */
	private void loadComp() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.weightx = 0;
		gbc.weighty = 0.1;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(labela_name,gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(labela_surname,gbc);
		
		

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(labela_password,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(tf_name,gbc);
		
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(tf_surname,gbc);
		
		

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(tf_password,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(labela_repeat_password,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(tf_repeat_password,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(kraj,gbc);
		
		
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(registriraj_me,gbc);
		
		
		
	}

	/**
	 * metoda u kojoj se prave objekti
	 */
	private void CreateComp() {
		tf_name=new JTextField(10);
		tf_surname=new JTextField(10);
		tf_password=new JPasswordField(10);
		labela_name=new JLabel("IME ");
		labela_surname=new JLabel("PREZIME ");
		labela_password=new JLabel("PASSWORD ");
		labela_repeat_password=new JLabel("PONOVI LOZINKU ");
		tf_repeat_password=new JPasswordField(10);
		registriraj_me=new JButton("REGISTRIRAJ ME");
		kraj=new JButton("KRAJ");
		
	}
	
	/**
	 * metroda koja provjerava jesu li uneseni svi trazeni podaci
	 */
	private void checkDate() {
		String ime=tf_name.getText();
		String prezime=tf_surname.getText();
		String pass1=String.valueOf(tf_password.getPassword());
		String pass2=String.valueOf(tf_repeat_password.getPassword());
		
		if (ime.length()!=0 && prezime.length()!=0 && pass1.length()>6 && pass2.length()>6) {
			
			if (pass1.equals(pass2)) {
				Controller con=new Controller();
				try {
					con.connect2DB();
					Lijecnik lijecnik=new Lijecnik(ime, prezime, pass2);
					con.getRegisterBefore();
					con.addDoctorTOdataBase(lijecnik);
					con.saveDoctor2DB();
					setVisible(false);
					
				}
				
				 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			else {
				JOptionPane.showMessageDialog(Registracija.this, "Polja Password i ponovi lozinku moraju biti ista!Duljina lozinke mora biti veca od 6!");
				setVisible(true);
			}
			
			
		}
		else {
			JOptionPane.showMessageDialog(Registracija.this, "Sva polja moraju biti popunjena!");
			setVisible(true);
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
