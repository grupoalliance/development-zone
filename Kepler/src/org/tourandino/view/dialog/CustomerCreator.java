package org.tourandino.view.dialog;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.tourandino.controller.CustomerController;
import org.tourandino.controller.ErrorLogController;
import org.tourandino.controller.TaxConditionController;
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

@SuppressWarnings({"rawtypes","unchecked"})
public class CustomerCreator extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -214349194818108970L;
	private JComboBox cmbTaxCondition;
	private JLabel lblTaxCondition;
	private JLabel lblCuit;
	private JLabel lblBithdate;
	private JLabel lblAddress;
	private JLabel lblCity;
	private JLabel lblPhone;
	private JLabel lblMobile;
	private JLabel lblEmail;
	private JLabel lblCreditLimit;private JTextField txtFullname;
	private JTextField txtCreditLimit;
	private JTextField txtCuit;
	private JTextField txtBirthdate;
	private JTextField txtAddress;
	private JTextField txtCity;
	private JTextField txtPhone;
	private JTextField txtMobile;
	private JTextField txtEmail;
	private TaxConditionController taxConditionController;
	private CustomerController customerController;
	private ErrorLogController errorLogController;

	/**
	 * Create the dialog.
	 */
	public CustomerCreator(JDialog parent, boolean modal, CustomerController customerController) {
		super(parent, modal);
		this.taxConditionController = new TaxConditionController();
		this.customerController = customerController;
		this.errorLogController = new ErrorLogController();
		initializeComponents();
	}
	
	private void initializeComponents(){
		setTitle("Nuevo Cliente");
		setResizable(false);
		getContentPane().setBackground(new Color(255, 204, 51));
		setBounds(100, 100, 600, 450);
		getContentPane().setLayout(null);
		
		txtFullname = new JTextField();
		txtFullname.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtFullname.setBounds(176, 60, 280, 19);
		getContentPane().add(txtFullname);
		txtFullname.setColumns(10);
		
		txtCreditLimit = new JTextField();
		txtCreditLimit.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtCreditLimit.setBounds(176, 277, 175, 19);
		getContentPane().add(txtCreditLimit);
		txtCreditLimit.setColumns(10);
		txtCreditLimit.setText("0");
		
		txtCuit = new JTextField();
		txtCuit.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtCuit.setBounds(425, 91, 138, 19);
		getContentPane().add(txtCuit);
		txtCuit.setColumns(10);
		
		JLabel lblFullname = new JLabel("Nombre completo", JLabel.RIGHT);
		lblFullname.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblFullname.setBounds(34, 60, 124, 19);
		getContentPane().add(lblFullname);
		
		lblTaxCondition = new JLabel("Condición IVA", JLabel.RIGHT);
		lblTaxCondition.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblTaxCondition.setBounds(34, 91, 124, 19);
		getContentPane().add(lblTaxCondition);
		
		lblCuit = new JLabel("CUIT", JLabel.RIGHT);
		lblCuit.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblCuit.setBounds(332, 91, 75, 19);
		getContentPane().add(lblCuit);
		
		lblBithdate = new JLabel("Fecha nacimiento", JLabel.RIGHT);
		lblBithdate.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblBithdate.setBounds(34, 122, 124, 19);
		getContentPane().add(lblBithdate);
		
		lblAddress = new JLabel("Domicilio", JLabel.RIGHT);
		lblAddress.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblAddress.setBounds(34, 153, 124, 19);
		getContentPane().add(lblAddress);
		
		lblCity = new JLabel("Ciudad", JLabel.RIGHT);
		lblCity.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblCity.setBounds(34, 184, 124, 19);
		getContentPane().add(lblCity);
		
		lblPhone = new JLabel("Teléfono", JLabel.RIGHT);
		lblPhone.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblPhone.setBounds(34, 215, 124, 19);
		getContentPane().add(lblPhone);
		
		lblMobile = new JLabel("Móvil", JLabel.RIGHT);
		lblMobile.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblMobile.setBounds(332, 215, 75, 19);
		getContentPane().add(lblMobile);
		
		lblEmail = new JLabel("E-mail", JLabel.RIGHT);
		lblEmail.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblEmail.setBounds(34, 246, 124, 19);
		getContentPane().add(lblEmail);
		
		lblCreditLimit = new JLabel("Limite de crédito", JLabel.RIGHT);
		lblCreditLimit.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblCreditLimit.setBounds(34, 277, 124, 19);
		getContentPane().add(lblCreditLimit);
		
		txtBirthdate = new JTextField();
		txtBirthdate.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtBirthdate.setBounds(176, 122, 138, 19);
		getContentPane().add(txtBirthdate);
		txtBirthdate.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtAddress.setBounds(176, 153, 280, 19);
		getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		txtCity = new JTextField();
		txtCity.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtCity.setBounds(176, 184, 280, 19);
		getContentPane().add(txtCity);
		txtCity.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtPhone.setBounds(176, 215, 138, 19);
		getContentPane().add(txtPhone);
		txtPhone.setColumns(10);
		
		txtMobile = new JTextField();
		txtMobile.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtMobile.setBounds(425, 215, 138, 19);
		getContentPane().add(txtMobile);
		txtMobile.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtEmail.setBounds(176, 246, 280, 19);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		cmbTaxCondition = new JComboBox();
		cmbTaxCondition.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		cmbTaxCondition.setBounds(176, 91, 138, 19);
		getContentPane().add(cmbTaxCondition);
		loadComboBox(cmbTaxCondition);
		
		JButton btnAdd = new JButton("Aceptar");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddActionPerformed(e);
			}
		});
		btnAdd.setIcon(new ImageIcon(CustomerCreator.class.getResource("/ar/com/tourandino/resources/accept.png")));
		btnAdd.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnAdd.setBounds(459, 378, 117, 25);
		getContentPane().add(btnAdd);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setIcon(new ImageIcon(CustomerCreator.class.getResource("/ar/com/tourandino/resources/cancel.png")));
		btnCancel.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnCancel.setBounds(330, 378, 117, 25);
		getContentPane().add(btnCancel);
		
		JButton btnDate = new JButton("");
		btnDate.setToolTipText("Ver calendario");
		btnDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDateActionPerformed(e);
			}
		});
		btnDate.setIcon(new ImageIcon(CustomerCreator.class.getResource("/ar/com/tourandino/resources/calendar.png")));
		btnDate.setBounds(326, 119, 25, 25);
		getContentPane().add(btnDate);
	}
	
	private void loadComboBox(JComboBox comboBox){
		comboBox.setModel(taxConditionController.loadRoles());
	}
	
	private void btnDateActionPerformed(ActionEvent e){
		txtBirthdate.setText(new DatePicker(this).getPickedDate());
	}
	
	private void btnAddActionPerformed(ActionEvent evt){
		if(!txtFullname.getText().isEmpty()){
			if(!txtCuit.getText().isEmpty()){
				if(!txtBirthdate.getText().isEmpty()){
					SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy"); 
					Date date;
					try {
						date = dt.parse(txtBirthdate.getText());
					} catch (ParseException e) {
						errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.getCause().toString());
						date = null;
					}
					if(!txtCreditLimit.getText().isEmpty()){
						if(date != null){
							try{
								if(customerController.create(cmbTaxCondition.getSelectedItem(), txtFullname.getText(), txtCuit.getText(), Float.parseFloat(txtCreditLimit.getText()), 
										date, txtAddress.getText(), txtCity.getText(), txtPhone.getText(), txtMobile.getText(), txtEmail.getText()) > 0){
									JOptionPane.showMessageDialog(this, "Cliente creado exitosamente", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/information.png")));
									this.dispose();
								}
								else{
									JOptionPane.showMessageDialog(this, "El cliente no se ha podido crear, intente nuevamente o contacte al administrador", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
								}
							}catch(NumberFormatException e){
								errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.getCause().toString());
								JOptionPane.showMessageDialog(this, "Ha habido un problema con el limite de crédito", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
							}
						}
						else{
							JOptionPane.showMessageDialog(this, "Ha habido un problema con la fecha seleccionada", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
						}

					}
					else{
						JOptionPane.showMessageDialog(this, "Ingrese el limite de crédito para el cliente", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
					}
				}
				else{
					JOptionPane.showMessageDialog(this, "Ingrese la fecha de nacimiento", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
				}
			}
			else{
				JOptionPane.showMessageDialog(this, "Ingrese el CUIT del cliente", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
			}			
		}
		else{
			JOptionPane.showMessageDialog(this, "Ingrese el nombre del cliente", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
	}	
	
}
