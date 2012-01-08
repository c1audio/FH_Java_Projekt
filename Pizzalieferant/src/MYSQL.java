import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class MYSQL {

	public void sql_test() {
		try {
			// Baue eine neue Instanz des MYSQL-Treibers auf.
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// Verbinde, mit Hilfe des Treibers, das Programm mit der Datenbank
			Connection myCon = DriverManager.getConnection("jdbc:mysql://127.0.0.1/", "root", "test"); // Hier kommmt es zur einer Exception durch das Password... Keine Ahnung warum.
			// Erstelle ein Objekt von Statement um Anfragen an die Datenbank stellen zu k�nnen.
			Statement myStmt= myCon.createStatement();
			// Speicher die Resultate der Anfrage in ein ResultSet-Objekt
			ResultSet result = myStmt.executeQuery("SELECT * FROM auth.account");
			// Lies aus der Liste alle Elemente und gib sie aus!
			while (result.next()) {
				// Konvertiere die Elemente aus dem ResultSet in ein String.
				System.out.println("ID: " + result.getString("id"));
			}
			// Schlie�e die Verbindung wieder. (Nicht n�tig, wenn eine dauerhafte Verbindung notwendig ist.)
			myCon.close();
		}
		catch (Exception sqlEx)
		{
			System.err.println(sqlEx);
		}
	}
}
