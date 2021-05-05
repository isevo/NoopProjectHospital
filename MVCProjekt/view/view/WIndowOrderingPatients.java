package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.Controller;
import model.Pacijent;


public class WIndowOrderingPatients extends JFrame implements PropertyChangeListener{
	/**
	 * botun klikom na kojeg se narucuje pacijent
	 */
	protected JButton order;
	/**
	 * botun klikom na kojeg se izlazi iz programa
	 */
	private JButton kraj;
	
	/**
	 * objekt tipa JLabel
	 */
	private JLabel labela_ime;
	/**
	 * objekt klase JLabel
	 */
	private JLabel labela_prezime;
	/**
	 * objekt klase JLabel
	 */
	/**
	 * objekt klase JLabel
	 */
	private JLabel labela_napomena;
	/**
	 * objekt klase JtextField u koje se unosi ime pacijeta
	 */
	protected JTextField tf_ime;
	/**
	 * objekt klase JTextField u koju se sprema prezime pacijenta
	 */
	protected JTextField tf_prezime;
	/**
	 * objekt klase JTextField u koju se spremaju napomene
	 */
	protected JTextField tf_naputak;
	

	/**
	 * radio button u kojeg se sprema broj god od 0 do 10
	 */
	protected JRadioButton c1_0_10;
	/**
	 * radio button u kojeg se sprema broj godina od 10 do 20
	 */
	protected JRadioButton c2_10_20;
	/**
	 * radio button u kojem se sprema broj godina od 20 do 30
	 */
	protected JRadioButton c3_20_30;
	/**
	 * radio button u kojem se sprema broj godina od 30 do 50
	 */
	protected JRadioButton c4_30_50;
	/**
	 * radio button u kojem se sprema broj godina 50+
	 */
	protected JRadioButton c5_50_vise;
	/**
	 * objekt u kojem se grupiraju radio bottuni
	 */
	private ButtonGroup radioTmeGroup;
	
	
	
	//private DataPanelEvent dpe;
//	private DataPanelListener dpl;
	/**
	 * objekt tipa JLabel 
	 */
	private JLabel godine;
	
	
	private Controller controller;
	
	/**
	 * varijabla tipa long
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	JFormattedTextField  textField = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.SHORT));
	
	/**
	 * konstruktor klase u kojem se postavlja pozicija frame-a, velicina,vidljivost
	 */
	public WIndowOrderingPatients() {
		
		setUndecorated(true);
		
		setLayout(new GridBagLayout());
		setLayout(new BorderLayout());
		setSize(550,350);
		//setVisible(true);
		setResizable(false);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		CreateComp();
		
		//Akcija();
		controller=new Controller();
		
	}

	

	/**
	 * metoda kojom se postavlja dogadaj
	 * postavlja se velicina textFildea u kojem se postavlja danasnji datum
	 * 
	 */
	 void Akcija(String table) {
		 	
			textField.setValue(new Date());
			textField.setPreferredSize(new Dimension(130, 30));
		
			CalendarWindow calendarWindow=new CalendarWindow();
			calendarWindow.addPropertyChangeListener(this);
			
			
			JButton calendarButton = new JButton("Pick a Date");
					
			calendarButton.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
				
				  calendarWindow.setLocation(textField.getLocationOnScreen().x,
						  (textField.getLocationOnScreen().y + textField.getHeight())); 
				  Date d =(Date)textField.getValue(); 
				  calendarWindow.resetSelection(d); 

					// calendarWindow.setUndecorated(true);
					  calendarWindow.setVisible(true);
			    
			  }
			});

			//add the UI controls to the ContentPane
			add(textField);
			add(calendarButton);
			setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		
		
		
		kraj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		
		order.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			try {
				
				int suma=getData();
				if (suma!=0) {
					
					String br_narucenih="";
					
					
					
					
					JOptionPane.showMessageDialog(WIndowOrderingPatients.this, "Osoba je narucena!");
					setVisible(false);
					String date=textField.getText();
					String god;
					
					if (c1_0_10.isSelected()) {
						god="0-10";
					}
					else if (c2_10_20.isSelected()) {
						god="10-20";
					}
					else if (c3_20_30.isSelected()) {
						god="20-30";
					}
					else if (c4_30_50.isSelected()) {
						god="30-50";
					}
					else {
						god="50+";
					}
					 br_narucenih=" "+tf_naputak.getText();
					
					
					Pacijent pacijent=new Pacijent(tf_ime.getText(), tf_prezime.getText(),br_narucenih,date,god);
					System.out.println("---------------------------------------");
					System.out.println(pacijent.getId());
					System.out.println("---------------------------------------");
					
					controller.addToDataBase(pacijent);
					
				//	dpe=new DataPanelEvent(tf_ime.getText(), tf_prezime.getText(), br_narucenih);
					controller.connect2DB();
				//	controller.save2DB();
					controller.joinNametoTable(table);
					
					tf_ime.setText(null);
					tf_prezime.setText(null);
					tf_naputak.setText(null);
				
				}
				else {
					JOptionPane.showMessageDialog(WIndowOrderingPatients.this, "Sva polja moraju biti popunjena!");
					setVisible(true);
				}
				
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
				
				
			}
		});
		
		
		
	}



	/**
	 * metoda u kojoj se kreiraju objekti i razmjestaju na panel
	 */
	private void CreateComp() {
		
		labela_ime=new JLabel("Ime: ");
		labela_prezime=new JLabel("Prezime: ");
		labela_napomena=new JLabel("Napomene: ");
		tf_ime=new JTextField(20);
		tf_prezime=new JTextField(20);
		tf_naputak=new JTextField(20);
		godine=new JLabel("Pogodnosti:");
		
		
		
		
		kraj=new JButton("Kraj");
		
		order=new JButton("SPREMI");

		c1_0_10=new JRadioButton("0-10");
		c2_10_20=new JRadioButton("10-20");
		c3_20_30=new JRadioButton("20-30");
		c4_30_50=new JRadioButton("30-50");
		c5_50_vise=new JRadioButton("50+");
		radioTmeGroup=new ButtonGroup();
		radioTmeGroup.add(c1_0_10);
		radioTmeGroup.add(c2_10_20);
		radioTmeGroup.add(c3_20_30);
		radioTmeGroup.add(c4_30_50);
		radioTmeGroup.add(c5_50_vise);
		
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.weightx = 0;
		gbc.weighty = 0.1;
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(labela_ime,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(labela_prezime,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(labela_napomena,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(tf_ime,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(tf_prezime,gbc);
		
		
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(tf_naputak,gbc);
		
		
		  gbc.gridx = 0; 
		  gbc.gridy = 4; 
		  gbc.anchor=GridBagConstraints.CENTER;
		  
		  add(godine,gbc);
		  
		  
		  gbc.gridx = 0; 
		  gbc.gridy = 5; 
		  gbc.anchor=GridBagConstraints.CENTER;
		  
		  add(c1_0_10,gbc);
		  
		  gbc.gridx = 1; 
		  gbc.gridy = 5; 
		  gbc.anchor=GridBagConstraints.CENTER;
		  
		  add(c2_10_20,gbc);
		  
		  
		  gbc.gridx = 1; 
		  gbc.gridy = 4; 
		  gbc.anchor=GridBagConstraints.CENTER;
		  
		  add(c3_20_30,gbc);
		  
		 gbc.gridx = 2; 
		 gbc.gridy = 4; 
		 gbc.anchor=GridBagConstraints.CENTER;
		  
		  add(c4_30_50,gbc);
		 
		  
		gbc.gridx = 2; 
		gbc.gridy = 5; 
		gbc.anchor=GridBagConstraints.CENTER;
			  
		add(c5_50_vise,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(order,gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 6;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(kraj,gbc);
		
		
		
		
		
	}
	
	/* (non-Javadoc)
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 * dohvaca se vrijednost datuma koju korisnik odabere i postavlja se na textfield
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		//get the selected date from the calendar control and set it to the text field
		if (evt.getPropertyName().equals("selectedDate")) {
            
			java.util.Calendar cal = (java.util.Calendar)evt.getNewValue();
			Date selDate =  cal.getTime();
			textField.setValue(selDate);
        }
		
	}
	
	/**
	 * @return suma
	 * metoda kojom se ispituje jesu li uneseni svi podaci
	 */
	private int getData() {
		int ime=tf_ime.getText().length();
		int prezime=tf_prezime.getText().length();
		int simptomi=tf_naputak.getText().length();
		int c=0;
		if (c1_0_10.isSelected() || c2_10_20.isSelected() || c3_20_30.isSelected() || c5_50_vise.isSelected() || c4_30_50.isSelected()) {
			c=1;
		}
		
		int suma=0;
		if (ime!=0 && prezime!=0 && simptomi!=0 && c!=0) {
			suma=ime+prezime+simptomi+c;
		}
		else {
			suma=0;
		}
		return suma;
	
	}



	
	
	
	

}
