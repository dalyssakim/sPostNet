package konkuk.spostnet.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import konkuk.spostnet.model.Employee;


public class SeniorManagerView extends JFrame implements View{


	private JPanel contentPane;
	private Employee employee = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeniorManagerView frame = new SeniorManagerView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public void setEmployee(Employee employee){
		this.employee = employee;
	}
	public SeniorManagerView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 355, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("[Name]");
		//JLabel lblId = new JLabel("[Name] "+emp.getName());
		lblId.setBounds(24, 21, 117, 15);
		panel.add(lblId);
		
		JLabel lblRole = new JLabel("[Role]");
		//JLabel lblRole = new JLabel("[Role] "+emp.getRole());
		lblRole.setBounds(24, 46, 57, 15);
		panel.add(lblRole);
		
		JLabel lblCenterid = new JLabel("[CenterId]");
		//JLabel lblCenterid = new JLabel("[CenterId] "+emp.getCenterId());
		lblCenterid.setBounds(24, 71, 134, 15);
		panel.add(lblCenterid);
		
		JButton btnNewButton = new JButton("Manage Center");
		btnNewButton.setBounds(10, 131, 148, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CenterManagementView cmv = new CenterManagementView();
			//	cmv.setVisible(true);

			}
		});

		panel.add(btnNewButton);

		
		JButton btnNewButton_1 = new JButton("Manage Employee");
		btnNewButton_1.setBounds(170, 131, 148, 23);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				EmployeeManagementView emv = new EmployeeManagementView();
				emv.setVisible(true);
			}
		});
		
		JButton btnNewButton_2 = new JButton("Request Status");
		btnNewButton_2.setBounds(10, 164, 148, 23);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatusRequestionView srv = new StatusRequestionView();
				srv.setVisible(true);
			}
		});
		
		JButton btnSignout = new JButton("Sign-out");
		btnSignout.setBounds(170, 164, 148, 23);
		panel.add(btnSignout);
		btnSignout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
	}

	@Override
	public void setModel(Object model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewInvoker() {
		// TODO Auto-generated method stub
		
	}
}
