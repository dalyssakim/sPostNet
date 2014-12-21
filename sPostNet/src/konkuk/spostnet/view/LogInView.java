package konkuk.spostnet.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import konkuk.spostnet.core.Center;
import konkuk.spostnet.model.Employee;


public class LogInView implements View {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Center center;

	/**
	 * Launch the application.
	 */
	public LogInView(){

		frame = new JFrame();
		frame.setVisible(false);
	}
	
	public void viewInvoker() {

		showLogInView();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public void showLogInView() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 355, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblSpostnet = new JLabel("SPostNet");
		lblSpostnet.setBounds(147, 43, 57, 15);
		panel.add(lblSpostnet);
		
		textField = new JTextField();
		textField.setBounds(122, 101, 116, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(122, 137, 116, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(46, 104, 57, 15);
		panel.add(lblId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(46, 140, 57, 15);
		panel.add(lblPassword);
		
		JButton btnLogin = new JButton("Sign-In");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				/*
				 * get Id Password and Call Proxy for 
				 */
				
				Employee employee = new Employee(textField.getText(), textField_1.getText(), center.getCenterId()); 	//1Create(UserId, Pwd, centerId)
				if(center.processLogin(employee)){ // 2:processLogin(Employee employee)
					frame.setVisible(false);
					frame.dispose();
				}
			}
		});
		btnLogin.setBounds(122, 181, 97, 23);
		panel.add(btnLogin);
	}

	@Override
	public void setModel(Object model) {
		// TODO Auto-generated method stub
		center = (Center) model;
		
	}
}
