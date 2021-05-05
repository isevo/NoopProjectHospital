package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

import javax.swing.JFrame;

import com.mindfusion.scheduling.Calendar;
import com.mindfusion.scheduling.ThemeType;



import com.mindfusion.common.*;


/**
 * @author Ivana
 * frame u kojem se prikazuje kalendar 
 */
public class CalendarWindow extends JFrame {	
	
	/**
	 * varijabla u kojoj se sprema datum
	 */
	private static final long serialVersionUID = 1L;	
		
	java.util.Calendar selectedDate = java.util.Calendar.getInstance();
	/**
	 * objekt tipa kalendar
	 */
	Calendar calendar = new Calendar();
	/**
	 * 
	 */
	protected PropertyChangeSupport changeSupport;

	

	
	/**
	 * konstruktor u kojem se postavlja velicina frame-a
	 * postavljen je dogadaj
	 * svaki put kada se klikne misem dva puta na broj datuma u frame-u kalendara i sprema se
	 */
	public CalendarWindow()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);	    
		
		setSize(235, 200);
		setTitle("MindFusion.Scheduling Sample: Minimal Application");
		setAlwaysOnTop(true);
		changeSupport = new PropertyChangeSupport(this);

		setDefaultCloseOperation(CalendarWindow.this.HIDE_ON_CLOSE);
		calendar.setTheme(ThemeType.Light);

		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(calendar, BorderLayout.CENTER);
		
		
		calendar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2)
				{			
				
					calendar.getSelection().reset();
					
					DateTime pointedDate = calendar.getDateAt(e.getX(), e.getY());
					
					java.util.Calendar cal = java.util.Calendar.getInstance();
					cal.set(pointedDate.getYear(), pointedDate.getMonth() - 1, pointedDate.getDay());
					
					setSelectedDate(cal);					
 
					dispose();						
					
				}
				
			}
		});	
		
		
		
		
	}
	
	
	


	
	/**
	 * @return selectedDate
	 * metoda koja dohvaca spremljeni datum
	 */
	public java.util.Calendar getSelectedDate()
	{
		return selectedDate;
	
	}
	
	
	/**
	 * @param date
	 * metoda kojom se postavlja datum na textField
	 */
	public void resetSelection(Date date)
	{
		calendar.getSelection().reset();
		calendar.getSelection().set(new DateTime(date), new DateTime(date).addMinutes(2));
		calendar.setDate(new DateTime(date));
		
	}
	
	

	/**
	 * @param selDate
	 * metoda kojom se na mjesto stare vrijednosti postavlja novi datum
	 */
	public void setSelectedDate (java.util.Calendar selDate)
	{

		java.util.Calendar oldValue = (java.util.Calendar)selectedDate.clone();
		selectedDate = selDate;				
				
		changeSupport.firePropertyChange("selectedDate",oldValue, selectedDate);
		
	}
	
	
	
	/**
	 * @param listener
	 * metoda kojom se postavlja lisener
	 */
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		 changeSupport.addPropertyChangeListener(listener);
	    }
	 
	 

	

}
