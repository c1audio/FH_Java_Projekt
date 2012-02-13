
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class KundenVerwaltung extends JPanel{
	private static final long serialVersionUID = -2785770450132537264L;
	
	JTabbedPane tPanel = new JTabbedPane();
	KundeSuchen tabKundeSuchen = new KundeSuchen("Kunde Suchen");
	KundeHinzufuegen tabNeuerKunde = new KundeHinzufuegen("Neuer Kunde");
	
	
	KundenVerwaltung(){

		setSize(400,350);
		setBackground(Color.red);
		setLayout(new BorderLayout());

		this.add(tPanel);
		tPanel.add(tabKundeSuchen);
		tPanel.add(tabNeuerKunde);
		
		
	}
	
}
