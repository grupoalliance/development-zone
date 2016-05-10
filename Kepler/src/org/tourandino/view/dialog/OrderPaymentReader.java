package org.tourandino.view.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.tourandino.controller.ErrorLogController;
import org.tourandino.controller.OrderController;
import org.tourandino.controller.PaymentController;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderPaymentReader extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5825672622690701576L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtDate;
	private JTextField txtCustomer;
	private JTextField txtUser;
	private JTextField txtTotal;
	private JTextField txtCost;
	private JTextField txtProfit;
	private JTable tableCashMovements;
	private OrderController orderController;
	private PaymentController paymentController;
	private ErrorLogController errorLogController;
	private JTextField txtTime;
	private JTextField txtIssuer;

	/**
	 * Create the dialog.
	 */
	public OrderPaymentReader(JDialog parent, boolean modal, OrderController orderController, Integer id) {
		super(parent, modal);
		this.orderController = orderController;
		this.errorLogController = new ErrorLogController();
		this.paymentController = new PaymentController();
		initializeComponents(id);
		load(id);
	}
	
	private void initializeComponents(Integer id){
		getContentPane().setBackground(new Color(255, 204, 51));
		setTitle("Cobros por Venta");
		setResizable(false);
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		contentPanel.setBackground(new Color(255, 204, 51));
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setIcon(new ImageIcon(OrderPaymentReader.class.getResource("/ar/com/tourandino/resources/door.png")));
		btnSalir.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnSalir.setBounds(646, 528, 130, 25);
		getContentPane().add(btnSalir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 66, 764, 402);
		getContentPane().add(scrollPane);
		
		tableCashMovements = new JTable();
		
		scrollPane.setViewportView(tableCashMovements);
		
		JLabel lblFecha = new JLabel("Fecha", JLabel.RIGHT);
		lblFecha.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblFecha.setBounds(12, 12, 70, 15);
		getContentPane().add(lblFecha);
		
		JLabel lblCustomer = new JLabel("Cliente", JLabel.RIGHT);
		lblCustomer.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblCustomer.setBounds(488, 12, 70, 15);
		getContentPane().add(lblCustomer);
		
		txtDate = new JTextField();
		txtDate.setEditable(false);
		txtDate.setBounds(100, 10, 200, 19);
		getContentPane().add(txtDate);
		txtDate.setColumns(10);
		
		txtCustomer = new JTextField();
		txtCustomer.setEditable(false);
		txtCustomer.setBounds(576, 8, 200, 19);
		getContentPane().add(txtCustomer);
		txtCustomer.setColumns(10);
		
		JLabel lblUser = new JLabel("Vendedor", JLabel.RIGHT);
		lblUser.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblUser.setBounds(488, 39, 70, 15);
		getContentPane().add(lblUser);
		
		txtUser = new JTextField();
		txtUser.setEditable(false);
		txtUser.setBounds(576, 35, 200, 19);
		getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total", JLabel.RIGHT);
		lblTotal.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblTotal.setBounds(12, 480, 114, 15);
		getContentPane().add(lblTotal);
		
		JLabel lblCost = new JLabel("Costo", JLabel.RIGHT);
		lblCost.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblCost.setBounds(12, 507, 114, 15);
		getContentPane().add(lblCost);
		
		JLabel lblProfit = new JLabel("Diferencia", JLabel.RIGHT);
		lblProfit.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblProfit.setBounds(12, 535, 114, 15);
		getContentPane().add(lblProfit);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(144, 478, 200, 19);
		getContentPane().add(txtTotal);
		txtTotal.setColumns(10);
		
		txtCost = new JTextField();
		txtCost.setEditable(false);
		txtCost.setBounds(144, 505, 200, 19);
		getContentPane().add(txtCost);
		txtCost.setColumns(10);
		
		txtProfit = new JTextField();
		txtProfit.setEditable(false);
		txtProfit.setBounds(144, 533, 200, 19);
		getContentPane().add(txtProfit);
		txtProfit.setColumns(10);
		
		JLabel lblTime = new JLabel("Hora", SwingConstants.RIGHT);
		lblTime.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblTime.setBounds(12, 41, 70, 15);
		getContentPane().add(lblTime);
		
		txtTime = new JTextField();
		txtTime.setText((String) null);
		txtTime.setEditable(false);
		txtTime.setColumns(10);
		txtTime.setBounds(100, 39, 200, 19);
		getContentPane().add(txtTime);
		
		JLabel lblIssuer = new JLabel("Operador", SwingConstants.RIGHT);
		lblIssuer.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblIssuer.setBounds(488, 480, 70, 15);
		getContentPane().add(lblIssuer);
		
		txtIssuer = new JTextField();
		txtIssuer.setEditable(false);
		txtIssuer.setColumns(10);
		txtIssuer.setBounds(576, 476, 200, 19);
		getContentPane().add(txtIssuer);
		load(id);
	}
	
	private void loadTable(JTable table, Integer id){
		table.setModel(paymentController.read(id));
		table.removeColumn(table.getColumnModel().getColumn(0));
	}
	
	private void load(Integer id){
		Object[] item = orderController.read(id);
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
		try{
			txtDate.setText(sdfDate.format(item[1]));
			txtTime.setText(sdfTime.format(item[2]));
			txtCost.setText(item[3].toString());
			txtTotal.setText(item[4].toString());
			txtProfit.setText(item[5].toString());
			txtCustomer.setText(item[6].toString());
			txtIssuer.setText(item[7].toString());
			txtUser.setText(item[8].toString());
			loadTable(tableCashMovements, Integer.parseInt(item[0].toString()));
		}
		catch(NullPointerException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
		}
		catch(IllegalArgumentException e1){
			errorLogController.createErrorLog(new Date(), e1.getMessage(), this.getTitle(), e1.toString());
		}
	}
}
