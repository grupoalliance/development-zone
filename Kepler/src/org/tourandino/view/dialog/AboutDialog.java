package org.tourandino.view.dialog;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * 
 * @author romerori
 * @creation Dec 24, 2015
 * @class About
 *
 */
public class AboutDialog extends JDialog {

	/**
	 * Create the dialog.
	 */
	public AboutDialog(JFrame parent, boolean modal) {
		super(parent, "Acerca de...", modal);
		initializeComponents();
	}
	
	private void initializeComponents(){
		getContentPane().setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 960, 540);
	}
	
}
