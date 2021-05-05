package model;

/**
 * @author Ivana
 * ovo je klasa u kojoj se spremaju odaci o pacijentu
 */

public class Pacijent {

	/**
	 * varijabla tipa string u kojoj se sprema ime
	 */
	private String ime;
	/**
	 * varijabla tipa string u kojoj se sprema prezime
	 */
	private String prezime;
	/**
	 * varijabla tipa string u kojoj se spremaju simptomi
	 */
	private String simptomi;
	/**
	 * varijabla tipa string u kojoj se sprema id pacijenta
	 */
	private int id;
	/**
	 * varijabla tipa string u kojoj se sprema datum
	 */
	private String date;
	/**
	 * brojac za id
	 */
	private static int num=1;
	/**
	 * varijabla u kojoj se spremaju godine
	 */
	private String godine;
	
	/**
	 * konstruktor klase Pacijent
	 */
	public Pacijent() {
	
		/**
		 * konstruktor klase Pacijent
		 */
	}
	public Pacijent(String ime,String prezime,String simptomi,String date,String godine) {
		this.ime=ime;
		this.date=date;
		this.prezime=prezime;
		this.simptomi=simptomi;
		this.id=num;
		num++;
		this.godine=godine;
		
	}
	/**
	 * @param ime
	 * metoda kojom se sprema ime
	 */
	public void setIme(String ime) {
		this.ime = ime;
	}
	/**
	 * @param prezime
	 * metoda kojom se sprema prezime
	 */
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	/**
	 * @param simptomi
	 * metoda kojom se sprema simptomi
	 */
	public void setSimptomi(String simptomi) {
		this.simptomi = simptomi;
	}
	
	/**
	 * @return ime
	 * metoda kojom se dohvaca ime
	 */
	public String getIme() {
		return ime;
	}
	/**
	 * @return prezime
	 * metoda kojom se dohvaca prezime
	 */
	public String getPrezime() {
		return prezime;
	}
	/**
	 * @return simptromi
	 * metoda kojom se dohvacaju simptomi
	 */
	public String getSimptomi() {
		return simptomi;
	}
	/**
	 * @param id
	 * metoda kojom se sprema id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return id
	 * metoda kojom se dohvaca id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return date
	 * metoda kojom se dohvaca datum
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date
	 * metoda kojom se sprema datum
	 */
	
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return godine
	 * metoda kojom se dohvacaju gdoine pacijenata
	 */
	public String getGodine() {
		return godine;
	}
	/**
	 * @param godine
	 * metoda kojom se dohvacaju godine
	 */
	public void setGodine(String godine) {
		this.godine = godine;
	}
	@Override
	public String toString() {
		return "Pacijent [ime=" + ime + ", prezime=" + prezime + ", simptomi=" + simptomi + ", id=" + id + ", date="
				+ date + ", godine=" + godine + "]";
	}
	
	
	
	
}
