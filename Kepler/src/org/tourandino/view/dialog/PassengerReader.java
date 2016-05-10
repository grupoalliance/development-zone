package org.tourandino.view.dialog;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import org.tourandino.controller.ErrorLogController;
import org.tourandino.controller.PassengerController;
import org.tourandino.util.DatePicker;

public class PassengerReader extends JDialog {

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
	public PassengerReader(JDialog parent, boolean modal, Integer id) {
		super(parent, modal);
		passengerController = new PassengerController();
		errorLogController = new ErrorLogController();
		setTitle("Ver Pasajero");
		setResizable(false);
		getContentPane().setBackground(new Color(255, 204, 51));
		setBounds(100, 100, 600, 450);
		getContentPane().setLayout(null);
		
		txtFullName = new JTextField();
		txtFullName.setEditable(false);
		txtFullName.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtFullName.setBounds(165, 79, 280, 19);
		getContentPane().add(txtFullName);
		txtFullName.setColumns(10);
		
		lblFullname = new JLabel("Nombre", JLabel.RIGHT);
		lblFullname.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblFullname.setBounds(23, 79, 124, 19);
		getContentPane().add(lblFullname);
		
		lblBithdate = new JLabel("Fecha nacimiento", JLabel.RIGHT);
		lblBithdate.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblBithdate.setBounds(23, 110, 124, 19);
		getContentPane().add(lblBithdate);
		
		lblAddress = new JLabel("Domicilio", JLabel.RIGHT);
		lblAddress.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblAddress.setBounds(23, 144, 124, 19);
		getContentPane().add(lblAddress);
		
		lblCity = new JLabel("Ciudad", JLabel.RIGHT);
		lblCity.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblCity.setBounds(23, 175, 124, 19);
		getContentPane().add(lblCity);
		
		lblPhone1 = new JLabel("Teléfono", JLabel.RIGHT);
		lblPhone1.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblPhone1.setBounds(23, 206, 124, 19);
		getContentPane().add(lblPhone1);
		
		lblMobile1 = new JLabel("Móvil", JLabel.RIGHT);
		lblMobile1.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblMobile1.setBounds(23, 237, 124, 19);
		getContentPane().add(lblMobile1);
		
		lblEmail = new JLabel("E-mail", JLabel.RIGHT);
		lblEmail.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblEmail.setBounds(23, 268, 124, 19);
		getContentPane().add(lblEmail);
		
		txtBirthdate = new JTextField();
		txtBirthdate.setEditable(false);
		txtBirthdate.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtBirthdate.setBounds(165, 110, 143, 19);
		getContentPane().add(txtBirthdate);
		txtBirthdate.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setEditable(false);
		txtAddress.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtAddress.setBounds(165, 144, 280, 19);
		getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		txtCity = new JTextField();
		txtCity.setEditable(false);
		txtCity.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtCity.setBounds(165, 175, 280, 19);
		getContentPane().add(txtCity);
		txtCity.setColumns(10);
		
		txtPhone1 = new JTextField();
		txtPhone1.setEditable(false);
		txtPhone1.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtPhone1.setBounds(165, 206, 143, 19);
		getContentPane().add(txtPhone1);
		txtPhone1.setColumns(10);
		
		txtMobile1 = new JTextField();
		txtMobile1.setEditable(false);
		txtMobile1.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtMobile1.setBounds(165, 237, 143, 19);
		getContentPane().add(txtMobile1);
		txtMobile1.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtEmail.setBounds(165, 268, 280, 19);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnExit = new JButton("Salir");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setIcon(new ImageIcon(PassengerReader.class.getResource("/ar/com/tourandino/resources/door.png")));
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
		btnDate.setIcon(new ImageIcon(PassengerReader.class.getResource("/ar/com/tourandino/resources/calendar.png")));
		btnDate.setBounds(315, 107, 25, 25);
		getContentPane().add(btnDate);
		
		JLabel lblPhone2 = new JLabel("Teléfono alt.", SwingConstants.RIGHT);
		lblPhone2.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblPhone2.setBounds(320, 206, 78, 19);
		getContentPane().add(lblPhone2);
		
		txtPhone2 = new JTextField();
		txtPhone2.setEditable(false);
		txtPhone2.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtPhone2.setColumns(10);
		txtPhone2.setBounds(416, 206, 143, 19);
		getContentPane().add(txtPhone2);
		
		JLabel lblMobile2 = new JLabel("Móvil alt.", SwingConstants.RIGHT);
		lblMobile2.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblMobile2.setBounds(320, 237, 78, 19);
		getContentPane().add(lblMobile2);
		
		txtMobile2 = new JTextField();
		txtMobile2.setEditable(false);
		txtMobile2.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtMobile2.setColumns(10);
		txtMobile2.setBounds(416, 237, 143, 19);
		getContentPane().add(txtMobile2);
		loadPassenger(id);

	}
	
	private void btnDateActionPerformed(ActionEvent e){
		txtBirthdate.setText(new DatePicker(this).getPickedDate());
	}
	
	private void loadPassenger(Integer id){
		Object[] item = passengerController.readPassenger(id);
		txtFullName.setText(item[0].toString());
		try{
			SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
			txtBirthdate.setText(date.format(item[1]));
			txtAddress.setText(item[2].toString());
			txtCity.setText(item[3].toString());
			txtPhone1.setText(item[4].toString());
			txtPhone2.setText(item[5].toString());
			txtMobile1.setText(item[6].toString());
			txtMobile2.setText(item[7].toString());
			txtEmail.setText(item[8].toString());
		}
		catch(NullPointerException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.getCause().toString());
		}
		catch(IllegalArgumentException e1){
			errorLogController.createErrorLog(new Date(), e1.getMessage(), this.getTitle(), e1.getCause().toString());
		}
	}
	
}
