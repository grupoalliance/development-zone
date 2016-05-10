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

public class IssuerInvoiceCreator extends JDialog {

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
	private JLabel lblSearch;
	private JTextField txtSearch;
	private JButton btnSearch;
	private JButton btnDateSearch;
	private IssuerInvoiceController issuerInvoiceController;
	private OrderController orderController;
	private ErrorLogController errorLogController;
	private JTextField txtTotal;

	/**
	 * Create the dialog.
	 */
	public IssuerInvoiceCreator(JDialog parent, boolean modal, IssuerInvoiceController issuerInvoiceController) {
		super(parent, modal);
		this.issuerInvoiceController = issuerInvoiceController;
		this.orderController = new OrderController();
		this.errorLogController = new ErrorLogController();
		initializeComponents();
	}
	
	private void initializeComponents(){
		setTitle("Ingreso de Factura");
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
		
		JButton btnAdd = new JButton("Aceptar");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddActionPerformed(e);
			}
		});
		btnAdd.setIcon(new ImageIcon(IssuerInvoiceCreator.class.getResource("/ar/com/tourandino/resources/accept.png")));
		btnAdd.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnAdd.setBounds(659, 528, 117, 25);
		getContentPane().add(btnAdd);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setIcon(new ImageIcon(IssuerInvoiceCreator.class.getResource("/ar/com/tourandino/resources/cancel.png")));
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
		btnDate.setIcon(new ImageIcon(IssuerInvoiceCreator.class.getResource("/ar/com/tourandino/resources/calendar.png")));
		btnDate.setToolTipText("Ver calendario");
		btnDate.setBounds(409, 398, 25, 25);
		getContentPane().add(btnDate);
		
		lblSearch = new JLabel("Búsqueda", SwingConstants.RIGHT);
		lblSearch.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblSearch.setBounds(12, 57, 124, 19);
		getContentPane().add(lblSearch);
		
		txtSearch = new JTextField();
		txtSearch.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtSearch.setColumns(10);
		txtSearch.setBounds(154, 57, 243, 19);
		getContentPane().add(txtSearch);
		
		btnSearch = new JButton("");
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnSearchActionPerformed(evt);
			}
		});
		btnSearch.setIcon(new ImageIcon(IssuerInvoiceCreator.class.getResource("/ar/com/tourandino/resources/find.png")));
		btnSearch.setToolTipText("Buscar");
		btnSearch.setBounds(409, 54, 25, 25);
		getContentPane().add(btnSearch);
		
		btnDateSearch = new JButton("");
		btnDateSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnDateSearchActionPerformed(evt);
			}
		});
		btnDateSearch.setIcon(new ImageIcon(IssuerInvoiceCreator.class.getResource("/ar/com/tourandino/resources/calendar.png")));
		btnDateSearch.setToolTipText("Ver calendario");
		btnDateSearch.setBounds(446, 54, 25, 25);
		getContentPane().add(btnDateSearch);
		
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
	
	private void btnSearchActionPerformed(ActionEvent evt){
		if(!txtSearch.getText().isEmpty()){
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			try{
				IssuerInvoiceSelector issuerInvoiceSelector = new IssuerInvoiceSelector(this, true, orderController, sdf.parse(txtSearch.getText()));
				issuerInvoiceSelector.setLocationRelativeTo(this);
				issuerInvoiceSelector.setVisible(true);
				loadTable(tableOrder);
			}
			catch(ParseException e){
				errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
				JOptionPane.showMessageDialog(this, "Seleccione un elemento de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
			}
		}
		else{
			IssuerInvoiceSelector issuerInvoiceSelector = new IssuerInvoiceSelector(this, true, orderController, null);
			issuerInvoiceSelector.setLocationRelativeTo(this);
			issuerInvoiceSelector.setVisible(true);
			loadTable(tableOrder);
		}
	}
	
	private void loadTable(JTable table){
		table.setModel(orderController.readUnique());
		table.removeColumn(table.getColumnModel().getColumn(0));
	}
	
	private void btnAddActionPerformed(ActionEvent evt){
		if(!txtInvoiceNumber.getText().isEmpty()){
			if(!txtInvoiceDate.getText().isEmpty()){
				if(!txtTotal.getText().isEmpty()){
					if(orderController.getOrder() != null){
						SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
						try{
							if(issuerInvoiceController.create(orderController.getOrder(), txtInvoiceNumber.getText(), sdfDate.parse(txtInvoiceDate.getText()), 
										0, 0, Float.parseFloat(txtTotal.getText())) > 0){
								JOptionPane.showMessageDialog(this, "La operacíon se completó exitosamente.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/information.png")));
								dispose();
							}
							else{
								JOptionPane.showMessageDialog(this, "No se pudo completar la operación, intente nuevamente o contacte al Soporte.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
							}
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
					else{
						JOptionPane.showMessageDialog(this, "No se pudo completar la operación. Seleccione una venta realizada e intente nuevamente.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
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
	
	private void btnDateSearchActionPerformed(ActionEvent e){
		txtSearch.setText(new DatePicker(this).getPickedDate());
	}
	
	private void btnDateActionPerformed(ActionEvent e){
		txtInvoiceDate.setText(new DatePicker(this).getPickedDate());
	}
}
