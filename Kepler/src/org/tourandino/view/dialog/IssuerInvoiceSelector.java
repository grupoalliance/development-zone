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
import org.tourandino.controller.OrderController;
import org.tourandino.view.frame.Main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

public class IssuerInvoiceSelector extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 112444251828533016L;
	private JTable tablePassengers;
	private JButton btnAccept;
	private JButton btnCancel;
	private ErrorLogController errorLogController;
	private OrderController orderController;

	/**
	 * Create the dialog.
	 */
	public IssuerInvoiceSelector(JDialog parent, boolean modal, OrderController orderController, Date search) {
		super(parent, modal);
		this.orderController = orderController;
		this.errorLogController = new ErrorLogController();
		initializeComponents();
		loadTable(tablePassengers, search);
	}
	
	private void initializeComponents(){
		getContentPane().setBackground(new Color(255, 204, 51));
		setTitle("Selector de Venta realizada");
		setResizable(false);
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 764, 504);
		getContentPane().add(scrollPane);
		
		tablePassengers = new JTable();
		scrollPane.setViewportView(tablePassengers);
		
		btnAccept = new JButton("Aceptar");
		btnAccept.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				btnAcceptActionPerformed(e);
			}
		});
		btnAccept.setIcon(new ImageIcon(IssuerInvoiceSelector.class.getResource("/ar/com/tourandino/resources/accept.png")));
		btnAccept.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnAccept.setBounds(659, 528, 117, 25);
		getContentPane().add(btnAccept);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setIcon(new ImageIcon(IssuerInvoiceSelector.class.getResource("/ar/com/tourandino/resources/cancel.png")));
		btnCancel.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnCancel.setBounds(530, 528, 117, 25);
		getContentPane().add(btnCancel);
	}
	
	private void loadTable(JTable table, Date search){
		if(search != null){
			table.setModel(orderController.read(search));
			table.removeColumn(tablePassengers.getColumnModel().getColumn(0));
		}
		else{
			table.setModel(orderController.read());
			table.removeColumn(tablePassengers.getColumnModel().getColumn(0));
		}
	}
	
	private void btnAcceptActionPerformed(ActionEvent evt){
		try{
			int rowIndex = tablePassengers.getSelectedRow();
			int columnIndex = 0;
			orderController.create(Integer.parseInt((tablePassengers.getModel().getValueAt(rowIndex, columnIndex).toString())));
			dispose();
		}
		catch(NullPointerException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
			JOptionPane.showMessageDialog(this, "Seleccione un elemento de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
		catch(ArrayIndexOutOfBoundsException e1){
			errorLogController.createErrorLog(new Date(), e1.getMessage(), this.getTitle(), e1.toString());
			JOptionPane.showMessageDialog(this, "Seleccione un elemento de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
	}
	
}
