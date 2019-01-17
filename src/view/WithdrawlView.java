package view;

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
public class WithdrawlView extends JPanel implements ActionListener {
	
	private ViewManager manager;		// manages interactions between the views, model, and database
	private BankAccount account;
	private JTextField WithdrawlField;
	private JButton CancelButton;
	private JButton ConfirmButton;
	/**
	 * Constructs an instance (or object) of the CreateView class.
	 * 
	 * @param manager
	 */
	
	public WithdrawlView(ViewManager manager) {
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
		
		initWithdrawlField();
		initCancelButton();
		initConfirmButton();
	}
	
	private void initWithdrawlField() {
		JLabel label = new JLabel("Withdrawl Amount", SwingConstants.RIGHT);
		label.setBounds(50, 100, 150, 35);
		label.setLabelFor(WithdrawlField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		WithdrawlField = new JTextField(35);
		WithdrawlField.setBounds(205, 100, 200, 35);
		
		this.add(label);
		this.add(WithdrawlField);
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
			this.removeAll();
			this.initialize();
		}
		else if (source.equals(ConfirmButton)) {
			String amount = WithdrawlField.getText();
			double number = Double.parseDouble(amount);
			if (amount == "") {
				JOptionPane.showMessageDialog(null, "Please enter a valid amount to withdraw.");
			}
			else {
				manager.withdraw(number);
				manager.updateAcc();
				manager.switchTo(ATM.HOME_VIEW);
			}
			this.removeAll();
			this.initialize();
		}
	}
}