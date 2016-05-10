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
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class UserUpdater extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -214349194818108970L;
	private JTextField txtUsername;
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
	private RoleController roleController;
	private UserController userController;
	private ErrorLogController errorLogController;
	private JPasswordField txtPassword;
	private JComboBox cmbRoles;

	/**
	 * Create the dialog.
	 */
	public UserUpdater(JDialog parent, boolean modal, UserController userController, Integer id) {
		super(parent, modal);
		this.userController = userController;
		this.roleController = new RoleController();
		this.errorLogController = new ErrorLogController();
		initializeComponents();
		loadUser(id);
	}
	
	private void initializeComponents(){
		setTitle("Editor de Usuario");
		setResizable(false);
		getContentPane().setBackground(new Color(255, 204, 51));
		setBounds(100, 100, 600, 450);
		getContentPane().setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setEditable(false);
		txtUsername.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtUsername.setBounds(195, 54, 280, 19);
		getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtFullName = new JTextField();
		txtFullName.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtFullName.setBounds(195, 116, 280, 19);
		getContentPane().add(txtFullName);
		txtFullName.setColumns(10);
		
		JLabel lblUsername = new JLabel("Usuario", JLabel.RIGHT);
		lblUsername.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblUsername.setBounds(53, 54, 124, 19);
		getContentPane().add(lblUsername);
		
		lblPassword = new JLabel("Clave", JLabel.RIGHT);
		lblPassword.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblPassword.setBounds(53, 85, 124, 19);
		getContentPane().add(lblPassword);
		
		lblFullname = new JLabel("Nombre", JLabel.RIGHT);
		lblFullname.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblFullname.setBounds(53, 116, 124, 19);
		getContentPane().add(lblFullname);
		
		lblBithdate = new JLabel("Fecha nacimiento", JLabel.RIGHT);
		lblBithdate.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblBithdate.setBounds(53, 147, 124, 19);
		getContentPane().add(lblBithdate);
		
		lblAddress = new JLabel("Domicilio", JLabel.RIGHT);
		lblAddress.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblAddress.setBounds(53, 178, 124, 19);
		getContentPane().add(lblAddress);
		
		lblCity = new JLabel("Ciudad", JLabel.RIGHT);
		lblCity.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblCity.setBounds(53, 209, 124, 19);
		getContentPane().add(lblCity);
		
		lblPhone = new JLabel("Teléfono", JLabel.RIGHT);
		lblPhone.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblPhone.setBounds(53, 240, 124, 19);
		getContentPane().add(lblPhone);
		
		lblMobile = new JLabel("Móvil", JLabel.RIGHT);
		lblMobile.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblMobile.setBounds(313, 240, 78, 19);
		getContentPane().add(lblMobile);
		
		lblEmail = new JLabel("E-mail", JLabel.RIGHT);
		lblEmail.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblEmail.setBounds(53, 271, 124, 19);
		getContentPane().add(lblEmail);
		
		lblRole = new JLabel("Rol", JLabel.RIGHT);
		lblRole.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblRole.setBounds(53, 302, 124, 19);
		getContentPane().add(lblRole);
		
		txtBirthdate = new JTextField();
		txtBirthdate.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtBirthdate.setBounds(195, 147, 106, 19);
		getContentPane().add(txtBirthdate);
		txtBirthdate.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtAddress.setBounds(195, 178, 280, 19);
		getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		txtCity = new JTextField();
		txtCity.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtCity.setBounds(195, 209, 280, 19);
		getContentPane().add(txtCity);
		txtCity.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtPhone.setBounds(195, 240, 106, 19);
		getContentPane().add(txtPhone);
		txtPhone.setColumns(10);
		
		txtMobile = new JTextField();
		txtMobile.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtMobile.setBounds(409, 240, 106, 19);
		getContentPane().add(txtMobile);
		txtMobile.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtEmail.setBounds(195, 271, 280, 19);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnAccept = new JButton("Aceptar");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditActionPerformed(e);
			}
		});
		btnAccept.setIcon(new ImageIcon(UserUpdater.class.getResource("/ar/com/tourandino/resources/accept.png")));
		btnAccept.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnAccept.setBounds(459, 378, 117, 25);
		getContentPane().add(btnAccept);
		
		JButton btnDate = new JButton("");
		btnDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDateActionPerformed(e);
			}
		});
		btnDate.setIcon(new ImageIcon(UserUpdater.class.getResource("/ar/com/tourandino/resources/calendar.png")));
		btnDate.setBounds(313, 144, 25, 25);
		getContentPane().add(btnDate);
		
		txtPassword = new JPasswordField();
		txtPassword.setEditable(false);
		txtPassword.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtPassword.setBounds(195, 85, 143, 19);
		getContentPane().add(txtPassword);
		
		cmbRoles = new JComboBox();
		cmbRoles.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		cmbRoles.setBounds(195, 302, 143, 19);
		getContentPane().add(cmbRoles);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setIcon(new ImageIcon(UserUpdater.class.getResource("/ar/com/tourandino/resources/cancel.png")));
		btnCancel.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnCancel.setBounds(330, 378, 117, 25);
		getContentPane().add(btnCancel);
	}
	
	private void btnDateActionPerformed(ActionEvent evt){
		txtBirthdate.setText(new DatePicker(this).getPickedDate());
	}
	
	private void loadComboBox(JComboBox comboBox, Object role){
		comboBox.setModel(roleController.read(role));
	}
	
	private void loadUser(Integer id){
		Object[] items = userController.readUserId(id);
		txtUsername.setText(items[0].toString());
		txtPassword.setText(items[1].toString());
		txtFullName.setText(items[2].toString());
		try{
			SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
			txtBirthdate.setText(date.format(items[3]));
			txtAddress.setText(items[4].toString());
			txtCity.setText(items[5].toString());
			txtPhone.setText(items[6].toString());
			txtMobile.setText(items[7].toString());
			txtEmail.setText(items[8].toString());
		}
		catch(NullPointerException ex){
			errorLogController.createErrorLog(new Date(), ex.getMessage(), this.getTitle(), ex.toString());
		}
		catch(IllegalArgumentException ex){
			errorLogController.createErrorLog(new Date(), ex.getMessage(), this.getTitle(), ex.toString());
		}
		finally{
			loadComboBox(cmbRoles, items[9]);
		}
	}
	
	private void btnEditActionPerformed(ActionEvent evt){
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
					userController.update(cmbRoles.getSelectedItem(), txtFullName.getText(), date, 
							txtAddress.getText(), txtCity.getText(), txtPhone.getText(), txtMobile.getText(), 
							txtEmail.getText());
					JOptionPane.showMessageDialog(this, "Usuario modificado exitosamente", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/information.png")));
					this.dispose();
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
}
