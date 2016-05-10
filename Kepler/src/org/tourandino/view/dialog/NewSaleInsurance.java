package org.tourandino.view.dialog;

import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.SwingConstants;

import org.einstein.controller.LoginController;
import org.tourandino.controller.CustomerController;
import org.tourandino.controller.DailyCashRecordController;
import org.tourandino.controller.ErrorLogController;
import org.tourandino.controller.IssuerController;
import org.tourandino.controller.OrderController;
import org.tourandino.controller.PassengerController;
import org.tourandino.view.frame.Main;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextPane;

@SuppressWarnings({"rawtypes","unchecked"})
public class NewSaleInsurance extends JDialog {

	private static final long serialVersionUID = 1847689777033426444L;
	private JButton btnDate;
	private JButton btnCustAdd;
	private JButton btnSearch;
	private JButton btnDelItinerary;
	private JButton btnAddItinerary;
	private JButton btnSearch1;
	private JButton btnPassAdd;
	private JButton btnIssuerAdd;
	private JButton btnPayment;
	private JButton btnConfirm;
	private JButton btnCancel;
	private JButton btnDelPayment;
	private JComboBox cmbIssuers;
	private JTable tablePassengers;
	private JTextField txtDate;
	private JTextField txtCustomer;
	private JTextField txtAddress;
	private JTextField txtCuit;
	private JTextField txtSearch1;
	private JTextField txtInsuranceName;
	private JTextField txtItinerary;
	private JTextField txtSubtotal;
	private JTextField txtDiscount;
	private JTextField txtRate;
	private JTextField txtTax;
	private JTextField txtTotal;
	private JTextField txtTaxCondition;
	private JTextField txtUser;
	private JTextField txtSearch;
	private JTextField txtPassenger;
	private JTextField txtPrice;
	private JTextField txtCost;
	private JTextField txtCash;
	private JTextField txtAccount;
	private JTextField txtDebit;
	private JTextField txtCredit;
	private JTextField txtCheque;
	private JTextField txtPriceTotal;
	private JTextField txtCostTotal;
	private JTextField txtProfitTotal;	
	private JTextPane txtNote;
	private OrderController orderController;
	private LoginController loginController;
	private ErrorLogController errorLogController;
	private IssuerController issuerController;
	private CustomerController customerController;
	private PassengerController passengerController;
	private DailyCashRecordController dailyCashRecordController;

	/**
	 * Create the dialog.
	 */
	public NewSaleInsurance(JFrame parent, boolean modal, LoginController loginController, DailyCashRecordController dailyCashRecordController) {
		super(parent, modal);
		this.dailyCashRecordController = dailyCashRecordController;
		this.loginController = loginController;
		this.errorLogController = new ErrorLogController();
		this.issuerController = new IssuerController();
		this.customerController = new CustomerController();
		this.passengerController = new PassengerController();
		this.orderController = new OrderController(this.customerController, this.passengerController, this.loginController, this.dailyCashRecordController);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		initializeComponents();
		orderController.initializeInsuranceOrder(loginController.getUser(), getTitle());
		displayTotal(txtPriceTotal, txtCostTotal, txtSubtotal, txtTotal, txtProfitTotal);
		displayPayments(txtCash, txtAccount, txtDebit, txtCredit, txtCheque);
	}
	
	private void initializeComponents(){
		setResizable(false);
		setTitle("VENTA DE SEGUROS");
		getContentPane().setBackground(new Color(255, 204, 51));
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		tabbedPane.setBounds(0, 12, 800, 504);
		getContentPane().add(tabbedPane);
		
		/*
		 * INITIALIZE THE CUSTOMERS PANEL
		 */
		JPanel panelGeneral = new JPanel();
		tabbedPane.addTab("General/Cliente", null, panelGeneral, null);
		panelGeneral.setLayout(null);
		
		JLabel lblCustomer = new JLabel("Cliente", JLabel.RIGHT);
		lblCustomer.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblCustomer.setBounds(12, 250, 70, 15);
		panelGeneral.add(lblCustomer);
		
		JLabel lblAddress = new JLabel("Domicilio", JLabel.RIGHT);
		lblAddress.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblAddress.setBounds(12, 282, 70, 15);
		panelGeneral.add(lblAddress);
		
		JLabel lblCuit = new JLabel("CUIT", JLabel.RIGHT);
		lblCuit.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblCuit.setBounds(12, 313, 70, 15);
		panelGeneral.add(lblCuit);
		
		JLabel lblTaxCondition = new JLabel("Condición IVA");
		lblTaxCondition.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblTaxCondition.setBounds(332, 313, 94, 15);
		panelGeneral.add(lblTaxCondition);
		
		JLabel lblSearch1 = new JLabel("Búsqueda");
		lblSearch1.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblSearch1.setBounds(12, 219, 70, 15);
		panelGeneral.add(lblSearch1);
		
		JLabel lblFecha = new JLabel("Fecha", JLabel.RIGHT);
		lblFecha.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblFecha.setBounds(487, 46, 70, 15);
		panelGeneral.add(lblFecha);
		
		JLabel lblUsuario = new JLabel("Usuario", SwingConstants.RIGHT);
		lblUsuario.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblUsuario.setBounds(487, 14, 70, 15);
		panelGeneral.add(lblUsuario);
		
		txtDate = new JTextField();
		txtDate.setEditable(false);
		txtDate.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		txtDate.setBounds(569, 44, 177, 19);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		txtDate.setText(sdf.format(new Date()));
		panelGeneral.add(txtDate);
		txtDate.setColumns(10);
		
		txtCustomer = new JTextField();
		txtCustomer.setEditable(false);
		txtCustomer.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		txtCustomer.setBounds(100, 248, 214, 19);
		panelGeneral.add(txtCustomer);
		txtCustomer.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setEditable(false);
		txtAddress.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		txtAddress.setBounds(100, 280, 214, 19);
		panelGeneral.add(txtAddress);
		txtAddress.setColumns(10);
		
		txtCuit = new JTextField();
		txtCuit.setEditable(false);
		txtCuit.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		txtCuit.setBounds(100, 311, 214, 19);
		panelGeneral.add(txtCuit);
		txtCuit.setColumns(10);
		
		txtSearch1 = new JTextField();
		txtSearch1.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtSearch1.setBounds(100, 217, 148, 19);
		panelGeneral.add(txtSearch1);
		txtSearch1.setColumns(10);
		
		txtTaxCondition = new JTextField();
		txtTaxCondition.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		txtTaxCondition.setEditable(false);
		txtTaxCondition.setBounds(432, 311, 214, 19);
		panelGeneral.add(txtTaxCondition);
		txtTaxCondition.setColumns(10);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		txtUser.setEditable(false);
		txtUser.setColumns(10);
		txtUser.setBounds(569, 12, 214, 19);
		txtUser.setText(loginController.getUser().getUserFullname());
		panelGeneral.add(txtUser);
		
		btnDate = new JButton("");
		btnDate.setEnabled(false);
		btnDate.setToolTipText("Ver calendario");
		btnDate.setIcon(new ImageIcon(NewSaleInsurance.class.getResource("/ar/com/tourandino/resources/calendar.png")));
		btnDate.setBounds(758, 41, 25, 25);
		panelGeneral.add(btnDate);
		
		btnSearch1 = new JButton("");
		btnSearch1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnSearch1ActionPerformed(evt);
			}
		});
		btnSearch1.setToolTipText("Buscar");
		btnSearch1.setBounds(260, 214, 25, 25);
		btnSearch1.setIcon(new ImageIcon(NewSaleInsurance.class.getResource("/ar/com/tourandino/resources/find.png")));
		panelGeneral.add(btnSearch1);
		
		btnCustAdd = new JButton("");
		btnCustAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnCustAddActionPerformed(evt);
			}
		});
		btnCustAdd.setToolTipText("Ingresar un nuevo cliente al sistema");
		btnCustAdd.setBounds(289, 214, 25, 25);
		btnCustAdd.setIcon(new ImageIcon(NewSaleInsurance.class.getResource("/ar/com/tourandino/resources/add.png")));
		panelGeneral.add(btnCustAdd);
		
		JCheckBox chbPrint = new JCheckBox("Imprimir al finalizar");
		chbPrint.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		chbPrint.setBounds(12, 446, 168, 23);
		panelGeneral.add(chbPrint);		
		
		/*
		 * INITIALIZE PASSENGER/ITINERARY PANEL
		 */
		JPanel panelDestiny = new JPanel();
		tabbedPane.addTab("Pasajeros/Seguro", null, panelDestiny, null);
		panelDestiny.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 284, 759, 181);
		panelDestiny.add(scrollPane);
		
		tablePassengers = new JTable();
		scrollPane.setViewportView(tablePassengers);
		
		JLabel lblPassenger = new JLabel("Pasajero", JLabel.RIGHT);
		lblPassenger.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblPassenger.setBounds(12, 48, 70, 15);
		panelDestiny.add(lblPassenger);
		
		JLabel lblPrice = new JLabel("Precio", JLabel.RIGHT);
		lblPrice.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblPrice.setBounds(322, 48, 70, 15);
		panelDestiny.add(lblPrice);
		
		JLabel lblSearch = new JLabel("Búsqueda", SwingConstants.RIGHT);
		lblSearch.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblSearch.setBounds(12, 17, 70, 15);
		panelDestiny.add(lblSearch);
		
		JLabel lblInsuranceName = new JLabel("Seguro", SwingConstants.RIGHT);
		lblInsuranceName.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblInsuranceName.setBounds(12, 79, 70, 15);
		panelDestiny.add(lblInsuranceName);
		
		JLabel lblCost = new JLabel("Costo", SwingConstants.RIGHT);
		lblCost.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblCost.setBounds(322, 79, 70, 15);
		panelDestiny.add(lblCost);
		
		txtPassenger = new JTextField();
		txtPassenger.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		txtPassenger.setEditable(false);
		txtPassenger.setBounds(100, 46, 200, 19);
		panelDestiny.add(txtPassenger);
		txtPassenger.setColumns(10);
		
		txtInsuranceName = new JTextField();
		txtInsuranceName.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtInsuranceName.setBounds(100, 77, 200, 19);
		panelDestiny.add(txtInsuranceName);
		txtInsuranceName.setColumns(10);
		
		txtSearch = new JTextField();
		txtSearch.setColumns(10);
		txtSearch.setBounds(100, 15, 200, 19);
		panelDestiny.add(txtSearch);
		
		txtPrice = new JTextField();
		txtPrice.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtPrice.setBounds(410, 46, 200, 19);
		panelDestiny.add(txtPrice);
		txtPrice.setColumns(10);
		
		txtCost = new JTextField();
		txtCost.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtCost.setColumns(10);
		txtCost.setBounds(410, 77, 200, 19);
		panelDestiny.add(txtCost);
		
		btnSearch = new JButton("");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearchActionPerfomed(e);
			}
		});
		btnSearch.setIcon(new ImageIcon(NewSaleInsurance.class.getResource("/ar/com/tourandino/resources/find.png")));
		btnSearch.setToolTipText("Buscar");
		btnSearch.setBounds(312, 12, 25, 25);
		panelDestiny.add(btnSearch);
		
		btnDelItinerary = new JButton("Quitar");
		btnDelItinerary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDelItineraryActionPerformed(e);
			}
		});
		btnDelItinerary.setIcon(new ImageIcon(NewSaleInsurance.class.getResource("/ar/com/tourandino/resources/delete.png")));
		btnDelItinerary.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnDelItinerary.setBounds(654, 247, 117, 25);
		panelDestiny.add(btnDelItinerary);
		
		btnAddItinerary = new JButton("Agregar");
		btnAddItinerary.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnAddItineraryActionPerformed(evt);
			}
		});
		btnAddItinerary.setIcon(new ImageIcon(NewSaleInsurance.class.getResource("/ar/com/tourandino/resources/add.png")));
		btnAddItinerary.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnAddItinerary.setBounds(525, 247, 117, 25);
		panelDestiny.add(btnAddItinerary);
		
		btnPassAdd = new JButton("");
		btnPassAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnPassAddActionPerformed(evt);
			}
		});
		btnPassAdd.setIcon(new ImageIcon(NewSaleInsurance.class.getResource("/ar/com/tourandino/resources/add.png")));
		btnPassAdd.setToolTipText("Ingresar un nuevo pasajero al sistema");
		btnPassAdd.setBounds(343, 12, 25, 25);
		panelDestiny.add(btnPassAdd);
		
		JLabel lblItinerary = new JLabel("Destino", SwingConstants.RIGHT);
		lblItinerary.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblItinerary.setBounds(12, 108, 70, 15);
		panelDestiny.add(lblItinerary);
		
		txtItinerary = new JTextField();
		txtItinerary.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtItinerary.setColumns(10);
		txtItinerary.setBounds(100, 106, 200, 19);
		panelDestiny.add(txtItinerary);
		
		JLabel lblNote = new JLabel("Descripción", SwingConstants.RIGHT);
		lblNote.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblNote.setBounds(12, 139, 70, 15);
		panelDestiny.add(lblNote);
		
		txtNote = new JTextPane();
		txtNote.setBounds(100, 137, 510, 98);
		panelDestiny.add(txtNote);
		
		/*
		 * INITIALIZE PAYMENTS PANEL
		 */
		JPanel panelPayment = new JPanel();
		tabbedPane.addTab("Forma de Pago", null, panelPayment, null);
		panelPayment.setLayout(null);
		
		JLabel lblIssuers = new JLabel("Operador");
		lblIssuers.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblIssuers.setBounds(12, 12, 100, 15);
		panelPayment.add(lblIssuers);
		
		JLabel lblTotal = new JLabel("TOTAL $");
		lblTotal.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		lblTotal.setBounds(637, 187, 124, 15);
		panelPayment.add(lblTotal);
		
		JLabel lblSubtotal = new JLabel("Subtotal $");
		lblSubtotal.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblSubtotal.setBounds(10, 187, 100, 15);
		panelPayment.add(lblSubtotal);
		
		JLabel lblDiscount = new JLabel("Descuento $");
		lblDiscount.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblDiscount.setBounds(122, 187, 100, 15);
		panelPayment.add(lblDiscount);
		
		JLabel lblTax = new JLabel("IVA %");
		lblTax.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblTax.setBounds(346, 187, 100, 15);
		panelPayment.add(lblTax);
		
		JLabel lblRate = new JLabel("Recargo %");
		lblRate.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblRate.setBounds(234, 187, 100, 15);
		panelPayment.add(lblRate);
		
		JLabel lblEfectivo = new JLabel("Efectivo $");
		lblEfectivo.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblEfectivo.setIcon(new ImageIcon(NewSaleInsurance.class.getResource("/ar/com/tourandino/resources/money.png")));
		lblEfectivo.setBounds(12, 304, 100, 15);
		panelPayment.add(lblEfectivo);
		
		JLabel lblCuenta = new JLabel("Cta. Cte. $");
		lblCuenta.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblCuenta.setIcon(new ImageIcon(NewSaleInsurance.class.getResource("/ar/com/tourandino/resources/account_balances.png")));
		lblCuenta.setBounds(122, 302, 100, 19);
		panelPayment.add(lblCuenta);
		
		JLabel lblCheque2 = new JLabel("Cheque $");
		lblCheque2.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblCheque2.setIcon(new ImageIcon(NewSaleInsurance.class.getResource("/ar/com/tourandino/resources/cheque.png")));
		lblCheque2.setBounds(460, 304, 100, 15);
		panelPayment.add(lblCheque2);
		
		JLabel lblCredito = new JLabel("Crédito $");
		lblCredito.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblCredito.setIcon(new ImageIcon(NewSaleInsurance.class.getResource("/ar/com/tourandino/resources/visa.png")));
		lblCredito.setBounds(348, 304, 100, 15);
		panelPayment.add(lblCredito);
		
		JLabel lblDebito = new JLabel("Débito $");
		lblDebito.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblDebito.setIcon(new ImageIcon(NewSaleInsurance.class.getResource("/ar/com/tourandino/resources/visa_electron.png")));
		lblDebito.setBounds(236, 304, 100, 15);
		panelPayment.add(lblDebito);
		
		JLabel lblPrecioTotal = new JLabel("Precio total $");
		lblPrecioTotal.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblPrecioTotal.setBounds(12, 43, 100, 15);
		panelPayment.add(lblPrecioTotal);
		
		JLabel lblCostoTotal = new JLabel("Costo total $");
		lblCostoTotal.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblCostoTotal.setBounds(12, 74, 100, 15);
		panelPayment.add(lblCostoTotal);
		
		JLabel lblDiferencia = new JLabel("Diferencia $");
		lblDiferencia.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblDiferencia.setBounds(12, 105, 100, 15);
		panelPayment.add(lblDiferencia);
		
		cmbIssuers = new JComboBox();
		loadCombo(cmbIssuers);
		cmbIssuers.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		cmbIssuers.setBounds(122, 10, 150, 19);
		panelPayment.add(cmbIssuers);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 173, 783, 2);
		panelPayment.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 290, 783, 2);
		panelPayment.add(separator_1);
		
		txtPriceTotal = new JTextField();
		txtPriceTotal.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		txtPriceTotal.setEditable(false);
		txtPriceTotal.setBounds(122, 41, 150, 19);
		panelPayment.add(txtPriceTotal);
		txtPriceTotal.setColumns(10);
		
		txtCostTotal = new JTextField();
		txtCostTotal.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		txtCostTotal.setEditable(false);
		txtCostTotal.setBounds(122, 72, 150, 19);
		panelPayment.add(txtCostTotal);
		txtCostTotal.setColumns(10);
		
		txtProfitTotal = new JTextField();
		txtProfitTotal.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		txtProfitTotal.setEditable(false);
		txtProfitTotal.setBounds(122, 103, 150, 19);
		panelPayment.add(txtProfitTotal);
		txtProfitTotal.setColumns(10);
		
		txtCash = new JTextField();
		txtCash.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		txtCash.setEditable(false);
		txtCash.setColumns(10);
		txtCash.setBounds(12, 332, 100, 19);
		panelPayment.add(txtCash);
		
		txtAccount = new JTextField();
		txtAccount.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		txtAccount.setEditable(false);
		txtAccount.setColumns(10);
		txtAccount.setBounds(122, 333, 100, 19);
		panelPayment.add(txtAccount);
		
		txtDebit = new JTextField();
		txtDebit.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		txtDebit.setEditable(false);
		txtDebit.setColumns(10);
		txtDebit.setBounds(234, 332, 100, 19);
		panelPayment.add(txtDebit);
		
		txtCredit = new JTextField();
		txtCredit.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		txtCredit.setEditable(false);
		txtCredit.setColumns(10);
		txtCredit.setBounds(346, 332, 100, 19);
		panelPayment.add(txtCredit);
		
		txtCheque = new JTextField();
		txtCheque.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		txtCheque.setEditable(false);
		txtCheque.setColumns(10);
		txtCheque.setBounds(460, 332, 100, 19);
		panelPayment.add(txtCheque);
		
		txtTotal = new JTextField();
		txtTotal.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		txtTotal.setEditable(false);
		txtTotal.setBounds(637, 214, 124, 19);
		panelPayment.add(txtTotal);
		txtTotal.setColumns(10);
		
		txtSubtotal = new JTextField();
		txtSubtotal.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		txtSubtotal.setEditable(false);
		txtSubtotal.setBounds(10, 214, 100, 19);
		panelPayment.add(txtSubtotal);
		txtSubtotal.setColumns(10);
		
		txtDiscount = new JTextField("0.0");
		txtDiscount.setEditable(false);
		txtDiscount.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtDiscount.setBounds(122, 214, 100, 19);
		panelPayment.add(txtDiscount);
		txtDiscount.setColumns(10);
			
		txtRate = new JTextField("0.0");
		txtRate.setEditable(false);
		txtRate.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtRate.setBounds(234, 214, 100, 19);
		panelPayment.add(txtRate);
		txtRate.setColumns(10);
		
		txtTax = new JTextField("0.0");
		txtTax.setEditable(false);
		txtTax.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtTax.setBounds(346, 214, 100, 19);
		panelPayment.add(txtTax);
		txtTax.setColumns(10);
		
		btnIssuerAdd = new JButton();
		btnIssuerAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnIssuerAddActionPerformed(evt);
			}
		});
		btnIssuerAdd.setBounds(284, 7, 24, 24);
		btnIssuerAdd.setIcon(new ImageIcon(NewSaleInsurance.class.getResource("/ar/com/tourandino/resources/add.png")));
		panelPayment.add(btnIssuerAdd);
		
		btnPayment = new JButton("Pago");
		btnPayment.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnPaymentActionPerformed(evt);
			}
		});
		btnPayment.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnPayment.setIcon(new ImageIcon(NewSaleInsurance.class.getResource("/ar/com/tourandino/resources/add.png")));
		btnPayment.setBounds(656, 329, 105, 25);
		panelPayment.add(btnPayment);
		
		JCheckBox chbTax = new JCheckBox();
		chbTax.setEnabled(false);
		chbTax.setBounds(346, 241, 100, 23);
		panelPayment.add(chbTax);
		
		JCheckBox chbRate = new JCheckBox();
		chbRate.setEnabled(false);
		chbRate.setBounds(234, 241, 100, 23);
		panelPayment.add(chbRate);
		
		JCheckBox chbDiscount = new JCheckBox();
		chbDiscount.setEnabled(false);
		chbDiscount.setBounds(122, 241, 100, 23);
		panelPayment.add(chbDiscount);
		
		btnConfirm = new JButton("Confirmar");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConfirmActionPerformed(e);
			}
		});
		btnConfirm.setIcon(new ImageIcon(NewSaleInsurance.class.getResource("/ar/com/tourandino/resources/accept.png")));
		btnConfirm.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnConfirm.setBounds(659, 528, 117, 25);
		getContentPane().add(btnConfirm);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setIcon(new ImageIcon(NewSaleInsurance.class.getResource("/ar/com/tourandino/resources/cancel.png")));
		btnCancel.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnCancel.setBounds(530, 528, 117, 25);
		getContentPane().add(btnCancel);
		
	    btnDelPayment = new JButton("Limpiar");
		btnDelPayment.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnDelPaymentActionPerformed(evt);
			}
		});
		btnDelPayment.setIcon(new ImageIcon(NewSaleInsurance.class.getResource("/ar/com/tourandino/resources/delete.png")));
		btnDelPayment.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnDelPayment.setBounds(656, 366, 105, 25);
		panelPayment.add(btnDelPayment);
	}
	
	private void displayTotal(JTextField priceTotal, JTextField costTotal, JTextField subtotal, JTextField total, JTextField profit){
		priceTotal.setText(String.valueOf(orderController.getOrder().getOrderTotal()));
		costTotal.setText(String.valueOf(orderController.getOrder().getOrderCost()));
		subtotal.setText(String.valueOf(orderController.getOrder().getOrderSubtotal()));
		total.setText(String.valueOf(orderController.getOrder().getOrderTotal()));
		profit.setText(String.valueOf(orderController.getOrder().getOrderProfit()));
	}
	
	private void displayPayments(JTextField cash, JTextField account, JTextField debit, JTextField credit, JTextField cheque){
		cash.setText(String.valueOf(orderController.getTotalCash()));
		account.setText(String.valueOf(orderController.getTotalAccount()));
		debit.setText(String.valueOf(orderController.getTotalDebit()));
		credit.setText(String.valueOf(orderController.getTotalCredit()));
		cheque.setText(String.valueOf(orderController.getTotalCheque()));
	}
	
	private void btnConfirmActionPerformed(ActionEvent evt){
		if(orderController.getCustomerController().getCustomer() != null){
			if(passengerController.getPassenger() != null){
				if(orderController.paidInFull()){
					if(orderController.getTotalCash() > 0){
						if(dailyCashRecordController.dailyRecordExist()){
							if(!dailyCashRecordController.DailyRecordIsClosed()){
								if(orderController.createInsurance(cmbIssuers.getSelectedItem()) > 0){
									JOptionPane.showMessageDialog(this, "La operacíon se completó exitosamente.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/information.png")));
									dispose();
								}
								else
									JOptionPane.showMessageDialog(this, "No se pudo completar la operación, intente nuevamente o contacte al Soporte.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
							}
							else
								JOptionPane.showMessageDialog(this, "No se pudo completar la operación. La caja ya se encuentra cerrada.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
						}
						else
							JOptionPane.showMessageDialog(this, "No se pudo completar la operación. Por favor realice la apertura de caja e intente nuevamente.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
					}
					else{
						if(orderController.createInsurance(cmbIssuers.getSelectedItem()) > 0){
							JOptionPane.showMessageDialog(this, "La operacíon se completó exitosamente.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/information.png")));
							dispose();
						}
						else
							JOptionPane.showMessageDialog(this, "No se pudo completar la operación, intente nuevamente o contacte al Soporte.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
					}
				}
				else
					JOptionPane.showMessageDialog(this, "No se pudo completar la operación. Verifique los montos e intente nuevamente.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
			}
			else
				JOptionPane.showMessageDialog(this, "No se pudo completar la operación. Verifique los pasajeros/tramos e intente nuevamente.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
		else
			JOptionPane.showMessageDialog(this, "No se pudo completar la operación. Verifique el cliente e intente nuevamente.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
	}
	
	private void btnPaymentActionPerformed(ActionEvent evt){
		NewPayment newPayment = new NewPayment(this, true, orderController);
		newPayment.setLocationRelativeTo(this);
		newPayment.setVisible(true);
		displayPayments(txtCash, txtAccount, txtDebit, txtCredit, txtCheque);
	}
	
	private void btnDelPaymentActionPerformed(ActionEvent evt){
		if(orderController.removePayment()){
			displayPayments(txtCash, txtAccount, txtDebit, txtCredit, txtCheque);
		}
	}
	
	private void btnSearch1ActionPerformed(ActionEvent evt){
		CustomerSelector customerSelector = new CustomerSelector(this, true, customerController, txtSearch1.getText());
		customerSelector.setLocationRelativeTo(this);
		customerSelector.setVisible(true);
		if(customerController.getCustomer() != null){
			txtSearch1.setText("");
			txtCustomer.setText(customerController.getCustomer().getCustomerFullname());
			txtAddress.setText(customerController.getCustomer().getCustomerAddress());
			txtTaxCondition.setText(customerController.getCustomer().getTaxCondition().getTaxConditionName());
			txtCuit.setText(customerController.getCustomer().getCustomerCuit());
		}
	}
	
	private void btnCustAddActionPerformed(ActionEvent evt){
		CustomerCreator customerCreator = new CustomerCreator(this, true, customerController);
		customerCreator.setLocationRelativeTo(this);
		customerCreator.setVisible(true);
		if(customerController.getCustomer() != null){
			orderController.getOrder().setCustomer(customerController.getCustomer());
			txtSearch1.setText("");
			txtCustomer.setText(customerController.getCustomer().getCustomerFullname());
			txtAddress.setText(customerController.getCustomer().getCustomerAddress());
			txtTaxCondition.setText(customerController.getCustomer().getTaxCondition().getTaxConditionName());
			txtCuit.setText(customerController.getCustomer().getCustomerCuit());
		}
	}
	
	private void btnSearchActionPerfomed(ActionEvent evt){
		PassengerSelector passengerSelector = new PassengerSelector(this, true, passengerController, txtSearch.getText());
		passengerSelector.setLocationRelativeTo(this);
		passengerSelector.setVisible(true);
		if(passengerController.getPassenger() != null){
			txtSearch.setText("");
			txtPassenger.setText(passengerController.getPassenger().getPassengerFullname());
		}
	}
	
	private void btnPassAddActionPerformed(ActionEvent evt){
		PassengerCreator passengerCreator = new PassengerCreator(this, true, passengerController);
		passengerCreator.setLocationRelativeTo(this);
		passengerCreator.setVisible(true);
		if(passengerController.getPassenger() != null){
			txtSearch.setText("");
			txtPassenger.setText(passengerController.getPassenger().getPassengerFullname());
		}
	}
	
	private void btnAddItineraryActionPerformed(ActionEvent evt){
		if(passengerController.getPassenger() != null){
				if(!txtPrice.getText().isEmpty()){
					if(!txtCost.getText().isEmpty()){
						try{
							orderController.addInsuranceItinerary(txtInsuranceName.getText(), txtItinerary.getText(), txtNote.getText(),
									Float.parseFloat(txtPrice.getText()), Float.parseFloat(txtCost.getText()));
							txtPassenger.setText("");
							txtInsuranceName.setText("");
							txtItinerary.setText("");
							txtNote.setText("");
							txtPrice.setText("");
							txtCost.setText("");
							loadTable(tablePassengers);
						}
						catch(NumberFormatException e){
							errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
							JOptionPane.showMessageDialog(this, "El monto ingresado es inválido, por favor ingrese un nuevo monto e intente nuevamente", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
						}
						finally{
							displayTotal(txtPriceTotal, txtCostTotal, txtSubtotal, txtTotal, txtProfitTotal);
						}
					}
					else
						JOptionPane.showMessageDialog(this, "Ingrese el costo del producto", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
				}
				else
					JOptionPane.showMessageDialog(this, "Ingrese el precio del producto", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
		else
			JOptionPane.showMessageDialog(this, "Seleccione un pasajero", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
	}
	
	private void btnDelItineraryActionPerformed(ActionEvent evt){
		try{
			int rowIndex = tablePassengers.getSelectedRow();
			int columnIndex = 0;
			orderController.removeInsuranceItinerary(Integer.parseInt(tablePassengers.getModel().getValueAt(rowIndex, columnIndex).toString()));
			loadTable(tablePassengers);
		}
		catch(ArrayIndexOutOfBoundsException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
			JOptionPane.showMessageDialog(this, "Seleccione un elemento de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
		catch(NullPointerException e1){
			errorLogController.createErrorLog(new Date(), e1.getMessage(), this.getTitle(), e1.toString());
			JOptionPane.showMessageDialog(this, "Seleccione un elemento de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
		finally{
			displayTotal(txtPriceTotal, txtCostTotal, txtSubtotal, txtTotal, txtProfitTotal);
		}
	}
	
	private void loadTable(JTable table){
		table.setModel(orderController.readInsurancePassengers());
		table.removeColumn(table.getColumnModel().getColumn(0));
	}
	
	private void loadCombo(JComboBox jComboBox){
		jComboBox.setModel(issuerController.readIssuers());
	}
	
	private void btnIssuerAddActionPerformed(ActionEvent evt){
		IssuerCreator issuerCreator = new IssuerCreator(this, true);
		issuerCreator.setLocationRelativeTo(this);
		issuerCreator.setVisible(true);
		loadCombo(cmbIssuers);
	}
	
}
