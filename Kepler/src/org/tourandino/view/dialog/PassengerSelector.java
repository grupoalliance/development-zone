package org.tourandino.view.dialog;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTable;

import org.tourandino.controller.ErrorLogController;
import org.tourandino.controller.PassengerController;
import org.tourandino.view.frame.Main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

public class PassengerSelector extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 112444251828533016L;
	private JTable tablePassengers;
	private PassengerController passengerController;
	private JButton btnAccept;
	private JButton btnCancel;
	private ErrorLogController errorLogController;

	/**
	 * Create the dialog.
	 */
	public PassengerSelector(JDialog parent, boolean modal, PassengerController passengerController, String search) {
		super(parent, modal);
		this.passengerController = passengerController;
		this.errorLogController = new ErrorLogController();
		initializeComponents(search);
	}
	
	private void initializeComponents(String search){
		getContentPane().setBackground(new Color(255, 204, 51));
		setTitle("Selector de Pasajero");
		setResizable(false);
		setBounds(100, 100, 600, 450);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 564, 354);
		getContentPane().add(scrollPane);
		
		tablePassengers = new JTable();
		scrollPane.setViewportView(tablePassengers);
		loadTable(tablePassengers, search);
		
		btnAccept = new JButton("Aceptar");
		btnAccept.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				btnAcceptActionPerformed(e);
			}
		});
		btnAccept.setIcon(new ImageIcon(PassengerSelector.class.getResource("/ar/com/tourandino/resources/accept.png")));
		btnAccept.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnAccept.setBounds(459, 378, 117, 25);
		getContentPane().add(btnAccept);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setIcon(new ImageIcon(PassengerSelector.class.getResource("/ar/com/tourandino/resources/cancel.png")));
		btnCancel.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnCancel.setBounds(330, 378, 117, 25);
		getContentPane().add(btnCancel);
	}
	
	private void loadTable(JTable table, String search){
		if(search.isEmpty()){
			table.setModel(passengerController.read());
			table.removeColumn(tablePassengers.getColumnModel().getColumn(0));
		}
		else{
			table.setModel(passengerController.read(search));
			table.removeColumn(tablePassengers.getColumnModel().getColumn(0));
		}
	}
	
	private void btnAcceptActionPerformed(ActionEvent evt){
		try{
			int rowIndex = tablePassengers.getSelectedRow();
			int columnIndex = 0;
			passengerController.create(Integer.parseInt((tablePassengers.getModel().getValueAt(rowIndex, columnIndex).toString())));
			dispose();
		}
		catch(NullPointerException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
			JOptionPane.showMessageDialog(this, "Seleccione un pasajero de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
		catch(ArrayIndexOutOfBoundsException e1){
			errorLogController.createErrorLog(new Date(), e1.getMessage(), this.getTitle(), e1.toString());
			JOptionPane.showMessageDialog(this, "Seleccione un pasajero de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
	}
	
}
