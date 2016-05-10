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
public class ButtonRead extends JButton{

	/**
	 *
	 */

	public ButtonRead(int x, int y){
		super("Ver");
		setBounds(x, y, 120, 25);
		setToolTipText("Ver el elemento seleccionado");
		setIcon(new ImageIcon(
				ButtonRead.class
				.getResource("/org/tourandino/resources/img/page_white_text.png")));
	}
	
	public ButtonRead(String text, String toolTipText, String icon, int x, int y){
		super(text);
		setBounds(x, y, 120, 25);
		setToolTipText(toolTipText);
		setIcon(new ImageIcon(
				ButtonRead.class
				.getResource(icon)));
	}
}
