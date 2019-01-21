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
public class TransferView extends JPanel implements ActionListener {
	
	private ViewManager manager;		// manages interactions between the views, model, and database
	private JButton CancelButton;
	private JButton ConfirmButton;
	private JTextField TransferField;
	private JTextField DestinationField;
	private JLabel errorMessageLabel;
	
	/**
	 * Constructs an instance (or object) of the CreateView class.
	 * 
	 * @param manager
	 */
	
	public TransferView(ViewManager manager) {
		super();
		
		this.manager = manager;
		this.errorMessageLabel = new JLabel("", SwingConstants.CENTER);
		initialize();
	}
	
	///////////////////// PRIVATE METHODS /////////////////////////////////////////////
	
	/*
	 * Initializes the CreateView components.
	 */
	
	private void initialize() {
		this.setLayout(null);
		
		initTransferField();
		initDestinationField();
		initCancelButton();
		initConfirmButton();
		initErrorMessageLabel();
	}
	
	private void initTransferField() {
		JLabel label = new JLabel("Transfer Amount:", SwingConstants.RIGHT);
		label.setBounds(50, 100, 150, 35);
		label.setLabelFor(TransferField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		TransferField = new JTextField(35);
		TransferField.setBounds(205, 100, 200, 35);
		
		this.add(label);
		this.add(TransferField);
	}
	
	private void initDestinationField() {
		JLabel label = new JLabel("Account Recieving:", SwingConstants.RIGHT);
		label.setBounds(50, 150, 150, 35);
		label.setLabelFor(DestinationField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		DestinationField = new JTextField(35);
		DestinationField.setBounds(205, 150, 200, 35);
		
		this.add(label);
		this.add(DestinationField);
	}
	
	private void initCancelButton() {	
		CancelButton = new JButton("Cancel");
		CancelButton.setBounds(305, 200, 100, 35);
		CancelButton.addActionListener(this);
		
		this.add(CancelButton);
	}
	
	private void initConfirmButton() {	
		ConfirmButton = new JButton("Confirm");
		ConfirmButton.setBounds(205, 200, 100, 35);
		ConfirmButton.addActionListener(this);
		
		this.add(ConfirmButton);
	}
	
	private void initErrorMessageLabel() {
		errorMessageLabel.setBounds(205, 240, 250, 35);
		errorMessageLabel.setFont(new Font("DialogInput", Font.ITALIC, 14));
		errorMessageLabel.setForeground(Color.RED);
		
		this.add(errorMessageLabel);
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
			manager.switchTo(ATM.HOME_VIEW);
		}
		if (source.equals(ConfirmButton)) {
			double amount = Double.parseDouble(TransferField.getText());
			long otherAcc = Long.parseLong(DestinationField.getText());
			BankAccount destination = manager.getTransferAccount(otherAcc);
			if (manager.transfer(destination, amount) != ATM.SUCCESS) {
				errorMessageLabel.setText("Invalid transfer amount or account number.");
			}
			else {
				System.out.println("from transfer view" + destination);
				manager.updateAcc();
				manager.updateTransAcc();
				manager.switchTo(ATM.HOME_VIEW);
			}
			this.removeAll();
			this.initialize();
		}
	}
}