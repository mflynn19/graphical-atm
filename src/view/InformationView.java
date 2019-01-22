package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
	private JComboBox<String> StateField;
	private JTextField ZIPField;
	private JTextField DOBField;
	private JTextField PhoneField;
	private JButton CancelButton;
	private JButton SaveButton;
	private JLabel errorLabel;

	/**
	 * Constructs an instance (or object) of the CreateView class.
	 * 
	 * @param manager
	 */
	
	public InformationView(ViewManager manager) {
		super();
		
		this.manager = manager;
		this.errorLabel = new JLabel("", SwingConstants.CENTER);
		initialize();
	}
	
	public void setView (BankAccount account) {
		this.account = account;
		if (this.account != null) {
			AccountNumberField.setText(Long.toString(account.getAccountNumber()));
			FirstNameField.setText(account.getUser().getFirstName());
			LastNameField.setText(account.getUser().getLastName());
			StreetAddressField.setText(account.getUser().getStreetAddress());
			CityField.setText(account.getUser().getCity());
			StateField.setSelectedItem(account.getUser().getState());
			ZIPField.setText(account.getUser().getZip());
			PhoneField.setText(Long.toString(account.getUser().getPhone()));
			DOBField.setText(Integer.toString(account.getUser().getDob()));

		}
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
		initCancelButton();
		initSaveButton();
		initErrorLabel();
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
		CityField.setEditable(false);
	}
	
	private void initStateField() {
		JLabel label = new JLabel("State", SwingConstants.RIGHT);
		label.setBounds(30, 260, 95, 35);
		label.setLabelFor(StateField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		this.add(label);
		
		String[] states = { "AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY" };
		StateField = new JComboBox<String>(states);
		StateField.setBounds(190, 260, 200, 35);
		this.add(StateField);
		StateField.setEnabled(false);
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
	
	private void initCancelButton() {	
		CancelButton = new JButton("Cancel");
		CancelButton.setBounds(270, 10, 100, 35);
		CancelButton.addActionListener(this);	
		
		this.add(CancelButton);
		CancelButton.setVisible(false);

	}
	
	private void initSaveButton() {	
		SaveButton = new JButton("Save");
		SaveButton.setBounds(160, 10, 100, 35);
		SaveButton.addActionListener(this);	
		
		this.add(SaveButton);
		SaveButton.setVisible(false);

	}
	
	private void initErrorLabel() {
		errorLabel.setBounds(105, 410, 175, 35);
		errorLabel.setFont(new Font("DialogInput", Font.ITALIC, 14));
		errorLabel.setForeground(Color.RED);
		
		this.add(errorLabel);
		
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
			this.removeAll();
			initialize();
			StreetAddressField.setEditable(false);
			CityField.setEditable(false);
			StateField.setEnabled(false);
			ZIPField.setEditable(false);
			PhoneField.setEditable(false);
			CancelButton.setVisible(false);
			SaveButton.setVisible(false);
			EditButton.setVisible(true);
			manager.switchTo(ATM.HOME_VIEW);
		}
		else if (source.equals(EditButton)) {
			StreetAddressField.setEditable(true);
			CityField.setEditable(true);
			StateField.setEnabled(true);
			ZIPField.setEditable(true);
			PhoneField.setEditable(true);
			CancelButton.setVisible(true);
			SaveButton.setVisible(true);
			EditButton.setVisible(false);
		}
		else if (source.equals(CancelButton)) {
			this.removeAll();
			initialize();
			StreetAddressField.setEditable(false);
			CityField.setEditable(false);
			StateField.setEnabled(false);
			ZIPField.setEditable(false);
			PhoneField.setEditable(false);
			CancelButton.setVisible(false);
			SaveButton.setVisible(false);
			EditButton.setVisible(true);
		}
		else if (source.equals(SaveButton)) {
			boolean create = true;
			
			long phone = 0;
			String phoneString = PhoneField.getText();
			if(phoneString.length() != 10 || phoneString.matches("[a-zA-Z]+")) {
				errorLabel.setText("Please enter a 10 digit phone number.");
				create = false;
			} else {
				phone = Long.parseLong(phoneString);
			}
			
			String street = StreetAddressField.getText();
			String city = CityField.getText();
			String state = StateField.getSelectedItem().toString();
			String zipcode = ZIPField.getText();
			if (street.equals("") || city.equals("") || state.equals("") || zipcode.equals("") || zipcode.matches("[a-zA-Z]+")) {
				errorLabel.setText("Please enter all components of your address.");
				create = false;
			}
			
			if(create) {
				account.getUser().setPhone(phone);
				account.getUser().setStreetAddress(street);
				account.getUser().setCity(city);
				account.getUser().setState(state);
				account.getUser().setZip(zipcode);
				
				manager.sendBankAccount(account, "manager");
				manager.sendBankAccount(account, "home");
				manager.updateAcc(null);

				StreetAddressField.setEditable(false);
				CityField.setEditable(false);
				StateField.setEnabled(false);
				ZIPField.setEditable(false);
				PhoneField.setEditable(false);
				CancelButton.setVisible(false);
				SaveButton.setVisible(false);
				EditButton.setVisible(true);
			}
		}
	}
}