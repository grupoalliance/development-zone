package org.tourandino.view.button;

import javax.swing.JCheckBox;

/**
 * 
 * @author romerori
 * @creation Dec 10, 2015
 * @class RegularCheckBox
 *
 */
public class RegularCheckBox extends JCheckBox{

	/**
	 *
	 */

	public RegularCheckBox(String text, boolean selected, int x, int y){
		super(text, selected);
		setBounds(x, y, 200, 19);
	}

}
