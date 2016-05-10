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

import org.tourandino.connector.MySQLConnector;
import org.tourandino.controller.ErrorLogController;
import org.tourandino.controller.OrderController;
import org.tourandino.util.Calculator;
import org.tourandino.util.DatePicker;
import org.tourandino.view.frame.Main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

public class OrderManager extends JDialog {

	private static final long serialVersionUID = 2054968089147933702L;
	private JTable tableOrders;
	private JTextField txtSearch;
	private JRadioButton rbtnIssuer;
	private JRadioButton rbtnCustomer;
	private JRadioButton rbtnType;
	private JRadioButton rbtnUser;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private ErrorLogController errorLogController;
	private OrderController orderController;
	private JTextField txtDateFrom;
	private JTextField txtDateTo;
	private JTextField txtCost;
	private JTextField txtPrice;
	private JTextField txtBenefit;

	/**
	 * Create the dialog.
	 */
	public OrderManager(JFrame parent, boolean modal) {
		super(parent, modal);
		this.orderController = new OrderController();
		this.errorLogController = new ErrorLogController();
		initializeComponents();
		loadTable(tableOrders);
		
		JButton btnExport = new JButton("Exportar");
		btnExport.setIcon(new ImageIcon(OrderManager.class.getResource("/ar/com/tourandino/resources/file_extension_pdf.png")));
		btnExport.setToolTipText("");
		btnExport.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnExport.setBounds(869, 596, 131, 25);
		getContentPane().add(btnExport);
	}
	
	private void initializeComponents(){
		setResizable(false);
		setTitle("Ventas");
		getContentPane().setBackground(new Color(255, 204, 51));
		getContentPane().setLayout(null);
		
		JButton btnExit = new JButton("Salir");
		btnExit.setToolTipText("Salir y volver a la ventana principal");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setIcon(new ImageIcon(OrderManager.class.getResource("/ar/com/tourandino/resources/door.png")));
		btnExit.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnExit.setBounds(900, 696, 100, 25);
		getContentPane().add(btnExit);
		
		JButton btnDelete = new JButton("Eliminar");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				btnDeleteActionPerformed(e);
			}
		});
		btnDelete.setIcon(new ImageIcon(OrderManager.class.getResource("/ar/com/tourandino/resources/delete.png")));
		btnDelete.setToolTipText("");
		btnDelete.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnDelete.setBounds(579, 105, 131, 25);
		getContentPane().add(btnDelete);
		
		JButton btnPrint = new JButton("Imprimir");
		btnPrint.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnPrintActionPerformed(evt);
			}
		});
		btnPrint.setIcon(new ImageIcon(OrderManager.class.getResource("/ar/com/tourandino/resources/printer.png")));
		btnPrint.setToolTipText("");
		btnPrint.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnPrint.setBounds(436, 105, 131, 25);
		getContentPane().add(btnPrint);
		
		JLabel lblSearch = new JLabel("B\u00fasqueda");
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
		txtSearch.setBounds(100, 10, 396, 19);
		getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnDetail = new JButton("Detalle");
		btnDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDetailActionPerformed(e);
			}
		});
		btnDetail.setToolTipText("");
		btnDetail.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnDetail.setBounds(865, 105, 131, 25);
		btnDetail.setIcon(new ImageIcon(OrderManager.class.getResource("/ar/com/tourandino/resources/page_white_text.png")));
		getContentPane().add(btnDetail);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 142, 988, 448);
		getContentPane().add(scrollPane);
		
		tableOrders = new JTable();
		tableOrders.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(tableOrders);
		tableOrders.setFont(new Font("Calibri", Font.PLAIN, 12));
		
		rbtnIssuer = new JRadioButton("Operador");
		buttonGroup.add(rbtnIssuer);
		rbtnIssuer.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		rbtnIssuer.setBackground(new Color(255, 204, 51));
		rbtnIssuer.setBounds(66, 37, 100, 23);
		rbtnIssuer.setSelected(true);
		getContentPane().add(rbtnIssuer);
		
		JButton btnDateFrom = new JButton("");
		btnDateFrom.setToolTipText("Ver calendario");
		btnDateFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDateFromActionPerformed(e);
			}
		});
		btnDateFrom.setIcon(new ImageIcon(OrderManager.class.getResource("/ar/com/tourandino/resources/calendar.png")));
		btnDateFrom.setBounds(274, 68, 25, 25);
		getContentPane().add(btnDateFrom);
		
		JButton btnPaymentDetail = new JButton("Ver Cobros");
		btnPaymentDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPaymentDetailActionPerformed(e);
			}
		});
		btnPaymentDetail.setIcon(new ImageIcon(OrderManager.class.getResource("/ar/com/tourandino/resources/coins.png")));
		btnPaymentDetail.setToolTipText("");
		btnPaymentDetail.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnPaymentDetail.setBounds(722, 105, 131, 25);
		getContentPane().add(btnPaymentDetail);
		
		rbtnCustomer = new JRadioButton("Cliente");
		buttonGroup.add(rbtnCustomer);
		rbtnCustomer.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		rbtnCustomer.setBackground(new Color(255, 204, 51));
		rbtnCustomer.setBounds(170, 37, 100, 23);
		getContentPane().add(rbtnCustomer);
		
		rbtnType = new JRadioButton("Tipo de vta.");
		buttonGroup.add(rbtnType);
		rbtnType.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		rbtnType.setBackground(new Color(255, 204, 51));
		rbtnType.setBounds(396, 37, 100, 23);
		getContentPane().add(rbtnType);
		
		rbtnUser = new JRadioButton("Vendedor");
		buttonGroup.add(rbtnUser);
		rbtnUser.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		rbtnUser.setBackground(new Color(255, 204, 51));
		rbtnUser.setBounds(274, 37, 100, 23);
		getContentPane().add(rbtnUser);
		
		txtDateFrom = new JTextField();
		txtDateFrom.setEditable(false);
		txtDateFrom.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtDateFrom.setColumns(10);
		txtDateFrom.setBounds(100, 71, 162, 19);
		getContentPane().add(txtDateFrom);
		
		JButton btnDateTo = new JButton("");
		btnDateTo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnDateToActionPerformed(evt);
			}
		});
		btnDateTo.setIcon(new ImageIcon(OrderManager.class.getResource("/ar/com/tourandino/resources/calendar.png")));
		btnDateTo.setToolTipText("Ver calendario");
		btnDateTo.setBounds(274, 105, 25, 25);
		getContentPane().add(btnDateTo);
		
		txtDateTo = new JTextField();
		txtDateTo.setEditable(false);
		txtDateTo.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtDateTo.setColumns(10);
		txtDateTo.setBounds(100, 108, 162, 19);
		getContentPane().add(txtDateTo);
		
		JLabel lblDateFrom = new JLabel("Desde");
		lblDateFrom.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblDateFrom.setBounds(12, 73, 70, 15);
		getContentPane().add(lblDateFrom);
		
		JLabel lblDateTo = new JLabel("Hasta");
		lblDateTo.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblDateTo.setBounds(12, 110, 70, 15);
		getContentPane().add(lblDateTo);
		
		JButton btnSearch = new JButton("Buscar");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearchActionPerformed(e);
			}
		});
		btnSearch.setIcon(new ImageIcon(OrderManager.class.getResource("/ar/com/tourandino/resources/magnifier.png")));
		btnSearch.setToolTipText("");
		btnSearch.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		btnSearch.setBounds(508, 7, 131, 25);
		getContentPane().add(btnSearch);
		
		JButton btnCleanFrom = new JButton("");
		btnCleanFrom.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				txtDateFrom.setText("");
			}
		});
		btnCleanFrom.setIcon(new ImageIcon(OrderManager.class.getResource("/ar/com/tourandino/resources/broom.png")));
		btnCleanFrom.setToolTipText("Limpiar fecha");
		btnCleanFrom.setBounds(311, 68, 25, 25);
		getContentPane().add(btnCleanFrom);
		
		JButton btnCleanTo = new JButton("");
		btnCleanTo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				txtDateTo.setText("");
			}
		});
		btnCleanTo.setIcon(new ImageIcon(OrderManager.class.getResource("/ar/com/tourandino/resources/broom.png")));
		btnCleanTo.setToolTipText("Limpiar fecha");
		btnCleanTo.setBounds(311, 105, 25, 25);
		getContentPane().add(btnCleanTo);
		
		txtCost = new JTextField();
		txtCost.setEditable(false);
		txtCost.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtCost.setColumns(10);
		txtCost.setBounds(100, 633, 125, 19);
		getContentPane().add(txtCost);
		
		txtPrice = new JTextField();
		txtPrice.setEditable(false);
		txtPrice.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtPrice.setColumns(10);
		txtPrice.setBounds(100, 602, 125, 19);
		getContentPane().add(txtPrice);
		
		txtBenefit = new JTextField();
		txtBenefit.setEditable(false);
		txtBenefit.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		txtBenefit.setColumns(10);
		txtBenefit.setBounds(100, 664, 125, 19);
		getContentPane().add(txtBenefit);
		
		JLabel lblCost = new JLabel("Costo");
		lblCost.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblCost.setBounds(12, 635, 70, 15);
		getContentPane().add(lblCost);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblTotal.setBounds(12, 604, 70, 15);
		getContentPane().add(lblTotal);
		
		JLabel lblBeneficio = new JLabel("Beneficio");
		lblBeneficio.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblBeneficio.setBounds(12, 666, 70, 15);
		getContentPane().add(lblBeneficio);
		setBounds(100, 100, 1024, 768);
		
	}
	
	private void btnDateFromActionPerformed(ActionEvent e){
		txtDateFrom.setText(new DatePicker(this).getPickedDate());
	}
	
	private void btnDateToActionPerformed(ActionEvent e){
		txtDateTo.setText(new DatePicker(this).getPickedDate());
	}
	
	private void loadTable(JTable table){
		table.setModel(orderController.read());
		table.removeColumn(table.getColumnModel().getColumn(0));
		Calculator calc = new Calculator();
		txtPrice.setText(String.valueOf(calc.calculateColumnTotal(table.getModel(), 5)));
		txtCost.setText(String.valueOf(calc.calculateColumnTotal(table.getModel(), 6)));
		txtBenefit.setText(String.valueOf(calc.calculateColumnTotal(table.getModel(), 7)));
    }
	
	private void loadTableByCustomer(JTable table, String customer){
		table.setModel(orderController.readByCustomer(customer));
		table.removeColumn(table.getColumnModel().getColumn(0));
		Calculator calc = new Calculator();
		txtPrice.setText(calc.calculateColumnTotal(table.getModel(), 5).toString());
		txtCost.setText(calc.calculateColumnTotal(table.getModel(), 6).toString());
		txtBenefit.setText(calc.calculateColumnTotal(table.getModel(), 7).toString());
    }
	
	private void loadTableByUser(JTable table, String search){
		table.setModel(orderController.readByUser(search));
		table.removeColumn(table.getColumnModel().getColumn(0));
		Calculator calc = new Calculator();
		txtPrice.setText(calc.calculateColumnTotal(table.getModel(), 5).toString());
		txtCost.setText(calc.calculateColumnTotal(table.getModel(), 6).toString());
		txtBenefit.setText(calc.calculateColumnTotal(table.getModel(), 7).toString());
    }
	
	private void loadTableByType(JTable table, String type){
		table.setModel(orderController.readByType(type));
		table.removeColumn(table.getColumnModel().getColumn(0));
		Calculator calc = new Calculator();
		txtPrice.setText(calc.calculateColumnTotal(table.getModel(), 5).toString());
		txtCost.setText(calc.calculateColumnTotal(table.getModel(), 6).toString());
		txtBenefit.setText(calc.calculateColumnTotal(table.getModel(), 7).toString());
    }
	
	private void loadTableByIssuer(JTable table, String search){
		table.setModel(orderController.readByIssuer(search));
		table.removeColumn(table.getColumnModel().getColumn(0));
		Calculator calc = new Calculator();
		txtPrice.setText(calc.calculateColumnTotal(table.getModel(), 5).toString());
		txtCost.setText(calc.calculateColumnTotal(table.getModel(), 6).toString());
		txtBenefit.setText(calc.calculateColumnTotal(table.getModel(), 7).toString());
    }
	
	private void loadTable(JTable table, Date dateFrom, Date dateTo){
		table.setModel(orderController.read(dateFrom, dateTo));
		table.removeColumn(table.getColumnModel().getColumn(0));
		Calculator calc = new Calculator();
		txtPrice.setText(calc.calculateColumnTotal(table.getModel(), 5).toString());
		txtCost.setText(calc.calculateColumnTotal(table.getModel(), 6).toString());
		txtBenefit.setText(calc.calculateColumnTotal(table.getModel(), 7).toString());
    }
	
	private void loadTableByCustomer(JTable table, String customer, Date dateFrom, Date dateTo){
		table.setModel(orderController.readByCustomer(customer, dateFrom, dateTo));
		table.removeColumn(table.getColumnModel().getColumn(0));
		Calculator calc = new Calculator();
		txtPrice.setText(calc.calculateColumnTotal(table.getModel(), 5).toString());
		txtCost.setText(calc.calculateColumnTotal(table.getModel(), 6).toString());
		txtBenefit.setText(calc.calculateColumnTotal(table.getModel(), 7).toString());
    }
	
	private void loadTableByUser(JTable table, String search, Date dateFrom, Date dateTo){
		table.setModel(orderController.readByUser(search, dateFrom, dateTo));
		table.removeColumn(table.getColumnModel().getColumn(0));
		Calculator calc = new Calculator();
		txtPrice.setText(calc.calculateColumnTotal(table.getModel(), 5).toString());
		txtCost.setText(calc.calculateColumnTotal(table.getModel(), 6).toString());
		txtBenefit.setText(calc.calculateColumnTotal(table.getModel(), 7).toString());
    }
	
	private void loadTableByType(JTable table, String type, Date dateFrom, Date dateTo){
		table.setModel(orderController.readByType(type, dateFrom, dateTo));
		table.removeColumn(table.getColumnModel().getColumn(0));
		Calculator calc = new Calculator();
		txtPrice.setText(calc.calculateColumnTotal(table.getModel(), 5).toString());
		txtCost.setText(calc.calculateColumnTotal(table.getModel(), 6).toString());
		txtBenefit.setText(calc.calculateColumnTotal(table.getModel(), 7).toString());
    }
	
	private void loadTableByIssuer(JTable table, String search, Date dateFrom, Date dateTo){
		table.setModel(orderController.readByIssuer(search, dateFrom, dateTo));
		table.removeColumn(table.getColumnModel().getColumn(0));
		Calculator calc = new Calculator();
		txtPrice.setText(calc.calculateColumnTotal(table.getModel(), 5).toString());
		txtCost.setText(calc.calculateColumnTotal(table.getModel(), 6).toString());
		txtBenefit.setText(calc.calculateColumnTotal(table.getModel(), 7).toString());
    }
	
	private void btnDetailActionPerformed(ActionEvent evt){
		try{
			int columnIndex = 0;
			int rowIndex = tableOrders.getSelectedRow();
			Integer id = Integer.parseInt(tableOrders.getModel().getValueAt(rowIndex, columnIndex).toString());
			OrderReader orderReader = new OrderReader(this, true, orderController, id);
			orderReader.setLocationRelativeTo(this);
			orderReader.setVisible(true);
		}
		catch(ArrayIndexOutOfBoundsException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
			JOptionPane.showMessageDialog(this, "Seleccione un elemento de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
		catch(NullPointerException e1){
			errorLogController.createErrorLog(new Date(), e1.getMessage(), this.getTitle(), e1.toString());
			JOptionPane.showMessageDialog(this, "Seleccione un elemento de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
	}
	
	private void btnDeleteActionPerformed(ActionEvent evt){
		try{
			int columnIndex = 0;
			int rowIndex = tableOrders.getSelectedRow();
			Integer id = Integer.parseInt(tableOrders.getModel().getValueAt(rowIndex, columnIndex).toString());
			orderController.delete(id);
			btnSearchActionPerformed(evt);
		}
		catch(ArrayIndexOutOfBoundsException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
			JOptionPane.showMessageDialog(this, "Seleccione un elemento de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
		catch(NullPointerException e1){
			errorLogController.createErrorLog(new Date(), e1.getMessage(), this.getTitle(), e1.toString());
			JOptionPane.showMessageDialog(this, "Seleccione un elemento de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
	}
	
	private void btnPrintActionPerformed(ActionEvent evt){
		try{
			int columnIndex = 0;
			int rowIndex = tableOrders.getSelectedRow();
			Integer id = Integer.parseInt(tableOrders.getModel().getValueAt(rowIndex, columnIndex).toString());
			//String reportSrcFile = "/home/romerori/test/TestInvoice.jrxml";
			
			// First, compile jrxml file.
			//JasperReport jasperReport =    JasperCompileManager.compileReport(reportSrcFile);
			
			URL jasperResURL = OrderManager.class.getResource("/ar/com/tourandino/reporting/Invoice.jasper"); 
			//JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File("/home/romerori/test/TestInvoice.jasper"));
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperResURL);
			//JasperReport report = (JasperReport) JRLoader.loadObject("reporte1.jasper");
			Connection conn = MySQLConnector.getConnection();

			// Parameters for report
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("ORDER_ID", id);

			JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);

			// Make sure the output directory exists.
			File outDir = new File("D:/output/test");
			outDir.mkdirs();

			// PDF Exporter.
			JRPdfExporter exporter = new JRPdfExporter();

			ExporterInput exporterInput = new SimpleExporterInput(print);
			
			// ExporterInput
			exporter.setExporterInput(exporterInput);

			// ExporterOutput
			SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd HHmmss");
			OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(
			        "D:/output/test/OrderReport_"
			+ format.format(Calendar.getInstance().getTime()) + ".pdf");
			
			// Output
			exporter.setExporterOutput(exporterOutput);

			//
			SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
			exporter.setConfiguration(configuration);
			exporter.exportReport();

			JOptionPane.showMessageDialog(this, "La operación se completó exitosamente, verifique la carpeta de salida", getTitle(), JOptionPane.INFORMATION_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/information.png")));
			//System.out.print("Done!");
		}
		catch(ArrayIndexOutOfBoundsException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
			JOptionPane.showMessageDialog(this, "Seleccione un elemento de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
		catch(NullPointerException e1){
			errorLogController.createErrorLog(new Date(), e1.getMessage(), this.getTitle(), e1.toString());
			JOptionPane.showMessageDialog(this, "Seleccione un elemento de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
	
	private void btnPaymentDetailActionPerformed(ActionEvent evt){
		try{
			int columnIndex = 0;
			int rowIndex = tableOrders.getSelectedRow();
			Integer id = Integer.parseInt(tableOrders.getModel().getValueAt(rowIndex, columnIndex).toString());
			OrderPaymentReader orderPaymentReader = new OrderPaymentReader(this, true, orderController, id);
			orderPaymentReader.setLocationRelativeTo(this);
			orderPaymentReader.setVisible(true);
		}
		catch(ArrayIndexOutOfBoundsException e){
			errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
			JOptionPane.showMessageDialog(this, "Seleccione un elemento de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
		catch(NullPointerException e1){
			errorLogController.createErrorLog(new Date(), e1.getMessage(), this.getTitle(), e1.toString());
			JOptionPane.showMessageDialog(this, "Seleccione un elemento de la lista", getTitle(), JOptionPane.WARNING_MESSAGE, new ImageIcon(Main.class.getResource("/ar/com/tourandino/resources/warning.png")));
		}
	}
	
	private void btnSearchActionPerformed(ActionEvent evt){
		if(!txtSearch.getText().isEmpty()){
			if(rbtnCustomer.isSelected()){
				if(!txtDateFrom.getText().isEmpty()){
					if(!txtDateTo.getText().isEmpty()){
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							loadTableByCustomer(tableOrders, txtSearch.getText(), sdf.parse(txtDateFrom.getText()), sdf.parse(txtDateTo.getText()));
						} 
						catch (ParseException e) {
							errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
						}
					}
					else
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							loadTableByCustomer(tableOrders, txtSearch.getText(), sdf.parse(txtDateFrom.getText()), new Date());
						} 
						catch (ParseException e) {
							errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
						}
				}
				else{
					if(!txtDateTo.getText().isEmpty()){
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							loadTableByCustomer(tableOrders, txtSearch.getText(), sdf.parse("01-01-2000"), sdf.parse(txtDateTo.getText()));
						} 
						catch (ParseException e) {
							errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
						}
					}
					else
						loadTableByCustomer(tableOrders, txtSearch.getText());
				}
			}
			if(rbtnType.isSelected()){
				if(!txtDateFrom.getText().isEmpty()){
					if(!txtDateTo.getText().isEmpty()){
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							loadTableByType(tableOrders, txtSearch.getText(), sdf.parse(txtDateFrom.getText()), sdf.parse(txtDateTo.getText()));
						} 
						catch (ParseException e) {
							errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
						}
					}
					else
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							loadTableByType(tableOrders, txtSearch.getText(), sdf.parse(txtDateFrom.getText()), new Date());
						} 
						catch (ParseException e) {
							errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
						}
				}
				else{
					if(!txtDateTo.getText().isEmpty()){
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							loadTable(tableOrders, sdf.parse("01-01-2000"), sdf.parse(txtDateTo.getText()));
						} 
						catch (ParseException e) {
							errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
						}
					}
					else
						loadTableByType(tableOrders, txtSearch.getText());
				}
			}
			if(rbtnUser.isSelected()){
				if(!txtDateFrom.getText().isEmpty()){
					if(!txtDateTo.getText().isEmpty()){
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							loadTableByUser(tableOrders, txtSearch.getText(), sdf.parse(txtDateFrom.getText()), sdf.parse(txtDateTo.getText()));
						} 
						catch (ParseException e) {
							errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
						}
					}
					else
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							loadTableByUser(tableOrders, txtSearch.getText(), sdf.parse(txtDateFrom.getText()), new Date());
						} 
						catch (ParseException e) {
							errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
						}
				}
				else{
					if(!txtDateTo.getText().isEmpty()){
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							loadTable(tableOrders, sdf.parse("01-01-2000"), sdf.parse(txtDateTo.getText()));
						} 
						catch (ParseException e) {
							errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
						}
					}
					else
						loadTableByUser(tableOrders, txtSearch.getText());
				}
			}
			if(rbtnIssuer.isSelected()){
				if(!txtDateFrom.getText().isEmpty()){
					if(!txtDateTo.getText().isEmpty()){
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							loadTableByIssuer(tableOrders, txtSearch.getText(), sdf.parse(txtDateFrom.getText()), sdf.parse(txtDateTo.getText()));
						} 
						catch (ParseException e) {
							errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
						}
					}
					else
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							loadTableByIssuer(tableOrders, txtSearch.getText(), sdf.parse(txtDateFrom.getText()), new Date());
						} 
						catch (ParseException e) {
							errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
						}
				}
				else{
					if(!txtDateTo.getText().isEmpty()){
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							loadTable(tableOrders, sdf.parse("01-01-2000"), sdf.parse(txtDateTo.getText()));
						} 
						catch (ParseException e) {
							errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
						}
					}
					else
						loadTableByIssuer(tableOrders, txtSearch.getText());
				}
			}	
		}
		else{
			if(!txtDateFrom.getText().isEmpty()){
				if(!txtDateTo.getText().isEmpty()){
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						loadTable(tableOrders, sdf.parse(txtDateFrom.getText()), sdf.parse(txtDateTo.getText()));
					} 
					catch (ParseException e) {
						errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
					}
				}
				else
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						loadTable(tableOrders, sdf.parse(txtDateFrom.getText()), new Date());
					} 
					catch (ParseException e) {
						errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
					}
			}
			else
				if(!txtDateTo.getText().isEmpty()){
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						loadTable(tableOrders, sdf.parse("01-01-2000"), sdf.parse(txtDateTo.getText()));
					} 
					catch (ParseException e) {
						errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
					}
				}
				else
					loadTable(tableOrders);
		}
	}
	
	private void txtSearchActionPerformed(ActionEvent evt){
		if(!txtSearch.getText().isEmpty()){
			if(rbtnCustomer.isSelected()){
				if(!txtDateFrom.getText().isEmpty()){
					if(!txtDateTo.getText().isEmpty()){
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							loadTableByCustomer(tableOrders, txtSearch.getText(), sdf.parse(txtDateFrom.getText()), sdf.parse(txtDateTo.getText()));
						} 
						catch (ParseException e) {
							errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
						}
					}
					else
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							loadTableByCustomer(tableOrders, txtSearch.getText(), sdf.parse(txtDateFrom.getText()), new Date());
						} 
						catch (ParseException e) {
							errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
						}
				}
				else{
					if(!txtDateTo.getText().isEmpty()){
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							loadTableByCustomer(tableOrders, txtSearch.getText(), sdf.parse("01-01-2000"), sdf.parse(txtDateTo.getText()));
						} 
						catch (ParseException e) {
							errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
						}
					}
					else
						loadTableByCustomer(tableOrders, txtSearch.getText());
				}
			}
			if(rbtnType.isSelected()){
				if(!txtDateFrom.getText().isEmpty()){
					if(!txtDateTo.getText().isEmpty()){
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							loadTableByType(tableOrders, txtSearch.getText(), sdf.parse(txtDateFrom.getText()), sdf.parse(txtDateTo.getText()));
						} 
						catch (ParseException e) {
							errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
						}
					}
					else
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							loadTableByType(tableOrders, txtSearch.getText(), sdf.parse(txtDateFrom.getText()), new Date());
						} 
						catch (ParseException e) {
							errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
						}
				}
				else{
					if(!txtDateTo.getText().isEmpty()){
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							loadTable(tableOrders, sdf.parse("01-01-2000"), sdf.parse(txtDateTo.getText()));
						} 
						catch (ParseException e) {
							errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
						}
					}
					else
						loadTableByType(tableOrders, txtSearch.getText());
				}
			}
			if(rbtnUser.isSelected()){
				if(!txtDateFrom.getText().isEmpty()){
					if(!txtDateTo.getText().isEmpty()){
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							loadTableByUser(tableOrders, txtSearch.getText(), sdf.parse(txtDateFrom.getText()), sdf.parse(txtDateTo.getText()));
						} 
						catch (ParseException e) {
							errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
						}
					}
					else
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							loadTableByUser(tableOrders, txtSearch.getText(), sdf.parse(txtDateFrom.getText()), new Date());
						} 
						catch (ParseException e) {
							errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
						}
				}
				else{
					if(!txtDateTo.getText().isEmpty()){
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							loadTable(tableOrders, sdf.parse("01-01-2000"), sdf.parse(txtDateTo.getText()));
						} 
						catch (ParseException e) {
							errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
						}
					}
					else
						loadTableByUser(tableOrders, txtSearch.getText());
				}
			}
			if(rbtnIssuer.isSelected()){
				if(!txtDateFrom.getText().isEmpty()){
					if(!txtDateTo.getText().isEmpty()){
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							loadTableByIssuer(tableOrders, txtSearch.getText(), sdf.parse(txtDateFrom.getText()), sdf.parse(txtDateTo.getText()));
						} 
						catch (ParseException e) {
							errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
						}
					}
					else
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							loadTableByIssuer(tableOrders, txtSearch.getText(), sdf.parse(txtDateFrom.getText()), new Date());
						} 
						catch (ParseException e) {
							errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
						}
				}
				else{
					if(!txtDateTo.getText().isEmpty()){
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							loadTable(tableOrders, sdf.parse("01-01-2000"), sdf.parse(txtDateTo.getText()));
						} 
						catch (ParseException e) {
							errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
						}
					}
					else
						loadTableByIssuer(tableOrders, txtSearch.getText());
				}
			}	
		}
		else{
			if(!txtDateFrom.getText().isEmpty()){
				if(!txtDateTo.getText().isEmpty()){
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						loadTable(tableOrders, sdf.parse(txtDateFrom.getText()), sdf.parse(txtDateTo.getText()));
					} 
					catch (ParseException e) {
						errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
					}
				}
				else
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						loadTable(tableOrders, sdf.parse(txtDateFrom.getText()), new Date());
					} 
					catch (ParseException e) {
						errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
					}
			}
			else
				if(!txtDateTo.getText().isEmpty()){
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						loadTable(tableOrders, sdf.parse("01-01-2000"), sdf.parse(txtDateTo.getText()));
					} 
					catch (ParseException e) {
						errorLogController.createErrorLog(new Date(), e.getMessage(), this.getTitle(), e.toString());
					}
				}
				else
					loadTable(tableOrders);
		}
	}
}
