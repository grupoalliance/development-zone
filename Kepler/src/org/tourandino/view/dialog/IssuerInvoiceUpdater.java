package org.tourandino.view.dialog;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import org.tourandino.controller.ErrorLogController;
import org.tourandino.controller.IssuerInvoiceController;
import org.tourandino.controller.OrderController;
import org.tourandino.util.DatePicker;
import org.tourandino.view.frame.Main;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class IssuerInvoiceUpdater extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -214349194818108970L;
	private JLabel lblInvoiceNo;
	private JLabel lblInvoiceDate;
	private JTextField txtInvoiceNumber;
	private JTextField txtInvoiceDate;
	private JScrollPane scrollPane;
	private JButton btnDate;
	private JTable tableOrder;
	private IssuerInvoiceController issuerInvoiceController;
	private OrderController orderController;
	private ErrorLogController errorLogController;
	private JTextField txtTotal;

	/**
	 * Create the dialog.
	 */
	public IssuerInvoiceUpdater(JDialog parent, boolean modal, IssuerInvoiceController issuerInvoiceController, Integer id) {
		super(parent, modal);
		this.issuerInvoiceController = issuerInvoiceController;
		this.orderController = new OrderController();
		this.errorLogController = new ErrorLogController();
		initializeComponents();
		orderController.setOrder(issuerInvoiceController.getById(id).getOrder());
		loadTable(tableOrder);
		loadIssuerInvoice(id);
	}
	
	private void initializeComponents(){
		setTitle("Editor de Factura");
		setResizable(false);
		getContentPane().setBackground(new Color(255, 204, 51));
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		lblInvoiceNo = new JLabel("No. Factura", JLabel.RIGHT);
		lblInvoiceNo.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblInvoiceNo.setBounds(12, 370, 124, 19);
		getContentPane().add(lblInvoiceNo);
		
		lblInvoiceDate = new JLabel("Fecha facturación", JLabel.RIGHT);
		lblInvoiceDate.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblInvoiceDate.setBounds(12, 401, 124, 19);
		getContentPane().add(lblInvoiceDate);
		
		txtInvoiceNumber = new JTextField();
		txtInvoiceNumber.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtInvoiceNumber.setBounds(154, 370, 280, 19);
		getContentPane().add(txtInvoiceNumber);
		txtInvoiceNumber.setColumns(10);
		
		txtInvoiceDate = new JTextField();
		txtInvoiceDate.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtInvoiceDate.setBounds(154, 401, 243, 19);
		getContentPane().add(txtInvoiceDate);
		txtInvoiceDate.setColumns(10);
		
		JButton btnUpdate = new JButton("Aceptar");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e);
			}
		});
		btnUpdate.setIcon(new ImageIcon(IssuerInvoiceUpdater.class.getResource("/ar/com/tourandino/resources/accept.png")));
		btnUpdate.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnUpdate.setBounds(659, 528, 117, 25);
		getContentPane().add(btnUpdate);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setIcon(new ImageIcon(IssuerInvoiceUpdater.class.getResource("/ar/com/tourandino/resources/cancel.png")));
		btnCancel.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnCancel.setBounds(530, 528, 117, 25);
		getContentPane().add(btnCancel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 91, 764, 267);
		getContentPane().add(scrollPane);
		
		tableOrder = new JTable();
		scrollPane.setViewportView(tableOrder);
		
		btnDate = new JButton("");
		btnDate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnDateActionPerformed(evt);
			}
		});
		btnDate.setIcon(new ImageIcon(IssuerInvoiceUpdater.class.getResource("/ar/com/tourandino/resources/calendar.png")));
		btnDate.setToolTipText("Ver calendario");
		btnDate.setBounds(409, 398, 25, 25);
		getContentPane().add(btnDate);
		
		JLabel lblTotal = new JLabel("Total facturado", SwingConstants.RIGHT);
		lblTotal.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblTotal.setBounds(12, 432, 124, 19);
		getContentPane().add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtTotal.setColumns(10);
		txtTotal.setBounds(154, 432, 124, 19);
		getContentPane().add(txtTotal);
	}
	
	private void loadTable(JTable table){
		table.setModel(orderController.readUnique());
		table.removeColumn(table.getColumnModel().getColumn(0));
	}
	
	private void loadIssuerInvoice(Integer id){
		Object[] item = issuerInvoiceController.read(id);
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
		txtInvoiceNumber.setText(item[1].toString());
		txtInvoiceDate.setText(sdfDate.format(item[2]));
		txtTotal.setText(item[3].toString());
	}
	
	private void btnUpdateActionPerformed(ActionEvent evt){
		if(!txtInvoiceNumber.getText().isEmpty()){
			if(!txtInvoiceDate.getText().isEmpty()){
				if(!txtTotal.getText().isEmpty()){
						SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
						try{
							issuerInvoiceController.update(txtInvoiceNumber.getText(), sdfDate.parse(txtInvoiceDate.getText()), 0, 0, Float.parseFloat(txtTotal.getText()));
							JOptionPane.showMessageDialog(this, "La operacíon se completó exitosamente.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/information.png")));
							dispose();
						}
						catch(ParseException e){
							errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
							JOptionPane.showMessageDialog(this, "No se pudo completar la operación. Verifique la fecha ingresada e intente nuevamente.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
						}
						catch(NullPointerException e1){
							errorLogController.createErrorLog(new Date(), e1.getMessage(), this.getTitle(), e1.toString());
							JOptionPane.showMessageDialog(this, "No se pudo completar la operación. Verifique el monto ingresado e intente nuevamente.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
						}
						catch(NumberFormatException e2){
							errorLogController.createErrorLog(new Date(), e2.getMessage(), this.getTitle(), e2.toString());
							JOptionPane.showMessageDialog(this, "No se pudo completar la operación. Verifique el monto ingresado e intente nuevamente.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
						}
				}
				else
					JOptionPane.showMessageDialog(this, "No se pudo completar la operación. Ingrese el monto e intente nuevamente.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
			}
			else
				JOptionPane.showMessageDialog(this, "No se pudo completar la operación. Ingrese la fecha e intente nuevamente.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
		else
			JOptionPane.showMessageDialog(this, "No se pudo completar la operación. Ingrese el número de factura e intente nuevamente.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
	}
	
	private void btnDateActionPerformed(ActionEvent e){
		txtInvoiceDate.setText(new DatePicker(this).getPickedDate());
	}
}
