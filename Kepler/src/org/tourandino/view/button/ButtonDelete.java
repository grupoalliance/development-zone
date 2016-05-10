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
public class ButtonDelete extends JButton{

	/**
	 *
	 */

	public ButtonDelete(int x, int y){
		super("Borrar");
		setBounds(x, y, 120, 25);
		setToolTipText("Borra el elemento seleccionado");
		setIcon(new ImageIcon(
				ButtonDelete.class
				.getResource("/org/tourandino/resources/img/delete.png")));
	}
	
	public ButtonDelete(String text, String toolTipText, String icon, int x, int y){
		super(text);
		setBounds(x, y, 120, 25);
		setToolTipText(toolTipText);
		setIcon(new ImageIcon(
				ButtonDelete.class
				.getResource(icon)));
	}
	
}
