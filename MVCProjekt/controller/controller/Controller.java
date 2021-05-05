package controller;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

import model.DataBase;
import model.Lijecnik;
import model.Pacijent;
import view.PieChart;
import view.PanelClickToStart;
import view.Panel_doctor;
import view.Panel_start;
import view.Panel_west;
import view.panel_center;


/**
 * @author Ivana
 *	posrednik sa klasam iz view paketa
 */
public class Controller {

	/**
	 * objekt klase DataBase
	 */
	private DataBase db;
	/**
	 * array lista u kojoj se spremaju objekti tipa Pacijent
	 */
	private LinkedList<Pacijent> pacijent;
	
	/**
	 * array lista u kojoj se spremaju objekti tipa Lijecnik
	 */
	private LinkedList<Lijecnik> lijecnik;
	/**
	 * objekt tipa Connection
	 */
	private Connection con;
	/**
	 * skup u kojem se spremaju prezimena koja se ne ponavljaju
	 */
	private Set<String>surname_list;
	/**
	 * varijabla koja sluzi za dohvacanje id-a
	 */
	private int id;
	/**
	 * skup u kojem se spremaju imena koja se ne ponavljaju
	 */
	private Set<String>name;
	/**
	 * objekt tipa pacijent
	 */
	Pacijent p=new Pacijent();
	/**
	 * objekt tipa lijecnik
	 */
	Lijecnik l=new Lijecnik();
	
	//private Highlighter.HighlightPainter painter;
	/**
	 * lista dnevnih pacijenata
	 */
	private ArrayList<Pacijent>lista_date_patients;
	
	private ArrayList<Lijecnik>lista_lijecnik=new ArrayList<>();
	
	/**
	 * brojac za godine 0-10
	 */
	private int brojac_god_0_10=0;
	/**
	 * brojac za godine 10-20
	 */
	private int brojac_god_10_20=0;
	/**
	 * brojac za godine 20-30
	 */
	private int brojac_god_20_30=0;
	/**
	 * brojac za godine 30-50
	 */
	private int brojac_god_30_50=0;
	/**
	 * brojac za godine 50+
	 */
	private int brojac_god_50_vise=0;
	
	
	/**
	 * lista lijecnika koji su registrirani prije novog registriranog
	 */
	ArrayList<Lijecnik>lista_prije=new ArrayList<>();
	
	
	/**
	 * varijabla koja dohvaca index iz baze
	 */
	private int index=0;
	
	/**
	 * ime posljednjeg koji se logirao
	 */
	private String name_last_login;
	/**
	 * prezime posljednjeg koji se prijavio
	 */
	private String surname_last_login;
	/**
	 * lozinka posljednjeg koji se ulogirao
	 */
	private String password_last_login;
	
	//private Person per;
	
	/**
	 * varijabla koji broji broj elemenatau bazi
	 */
	private int brojac;
	
	
	/**
	 * zastavica pomocu koje se provjerava ime,prezime i lozinka onoga tko se registrira
	 */
	private boolean f=false;
	
	
	
	
	private Pacijent PACIJENT;
	private ArrayList<Pacijent>lista_pacijenata;
	
	//private String tableName;
	
	/**
	 * konstruktor
	 */
	public Controller() {
		// TODO Auto-generated constructor stub
	
		db=new DataBase();
		
		surname_list=new HashSet<String>();
		name=new HashSet<String>();
		lista_date_patients=new ArrayList<>();
		lista_pacijenata=new ArrayList<>();
	}
	
	/**
	 * @param pacijent
	 * metoda koa se povezuje sa klasom DataBase i sprema pacijenta
	 */
	public void addToDataBase(Pacijent pacijent) {
		//pacijent.setId(id);
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		System.out.println(pacijent.toString());
		db.addPacijent(pacijent);
	}
	
	/**
	 * @param li
	 * metoda kojom se spaja sa klasom DataBase i sprema objekt tipa Lijecnik
	 */
	public void addDoctorTOdataBase(Lijecnik li) {
		li.setId(id);
		db.addLijecnik(li);
	}
	
	
	
	/**
	 * @return db.getAll4DB();
	 * metoda koja dohvaca elemente iz klase DataBase a spremljeni su u listi 
	 */
	public LinkedList<Pacijent> getPacijent() {
		
		return db.getAll4DB();
	}
	
	
	/**
	 * @return
	 *  metoda koja dohvaca elemente iz klase DataBase a spremljeni su u listi 
	 */
	public LinkedList<Lijecnik> getLijecnik() {
		return db.getAllDoctors4DB();
	}
	
	
	
	
	//za tablicu ne ce trebat
	/*public void forwardData(DataPanelEvent dpe,TableData td ) {
		td.setDataOnTxtArea(dpe.toString());
	}*/
	
	
	/**
	 * @param pc objekt klase panel_center
	 * metoda kojom se brise sve sto je txtArea
	 */
	public void setTextOnTxtArea(panel_center pc) {
		pc.Brisanje();
	}
	
	/**
	 * @param pc objekt klase panel_center
	 * metoda kojom se ispisuje sve sto je u bazi u txtArea
	 */
	public void Ispis(panel_center pc,boolean flag) {
		//System.out.println("jwdkjdxjk");
		String t="";
	//	System.out.println("Lista pacijenata: -----_------->"+lista_pacijenata.toString());
		System.out.println(pacijent.toString());
		for (int i = 0; i < pacijent.size(); i++) {
			//pacijent.get(i).setId(i+1);
			
		
			//System.out.println("wkdk");
				
			t=t+"ID:	"+i+" 	IME: 	"+pacijent.get(i).getIme()+"\n"+
			"PREZIME:		"+pacijent.get(i).getPrezime()+" STATUS:		"+pacijent.get(i).getSimptomi()+"\n"
			+"DATUM: "+pacijent.get(i).getDate()+"\n";
			
			index=i;
			
		}
		//System.out.println(lista);
		
		
		pc.Ispis(t);
	//	tvp.setDataOnPresArea(t);
		
	}
	/**
	 * @param pw objet klase Panel_west
	 * metoda kojom se na labeli prikazuje broj danasnjih narucenih pacijenata
	 * 
	 */
	public void PrikazNaLabeli(Panel_west pw) {
		int s=pacijent.size();
		
		pw.getLabela().setText(String.valueOf(s));
		
	}


	


	


	/**
	 * @return
	 * metoda koja vraca index tj id iz baze
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @throws SQLException
	 * metoda kojom se povezuje program sa bazom
	 */
	public void connect2DB() throws SQLException {
		pacijent=getPacijent();
		System.out.println("Connecting to database...");
		try {
			// load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// obtain connection
			String url = "jdbc:mysql://db4free.net:3306/projectdatabase"; // your database
			String user = "ivana1"; // your username
			String password = "463f1f38"; // your password
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to -> " + con.toString());
		} catch (ClassNotFoundException e) {
			System.out.println("Could not load driver!!!");
		}
		
	}

	/**
	 * @throws SQLException
	 * metoda kojom se spremaju podaci u bazu
	 */
	public void save2DB() throws SQLException{
		pacijent=getPacijent();
		// assume that connection is successfully established
				if(con != null) {
					// SQL queries
					String cntSql = "select count(*) as count from Pacijenti where id = ?";
					String sql="select * from Pacijenti";
					
					String insSql = "insert into Pacijenti (id, name, surname, simptoms,date,year) values (?,?,?,?,?,?)";
					String updSql = "update Pacijent set id= ?, name = ?, surname = ?, simptoms = ?, date=?, year=?";
					// statements
					PreparedStatement cntStm = con.prepareStatement(cntSql);
					PreparedStatement insrStm = con.prepareStatement(insSql);
					PreparedStatement updStm = con.prepareStatement(updSql);
					
					PreparedStatement ps=con.prepareStatement(sql);
					ResultSet slcResult = ps.executeQuery();
					
					Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				      //Retrieving the data
				    ResultSet rs = stmt.executeQuery("select * from Pacijenti");
				    brojac=0;
				    while (slcResult.next()) {
				    	int id = slcResult.getInt(1);
						String name = slcResult.getString(2);
						String email = slcResult.getString(3);
						System.out.println(email);
						surname_list.add(email);
						this.name.add(name);
						brojac++;
						
					}
				    System.out.println(pacijent.size());
					System.out.println("BROJ REDAKA "+brojac);
				  
					
					p.setId(brojac+1);
				    //AKO POSTOJE PODACI U BAZI
				    
						pacijent.add(p);
					
						
						// checking all programmers
						for(Pacijent pac: pacijent) {
							int id = pac.getId(); // for now we only need this
							String name=pac.getIme();
							String email=pac.getPrezime();
							String status=pac.getSimptomi();
							String date=pac.getDate();
							String year=pac.getGodine();
							
							System.out.println(name);
							cntStm.setInt(1, id);
							ResultSet result = cntStm.executeQuery();
							result.next();

							int cnt = result.getInt(1);
							
							
							
							
							System.out.println("Cnt -> " + cnt);
							
							
							if (!surname_list.contains(email) ) {
								if(cnt == 0) {
									//if (rs.next()==true) {
																			
										
										
										System.out.println("Inserting new person -> " + p.getId());
										// insert commands
										int col = 1;
										insrStm.setInt(col++, p.getId());
										insrStm.setString(col++, name);
										insrStm.setString(col++, email);
										insrStm.setString(col++, status);
										insrStm.setString(col++, date);
										insrStm.setString(col++, year);
										insrStm.executeUpdate();
									//}
								
									
									
								} 
								else {
									System.out.println("Updating person -> " + p.getId());
									// update commands
									/*int col = 1;
									updStm.setString(col++, name);
									updStm.setString(col++, email);
									updStm.setString(col++, status);
									updStm.setString(col++, service);
									updStm.setString(col++, registration);
									updStm.setString(col++, info);
									updStm.setString(col++, additional);
									updStm.setInt(col++, p.getId());

									updStm.executeUpdate();*/
									
									System.out.println("Inserting new person -> " + p.getId());
									// insert commands
									int col = 1;
									insrStm.setInt(col++, p.getId());
									insrStm.setString(col++, name);
									insrStm.setString(col++, email);
									insrStm.setString(col++, status);
									insrStm.setString(col++, date);
									insrStm.setString(col++, year);
									insrStm.executeUpdate();
									
									
									
									
								}
							}
							else {
								System.out.println("Taj vec postoji u bazi!");
							}
							
							}
							
							
							
					// closing I/O streams 
					cntStm.close();
					insrStm.close();
					updStm.close();
			
			
			
				}

		
	}

	/**
	 * @throws SQLException
	 * metoda kojom se odspaja sa baze
	 */
	public void disconnect4DB() throws SQLException{
		if (con!=null) {

			con.close();
			System.out.println("Disconnected from DB....");
			
		}
		else {
			System.out.println("Already close!");
		}
		
	}

	/**
	 * @param table ime tablice
	 * @throws SQLException
	 * 
	 * metoda koja se za svakog novog registriranog konektira sa njegovovm odgovarajucom bazom
	 */
	public void load4DB(String table) throws SQLException{
		pacijent=getPacijent();
		
		
		//String table_name=getTableName();
		// TODO Auto-generated method stub
		if(con != null) {
			System.out.println("Loading from DB...");
			System.out.println(pacijent.toString());
			String slctSQL = "select id, name,surname,simptoms,date,year  from "+table+" order by id ";
			PreparedStatement slcStm = con.prepareStatement(slctSQL);

			ResultSet slcResult = slcStm.executeQuery();
			pacijent.clear(); // empty local database

			while(slcResult.next()) {
				int id = slcResult.getInt(1);
				String name = slcResult.getString(2);
				String prezime = slcResult.getString(3);
				String simptomi=slcResult.getString(4);
				String date=slcResult.getString(5);
				String year=slcResult.getString(6);
				//System.out.println(name);
			//	System.out.println("Date: "+date);
				//System.out.println(year);
				
				Pacijent pa=new Pacijent(name, prezime, simptomi,date,year);
				pacijent.add(pa);
			}
			//System.out.println(persons.get(3).getName());
			System.out.println();
			System.out.println(pacijent.toString());
			
			
			slcResult.close();
			slcStm.close();
		}
		
	}

	/**
	 * @return brojac
	 * metoda kojom se dohvaca broj redaka u bazi
	 * 
	 */
	public int getBroj_redka() {
		return brojac;
	}

	
	/**
	 * @return broj redaka
	 * metoda kojom se dohvaca broj redaka u bazi
	 */
	public int BrojRedakaUPunojBazi() {
		int broj_redaka=getBroj_redka();
		return broj_redaka;
	}
	
	
	/*public void Delete(panel_center pc) {
		pc.Brisanje();
	}*/
	

	
	
	/**
	 * @param table
	 * @return
	 * @throws SQLException
	 * meoda kojom se provjerava datum za svakog pacijenta
	 */
	public int checkDate(String table)throws SQLException {
		pacijent=getPacijent();
		
		System.out.println("Tablica check date "+table);
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yy");  
		   LocalDateTime now = LocalDateTime.now();  
		 //  System.out.println(dtf.format(now).toString());  
		   String d=dtf.format(now).toString();
		
		// TODO Auto-generated method stub
		if(con != null) {
			
		
			System.out.println("Loading from DB...");
			String slctSQL = "select id, name,surname,simptoms,date,year  from "+table+" order by name ";
			PreparedStatement slcStm = con.prepareStatement(slctSQL);
			
			 ResultSet  slcResult = slcStm.executeQuery();
			 
			 
			
			 
			 
			pacijent.clear(); // empty local database

			while(slcResult.next()) {
				int id = slcResult.getInt(1);
				String name = slcResult.getString(2);
				String prezime = slcResult.getString(3);
				String simptomi=slcResult.getString(4);
				String date=slcResult.getString(5);
				String year=slcResult.getString(6);
				//System.out.println(d);
				//System.out.println(date);
				//lista_date_patients.add(date);
				
				if (date.equals(d)) {
					brojac++;
					Pacijent pa=new Pacijent(name, prezime, simptomi,date,year);
					pacijent.add(pa);
					
					
				}
				
				
				
			}
			//System.out.println(persons.get(3).getName());
			
		
			
			
			slcResult.close();
			slcStm.close();
		}
		
		
		return brojac;
	
		
		
	}
	
	/**
	 * @param bc
	 * @param table
	 * @throws SQLException
	 *
	 * metoda kojom se za svakog registriranog korisnika spaja s njegovovom bazom i ispisuju podaci iz tocno te teablice
	 */
	public void loadnumbOFpatint_year(PieChart bc,String table) throws SQLException{
		pacijent=getPacijent();
		// TODO Auto-generated method stub
		if(con != null) {
			System.out.println("Loading from DB...");
			String slctSQL = "select id, name,surname,simptoms,date,year  from "+table+" order by name ";
			PreparedStatement slcStm = con.prepareStatement(slctSQL);

			ResultSet slcResult = slcStm.executeQuery();
			pacijent.clear(); // empty local database

			while(slcResult.next()) {
				int id = slcResult.getInt(1);
				String name = slcResult.getString(2);
				String prezime = slcResult.getString(3);
				String simptomi=slcResult.getString(4);
				String date=slcResult.getString(5);
				String year=slcResult.getString(6);
			//	System.out.println("Date: "+date);
				//System.out.println(year);
				if (year.equals("0-10")) {
					brojac_god_0_10++;
				}
				else if (year.equals("10-20")) {
					brojac_god_10_20++;
				}
				else if (year.equals("20-30")) {
					brojac_god_20_30++;
				}
				else if (year.equals("30-50")) {
					brojac_god_30_50++;
				}
				else {
					brojac_god_50_vise++;
				}
				
				bc.setGrey(brojac_god_0_10);
				bc.setWhite(brojac_god_10_20);
				bc.setDarkGray(brojac_god_20_30);
				bc.setBlack(brojac_god_30_50);
				bc.setLightGfray(brojac_god_50_vise);
				
				
				Pacijent pa=new Pacijent(name, prezime, simptomi,date,year);
				pacijent.add(pa);
			}
			//System.out.println(persons.get(3).getName());
			System.out.println("0-10 "+brojac_god_0_10);
			System.out.println("10-20 "+brojac_god_10_20);
			System.out.println("20-30 "+brojac_god_20_30);
			System.out.println("30-50 "+brojac_god_30_50);
			System.out.println("50+ "+brojac_god_50_vise);
			
			
			slcResult.close();
			slcStm.close();
		}
		
	}

	/**
	 * @throws SQLException
	 * metoda kojom se lijecnici spremaju u bazu
	 */
	public void saveDoctor2DB() throws SQLException{
				lijecnik=getLijecnik();
				// assume that connection is successfully established
				if(con != null) {
					// SQL queries
					String cntSql = "select count(*) as count from lijecnik where ID = ?";
					String sql="select * from lijecnik";
					
					String insSql = "insert into lijecnik (ID, IME, PREZIME, PASSWORD) values (?,?,?,?)";
					String updSql = "update lijecnik set ID= ?, IME = ?, PREZIME = ?, PASSWORD = ?";
					// statements
					PreparedStatement cntStm = con.prepareStatement(cntSql);
					PreparedStatement insrStm = con.prepareStatement(insSql);
					PreparedStatement updStm = con.prepareStatement(updSql);
					
					PreparedStatement ps=con.prepareStatement(sql);
					ResultSet slcResult = ps.executeQuery();
					
					System.out.println("---------------");
					//System.out.println(lijecnik);
					
					
					Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				      //Retrieving the data
				    ResultSet rs = stmt.executeQuery("select * from lijecnik");
				    brojac=0;
				    while (slcResult.next()) {
				    	int id = slcResult.getInt(1);
						String name = slcResult.getString(2);
						String surname = slcResult.getString(3);
					System.out.println(name+" "+surname);
						
						brojac++;
						
					}
				  //  System.out.println(lista_lijecnik.size());
					System.out.println("BROJ REDAKA "+brojac);
				  
					
					l.setId(brojac+1);
				    //AKO POSTOJE PODACI U BAZI
				    
						
					System.out.println(lijecnik.get(0).getPassword());
						
						// checking all programmers
						for(Lijecnik pac: lijecnik) {
							int id = pac.getId(); // for now we only need this
							String name=pac.getName();
							String surname=pac.getPrezime();
							String password=pac.getPassword();
							
							System.out.println(name+" "+surname);
							cntStm.setInt(1, id);
							ResultSet result = cntStm.executeQuery();
							result.next();

							int cnt = result.getInt(1);
							
							
							
							
							System.out.println("Cnt -> " + cnt);
							
							
							
								if(cnt == 0) {
									//if (rs.next()==true) {
																			
										
										
										System.out.println("Inserting new person -> " + l.getId());
										// insert commands
										int col = 1;
										insrStm.setInt(col++, l.getId());
										insrStm.setString(col++, name);
										insrStm.setString(col++, surname);
										insrStm.setString(col++, password);
										
										insrStm.executeUpdate();
										
									//}
								
									
									
								} 
								else {
									System.out.println("Updating person -> " + l.getId());
									// update commands
									/*int col = 1;
									updStm.setString(col++, name);
									updStm.setString(col++, email);
									updStm.setString(col++, status);
									updStm.setString(col++, service);
									updStm.setString(col++, registration);
									updStm.setString(col++, info);
									updStm.setString(col++, additional);
									updStm.setInt(col++, p.getId());

									updStm.executeUpdate();*/
									
									System.out.println("Inserting new person -> " + l.getId());
									// insert commands
									int col = 1;
									insrStm.setInt(col++, l.getId());
									insrStm.setString(col++, name);
									insrStm.setString(col++, surname);
									insrStm.setString(col++, password);
									
									insrStm.executeUpdate();
									
									
									
									
								}
							}
							
							
							
							
					// closing I/O streams 
					cntStm.close();
					insrStm.close();
					updStm.close();
			
			
			
				}

		
	}

	
	/**
	 * @param pcts
	 * @return
	 * @throws SQLException
	 * metoda kojom se prilikom logina provjerava da li pasword,ime i prezime odgovara onoj u bazu 
	 */
	public boolean CheckPassword_Registracija(PanelClickToStart pcts) throws SQLException {
		lijecnik=getLijecnik();
		
		// TODO Auto-generated method stub
		if(con != null) {
			
		
			System.out.println("Loading from DB...");
			String slctSQL = "select ID, IME,PREZIME,PASSWORD  from lijecnik order by IME ";
			PreparedStatement slcStm = con.prepareStatement(slctSQL);

			 ResultSet  slcResult = slcStm.executeQuery();
			pacijent.clear(); // empty local database
		/*	if (slcResult.next()==false) {
				f=false;
			}*/
		
		
			
			
			
			while(slcResult.next()) {
				int id = slcResult.getInt(1);
				String name = slcResult.getString(2);
				String prezime = slcResult.getString(3);
				String password=slcResult.getString(4);
				
				String pass=String.valueOf(pcts.getTf_password().getPassword());
				
				
				System.out.println("IME       "+name+ " PREZIME "+prezime+" PASSWORD "+password);
				System.out.println("PASS "+pass);
				//System.out.println(name);
					System.out.println(pcts.getTf_name().getText()+"--------------->"+name);
				
		/*		if (pcts.getTf_name().getText().equals(name)==true) {
					System.out.println("true");
				}
				else {
					System.out.println("false");
				}
				*/
				
				
				if (pcts.getTf_name().getText().equals(name)==true && pcts.getTf_surname().getText().equals(prezime)==true &&  pass.equals(password)==true) {
					System.out.println("----------------------->"+true);
					setName_last_login(name);
					setSurname_last_login(prezime);
					setPassword_last_login(password);
					f=true;
					break;
				}
				
				
				System.out.println(f);
				
			}
			//System.out.println(persons.get(3).getName());
			
		//	System.out.println(f);
			
			slcResult.close();
			slcStm.close();
		}
		
		System.out.println("flag before "+f);
		
		return f;
		
		
	}
	
	
	/**
	 * @throws SQLException
	 * metoda koja dohvaca sve one koji su bili registrirani prije nego sto se novi korisnik ulogiraos
	 */
	public void getRegisterBefore () throws SQLException{
		
		lijecnik=getLijecnik();
		boolean f=true;
		// TODO Auto-generated method stub
		if(con != null) {
			
		
			System.out.println("Loading from DB...");
			String slctSQL = "select ID, IME,PREZIME,PASSWORD  from lijecnik order by IME ";
			PreparedStatement slcStm = con.prepareStatement(slctSQL);

			 ResultSet  slcResult = slcStm.executeQuery();
			pacijent.clear(); // empty local database
			
			while(slcResult.next()) {
				
				int id = slcResult.getInt(1);
				String name = slcResult.getString(2);
				String prezime = slcResult.getString(3);
				String password=slcResult.getString(4);
				//System.out.println(name);
				
				Lijecnik reg_li=new Lijecnik(name, prezime, password);
				lista_prije.add(reg_li);
				
			}
			//System.out.println(persons.get(3).getName());
			
			slcResult.close();
			slcStm.close();
		}
		
		
		
		System.out.println(lista_prije.toString());
		
	}
	
	
	
	/**
	 * @throws SQLException
	 * metoda kojom se pravi tablica u MySql bazi
	 */
	public void createTabele() throws SQLException{
		
		String table_name=getName_last_login()+"_"+getSurname_last_login();
		System.out.println("TN "+table_name);
	//	setTableName(table_name);
	/*	if (con!=null) {
			String createTableSQL = "create table if not exists "+table_name+"(id INT,name TEXT,surname TEXT,simptoms TEXT );";
			PreparedStatement ps=con.prepareStatement(createTableSQL);
			ResultSet slcResult = ps.executeQuery();
			
			
		}*/
		
		Statement stmt = null;
		System.out.println("Creating table in given database...");
	     stmt = con.createStatement();
	     
	     
	     String sql="create table if not exists "+table_name+"(id INT,name TEXT,surname TEXT,simptoms TEXT,date TEXT,year TEXT );";
	    stmt.executeUpdate(sql);
	     
	      System.out.println("Created table in given database...");
		
	}
	
	
	
	
	
	
/**
 * @param table
 * @throws SQLException
 * 
 * metoda kojom se ukogirana osoba pridruzuje svojoj bazi
 * 
 */
public void joinNametoTable(String table)  throws SQLException{
	pacijent=getPacijent();
	
	//System.out.println(pacijent.toString());
	// assume that connection is successfully established
			if(con != null) {
				// SQL queries
				String cntSql = "select count(*) as count from "+table+" where id = ?";
				String sql="select * from "+table;
				
				String insSql = "insert into "+table+" (id, name, surname, simptoms,date,year) values (?,?,?,?,?,?)";
				String updSql = "update "+table+" set id= ?, name = ?, surname = ?, simptoms = ?, date=?, year=?";
				// statements
				PreparedStatement cntStm = con.prepareStatement(cntSql);
				PreparedStatement insrStm = con.prepareStatement(insSql);
				PreparedStatement updStm = con.prepareStatement(updSql);
				
				PreparedStatement ps=con.prepareStatement(sql);
				ResultSet slcResult = ps.executeQuery();
				
				Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			      //Retrieving the data
			    ResultSet rs = stmt.executeQuery("select * from "+table);
			    brojac=0;
			    while (slcResult.next()) {
			    	int id = slcResult.getInt(1);
					String name = slcResult.getString(2);
					String surname = slcResult.getString(3);
					String simptoms=slcResult.getString(4);
					String date=slcResult.getString(4);
					String y=slcResult.getString(6);
					System.out.println(name);
					surname_list.add(surname);
					this.name.add(name);
					brojac++;
					PACIJENT=new Pacijent(name, surname, simptoms, date, y);
					lista_pacijenata.add(PACIJENT);
				}
			    System.out.println(pacijent.toString());
				System.out.println("BROJ REDAKA "+brojac);
			  
				
				p.setId(brojac+1);
			    //AKO POSTOJE PODACI U BAZI
			    
					
				
					
					// checking all programmers
					for(Pacijent pac: pacijent) {
						//int id = pac.getId(); // for now we only need this
						int id=p.getId();
						String name=pac.getIme();
						String prezime=pac.getPrezime();
						String simptomi=pac.getSimptomi();
						String date=pac.getDate();
						String year=pac.getGodine();
						
						pac.setId(id);
						System.out.println(name+" ID "+id);
						cntStm.setInt(1, id);
						ResultSet result = cntStm.executeQuery();
						result.next();
						
						
						
						
						
						
						
						
						int cnt = result.getInt(1);
						
						
						//lista_pacijenata.add(p);
						System.out.println("Cnt -> " + cnt);
						
						
						if (!surname_list.contains(prezime) ) {
							if(cnt == 0) {
								//if (rs.next()==true) {
																		
									
									
									System.out.println("Inserting new person -> " + p.getId());
									// insert commands
									int col = 1;
									insrStm.setInt(col++, p.getId());
									insrStm.setString(col++, name);
									insrStm.setString(col++, prezime);
									insrStm.setString(col++, simptomi);
									insrStm.setString(col++, date);
									insrStm.setString(col++, year);
									insrStm.executeUpdate();
								//}
							
								
								
							} 
							else {
								System.out.println("Updating person -> " + p.getId());
								// update commands
								/*int col = 1;
								updStm.setString(col++, name);
								updStm.setString(col++, email);
								updStm.setString(col++, status);
								updStm.setString(col++, service);
								updStm.setString(col++, registration);
								updStm.setString(col++, info);
								updStm.setString(col++, additional);
								updStm.setInt(col++, p.getId());

								updStm.executeUpdate();*/
								
								System.out.println("Inserting new person -> " + p.getId());
								// insert commands
								int col = 1;
								insrStm.setInt(col++, p.getId());
								insrStm.setString(col++, name);
								insrStm.setString(col++, prezime);
								insrStm.setString(col++, simptomi);
								insrStm.setString(col++, date);
								insrStm.setString(col++, year);
								insrStm.executeUpdate();
								
								
								
							}
						}
						else {
							System.out.println("Taj vec postoji u bazi!");
							System.out.println(pacijent.toString());
						}
						
						}
				//	pacijent.clear();
				//	pacijent.add(PACIJENT);
				
					System.out.println(pacijent.toString()+"================"+p.getId());
						
						
				// closing I/O streams 
				cntStm.close();
				insrStm.close();
				updStm.close();
		
		
		
			}
		
}
	
	
	
	


	/**
	 * @return name_last_login
	 * metoda kojom se dohvaca ime zadnjeg ulogiranog
	 */
	
	public String getName_last_login() {
		
		return name_last_login;
	}
	/**
	 * @return name_last_login
	 * metoda kojom se sprema ime zadnjeg ulogiranog
	 */

	public void setName_last_login(String name_last_login) {
		this.name_last_login = name_last_login;
	}
	/**
	 * @return name_last_login
	 * metoda kojom se dohvaca prezime zadnjeg ulogiranog
	 */
	public String getSurname_last_login() {
		return surname_last_login;
	}

	/**
	 * @param surname_last_login
	 * metoda kojom se sprema prezime zadnjeg ulogiranog
	 */
	public void setSurname_last_login(String surname_last_login) {
		this.surname_last_login = surname_last_login;
	}

	/**
	 * @return password_last login
	 * metoda kojom se dohvaca lozinka zadnjeg ulogiranog
	 */
	public String getPassword_last_login() {
		return password_last_login;
	}

	/**
	 * @param password_last_login
	 * metoda kojom se sprema lozinka zadnjeg ulogiranog
	 */
	public void setPassword_last_login(String password_last_login) {
		this.password_last_login = password_last_login;
	}

/*	public String getTableName() {
		System.out.println(this.tableName);
		return tableName;
	}

	public void setTableName(String table) {
		System.out.println("----------------------------------->"+tableName);
		this.tableName = table;
	}*/
	
	
	

}


