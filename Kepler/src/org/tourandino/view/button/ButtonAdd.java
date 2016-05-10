package org.tourandino.view.button;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * 
 * @author romerori
 * @creation Dec 10, 2015
 * @class SmallButton
 *
 */
public class ButtonAdd extends JButton{

	public ButtonAdd(int x, int y){
		setBounds(x, y, 25, 25);
		setToolTipText("Agregar un nuevo elemento");
		setIcon(new ImageIcon(
				ButtonAdd.class
				.getResource("/org/tourandino/resources/img/add.png")));
	}
	
	public ButtonAdd(String toolTipText, String icon, int x, int y){
		setBounds(x, y, 25, 25);
		setIcon(new ImageIcon(
				ButtonAdd.class
				.getResource(icon)));
		setToolTipText(toolTipText);
	}
}
