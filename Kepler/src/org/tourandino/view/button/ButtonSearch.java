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
public class ButtonSearch extends JButton{

	/**
	 *
	 */

	public ButtonSearch(int x, int y){
		super("Buscar");
		setBounds(x, y, 120, 25);
		setToolTipText("Buscar elementos que coincidan con el texto de b\u00fasqueda");
		setIcon(new ImageIcon(
				ButtonSearch.class
				.getResource("/org/tourandino/resources/img/magnifier.png")));
	}
	
	public ButtonSearch(String text, String toolTipText, String icon, int x, int y){
		super(text);
		setBounds(x, y, 120, 25);
		setToolTipText(toolTipText);
		setIcon(new ImageIcon(
				ButtonSearch.class
				.getResource(icon)));
	}
}
