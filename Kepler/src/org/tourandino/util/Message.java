package org.tourandino.util;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * 
 * @author romerori
 * @creation Oct 8, 2015
 *
 */

public class Message extends JOptionPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5633859536448565907L;
	private String message;
	private Component parent;

	public Message(Component parent, String message) {
		this.message = message;
		this.parent = parent;
	}
	
	public Message(Component parent) {
		this.parent = parent;
	}

	public void informationMessage() {
		showMessageDialog(
				parent,
				"La operaci\u00f3n se complet\u00f3 exitosamente.",
				"Informaci\u00f3n",
				JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon(
						Message.class
								.getResource("/org/tourandino/resources/img/information.png")));
	}
	
	public void showMessage() {
		showMessageDialog(
				parent,
				message,
				"Mensaje",
				JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon(
						Message.class
								.getResource("/org/tourandino/resources/img/information.png")));
	}

	public void warningMessage() {
		showMessageDialog(
				parent,
				"La operaci\u00f3n no se pudo completar, verifique e intente nuevamente.",
				"Advertencia",
				JOptionPane.WARNING_MESSAGE,
				new ImageIcon(
						Message.class
								.getResource("/org/tourandino/resources/img/warning.png")));
	}

	public void errorMessage() {
		showMessageDialog(
				parent,
				"Se ha producido un error al intentar completar la operaci\u00f3n.",
				"Error",
				JOptionPane.ERROR_MESSAGE,
				new ImageIcon(
						Message.class
								.getResource("/org/tourandino/resources/img/exclamation.png")));
	}

	public int questionMessage() {
		return showOptionDialog(
				parent,
				"¿Desea continuar?",
				"Confirma",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				new ImageIcon(Message.class
						.getResource("/org/tourandino/resources/img/help.png")),
				new Object[] { "Si", "No"}, "Si");
	}

}
