package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class panel_medicals extends JFrame{
	/**
	 *objekt klase JtextField  u koju se unosi ime pacijenta
	 */
	private JTextField tf_name;
	/**
	 * objekt klase JtextField  u koju se unosi prezime pacijenta
	 */
	private JTextField tf_surname;
	/**
	 * objekt tipa JLabel
	 */
	private JLabel label_name;
	/**
	 * objekt tipa JLabel
	 */
	private JLabel label_surname;
	/**
	 * objekt tipa JLabel
	 */
	private JLabel labela_text;
	/**
	 * objekt tipa JTextArea 
	 */
	private JTextArea txtArea;
	/**
	 *botun klikom na kojeg se salje lijek u ljekarnu
	 */
	private JButton button;

	
	/**
	 * konstruktor klase panel_medicals
	 */
	public panel_medicals() {
		setUndecorated(true);
		//super("GAME");
		setLayout(new GridBagLayout());
		setLayout(new BorderLayout());
		setSize(450,350);
		setVisible(true);
		setResizable(false);
	//	setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		CreateComp();
		Akcija();
		setDimension();
		
	}

	/**
	 * metoda kojom se postavlja dimenzija panela
	 */
	private void setDimension() {
		Dimension dim=new Dimension();
		dim.width=320;
		dim.height=350;
		setPreferredSize(dim);
		
	}

	/**
	 * metoda kojom se provjera dogadaj -klikom na botun dogodi se radnja
	 */
	private void Akcija() {
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				int suma=0;
				if (tf_name.getText().length()!=0 && tf_surname.getText().length()!=0 && txtArea.getText().length()!=0) {
					JOptionPane.showMessageDialog(panel_medicals.this, "Poslano u ljekarnu!");
					setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(panel_medicals.this, "Polja moraju biti popunjena!");
				}
				
				
				
			
				
			}
		});
		
		
		
	}

	/**
	 * metoda kojom se stvaraju objekti i rasporeduju na panel preko kordinata
	 */
	private void CreateComp() {
		tf_name=new JTextField(10);
		tf_surname=new JTextField(10);
		label_name=new JLabel("Ime pacijenta");
		label_surname=new JLabel("Prezime pacijenta");
		labela_text=new JLabel("Mjere i propisi konzumacije lijeka");
		txtArea=new JTextArea();
		button=new JButton("SALJI");
		
		
		//razmjestaj
		
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.weightx = 0;
		gbc.weighty = 0.1;
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(label_name,gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(label_surname,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor=GridBagConstraints.CENTER;
		add(labela_text,gbc);
		
		
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor=GridBagConstraints.CENTER;
		
		txtArea.setPreferredSize(new Dimension(200, 250));
		
		add(new JScrollPane(txtArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS),
				gbc);
		
		
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(tf_name,gbc);
		
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(tf_surname,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.anchor=GridBagConstraints.CENTER;
		
		add(button,gbc);
		
		
		
		
		
	}
	
	
	
	
}
