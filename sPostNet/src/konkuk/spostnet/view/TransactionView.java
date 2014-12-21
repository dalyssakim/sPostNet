package konkuk.spostnet.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import konkuk.spostnet.core.Center;
import konkuk.spostnet.model.Client;
import konkuk.spostnet.model.Employee;

public class TransactionView extends JFrame implements View {

	private String[] priority = { "High", "Low" };
	private JPanel contentPane;
	private JTextField senderNameTextField;
	private JTextField senderAddressTextField;
	private JTextField senderPhoneNumTextField;
	private JTextField receiverNameTextField;
	private JTextField receiverAddressTextField;
	private JTextField receiverPhoneNumTextField;
	private JTextField weightTextField;
	private Employee employee;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TransactionView() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblItemId = new JLabel("Sender Name");
		lblItemId.setBounds(12, 31, 86, 15);
		panel.add(lblItemId);

		JLabel lblNewLabel_1 = new JLabel("Sender Address");
		lblNewLabel_1.setBounds(12, 59, 107, 15);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Sender PhoneNum");
		lblNewLabel.setBounds(12, 89, 107, 15);
		panel.add(lblNewLabel);

		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setBounds(278, 130, 57, 15);
		panel.add(lblWeight);

		JLabel lblPriority = new JLabel("Priority");
		lblPriority.setBounds(278, 162, 57, 15);
		panel.add(lblPriority);

		JLabel lblNewLabel_2 = new JLabel("Receiver Name");
		lblNewLabel_2.setBounds(12, 130, 100, 15);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Reciever Address");
		lblNewLabel_3.setBounds(12, 162, 107, 15);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Receiver PhoneNum");
		lblNewLabel_4.setBounds(12, 193, 116, 15);
		panel.add(lblNewLabel_4);

		// senderName
		senderNameTextField = new JTextField();
		senderNameTextField.setBounds(138, 28, 116, 21);
		panel.add(senderNameTextField);
		senderNameTextField.setColumns(10);

		// senderAddress
		senderAddressTextField = new JTextField();
		senderAddressTextField.setBounds(138, 56, 116, 21);
		panel.add(senderAddressTextField);
		senderAddressTextField.setColumns(10);

		// sender PhoneNum
		senderPhoneNumTextField = new JTextField();
		senderPhoneNumTextField.setBounds(138, 86, 116, 21);
		panel.add(senderPhoneNumTextField);
		senderPhoneNumTextField.setColumns(10);

		// Receiver Name
		receiverNameTextField = new JTextField();
		receiverNameTextField.setBounds(138, 127, 116, 21);
		panel.add(receiverNameTextField);
		receiverNameTextField.setColumns(10);

		// Receiver Address
		receiverAddressTextField = new JTextField();
		receiverAddressTextField.setBounds(138, 159, 116, 21);
		panel.add(receiverAddressTextField);
		receiverAddressTextField.setColumns(10);

		// Receiver PhoneNum
		receiverPhoneNumTextField = new JTextField();
		receiverPhoneNumTextField.setBounds(138, 190, 116, 21);
		panel.add(receiverPhoneNumTextField);
		receiverPhoneNumTextField.setColumns(10);

		// Weight
		weightTextField = new JTextField();
		weightTextField.setBounds(328, 127, 100, 21);
		panel.add(weightTextField);
		weightTextField.setColumns(10);

		final JComboBox comboBox_1 = new JComboBox(priority);
		comboBox_1.setBounds(328, 159, 68, 21);
		panel.add(comboBox_1);

		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(257, 220, 97, 23);
		panel.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				/*
				 * Register(senderName, senderNation, senderCity, senderAddress, senderPhone
				 * 			receiverName, receiverNation, receiverCity, receiverAddress, receiverPhone,
				 * 			weight, priority)
				 */
				// Name, Nation, City, Address, Phone
				Client sender = new Client(senderNameTextField.getText(), "Our Universe", "Earth",
						senderAddressTextField.getText() , senderPhoneNumTextField.getText()); 		//  1.create(senderName, ..., senderPhone)
				Client receiver = new Client(receiverNameTextField.getText(), "Our Universe", "Mars",
						receiverAddressTextField.getText(), receiverPhoneNumTextField.getText());	// 	2.create(receiverName, ..., receiverPhone)
				Double weight = Double.parseDouble(weightTextField.getText()); 			
				int priority ;
				if(((String)comboBox_1.getSelectedItem()).equals("High")){
					priority = 0;
				}else{
					priority = 1;
				}
				List<Object> list = new ArrayList<Object>(); 			//3 create
				list.add(sender);										//4 add(sender)
				list.add(receiver);										//5 add(receiver)
				list.add(weight);										//6 add(weight)
				list.add(priority);										//7 add(priority)
				
				employee.getRole().doTask("ADDITEM", list);				//8 role:=getRole(), 9 doTask("ADDITEM", list)

				dispose();

			}
		});

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(357, 220, 97, 23);
		panel.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

	}

	@Override
	public void setModel(Object model) {
		// TODO Auto-generated method stub
		employee = (Employee) model;

	}

	@Override
	public void viewInvoker() {
		// TODO Auto-generated method stub

	}
}
