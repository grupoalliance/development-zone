package org.tourandino.view.dialog;

import javax.swing.JDialog;
import javax.swing.JTextField;

import org.tourandino.controller.ErrorLogController;
import org.tourandino.controller.UserController;
import org.tourandino.util.DatePicker;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class UserReader extends JDialog {

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
	private UserController userController;
	private JTextField txtRole;
	private JPasswordField txtPassword;
	private ErrorLogController errorLogController;

	/**
	 * Create the dialog.
	 */
	public UserReader(JDialog parent, boolean modal, Integer userId) {
		super(parent, modal);
		this.userController = new UserController();
		this.errorLogController = new ErrorLogController();
		initializeComponents();
		loadUser(userId);
	}
	
	private void initializeComponents(){
		setTitle("Ver Usuario");
		setResizable(false);
		getContentPane().setBackground(new Color(255, 204, 51));
		setBounds(100, 100, 600, 450);
		getContentPane().setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setEditable(false);
		txtUsername.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtUsername.setBounds(193, 46, 280, 19);
		getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtFullName = new JTextField();
		txtFullName.setEditable(false);
		txtFullName.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtFullName.setBounds(193, 108, 280, 19);
		getContentPane().add(txtFullName);
		txtFullName.setColumns(10);
		
		JLabel lblUsername = new JLabel("Usuario", JLabel.RIGHT);
		lblUsername.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblUsername.setBounds(51, 46, 124, 19);
		getContentPane().add(lblUsername);
		
		lblPassword = new JLabel("Clave", JLabel.RIGHT);
		lblPassword.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblPassword.setBounds(51, 77, 124, 19);
		getContentPane().add(lblPassword);
		
		lblFullname = new JLabel("Nombre", JLabel.RIGHT);
		lblFullname.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblFullname.setBounds(51, 108, 124, 19);
		getContentPane().add(lblFullname);
		
		lblBithdate = new JLabel("Fecha nacimiento", JLabel.RIGHT);
		lblBithdate.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblBithdate.setBounds(51, 139, 124, 19);
		getContentPane().add(lblBithdate);
		
		lblAddress = new JLabel("Domicilio", JLabel.RIGHT);
		lblAddress.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblAddress.setBounds(51, 170, 124, 19);
		getContentPane().add(lblAddress);
		
		lblCity = new JLabel("Ciudad", JLabel.RIGHT);
		lblCity.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblCity.setBounds(51, 201, 124, 19);
		getContentPane().add(lblCity);
		
		lblPhone = new JLabel("Teléfono", JLabel.RIGHT);
		lblPhone.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblPhone.setBounds(51, 232, 124, 19);
		getContentPane().add(lblPhone);
		
		lblMobile = new JLabel("Móvil", JLabel.RIGHT);
		lblMobile.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblMobile.setBounds(311, 232, 78, 19);
		getContentPane().add(lblMobile);
		
		lblEmail = new JLabel("E-mail", JLabel.RIGHT);
		lblEmail.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblEmail.setBounds(51, 263, 124, 19);
		getContentPane().add(lblEmail);
		
		lblRole = new JLabel("Rol", JLabel.RIGHT);
		lblRole.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblRole.setBounds(51, 294, 124, 19);
		getContentPane().add(lblRole);
		
		txtBirthdate = new JTextField();
		txtBirthdate.setEditable(false);
		txtBirthdate.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtBirthdate.setBounds(193, 139, 106, 19);
		getContentPane().add(txtBirthdate);
		txtBirthdate.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setEditable(false);
		txtAddress.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtAddress.setBounds(193, 170, 280, 19);
		getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		txtCity = new JTextField();
		txtCity.setEditable(false);
		txtCity.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtCity.setBounds(193, 201, 280, 19);
		getContentPane().add(txtCity);
		txtCity.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setEditable(false);
		txtPhone.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtPhone.setBounds(193, 232, 106, 19);
		getContentPane().add(txtPhone);
		txtPhone.setColumns(10);
		
		txtMobile = new JTextField();
		txtMobile.setEditable(false);
		txtMobile.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtMobile.setBounds(407, 232, 106, 19);
		getContentPane().add(txtMobile);
		txtMobile.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtEmail.setBounds(193, 263, 280, 19);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnExit = new JButton("Salir");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setIcon(new ImageIcon(UserReader.class.getResource("/ar/com/tourandino/resources/door.png")));
		btnExit.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnExit.setBounds(459, 378, 117, 25);
		getContentPane().add(btnExit);
		
		JButton btnDate = new JButton("");
		btnDate.setEnabled(false);
		btnDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDateActionPerformed(e);
			}
		});
		btnDate.setIcon(new ImageIcon(UserReader.class.getResource("/ar/com/tourandino/resources/calendar.png")));
		btnDate.setBounds(311, 136, 25, 25);
		getContentPane().add(btnDate);
		
		txtRole = new JTextField();
		txtRole.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtRole.setEditable(false);
		txtRole.setColumns(10);
		txtRole.setBounds(193, 294, 143, 19);
		getContentPane().add(txtRole);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtPassword.setEditable(false);
		txtPassword.setBounds(193, 77, 143, 19);
		getContentPane().add(txtPassword);
	}
	
	private void btnDateActionPerformed(ActionEvent evt){
		txtBirthdate.setText(new DatePicker(this).getPickedDate());
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
		catch(NullPointerException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
		}
		catch(IllegalArgumentException e1){
			errorLogController.createErrorLog(new Date(), e1.getMessage(), this.getTitle(), e1.toString());
		}
		finally{
			txtRole.setText(items[9].toString());
		}
	}
}
