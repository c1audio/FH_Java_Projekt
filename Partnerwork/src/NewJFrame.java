import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.ListModel;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import java.sql.*; // Eingefügt für späteren Gebrauch.


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class NewJFrame extends javax.swing.JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L; // Wird gebraucht um ein Warning des Java-Compilers abzustellen.

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	// Erstellen aller benötigten Objekte für die GUI.

	private JPanel upperMainPanel;
	private JPanel kundenPanel;
	private JPanel lowerMainPanel;
	private JTabbedPane bestellungsTPane;
	private JList akt_Bestellungen;
	private JList vorh_Bestellungen;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				NewJFrame inst = new NewJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public NewJFrame() {
		super();
		super.setTitle("Pizzalieferant GUI");
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
				{ 	// Erstellen des Reiter-Panes
					bestellungsTPane = new JTabbedPane();
					upperMainPanel.add(bestellungsTPane);
					{	// Erstellen des Tabs 'Aktuelle Bestellungen:'

						ListModel akt_BesteListe = new DefaultComboBoxModel
						(new String[] { "Pizza Avanti", "Pizza Alegro" });

						akt_Bestellungen = new JList();
						bestellungsTPane.addTab("Aktuelle Bestellungen:", null, akt_Bestellungen, null);
						akt_Bestellungen.setModel(akt_BesteListe);
						akt_Bestellungen.setSelectedIndex(1);
					}
					{	// Erstellen des Tabs 'Vorherige Bestellungen:'

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
			this.setSize(800, 600);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
