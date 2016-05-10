package org.tourandino.view.button;

import javax.swing.JRadioButton;

/**
 * 
 * @author romerori
 * @creation Dec 10, 2015
 * @class RegularRadioButton
 *
 */
public class RegularRadioButton extends JRadioButton{

	/**
	 *
	 */

	public RegularRadioButton(String text, boolean selected, int x, int y){
		super(text, selected);
		setBounds(x, y, 120, 19);
	}

}
