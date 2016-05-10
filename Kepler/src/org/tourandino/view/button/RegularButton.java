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
public class RegularButton extends JButton{

	/**
	 *
	 */

	public RegularButton(String text, String icon, int x, int y){
		super(text);
		setBounds(x, y, 120, 25);
		setIcon(new ImageIcon(
				RegularButton.class
				.getResource(icon)));
	}
	
	public RegularButton(String text, String toolTipText, String icon, int x, int y){
		super(text);
		setBounds(x, y, 120, 25);
		setToolTipText(toolTipText);
		setIcon(new ImageIcon(
				RegularButton.class
				.getResource(icon)));
	}
}
