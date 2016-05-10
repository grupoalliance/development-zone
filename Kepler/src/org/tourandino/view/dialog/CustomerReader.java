package org.tourandino.view.dialog;

import javax.swing.JDialog;
import javax.swing.JTextField;

import org.tourandino.controller.CustomerController;
import org.tourandino.controller.ErrorLogController;
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

public class CustomerReader extends JDialog {

    /**
     *
     */
    private static final long serialVersionUID = -214349194818108970L;
    private JTextField txtFullname;
    private JTextField txtCreditLimit;
    private JTextField txtCuit;
    private JLabel lblTaxCondition;
    private JLabel lblCuit;
    private JLabel lblBithdate;
    private JLabel lblAddress;
    private JLabel lblCity;
    private JLabel lblPhone;
    private JLabel lblMobile;
    private JLabel lblEmail;
    private JLabel lblCreditLimit;
    private JTextField txtBirthdate;
    private JTextField txtAddress;
    private JTextField txtCity;
    private JTextField txtPhone;
    private JTextField txtMobile;
    private JTextField txtEmail;
    private CustomerController customerController;
    private JTextField txtTaxCondition;
    private Integer id;
    private ErrorLogController errorLogController;

    /**
     * Create the dialog.
     */
    public CustomerReader(JDialog parent, boolean modal, Integer id) {
        super(parent, modal);
        this.id = id;
        customerController = new CustomerController();
        errorLogController = new ErrorLogController();
        setTitle("Ver Cliente");
        setResizable(false);
        getContentPane().setBackground(new Color(255, 204, 51));
        setBounds(100, 100, 600, 450);
        getContentPane().setLayout(null);

        JButton btnExit = new JButton("Salir");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnExit.setIcon(new ImageIcon(CustomerReader.class.getResource("/ar/com/tourandino/resources/door.png")));
        btnExit.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        btnExit.setBounds(459, 378, 117, 25);
        getContentPane().add(btnExit);

        txtFullname = new JTextField();
        txtFullname.setEditable(false);
        txtFullname.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        txtFullname.setBounds(171, 68, 280, 19);
        getContentPane().add(txtFullname);
        txtFullname.setColumns(10);

        txtCreditLimit = new JTextField();
        txtCreditLimit.setEditable(false);
        txtCreditLimit.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        txtCreditLimit.setBounds(171, 285, 138, 19);
        getContentPane().add(txtCreditLimit);
        txtCreditLimit.setColumns(10);

        txtCuit = new JTextField();
        txtCuit.setEditable(false);
        txtCuit.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        txtCuit.setBounds(414, 99, 138, 19);
        getContentPane().add(txtCuit);
        txtCuit.setColumns(10);

        JLabel lblFullname = new JLabel("Nombre completo", JLabel.RIGHT);
        lblFullname.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        lblFullname.setBounds(29, 68, 124, 19);
        getContentPane().add(lblFullname);

        lblTaxCondition = new JLabel("Condición IVA", JLabel.RIGHT);
        lblTaxCondition.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        lblTaxCondition.setBounds(29, 99, 124, 19);
        getContentPane().add(lblTaxCondition);

        lblCuit = new JLabel("CUIT", JLabel.RIGHT);
        lblCuit.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        lblCuit.setBounds(321, 99, 75, 19);
        getContentPane().add(lblCuit);

        lblBithdate = new JLabel("Fecha nacimiento", JLabel.RIGHT);
        lblBithdate.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        lblBithdate.setBounds(29, 130, 124, 19);
        getContentPane().add(lblBithdate);

        lblAddress = new JLabel("Domicilio", JLabel.RIGHT);
        lblAddress.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        lblAddress.setBounds(29, 161, 124, 19);
        getContentPane().add(lblAddress);

        lblCity = new JLabel("Ciudad", JLabel.RIGHT);
        lblCity.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        lblCity.setBounds(29, 192, 124, 19);
        getContentPane().add(lblCity);

        lblPhone = new JLabel("Teléfono", JLabel.RIGHT);
        lblPhone.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        lblPhone.setBounds(29, 223, 124, 19);
        getContentPane().add(lblPhone);

        lblMobile = new JLabel("Móvil", JLabel.RIGHT);
        lblMobile.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        lblMobile.setBounds(327, 223, 75, 19);
        getContentPane().add(lblMobile);

        lblEmail = new JLabel("E-mail", JLabel.RIGHT);
        lblEmail.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        lblEmail.setBounds(29, 254, 124, 19);
        getContentPane().add(lblEmail);

        lblCreditLimit = new JLabel("Limite de crédito", JLabel.RIGHT);
        lblCreditLimit.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        lblCreditLimit.setBounds(29, 285, 124, 19);
        getContentPane().add(lblCreditLimit);

        txtBirthdate = new JTextField();
        txtBirthdate.setEditable(false);
        txtBirthdate.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        txtBirthdate.setBounds(171, 130, 138, 19);
        getContentPane().add(txtBirthdate);
        txtBirthdate.setColumns(10);

        txtAddress = new JTextField();
        txtAddress.setEditable(false);
        txtAddress.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        txtAddress.setBounds(171, 161, 175, 19);
        getContentPane().add(txtAddress);
        txtAddress.setColumns(10);

        txtCity = new JTextField();
        txtCity.setEditable(false);
        txtCity.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        txtCity.setBounds(171, 192, 280, 19);
        getContentPane().add(txtCity);
        txtCity.setColumns(10);

        txtPhone = new JTextField();
        txtPhone.setEditable(false);
        txtPhone.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        txtPhone.setBounds(171, 223, 138, 19);
        getContentPane().add(txtPhone);
        txtPhone.setColumns(10);

        txtMobile = new JTextField();
        txtMobile.setEditable(false);
        txtMobile.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        txtMobile.setBounds(414, 223, 138, 19);
        getContentPane().add(txtMobile);
        txtMobile.setColumns(10);

        txtEmail = new JTextField();
        txtEmail.setEditable(false);
        txtEmail.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        txtEmail.setBounds(171, 254, 280, 19);
        getContentPane().add(txtEmail);
        txtEmail.setColumns(10);

        JButton btnDate = new JButton("");
        btnDate.setEnabled(false);
        btnDate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnDateActionPerformed(e);
            }
        });
        btnDate.setIcon(new ImageIcon(CustomerReader.class.getResource("/ar/com/tourandino/resources/calendar.png")));
        btnDate.setBounds(321, 127, 25, 25);
        getContentPane().add(btnDate);

        txtTaxCondition = new JTextField();
        txtTaxCondition.setEditable(false);
        txtTaxCondition.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        txtTaxCondition.setColumns(10);
        txtTaxCondition.setBounds(171, 99, 138, 19);
        getContentPane().add(txtTaxCondition);
        loadCustomer(this.id);

    }

    private void btnDateActionPerformed(ActionEvent e) {
        txtBirthdate.setText(new DatePicker(this).getPickedDate());
    }

    private void loadCustomer(Integer id) {
        Object[] items = customerController.readCustomer(id);
        txtTaxCondition.setText(items[0].toString());
        txtFullname.setText(items[1].toString());
        txtCuit.setText(items[2].toString());
        txtCreditLimit.setText(items[3].toString());
        try {
            SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
            txtBirthdate.setText(date.format(items[4]));
            txtAddress.setText(items[5].toString());
            txtCity.setText(items[6].toString());
            txtPhone.setText(items[7].toString());
            txtMobile.setText(items[8].toString());
            txtEmail.setText(items[9].toString());
        } catch (NullPointerException e) {
            errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
        } catch (IllegalArgumentException e1) {
            errorLogController.createErrorLog(new Date(), e1.getMessage(), this.getTitle(), e1.toString());
        }
    }
}
