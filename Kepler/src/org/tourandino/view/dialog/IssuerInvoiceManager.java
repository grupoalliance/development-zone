package org.tourandino.view.dialog;

import javax.swing.JDialog;

import java.awt.Color;

import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.tourandino.controller.ErrorLogController;
import org.tourandino.controller.IssuerInvoiceController;
import org.tourandino.util.DatePicker;
import org.tourandino.view.frame.Main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class IssuerInvoiceManager extends JDialog {

	private static final long serialVersionUID = 2054968089147933702L;
	private JTable tableOrders;
	private JTextField txtSearch;
	private JRadioButton rbtnDate;
	private JRadioButton rbtnIssuer;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private ErrorLogController errorLogController;
	private IssuerInvoiceController issuerInvoiceController;

	/**
	 * Create the dialog.
	 */
	public IssuerInvoiceManager(JFrame parent, boolean modal) {
		super(parent, modal);
		this.issuerInvoiceController = new IssuerInvoiceController();
		this.errorLogController = new ErrorLogController();
		initializeComponents();
	}
	
	private void initializeComponents(){
		setResizable(false);
		setTitle("Facturas ingresadas");
		getContentPane().setBackground(new Color(255, 204, 51));
		getContentPane().setLayout(null);
		
		JButton btnExit = new JButton("Salir");
		btnExit.setToolTipText("Salir y volver a la ventana principal");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setIcon(new ImageIcon(IssuerInvoiceManager.class.getResource("/ar/com/tourandino/resources/door.png")));
		btnExit.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnExit.setBounds(900, 696, 100, 25);
		getContentPane().add(btnExit);
		
		JLabel lblSearch = new JLabel("Búsqueda");
		lblSearch.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblSearch.setBounds(12, 12, 70, 15);
		getContentPane().add(lblSearch);
		
		txtSearch = new JTextField();
		txtSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSearchActionPerformed(e);
			}
		});
		txtSearch.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtSearch.setBounds(100, 10, 274, 19);
		getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("");
		btnSearch.setToolTipText("Buscar");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearchActionPerformed(e);
			}
		});
		btnSearch.setBounds(423, 7, 25, 25);
		btnSearch.setIcon(new ImageIcon(IssuerInvoiceManager.class.getResource("/ar/com/tourandino/resources/find.png")));
		getContentPane().add(btnSearch);
		
		JButton btnAdd = new JButton("Ingresar");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddActionPerformed(e);
			}
		});
		btnAdd.setToolTipText("");
		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnAddActionPerformed(evt);
			}
		});
		btnAdd.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnAdd.setBounds(726, 68, 131, 25);
		btnAdd.setIcon(new ImageIcon(IssuerInvoiceManager.class.getResource("/ar/com/tourandino/resources/add.png")));
		getContentPane().add(btnAdd);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 105, 988, 579);
		getContentPane().add(scrollPane);
		
		tableOrders = new JTable();
		loadTable(tableOrders);
		tableOrders.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(tableOrders);
		tableOrders.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		
		rbtnDate = new JRadioButton("Fecha");
		buttonGroup.add(rbtnDate);
		rbtnDate.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		rbtnDate.setBackground(new Color(255, 204, 51));
		rbtnDate.setBounds(66, 37, 100, 23);
		rbtnDate.setSelected(true);
		getContentPane().add(rbtnDate);
		
		JButton btnDatePicker = new JButton("");
		btnDatePicker.setToolTipText("Ver calendario");
		btnDatePicker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDateActionPerformed(e);
			}
		});
		btnDatePicker.setIcon(new ImageIcon(IssuerInvoiceManager.class.getResource("/ar/com/tourandino/resources/calendar.png")));
		btnDatePicker.setBounds(386, 7, 25, 25);
		getContentPane().add(btnDatePicker);
		
		rbtnIssuer = new JRadioButton("Operador");
		buttonGroup.add(rbtnIssuer);
		rbtnIssuer.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		rbtnIssuer.setBackground(new Color(255, 204, 51));
		rbtnIssuer.setBounds(170, 37, 100, 23);
		getContentPane().add(rbtnIssuer);
		
		JButton btnEdit = new JButton("Editar");
		btnEdit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnEditActionPerformed(evt);
			}
		});
		btnEdit.setIcon(new ImageIcon(IssuerInvoiceManager.class.getResource("/ar/com/tourandino/resources/pencil.png")));
		btnEdit.setToolTipText("");
		btnEdit.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnEdit.setBounds(869, 68, 131, 25);
		getContentPane().add(btnEdit);
		setBounds(100, 100, 1024, 768);
		
	}
	
	private void btnDateActionPerformed(ActionEvent e){
		txtSearch.setText(new DatePicker(this).getPickedDate());
	}
	
	private void loadTable(JTable table){
		table.setModel(issuerInvoiceController.read());
		table.removeColumn(table.getColumnModel().getColumn(0));
    }
	
	private void loadTableByIssuer(JTable table, String issuer){
		table.setModel(issuerInvoiceController.readByIssuer(issuer));
		table.removeColumn(table.getColumnModel().getColumn(0));
    }
	
	private void loadTable(JTable table, Date date){
		table.setModel(issuerInvoiceController.read(date));
		table.removeColumn(table.getColumnModel().getColumn(0));
    }
	
	private void btnAddActionPerformed(ActionEvent evt){
		IssuerInvoiceCreator issuerInvoiceCreator = new IssuerInvoiceCreator(this, true, issuerInvoiceController);
		issuerInvoiceCreator.setLocationRelativeTo(this);
		issuerInvoiceCreator.setVisible(true);
		loadTable(tableOrders);
	}
	
	private void btnEditActionPerformed(ActionEvent evt){
		try{
			int columnIndex = 0;
			int rowIndex = tableOrders.getSelectedRow();
			Integer id = Integer.parseInt(tableOrders.getModel().getValueAt(rowIndex, columnIndex).toString());
			IssuerInvoiceUpdater issuerInvoiceUpdater = new IssuerInvoiceUpdater(this, true, issuerInvoiceController, id);
			issuerInvoiceUpdater.setLocationRelativeTo(this);
			issuerInvoiceUpdater.setVisible(true);
			loadTable(tableOrders);
		}
		catch(ArrayIndexOutOfBoundsException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
			JOptionPane.showMessageDialog(this, "Seleccione un elemento de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
		catch(NullPointerException e1){
			errorLogController.createErrorLog(new Date(), e1.getMessage(), this.getTitle(), e1.toString());
			JOptionPane.showMessageDialog(this, "Seleccione un elemento de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
	}
	
	private void btnSearchActionPerformed(ActionEvent evt){
		if(!txtSearch.getText().isEmpty()){
			if(rbtnDate.isSelected()){
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					loadTable(tableOrders, sdf.parse(txtSearch.getText()));
				} 
				catch (ParseException e) {
					errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
				}
			}
			if(rbtnIssuer.isSelected()){
				loadTableByIssuer(tableOrders, txtSearch.getText());
			}
		}
		else{
			loadTable(tableOrders);
		}
	}
	
	private void txtSearchActionPerformed(ActionEvent evt){
		if(!txtSearch.getText().isEmpty()){
			if(rbtnDate.isSelected()){
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					loadTable(tableOrders, sdf.parse(txtSearch.getText()));
				} 
				catch (ParseException e) {
					errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
				}
			}
			if(rbtnIssuer.isSelected()){
				loadTableByIssuer(tableOrders, txtSearch.getText());
			}
		}
		else{
			loadTable(tableOrders);
		}
	}
}
