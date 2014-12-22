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

public class TransactionView implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] priority = { "High", "Low" };
	private JPanel contentPane;
	private JFrame frame;
	private JTextField senderNameTextField;
	private JTextField senderNationTextField;
	private JTextField senderCityTextField;
	private JTextField senderAddressTextField;
	private JTextField senderPhoneNumTextField;
	private JTextField receiverNameTextField;
	private JTextField receiverNationTextField;
	private JTextField receiverCityTextField;
	private JTextField receiverAddressTextField;
	private JTextField receiverPhoneNumTextField;
	private JTextField weightTextField;
/*	private JTextField senderNameTextField;
	private JTextField senderAddressTextField;
	private JTextField senderPhoneNumTextField;
	private JTextField receiverNameTextField;
	private JTextField receiverAddressTextField;
	private JTextField receiverPhoneNumTextField;
	private JTextField weightTextField;*/
	private Employee employee;

	
	public TransactionView(){
		frame = new JFrame();
		frame.setVisible(false);
	}
	public void showTransactionView() {


		frame.setBounds(100, 100, 700, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sender Name");
		lblNewLabel.setBounds(29, 32, 116, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nation");
		lblNewLabel_1.setBounds(29, 64, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sender PhoneNum");
		lblNewLabel_2.setBounds(29, 96, 116, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Receiver Name");
		lblNewLabel_3.setBounds(29, 158, 116, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nation");
		lblNewLabel_4.setBounds(29, 186, 57, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Receiver PhoneNum");
		lblNewLabel_5.setBounds(29, 214, 116, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("City");
		lblNewLabel_6.setBounds(287, 64, 57, 15);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Address");
		lblNewLabel_7.setBounds(455, 64, 57, 15);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("City");
		lblNewLabel_8.setBounds(287, 186, 57, 15);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Address");
		lblNewLabel_9.setBounds(455, 186, 57, 15);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Weight");
		lblNewLabel_10.setBounds(29, 265, 57, 15);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Priority");
		lblNewLabel_11.setBounds(287, 265, 57, 15);
		contentPane.add(lblNewLabel_11);
		
		senderNameTextField = new JTextField();
		senderNameTextField.setBounds(154, 29, 116, 21);
		contentPane.add(senderNameTextField);
		senderNameTextField.setColumns(10);
		
		senderNationTextField = new JTextField();
		senderNationTextField.setBounds(154, 61, 116, 21);
		contentPane.add(senderNationTextField);
		senderNationTextField.setColumns(10);
		
		senderCityTextField = new JTextField();
		senderCityTextField.setBounds(323, 61, 116, 21);
		contentPane.add(senderCityTextField);
		senderCityTextField.setColumns(10);
		
		senderAddressTextField = new JTextField();
		senderAddressTextField.setBounds(511, 61, 116, 21);
		contentPane.add(senderAddressTextField);
		senderAddressTextField.setColumns(10);
		
		senderPhoneNumTextField = new JTextField();
		senderPhoneNumTextField.setBounds(154, 93, 116, 21);
		contentPane.add(senderPhoneNumTextField);
		senderPhoneNumTextField.setColumns(10);
		
		receiverNameTextField = new JTextField();
		receiverNameTextField.setBounds(157, 155, 116, 21);
		contentPane.add(receiverNameTextField);
		receiverNameTextField.setColumns(10);
		
		receiverNationTextField = new JTextField();
		receiverNationTextField.setBounds(157, 183, 116, 21);
		contentPane.add(receiverNationTextField);
		receiverNationTextField.setColumns(10);
		
		receiverCityTextField = new JTextField();
		receiverCityTextField.setBounds(323, 183, 116, 21);
		contentPane.add(receiverCityTextField);
		receiverCityTextField.setColumns(10);
		
		receiverAddressTextField = new JTextField();
		receiverAddressTextField.setBounds(511, 183, 116, 21);
		contentPane.add(receiverAddressTextField);
		receiverAddressTextField.setColumns(10);
		
		receiverPhoneNumTextField = new JTextField();
		receiverPhoneNumTextField.setBounds(157, 211, 116, 21);
		contentPane.add(receiverPhoneNumTextField);
		receiverPhoneNumTextField.setColumns(10);
		
		weightTextField = new JTextField();
		weightTextField.setBounds(157, 262, 116, 21);
		contentPane.add(weightTextField);
		weightTextField.setColumns(10);
		
		final JComboBox comboBox = new JComboBox(priority);
		comboBox.setBounds(342, 263, 91, 18);
		contentPane.add(comboBox);
	

		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(386, 307, 97, 23);
		contentPane.add(btnRegister);
		btnRegister.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e){
						/*
				 * Register(senderName, senderNation, senderCity, senderAddress, senderPhone
				 * 			receiverName, receiverNation, receiverCity, receiverAddress, receiverPhone,
				 * 			weight, priority)
				 */
				// Name, Nation, City, Address, Phone
				Client sender = new Client(senderNameTextField.getText(), senderNationTextField.getText()+"", senderCityTextField.getText()+"",
						senderAddressTextField.getText() , senderPhoneNumTextField.getText()); 		//  1.create(senderName, ..., senderPhone)
				Client receiver = new Client(receiverNameTextField.getText(), receiverNationTextField.getText()+"", receiverCityTextField.getText()+"",
						receiverAddressTextField.getText(), receiverPhoneNumTextField.getText());	// 	2.create(receiverName, ..., receiverPhone)
				Double weight = Double.parseDouble(weightTextField.getText()); 			
				int priority ;
				if(((String)comboBox.getSelectedItem()).equals("High")){
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

				frame.dispose();
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(514, 307, 97, 23);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
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
		showTransactionView();
		frame.setVisible(true);
	}
}