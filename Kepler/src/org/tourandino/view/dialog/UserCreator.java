package org.tourandino.view.dialog;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.tourandino.controller.ErrorLogController;
import org.tourandino.controller.RoleController;
import org.tourandino.controller.UserController;
import org.tourandino.util.DatePicker;
import org.tourandino.view.frame.Main;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class UserCreator extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -214349194818108970L;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtFullName;
	private JLabel lblPassword;
	private JLabel lblFullname;
	private JLabel lblBithdate;
	private JLabel lblAddress;
	private JLabel lblCity;
	private JLabel lblPhone;
	private JLabel lblMobile;
	private JLabel lblEmail;
	private JLabel lblRole;
	private JTextField txtBirthdate;
	private JTextField txtAddress;
	private JTextField txtCity;
	private JTextField txtPhone;
	private JTextField txtMobile;
	private JTextField txtEmail;
	private JComboBox cmbRoles;
	private RoleController roleController;
	private UserController userController;
	private ErrorLogController errorLogController;

	/**
	 * Create the dialog.
	 */
	public UserCreator(JDialog parent, boolean modal) {
		super(parent, modal);
		this.roleController = new RoleController();
		this.userController = new UserController();
		this.errorLogController = new ErrorLogController();
		initializeComponents();
	}
	
	private void initializeComponents(){
		setTitle("Nuevo Usuario");
		setResizable(false);
		getContentPane().setBackground(new Color(255, 204, 51));
		setBounds(100, 100, 600, 450);
		getContentPane().setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtUsername.setBounds(191, 55, 280, 19);
		getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtPassword.setBounds(191, 86, 143, 19);
		getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		txtFullName = new JTextField();
		txtFullName.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtFullName.setBounds(191, 117, 280, 19);
		getContentPane().add(txtFullName);
		txtFullName.setColumns(10);
		
		JLabel lblUsername = new JLabel("Usuario", JLabel.RIGHT);
		lblUsername.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblUsername.setBounds(49, 55, 124, 19);
		getContentPane().add(lblUsername);
		
		lblPassword = new JLabel("Clave", JLabel.RIGHT);
		lblPassword.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblPassword.setBounds(49, 86, 124, 19);
		getContentPane().add(lblPassword);
		
		lblFullname = new JLabel("Nombre", JLabel.RIGHT);
		lblFullname.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblFullname.setBounds(49, 117, 124, 19);
		getContentPane().add(lblFullname);
		
		lblBithdate = new JLabel("Fecha nacimiento", JLabel.RIGHT);
		lblBithdate.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblBithdate.setBounds(49, 148, 124, 19);
		getContentPane().add(lblBithdate);
		
		lblAddress = new JLabel("Domicilio", JLabel.RIGHT);
		lblAddress.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblAddress.setBounds(49, 179, 124, 19);
		getContentPane().add(lblAddress);
		
		lblCity = new JLabel("Ciudad", JLabel.RIGHT);
		lblCity.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblCity.setBounds(49, 210, 124, 19);
		getContentPane().add(lblCity);
		
		lblPhone = new JLabel("Teléfono", JLabel.RIGHT);
		lblPhone.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblPhone.setBounds(49, 241, 124, 19);
		getContentPane().add(lblPhone);
		
		lblMobile = new JLabel("Móvil", JLabel.RIGHT);
		lblMobile.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblMobile.setBounds(309, 241, 76, 19);
		getContentPane().add(lblMobile);
		
		lblEmail = new JLabel("E-mail", JLabel.RIGHT);
		lblEmail.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblEmail.setBounds(49, 272, 124, 19);
		getContentPane().add(lblEmail);
		
		lblRole = new JLabel("Rol", JLabel.RIGHT);
		lblRole.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblRole.setBounds(49, 303, 124, 19);
		getContentPane().add(lblRole);
		
		txtBirthdate = new JTextField();
		txtBirthdate.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtBirthdate.setBounds(191, 148, 106, 19);
		getContentPane().add(txtBirthdate);
		txtBirthdate.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtAddress.setBounds(191, 179, 280, 19);
		getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		txtCity = new JTextField();
		txtCity.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtCity.setBounds(191, 210, 280, 19);
		getContentPane().add(txtCity);
		txtCity.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtPhone.setBounds(191, 241, 106, 19);
		getContentPane().add(txtPhone);
		txtPhone.setColumns(10);
		
		txtMobile = new JTextField();
		txtMobile.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtMobile.setBounds(403, 241, 106, 19);
		getContentPane().add(txtMobile);
		txtMobile.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtEmail.setBounds(191, 272, 280, 19);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		cmbRoles = new JComboBox();
		cmbRoles.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		cmbRoles.setBounds(191, 303, 143, 19);
		getContentPane().add(cmbRoles);
		loadComboBox(cmbRoles);
		
		JButton btnAdd = new JButton("Aceptar");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddActionPerformed(e);
			}
		});
		btnAdd.setIcon(new ImageIcon(UserCreator.class.getResource("/ar/com/tourandino/resources/accept.png")));
		btnAdd.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnAdd.setBounds(459, 378, 117, 25);
		getContentPane().add(btnAdd);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setIcon(new ImageIcon(UserCreator.class.getResource("/ar/com/tourandino/resources/cancel.png")));
		btnCancel.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnCancel.setBounds(330, 378, 117, 25);
		getContentPane().add(btnCancel);
		
		JButton btnDate = new JButton("");
		btnDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDateActionPerformed(e);
			}
		});
		btnDate.setIcon(new ImageIcon(UserCreator.class.getResource("/ar/com/tourandino/resources/calendar.png")));
		btnDate.setBounds(309, 145, 25, 25);
		getContentPane().add(btnDate);
	}
	
	private void loadComboBox(JComboBox comboBox){
		comboBox.setModel(roleController.read());
	}
	
	private void btnDateActionPerformed(ActionEvent e){
		txtBirthdate.setText(new DatePicker(this).getPickedDate());
	}
	
	private void btnAddActionPerformed(ActionEvent evt){
		if(!txtUsername.getText().isEmpty()){
			if(userController.validateUsername(txtUsername.getText())){
				if(!txtPassword.getText().isEmpty()){
					if(!txtFullName.getText().isEmpty()){
						if(!txtBirthdate.getText().isEmpty()){
							SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy"); 
							Date date;
							try {
								date = dt.parse(txtBirthdate.getText());
							} catch (ParseException e) {
								errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
								date = null;
							}
							if(date != null){
							if(userController.create(cmbRoles.getSelectedItem(), txtUsername.getText(), txtPassword.getText(), 
									txtFullName.getText(), date, txtAddress.getText(), txtCity.getText(), 
									txtPhone.getText(), txtMobile.getText(), txtEmail.getText()) > 0){
								JOptionPane.showMessageDialog(this, "Usuario creado exitosamente", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/information.png")));
								this.dispose();
							}
							else{
								JOptionPane.showMessageDialog(this, "El usuario no se ha podido crear, intente nuevamente o contacte al administrador", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
							}
							}
							else{
								JOptionPane.showMessageDialog(this, "Ha habido un problema con la fecha seleccionada", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
							}
					
						}
						else{
							JOptionPane.showMessageDialog(this, "Ingrese la fecha de nacimiento", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
						}
				
					}
					else{
						JOptionPane.showMessageDialog(this, "Ingrese el nombre", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
					}
								
				}
				else{
					JOptionPane.showMessageDialog(this, "Ingrese la clave", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
				}
			}
			else{
				JOptionPane.showMessageDialog(this, "El usuario ya existe", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
			}
		}
		else{
			JOptionPane.showMessageDialog(this, "Ingrese el nombre de usuario", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
	}
}
