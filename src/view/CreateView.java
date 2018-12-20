package view;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ViewManager;

@SuppressWarnings("serial")
public class CreateView extends JPanel implements ActionListener {
	
	private ViewManager manager;		// manages interactions between the views, model, and database
	private JTextField FnameField;
	private JTextField LnameField;
	private Component PhoneField;
	private Component StreetField;
	private JTextField BirthdayField;
	private Component CityField;
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
		
		// TODO
		//
		// this is a placeholder for this view and should be removed once you start
		// building the CreateView.
		
		this.add(new javax.swing.JLabel("CreateView", javax.swing.SwingConstants.CENTER));
		
		// TODO
		//
		// this is where you should build the CreateView (i.e., all the components that
		// allow the user to enter his or her information and create a new account).
		//
		// feel free to use my layout in LoginView as an example for laying out and
		// positioning your components.
		
	}
	
	private void initFnameField() {
		JLabel label = new JLabel("First Name", SwingConstants.RIGHT);
		label.setBounds(100, 140, 95, 35);
		label.setLabelFor(FnameField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		FnameField = new JTextField(20);
		FnameField.setBounds(205, 140, 200, 35);
		
		this.add(label);
		this.add(FnameField);
	}
	
	private void initLnameField() {
		JLabel label = new JLabel("Last Name", SwingConstants.RIGHT);
		label.setBounds(100, 140, 95, 35);
		//x, y, width, height starts at 0,0 top left
		label.setLabelFor(LnameField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		FnameField = new JTextField(20);
		FnameField.setBounds(200, 140, 200, 35);
		
		this.add(label);
		this.add(LnameField);
	}
	
	private void initBirthdayField() {
		//do three combo boxes with months days and years
		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
		JComboBox<String> first = new JComboBox<String>(months);
		first.addActionListener(this);
		BirthdayField = new JTextField(20);
		BirthdayField.setBounds(205, 140, 200, 35);
		this.add(first);
		this.add(BirthdayField);
		
		
		String[] days = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
		JComboBox<String> second = new JComboBox<String>(days);
		second.addActionListener(this);
		BirthdayField = new JTextField(20);
		BirthdayField.setBounds(205, 140, 200, 35);
		this.add(second);
		this.add(BirthdayField);
	}
	
	//needs to be three separate boxes!!!
	private void initPhoneField() {
		JLabel label = new JLabel("Phone", SwingConstants.RIGHT);
		label.setBounds(100, 140, 95, 35);
		label.setLabelFor(PhoneField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		PhoneField = new JTextField(20);
		PhoneField.setBounds(205, 140, 200, 35);
		
		this.add(label);
		this.add(PhoneField);
	}
	
	private void initStreetField() {
		JLabel label = new JLabel("Street Address", SwingConstants.RIGHT);
		label.setBounds(100, 140, 95, 35);
		label.setLabelFor(StreetField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		StreetField = new JTextField(20);
		StreetField.setBounds(205, 140, 200, 35);
		
		this.add(label);
		this.add(StreetField);
	}
	
	private void initCityField() {
		JLabel label = new JLabel("City", SwingConstants.RIGHT);
		label.setBounds(100, 140, 95, 35);
		label.setLabelFor(CityField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		CityField = new JTextField(20);
		CityField.setBounds(205, 140, 200, 35);
		
		this.add(label);
		this.add(CityField);
	}
	
	private void initState() {
		String[] months = { "AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "IA", "ID" };
		JComboBox<String> first = new JComboBox<String>(months);
		first.addActionListener(this);
		BirthdayField = new JTextField(20);
		BirthdayField.setBounds(205, 140, 200, 35);
		this.add(first);
		this.add(BirthdayField);
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
		
		// TODO
		//
		// this is where you'll setup your action listener, which is responsible for
		// responding to actions the user might take in this view (an action can be a
		// user clicking a button, typing in a textfield, etc.).
		//
		// feel free to use my action listener in LoginView.java as an example.
	}
}