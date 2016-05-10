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
public class ButtonOK extends JButton{

	/**
	 *
	 */

	public ButtonOK(int x, int y){
		super("Aceptar");
		setBounds(x, y, 120, 25);
		setToolTipText("Completar la operaci\u00f3n actual");
		setIcon(new ImageIcon(
				ButtonOK.class
				.getResource("/org/tourandino/resources/img/accept.png")));
	}
	
	public ButtonOK(String text, String toolTipText, String icon, int x, int y){
		super(text);
		setBounds(x, y, 120, 25);
		setToolTipText(toolTipText);
		setIcon(new ImageIcon(
				ButtonOK.class
				.getResource(icon)));
	}
}
