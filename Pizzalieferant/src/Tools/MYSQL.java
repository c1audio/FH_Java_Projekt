/**
 * Eine vereinfachte Schnittstelle zur Datenbank in Java.
 * 
 * Diese Funktion f�hrt die �bergebene Anfrage aus und 
 * gibt eine ArrayList mit allen Resultaten zur�ck.
 * 
 * Um die Resultate zu verwerten muss die Gr��e der Liste mit name.getSize(); ermittelt werden.
 * Danach kann durch das Durchlaufen einer Schleife jeder einzelner Datensatz betrachtet werden.
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
 * ArrayList<String> request(String Statement)
 * 
 * @category getter 
 * @param	statement Hier gibt man die Vollst�ndige SQL-Abfrage ein! (Bsp: "SELECT * FROM Test");
 * @return	null oder eine ArrayList vom Typ String mit allen Resultaten der Abfrage.
 */
	
	public ArrayList<String> request(String Statement) 
	{
		ArrayList<String> results = new ArrayList<String>();
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance(); // Baue eine neue Instanz des MYSQL-Treibers auf.
			Connection myCon = DriverManager.getConnection("jdbc:mysql://127.0.0.1/", "pizzagui", "test"); // Verbinde, mit Hilfe des Treibers, das Programm mit der Datenbank
			Statement myStmt= myCon.createStatement();	// Erstelle ein Objekt von Statement um Anfragen an die Datenbank stellen zu k�nnen.
			ResultSet result = myStmt.executeQuery(Statement);

			int columnCount = result.getMetaData().getColumnCount();

			while (result.next())
			{
				String row = "";
				
				for (int colid=0; colid<columnCount;colid++)
				{
					row += result.getString(colid+1)+" ";
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
		return results; // Erfolgreich ausgef�hrt. R�ckgabe der Liste.
	}
}
