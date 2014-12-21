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
import java.lang.instrument.ClassFileTransformer;

import konkuk.spostnet.model.Employee;

public class WarehouseManagerView implements View {

	private JFrame frame;
	private JPanel contentPane;
	private Employee employee = null; 

	/**
	 * Launch the application.
	 */

	public WarehouseManagerView(){
		frame = new JFrame();
		frame.setVisible(false);
	}
	
	/**
	 * Create the frame.
	 */
	public void showWarehouseManagerView() {
		// public WarehouseManagerView(Employee emp) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 355, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		//JLabel lblId = new JLabel("[Name]");
		JLabel lblId = new JLabel("[Name] "+employee.getName());
		lblId.setBounds(24, 21, 117, 15);
		panel.add(lblId);

		//JLabel lblRole = new JLabel("[Role]");
		 JLabel lblRole = new JLabel("[Role] "+employee.getRoleName());
		lblRole.setBounds(24, 46, 57, 15);
		panel.add(lblRole);

		//JLabel lblCenterid = new JLabel("[CenterId]");
		JLabel lblCenterid = new JLabel("[CenterId] "+employee.getCenterId());
		lblCenterid.setBounds(24, 71, 134, 15);
		panel.add(lblCenterid);

		JButton btnNewButton = new JButton("Classify Item");
		btnNewButton.setBounds(12, 164, 148, 23);
		btnNewButton.addActionListener(new ActionListener() {	// classifyItem
			public void actionPerformed(ActionEvent e) {
				ClassificationView cfv = new ClassificationView(); 	// 1 create
				cfv.setModel(employee);								// 2 setModel(employee)
				cfv.viewInvoker();									// 3 viewInvoker()
			}
		});

		panel.add(btnNewButton);

		JButton btnSignout = new JButton("Sign-out");
		btnSignout.setBounds(169, 164, 148, 23);
		panel.add(btnSignout);
		btnSignout.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});

	}
	@Override
	public void setModel(Object model) {
		// TODO Auto-generated method stub
		this.employee = (Employee) model;
	}
	@Override
	public void viewInvoker() {
		// TODO Auto-generated method stub
		showWarehouseManagerView();
		frame.setVisible(true);
	}
}
