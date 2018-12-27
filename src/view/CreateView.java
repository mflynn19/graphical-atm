package view;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.stream.IntStream;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import controller.ViewManager;
import data.Database;

@SuppressWarnings("serial")
public class CreateView extends JPanel implements ActionListener {
	
	private ViewManager manager;		// manages interactions between the views, model, and database
	private JTextField FnameField;
	private JTextField LnameField;
	private JTextField PhoneField;
	private JTextField StreetField;
	private JComboBox<String> BirthdayField;
	private JTextField CityField;
	private JComboBox<String> StateField;
	private JTextField ZipField;
	private JTextField APhoneField;
	private JTextField BPhoneField;
	private JTextField PINField;
	private JButton CancelButton;
	private JButton CreateButton;
	/**
	 * Constructs an instance (or object) of the CreateView class.
	 * 
	 * @param manager
	 */
	
	public CreateView(ViewManager manager) {
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
		
		initFnameField();
		initLnameField();
		initPhoneField();
		initAPhoneField();
		initBPhoneField();
		initStreetField();
		initBirthdayField();
		initCityField();
		initStateField();
		initZipField();
		initPINField();
		initCancelButton();
		initCreateButton();
	}
	
	private void initFnameField() {
		JLabel label = new JLabel("First Name", SwingConstants.RIGHT);
		label.setBounds(100, 10, 95, 35);
		label.setLabelFor(FnameField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		FnameField = new JTextField(25);
		FnameField.setBounds(205, 10, 200, 35);
		
		this.add(label);
		this.add(FnameField);
	}
	
	private void initLnameField() {
		JLabel label = new JLabel("Last Name", SwingConstants.RIGHT);
		label.setBounds(100, 50, 95, 35);
		//x, y, width, height starts at 0,0 top left
		label.setLabelFor(LnameField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		LnameField = new JTextField(25);
		LnameField.setBounds(205, 50, 200, 35);
		
		this.add(label);
		this.add(LnameField);
	}
	
	private void initBirthdayField() {
		JLabel label = new JLabel("Birthdate", SwingConstants.RIGHT);
		label.setBounds(100, 90, 95, 35);
		label.setLabelFor(BirthdayField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		this.add(label);
		
		//do three combo boxes with months days and years
		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
		JComboBox<String> first = new JComboBox<String>(months);
		first.addActionListener(this);
		first.setBounds(205, 90, 95, 35);
		this.add(first);
		first.setVisible(true);
		
		String[] days = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
		JComboBox<String> second = new JComboBox<String>(days);
		second.addActionListener(this);
		second.setBounds(235, 90, 95, 35);
		this.add(second);
		second.setVisible(true);
		
		int[] years = IntStream.range(1900, 2019).toArray();
		String[] stringYears = Arrays.toString(years).split("[\\[\\]]")[1].split(",");
		JComboBox<String> third = new JComboBox<String>(stringYears);
		third.addActionListener(this);
		third.setBounds(275, 90, 95, 35);
		this.add(third);
		third.setVisible(true);
	}
	
	private void initPhoneField() {
		JLabel label = new JLabel("Phone", SwingConstants.RIGHT);
		label.setBounds(100, 130, 95, 35);
		label.setLabelFor(PhoneField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		PhoneField = new JTextField(20);
		PhoneField.setBounds(205, 130, 30, 35);
		
		this.add(label);
		this.add(PhoneField);
	}
	
	private void initAPhoneField() {
		APhoneField = new JTextField(20);
		APhoneField.setBounds(245, 130, 30, 35);
		
		this.add(APhoneField);
	}
	
	private void initBPhoneField() {
		BPhoneField = new JTextField(20);
		BPhoneField.setBounds(285, 130, 40, 35);
		
		this.add(BPhoneField);
	}
	
	private void initStreetField() {
		JLabel label = new JLabel("Address", SwingConstants.RIGHT);
		label.setBounds(100, 170, 95, 35);
		label.setLabelFor(StreetField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		StreetField = new JTextField(30);
		StreetField.setBounds(205, 170, 200, 35);
		
		this.add(label);
		this.add(StreetField);
	}
	
	private void initCityField() {
		JLabel label = new JLabel("City", SwingConstants.RIGHT);
		label.setBounds(100, 210, 95, 35);
		label.setLabelFor(CityField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		CityField = new JTextField(30);
		CityField.setBounds(205, 210, 200, 35);
		
		this.add(label);
		this.add(CityField);
	}
	
	private void initStateField() {
		JLabel label = new JLabel("State", SwingConstants.RIGHT);
		label.setBounds(100, 250, 95, 35);
		label.setLabelFor(StateField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		this.add(label);
		
		String[] states = { "AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY" };
		JComboBox<String> initial = new JComboBox<String>(states);
		initial.addActionListener(this);
		initial.setBounds(205, 250, 200, 35);
		this.add(initial);
		initial.setVisible(true);
	}
	
	private void initZipField() {
		JLabel label = new JLabel("ZIP", SwingConstants.RIGHT);
		label.setBounds(100, 290, 95, 35);
		label.setLabelFor(ZipField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		ZipField = new JTextField(30);
		ZipField.setBounds(205, 290, 200, 35);
		
		this.add(label);
		this.add(ZipField);
	}
	
	private void initPINField() {
		JLabel label = new JLabel("PIN", SwingConstants.RIGHT);
		label.setBounds(100, 330, 95, 35);
		label.setLabelFor(PINField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		JPasswordField PINField = new JPasswordField();
	    PINField.setEchoChar('*');
		PINField.setBounds(205, 330, 50, 35);
		
		this.add(label);
		this.add(PINField);
	}
	
	private void initCancelButton() {	
		CancelButton = new JButton("Cancel");
		CancelButton.setBounds(305, 370, 100, 35);
		CancelButton.addActionListener(this);
		
		this.add(CancelButton);
	}
	
	private void initCreateButton() {	
		CreateButton = new JButton("Confirm");
		CreateButton.setBounds(205, 370, 100, 35);
		CreateButton.addActionListener(this);
		
		this.add(CreateButton);
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
	//private Database db;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO actually make the create account work; make checks for wrong 
		//values, figure out how to set nested combo boxes to null and PIN
		Object source = e.getSource();
		
		if (source.equals(CreateButton)) {
			//with db make an account
			//db.insertAccount(null);
			manager.switchTo(ATM.HOME_VIEW);
		}
		else if (source.equals(CancelButton)) {
			manager.switchTo(ATM.LOGIN_VIEW);
			FnameField.setText(null);
			LnameField.setText(null);
			PhoneField.setText(null);
			APhoneField.setText(null);
			BPhoneField.setText(null);
			StreetField.setText(null);
			//BirthdayField.setSelectedIndex(0);
			CityField.setText(null);
			//StateField.setSelectedIndex(0);
			ZipField.setText(null);
			PINField.setText(null);
			
		} else {
			System.err.println("ERROR: Action command not found (" + e.getActionCommand() + ")");
		}
	}
}