package org.tourandino.view.dialog;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import org.tourandino.controller.ErrorLogController;
import org.tourandino.controller.OrderController;
import org.tourandino.controller.PaymentMethodController;
import org.tourandino.view.frame.Main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class NewPayment extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8742257275872732749L;
	private JTextField txtAmount;
	private JComboBox cmbPayments;
	private ErrorLogController errorLogController;
	private PaymentMethodController paymentMethodController;
	private JTextField txtNotes;
	private OrderController orderController;

	/**
	 * Create the dialog.
	 */
	public NewPayment(JDialog parent, boolean modal, OrderController orderController) {
		super(parent, modal);
		setTitle("Ingresar un pago");
		this.orderController = orderController;
		this.errorLogController = new ErrorLogController();
		this.paymentMethodController = new PaymentMethodController();
		initializeComponents();
	}
	
	private void initializeComponents(){
		setResizable(false);
		getContentPane().setBackground(new Color(255, 204, 51));
		setBounds(100, 100, 400, 300);
		getContentPane().setLayout(null);
		
		cmbPayments = new JComboBox();
		loadCombo(cmbPayments);
		cmbPayments.setSelectedIndex(0);
		cmbPayments.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		cmbPayments.setBounds(150, 75, 200, 19);
		getContentPane().add(cmbPayments);
		
		JLabel lblFormaDePago = new JLabel("Forma de pago", JLabel.RIGHT);
		lblFormaDePago.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblFormaDePago.setBounds(12, 77, 120, 15);
		getContentPane().add(lblFormaDePago);
		
		JButton btnConfirm = new JButton("Confirmar");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConfirmActionPerformed(e);
			}
		});
		btnConfirm.setIcon(new ImageIcon(NewPayment.class.getResource("/ar/com/tourandino/resources/accept.png")));
		btnConfirm.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnConfirm.setBounds(259, 228, 117, 25);
		getContentPane().add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});
		btnCancel.setIcon(new ImageIcon(NewPayment.class.getResource("/ar/com/tourandino/resources/cancel.png")));
		btnCancel.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnCancel.setBounds(135, 228, 117, 25);
		getContentPane().add(btnCancel);
		
		txtAmount = new JTextField();
		txtAmount.setBounds(150, 137, 117, 19);
		getContentPane().add(txtAmount);
		txtAmount.setColumns(10);
		
		JLabel lblMonto = new JLabel("Total a pagar", SwingConstants.RIGHT);
		lblMonto.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblMonto.setBounds(12, 139, 120, 15);
		getContentPane().add(lblMonto);
		
		txtNotes = new JTextField();
		txtNotes.setColumns(10);
		txtNotes.setBounds(150, 106, 200, 19);
		getContentPane().add(txtNotes);
		
		JLabel lblNotes = new JLabel("Observación", SwingConstants.RIGHT);
		lblNotes.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblNotes.setBounds(12, 108, 120, 15);
		getContentPane().add(lblNotes);
	}
	
	private void btnConfirmActionPerformed(ActionEvent evt){
		try{
			orderController.addPayment(Float.parseFloat(txtAmount.getText()), txtNotes.getText(), cmbPayments.getSelectedItem());
			dispose();
		}
		catch(NumberFormatException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
			JOptionPane.showMessageDialog(this, "El monto ingresado es inválido, por favor ingrese un nuevo monto e intente nuevamente", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
		}
		catch(NullPointerException e1){
			errorLogController.createErrorLog(new Date(), e1.getMessage(), this.getTitle(), e1.toString());
			JOptionPane.showMessageDialog(this, "El monto ingresado es inválido, por favor ingrese un nuevo monto e intente nuevamente", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
		}
	}
	
	private void loadCombo(JComboBox jComboBox){
		jComboBox.setModel(paymentMethodController.read());
	}
}
