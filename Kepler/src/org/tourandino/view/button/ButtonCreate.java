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
public class ButtonCreate extends JButton{

	/**
	 *
	 */

	public ButtonCreate(int x, int y){
		super("Crear");
		setBounds(x, y, 120, 25);
		setToolTipText("Agregar un nuevo elemento");
		setIcon(new ImageIcon(
				ButtonCreate.class
				.getResource("/org/tourandino/resources/img/add.png")));
	}
	
	public ButtonCreate(String text, String toolTipText, String icon, int x, int y){
		super(text);
		setBounds(x, y, 120, 25);
		setToolTipText(toolTipText);
		setIcon(new ImageIcon(
				ButtonCreate.class
				.getResource(icon)));
	}
}
