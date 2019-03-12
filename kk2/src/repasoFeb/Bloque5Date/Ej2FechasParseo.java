package repasoFeb.Bloque5Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.JOptionPane;

public class Ej2FechasParseo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Calendar c = Calendar.getInstance();
             
		//get current TimeZone using
	    TimeZone tz = c.getTimeZone();
	          
	    System.out.println("Current TimeZone is : " + tz.getDisplayName());
	    
	    Calendar ahoraNewYork=Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
	    System.out.println(ahoraNewYork);
	    Calendar ahoraSydney=Calendar.getInstance(TimeZone.getTimeZone("Australia/Sydney"));
	    System.out.println(ahoraSydney);
	    
	    System.out.println("Diferencia horaria: "+((ahoraNewYork.get(Calendar.HOUR_OF_DAY))-(ahoraSydney.get(Calendar.HOUR_OF_DAY))));
	}

}
