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
public class ButtonClose extends JButton{

	/**
	 *
	 */

	public ButtonClose(int x, int y){
		super("Salir");
		setBounds(x, y, 120, 25);
		setToolTipText("Cerrar la ventana actual");
		setIcon(new ImageIcon(
				ButtonClose.class
				.getResource("/org/tourandino/resources/img/door_in.png")));
	}
	
	public ButtonClose(String text, String toolTipText, String icon, int x, int y){
		super(text);
		setBounds(x, y, 120, 25);
		setToolTipText(toolTipText);
		setIcon(new ImageIcon(
				ButtonClose.class
				.getResource(icon)));
	}
}
