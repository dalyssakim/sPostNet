package konkuk.spostnet.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JComboBox;
import javax.swing.JList;

public class EmployeeManagementView extends JFrame {

	private JPanel contentPane;
	private ArrayList employeeInfo = new ArrayList();
	private String[] manageEmployee = { "Insert", "Modify", "Delete" };



	/**
	 * Create the frame.
	 */
	public EmployeeManagementView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JComboBox comboBox = new JComboBox(manageEmployee);
		comboBox.setBounds(227, 31, 64, 21);
		contentPane.add(comboBox);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Object obj = e.getItem();
				if (obj.equals("Insert")) {

				} else if (obj.equals("Modify")) {

				} else if (obj.equals("Delete")) {
					JButton btnSignout = new JButton("Delete");
					btnSignout.setBounds(169, 163, 148, 23);
					btnSignout.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							dispose();
						}
					});
				}
			}

		});

		/*
		 * employeeInfo = extractEmployeeInfo();
		 */
		employeeInfo.add("aa");
		employeeInfo.add("bb");
		JList list = new JList(employeeInfo.toArray());
		list.setBounds(24, 33, 191, 202);
		contentPane.add(list);
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(final ListSelectionEvent le) {
				comboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						if(e.getSource() instanceof JComboBox && le.getValueIsAdjusting()){
							System.out.println("aaarrrr");
						}
					}
				});
			
			}
			
		});
	}
}
