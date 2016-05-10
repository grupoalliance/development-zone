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
import org.tourandino.controller.PassengerController;
import org.tourandino.view.frame.Main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.JRadioButton;

public class PassengerManager extends JDialog {

	private static final long serialVersionUID = 2054968089147933702L;
	private JTable tablePassengers;
	private JTextField txtSearch;
	private JRadioButton rbtnName;
	private ErrorLogController errorLogController;
	private PassengerController passengerController;

	/**
	 * Create the dialog.
	 */
	public PassengerManager(JFrame parent, boolean modal) {
		super(parent, modal);
		this.errorLogController = new ErrorLogController();
		this.passengerController = new PassengerController();
		initializeComponents();
	}
	
	private void initializeComponents(){
		setResizable(false);
		setTitle("Pasajeros");
		getContentPane().setBackground(new Color(255, 204, 51));
		getContentPane().setLayout(null);
		
		JButton btnExit = new JButton("Salir");
		btnExit.setToolTipText("Cerrar y volver al menú principal");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setIcon(new ImageIcon(PassengerManager.class.getResource("/ar/com/tourandino/resources/door.png")));
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
		btnSearch.setIcon(new ImageIcon(PassengerManager.class.getResource("/ar/com/tourandino/resources/find.png")));
		getContentPane().add(btnSearch);
		
		JButton btnCreate = new JButton("Nuevo");
		btnCreate.setToolTipText("Ingresa un nuevo pasajero");
		btnCreate.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCreateActionPerformed(e);
			}
		});
		btnCreate.setBounds(359, 65, 131, 25);
		btnCreate.setIcon(new ImageIcon(PassengerManager.class.getResource("/ar/com/tourandino/resources/user_add.png")));
		getContentPane().add(btnCreate);
		
		JButton btnUpdate = new JButton("Editar");
		btnUpdate.setToolTipText("Edita los datos de un pasajero");
		btnUpdate.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e);
			}
		});
		btnUpdate.setBounds(645, 65, 131, 25);
		btnUpdate.setIcon(new ImageIcon(PassengerManager.class.getResource("/ar/com/tourandino/resources/user_edit.png")));
		getContentPane().add(btnUpdate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 102, 764, 414);
		getContentPane().add(scrollPane);
		
		tablePassengers = new JTable();
		tablePassengers.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(tablePassengers);
		tablePassengers.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		loadTable(tablePassengers);
		
		JButton btnRead = new JButton("Ver");
		btnRead.setToolTipText("Muestra los datos de un pasajero");
		btnRead.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnReadActionPerformed(e);
			}
		});
		btnRead.setIcon(new ImageIcon(PassengerManager.class.getResource("/ar/com/tourandino/resources/user_go.png")));
		btnRead.setBounds(502, 65, 131, 25);
		getContentPane().add(btnRead);
		
		rbtnName = new JRadioButton("Nombre");
		rbtnName.setEnabled(false);
		rbtnName.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		rbtnName.setBackground(new Color(255, 204, 51));
		rbtnName.setBounds(100, 37, 100, 23);
		getContentPane().add(rbtnName);
		setBounds(100, 100, 800, 600);
	}
	
	private void loadTable(JTable table){
		table.setModel(passengerController.read());
		table.removeColumn(table.getColumnModel().getColumn(0));
    }
	
	private void loadTable(JTable table, String search){
		table.setModel(passengerController.read(search));
		table.removeColumn(table.getColumnModel().getColumn(0));
    }
	
	private void btnCreateActionPerformed(ActionEvent e){
		PassengerCreator passengerCreator = new PassengerCreator(this, true, passengerController);
		passengerCreator.setLocationRelativeTo(this);
		passengerCreator.setVisible(true);
		if(passengerController.getPassenger() != null){
			loadTable(tablePassengers);
		}
	}
	
	private void txtSearchActionPerformed(ActionEvent evt){
		if(!txtSearch.getText().isEmpty()){
			loadTable(tablePassengers, txtSearch.getText());
		}
		else{
			loadTable(tablePassengers);
		}
	}
	
	private void btnSearchActionPerformed(ActionEvent e){
		if(!txtSearch.getText().isEmpty()){
			loadTable(tablePassengers, txtSearch.getText());
		}
		else{
			loadTable(tablePassengers);
		}
	}
	
	private void btnReadActionPerformed(ActionEvent evt){
		try{
			int rowIndex = tablePassengers.getSelectedRow();
			int columnIndex = 0;
			Integer id = Integer.parseInt(String.valueOf(tablePassengers.getModel().getValueAt(rowIndex,columnIndex).toString()));
			PassengerReader passengerReader = new PassengerReader(this, true, id);
			passengerReader.setLocationRelativeTo(this);
			passengerReader.setVisible(true);
		}
		catch(ArrayIndexOutOfBoundsException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
			JOptionPane.showMessageDialog(this, "Seleccione un pasajero de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
		catch(NullPointerException e1){
			errorLogController.createErrorLog(new Date(), e1.getMessage(), this.getTitle(), e1.toString());
			JOptionPane.showMessageDialog(this, "Seleccione un pasajero de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
	}
	
	private void btnUpdateActionPerformed(ActionEvent evt){
		try{
			int rowIndex = tablePassengers.getSelectedRow();
			int columnIndex = 0;
			Integer id = Integer.parseInt(String.valueOf(tablePassengers.getModel().getValueAt(rowIndex,columnIndex).toString()));
			PassengerUpdater passengerUpdater = new PassengerUpdater(this, true, id);
			passengerUpdater.setLocationRelativeTo(this);
			passengerUpdater.setVisible(true);
			if(passengerController.getPassenger() != null){
				loadTable(tablePassengers);
			}
			}
		catch(ArrayIndexOutOfBoundsException e){
				errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
				JOptionPane.showMessageDialog(this, "Seleccione un pasajero de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
		catch(NullPointerException e1){
			errorLogController.createErrorLog(new Date(), e1.getMessage(), this.getTitle(), e1.toString());
			JOptionPane.showMessageDialog(this, "Seleccione un pasajero de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
	}
}
