/**
 * Eine Benutzeroberfl�che f�r den Gesch�ftsbereich "Pizzalieferant"
 * Erleichtert das Verwalten von Kunden, ihrer Bestellungen, sowie ihrer Daten.
 * 
 * Erlaubt das Manipulieren von Kundendaten, Aufnehmen von Bestellungen,
 * Suchen von Kunden in der Datenbank, Importierung vorheriger Bestellung.
 * 
 * 
 * TODO Kundenpanel, Gerichtepanel, Datenbank
 * 
 * 
 * @author Claudio Bianucci, Sülo Gemici, Adiran Gutierrez, Dennis Natanzon
 * @version 0.3
 * 
 */
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList; // Eingef�gt f�r sp�teren Gebrauch!
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import Tools.MYSQL; // Eigenes SQL-Interface, R�ckgabe von Ergebnissen ist eine ArrayList, welche String-Arrays enth�lt!


public class PizzaGUI extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	MYSQL sql = new MYSQL();
	
	private JPanel panelUpperMain;
	private JPanel panelMainLower;
	private JPanel tabPizzaDetails;
	private JPanel tabNudelDetails;
	private JPanel tabSalatDetails;
	private JPanel tabGetraenkeDetails;
	private JPanel tabAktuelleBestellung;
	private JPanel tabVorherigeBestellung;
	private JPanel abrechnungsPanel;
	
	private KundenVerwaltung tPaneKunden; ////////GEÄNDERTTTTTT///////////////
	private ZutatenVerwaltung tPaneZutaten;
	private JTabbedPane tPaneBestellung;
	private JTabbedPane tPaneArtikelDetails;
	
	private JList akt_Bestellungen;
	private JList vorh_Bestellungen;


	private JTextField feldAbrechnung;

	private JButton knopfAbrechnen;
	
	private JScrollPane scroll_akt_b;
	private JScrollPane scroll_vorh_b;
	
	private JPopupMenu pizza_popup;

	PizzaGUI()
	{
		// Menubar Items
		
		JMenuBar pizza_bar = new JMenuBar();
		JMenu datei, extras, hilfe;
		JMenuItem datei_ende;
		JMenuItem extras_einstlg;
		JMenuItem hilfe_info;
		
		datei = new JMenu("Datei");
		{
			datei_ende = new JMenuItem("Beenden");
			datei.add(datei_ende);
		}
		extras = new JMenu("Extras");
		{
			extras_einstlg = new JMenuItem("Einstellungen");
			extras.add(extras_einstlg);
		}
		hilfe = new JMenu("Hilfe");
		{
			hilfe_info = new JMenuItem("�ber");
			hilfe.add(hilfe_info);
		}

		pizza_bar.add(datei);
		pizza_bar.add(extras);
		pizza_bar.add(hilfe);
		
		this.setJMenuBar(pizza_bar);
		
		// PopupMenu
		
		pizza_popup = new JPopupMenu();

		// Baue das Main-Grid auf.
		
		panelUpperMain = new JPanel();
		panelUpperMain.setLayout(new GridLayout(1,5,2,5));
				
		panelMainLower = new JPanel();
		panelMainLower.setLayout(new BorderLayout());
		
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
		
		
		tPaneKunden = new KundenVerwaltung();   ////GEÄNDERTTT/////
		tPaneZutaten= new ZutatenVerwaltung(); ////GEÄNDERTTT/////
		tPaneBestellung = new JTabbedPane();
		tPaneArtikelDetails = new JTabbedPane();
		
		akt_Bestellungen = new JList();
		akt_Bestellungen.setName("akt_Bestellungen");
		akt_Bestellungen.setSelectionMode(0);
		vorh_Bestellungen =new JList();
		vorh_Bestellungen.setSelectionMode(0);
		vorh_Bestellungen.setName("vorh_Bestellungen");
		
		MouseListener m_listener = new MouseAdapter()
		{
			public void mouseReleased (MouseEvent event)
			{
				if (event.getSource().toString().contains("akt_Bestellungen")) best_Listener(akt_Bestellungen, event);
				else best_Listener(vorh_Bestellungen, event);
			}
		};
		
		akt_Bestellungen.addMouseListener(m_listener);
		vorh_Bestellungen.addMouseListener(m_listener);
		
		feldAbrechnung = new JTextField();
		feldAbrechnung.setEditable(false);
		
		knopfAbrechnen = new JButton("Abrechnen");
		knopfAbrechnen.addActionListener(this);
		
		tPaneBestellung.add(tabAktuelleBestellung, "Aktuelle Bestellung");
		tPaneBestellung.add(tabVorherigeBestellung, "Vorherige Bestellung");
		
		panelUpperMain.add(tPaneKunden);
		panelUpperMain.add(tPaneBestellung);
		
		/////////////////////////////////////////////////////////////////////
		//panelMainLower.add(tPaneArtikelDetails, BorderLayout.CENTER);
		tPaneZutaten.setSize(795, 200);
		tPaneZutaten.setPreferredSize(tPaneZutaten.getSize());
		panelMainLower.add(tPaneZutaten, BorderLayout.CENTER);
		//////////////////////////////////////////////////////////////GEÄNDERT
		
		tPaneArtikelDetails.add(tabPizzaDetails, "Pizza");
		tPaneArtikelDetails.add(tabNudelDetails, "Nudeln");
		tPaneArtikelDetails.add(tabSalatDetails, "Salat");
		tPaneArtikelDetails.add(tabGetraenkeDetails, "Getr�nke");
		
		abrechnungsPanel.add(feldAbrechnung);
		abrechnungsPanel.add(knopfAbrechnen);
		
		scroll_akt_b = new JScrollPane (akt_Bestellungen);
		scroll_vorh_b = new JScrollPane (vorh_Bestellungen);
		
		tabAktuelleBestellung.add(scroll_akt_b,BorderLayout.CENTER);
		tabAktuelleBestellung.add(abrechnungsPanel, BorderLayout.SOUTH);
		tabVorherigeBestellung.add(scroll_vorh_b, BorderLayout.CENTER);
		
		this.setSize(800,600);
		this.setTitle("PizzaLieferant");
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		this.add(panelUpperMain, BorderLayout.CENTER);
		this.add(panelMainLower, BorderLayout.SOUTH);
				
		
	

		initBestellungsPanel(); // Eingef�gt f�r Testzwecke bez�glich MYSQL.request();
	}
	
	public void initKundenPanel ()
	{		
		
	}
	
	public void initBestellungsPanel ()
	{
		
		DefaultListModel akt_Best_model = new DefaultListModel();
		DefaultListModel vorh_Best_model = new DefaultListModel();
		
		
		akt_Best_model.addElement("1: Testpizza");
		akt_Best_model.addElement("2: Testtrinken");
		
		vorh_Best_model.addElement("1: Testnudel");
		vorh_Best_model.addElement("2: Testsalat");
		
		
		this.akt_Bestellungen.setModel(akt_Best_model);
		this.vorh_Bestellungen.setModel(vorh_Best_model);
		
	}
	
	public void actionPerformed (ActionEvent event) 
	{
		
		String abfrage = event.getActionCommand();
		
		if (abfrage=="Abrechnen")
		{
			JOptionPane.showMessageDialog(this, "Abrechnen noch nicht verfügbar!","Pizzalieferant",JOptionPane.ERROR_MESSAGE);
		} else if (abfrage=="Entfernen")
		{
			JOptionPane.showMessageDialog(this, "Gelöscht! (Debug-Nachricht)", "Pizzalieferant",JOptionPane.INFORMATION_MESSAGE);
		} else if (abfrage=="Hinzufügen")
		{
			JOptionPane.showMessageDialog(this, "Hinzugefügt! (Debug-Nachricht)", "Pizzalieferant",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void best_Listener (JList list, MouseEvent event)
	{
		
		list.setSelectedIndex(list.locationToIndex(event.getPoint()));
		System.out.println("In " + list.getName() + " wurde das Element " + list.getSelectedIndex() + " ausgew�hlt.");
		pizza_popup.removeAll();
		
		if(list.getName()=="akt_Bestellungen" && event.isPopupTrigger())
		{
			JMenuItem akt_entf = new JMenuItem("Entfernen");
			akt_entf.addActionListener(this);
			pizza_popup.add(akt_entf);
			pizza_popup.show(event.getComponent(), event.getX(), event.getY());
		} 
		else if (list.getName()=="vorh_Bestellungen" && event.isPopupTrigger())
		{
			JMenuItem vorh_hinzfg = new JMenuItem("Hinzuf�gen");
			vorh_hinzfg.addActionListener(this);
			pizza_popup.add(vorh_hinzfg);
			pizza_popup.show(event.getComponent(), event.getX(), event.getY());
		}
	}
	
	public static void main (String[]args)
	{
		new PizzaGUI();
	}

}
