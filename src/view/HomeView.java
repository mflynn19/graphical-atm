package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.ViewManager;

@SuppressWarnings("serial")
public class HomeView extends JPanel implements ActionListener {
	
	private ViewManager manager;		// manages interactions between the views, model, and database
	private JButton logoutButton;
	private JButton DepositButton;
	private JButton WithdrawlButton;
	private JButton TransferButton;
	private JButton CloseButton;
	private JButton InfoButton;
	private JLabel BalanceLabel;

	/**
	 * Constructs an instance (or objects) of the HomeView class.
	 * 
	 * @param manager
	 */
	
	public HomeView(ViewManager manager) {
		super();
		
		this.manager = manager;
		initialize();
	}
	
	///////////////////// PRIVATE METHODS /////////////////////////////////////////////
	
	/*
	 * Initializes the HomeView components.
	 */
	
	private void initialize() {
		this.setLayout(null);
		initDepositButton();
		initWithdrawlButton();
		initTransferButton();
		initInfoButton();
		initCloseButton();
		initLogoutButton();
		initBalanceLabel();
	}
	
	private void initDepositButton() {	
		DepositButton = new JButton("Deposit");
		DepositButton.setBounds(10, 10, 120, 35);
		DepositButton.addActionListener(this);
		
		this.add(DepositButton);
	}
	
	private void initWithdrawlButton() {	
		WithdrawlButton = new JButton("Withdrawl");
		WithdrawlButton.setBounds(10, 60, 120, 35);
		WithdrawlButton.addActionListener(this);
		
		this.add(WithdrawlButton);
	}
	
	private void initTransferButton() {	
		TransferButton = new JButton("Transfer");
		TransferButton.setBounds(10, 110, 120, 35);
		TransferButton.addActionListener(this);
		
		this.add(TransferButton);
	}
	
	private void initInfoButton() {	
		InfoButton = new JButton("Personal Info");
		InfoButton.setBounds(10, 160, 120, 35);
		InfoButton.addActionListener(this);
		
		this.add(InfoButton);
	}
	
	private void initCloseButton() {	
		CloseButton = new JButton("Close Account");
		CloseButton.setBounds(10, 210, 120, 35);
		CloseButton.addActionListener(this);
		
		this.add(CloseButton);
	}
	
	private void initLogoutButton() {	
		logoutButton = new JButton("Log Out");
		logoutButton.setBounds(10, 260, 120, 35);
		logoutButton.addActionListener(this);
		
		this.add(logoutButton);
	}
	
	private void initBalanceLabel() {
		//reference database and format balance as $###,####.##
		JLabel BalanceLabel = new JLabel("Balance:", SwingConstants.RIGHT);
		BalanceLabel.setBounds(150, 10, 100, 35);
		BalanceLabel.setFont(new Font("DialogInput", Font.ITALIC, 14));
		
		this.add(BalanceLabel);
	}
	
	/*
	 * HomeView is not designed to be serialized, and attempts to serialize will throw an IOException.
	 * 
	 * @param oos
	 * @throws IOException
	 */
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		throw new IOException("ERROR: The HomeView class is not serializable.");
	}
	
	///////////////////// OVERRIDDEN METHODS //////////////////////////////////////////
	
	/*
	 * Responds to button clicks and other actions performed in the HomeView.
	 * 
	 * @param e
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		if (source.equals(logoutButton)) {
			manager.shutdown();
			manager.switchTo(ATM.LOGIN_VIEW);
		}
		else {
			System.err.println("ERROR: Action command not found (" + e.getActionCommand() + ")");
		}
	}
	}
