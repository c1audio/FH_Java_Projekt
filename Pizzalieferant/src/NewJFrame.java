import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.ListModel;
import javax.swing.WindowConstants;

import java.sql.*; // Eingef�gt f�r sp�teren Gebrauch.


public class NewJFrame extends javax.swing.JFrame {


	private static final long serialVersionUID = 1L; // Stellt eine Compilerwarnung ab.
	
	// Erstellen aller ben�tigten Objekte f�r die GUI.
	
	private JPanel upperMainPanel;
	private JPanel kundenPanel;
	private JPanel lowerMainPanel;
	private JTabbedPane bestellungsTPane;
	private JList akt_Bestellungen;
	private JList vorh_Bestellungen;

	//public static void main(String[] args) {
	//	new NewJFrame();
	//}
	
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
	
	public NewJFrame() {
		super();
		super.setLocationRelativeTo(null);
		super.setVisible(true);
		super.setTitle("Pizzalieferant GUI");
		super.setResizable(false);
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				upperMainPanel = new JPanel();
				GridLayout upperMainPanelLayout = new GridLayout(1, 2);
				upperMainPanelLayout.setHgap(5);
				upperMainPanelLayout.setVgap(5);
				upperMainPanelLayout.setColumns(2);
				upperMainPanel.setLayout(upperMainPanelLayout);
				getContentPane().add(upperMainPanel, BorderLayout.CENTER);
				upperMainPanel.setBackground(new java.awt.Color(229,229,229));
				{
					kundenPanel = new JPanel();
					upperMainPanel.add(kundenPanel);
					kundenPanel.setBackground(new java.awt.Color(255,217,120));
				}
				{ 	
					// Erstellen des Reiter-Panes
					bestellungsTPane = new JTabbedPane();
					upperMainPanel.add(bestellungsTPane);
					{	
						// Erstellen des Tabs 'Aktuelle Bestellungen:'
						ListModel akt_BesteListe = new DefaultComboBoxModel
						(new String[] { "Pizza Avanti", "Pizza Alegro" });
						
						akt_Bestellungen = new JList();
						bestellungsTPane.addTab("Aktuelle Bestellungen:", null, akt_Bestellungen, null);
						akt_Bestellungen.setModel(akt_BesteListe);
						akt_Bestellungen.setSelectedIndex(1);
					}
					{	
						// Erstellen des Tabs 'Vorherige Bestellungen:'
						ListModel vorh_BesteListe = new DefaultComboBoxModel
						(new String[] { "Pizza Antonio", "Pizza Pasta" });
						
						vorh_Bestellungen = new JList();
						bestellungsTPane.addTab("Vorherige Bestellungen:",null, vorh_Bestellungen, null);
						vorh_Bestellungen.setModel(vorh_BesteListe);
						vorh_Bestellungen.setSelectedIndex(0);
					}
				}
			}
			{
				lowerMainPanel = new JPanel();
				getContentPane().add(lowerMainPanel, BorderLayout.SOUTH);
				lowerMainPanel.setBackground(new java.awt.Color(144,238,144));
				lowerMainPanel.setPreferredSize(new java.awt.Dimension(790, 157));
			}
			pack();
			this.setLocation(this.getWidth()-225, this.getHeight()-100); // Setze die GUI in die Mitte des Bildschirms.
			this.setSize(800, 600);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sql_test(); 
	}

}
