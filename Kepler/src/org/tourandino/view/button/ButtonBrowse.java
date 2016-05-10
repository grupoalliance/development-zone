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
public class ButtonBrowse extends JButton{

	/**
	 *
	 */

	public ButtonBrowse(int x, int y){
		super("Examinar");
		setBounds(x, y, 120, 25);
		setToolTipText("Abrir el sistema de archivos");
		setIcon(new ImageIcon(
				ButtonBrowse.class
				.getResource("/org/tourandino/resources/img/drive_magnify.png")));
	}
	
	public ButtonBrowse(String text, String toolTipText, String icon, int x, int y){
		super(text);
		setBounds(x, y, 120, 25);
		setToolTipText(toolTipText);
		setIcon(new ImageIcon(
				ButtonBrowse.class
				.getResource(icon)));
	}
	
}
