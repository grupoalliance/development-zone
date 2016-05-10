package org.tourandino.view.dialog;

import javax.swing.JDialog;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.tourandino.controller.CashMovementController;
import org.tourandino.controller.DailyCashRecordController;
import org.tourandino.controller.ErrorLogController;
import org.tourandino.view.frame.Main;

import javax.swing.DefaultComboBoxModel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class NewIncome extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6042185820932928641L;
	private JTextField txtTotal;
	private JTextField txtDescr;
	private JComboBox cmbCategory;
	private CashMovementController cashMovementController;
	private ErrorLogController errorLogController;

	/**
	 * Create the dialog.
	 */
	public NewIncome(JFrame parent, boolean modal) {
		super(parent, modal);
		this.cashMovementController = new CashMovementController();
		this.errorLogController = new ErrorLogController();
		initializeComponents();
	}
	
	private void initializeComponents(){
		setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		setResizable(false);
		getContentPane().setBackground(new Color(255, 204, 51));
		getContentPane().setLayout(null);
		
		JLabel lblTipoDeGasto = new JLabel("Tipo de ingreso", JLabel.RIGHT);
		lblTipoDeGasto.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblTipoDeGasto.setBounds(23, 78, 102, 15);
		getContentPane().add(lblTipoDeGasto);
		
		cmbCategory = new JComboBox();
		cmbCategory.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		cmbCategory.setModel(new DefaultComboBoxModel(new String[] {"DINERO EN APERTURA DE CAJA", "VENTAS", "COBRANZAS ATRASADAS", "AJUSTES DE CAJA", "OTROS INGRESOS"}));
		cmbCategory.setSelectedIndex(0);
		cmbCategory.setBounds(143, 76, 215, 19);
		getContentPane().add(cmbCategory);
		
		txtTotal = new JTextField();
		txtTotal.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtTotal.setBounds(143, 136, 215, 19);
		getContentPane().add(txtTotal);
		txtTotal.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total a pagar", JLabel.RIGHT);
		lblTotal.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblTotal.setBounds(23, 138, 102, 15);
		getContentPane().add(lblTotal);
		
		txtDescr = new JTextField();
		txtDescr.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtDescr.setBounds(143, 105, 215, 19);
		getContentPane().add(txtDescr);
		txtDescr.setColumns(10);
		
		JLabel lblConcepto = new JLabel("Concepto", JLabel.RIGHT);
		lblConcepto.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblConcepto.setBounds(23, 107, 102, 15);
		getContentPane().add(lblConcepto);
		
		JButton btnAccept = new JButton("Confirmar");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAcceptActionPerformed(e);
			}
		});
		btnAccept.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnAccept.setIcon(new ImageIcon(NewIncome.class.getResource("/ar/com/tourandino/resources/accept.png")));
		btnAccept.setBounds(259, 228, 117, 25);
		getContentPane().add(btnAccept);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setIcon(new ImageIcon(NewIncome.class.getResource("/ar/com/tourandino/resources/cancel.png")));
		btnCancel.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnCancel.setBounds(130, 228, 117, 25);
		getContentPane().add(btnCancel);
		setTitle("Ingreso manual de dinero");
		setBounds(100, 100, 400, 300);

	}
	
	private void btnAcceptActionPerformed(ActionEvent evt){
		DailyCashRecordController dailyCashRecordController = new DailyCashRecordController();
		if(!txtTotal.getText().isEmpty()){
			if(!txtDescr.getText().isEmpty()){
				if(dailyCashRecordController.dailyRecordExist()){
					if(!dailyCashRecordController.DailyRecordIsClosed()){
						try{
							if(cashMovementController.create(Float.parseFloat(txtTotal.getText()), 0, cmbCategory.getSelectedItem().toString()+", "+ txtDescr.getText()) > 0){
								JOptionPane.showMessageDialog(this, "La operacíon se completó exitosamente.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/information.png")));
								this.dispose();
							}
							else{
								JOptionPane.showMessageDialog(this, "No se pudo completar la operación, intente nuevamente o contacte al Soporte.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
							}
						}
						catch(NumberFormatException e){
							errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
							JOptionPane.showMessageDialog(this, "No se pudo completar la operación. Verifique el monto ingresado e intente nuevamente.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
						}
						catch(NullPointerException e1){
							errorLogController.createErrorLog(new Date(), e1.getMessage(), this.getTitle(), e1.toString());
							JOptionPane.showMessageDialog(this, "No se pudo completar la operación. Por favor realice la apertura de caja e intente nuevamente.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
						}
					}
					else
						JOptionPane.showMessageDialog(this, "No se pudo completar la operación, la caja ya se encuentra cerrada.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
				}
				else
					JOptionPane.showMessageDialog(this, "No se pudo completar la operación. Por favor realice la apertura de caja e intente nuevamente.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
				
			}
			else
				JOptionPane.showMessageDialog(this, "No se pudo completar la operación. Ingrese el campo concepto e intente nuevamente.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
		else
			JOptionPane.showMessageDialog(this, "No se pudo completar la operación. Ingrese el campo monto e intente nuevamente.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
	}
}
