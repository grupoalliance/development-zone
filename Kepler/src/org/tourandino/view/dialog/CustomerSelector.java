package org.tourandino.view.dialog;

import javax.swing.JDialog;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JTable;

import org.tourandino.controller.CustomerController;
import org.tourandino.controller.ErrorLogController;
import org.tourandino.view.frame.Main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

public class CustomerSelector extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 112444251828533016L;
	private JButton btnAccept;
	private JButton btnCancel;
	private JTable tableCustomers;
	private CustomerController customerController;
	private ErrorLogController errorLogController;

	/**
	 * Create the dialog.
	 */
	public CustomerSelector(JDialog parent, boolean modal, CustomerController customerController, String search) {
		super(parent, modal);
		this.customerController = customerController; 
		this.errorLogController = new ErrorLogController();
		initializeComponents(search);
	}
	
	private void initializeComponents(String search){
		getContentPane().setBackground(new Color(255, 204, 51));
		setTitle("Selector de cliente");
		setResizable(false);
		setBounds(100, 100, 600, 450);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 564, 354);
		getContentPane().add(scrollPane);
		
		tableCustomers = new JTable();
		scrollPane.setViewportView(tableCustomers);
		loadTable(tableCustomers, search);
		
		btnAccept = new JButton("Aceptar");
		btnAccept.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				btnAcceptActionPerformed(e);
			}
		});
		btnAccept.setIcon(new ImageIcon(CustomerSelector.class.getResource("/ar/com/tourandino/resources/accept.png")));
		btnAccept.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnAccept.setBounds(459, 378, 117, 25);
		getContentPane().add(btnAccept);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setIcon(new ImageIcon(CustomerSelector.class.getResource("/ar/com/tourandino/resources/cancel.png")));
		btnCancel.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnCancel.setBounds(330, 378, 117, 25);
		getContentPane().add(btnCancel);
	}
	
	private void loadTable(JTable table, String search){
		if(search.isEmpty()){
			table.setModel(customerController.read());
			table.removeColumn(tableCustomers.getColumnModel().getColumn(0));
		}
		else{
			table.setModel(customerController.readByName(search));
			table.removeColumn(tableCustomers.getColumnModel().getColumn(0));
		}
	}
	
	private void btnAcceptActionPerformed(ActionEvent evt){
		try{
			customerController.create(Integer.parseInt(tableCustomers.getModel().getValueAt(tableCustomers.getSelectedRow(), 0).toString()));
			dispose();
		}
		catch(NullPointerException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
			JOptionPane.showMessageDialog(this, "Seleccione un cliente de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
		catch(ArrayIndexOutOfBoundsException e1){
			errorLogController.createErrorLog(new Date(), e1.getMessage(), this.getTitle(), e1.toString());
			JOptionPane.showMessageDialog(this, "Seleccione un cliente de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
	}
	
}
