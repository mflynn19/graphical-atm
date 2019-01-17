package view;

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
public class InformationView extends JPanel implements ActionListener {
	
	private ViewManager manager;		// manages interactions between the views, model, and database
	private BankAccount account;
	private JButton BackButton;
	private JButton EditButton;
	private JTextField AccountNumberField;
	private JTextField FirstNameField;
	private JTextField LastNameField;
	private JTextField StreetAddressField;
	private JTextField CityField;
	private JTextField StateField;
	private JTextField ZIPField;
	private JTextField DOBField;
	private JTextField PhoneField;



	/**
	 * Constructs an instance (or object) of the CreateView class.
	 * 
	 * @param manager
	 */
	
	public InformationView(ViewManager manager) {
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
		
		initAccountNumberField();
		initFirstNameField();
		initLastNameField();
		initStreetAddressField();
		initCityField();
		initStateField();
		initZIPField();
		initDOBField();
		initPhoneField();
		initBackButton();
		initEditButton();
	}
	
	private void initAccountNumberField() {
		JLabel label = new JLabel("Account Number", SwingConstants.RIGHT);
		label.setBounds(30, 60, 150, 35);
		label.setLabelFor(AccountNumberField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		AccountNumberField = new JTextField(35);
		AccountNumberField.setBounds(190, 60, 200, 35);
		
		this.add(label);
		this.add(AccountNumberField);
		//going to throw error in initialization
		//WithdrawlField.setText(Long.toString(account.getAccountNumber()));
		AccountNumberField.setEditable(false);
	}
	
	private void initFirstNameField() {
		JLabel label = new JLabel("First Name", SwingConstants.RIGHT);
		label.setBounds(30, 100, 150, 35);
		label.setLabelFor(FirstNameField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		FirstNameField = new JTextField(35);
		FirstNameField.setBounds(190, 100, 200, 35);
		
		this.add(label);
		this.add(FirstNameField);
		//going to throw error in initialization
		//WithdrawlField.setText(Long.toString(account.getAccountNumber()));
		FirstNameField.setEditable(false);
	}
	
	private void initLastNameField() {
		JLabel label = new JLabel("Last Name", SwingConstants.RIGHT);
		label.setBounds(30, 140, 150, 35);
		label.setLabelFor(LastNameField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		LastNameField = new JTextField(35);
		LastNameField.setBounds(190, 140, 200, 35);
		
		this.add(label);
		this.add(LastNameField);
		//going to throw error in initialization
		//WithdrawlField.setText(Long.toString(account.getAccountNumber()));
		LastNameField.setEditable(false);
	}
	
	private void initStreetAddressField() {
		JLabel label = new JLabel("Street Address", SwingConstants.RIGHT);
		label.setBounds(5, 180, 180, 35);
		label.setLabelFor(StreetAddressField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		StreetAddressField = new JTextField(35);
		StreetAddressField.setBounds(190, 180, 200, 35);
		
		this.add(label);
		this.add(StreetAddressField);
		//going to throw error in initialization
		//WithdrawlField.setText(Long.toString(account.getAccountNumber()));
		StreetAddressField.setEditable(false);
	}
	
	private void initCityField() {
		JLabel label = new JLabel("City", SwingConstants.RIGHT);
		label.setBounds(30, 220, 150, 35);
		label.setLabelFor(CityField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		CityField = new JTextField(35);
		CityField.setBounds(190, 220, 200, 35);
		
		this.add(label);
		this.add(CityField);
		//going to throw error in initialization
		//WithdrawlField.setText(Long.toString(account.getAccountNumber()));
		CityField.setEditable(false);
	}
	
	private void initStateField() {
		JLabel label = new JLabel("State", SwingConstants.RIGHT);
		label.setBounds(30, 260, 150, 35);
		label.setLabelFor(StateField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		StateField = new JTextField(35);
		StateField.setBounds(190, 260, 200, 35);
		
		this.add(label);
		this.add(StateField);
		//going to throw error in initialization
		//WithdrawlField.setText(Long.toString(account.getAccountNumber()));
		StateField.setEditable(false);
	}
	
	private void initZIPField() {
		JLabel label = new JLabel("ZIP", SwingConstants.RIGHT);
		label.setBounds(30, 300, 150, 35);
		label.setLabelFor(ZIPField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		ZIPField = new JTextField(35);
		ZIPField.setBounds(190, 300, 200, 35);
		
		this.add(label);
		this.add(ZIPField);
		//going to throw error in initialization
		//WithdrawlField.setText(Long.toString(account.getAccountNumber()));
		ZIPField.setEditable(false);
	}
	
	private void initPhoneField() {
		JLabel label = new JLabel("Phone #", SwingConstants.RIGHT);
		label.setBounds(30, 340, 150, 35);
		label.setLabelFor(PhoneField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		PhoneField = new JTextField(35);
		PhoneField.setBounds(190, 340, 200, 35);
		
		this.add(label);
		this.add(PhoneField);
		//going to throw error in initialization
		//WithdrawlField.setText(Long.toString(account.getAccountNumber()));
		PhoneField.setEditable(false);
	}
	
	private void initDOBField() {
		JLabel label = new JLabel("DOB", SwingConstants.RIGHT);
		label.setBounds(30, 380, 150, 35);
		label.setLabelFor(DOBField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		DOBField = new JTextField(35);
		DOBField.setBounds(190, 380, 200, 35);
		
		this.add(label);
		this.add(DOBField);
		//going to throw error in initialization
		//WithdrawlField.setText(Long.toString(account.getAccountNumber()));
		DOBField.setEditable(false);
	}
	
	private void initBackButton() {	
		BackButton = new JButton("Back");
		BackButton.setBounds(50, 10, 100, 35);
		BackButton.addActionListener(this);
		
		this.add(BackButton);
	}
	
	private void initEditButton() {	
		EditButton = new JButton("Edit");
		EditButton.setBounds(160, 10, 100, 35);
		EditButton.addActionListener(this);
		
		this.add(EditButton);
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
		if (source.equals(BackButton)) {
			manager.switchTo(ATM.HOME_VIEW);
			this.removeAll();
			this.initialize();
		}
		else if (source.equals(EditButton)) {
			StreetAddressField.setEditable(true);
			CityField.setEditable(true);
			StateField.setEditable(true);
			ZIPField.setEditable(true);
			PhoneField.setEditable(true);
			//PINField.setEditable(true); doesn't exist here???
			//add new buttons and dropdowns etc
	}
}
}