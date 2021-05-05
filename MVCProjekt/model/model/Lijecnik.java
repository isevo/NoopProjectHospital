package model;

/**
 * @author Ivana
 *	klassa u kojoj se spremaju podaci o lijecnicima
 */
public class Lijecnik {
	
	/**
	 * varijabla u kojoj se sprema ime
	 */
	private String name;
	/**
	 * varijabla u kojoj se sprema prezime
	 */
	private String prezime;
	/**
	 *  varijabla u kojoj se sprema id
	 */
	private int id;
	/**
	 *  varijabla u kojoj se sprema password
	 */
	private String password;
	/**
	 *  brojac za id
	 */
	private int cnt=0;
	
	
	
	
	/**
	 * @param name ime lijecnika
	 * @param prezime prezime lijecnika
	 * @param password lozinka
	 * konstruktor
	 */
	public Lijecnik(String name,String prezime,String password) {
		
		this.name=name;
		this.prezime=prezime;
		this.password=password;
		cnt++;
		this.id=cnt;
	}


/**
 * konstruktor
 */
public Lijecnik() {
	// TODO Auto-generated constructor stub
}

	/**
	 * @return name
	 * metoda kojom se dohvaca ime
	 */
	public String getName() {
		return name;
	}




	/**
	 * @param name ime lijecnika
	 * metoda kojom se sprema ime 
	 */
	public void setName(String name) {
		this.name = name;
	}




	/**
	 * @return prezime 
	 * metoda kojom se dohvaca prezime lijecnika
	 */
	public String getPrezime() {
		return prezime;
	}




	/**
	 * @param prezime
	 * metoda kojom se postavlja vrijednost varijable  prezime
	 */
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}




	/**
	 * @return password
	 * metoda kojom se dohvaca lozinka 
	 */
	public String getPassword() {
		return password;
	}




	/**
	 * @param password
	 * metoda kojom se postavlja vrijednost varijable password
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return id
	 * metoda kojom se dohvaca id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id
	 * metoda kojom se postavlja vrijednost varijable id
	 */
	public void setId(int id) {
		this.id = id;
	}


	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * metoda kojom se ispisuju vrijednosti navedenih varijabli
	 */
	public String toString() {
		return "Lijecnik [name=" + name + ", prezime=" + prezime + ", id=" + id + ", password=" + password + ", cnt="
				+ cnt + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
