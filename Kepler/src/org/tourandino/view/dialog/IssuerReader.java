package org.tourandino.view.dialog;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import org.tourandino.controller.ErrorLogController;
import org.tourandino.controller.IssuerController;

public class IssuerReader extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -214349194818108970L;
	private JTextField txtFullname;
	private JTextField txtCreditLimit;
	private JTextField txtCuit;
	private JLabel lblTaxCondition;
	private JLabel lblCuit;
	private JLabel lblAddress;
	private JLabel lblCity;
	private JLabel lblPhone1;
	private JLabel lblMobile;
	private JLabel lblEmail;
	private JLabel lblCreditLimit;
	private JTextField txtAddress;
	private JTextField txtCity;
	private JTextField txtPhone1;
	private JTextField txtMobile;
	private JTextField txtEmail;
	private ErrorLogController errorLogController;
	private IssuerController issuerController;
	private JLabel lblPhone2;
	private JTextField txtPhone2;
	private JLabel lblWebsite;
	private JTextField txtWebiste;
	private JTextField txtTaxCondition;

	/**
	 * Create the dialog.
	 */
	public IssuerReader(JDialog parent, boolean modal, IssuerController issuerController, Integer id) {
		super(parent, modal);
		this.errorLogController = new ErrorLogController();
		this.issuerController = issuerController;
		initializeComponents();
		loadIssuer(id);
	}
	
	private void initializeComponents(){
		setTitle("Ver Operador");
		setResizable(false);
		getContentPane().setBackground(new Color(255, 204, 51));
		setBounds(100, 100, 600, 450);
		getContentPane().setLayout(null);
		
		txtFullname = new JTextField();
		txtFullname.setEditable(false);
		txtFullname.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtFullname.setBounds(176, 60, 280, 19);
		getContentPane().add(txtFullname);
		txtFullname.setColumns(10);
		
		txtCreditLimit = new JTextField();
		txtCreditLimit.setEditable(false);
		txtCreditLimit.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtCreditLimit.setBounds(176, 308, 175, 19);
		getContentPane().add(txtCreditLimit);
		txtCreditLimit.setColumns(10);
		txtCreditLimit.setText("0");
		
		txtCuit = new JTextField();
		txtCuit.setEditable(false);
		txtCuit.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtCuit.setBounds(425, 91, 138, 19);
		getContentPane().add(txtCuit);
		txtCuit.setColumns(10);
		
		JLabel lblFullname = new JLabel("Nombre", JLabel.RIGHT);
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
		
		lblAddress = new JLabel("Domicilio", JLabel.RIGHT);
		lblAddress.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblAddress.setBounds(34, 122, 124, 19);
		getContentPane().add(lblAddress);
		
		lblCity = new JLabel("Ciudad", JLabel.RIGHT);
		lblCity.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblCity.setBounds(34, 153, 124, 19);
		getContentPane().add(lblCity);
		
		lblPhone1 = new JLabel("Teléfono", JLabel.RIGHT);
		lblPhone1.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblPhone1.setBounds(34, 184, 124, 19);
		getContentPane().add(lblPhone1);
		
		lblMobile = new JLabel("Móvil", JLabel.RIGHT);
		lblMobile.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblMobile.setBounds(332, 184, 75, 19);
		getContentPane().add(lblMobile);
		
		lblEmail = new JLabel("E-mail", JLabel.RIGHT);
		lblEmail.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblEmail.setBounds(34, 246, 124, 19);
		getContentPane().add(lblEmail);
		
		lblCreditLimit = new JLabel("Limite de crédito", JLabel.RIGHT);
		lblCreditLimit.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblCreditLimit.setBounds(34, 308, 124, 19);
		getContentPane().add(lblCreditLimit);
		
		txtAddress = new JTextField();
		txtAddress.setEditable(false);
		txtAddress.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtAddress.setBounds(176, 122, 280, 19);
		getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		txtCity = new JTextField();
		txtCity.setEditable(false);
		txtCity.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtCity.setBounds(176, 153, 280, 19);
		getContentPane().add(txtCity);
		txtCity.setColumns(10);
		
		txtPhone1 = new JTextField();
		txtPhone1.setEditable(false);
		txtPhone1.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtPhone1.setBounds(176, 184, 138, 19);
		getContentPane().add(txtPhone1);
		txtPhone1.setColumns(10);
		
		txtMobile = new JTextField();
		txtMobile.setEditable(false);
		txtMobile.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtMobile.setBounds(425, 184, 138, 19);
		getContentPane().add(txtMobile);
		txtMobile.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtEmail.setBounds(176, 246, 280, 19);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnExit = new JButton("Salir");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setIcon(new ImageIcon(IssuerReader.class.getResource("/ar/com/tourandino/resources/door.png")));
		btnExit.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnExit.setBounds(459, 378, 117, 25);
		getContentPane().add(btnExit);
		
		lblPhone2 = new JLabel("Teléfono alt.", SwingConstants.RIGHT);
		lblPhone2.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblPhone2.setBounds(34, 215, 124, 19);
		getContentPane().add(lblPhone2);
		
		txtPhone2 = new JTextField();
		txtPhone2.setEditable(false);
		txtPhone2.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtPhone2.setColumns(10);
		txtPhone2.setBounds(176, 215, 138, 19);
		getContentPane().add(txtPhone2);
		
		lblWebsite = new JLabel("Website", SwingConstants.RIGHT);
		lblWebsite.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblWebsite.setBounds(34, 277, 124, 19);
		getContentPane().add(lblWebsite);
		
		txtWebiste = new JTextField();
		txtWebiste.setEditable(false);
		txtWebiste.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtWebiste.setColumns(10);
		txtWebiste.setBounds(176, 277, 280, 19);
		getContentPane().add(txtWebiste);
		
		txtTaxCondition = new JTextField();
		txtTaxCondition.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtTaxCondition.setEditable(false);
		txtTaxCondition.setColumns(10);
		txtTaxCondition.setBounds(176, 91, 138, 19);
		getContentPane().add(txtTaxCondition);

	}
	
	private void loadIssuer(Integer id){
		Object[] items = issuerController.read(id);
		txtFullname.setText(items[0].toString());
		txtTaxCondition.setText(items[1].toString());
		txtCuit.setText(items[2].toString());
		txtCreditLimit.setText(items[10].toString());
		try{
			txtAddress.setText(items[3].toString());
			txtCity.setText(items[4].toString());
			txtPhone1.setText(items[5].toString());
			txtPhone2.setText(items[6].toString());
			txtMobile.setText(items[7].toString());
			txtEmail.setText(items[8].toString());
			txtWebiste.setText(items[9].toString());
		}
		catch (NullPointerException e) {
        errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
		} 
		catch (IllegalArgumentException e1) {
        errorLogController.createErrorLog(new Date(), e1.getMessage(), this.getTitle(), e1.toString());
		}
	}
}
