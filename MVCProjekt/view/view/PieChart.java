package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JFrame;


/**
 * @author Ivana
 *	Ovo je klasa u kojoj se crta dijagram 
 */
public class PieChart extends JComponent {
	
	/**
	 * varijabla tipa int u koju se sprema broj pacijenata 0-10 god
	 */
	private int grey;
	/**
	 * varijabla tipa in u koju se sprema broj pacijenata od 10-20 god
	 */
	private int white;
	/**
	 * varijabla tipa int u koju se sprema broj pacijenata 20-30 god
	 */
	private int darkGray;
	/**
	 * varijabla tipa int u koju se sprema broj pacijenta 30-50 god
	 */
	private int black;
	/**
	 * varijabla tipa int u koju se sprema broj pacijenata 50+ god
	 */
	private int lightGfray;
	
	

	/*
	 * Part[] slices = { new Part(4, Color.gray), new Part(2, Color.white), new
	 * Part(7, Color.darkGray), new Part(1, Color.black) , new Part(3,
	 * Color.LIGHT_GRAY) };
	 */
	

/**
 * konstruktor
 */
PieChart() {
	
	/*System.out.println("VELICINE: ");
	System.out.println(getGrey());
	System.out.println(getWhite());
	System.out.println(getBlack());*/
	
}


	
   /**
 * @return grey
 * metoda koja dohvaca broj pacijenata (0-10 god)
 */
public int getGrey() {
		return grey;
	}
	/**
	 * @param grey
	 * metoda kojom se postavlja int vrijednost godina(0-10 god)
	 */
	public void setGrey(int grey) {
		this.grey = grey;
	}
	/**
	 * @return darkGray
	 * metoda koja dohvaca broj pacijenata (20-30 god)
	 * 
	 * 
	 */
	public int getDarkGray() {
		return darkGray;
	}
	/**
	 * @param darkGray
	 * 
	 * metoda kojom se postavlja int vrijednost godina(20-30 god)
	 */
	 
	public void setDarkGray(int darkGray) {
		this.darkGray = darkGray;
	}
	/**
	 * @return black 
	 * 
	 * dohvaca broj narcenih u rasponu od 30-50
	 */
	public int getBlack() {
		return black;
	}
	/**
	 * @param black
	 * 
	 * postavlja broj narucenih u rasponu od 30-50 god
	 */
	public void setBlack(int black) {
		this.black = black;
	}
	/**
	 * @return lightGray
	 * dohvaca broj narucenih u rasponu od 50+ god
	 */
	public int getLightGfray() {
		return lightGfray;
	}
	/**
	 * @param lightGfray
	 * metoda kojom se postavlja broj narucenih u rasponu 50+ god
	 */
	public void setLightGfray(int lightGfray) {
		this.lightGfray = lightGfray;
	}
	
	
	
	
/**
 * @return white
 * metoda koja dohvaca broj pacijenata (10-20 god)
 */
public int getWhite() {
		return white;
	}
	/**
	 * @param white
	 * metoda kojom se postavlja vrijednotbroja pacijenata 10-20 god
	 */
	public void setWhite(int white) {
		this.white = white;
	}


/**
*@param g
*metoda u kojoj se u niz postavljaju vrijednosti broja narucenih pacijenata (ovisno o kategoriji kojoj pripadaju)
*
*/
 
 

public void paint(Graphics g) {
	   Part[] slices = { 
			      new Part(getGrey(), Color.gray), new Part(getWhite(), Color.white), new Part(getDarkGray(), Color.darkGray), new Part(getBlack(), Color.black) ,
			      new Part(getLightGfray(), Color.LIGHT_GRAY)
			   }; 
	   
      drawPie((Graphics2D) g, getBounds(), slices);
      
    /*  System.out.println("bijela "+getWhite());
      System.out.println("siva "+getGrey());
      System.out.println("darkG "+getDarkGray());
      System.out.println("black "+getBlack());
      System.out.println("lightG "+getLightGfray());*/
      
      
   } 



   /**
 * @param g
 * @param area
 * @param slices -broj dijelova dijagrama (5 jer je 5 podjela po godinama)
 * 
 * 
 * Metoda koja racuna koliko svaki broj pacijenata zauzima mjesta u tortnom dijagramu
 */
void drawPie(Graphics2D g, Rectangle area, Part[] slices) {
      double total = 0.0D;
      for (int i = 0; i < slices.length; i++) {
         total += slices[i].value;
      } 
      double curValue = 0.0D;
      int startAngle = 0;
      for (int i = 0; i < slices.length; i++) {
         startAngle = (int) (curValue * 360 / total);
         int arcAngle = (int) (slices[i].value * 360 / total);
         
         g.setColor(slices[i].color);
         g.fillArc(area.x, area.y, area.width, area.height, startAngle, arcAngle);
         curValue += slices[i].value;
      } 
   }
}

