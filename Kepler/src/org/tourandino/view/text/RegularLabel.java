package org.tourandino.view.text;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author romerori
 * @creation Dec 10, 2015
 * @class RegularLabel
 *
 */
public class RegularLabel extends JLabel{

	public RegularLabel(String text, int horizontalAlignment, String icon, int x, int y){
		super(text, horizontalAlignment);
		setBounds(x, y, 120, 19);
		setIcon(new ImageIcon(
				RegularLabel.class
				.getResource(icon)));
	}
	
	public RegularLabel(String text, String icon, int x, int y){
		super(text);
		setBounds(x, y, 120, 19);
		setIcon(new ImageIcon(
				RegularLabel.class
				.getResource(icon)));
	}
	
	public RegularLabel(String text, int horizontalAlignment, int x, int y){
		super(text, horizontalAlignment);
		setBounds(x, y, 120, 19);
	}
	
	public RegularLabel(String text, int x, int y){
		super(text);
		setBounds(x, y, 120, 19);
	}
}
