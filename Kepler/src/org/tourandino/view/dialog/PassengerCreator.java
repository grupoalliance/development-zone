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
import org.tourandino.controller.PassengerController;
import org.tourandino.util.DatePicker;
import org.tourandino.view.frame.Main;

public class PassengerCreator extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -214349194818108970L;
	private JTextField txtFullName;
	private JLabel lblFullname;
	private JLabel lblBithdate;
	private JLabel lblAddress;
	private JLabel lblCity;
	private JLabel lblPhone1;
	private JLabel lblMobile1;
	private JLabel lblEmail;
	private JTextField txtBirthdate;
	private JTextField txtAddress;
	private JTextField txtCity;
	private JTextField txtPhone1;
	private JTextField txtMobile1;
	private JTextField txtEmail;
	private ErrorLogController errorLogController;
	private PassengerController passengerController;
	private JTextField txtPhone2;
	private JTextField txtMobile2;

	/**
	 * Create the dialog.
	 */
	public PassengerCreator(JDialog parent, boolean modal, PassengerController passengerController) {
		super(parent, modal);
		this.passengerController = passengerController;
		this.errorLogController = new ErrorLogController();
		initializeComponents();
	}
	
	private void initializeComponents(){
		setTitle("Nuevo Pasajero");
		setResizable(false);
		getContentPane().setBackground(new Color(255, 204, 51));
		setBounds(100, 100, 600, 450);
		getContentPane().setLayout(null);
		
		txtFullName = new JTextField();
		txtFullName.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtFullName.setBounds(188, 78, 280, 19);
		getContentPane().add(txtFullName);
		txtFullName.setColumns(10);
		
		lblFullname = new JLabel("Nombre", JLabel.RIGHT);
		lblFullname.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblFullname.setBounds(46, 78, 124, 19);
		getContentPane().add(lblFullname);
		
		lblBithdate = new JLabel("Fecha nacimiento", JLabel.RIGHT);
		lblBithdate.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblBithdate.setBounds(46, 109, 124, 19);
		getContentPane().add(lblBithdate);
		
		lblAddress = new JLabel("Domicilio", JLabel.RIGHT);
		lblAddress.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblAddress.setBounds(46, 143, 124, 19);
		getContentPane().add(lblAddress);
		
		lblCity = new JLabel("Ciudad", JLabel.RIGHT);
		lblCity.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblCity.setBounds(46, 174, 124, 19);
		getContentPane().add(lblCity);
		
		lblPhone1 = new JLabel("Teléfono", JLabel.RIGHT);
		lblPhone1.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblPhone1.setBounds(46, 205, 124, 19);
		getContentPane().add(lblPhone1);
		
		lblMobile1 = new JLabel("Móvil", JLabel.RIGHT);
		lblMobile1.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblMobile1.setBounds(46, 236, 124, 19);
		getContentPane().add(lblMobile1);
		
		lblEmail = new JLabel("E-mail", JLabel.RIGHT);
		lblEmail.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblEmail.setBounds(46, 267, 124, 19);
		getContentPane().add(lblEmail);
		
		txtBirthdate = new JTextField();
		txtBirthdate.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtBirthdate.setBounds(188, 109, 106, 19);
		getContentPane().add(txtBirthdate);
		txtBirthdate.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtAddress.setBounds(188, 143, 280, 19);
		getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		txtCity = new JTextField();
		txtCity.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtCity.setBounds(188, 174, 280, 19);
		getContentPane().add(txtCity);
		txtCity.setColumns(10);
		
		txtPhone1 = new JTextField();
		txtPhone1.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtPhone1.setBounds(188, 205, 106, 19);
		getContentPane().add(txtPhone1);
		txtPhone1.setColumns(10);
		
		txtMobile1 = new JTextField();
		txtMobile1.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtMobile1.setBounds(188, 236, 106, 19);
		getContentPane().add(txtMobile1);
		txtMobile1.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtEmail.setBounds(188, 267, 280, 19);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnAdd = new JButton("Aceptar");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddActionPerformed(e);
			}
		});
		btnAdd.setIcon(new ImageIcon(PassengerCreator.class.getResource("/ar/com/tourandino/resources/accept.png")));
		btnAdd.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnAdd.setBounds(459, 378, 117, 25);
		getContentPane().add(btnAdd);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setIcon(new ImageIcon(PassengerCreator.class.getResource("/ar/com/tourandino/resources/cancel.png")));
		btnCancel.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnCancel.setBounds(330, 378, 117, 25);
		getContentPane().add(btnCancel);
		
		JButton btnDate = new JButton("");
		btnDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDateActionPerformed(e);
			}
		});
		btnDate.setIcon(new ImageIcon(PassengerCreator.class.getResource("/ar/com/tourandino/resources/calendar.png")));
		btnDate.setBounds(306, 106, 25, 25);
		getContentPane().add(btnDate);
		
		JLabel lblPhone2 = new JLabel("Teléfono alt.", SwingConstants.RIGHT);
		lblPhone2.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblPhone2.setBounds(306, 205, 78, 19);
		getContentPane().add(lblPhone2);
		
		txtPhone2 = new JTextField();
		txtPhone2.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtPhone2.setColumns(10);
		txtPhone2.setBounds(402, 205, 106, 19);
		getContentPane().add(txtPhone2);
		
		JLabel lblMobile2 = new JLabel("Móvil alt.", SwingConstants.RIGHT);
		lblMobile2.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblMobile2.setBounds(306, 236, 78, 19);
		getContentPane().add(lblMobile2);
		
		txtMobile2 = new JTextField();
		txtMobile2.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtMobile2.setColumns(10);
		txtMobile2.setBounds(402, 236, 106, 19);
		getContentPane().add(txtMobile2);
	}
	
	private void btnDateActionPerformed(ActionEvent e){
		txtBirthdate.setText(new DatePicker(this).getPickedDate());
	}
	
	private void btnAddActionPerformed(ActionEvent evt){
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
					if(passengerController.create(txtFullName.getText(), date, txtAddress.getText(), txtCity.getText(), 
							txtPhone1.getText(), txtPhone2.getText(), txtMobile1.getText(), txtMobile2.getText(), txtEmail.getText()) > 0){
						JOptionPane.showMessageDialog(this, "Pasajero creado exitosamente", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/information.png")));
						this.dispose();
					}
					else{
						JOptionPane.showMessageDialog(this, "El pasajero no se ha podido crear, intente nuevamente o contacte al administrador", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
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
	
}
