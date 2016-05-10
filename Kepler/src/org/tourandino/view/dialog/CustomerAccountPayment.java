package org.tourandino.view.dialog;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import org.tourandino.controller.CustAccPaymentController;
import org.tourandino.controller.CustomerAccountController;
import org.tourandino.controller.ErrorLogController;
import org.tourandino.view.frame.Main;

public class CustomerAccountPayment extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5119846141012522654L;
	private JTextField txtNotes;
	private ErrorLogController errorLogController;
	private CustomerAccountController customerAccountController;
	private CustAccPaymentController custAccPaymentController;
	private JTextField txtBalance;
	private JTextField txtTotal;

	/**
	 * Create the dialog.
	 */
	public CustomerAccountPayment(JDialog parent, boolean modal, CustomerAccountController customerAccountController, Integer id) {
		super(parent, modal);
		this.customerAccountController = customerAccountController;
		this.errorLogController = new ErrorLogController();
		this.custAccPaymentController = new CustAccPaymentController();
		initializeComponents();
		loadAccount(id);
	}
	
	private void initializeComponents(){
		getContentPane().setBackground(new Color(255, 204, 51));
		setTitle("Cobranza de saldo a cliente");
		getContentPane().setLayout(null);
		
		JButton btnConfirm = new JButton("Confirmar");
		btnConfirm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnConfirmActionPerformed(evt);
			}
		});
		btnConfirm.setIcon(new ImageIcon(CustomerAccountPayment.class.getResource("/ar/com/tourandino/resources/accept.png")));
		btnConfirm.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnConfirm.setBounds(309, 228, 117, 25);
		getContentPane().add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});
		btnCancel.setIcon(new ImageIcon(CustomerAccountPayment.class.getResource("/ar/com/tourandino/resources/cancel.png")));
		btnCancel.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnCancel.setBounds(180, 228, 117, 25);
		getContentPane().add(btnCancel);
		
		JLabel lblMonto = new JLabel("Total a pagar", JLabel.RIGHT);
		lblMonto.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblMonto.setBounds(36, 149, 90, 15);
		getContentPane().add(lblMonto);
		
		txtNotes = new JTextField();
		txtNotes.setBounds(144, 116, 231, 19);
		getContentPane().add(txtNotes);
		txtNotes.setColumns(10);
		
		txtBalance = new JTextField();
		txtBalance.setEditable(false);
		txtBalance.setBounds(144, 85, 231, 19);
		getContentPane().add(txtBalance);
		txtBalance.setColumns(10);
		
		JLabel lblSaldo = new JLabel("Saldo", SwingConstants.RIGHT);
		lblSaldo.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblSaldo.setBounds(36, 87, 90, 15);
		getContentPane().add(lblSaldo);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(144, 147, 114, 19);
		getContentPane().add(txtTotal);
		txtTotal.setColumns(10);
		
		JLabel lblNotas = new JLabel("Observación", SwingConstants.RIGHT);
		lblNotas.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblNotas.setBounds(36, 118, 90, 15);
		getContentPane().add(lblNotas);
		setResizable(false);
		setBounds(100, 100, 450, 300);

	}
	
	private void btnConfirmActionPerformed(ActionEvent evt){
		try{
			if(customerAccountController.getCustomerAccount() != null){
				if(custAccPaymentController.create(customerAccountController.getCustomerAccount(), 0, 0, Float.parseFloat(txtTotal.getText()), txtNotes.getText()) > 0){
					JOptionPane.showMessageDialog(this, "La operacíon se completó exitosamente.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/information.png")));
					dispose();
				}
			}
			else{
				JOptionPane.showMessageDialog(this, "No se pudo completar la operación. Intente nuevamente o contacte al soporte.", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
			}
			
		}
		catch(NullPointerException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), getTitle(), e.toString());
			JOptionPane.showMessageDialog(this, "No se pudo completar la operación. Verifique el monto ingresado e intente nuevamente.", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
		}
		catch(NumberFormatException e1){
			errorLogController.createErrorLog(new Date(), e1.getMessage(), getTitle(), e1.toString());
			JOptionPane.showMessageDialog(this, "No se pudo completar la operación. Verifique el monto ingresado e intente nuevamente.", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
		}
	}
	
	private void loadAccount(Integer id){
		Object[] items = customerAccountController.read(id);
		txtBalance.setText(items[2].toString());
	}
}
