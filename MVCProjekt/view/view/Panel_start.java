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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.Controller;




/**
 * @author Ivana
 * frame na kojem su smjesteni paneli PanelClickToStart i PanelImage
 *
 */
public class Panel_start extends JFrame {

	
	
	/**
	 * panel na kojem se nalazi slika
	 */
	private PanelImage pnelImage;
	/**
	 * objekt klase PanelClickToStart
	 */
	protected PanelClickToStart pcTs;
	/**
	 * objekt klase Panel_dosctor
	 */
	protected Panel_doctor pd=new Panel_doctor();
	/**
	 * varijabla u koju se sprema naziv tablice u bazi
	 */
	private String tablica;
	/**
	 * konstruktor klase Panel_start
	 * u njemu su pozvane metode createComp i Akcija
	 */
	public Panel_start() {
		setUndecorated(true);
		//super("GAME");
		
		setLayout(new BorderLayout());
		setSize(650,450);
		setVisible(true);
		setResizable(false);
	//	setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		setLayout(new BorderLayout());
		
		createComp();
		
		Akcija();
		
	}
	
	
    


	/**
	 * metoda u kojoj se odvija dogadaj prilikom klika na botun
	 * prikazuje se panel_doctor i izlaz iz aplikacije
	 */
	private void Akcija() {
		String table=pcTs.getTf_name().getText()+"_"+pcTs.getTf_surname().getText();
		pcTs.button_quit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//setVisible(false);
				System.exit(0);
			}
		});
		
		pcTs.button_next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			checkData();
			
				
				
			}
		});
		
		
		//pd.Akcija(getTable());
		
		
	}

	/**
	 * metoda kojom se provjerava jesu li svi podaci ispravno uneseni 
	 */
	private void checkData() {
		String name=pcTs.tf_name.getText();
		String surname=pcTs.tf_surname.getText();
		String pass=String.valueOf(pcTs.tf_password.getPassword());
		String table=pcTs.getTf_name().getText()+"_"+pcTs.getTf_surname().getText();
		
		if (name.length()!=0 || surname.length()!=0 || pass.length()!=0) {
			
			
			Controller con=new Controller();
			try {
				con.connect2DB();
				
				boolean f=con.CheckPassword_Registracija(pcTs);
				System.out.println("Zastavica"+f);
				//con.disconnect4DB();
				if (f==false) {
					JOptionPane.showMessageDialog(Panel_start.this, "Nesto nije ispravno popunjeno!");
				}
				else {
					
					
					//con.createTabele();
					
					pd.setAlwaysOnTop(true);
					pd.setVisible(true);
					con.createTabele();
					System.out.println("Panel Start: "+table);
					setTable(table);
					pd.wop.Akcija(table);
					pd.Akcija(table);
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//JOptionPane.showMessageDialog(Panel_start.this, "Sva polja moraju biti popunjena!");
				System.out.println("BLA BLA BLA BLA");
				System.out.println(e);
			}
		
			
			
		}else {
			JOptionPane.showMessageDialog(Panel_start.this, "Sva polja moraju biti popunjena ispravno!");
		}
		
		
		
		
	}

	
	/**
	 * @return table
	 * metoda koja dohvaca ime tablice
	 */
	/*public String getNameTable() {
	
		String table=pcTs.getTf_name().getText()+"_"+pcTs.getTf_surname().getText();
		
		return table;
	}*/
	
	


	public String getTable() {
		return tablica;
	}


	/**
	 * @return table
	 * metoda koja sprema ime tablice
	 */


	public void setTable(String tablica) {
		this.tablica=tablica;
	}





	/**
	 * metoda u kojoj nastaju objekti
	 */
	private void createComp() {
			
			pnelImage=new PanelImage();
			pcTs=new PanelClickToStart();
			add(pnelImage,BorderLayout.WEST);
		 	add(pcTs,BorderLayout.EAST);
	}
	
	
	
}
