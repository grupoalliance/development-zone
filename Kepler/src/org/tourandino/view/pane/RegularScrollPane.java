package org.tourandino.view.pane;

import javax.swing.JScrollPane;

/**
 * 
 * @author romerori
 * @creation Dec 10, 2015
 * @class RegularScrollPane
 *
 */
public class RegularScrollPane extends JScrollPane{

	public RegularScrollPane(int x, int y, int width, int height){
		super();
		setBounds(x, y, width, height);
	}
	
}
