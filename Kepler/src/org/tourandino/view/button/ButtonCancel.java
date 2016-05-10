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
public class ButtonCancel extends JButton{

	/**
	 *
	 */

	public ButtonCancel(int x, int y){
		super("Cancelar");
		setBounds(x, y, 120, 25);
		setToolTipText("Cancelar la operaci\u00f3n actual");
		setIcon(new ImageIcon(
				ButtonCancel.class
				.getResource("/org/tourandino/resources/img/cancel.png")));
	}
	
	public ButtonCancel(String text, String toolTipText, String icon, int x, int y){
		super(text);
		setBounds(x, y, 120, 25);
		setToolTipText(toolTipText);
		setIcon(new ImageIcon(
				ButtonCancel.class
				.getResource(icon)));
	}
}
