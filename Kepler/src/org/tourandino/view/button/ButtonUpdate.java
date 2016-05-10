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
public class ButtonUpdate extends JButton{

	/**
	 *
	 */

	public ButtonUpdate(int x, int y){
		super("Actualizar");
		setBounds(x, y, 120, 25);
		setToolTipText("Actualizar los datos del elemento seleccionado");
		setIcon(new ImageIcon(
				ButtonUpdate.class
				.getResource("/org/tourandino/resources/img/pencil.png")));
	}
	
	public ButtonUpdate(String text, String toolTipText, String icon, int x, int y){
		super(text);
		setBounds(x, y, 120, 25);
		setToolTipText(toolTipText);
		setIcon(new ImageIcon(
				ButtonUpdate.class
				.getResource(icon)));
	}
}
