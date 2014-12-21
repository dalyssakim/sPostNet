package konkuk.spostnet.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import konkuk.spostnet.model.Employee;


public class DriverView extends JFrame implements View {

	private JPanel contentPane;
	public DeliveryView deliveryview = null;
	private Employee employee = null;
	
	/**
	 * Launch the application.
	 */
	public void viewInvoker(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DriverView frame = new DriverView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setEmployee(Employee employee){
		this.employee = employee;
	}

	/**
	 * Create the frame.
	 */
	public DriverView() {
		//	super("Clerk"+employee.getName());	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 355, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("[Name	]");
		lblId.setBounds(24, 21, 117, 15);
		panel.add(lblId);
		
		JLabel lblRole = new JLabel("[Role	]");
		lblRole.setBounds(24, 46, 57, 15);
		panel.add(lblRole);
		
		JLabel lblCenterid = new JLabel("[CenterId	]");
		lblCenterid.setBounds(24, 71, 134, 15);
		panel.add(lblCenterid);
		
		
		JButton btnNewButton = new JButton("Start Delivery");
		btnNewButton.setBounds(10, 165, 148, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deliveryview = new DeliveryView(employee);
				deliveryview.setVisible(true);
			}
		});
		

		panel.add(btnNewButton);

		JButton btnSignout = new JButton("Sign-out");
		btnSignout.setBounds(169, 165, 148, 23);
		panel.add(btnSignout);
		btnSignout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		JLabel lblmessage = new JLabel("[Message]");
		lblmessage.setBounds(226, 21, 186, 15);
		panel.add(lblmessage);
	}

	@Override
	public void setModel(Object model) {
		// TODO Auto-generated method stub
		
	}

}




