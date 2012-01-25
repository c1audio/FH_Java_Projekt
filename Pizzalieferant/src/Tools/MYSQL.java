/**
 * Eine vereinfachte Schnittstelle zur Datenbank in Java.
 * 
 * Diese Funktion führt die übergebene Anfrage aus und 
 * gibt eine ArrayList mit allen Resultaten zurück.
 * 
 * Um die Resultate zu verwerten muss die Größe der Liste mit name.getSize(); ermittelt werden.
 * Danach kann durch das Durchlaufen einer Schleife jeder einzelner Datensatz betrachtet werden.
 * 
 * Bitte beachtet, dass in der Liste String-Arrays enthalten sind.
 * Welche auch dementsprechend angesprochen werden müssen.
 * 
 * ### Beispiel:
 * 
 * MYSQL sqlHandling = new MYSQL();
 * 
 * ArrayList<String[]> results = sqlHandling.request("SELECT `id`,`Name`, `Vorname` FROM pizza.kunde");
 * 
 * if (result==null)
 * {
 * 		// FEHLER BEI ABFRAGE
 * }
 * 
 * for (int id=0;id<results.size();id++)
 * {
 * 		System.out.println(sqlHandling.Star_to_St(results.get(id))); // Falls ihr die komplette Array in ein String packen wollt.
 * 		System.out.println(results.get(id)[0]); // Falls ihr, wie in diesem Fall, nur die ID Ausgeben wollt.
 * }
 * 
 * ### Ende
 * 
 * @author Dennis Natanzon
 * @version 0.4
 */

package Tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MYSQL 
{
	
/** 
 * ArrayList<String[]> request(String Statement)
 * 
 * @category getter 
 * @param	statement - Hier gibt man die Vollständige SQL-Abfrage ein! (Bsp: "SELECT * FROM Test");
 * @return	null oder eine ArrayList vom Typ String mit allen Resultaten der Abfrage.
 */
	
	public ArrayList<String[]> request (String Statement) 
	{
		ArrayList<String[]> results = new ArrayList<String[]>();
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance(); // Baue eine neue Instanz des MYSQL-Treibers auf.
			Connection myCon = DriverManager.getConnection("jdbc:mysql://127.0.0.1/", "pizzagui", "test"); // Verbinde, mit Hilfe des Treibers, das Programm mit der Datenbank
			Statement myStmt= myCon.createStatement();	// Erstelle ein Objekt von Statement um Anfragen an die Datenbank stellen zu können.
			ResultSet result = myStmt.executeQuery(Statement);

			int columnCount = result.getMetaData().getColumnCount();

			while (result.next())
			{
				String row[] = new String[columnCount];
				for (int colid=0; colid<columnCount;colid++)
				{
					row[colid] = result.getString(colid+1);
				}
				results.add(row);
			}
			myCon.close();
		}
		catch (Exception sqlEx)
		{
			System.err.println(sqlEx);
			return null; // Fehler aufgetreten.
		}
		return results; // Erfolgreich ausgeführt. Rückgabe der Liste.
	}
	
	/**
	 * Umwandler von String-Array in String.
	 * 
	 * @param arg - Übergebenes Argument muss ein String-Array sein.
	 * @return cache - Zurückgegebener Wert ist ein String mit den Werten des String-Arrays.
	 */
	
	public String Star_to_St (String[] arg)
	{
		
		int arrayl = arg.length;
		String cache = "";
		
		for (int id=0; id<arrayl; id++)
		{
			cache += arg[id]+" ";
		}
		
		return cache;
	}
}
