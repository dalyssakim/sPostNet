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
	private JFrame frame;
	private Employee employee = null;

	public DriverView() {
		frame = new JFrame();
		frame.setVisible(false);
	}

	public void showDriverView() {
		frame.setVisible(true);
		frame.setTitle("[Driver] " + employee.getName());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 355, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblId = new JLabel("[Name] " + employee.getName());
		lblId.setBounds(24, 21, 117, 15);
		panel.add(lblId);

		JLabel lblRole = new JLabel("[Role] " + employee.getRoleName());
		lblRole.setBounds(24, 46, 100, 15);
		panel.add(lblRole);

		JLabel lblCenterid = new JLabel("[CenterId] " + employee.getCenterId());
		lblCenterid.setBounds(24, 71, 134, 15);
		panel.add(lblCenterid);

		JButton btnNewButton = new JButton("Start Delivery");
		btnNewButton.setBounds(10, 165, 148, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeliveryView dv = new DeliveryView(employee);
				dv.setModel(employee);
				dv.viewInvoker();
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
		employee = (Employee) model;
	}

	@Override
	public void viewInvoker() {
		// TODO Auto-generated method stub-[
		showDriverView();
	}

}
