package repasoFeb.Bloque5Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

public class Ej1FechasParseo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 11/11/2000 11:11:11
		//Formato en el que metemos el String
		SimpleDateFormat formatDated=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		// Lo metemos con el formato anterior
		String fechaString=JOptionPane.showInputDialog("Introduce la fecha en dd/MM/yyyy HH:mm:ss");
		Date fechaDated=null;

		//try catch
		try {
			fechaDated=formatDated.parse(fechaString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Traemos un calendario
		Calendar fechaCalendar=Calendar.getInstance();
		fechaCalendar.setTime(fechaDated); // para meter la fecha en el calendario
		
		System.out.println("Año date: "+new SimpleDateFormat("yyyy").format(fechaDated));	
		System.out.println("Mes date: "+new SimpleDateFormat("MM").format(fechaDated));	
		System.out.println("Dia date: "+new SimpleDateFormat("dd").format(fechaDated));	
		
		System.out.println("Hora date: "+new SimpleDateFormat("HH").format(fechaDated));	
		System.out.println("Minutos date: "+new SimpleDateFormat("mm").format(fechaDated));	
		System.out.println("Segundos date: "+new SimpleDateFormat("ss").format(fechaDated));	

		System.out.println("Fecha en Calendar");
		System.out.println("Año en Calendar: "+fechaCalendar.get(Calendar.YEAR));
		System.out.println("Mes en Calendar: "+fechaCalendar.get(Calendar.MONTH));
		System.out.println("Dia en Calendar: "+fechaCalendar.get(Calendar.DAY_OF_MONTH));
		
	}
	
	

}
