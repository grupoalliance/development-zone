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
import org.tourandino.controller.IssuerController;
import org.tourandino.view.frame.Main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class IssuerManager extends JDialog {

	private static final long serialVersionUID = 2054968089147933702L;
	private JTable tableIssuers;
	private JTextField txtSearch;
	private JRadioButton rbtnName;
	private JRadioButton rbtnCuit;
	private ErrorLogController errorLogController;
	private IssuerController issuerController;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the dialog.
	 */
	public IssuerManager(JFrame parent, boolean modal) {
		super(parent, modal);
		this.errorLogController = new ErrorLogController();
		this.issuerController = new IssuerController();
		initializeComponents();
	}
	
	private void initializeComponents(){
		setResizable(false);
		setTitle("Operadores");
		getContentPane().setBackground(new Color(255, 204, 51));
		getContentPane().setLayout(null);
		
		JButton btnExit = new JButton("Salir");
		btnExit.setToolTipText("Cierra esta ventana y vuelve al menú principal");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setIcon(new ImageIcon(IssuerManager.class.getResource("/ar/com/tourandino/resources/door.png")));
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
		btnSearch.setIcon(new ImageIcon(IssuerManager.class.getResource("/ar/com/tourandino/resources/find.png")));
		getContentPane().add(btnSearch);
		
		JButton btnCreate = new JButton("Nuevo");
		btnCreate.setToolTipText("Ingresa un operador cliente al sistema");
		btnCreate.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCreateActionPerformed(e);
			}
		});
		btnCreate.setBounds(524, 67, 120, 25);
		btnCreate.setIcon(new ImageIcon(IssuerManager.class.getResource("/ar/com/tourandino/resources/user_add.png")));
		getContentPane().add(btnCreate);
		
		JButton btnUpdate = new JButton("Editar");
		btnUpdate.setToolTipText("Edita los datos de un operador");
		btnUpdate.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e);
			}
		});
		btnUpdate.setBounds(656, 67, 120, 25);
		btnUpdate.setIcon(new ImageIcon(IssuerManager.class.getResource("/ar/com/tourandino/resources/user_edit.png")));
		getContentPane().add(btnUpdate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 104, 764, 412);
		getContentPane().add(scrollPane);
		
		tableIssuers = new JTable();
		tableIssuers.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(tableIssuers);
		tableIssuers.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		loadTable(tableIssuers);
		
		JButton btnRead = new JButton("Ver datos");
		btnRead.setToolTipText("Muestra todos los datos de un operador");
		btnRead.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnReadActionPerformed(e);
			}
		});
		btnRead.setIcon(new ImageIcon(IssuerManager.class.getResource("/ar/com/tourandino/resources/user_go.png")));
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
		table.setModel(issuerController.read());
		table.removeColumn(table.getColumnModel().getColumn(0));
    }
	
	private void loadTableByName(JTable table, String search){
		table.setModel(issuerController.readByName(search));
		table.removeColumn(table.getColumnModel().getColumn(0));
	}
	
	private void loadTableByCuit(JTable table, String search){
		table.setModel(issuerController.readByCuit(search));
		table.removeColumn(table.getColumnModel().getColumn(0));
	}
	
	private void btnCreateActionPerformed(ActionEvent e){
		IssuerCreator issuerCreator = new IssuerCreator(this, true);
		issuerCreator.setLocationRelativeTo(this);
		issuerCreator.setVisible(true);
		if(issuerController.getIssuer() != null){
			loadTable(tableIssuers);
		}
	}
	
	private void txtSearchActionPerformed(ActionEvent evt){
		if(!txtSearch.getText().isEmpty()){
			if(rbtnName.isSelected()){
				loadTableByName(tableIssuers, txtSearch.getText());
			}
			if(rbtnCuit.isSelected()){
				loadTableByCuit(tableIssuers, txtSearch.getText());
			}
		}
		else{
			loadTable(tableIssuers);
		}
	}
	
	private void btnSearchActionPerformed(ActionEvent e){
		if(!txtSearch.getText().isEmpty()){
			if(rbtnName.isSelected()){
				loadTableByName(tableIssuers, txtSearch.getText());
			}
			if(rbtnCuit.isSelected()){
				loadTableByCuit(tableIssuers, txtSearch.getText());
			}
		}
		else{
			loadTable(tableIssuers);
		}
	}
	
	private void btnReadActionPerformed(ActionEvent evt){
		try{
			int rowIndex = tableIssuers.getSelectedRow();
			int columnIndex = 0;
			Integer id = Integer.parseInt(String.valueOf(tableIssuers.getModel().getValueAt(rowIndex,columnIndex).toString()));
			IssuerReader issuerReader = new IssuerReader(this, true, issuerController, id);
			issuerReader.setLocationRelativeTo(this);
			issuerReader.setVisible(true);
		}
		catch(ArrayIndexOutOfBoundsException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
			JOptionPane.showMessageDialog(this, "Seleccione un operador de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
	}
	
	private void btnUpdateActionPerformed(ActionEvent evt){
		try{
			int rowIndex = tableIssuers.getSelectedRow();
			int columnIndex = 0;
			Integer id = Integer.parseInt(String.valueOf(tableIssuers.getModel().getValueAt(rowIndex,columnIndex).toString()));
			IssuerUpdater issuerUpdater = new IssuerUpdater(this, true, issuerController, id);
			issuerUpdater.setLocationRelativeTo(this);
			issuerUpdater.setVisible(true);
			if(issuerController.getIssuer() != null){
				loadTable(tableIssuers);
			}
		}
		catch(ArrayIndexOutOfBoundsException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
			JOptionPane.showMessageDialog(this, "Seleccione un operador de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
		catch(NullPointerException e1){
			errorLogController.createErrorLog(new Date(), e1.getMessage(), this.getTitle(), e1.toString());
			JOptionPane.showMessageDialog(this, "Seleccione un operador de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
	}
}
