
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class KundeSuchen extends JPanel{
	private static final long serialVersionUID = 8882516531404814660L;
	
	JPanel panelNord = new JPanel();
	JPanel panelSued = new JPanel();
	JPanel panelCenter = new JPanel();
	
	JPanel panelDaten = new JPanel();
	JPanel panelDekl = new JPanel();
	
	JTextField feldSuchen = new JTextField("Suchbegriff");
	JList listeErgebnisse = new JList();
	
	JLabel labelName = new JLabel("Claudio");
	JLabel labelTelefonnr = new JLabel("0190666666");
	JLabel labelStrasse = new JLabel("Bahnhofstraße 74");
	JLabel labelOrt = new JLabel("Mühlheim");
	JLabel labelPlz = new JLabel("63165");
	 
	JLabel labelDeklName = new JLabel("Nam:");
	JLabel labelDeklTelefonnr = new JLabel("Tel:");
	JLabel labelDeklStrasse = new JLabel("Str:");
	JLabel labelDeklOrt = new JLabel("Plz:");
	JLabel labelDeklPkz = new JLabel("Plz:");
	
	GridLayout g = new GridLayout(1,1,1,1);
	
	KundeSuchen(String name)
	{
		this.setName(name);
		//HAUPTPANEL
		
				//NORDPANEL
				panelNord.setLayout(g);
				panelNord.setSize(380, 150);
				panelNord.add(feldSuchen);
				//NORDPANEL		
				
				//CENTERPANEL
				panelCenter.setLayout(g);
				listeErgebnisse.setBackground(Color.green);
				panelCenter.add(listeErgebnisse);
				//CENTERPANEL
				
				//SUEDPANEL
				panelSued.setLayout(g);
				panelSued.add(panelDekl);
				panelSued.add(panelDaten);
				//SUEDPANEL	
		
		//HAUPTPANEL
		
		//DATENPANEL
		panelDaten.add(labelTelefonnr);
		panelDaten.add(labelName);
		panelDaten.add(labelStrasse);
		panelDaten.add(labelOrt);
		panelDaten.setLayout(new GridLayout(4,4,1,4));
		//DATENPANEL
		
		//DEKLARATIONS-PANEL
		panelDekl.add(labelDeklTelefonnr);
		panelDekl.add(labelDeklName);
		panelDekl.add(labelDeklStrasse);
		panelDekl.add(labelDeklOrt);
		panelDekl.setLayout(new GridLayout(4,4,1,4));
		//DEKLARATIONS-PANEL
		
		
		setLayout(new BorderLayout());
		add(panelNord, BorderLayout.NORTH);
		add(panelCenter, BorderLayout.CENTER);
		add(panelSued, BorderLayout.SOUTH);
	}
	
	public void listeErgebnisse()
	{
		
	}
}
