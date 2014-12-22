package konkuk.spostnet.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import konkuk.spostnet.model.Client;
import konkuk.spostnet.model.Employee;

public class ClerkView implements View{

	private JFrame frame;
	private Employee employee;
	private JPanel contentPane;
	String id, pw;

	/**
	 * Launch the application.
	 */
	public ClerkView(){
		frame = new JFrame();
		frame.setVisible(false);
	}
	
	public void setModel(Object model){
		this.employee = (Employee)model;
	}
	/**
	 * Create the frame.
	 */

	public void viewInvoker(){

		showClerkView();
		frame.setVisible(true);
	}
	
	public void showClerkView() {
		// public ClerkView(Employee emp) {
		frame.setTitle("[Clerk]"+employee.getName());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 355, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblId = new JLabel("[Name]      "+employee.getName());
		// JLabel lblId = new JLabel("[Name] "+emp.getName());
		lblId.setBounds(24, 21, 117, 15);
		panel.add(lblId);

		JLabel lblRole = new JLabel("[Role]");
		// JLabel lblRole = new JLabel("[Role] "+emp.getRole());
		lblRole.setBounds(24, 46, 57, 15);
		panel.add(lblRole);

		JLabel lblCenterid = new JLabel("[CenterId]");
		// JLabel lblCenterid = new JLabel("[CenterId] "+emp.getCenterId());
		lblCenterid.setBounds(24, 71, 134, 15);
		panel.add(lblCenterid);

		JButton btnNewButton = new JButton("Add Transaction");
		btnNewButton.setBounds(24, 116, 134, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 *  Add Transaction
				 * */
				TransactionView frame = new TransactionView();
				frame.setModel(employee);
				frame.viewInvoker();
		
			
			}
		});

		panel.add(btnNewButton);

		JButton btnSignout = new JButton("Sign-out");
		btnSignout.setBounds(24, 159, 134, 23);
		panel.add(btnSignout);
		
	}

}