
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class KundeHinzufuegen extends JPanel{
	private static final long serialVersionUID = -6438809429682917383L;

	JLabel labelDeklNam = new JLabel("Nam:");
	JLabel labelDeklTel = new JLabel("Tel:");
	JLabel labelDeklStr = new JLabel("Str:");
	JLabel labelDeklOrt = new JLabel("Plz:");
	JLabel labelDeklPkz = new JLabel("Plz:");
	
	JTextField feldName = new JTextField("Claudio");
	JTextField feldTel = new JTextField("0190666666");
	JTextField feldStr = new JTextField("Bahnhofstraße 74");
	JTextField feldOrt = new JTextField("Mühlheim");
	JTextField feldPlz = new JTextField("63165");
	
	KundeHinzufuegen(String name)
	{
		this.setName(name);
		
		this.add(labelDeklNam);
		this.add(feldName);
		
		
		
		
		
		
	}
}
