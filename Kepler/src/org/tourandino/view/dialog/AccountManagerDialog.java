package org.tourandino.view.dialog;

import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.WindowConstants;

import org.tourandino.controller.CustomerAccountController;
import org.tourandino.util.Message;
import org.tourandino.view.button.ButtonClose;
import org.tourandino.view.button.ButtonCreate;
import org.tourandino.view.button.ButtonDelete;
import org.tourandino.view.button.ButtonRead;
import org.tourandino.view.button.ButtonSearch;
import org.tourandino.view.button.ButtonUpdate;
import org.tourandino.view.button.RegularRadioButton;
import org.tourandino.view.pane.RegularScrollPane;
import org.tourandino.view.text.RegularLabel;
import org.tourandino.view.text.RegularTextField;

/**
 * 
 * @author romerori
 * @creation Dec 24, 2015
 * @class CustomerAccountManager
 *
 */
public class AccountManagerDialog extends JDialog {

	private ButtonClose btnClose;
	private ButtonSearch btnSearch;
	private ButtonCreate btnCreate;
	private ButtonRead btnRead;
	private ButtonUpdate btnUpdate;
	private ButtonDelete btnDelete;
	private RegularLabel lblSearch;
	private RegularTextField txtSearch;
	private RegularRadioButton rrbName;
	private RegularRadioButton rrbCuit;
	private RegularRadioButton rrbAddress;
	private ButtonGroup searchGroup;
	private RegularScrollPane paneResult;
	private JTable tableResult;
	private CustomerAccountController customerAccountController;

	/**
	 * Create the dialog.
	 */
	public AccountManagerDialog(JFrame parent, boolean modal) {
		super(parent, "Cuentas", modal);
		customerAccountController = new CustomerAccountController();
		initializeComponents();
	}
	
	private void initializeComponents(){
		getContentPane().setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 960, 540);
		
		lblSearch = new RegularLabel("B\u00fasqueda", JLabel.RIGHT, 376, 14);
		getContentPane().add(lblSearch);

		txtSearch = new RegularTextField(506, 13);
		getContentPane().add(txtSearch);

		rrbName = new RegularRadioButton("Nombre", true, 502, 39);
		getContentPane().add(rrbName);

		rrbCuit = new RegularRadioButton("CUIT", false, 604, 39);
		getContentPane().add(rrbCuit);

		rrbAddress = new RegularRadioButton("Domicilio", false, 706, 39);
		getContentPane().add(rrbAddress);
		
		btnClose = new ButtonClose(824, 476);
		getContentPane().add(btnClose);
		
		btnSearch = new ButtonSearch(824, 11);
		getContentPane().add(btnSearch);
		
		btnCreate = new ButtonCreate(12, 67);
		getContentPane().add(btnCreate);

		btnRead = new ButtonRead(142, 67);
		getContentPane().add(btnRead);

		btnUpdate = new ButtonUpdate(272, 67);
		getContentPane().add(btnUpdate);

		btnDelete = new ButtonDelete(402, 67);
		getContentPane().add(btnDelete);

		paneResult = new RegularScrollPane(12, 103, 932, 362);
		getContentPane().add(paneResult);

		tableResult = new JTable();
		paneResult.setViewportView(tableResult);
		
		searchGroup = new ButtonGroup();
		searchGroup.add(rrbName);
		searchGroup.add(rrbCuit);
		searchGroup.add(rrbAddress);
		
		loadTable(tableResult, true);
	}
	
	private void btnPaymentActionPerformed(ActionEvent evt){
		try{
			CustomerAccountPayment customerAccountPayment = new CustomerAccountPayment(this, true, customerAccountController, Integer.parseInt(tableResult.getModel().getValueAt(tableResult.getSelectedRow(), 0).toString()));
			customerAccountPayment.setLocationRelativeTo(this);
			customerAccountPayment.setVisible(true);
			loadTable(tableResult, true);
		}
		catch(NumberFormatException e){
			Message msg = new Message(this, "Seleccione un elemento de la lista");
			msg.showMessage();
		}
		catch(ArrayIndexOutOfBoundsException e1){
			Message msg = new Message(this, "Seleccione un elemento de la lista");
			msg.showMessage();
		}
	}
	
	private void loadTable(JTable table, boolean active){
		table.setModel(customerAccountController.read(active));
		table.removeColumn(table.getColumnModel().getColumn(0));
    }
	
	private void loadTable(JTable table, String search, boolean active){
		table.setModel(customerAccountController.read(search, active));
		table.removeColumn(table.getColumnModel().getColumn(0));
    }
	
	private void txtSearchActionPerformed(ActionEvent evt){
		if(!txtSearch.getText().isEmpty()){
			loadTable(tableResult, txtSearch.getText(), true);
		}
		else{
			loadTable(tableResult, true);
		}
	}
	
	private void btnSearchActionPerformed(ActionEvent e){
		if(!txtSearch.getText().isEmpty()){
			loadTable(tableResult, txtSearch.getText(), true);
		}
		else{
			loadTable(tableResult, true);
		}
	}
	
	private void cbxActiveActionPerformed(ActionEvent evt){
		if(!txtSearch.getText().isEmpty()){
			loadTable(tableResult, txtSearch.getText(), true);
		}
		else{
			loadTable(tableResult, true);
		}
	}
}
