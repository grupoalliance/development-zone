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
import org.tourandino.controller.UserController;
import org.tourandino.view.frame.Main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class UserManager extends JDialog {

	private static final long serialVersionUID = 2054968089147933702L;
	private JTable tableUsers;
	private JTextField txtSearch;
	private UserController userController;
	private JRadioButton rbtnName;
	private JRadioButton rbtnUser;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private ErrorLogController errorLogController;

	/**
	 * Create the dialog.
	 */
	public UserManager(JFrame parent, boolean modal) {
		super(parent, modal);
		this.userController = new UserController();
		this.errorLogController = new ErrorLogController();
		initializeComponents();
	}
	
	private void initializeComponents(){
		setResizable(false);
		setTitle("Usuarios");
		getContentPane().setBackground(new Color(255, 204, 51));
		getContentPane().setLayout(null);
		
		JButton btnExit = new JButton("Salir");
		btnExit.setToolTipText("Cierra esta ventana y vuelve al menú principal");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setIcon(new ImageIcon(UserManager.class.getResource("/ar/com/tourandino/resources/door.png")));
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
		btnSearch.setIcon(new ImageIcon(UserManager.class.getResource("/ar/com/tourandino/resources/find.png")));
		getContentPane().add(btnSearch);
		
		JButton btnCreate = new JButton("Nuevo");
		btnCreate.setToolTipText("Muestra los datos de un usuario");
		btnCreate.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCreateActionPerformed(e);
			}
		});
		btnCreate.setBounds(359, 60, 131, 25);
		btnCreate.setIcon(new ImageIcon(UserManager.class.getResource("/ar/com/tourandino/resources/user_add.png")));
		getContentPane().add(btnCreate);
		
		JButton btnUpdate = new JButton("Editar");
		btnUpdate.setToolTipText("Edita los datos de un usuario");
		btnUpdate.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e);
			}
		});
		btnUpdate.setBounds(645, 60, 131, 25);
		btnUpdate.setIcon(new ImageIcon(UserManager.class.getResource("/ar/com/tourandino/resources/user_edit.png")));
		getContentPane().add(btnUpdate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 97, 764, 419);
		getContentPane().add(scrollPane);
		
		tableUsers = new JTable();
		loadTable(tableUsers);
		tableUsers.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(tableUsers);
		tableUsers.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		
		JButton btnRead = new JButton("Ver");
		btnRead.setToolTipText("");
		btnRead.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnReadActionPerformed(e);
			}
		});
		btnRead.setIcon(new ImageIcon(UserManager.class.getResource("/ar/com/tourandino/resources/user_go.png")));
		btnRead.setBounds(502, 60, 131, 25);
		getContentPane().add(btnRead);
		
		rbtnUser = new JRadioButton("Usuario");
		rbtnUser.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		buttonGroup.add(rbtnUser);
		rbtnUser.setBackground(new Color(255, 204, 51));
		rbtnUser.setBounds(66, 37, 100, 23);
		rbtnUser.setSelected(true);
		getContentPane().add(rbtnUser);
		
		rbtnName = new JRadioButton("Nombre");
		rbtnName.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		buttonGroup.add(rbtnName);
		rbtnName.setBackground(new Color(255, 204, 51));
		rbtnName.setBounds(170, 37, 100, 23);
		getContentPane().add(rbtnName);
		setBounds(100, 100, 800, 600);
	}
	
	private void loadTable(JTable table){
		table.setModel(userController.loadUserTable());
		table.removeColumn(table.getColumnModel().getColumn(0));
    }
	
	private void loadTableUsername(JTable table, String search){
		table.setModel(userController.readByUsername(search));
		table.removeColumn(table.getColumnModel().getColumn(0));
	}
	
	private void loadTableFullname(JTable table, String search){
		table.setModel(userController.readByFullname(search));
		table.removeColumn(table.getColumnModel().getColumn(0));
	}
	
	private void btnCreateActionPerformed(ActionEvent evt){
		UserCreator userCreator = new UserCreator(this, true);
		userCreator.setLocationRelativeTo(this);
		userCreator.setVisible(true);
		loadTable(tableUsers);
	}
	
	private void txtSearchActionPerformed(ActionEvent evt){
		if(!txtSearch.getText().isEmpty()){
			if(rbtnUser.isSelected()){
				loadTableUsername(tableUsers, txtSearch.getText());
			}
			else{
				loadTableFullname(tableUsers, txtSearch.getText());
			}
		}
		else{
			loadTable(tableUsers);
		}
	}
	
	private void btnSearchActionPerformed(ActionEvent evt){
		if(!txtSearch.getText().isEmpty()){
			if(rbtnUser.isSelected()){
				loadTableUsername(tableUsers, txtSearch.getText());
			}
			else{
				loadTableFullname(tableUsers, txtSearch.getText());
			}
		}
		else{
			loadTable(tableUsers);
		}
	}
	
	private void btnReadActionPerformed(ActionEvent evt){
		try{
			int rowIndex = tableUsers.getSelectedRow();
			int columnIndex = 0;
			Integer id = Integer.parseInt(String.valueOf(tableUsers.getModel().getValueAt(rowIndex,columnIndex).toString()));
			UserReader userReader = new UserReader(this, true, id);
			userReader.setLocationRelativeTo(this);
			userReader.setVisible(true);
		}
		catch(ArrayIndexOutOfBoundsException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
			JOptionPane.showMessageDialog(this, "Seleccione un usuario de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
		catch(NullPointerException e1){
			errorLogController.createErrorLog(new Date(), e1.getMessage(), this.getTitle(), e1.toString());
			JOptionPane.showMessageDialog(this, "Seleccione un usuario de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
	}
	
	private void btnUpdateActionPerformed(ActionEvent evt){
		try{
			int rowIndex = tableUsers.getSelectedRow();
			int columnIndex = 0;
			Integer id = Integer.parseInt(String.valueOf(tableUsers.getModel().getValueAt(rowIndex,columnIndex).toString()));
			UserUpdater userUpdater = new UserUpdater(this, true, userController, id);
			userUpdater.setLocationRelativeTo(this);
			userUpdater.setVisible(true);
			loadTable(tableUsers);
			}
		catch(ArrayIndexOutOfBoundsException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.getCause().toString());
			JOptionPane.showMessageDialog(this, "Seleccione un usuario de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
		catch(NullPointerException e1){
			errorLogController.createErrorLog(new Date(), e1.getMessage(), this.getTitle(), e1.getCause().toString());
			JOptionPane.showMessageDialog(this, "Seleccione un usuario de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
	}
}
