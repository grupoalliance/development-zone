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
public class ButtonImport extends JButton{

	/**
	 *
	 */

	public ButtonImport(int x, int y){
		super("Importar");
		setBounds(x, y, 120, 25);
		setToolTipText("Importar datos desde la planilla Excel a la grilla");
		setIcon(new ImageIcon(
				ButtonImport.class
				.getResource("/org/tourandino/resources/img/document_export.png")));
	}
	
	public ButtonImport(String text, String toolTipText, String icon, int x, int y){
		super(text);
		setBounds(x, y, 120, 25);
		setToolTipText(toolTipText);
		setIcon(new ImageIcon(
				ButtonImport.class
				.getResource(icon)));
	}
}
