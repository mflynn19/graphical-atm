package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ViewManager;
import model.BankAccount;

@SuppressWarnings("serial")
public class DepositView extends JPanel implements ActionListener {
	
	private BankAccount account;			// the user's bank account
	private ViewManager manager;		// manages interactions between the views, model, and database
	private JTextField DepositField;
	private JButton CancelButton;
	private JButton ConfirmButton;
	private JLabel errorMessageLabel;
	private JLabel infoLabel;

	/**
	 * Constructs an instance (or object) of the CreateView class.
	 * 
	 * @param manager
	 */
	
	public DepositView(ViewManager manager) {
		super();
		
		this.manager = manager;
		this.errorMessageLabel = new JLabel("", SwingConstants.CENTER);
		initialize();
	}
	
	public void setMessage (BankAccount account) {
		this.account = account;
		if (this.account != null) {
			infoLabel.setText("Your Account Number: " + account.getAccountNumber() + " | " + "Balance: " + account.getFBalance());
		} 
	}
	
	///////////////////// PRIVATE METHODS /////////////////////////////////////////////
	
	/*
	 * Initializes the CreateView components.
	 */
	
	private void initialize() {
		this.setLayout(null);
		
		initDepositField();
		initCancelButton();
		initConfirmButton();
		initErrorMessageLabel();
		initInfoLabel();
	}
	
	private void initDepositField() {
		JLabel label = new JLabel("Deposit Amount", SwingConstants.RIGHT);
		label.setBounds(50, 100, 150, 35);
		label.setLabelFor(DepositField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		DepositField = new JTextField(35);
		DepositField.setBounds(205, 100, 200, 35);
		
		this.add(label);
		this.add(DepositField);
	}
	
	private void initCancelButton() {	
		CancelButton = new JButton("Cancel");
		CancelButton.setBounds(305, 170, 100, 35);
		CancelButton.addActionListener(this);
		
		this.add(CancelButton);
	}
	
	private void initConfirmButton() {	
		ConfirmButton = new JButton("Confirm");
		ConfirmButton.setBounds(205, 170, 100, 35);
		ConfirmButton.addActionListener(this);
		
		this.add(ConfirmButton);
	}
	
	private void initErrorMessageLabel() {
		errorMessageLabel.setBounds(50, 210, 500, 35);
		errorMessageLabel.setFont(new Font("DialogInput", Font.ITALIC, 14));
		errorMessageLabel.setForeground(Color.RED);
		
		this.add(errorMessageLabel);
	}
	
	private void initInfoLabel() {
		infoLabel  = new JLabel("");
		infoLabel.setBounds(10, 30, 500, 35);
		
		this.add(infoLabel);
	}
	
	/*
	 * CreateView is not designed to be serialized, and attempts to serialize will throw an IOException.
	 * 
	 * @param oos
	 * @throws IOException
	 */
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		throw new IOException("ERROR: The CreateView class is not serializable.");
	}
	
	///////////////////// OVERRIDDEN METHODS //////////////////////////////////////////
	
	/*
	 * Responds to button clicks and other actions performed in the CreateView.
	 * 
	 * @param e
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source.equals(CancelButton)) {
			DepositField.setText(null);
			manager.switchTo(ATM.HOME_VIEW);
			this.removeAll();
			this.initialize();
		}
		if (source.equals(ConfirmButton)) {
			try {
				double amount = Double.parseDouble(DepositField.getText());
				if (manager.deposit(amount) != ATM.SUCCESS) {
					errorMessageLabel.setText("Invalid deposit amount.");
				}
				else {
					manager.updateAcc(null);
					manager.sendBankAccount(account, "home");
					manager.switchTo(ATM.HOME_VIEW);
				}
				this.removeAll();
				this.initialize();
			}
		catch (NumberFormatException e2) {
			errorMessageLabel.setText("Invalid input.");
		}
	}
}
}