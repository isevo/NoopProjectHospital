package view;
import javax.swing.SwingUtilities;



/**
 * @author Ivana
 * Jednostavna aplikacija koja simulira spremanje pacijenata u bazu
 *
 */
public class APP {

	/**
	 * @param args
	 * Main metoda pokrece program
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					new Panel_select();
					//new Panel_doctor();
					//new CalendarWindow();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});

	}

}
