package konkuk.spostnet.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.instrument.ClassFileTransformer;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import konkuk.spostnet.abstractobject.Mail;
import konkuk.spostnet.core.Center;
import konkuk.spostnet.core.sPostNet;
import konkuk.spostnet.model.Container;
import konkuk.spostnet.model.Driver;
import konkuk.spostnet.model.Employee;

public class AllocationView extends JFrame implements View, java.util.Observer {

	private JFrame frame;
	private JPanel contentPane;
	private Employee employee = null;

	private List<Container> containers = new ArrayList();
	private List<Employee> drivers = new ArrayList();
	private ArrayList availableDriver = new ArrayList();
	private ArrayList classifiedContainer = new ArrayList();

	private DefaultListModel driverListModel = new DefaultListModel();
	private DefaultListModel containerListModel = new DefaultListModel();
	private JList list = new JList(driverListModel);
	private JList list_1 = new JList(containerListModel);
	List elist = new ArrayList();

	public AllocationView() {
		frame = new JFrame();
		frame.setVisible(false);
	}

	@SuppressWarnings("unchecked")
	public void showAllocationView() {

		/*
		 * Set available drivers and classified container.
		 */
		drivers = sPostNet.getSPostNet().getActiveEmployee();

		drivers = employee.getRole().getProxy()
				.updateSelect("AvailableDriver", elist);

		for (int i = 0; i < drivers.size(); i++) {
			if (drivers.get(i).getRoleName().equals("Driver"))
				; // [role == Driver && driver.state = waiting]
			driverListModel.addElement(drivers.get(i).getUserId());
		}
		list.setModel(driverListModel);

		containers = (List) Center.getCenter().getLcontainer(); // 3.1.1
																// container :=
																// getLcontainer()

		for (int i = 0; i < containers.size(); i++) { // 3.1.2
														// [*i=0...mail.size]
														// mail:=get(i)
			System.out.println(containers.get(i).getCenter().getName());
			//if (containers.get(i) != null && containers.get(i).getStatus().equalsIgnoreCase("idle")) {
				containerListModel.addElement(containers.get(i)
						.getInvoiceNumber()); // 3.1.3 [mail.status==Classified]
												// addElement(mail.invoiceNumber);
			//}
		}

		list_1.setModel(containerListModel);
		if (containers.size() == 0) {
			System.out.println("No Item in the list");
		}

		frame.setTitle("[WM - Allocation] " + employee.getName());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		list.setBounds(27, 35, 171, 170);
		contentPane.add(list);

		list_1.setBounds(226, 35, 171, 170);
		contentPane.add(list_1);

		JLabel lblAvailableDriver = new JLabel("Available Driver");
		lblAvailableDriver.setBounds(60, 10, 115, 15);
		contentPane.add(lblAvailableDriver);

		JLabel lblMail = new JLabel("Container");
		lblMail.setBounds(283, 10, 57, 15);
		contentPane.add(lblMail);

		final JButton btnAllocate = new JButton("Allocate");
		btnAllocate.setBounds(178, 229, 97, 23);
		contentPane.add(btnAllocate);

		JButton btnCompleted = new JButton("Completed");
		btnCompleted.setBounds(299, 229, 97, 23);
		contentPane.add(btnCompleted);
		btnCompleted.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		list.addListSelectionListener(new ListSelectionListener() {// list-driverListModel,
																	// list_1-containerListModel
			public void valueChanged(ListSelectionEvent le) {
				list_1.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent se) {
						btnAllocate.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								/*
								 * allocation onbutton with available drivers
								 * and classified containers
								 */

								int invoiceNumber = -1;
								String userId = "";
								for (int i = 0; i < containers.size(); i++) {
									if (list_1.getSelectedValue() != null) {
										if ((Integer) list_1.getSelectedValue() != containers
												.get(i).getInvoiceNumber()) {
											invoiceNumber = (Integer) list_1
													.getSelectedValue();
											userId = (String) list
													.getSelectedValue();
											List<Object> objects = new ArrayList(); // 1
																					// create
											objects.add(invoiceNumber); // 2
																		// add(invoiceNumber)
											objects.add(userId);
											employee.getRole().doTask(
													"AllocateDriver", objects); // 3
																				// role:=getRole(),
																				// 4
																				// doTask("Classify",
																				// objects)
										}
									}
								}

							}
						});

					}
				});
			}
		});
	}

	@Override
	public void setModel(Object model) {
		// TODO Auto-generated method stub
		Center.getCenter().addObserver(this);
		employee = (Employee) model;
	}

	@Override
	public void viewInvoker() {
		// TODO Auto-generated method stub
		elist.add(String.valueOf(employee.getCenterId()));
		elist.add("Available");

		showAllocationView();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		System.out.println("Update View!!!!---allocation");

		containerListModel.clear();
		drivers.clear();

		containers = (List) Center.getCenter().getLcontainer();
		drivers = sPostNet.getSPostNet().getActiveEmployee();
		drivers = employee.getRole().getProxy()
				.updateSelect("AvailableDriver", elist);

		/*
		 * This should be Separate Method
		 */

		for (int i = 0; i < containers.size(); i++) {
			System.out.println(containers.get(i).getInvoiceNumber()
					+ "!!!!!!!!!!!status:" + containers.get(i).getStatus());
			if (containers.get(i).getStatus().equals("Classified")
					|| containers.get(i).getStatus().equals("idle")
					|| containers.get(i).getStatus().equals("Idle")) {
				containerListModel.addElement(containers.get(i)
						.getInvoiceNumber());
				System.out.println("register......."
						+ containers.get(i).getInvoiceNumber());
			} else if (containers.get(i).getStatus().equals("Allocated")) {
				containerListModel.removeElement(containers.get(i)
						.getInvoiceNumber());
			}
		}

		System.out.println("USERID----" + drivers.get(0).getUserId());

		for (int i = 0; i < drivers.size(); i++) {
			System.out.println("USERID----" + drivers.get(i).getUserId());
			driverListModel.addElement(drivers.get(i).getUserId());
		}

		if (drivers.size() == 0) {
			System.out.println("No Item in the list");
		}

		if (containers.size() == 0) {
			System.out.println("No Item in the list");
		}
	}

}
