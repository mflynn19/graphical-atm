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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ViewManager;
import model.BankAccount;

@SuppressWarnings("serial")
public class DepositView extends JPanel implements ActionListener {
	
	private ViewManager manager;		// manages interactions between the views, model, and database
	private BankAccount account;
	private JTextField DepositField;
	private JButton CancelButton;
	private JButton ConfirmButton;
	private JLabel errorMessageLabel;

	/**
	 * Constructs an instance (or object) of the CreateView class.
	 * 
	 * @param manager
	 */
	
	public DepositView(ViewManager manager) {
		super();
		
		this.manager = manager;
		initialize();
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
	
	private void deposit() {
		double amount = Double.parseDouble(DepositField.getText());
		if (manager.deposit(amount) != ATM.SUCCESS) {
			errorMessageLabel.setText("Invalid deposit amount.");
		}
		else {
			JOptionPane.showMessageDialog(null, "You deposited $" + amount + ".");

		}
		
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
		}
		if (source.equals(ConfirmButton)) {
			deposit();
			manager.switchTo(ATM.HOME_VIEW);
		}
	}
}