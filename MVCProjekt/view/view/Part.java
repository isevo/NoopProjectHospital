package view;

import java.awt.Color;

/**
 * @author Ivana
 *	klasa koja odreduje odsjecak tortnog grafikona-njegovu velicinu i boju
 */
public class Part {
	 double value;
	   Color color;
	   
	   /**
	 * @param value velicina odsjecka na grafu
	 * @param color boja odsjecka
	 * konstruktor klase Part
	 */
	public Part(double value, Color color) {
	      this.value = value;
	      this.color = color;
	   }
}
