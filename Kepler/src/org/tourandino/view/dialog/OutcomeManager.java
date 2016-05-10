package org.tourandino.view.dialog;

import javax.swing.JDialog;

import java.awt.Color;

import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.tourandino.controller.CashMovementController;
import org.tourandino.controller.ErrorLogController;
import org.tourandino.util.Calculator;
import org.tourandino.util.DatePicker;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OutcomeManager extends JDialog {

	private static final long serialVersionUID = 2054968089147933702L;
	private JTable tableOutcomes;
	private JTextField txtSearch;
	private ErrorLogController errorLogController;
	private CashMovementController cashMovementController;
	private JTextField txtDateFrom;
	private JTextField txtDateTo;
	private JTextField txtTotal;

	/**
	 * Create the dialog.
	 */
	public OutcomeManager(JFrame parent, boolean modal) {
		super(parent, modal);
		this.cashMovementController = new CashMovementController();
		this.errorLogController = new ErrorLogController();
		initializeComponents();
		loadTable(tableOutcomes);
	}
	
	private void initializeComponents(){
		setResizable(false);
		setTitle("Historial de Pagos");
		getContentPane().setBackground(new Color(255, 204, 51));
		getContentPane().setLayout(null);
		
		JButton btnExit = new JButton("Salir");
		btnExit.setToolTipText("Cierra esta ventana y vuelve al menú principal");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setIcon(new ImageIcon(OutcomeManager.class.getResource("/ar/com/tourandino/resources/door.png")));
		btnExit.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnExit.setBounds(676, 528, 100, 25);
		getContentPane().add(btnExit);
		
		JLabel lblSearch = new JLabel("Búsqueda");
		lblSearch.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblSearch.setBounds(12, 12, 70, 15);
		getContentPane().add(lblSearch);
		
		txtSearch = new JTextField();
		txtSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSearchActionPerformed(e);
			}
		});
		txtSearch.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtSearch.setBounds(100, 10, 207, 19);
		getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnAddOutcome = new JButton("Ingresar");
		btnAddOutcome.setToolTipText("Ingresa un nuevo pago realizado");
		btnAddOutcome.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnAddOutcome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddOutcomeActionPerformed(e);
			}
		});
		btnAddOutcome.setBounds(645, 73, 131, 25);
		btnAddOutcome.setIcon(new ImageIcon(OutcomeManager.class.getResource("/ar/com/tourandino/resources/add.png")));
		getContentPane().add(btnAddOutcome);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 110, 764, 406);
		getContentPane().add(scrollPane);
		
		tableOutcomes = new JTable();
		tableOutcomes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(tableOutcomes);
		tableOutcomes.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		
		JLabel lblDateFrom = new JLabel("Desde");
		lblDateFrom.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblDateFrom.setBounds(12, 44, 70, 15);
		getContentPane().add(lblDateFrom);
		
		txtDateFrom = new JTextField();
		txtDateFrom.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtDateFrom.setEditable(false);
		txtDateFrom.setColumns(10);
		txtDateFrom.setBounds(100, 42, 133, 19);
		getContentPane().add(txtDateFrom);
		
		JButton btnDateFrom = new JButton("");
		btnDateFrom.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnDateFromActionPerformed(evt);
			}
		});
		btnDateFrom.setIcon(new ImageIcon(OutcomeManager.class.getResource("/ar/com/tourandino/resources/calendar.png")));
		btnDateFrom.setToolTipText("Ver calendario");
		btnDateFrom.setBounds(245, 39, 25, 25);
		getContentPane().add(btnDateFrom);
		
		JButton btnCleanFrom = new JButton("");
		btnCleanFrom.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				txtDateTo.setText("");
			}
		});
		btnCleanFrom.setIcon(new ImageIcon(OutcomeManager.class.getResource("/ar/com/tourandino/resources/broom.png")));
		btnCleanFrom.setToolTipText("Limpia el campo fecha");
		btnCleanFrom.setBounds(282, 39, 25, 25);
		getContentPane().add(btnCleanFrom);
		
		JButton btnCleanTo = new JButton("");
		btnCleanTo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				txtDateFrom.setText("");
			}
		});
		btnCleanTo.setIcon(new ImageIcon(OutcomeManager.class.getResource("/ar/com/tourandino/resources/broom.png")));
		btnCleanTo.setToolTipText("Limpia el campo fecha");
		btnCleanTo.setBounds(282, 73, 25, 25);
		getContentPane().add(btnCleanTo);
		
		JButton btnDateTo = new JButton("");
		btnDateTo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnDateToActionPerformed(evt);
			}
		});
		btnDateTo.setIcon(new ImageIcon(OutcomeManager.class.getResource("/ar/com/tourandino/resources/calendar.png")));
		btnDateTo.setToolTipText("Ver calendario");
		btnDateTo.setBounds(245, 73, 25, 25);
		getContentPane().add(btnDateTo);
		
		txtDateTo = new JTextField();
		txtDateTo.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtDateTo.setEditable(false);
		txtDateTo.setColumns(10);
		txtDateTo.setBounds(100, 76, 133, 19);
		getContentPane().add(txtDateTo);
		
		JLabel lblDateTo = new JLabel("Hasta");
		lblDateTo.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblDateTo.setBounds(12, 78, 70, 15);
		getContentPane().add(lblDateTo);
		
		JButton btnSearch = new JButton("Buscar");
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnSearchActionPerformed(evt);
			}
		});
		btnSearch.setIcon(new ImageIcon(OutcomeManager.class.getResource("/ar/com/tourandino/resources/magnifier.png")));
		btnSearch.setToolTipText("");
		btnSearch.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnSearch.setBounds(319, 7, 131, 25);
		getContentPane().add(btnSearch);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblTotal.setBounds(12, 533, 70, 15);
		getContentPane().add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setText("89270.0");
		txtTotal.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		txtTotal.setBounds(100, 531, 125, 19);
		getContentPane().add(txtTotal);
		setBounds(100, 100, 800, 600);
	}
	
	private void btnDateFromActionPerformed(ActionEvent e){
		txtDateFrom.setText(new DatePicker(this).getPickedDate());
	}
	
	private void btnDateToActionPerformed(ActionEvent e){
		txtDateTo.setText(new DatePicker(this).getPickedDate());
	}
	
	private void loadTable(JTable table){
		table.setModel(cashMovementController.read());
		table.removeColumn(table.getColumnModel().getColumn(0));
		Calculator calc = new Calculator();
		txtTotal.setText(String.valueOf(calc.calculateColumnTotal(table.getModel(), 4)));
    }
	
	private void loadTable(JTable table, Date dateFrom, Date dateTo){
		table.setModel(cashMovementController.read(dateFrom, dateTo));
		table.removeColumn(table.getColumnModel().getColumn(0));
		Calculator calc = new Calculator();
		txtTotal.setText(String.valueOf(calc.calculateColumnTotal(table.getModel(), 4)));
    }
	
	private void loadTable(JTable table, String search){
		table.setModel(cashMovementController.read(search));
		table.removeColumn(table.getColumnModel().getColumn(0));
		Calculator calc = new Calculator();
		txtTotal.setText(String.valueOf(calc.calculateColumnTotal(table.getModel(), 4)));
    }
	
	private void loadTable(JTable table, String search, Date dateFrom, Date dateTo){
		table.setModel(cashMovementController.read(search, dateFrom, dateTo));
		table.removeColumn(table.getColumnModel().getColumn(0));
		Calculator calc = new Calculator();
		txtTotal.setText(String.valueOf(calc.calculateColumnTotal(table.getModel(), 4)));
    }
	
	private void txtSearchActionPerformed(ActionEvent evt){
		if(!txtSearch.getText().isEmpty()){
			if(!txtDateFrom.getText().isEmpty()){
				if(!txtDateTo.getText().isEmpty()){
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						loadTable(tableOutcomes, txtSearch.getText(), sdf.parse(txtDateFrom.getText()), sdf.parse(txtDateTo.getText()));
					} 
					catch (ParseException e) {
						errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
					}
				}
				else
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						loadTable(tableOutcomes, txtSearch.getText(), sdf.parse(txtDateFrom.getText()), new Date());
					} 
				catch (ParseException e) {
					errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
				}
			}
			else{
				if(!txtDateTo.getText().isEmpty()){
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						loadTable(tableOutcomes, txtSearch.getText(), sdf.parse("01-01-2000"), sdf.parse(txtDateTo.getText()));
					} 
					catch (ParseException e) {
						errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
					}
				}
				else
					loadTable(tableOutcomes, txtSearch.getText());
			}	
		}
		else{
			if(!txtDateFrom.getText().isEmpty()){
				if(!txtDateTo.getText().isEmpty()){
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						loadTable(tableOutcomes, sdf.parse(txtDateFrom.getText()), sdf.parse(txtDateTo.getText()));
					} 
					catch (ParseException e) {
						errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
					}
				}
				else
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						loadTable(tableOutcomes, sdf.parse(txtDateFrom.getText()), new Date());
					} 
					catch (ParseException e) {
						errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
					}
			}
			else
				if(!txtDateTo.getText().isEmpty()){
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						loadTable(tableOutcomes, sdf.parse("01-01-2000"), sdf.parse(txtDateTo.getText()));
					} 
					catch (ParseException e) {
						errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
					}
				}
				else
					loadTable(tableOutcomes);
		}
	}
	
	private void btnSearchActionPerformed(ActionEvent evt){
		if(!txtSearch.getText().isEmpty()){
			if(!txtDateFrom.getText().isEmpty()){
				if(!txtDateTo.getText().isEmpty()){
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						loadTable(tableOutcomes, txtSearch.getText(), sdf.parse(txtDateFrom.getText()), sdf.parse(txtDateTo.getText()));
					} 
					catch (ParseException e) {
						errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
					}
				}
				else
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						loadTable(tableOutcomes, txtSearch.getText(), sdf.parse(txtDateFrom.getText()), new Date());
					} 
				catch (ParseException e) {
					errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
				}
			}
			else{
				if(!txtDateTo.getText().isEmpty()){
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						loadTable(tableOutcomes, txtSearch.getText(), sdf.parse("01-01-2000"), sdf.parse(txtDateTo.getText()));
					} 
					catch (ParseException e) {
						errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
					}
				}
				else
					loadTable(tableOutcomes, txtSearch.getText());
			}	
		}
		else{
			if(!txtDateFrom.getText().isEmpty()){
				if(!txtDateTo.getText().isEmpty()){
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						loadTable(tableOutcomes, sdf.parse(txtDateFrom.getText()), sdf.parse(txtDateTo.getText()));
					} 
					catch (ParseException e) {
						errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
					}
				}
				else
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						loadTable(tableOutcomes, sdf.parse(txtDateFrom.getText()), new Date());
					} 
					catch (ParseException e) {
						errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
					}
			}
			else
				if(!txtDateTo.getText().isEmpty()){
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						loadTable(tableOutcomes, sdf.parse("01-01-2000"), sdf.parse(txtDateTo.getText()));
					} 
					catch (ParseException e) {
						errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
					}
				}
				else
					loadTable(tableOutcomes);
		}
	}
	
	private void btnAddOutcomeActionPerformed(ActionEvent evt){
		NewOutcome newOutcome = new NewOutcome(this, true);
		newOutcome.setLocationRelativeTo(this);
		newOutcome.setVisible(true);
		loadTable(tableOutcomes);
	}
}
