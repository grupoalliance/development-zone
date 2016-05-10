package org.tourandino.view.button;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * 
 * @author romerori
 * @creation Dec 10, 2015
 * @class RegularButton
 *
 */
public class ButtonSynchronize extends JButton{

	/**
	 *
	 */

	public ButtonSynchronize(int x, int y){
		super("Sincronizar");
		setBounds(x, y, 120, 25);
		setToolTipText("Sincronizar los datos");
		setIcon(new ImageIcon(
				ButtonSynchronize.class
				.getResource("/org/tourandino/resources/img/database_refresh.png")));
	}
	
	public ButtonSynchronize(String text, String toolTipText, String icon, int x, int y){
		super(text);
		setBounds(x, y, 120, 25);
		setToolTipText(toolTipText);
		setIcon(new ImageIcon(
				ButtonSynchronize.class
				.getResource(icon)));
	}
}
