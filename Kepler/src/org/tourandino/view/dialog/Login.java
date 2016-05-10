package org.tourandino.view.dialog;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import org.einstein.controller.LoginController;
import org.tourandino.view.frame.Main;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JDialog {

    private static final long serialVersionUID = 1L;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	private boolean succeeded;
	private LoginController loginController;

	/**
	 * Create the dialog.
	 */
	public Login(JFrame parent, boolean modal, LoginController loginController) {
		super(parent, modal);
		initializeComponents();
		this.loginController = loginController;
		loginController = new LoginController();
	}
	
	private void initializeComponents(){
		setTitle("Ingreso al Sistema");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(255, 204, 51));
		getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario", JLabel.RIGHT);
		lblUsuario.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblUsuario.setBounds(36, 54, 70, 15);
		getContentPane().add(lblUsuario);
		
		JLabel lblClave = new JLabel("Clave", JLabel.RIGHT);
		lblClave.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblClave.setBounds(36, 85, 70, 15);
		getContentPane().add(lblClave);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtUsername.setBounds(114, 52, 118, 19);
		getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtPassword.setBounds(114, 83, 118, 19);
		getContentPane().add(txtPassword);
		
		btnLogin = new JButton("Aceptar");
		btnLogin.setIcon(new ImageIcon(Login.class.getResource("/ar/com/tourandino/resources/accept.png")));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoginActionPerformed(e);
			}
		});
		btnLogin.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnLogin.setBounds(159, 153, 117, 25);
		getContentPane().add(btnLogin);
		setResizable(false);
		setBounds(100, 100, 300, 225);
		SwingUtilities.getRootPane(btnLogin).setDefaultButton(btnLogin);
	}
	
	private void btnLoginActionPerformed(ActionEvent e){
		String username = txtUsername.getText();
		String password = String.valueOf(txtPassword.getPassword());
		if(!username.isEmpty()){
			if(!password.isEmpty()){
				if(loginController.createSession(username, password) > 0){
					this.succeeded = true;
					this.dispose();
				}
				else{
					JOptionPane.showMessageDialog(this, "Usuario y/o clave incorrecta", "Login", JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
					this.succeeded = false;
				}
			}
			else{
				JOptionPane.showMessageDialog(this, "Ingrese su clave", "Login", JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
				this.succeeded = false;
			}
		}
		else{
			JOptionPane.showMessageDialog(this, "Ingrese el usuario","Login",JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
			this.succeeded = false;
		}
	}
	
	public boolean isSucceeded(){
		return this.succeeded;
	}
	
}

