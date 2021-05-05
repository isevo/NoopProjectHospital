package model;

import java.util.LinkedList;

/**
 * @author Ivana
 *	klasa u kojoj se spremaju objekti tipa Pacijent i Lijecnik
 */
public class DataBase {
	
	/**
	 * Array lista tipa Pacijent
	 */
	private LinkedList<Pacijent> pacijent;
	/**
	 * Array lista tipa Lijecnik
	 */
	private LinkedList<Lijecnik>lijecnik;
	
	
	/**
	 * konstruktor klase DataBase
	 */
	public DataBase() {
		this.pacijent = new LinkedList<>();
		this.lijecnik=new LinkedList<>();
	}
	
	/**
	 * @param programmer
	 * metoda kojom se dodaje pacijent u listu pacijenata
	 */
	public void addPacijent(Pacijent programmer) {
		pacijent.add(programmer);
		
	}
	
	/**
	 * @return
	 * metoda kojom se ispisuju svi podaci o pacijentima iz baze
	 */
	public LinkedList<Pacijent> getAll4DB(){
		System.out.println("DATABASE<------>:      ");
		return pacijent;
	}

	
	
	/**
	 * @param l
	 * metoda kojom se objekt klase Lijecnik dodaje u listu
	 */
	public void addLijecnik(Lijecnik l) {
		lijecnik.add(l);
	}
	
	/**
	 * @return
	 * metoda kojom se dohvacaju svi lijecnici registrirani u bazi
	 */
	public LinkedList<Lijecnik> getAllDoctors4DB(){
		System.out.println("Lijecnik lista: "+lijecnik);
		return lijecnik;
	}
	
	
	
	
	
	
	
}
