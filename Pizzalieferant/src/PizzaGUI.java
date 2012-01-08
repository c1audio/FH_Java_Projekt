import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class PizzaGUI extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	MYSQL sqlHandling = new MYSQL();
	
	private JPanel panelUpperMain;
	private JPanel panelMainLower;
	private JPanel tabKundeSuchen;
	private JPanel tabNeuerKunde;
	private JPanel tabPizzaDetails;
	private JPanel tabNudelDetails;
	private JPanel tabSalatDetails;
	private JPanel tabGetraenkeDetails;
	private JPanel tabAktuelleBestellung;
	private JPanel tabVorherigeBestellung;
	private JPanel abrechnungsPanel;
	
	private JTabbedPane tPaneKunden;
	private JTabbedPane tPaneBestellung;
	private JTabbedPane tPaneArtikelDetails;
	
	private JList akt_Bestellungen;
	private JList vorh_Bestellungen;
	
	private JTextField feldAbrechnung;

	private JButton knopfAbrechnen;
	
	/*######################################################KundenPanelKomponenten
	/**/ private JTextField feldKundeSuchen;
	/**/ private JList listeKundenErgebnisse;
	/**/ 
	/**/ private JPanel panelKundenDaten;
	/**/ private JPanel panelDeklKundenLabel;
	/**/ private JPanel panelKundenNord;
	/**/ private JPanel panelKundenSued;
	/**/ private JPanel panelKundenCenter;
	/**/ 
	/**/ private JLabel labelName;
	/**/ private JLabel labelTelefonnr;
	/**/ private JLabel labelStrasse;
	/**/ private JLabel labelOrt;
	/**/ 
	/**/ private JLabel labelDeklName;
	/**/ private JLabel labelDeklTelefonnr;
	/**/ private JLabel labelDeklStrasse;
	/**/ private JLabel labelDeklOrt;
	/**/ 
	/**/ 
	
	

	PizzaGUI()
	{
		panelUpperMain = new JPanel();
		panelUpperMain.setLayout(new GridLayout(1,5,2,5));
				
		panelMainLower = new JPanel();
		panelMainLower.setLayout(new BorderLayout());
		
		tabKundeSuchen = new JPanel();
		tabKundeSuchen.setLayout(new BorderLayout());
		tabNeuerKunde = new JPanel();
		
		tabPizzaDetails = new JPanel();
		tabNudelDetails  = new JPanel();
		tabSalatDetails = new JPanel();
		tabGetraenkeDetails = new JPanel();
		
		abrechnungsPanel = new JPanel();
		abrechnungsPanel.setLayout(new GridLayout(1,5,2,5));
		
		tabAktuelleBestellung = new JPanel();
		tabAktuelleBestellung.setLayout(new BorderLayout());
		
		tabVorherigeBestellung = new JPanel();
		tabVorherigeBestellung.setLayout(new BorderLayout());
		
		
		tPaneKunden = new JTabbedPane();
		tPaneBestellung = new JTabbedPane();
		tPaneArtikelDetails = new JTabbedPane();
		
		akt_Bestellungen = new JList();
		vorh_Bestellungen =new JList();
		
		feldAbrechnung = new JTextField("50 EURO");
		
		knopfAbrechnen = new JButton("Abrechnen");
		
		
		tPaneBestellung.add(tabAktuelleBestellung, "Aktuelle Bestellung");
		tPaneBestellung.add(tabVorherigeBestellung, "Vorherige Bestellung");
		
		tPaneKunden.add(tabKundeSuchen, "Kunde Suchen");
		tPaneKunden.add(tabNeuerKunde, "Neuer Kunde");
		
		panelUpperMain.add(tPaneKunden);
		panelUpperMain.add(tPaneBestellung);
		
		panelMainLower.add(tPaneArtikelDetails, BorderLayout.CENTER);
		
		tPaneArtikelDetails.add(tabPizzaDetails, "Pizza");
		tPaneArtikelDetails.add(tabNudelDetails, "Nudeln");
		tPaneArtikelDetails.add(tabSalatDetails, "Salat");
		tPaneArtikelDetails.add(tabGetraenkeDetails, "Getränke");
		
		abrechnungsPanel.add(feldAbrechnung);
		abrechnungsPanel.add(knopfAbrechnen);
		
		tabAktuelleBestellung.add(akt_Bestellungen,BorderLayout.CENTER);
		tabAktuelleBestellung.add(abrechnungsPanel, BorderLayout.SOUTH);
		tabVorherigeBestellung.add(vorh_Bestellungen, BorderLayout.CENTER);
		
		setSize(800,600);
		setTitle("PizzaLieferant");
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		add(panelUpperMain, BorderLayout.CENTER);
		add(panelMainLower, BorderLayout.SOUTH);
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////
		
		feldKundeSuchen = new JTextField();
		listeKundenErgebnisse = new JList();
		
		panelKundenDaten = new JPanel();
		panelDeklKundenLabel = new JPanel();
		panelKundenNord = new JPanel();
		panelKundenCenter = new JPanel();
		panelKundenSued = new JPanel();
		
		labelName= new JLabel("");
		labelTelefonnr= new JLabel("") ;
		labelStrasse = new JLabel("");
		labelOrt = new JLabel("");
		 
		labelDeklName = new JLabel("Name:");
		labelDeklTelefonnr = new JLabel("Tel:");
		labelDeklStrasse = new JLabel("Str:");
		labelDeklOrt = new JLabel("Ort:");
		
		panelKundenDaten.add(labelTelefonnr);
		panelKundenDaten.add(labelName);
		panelKundenDaten.add(labelStrasse);
		panelKundenDaten.add(labelOrt);
		
		panelDeklKundenLabel.add(labelDeklTelefonnr);
		panelDeklKundenLabel.add(labelDeklName);
		panelDeklKundenLabel.add(labelDeklStrasse);
		panelDeklKundenLabel.add(labelDeklOrt);
		
		panelKundenNord.add(feldKundeSuchen);
		panelKundenSued.add(panelKundenDaten);
		panelKundenSued.add(panelDeklKundenLabel);
		panelKundenCenter.add(listeKundenErgebnisse);

		tabKundeSuchen.add(panelKundenNord, BorderLayout.NORTH);
		tabKundeSuchen.add(panelKundenCenter, BorderLayout.CENTER);
		tabKundeSuchen.add(panelKundenSued, BorderLayout.SOUTH);
	}
	
	public void initKundenPanel()
	{
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		String abfrage = arg0.getActionCommand();
		
		if(abfrage=="OK")
		{
			
		}
	}

	public static void main(String[]args)
	
	{
		new PizzaGUI();
	}
	
	
}
