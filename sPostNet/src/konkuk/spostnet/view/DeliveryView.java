package konkuk.spostnet.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;

import konkuk.spostnet.model.Employee;


public class DeliveryView extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public DeliveryView(Employee employee) {
		super("aaaaaaaaaaaa");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 493, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JList list = new JList();
		list.setBounds(40, 222, 153, -174);
		panel.add(list);
		
		JLabel lblDeliveryList = new JLabel("Delivery List");
		lblDeliveryList.setBounds(50, 10, 77, 15);
		panel.add(lblDeliveryList);
		
		JButton btnDeliveryCompleted = new JButton("Delivery Completed");
		btnDeliveryCompleted.setBounds(203, 163, 162, 23);
		panel.add(btnDeliveryCompleted);
		btnDeliveryCompleted.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
		

		
		JLabel label = new JLabel("");
		label.setBounds(210, 58, 213, 76);
		panel.add(label);
		
	}
}
