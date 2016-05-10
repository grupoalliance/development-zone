package org.tourandino.view.dialog;

import javax.swing.JDialog;

import java.awt.Color;

import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.tourandino.controller.DailyCashRecordController;
import org.tourandino.controller.ErrorLogController;
import org.tourandino.util.Calculator;
import org.tourandino.util.DatePicker;
import org.tourandino.view.frame.Main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DailyCashRecordManager extends JDialog {

	private static final long serialVersionUID = 2054968089147933702L;
	private JButton btnExit; 
	private JButton btnClose;
	private JButton btnRead;
	private JButton btnOpen;
	private JTable tableCashRecords;
	private ErrorLogController errorLogController;
	private DailyCashRecordController dailyCashRecordController;
	private JTextField txtDateFrom;
	private JLabel lblDateFrom;
	private JTextField txtDateTo;
	private JLabel lblDateTo;
	private JButton btnSearch;
	private JButton btnCleanFrom;
	private JButton btnCleanTo;
	private JButton btnDateFrom;
	private JButton btnDateTo;
	private JLabel lblBalance;
	private JTextField txtBalance;
	private JTextField txtOutcome;
	private JLabel lblOutcome;
	private JLabel lblIncome;
	private JTextField txtIncome;

	/**
	 * Create the dialog.
	 */
	public DailyCashRecordManager(JFrame parent, boolean modal, DailyCashRecordController dailyCashRecordController) {
		super(parent, modal);
		this.dailyCashRecordController = dailyCashRecordController;
		this.errorLogController = new ErrorLogController();
		initializeComponents();
		loadTable(tableCashRecords);
	}
	
	private void initializeComponents(){
		setResizable(false);
		setTitle("Caja Diaria");
		getContentPane().setBackground(new Color(255, 204, 51));
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 112, 764, 350);
		getContentPane().add(scrollPane);
		
		tableCashRecords = new JTable();
		tableCashRecords.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(tableCashRecords);
		tableCashRecords.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		
		btnExit = new JButton("Salir");
		btnExit.setToolTipText("Salir y volver a la ventana principal");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setIcon(new ImageIcon(DailyCashRecordManager.class.getResource("/ar/com/tourandino/resources/door.png")));
		btnExit.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnExit.setBounds(676, 528, 100, 25);
		getContentPane().add(btnExit);
		
		btnClose = new JButton("Cerrar caja");
		btnClose.setToolTipText("Cierre diario de caja");
		btnClose.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCloseActionPerformed(e);
			}
		});
		btnClose.setBounds(645, 75, 131, 25);
		btnClose.setIcon(new ImageIcon(DailyCashRecordManager.class.getResource("/ar/com/tourandino/resources/coins.png")));
		getContentPane().add(btnClose);
		
		btnRead = new JButton("Movimientos");
		btnRead.setToolTipText("Ver todos los moviemientos para la fecha seleccionada");
		btnRead.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnReadActionPerformed(e);
			}
		});
		btnRead.setIcon(new ImageIcon(DailyCashRecordManager.class.getResource("/ar/com/tourandino/resources/page_white_text.png")));
		btnRead.setBounds(502, 75, 131, 25);
		getContentPane().add(btnRead);
		
		btnOpen = new JButton("Abrir caja");
		btnOpen.setToolTipText("Apertura diaria de caja");
		btnOpen.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnOpenActionPerformed(e);
			}
		});
		btnOpen.setIcon(new ImageIcon(DailyCashRecordManager.class.getResource("/ar/com/tourandino/resources/cash_reg.png")));
		btnOpen.setBounds(359, 75, 131, 25);
		getContentPane().add(btnOpen);
		
		txtDateFrom = new JTextField();
		txtDateFrom.setEditable(false);
		txtDateFrom.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtDateFrom.setColumns(10);
		txtDateFrom.setBounds(100, 10, 133, 19);
		getContentPane().add(txtDateFrom);
		
		lblDateFrom = new JLabel("Desde");
		lblDateFrom.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblDateFrom.setBounds(12, 12, 70, 15);
		getContentPane().add(lblDateFrom);
		
		txtDateTo = new JTextField();
		txtDateTo.setEditable(false);
		txtDateTo.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtDateTo.setColumns(10);
		txtDateTo.setBounds(100, 44, 133, 19);
		getContentPane().add(txtDateTo);
		
		lblDateTo = new JLabel("Hasta");
		lblDateTo.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblDateTo.setBounds(12, 46, 70, 15);
		getContentPane().add(lblDateTo);
		
		btnSearch = new JButton("Buscar");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearchActionPerformed(e);
			}
		});
		btnSearch.setIcon(new ImageIcon(DailyCashRecordManager.class.getResource("/ar/com/tourandino/resources/magnifier.png")));
		btnSearch.setToolTipText("");
		btnSearch.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnSearch.setBounds(319, 7, 131, 25);
		getContentPane().add(btnSearch);
		
		btnCleanFrom = new JButton("");
		btnCleanFrom.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				txtDateFrom.setText("");
			}
		});
		btnCleanFrom.setIcon(new ImageIcon(DailyCashRecordManager.class.getResource("/ar/com/tourandino/resources/broom.png")));
		btnCleanFrom.setToolTipText("Ver calendario");
		btnCleanFrom.setBounds(282, 7, 25, 25);
		getContentPane().add(btnCleanFrom);
		
		btnCleanTo = new JButton("");
		btnCleanTo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				txtDateTo.setText("");
			}
		});
		btnCleanTo.setIcon(new ImageIcon(DailyCashRecordManager.class.getResource("/ar/com/tourandino/resources/broom.png")));
		btnCleanTo.setToolTipText("Ver calendario");
		btnCleanTo.setBounds(282, 41, 25, 25);
		getContentPane().add(btnCleanTo);
		
		btnDateFrom = new JButton("");
		btnDateFrom.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnDateFromActionPerformed(evt);
			}
		});
		btnDateFrom.setIcon(new ImageIcon(DailyCashRecordManager.class.getResource("/ar/com/tourandino/resources/calendar.png")));
		btnDateFrom.setToolTipText("Ver calendario");
		btnDateFrom.setBounds(245, 7, 25, 25);
		getContentPane().add(btnDateFrom);
		
		btnDateTo = new JButton("");
		btnDateTo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnDateToActionPerformed(evt);
			}
		});
		btnDateTo.setIcon(new ImageIcon(DailyCashRecordManager.class.getResource("/ar/com/tourandino/resources/calendar.png")));
		btnDateTo.setToolTipText("Ver calendario");
		btnDateTo.setBounds(245, 41, 25, 25);
		getContentPane().add(btnDateTo);
		
		lblBalance = new JLabel("Balance");
		lblBalance.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblBalance.setBounds(12, 536, 70, 15);
		getContentPane().add(lblBalance);
		
		txtBalance = new JTextField();
		txtBalance.setText("15936.0");
		txtBalance.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtBalance.setEditable(false);
		txtBalance.setColumns(10);
		txtBalance.setBounds(100, 534, 125, 19);
		getContentPane().add(txtBalance);
		
		txtOutcome = new JTextField();
		txtOutcome.setText("73334.0");
		txtOutcome.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtOutcome.setEditable(false);
		txtOutcome.setColumns(10);
		txtOutcome.setBounds(100, 503, 125, 19);
		getContentPane().add(txtOutcome);
		
		lblOutcome = new JLabel("Egreso");
		lblOutcome.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblOutcome.setBounds(12, 505, 70, 15);
		getContentPane().add(lblOutcome);
		
		lblIncome = new JLabel("Ingreso");
		lblIncome.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblIncome.setBounds(12, 474, 70, 15);
		getContentPane().add(lblIncome);
		
		txtIncome = new JTextField();
		txtIncome.setText("89270.0");
		txtIncome.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtIncome.setEditable(false);
		txtIncome.setColumns(10);
		txtIncome.setBounds(100, 472, 125, 19);
		getContentPane().add(txtIncome);
		setBounds(100, 100, 800, 600);
	}
	
	private void btnDateFromActionPerformed(ActionEvent e){
		txtDateFrom.setText(new DatePicker(this).getPickedDate());
	}
	
	private void btnDateToActionPerformed(ActionEvent e){
		txtDateTo.setText(new DatePicker(this).getPickedDate());
	}
	
	private void btnOpenActionPerformed(ActionEvent evt){
		if(!dailyCashRecordController.dailyRecordExist()){
			if(dailyCashRecordController.createRecord() > 0){
				JOptionPane.showMessageDialog(this, "La operación se completó exitosamente", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/information.png")));
				loadTable(tableCashRecords);
			}
			else{
				JOptionPane.showMessageDialog(this, "No se pudo completar la operación, intente nuevamente o contacte al Soporte.", this.getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/exclamation.png")));
			}
		}
		else{
			JOptionPane.showMessageDialog(this, "No se pudo completar la operación. La caja se encuentra abierta", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
	}
	
	private void loadTable(JTable table){
		table.setModel(dailyCashRecordController.read());
		table.removeColumn(table.getColumnModel().getColumn(0));
		Calculator calc = new Calculator();
		txtIncome.setText(calc.calculateColumnTotal(table.getModel(), 4).toString());
		txtOutcome.setText(calc.calculateColumnTotal(table.getModel(), 5).toString());
		txtBalance.setText(calc.calculateColumnTotal(table.getModel(), 6).toString());
    }
	
	private void loadTable(JTable table, Date dateFrom, Date dateTo){
		table.setModel(dailyCashRecordController.read(dateFrom, dateTo));
		table.removeColumn(table.getColumnModel().getColumn(0));
		Calculator calc = new Calculator();
		txtIncome.setText(calc.calculateColumnTotal(table.getModel(), 4).toString());
		txtOutcome.setText(calc.calculateColumnTotal(table.getModel(), 5).toString());
		txtBalance.setText(calc.calculateColumnTotal(table.getModel(), 6).toString());
    }
	
	private void btnSearchActionPerformed(ActionEvent evt){
		if(!txtDateFrom.getText().isEmpty()){
			if(!txtDateTo.getText().isEmpty()){
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					loadTable(tableCashRecords, sdf.parse(txtDateFrom.getText()), sdf.parse(txtDateTo.getText()));
				} 
				catch (ParseException e) {
					errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
				}
			}
			else
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					loadTable(tableCashRecords, sdf.parse(txtDateFrom.getText()), new Date());
				} 
				catch (ParseException e) {
					errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
				}
		}
		else{
			if(!txtDateTo.getText().isEmpty()){
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					loadTable(tableCashRecords, sdf.parse("01-01-2000"), sdf.parse(txtDateTo.getText()));
				} 
				catch (ParseException e) {
					errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
				}
			}
			else
				loadTable(tableCashRecords);
		}
	}
	
	private void btnReadActionPerformed(ActionEvent evt){
		try{
			int rowIndex = tableCashRecords.getSelectedRow();
			int columnRow = 0;
			Integer id = Integer.parseInt(String.valueOf(tableCashRecords.getModel().getValueAt(rowIndex,columnRow).toString()));
			DailyCashRecordReader dailyCashRecordReader = new DailyCashRecordReader(this, true, dailyCashRecordController, id);
			dailyCashRecordReader.setLocationRelativeTo(this);
			dailyCashRecordReader.setVisible(true);
			loadTable(tableCashRecords);
		}
		catch(ArrayIndexOutOfBoundsException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
			JOptionPane.showMessageDialog(this, "No se pudo completar la operación. Seleccione un item de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
		catch(NullPointerException e1){
			errorLogController.createErrorLog(new Date(), e1.getMessage(), this.getTitle(), e1.toString());
			JOptionPane.showMessageDialog(this, "No se pudo completar la operación. Seleccione un item de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
	}
	
	private void btnCloseActionPerformed(ActionEvent evt){
		try{
			int rowIndex = tableCashRecords.getSelectedRow();
			int columnIndex = 0;
			Integer id = Integer.parseInt(String.valueOf(tableCashRecords.getModel().getValueAt(rowIndex,columnIndex).toString()));
			dailyCashRecordController.closeRecord(id);
			loadTable(tableCashRecords);
		}
		catch(ArrayIndexOutOfBoundsException e){
				errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
				JOptionPane.showMessageDialog(this, "No se pudo completar la operación. Seleccione un item de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
		catch(NullPointerException e1){
			errorLogController.createErrorLog(new Date(), e1.getMessage(), this.getTitle(), e1.toString());
			JOptionPane.showMessageDialog(this, "No se pudo completar la operación. Seleccione un item de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
	}
}
