package org.tourandino.view.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.tourandino.controller.CashMovementController;
import org.tourandino.controller.DailyCashRecordController;
import org.tourandino.controller.ErrorLogController;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DailyCashRecordReader extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5825672622690701576L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtDate;
	private JTextField txtOpenDate;
	private JTextField txtCloseDate;
	private JTextField txtIncome;
	private JTextField txtOutcome;
	private JTextField txtBalance;
	private JButton btnClose;
	private JTable tableCashMovements;
	private CashMovementController cashMovementController;
	private DailyCashRecordController dailyCashRecordController;
	private ErrorLogController errorLogController;

	/**
	 * Create the dialog.
	 */
	public DailyCashRecordReader(JDialog parent, boolean modal, DailyCashRecordController dailyCashRecordController, Integer id) {
		super(parent, modal);
		this.dailyCashRecordController = dailyCashRecordController;
		this.cashMovementController = new CashMovementController();
		this.errorLogController = new ErrorLogController();
		initializeComponents(id);
	}
	
	private void initializeComponents(Integer id){
		getContentPane().setBackground(new Color(255, 204, 51));
		setTitle("Movimientos de Caja");
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
		btnSalir.setIcon(new ImageIcon(DailyCashRecordReader.class.getResource("/ar/com/tourandino/resources/door.png")));
		btnSalir.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnSalir.setBounds(646, 528, 130, 25);
		getContentPane().add(btnSalir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 66, 764, 402);
		getContentPane().add(scrollPane);
		
		tableCashMovements = new JTable();
		loadCashMovementTable(tableCashMovements, id);
		scrollPane.setViewportView(tableCashMovements);
		
		JLabel lblFecha = new JLabel("Fecha", JLabel.RIGHT);
		lblFecha.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblFecha.setBounds(12, 12, 70, 15);
		getContentPane().add(lblFecha);
		
		JLabel lblApertura = new JLabel("Apertura", JLabel.RIGHT);
		lblApertura.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblApertura.setBounds(538, 10, 70, 15);
		getContentPane().add(lblApertura);
		
		txtDate = new JTextField();
		txtDate.setEditable(false);
		txtDate.setBounds(100, 10, 150, 19);
		getContentPane().add(txtDate);
		txtDate.setColumns(10);
		
		txtOpenDate = new JTextField();
		txtOpenDate.setEditable(false);
		txtOpenDate.setBounds(626, 8, 150, 19);
		getContentPane().add(txtOpenDate);
		txtOpenDate.setColumns(10);
		
		JLabel lblCierre = new JLabel("Cierre", JLabel.RIGHT);
		lblCierre.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblCierre.setBounds(538, 37, 70, 15);
		getContentPane().add(lblCierre);
		
		txtCloseDate = new JTextField();
		txtCloseDate.setEditable(false);
		txtCloseDate.setBounds(626, 35, 150, 19);
		getContentPane().add(txtCloseDate);
		txtCloseDate.setColumns(10);
		
		JLabel lblTotalIngresos = new JLabel("Total ingresos", JLabel.RIGHT);
		lblTotalIngresos.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblTotalIngresos.setBounds(12, 480, 114, 15);
		getContentPane().add(lblTotalIngresos);
		
		JLabel lblTotalEgresos = new JLabel("Total egresos", JLabel.RIGHT);
		lblTotalEgresos.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblTotalEgresos.setBounds(12, 507, 114, 15);
		getContentPane().add(lblTotalEgresos);
		
		JLabel lblBalance = new JLabel("Balance", JLabel.RIGHT);
		lblBalance.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblBalance.setBounds(12, 535, 114, 15);
		getContentPane().add(lblBalance);
		
		txtIncome = new JTextField();
		txtIncome.setEditable(false);
		txtIncome.setBounds(144, 478, 150, 19);
		getContentPane().add(txtIncome);
		txtIncome.setColumns(10);
		
		txtOutcome = new JTextField();
		txtOutcome.setEditable(false);
		txtOutcome.setBounds(144, 505, 150, 19);
		getContentPane().add(txtOutcome);
		txtOutcome.setColumns(10);
		
		txtBalance = new JTextField();
		txtBalance.setEditable(false);
		txtBalance.setBounds(144, 533, 150, 19);
		getContentPane().add(txtBalance);
		txtBalance.setColumns(10);
		
		btnClose = new JButton("Cerrar caja");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCloseActionPerformed(e);
			}
		});
		btnClose.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnClose.setEnabled(false);
		btnClose.setIcon(new ImageIcon(DailyCashRecordReader.class.getResource("/ar/com/tourandino/resources/coins.png")));
		btnClose.setBounds(646, 478, 130, 25);
		getContentPane().add(btnClose);
		loadDailyCashRecord(id);
	}
	
	private void loadCashMovementTable(JTable table, Integer id){
		table.setModel(cashMovementController.readByDailyCash(id));
		table.removeColumn(tableCashMovements.getColumnModel().getColumn(0));
	}
	
	private void loadDailyCashRecord(Integer id){
		Object[] item = dailyCashRecordController.loadDailyCashRecord(id);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
		try{
			txtDate.setText(sdf.format(item[0]));
			txtOpenDate.setText(sdf2.format(item[1]));
			if(item[2]!= null){
				txtCloseDate.setText(sdf2.format(item[2]));
			}
			else{
				btnClose.setEnabled(true);
			}
			txtIncome.setText(item[3].toString());
			txtOutcome.setText(item[4].toString());
			txtBalance.setText(item[5].toString());
		}
		catch(NullPointerException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.getCause().toString());
		}
		catch(IllegalArgumentException e1){
			errorLogController.createErrorLog(new Date(), e1.getMessage(), this.getTitle(), e1.getCause().toString());
		}
	}
	
	private void btnCloseActionPerformed(ActionEvent evt){
		if(dailyCashRecordController.getDailyCashRecord() != null){
			dailyCashRecordController.closeRecord(dailyCashRecordController.getDailyCashRecord().getDailyCashRecordId());
			loadDailyCashRecord(dailyCashRecordController.getDailyCashRecord().getDailyCashRecordId());
		}
	}

}
