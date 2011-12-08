import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


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
public class GUI extends javax.swing.JFrame {
	private JPanel jPanel3;
	private JInternalFrame jInternalFrame2;
	private JPanel jPanel2;
	private JInternalFrame jInternalFrame1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GUI inst = new GUI();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public GUI() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jInternalFrame2 = new JInternalFrame();
				getContentPane().add(jInternalFrame2);
				jInternalFrame2.setVisible(true);
				{
					jPanel3 = new JPanel();
					jInternalFrame2.getContentPane().add(jPanel3);
					jPanel3.setBackground(new java.awt.Color(160,32,240));
				}
			}
			{
				jInternalFrame1 = new JInternalFrame();
				getContentPane().add(jInternalFrame1, BorderLayout.NORTH);
				jInternalFrame1.setVisible(true);
				jInternalFrame1.setPreferredSize(new java.awt.Dimension(295, 93));
				jInternalFrame1.setBounds(0, 0, 295, 93);
				{
					jPanel2 = new JPanel();
					jInternalFrame1.getContentPane().add(jPanel2, BorderLayout.CENTER);
					jPanel2.setBackground(new java.awt.Color(255,0,0));
					jPanel2.setPreferredSize(new java.awt.Dimension(293, 85));
				}
			}
			pack();
			this.setSize(305, 299);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
