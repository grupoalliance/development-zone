package org.tourandino.view.frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import org.tourandino.util.Message;
import org.tourandino.view.dialog.AboutDialog;
import org.tourandino.view.dialog.AccountManagerDialog;

/**
 * 
 * @author romerori
 * @creation Dec 24, 2015
 * @class Main
 *
 */
public class Main {

	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu mnHome;
	private JMenuItem mniLogin;
	private JMenuItem mniLogout;
	private JMenuItem mniQuit;
	private JMenu mnCash;
	private JMenuItem mniOpen;
	private JMenuItem mniIncome;
	private JMenuItem mniCashHistory;
	private JMenu mnSales;
	private JMenuItem mniFlight;
	private JMenuItem mniBusTrip;
	private JMenuItem mniHotel;
	private JMenuItem mniPackage;
	private JMenuItem mniInsurance;
	private JMenuItem mniSalesList;
	private JMenuItem mniPassengers;
	private JMenu mnCustomers;
	private JMenuItem mniCustomerAccounts;
	private JMenuItem mniCustomerList;
	private JMenu mnIssuers;
	private JMenuItem mniIssuerAccounts;
	private JMenuItem mniIssuerList;
	private JMenu mnOutcomes;
	private JMenuItem mniNewOutcome;
	private JMenuItem mniOutcomeHistory;
	private JMenu mnSystem;
	private JMenuItem mniUsers;
	private JMenuItem mniError;
	private JMenu mnHelp;
	private JMenuItem mniAbout;
	private JMenu mnTest;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("TOUR ANDINO");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/org/tourandino/resources/img/logo.png")));
		frame.setResizable(false);
		frame.setBounds(100, 100, 960, 540);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent e) {
		        closeActionPerformed();
		      }
		    });
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 960, 23);
		frame.getContentPane().add(menuBar);
		
		mnHome = new JMenu("Inicio");
		menuBar.add(mnHome);
		
		mniLogin = new JMenuItem("Iniciar sesi\u00f3n");
		mnHome.add(mniLogin);
		
		mniLogout = new JMenuItem("Cerrar sesi\u00f3n");
		mnHome.add(mniLogout);
		
		mniQuit = new JMenuItem("Salir");
		mniQuit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				closeActionPerformed();
			}
		});
		mnHome.add(mniQuit);
		
		mnCash = new JMenu("Caja");
		menuBar.add(mnCash);
		
		mniOpen = new JMenuItem("Abrir Caja");
		mnCash.add(mniOpen);
		
		mniIncome = new JMenuItem("Ingreso manual de dinero");
		mnCash.add(mniIncome);
		
		mniCashHistory = new JMenuItem("Historial");
		mnCash.add(mniCashHistory);
		
		mnSales = new JMenu("Ventas");
		menuBar.add(mnSales);
		
		mniFlight = new JMenuItem("Aereos");
		mnSales.add(mniFlight);
		
		mniBusTrip = new JMenuItem("Colectivos");
		mnSales.add(mniBusTrip);
		
		mniHotel = new JMenuItem("Hoteles");
		mnSales.add(mniHotel);
		
		mniPackage = new JMenuItem("Paquetes");
		mnSales.add(mniPackage);
		
		mniInsurance = new JMenuItem("Seguros");
		mnSales.add(mniInsurance);
		
		mniPassengers = new JMenuItem("Pasajeros");
		mnSales.add(mniPassengers);
		
		mniSalesList = new JMenuItem("Listado de Ventas");
		mnSales.add(mniSalesList);
		
		mnCustomers = new JMenu("Clientes");
		menuBar.add(mnCustomers);
		
		mniCustomerAccounts = new JMenuItem("Estado de Cuentas");
		mnCustomers.add(mniCustomerAccounts);
		
		mniCustomerList = new JMenuItem("Listado de Clientes");
		mnCustomers.add(mniCustomerList);
		
		mnIssuers = new JMenu("Operadores");
		menuBar.add(mnIssuers);
		
		mniIssuerAccounts = new JMenuItem("Ingreso de facturas");
		mnIssuers.add(mniIssuerAccounts);
		
		mniIssuerList = new JMenuItem("Listado de Operadores");
		mnIssuers.add(mniIssuerList);
		
		mnOutcomes = new JMenu("Gastos");
		menuBar.add(mnOutcomes);
		
		mniNewOutcome = new JMenuItem("Pago de gastos");
		mnOutcomes.add(mniNewOutcome);
		
		mniOutcomeHistory = new JMenuItem("Historial");
		mnOutcomes.add(mniOutcomeHistory);
		
		mnSystem = new JMenu("Sistema");
		menuBar.add(mnSystem);
		
		mniUsers = new JMenuItem("Usuarios");
		mnSystem.add(mniUsers);
		
		mniError = new JMenuItem("Errores");
		mnSystem.add(mniError);
		
		mnHelp = new JMenu("Ayuda");
		menuBar.add(mnHelp);
		
		mniAbout = new JMenuItem("Acerca de...");
		mnHelp.add(mniAbout);
		
		mnTest = new JMenu("TEST");
		menuBar.add(mnTest);
		
		JMenuItem mniAboutDialog = new JMenuItem("AboutDialog");
		mniAboutDialog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutDialog ad = new AboutDialog(frame, true);
				ad.setVisible(true);
			}
		});
		mnTest.add(mniAboutDialog);
		
		JMenuItem mniAccountManagerDialog = new JMenuItem("AccountManagerDialog");
		mniAccountManagerDialog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountManagerDialog amd = new AccountManagerDialog(frame, true);
				amd.setVisible(true);
			}
		});
		mnTest.add(mniAccountManagerDialog);
		
	}
	
	private void closeActionPerformed(){
		Message msg = new Message(frame);
		if ( msg.questionMessage() == 0) {
			frame.dispose();
		}
	}
	
	private void populateMenu(){
		mniLogin.setVisible(false);
		mniLogout.setVisible(true);
		mnCash.setVisible(true);
		mnSales.setVisible(true);
		mnCustomers.setVisible(true);
		mnIssuers.setVisible(true);
		mnOutcomes.setVisible(true);
		mnSystem.setVisible(true);
		mnHelp.setVisible(true);
	}
	
	private void cleanMenu(){
		mniLogin.setVisible(true);
		mniLogout.setVisible(false);
		mnCash.setVisible(false);
		mnSales.setVisible(false);
		mnCustomers.setVisible(false);
		mnIssuers.setVisible(false);
		mnOutcomes.setVisible(false);
		mnSystem.setVisible(false);
		mnHelp.setVisible(false);
	}
	
}
