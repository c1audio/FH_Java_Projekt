import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class ZutatenVerwaltung extends JPanel{
	private static final long serialVersionUID = -2476107718380346643L;

	JTabbedPane tPanel= new JTabbedPane();
	
	ZutatenWarm warmTab = new ZutatenWarm("Warme Gerichte");
	ZutatenKalt kaltTab = new ZutatenKalt("Kalte Gerichte");
	ZutatenExtra extraTab = new ZutatenExtra("Extras");
	
	ZutatenVerwaltung()
	{
		setLayout(new GridLayout(1,1,1,1));
		tPanel.add(warmTab);
		tPanel.add(kaltTab);
		tPanel.add(extraTab);
		add(tPanel);		
	}
	
}
