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

import org.tourandino.controller.CustomerController;
import org.tourandino.controller.ErrorLogController;
import org.tourandino.view.frame.Main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class CustomerManager extends JDialog {

	private static final long serialVersionUID = 2054968089147933702L;
	private JTable tableCustomers;
	private JTextField txtSearch;
	private CustomerController customerController;
	private JRadioButton rbtnName;
	private JRadioButton rbtnCuit;
	private ErrorLogController errorLogController;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the dialog.
	 */
	public CustomerManager(JFrame parent, boolean modal) {
		super(parent, modal);
		customerController = new CustomerController();
		errorLogController = new ErrorLogController();
		initializeComponents();
	}
	
	private void initializeComponents(){
		setResizable(false);
		setTitle("Clientes");
		getContentPane().setBackground(new Color(255, 204, 51));
		getContentPane().setLayout(null);
		
		JButton btnExit = new JButton("Salir");
		btnExit.setToolTipText("Cierra esta ventana y vuelve al menú principal");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setIcon(new ImageIcon(CustomerManager.class.getResource("/ar/com/tourandino/resources/door.png")));
		btnExit.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnExit.setBounds(676, 528, 100, 25);
		getContentPane().add(btnExit);
		
		JLabel lblSearch = new JLabel("Búsqueda", JLabel.RIGHT);
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
		txtSearch.setBounds(100, 10, 170, 19);
		getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("");
		btnSearch.setToolTipText("Buscar");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearchActionPerformed(e);
			}
		});
		btnSearch.setBounds(282, 7, 25, 25);
		btnSearch.setIcon(new ImageIcon(CustomerManager.class.getResource("/ar/com/tourandino/resources/find.png")));
		getContentPane().add(btnSearch);
		
		JButton btnCreate = new JButton("Nuevo");
		btnCreate.setToolTipText("Ingresa un nuevo cliente al sistema");
		btnCreate.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCreateActionPerformed(e);
			}
		});
		btnCreate.setBounds(524, 67, 120, 25);
		btnCreate.setIcon(new ImageIcon(CustomerManager.class.getResource("/ar/com/tourandino/resources/user_add.png")));
		getContentPane().add(btnCreate);
		
		JButton btnUpdate = new JButton("Editar");
		btnUpdate.setToolTipText("Edita los datos de un cliente");
		btnUpdate.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e);
			}
		});
		btnUpdate.setBounds(656, 67, 120, 25);
		btnUpdate.setIcon(new ImageIcon(CustomerManager.class.getResource("/ar/com/tourandino/resources/user_edit.png")));
		getContentPane().add(btnUpdate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 104, 764, 412);
		getContentPane().add(scrollPane);
		
		tableCustomers = new JTable();
		tableCustomers.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(tableCustomers);
		tableCustomers.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		loadTable(tableCustomers);
		
		JButton btnRead = new JButton("Ver datos");
		btnRead.setToolTipText("Muestra todos los datos de un cliente");
		btnRead.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnReadActionPerformed(e);
			}
		});
		btnRead.setIcon(new ImageIcon(CustomerManager.class.getResource("/ar/com/tourandino/resources/user_go.png")));
		btnRead.setBounds(392, 67, 120, 25);
		getContentPane().add(btnRead);
		
		rbtnCuit = new JRadioButton("CUIT");
		rbtnCuit.setSelected(true);
		buttonGroup.add(rbtnCuit);
		rbtnCuit.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		rbtnCuit.setBackground(new Color(255, 204, 51));
		rbtnCuit.setBounds(66, 37, 100, 23);
		getContentPane().add(rbtnCuit);
		
		rbtnName = new JRadioButton("Nombre");
		buttonGroup.add(rbtnName);
		rbtnName.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		rbtnName.setBackground(new Color(255, 204, 51));
		rbtnName.setBounds(170, 37, 100, 23);
		getContentPane().add(rbtnName);
		setBounds(100, 100, 800, 600);
	}
	
	private void loadTable(JTable table){
		table.setModel(customerController.read());
		table.removeColumn(table.getColumnModel().getColumn(0));
    }
	
	private void loadTableByName(JTable table, String search){
		table.setModel(customerController.readByName(search));
		table.removeColumn(table.getColumnModel().getColumn(0));
	}
	
	private void loadTableByCuit(JTable table, String search){
		table.setModel(customerController.readByCuit(search));
		table.removeColumn(table.getColumnModel().getColumn(0));
	}
	
	private void btnCreateActionPerformed(ActionEvent e){
		CustomerCreator customerCreator = new CustomerCreator(this, true, customerController);
		customerCreator.setLocationRelativeTo(this);
		customerCreator.setVisible(true);
		loadTable(tableCustomers);
	}
	
	private void txtSearchActionPerformed(ActionEvent evt){
		if(!txtSearch.getText().isEmpty()){
			if(rbtnName.isSelected()){
				loadTableByName(tableCustomers, txtSearch.getText());
			}
			if(rbtnCuit.isSelected()){
				loadTableByCuit(tableCustomers, txtSearch.getText());
			}
		}
		else{
			loadTable(tableCustomers);
		}
	}
	
	private void btnSearchActionPerformed(ActionEvent e){
		if(!txtSearch.getText().isEmpty()){
			if(rbtnName.isSelected()){
				loadTableByName(tableCustomers, txtSearch.getText());
			}
			if(rbtnCuit.isSelected()){
				loadTableByCuit(tableCustomers, txtSearch.getText());
			}
		}
		else{
			loadTable(tableCustomers);
		}
	}
	
	private void btnReadActionPerformed(ActionEvent evt){
		try{
			int rowIndex = tableCustomers.getSelectedRow();
			int columnIndex = 0;
			Integer id = Integer.parseInt(String.valueOf(tableCustomers.getModel().getValueAt(rowIndex,columnIndex).toString()));
			CustomerReader customerReader = new CustomerReader(this, true, id);
			customerReader.setLocationRelativeTo(this);
			customerReader.setVisible(true);
		}
		catch(ArrayIndexOutOfBoundsException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
			JOptionPane.showMessageDialog(this, "Seleccione un cliente de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
	}
	
	private void btnUpdateActionPerformed(ActionEvent evt){
		try{
			int rowIndex = tableCustomers.getSelectedRow();
			int columnIndex = 0;
			Integer id = Integer.parseInt(String.valueOf(tableCustomers.getModel().getValueAt(rowIndex,columnIndex).toString()));
			CustomerUpdater customerUpdater = new CustomerUpdater(this, true, id);
			customerUpdater.setLocationRelativeTo(this);
			customerUpdater.setVisible(true);
			if(customerController.getCustomer() != null){
				loadTable(tableCustomers);
			}
		}
		catch(ArrayIndexOutOfBoundsException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
			JOptionPane.showMessageDialog(this, "Seleccione un cliente de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
		catch(NullPointerException e1){
			errorLogController.createErrorLog(new Date(), e1.getMessage(), this.getTitle(), e1.toString());
			JOptionPane.showMessageDialog(this, "Seleccione un cliente de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
	}
}
