
package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.Controller;
import model.Pacijent;




/**
 * @author Ivana
 *
 *Panel sa kojeg se narucuje pacijent i ispisuju podaci iz baze u txtARea
 */
public class Panel_doctor extends JFrame{
	
	/**
	 * objekt panela Panel_west
	 */
	protected Panel_west pw;
	/**
	 * objekt panela panel_north
	 */
	private panel_north pn;
	/**
	 * objekt panela panel_center
	 */
	private panel_center pc;
	/**
	 * objekt panela panel_south
	 */
	private panel_south ps;
	/**
	 * objekt panela WindowOrderingPatients
	 */
	protected WIndowOrderingPatients wop=new WIndowOrderingPatients();
	/**
	 * varijabla tipa int u koju se sprema broj narucenih za danasnji dan
	 */
	private int broj_narucenih;
	
	/**
	 * 
	 */
	//private DataPanelEvent dpe;
	
	/**
	 * objekt tipa PieChartFrame  
	 */
	PieChartFrame pcf;
	//private JLabel labela;
	
	/**
	 * Objekt tipa controller
	 */
	private Controller controller;
	
	
	/**
	 * konstruktor klase Panel_dosctor u kojem e postavlja velicina okvira,vidljivost i lokacija
	 */
	public Panel_doctor() {
		
		setLayout(new BorderLayout());
		
		
		
		setUndecorated(true);
		//super("GAME");
		setLayout(new GridBagLayout());
		setLayout(new BorderLayout());
		setSize(750,450);
	//	setVisible(true);
		setResizable(false);
	//	setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		CreateComp();
		
		
		controller=new Controller();
		
		
		
	//	Akcija();
	
		
		
		
		
	}

	/**
	 * metoda u kojoj se odvijaju događaji prilikom klika na buttone
	 */
	 void Akcija(String table) {
		
		//dpe=new DataPanelEvent();
		
		
		pw.kraj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		pw.booking.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				wop.setVisible(true);
			}
		});
	/*	pn.narudzbaLjekova.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel_medicals pnm=new panel_medicals();
				pnm.setAlwaysOnTop(true);
				pnm.setVisible(true);
				
			}
		});
		*/
		ps.showPatients.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Controller controller=new Controller();
				try {
					controller.connect2DB();
					
					controller.load4DB(table);
					controller.disconnect4DB();
					controller.Ispis(pc,true);
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
		pw.button_br_narucenih.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			//	 controller=new Controller();
				try {
					controller.connect2DB();
					broj_narucenih=	controller.checkDate(table);
					
				
					controller.PrikazNaLabeli(pw);
				
					controller.Ispis(pc,false);
					
				//	dpe.setBroj_narucenih(broj_narucenih+"");
				
					controller.disconnect4DB();
					
					
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		pn.pogledaj_statistiku.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
			try {
				
				controller.connect2DB();
				pcf=new PieChartFrame();
				//BarChart bc =new BarChart();
				controller.loadnumbOFpatint_year(pcf.barchart,table);
				
				
					/*
					 * JFrame frame = new JFrame(); frame.getContentPane().add(new BarChart());
					 * frame.setSize(350, 350); frame.setVisible(true); frame.setResizable(false);
					 */
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
				
				
				
			}
		});
		
		
		
	}

	/**
	 * metoda u kojoj se instanciraju klase
	 */
	private void CreateComp() {
		// TODO Auto-generated method stub
		pw=new Panel_west();
		pn=new panel_north();
		pc=new panel_center();
		ps=new panel_south();
		
		
		
		add(pw,BorderLayout.WEST);
		add(pn,BorderLayout.NORTH);
		add(pc,BorderLayout.CENTER);
		add(ps,BorderLayout.SOUTH);
	}

	/**
	 * @return broj narucenih
	 * metoda u kojoj se dohvaca broj narucenih za danasnji dan
	 */
	public int getBroj_narucenih() {
		return broj_narucenih;
	}

	/**
	 * @param broj_narucenih
	 * 
	 * 
	 * metoda kojom se dohvaca broj narunenih za danasnji dan
	 */
	public void setBroj_narucenih(int broj_narucenih) {
		this.broj_narucenih = broj_narucenih;
	}
	
	
	
}
