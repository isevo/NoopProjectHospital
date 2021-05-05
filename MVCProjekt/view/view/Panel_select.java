package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.Controller;
import model.Pacijent;




/**
 * @author Ivana
 *ovo je frame u kojem korisnik odlucuje zeli li se registrirati ili logirati ili izaci iz aplikacije
 */
public class Panel_select extends JFrame{
	
	/**
	 * botun koji koricinka vodi do forme u kojoj se logira
	 */
	private JButton doctor;
	/**
	 * botun koji korisnika vodi na registraciju
	 */
	private JButton registracija;
	/**
	 * botun kojim se izlazi iz aplikacije
	 */
	private JButton kraj;
	/**
	 * objekt tipa Panel_start-panel na kojem se korisnik logira
	 */
	private Panel_start panelStart;
	/**
	 * objekt tipa Registracija-frame na kojem se korisnik registrira
	 */
	private Registracija reg;

	 
	Controller controller;
	
	/**
	 * konstruktor klase Panel_select
	 * u ovom konstruktoru su pozvane metode CreateComp i Akcija
	 */
	public Panel_select() {
		setUndecorated(true);
		//super("GAME");
		setLayout(new GridBagLayout());
		setLayout(new BorderLayout());
		setSize(250,150);
		setVisible(true);
		setResizable(false);
	//	setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		CreateComp();
		Akcija();
		controller=new Controller();
	}

	/**
	 * metoda u kojoj se odvija dogadaj klikanja na botune koji omogucavaju login,
	 * registraciju i izlazak iz aplikacije
	 */
	private void Akcija() {
		
		
		
		  doctor.addActionListener(new ActionListener() {
		  
		  @Override public void actionPerformed(ActionEvent e) { 
			  	panelStart=new Panel_start();
				panelStart.setVisible(true);
				panelStart.setAlwaysOnTop(true);
				
		  
		  } });
		 
		
		
		
		//doctor.addActionListener(invkList);
		
		registracija.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				reg=new Registracija();
			//	panelStart=new Panel_start();
				reg.setVisible(true);
				reg.setAlwaysOnTop(true);
			}
		});
		
		kraj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		
		
		
		
		
		
		
		
	}

	/**
	 * metoda kojom se stvaraju istance klase i razmjesatju komponente na frame-u
	 */
	private void CreateComp() {
		// TODO Auto-generated method stub
		doctor=new JButton("NASTAVI KAO LIJECNIK");
		registracija=new JButton("REGISTRACIJA");
		kraj=new JButton("KRAJ RADA");
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.weightx = 0;
		gbc.weighty = 0.1;
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(doctor,gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(registracija,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(kraj,gbc);
		
	}
	
	
	
	
	

}
