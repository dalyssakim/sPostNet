package konkuk.spostnet.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import konkuk.spostnet.model.Employee;

/*
 * 
 */

public class CenterManagementView implements View{

	private JFrame frame;
	private JPanel contentPane;
	private ArrayList centerInfo = new ArrayList();
	private String[] manageCenter = { "Insert", "Modify", "Delete" };


	/**
	 * Create the frame.
	 */
	public CenterManagementView(){
		frame = new JFrame();
		frame.setVisible(false);
	}
	
	public void showCenterManagementView() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		final JComboBox comboBox = new JComboBox(manageCenter);
		comboBox.setBounds(234, 29, 92, 21);
		panel.add(comboBox);
		
		
		

		
		/*
		 * centerInfo = extractCenterInfo();
		 */
		centerInfo.add("aa");
		centerInfo.add("bb");
	
		JList list = new JList(centerInfo.toArray());
		list.setBounds(12, 31, 200, 211);
		panel.add(list);
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


	@Override
	public void setModel(Object model) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void viewInvoker() {
		// TODO Auto-generated method stub
		
	}

}
