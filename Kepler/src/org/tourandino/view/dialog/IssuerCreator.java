package org.tourandino.view.dialog;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Font;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import org.tourandino.controller.ErrorLogController;
import org.tourandino.controller.IssuerController;
import org.tourandino.controller.TaxConditionController;
import org.tourandino.view.frame.Main;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class IssuerCreator extends JDialog {

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
	private boolean isSucceed;
	private Integer issuerId;
	private JComboBox cmbTaxCondition;
	private TaxConditionController taxConditionController;
	private ErrorLogController errorLogController;
	private IssuerController issuerController;
	private JLabel lblPhone2;
	private JTextField txtPhone2;
	private JLabel lblWebsite;
	private JTextField txtWebiste;

	/**
	 * Create the dialog.
	 */
	public IssuerCreator(JDialog parent, boolean modal) {
		super(parent, modal);
		isSucceed = false;
		taxConditionController = new TaxConditionController();
		errorLogController = new ErrorLogController();
		issuerController = new IssuerController();
		setTitle("Nuevo Operador");
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
		txtCreditLimit.setBounds(176, 308, 175, 19);
		getContentPane().add(txtCreditLimit);
		txtCreditLimit.setColumns(10);
		txtCreditLimit.setText("0");
		
		txtCuit = new JTextField();
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
		txtAddress.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtAddress.setBounds(176, 122, 280, 19);
		getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		txtCity = new JTextField();
		txtCity.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtCity.setBounds(176, 153, 280, 19);
		getContentPane().add(txtCity);
		txtCity.setColumns(10);
		
		txtPhone1 = new JTextField();
		txtPhone1.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtPhone1.setBounds(176, 184, 138, 19);
		getContentPane().add(txtPhone1);
		txtPhone1.setColumns(10);
		
		txtMobile = new JTextField();
		txtMobile.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtMobile.setBounds(425, 184, 138, 19);
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
		btnAdd.setIcon(new ImageIcon(IssuerCreator.class.getResource("/ar/com/tourandino/resources/accept.png")));
		btnAdd.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnAdd.setBounds(459, 378, 117, 25);
		getContentPane().add(btnAdd);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setIcon(new ImageIcon(IssuerCreator.class.getResource("/ar/com/tourandino/resources/cancel.png")));
		btnCancel.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnCancel.setBounds(330, 378, 117, 25);
		getContentPane().add(btnCancel);
		
		lblPhone2 = new JLabel("Teléfono alt.", SwingConstants.RIGHT);
		lblPhone2.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblPhone2.setBounds(34, 215, 124, 19);
		getContentPane().add(lblPhone2);
		
		txtPhone2 = new JTextField();
		txtPhone2.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtPhone2.setColumns(10);
		txtPhone2.setBounds(176, 215, 138, 19);
		getContentPane().add(txtPhone2);
		
		lblWebsite = new JLabel("Website", SwingConstants.RIGHT);
		lblWebsite.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblWebsite.setBounds(34, 277, 124, 19);
		getContentPane().add(lblWebsite);
		
		txtWebiste = new JTextField();
		txtWebiste.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtWebiste.setColumns(10);
		txtWebiste.setBounds(176, 277, 280, 19);
		getContentPane().add(txtWebiste);

	}
	
	private void loadComboBox(JComboBox comboBox){
		comboBox.setModel(taxConditionController.loadRoles());
	}
	
	private void btnAddActionPerformed(ActionEvent evt){
		if(!txtFullname.getText().isEmpty()){
			if(!txtCuit.getText().isEmpty()){
				if(!txtCreditLimit.getText().isEmpty()){
					try{
						issuerId = issuerController.createIssuer(cmbTaxCondition.getSelectedItem(), txtFullname.getText().toUpperCase(), txtCuit.getText().toUpperCase(), Float.parseFloat(txtCreditLimit.getText()), 
								txtAddress.getText().toUpperCase(), txtCity.getText().toUpperCase(), txtPhone1.getText().toUpperCase(), txtPhone2.getText().toUpperCase(), txtMobile.getText().toUpperCase(),
								txtEmail.getText().toLowerCase(), txtWebiste.getText().toLowerCase());
						if(issuerId > 0){
							JOptionPane.showMessageDialog(this, "La operacíon se completó exitosamente.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/information.png")));
							isSucceed = true;
							this.dispose();
						}
						else{
							JOptionPane.showMessageDialog(this, "No se pudo completar la operación, intente nuevamente o contacte al administrador.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
						}
					}catch(NumberFormatException e){
						errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
						JOptionPane.showMessageDialog(this, "No se pudo completar la operación. Verifique el límite de crédito ingresado e intente nuevamente.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
					}

				}
				else{
					JOptionPane.showMessageDialog(this, "No se pudo completar la operación. Ingrese el límite de crédito e intente nuevamente.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
				}
			}
			else{
				JOptionPane.showMessageDialog(this, "No se pudo completar la operación. Ingrese el CUIT e intente nuevamente.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
			}			
		}
		else{
			JOptionPane.showMessageDialog(this, "No se pudo completar la operación. Ingrese el nombre e intente nuevamente.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
	}

	public boolean isSucceed() {
		return isSucceed;
	}

	public void setSucceed(boolean isSucceed) {
		this.isSucceed = isSucceed;
	}

	public JTextField getTxtFullname() {
		return txtFullname;
	}

	public void setTxtFullname(JTextField txtFullname) {
		this.txtFullname = txtFullname;
	}

	public JTextField getTxtCuit() {
		return txtCuit;
	}

	public void setTxtCuit(JTextField txtCuit) {
		this.txtCuit = txtCuit;
	}

	public JTextField getTxtAddress() {
		return txtAddress;
	}

	public void setTxtAddress(JTextField txtAddress) {
		this.txtAddress = txtAddress;
	}

	public JComboBox getCmbTaxCondition() {
		return cmbTaxCondition;
	}

	public void setCmbTaxCondition(JComboBox cmbTaxCondition) {
		this.cmbTaxCondition = cmbTaxCondition;
	}
}
