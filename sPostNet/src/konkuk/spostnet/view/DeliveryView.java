package konkuk.spostnet.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

import konkuk.spostnet.abstractobject.Mail;
import konkuk.spostnet.core.Center;
import konkuk.spostnet.model.Container;
import konkuk.spostnet.model.Employee;

public class DeliveryView extends JFrame implements View, java.util.Observer {

	private JPanel contentPane;
	private JFrame frame;
	private Employee employee = null;
	private List<Mail> mails = new ArrayList();
	private List<String> item = new ArrayList();
	private DefaultListModel listModel = new DefaultListModel();
	private JList list = new JList(listModel);

	/**
	 * Create the frame.
	 */
	public DeliveryView(Employee employee) {
		frame = new JFrame();
		frame.setVisible(false);
	}

	public void showDeliveryView() {

		mails = (List) Center.getCenter().getLcontainer(); // 3.1.1
															// mails:=getLcontainer()

		for (int i = 0; i < mails.size(); i++) { // 3.1.2
													// [*i=0...mail.size]mail:=get(i)
			if (mails.get(i).getStatus().equals("Allocated")) { // 3.1.3
																// [mail.status==WaitingDelivery]
				listModel.addElement(mails.get(i).getInvoiceNumber()); // addElement(mail.ContainerInvoiceNumber);
				System.out.println("mail registers on jlist /"
						+ mails.get(i).getInvoiceNumber());
				System.out.println("dddd"
						+ mails.get(i).getReceiver().getAddress());
				try {
					if (Center.getCenter().getCenterInfo().getCity() == mails
							.get(i).getReceiver().getCity()) {
						Container container = (Container) mails.get(i);
						System.out
								.println("dddd" + container.getItems().size());
						for (int j = 0; j < container.getItems().size(); j++) {
							System.out.println("mails in Container~~~~"
									+ container.getItems().get(j)
											.getInvoiceNumber());
							listModel.addElement(container.getItems().get(j)
									.getInvoiceNumber());
						}
					}
				} catch (Exception e) {

				}
			}
		}

		list.setModel(listModel);

		if (item.size() == 0) {
			System.out.println("No Item in the list");
		}

		frame.setVisible(true);
		frame.setTitle("[Driver - Delivery] " + employee.getName());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 426, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		list.setBounds(23, 38, 157, 203);
		contentPane.add(list);

		final JTextPane textPane = new JTextPane();
		textPane.setBounds(211, 38, 178, 159);
		contentPane.add(textPane);

		final JButton btnDelivery = new JButton("Delivery");
		btnDelivery.setBounds(196, 218, 97, 23);
		contentPane.add(btnDelivery);

		JButton btnCompleted = new JButton("Completed");
		btnCompleted.setBounds(305, 218, 97, 23);
		contentPane.add(btnCompleted);
		btnCompleted.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		JLabel lblDeliveryList = new JLabel("Delivery Mail List");
		lblDeliveryList.setBounds(47, 13, 105, 15);
		contentPane.add(lblDeliveryList);

		JLabel lblMailSpecification = new JLabel("Mail Specification");
		lblMailSpecification.setBounds(245, 13, 121, 15);
		contentPane.add(lblMailSpecification);

		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(final ListSelectionEvent e) {
				if (list.getSelectedValue() != null) {
					final int invoiceNumber = (Integer) list.getSelectedValue();

					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							for (int i = 0; i < mails.size(); i++) { // Mail
																		// Specification
								if (invoiceNumber == mails.get(i)
										.getInvoiceNumber()) {
									textPane.setText("Invoice Number : "
											+ mails.get(i).getInvoiceNumber()
											+ "\nDeparture : "
											+ mails.get(i).getSender()
													.getNation()
											+ "\n	"
											+ mails.get(i).getSender()
													.getCity()
											+ "\n	"
											+ mails.get(i).getSender()
													.getAddress()
											+ "\nDestination : "
											+ mails.get(i).getReceiver()
													.getAddress()
											+ "\n	"
											+ mails.get(i).getReceiver()
													.getCity()
											+ "	\n	"
											+ mails.get(i).getReceiver()
													.getAddress() + "\n	");
								}

								if (Center.getCenter().getCenterInfo()
										.getCity() == mails.get(i)
										.getReceiver().getCity()) {
									Container container = (Container) mails
											.get(i);
									try {
										for (int j = 0; j < container
												.getItems().size(); j++) {
											if (invoiceNumber == container
													.getItems().get(j)
													.getInvoiceNumber()) {
												textPane.setText("[Container]"
														+ mails.get(i)
																.getInvoiceNumber()
														+ "\nInvoice Number : "
														+ container
																.getItems()
																.get(j)
																.getInvoiceNumber()
														+ "\nDeparture : "
														+ container.getItems()
																.get(j)
																.getSender()
																.getNation()
														+ "\n	"
														+ container.getItems()
																.get(j)
																.getSender()
																.getCity()
														+ "\n	"
														+ container.getItems()
																.get(j)
																.getSender()
																.getAddress()
														+ "\nDestination : "
														+ container.getItems()
																.get(j)
																.getReceiver()
																.getNation()
														+ "\n	"
														+ container.getItems()
																.get(j)
																.getReceiver()
																.getCity()
														+ "	\n	"
														+ container.getItems()
																.get(j)
																.getReceiver()
																.getAddress()
														+ "\n	");
											}
										}
									} catch (Exception e) {
									}
								}
							}

						}
					});

					System.out.println("Before~~~~~~~~~~~~button!!");
					btnDelivery.addActionListener(new ActionListener() { // Classify(invoiceNumber)
								public void actionPerformed(ActionEvent ae) {
									if (ae.getSource() instanceof JButton
											&& e.getValueIsAdjusting()) {
										System.out
												.println("Before~~~~~~~~~~~~Delivery Completed!!"
														+ invoiceNumber);
										List<Object> objects = new ArrayList(); // 1
																				// create
										objects.add(invoiceNumber);
										objects.add(employee);// 2
																	// add(invoiceNumber)
										employee.getRole().doTask("Completed",
												objects); // 3 role:=getRole(),
															// 4
															// doTask("Classify",
															// objects)
										System.out
												.println("Delivery Completed!!");
									}
								}
							});
				}
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
		Center.getCenter().addObserver(this);
		showDeliveryView();
	}

	@Override
	public void update(Observable o, Object arg) {

		// TODO Auto-generated method stub

		listModel.clear();

		mails = (List) Center.getCenter().getLcontainer();

		/*
		 * This should be Separate Method
		 */

		for (int i = 0; i < mails.size(); i++) {
			if (mails.get(i).getStatus().equals("Allocated")) {
				listModel.addElement(mails.get(i).getInvoiceNumber());
				System.out.println("[" + mails.get(i).getInvoiceNumber() + "]"
						+ mails.get(i).getStatus());

				try {
					if (Center.getCenter().getCenterInfo().getCity() == mails
							.get(i).getReceiver().getAddress()) {
						Container container = (Container) mails.get(i);

						for (int j = 0; j < container.getItems().size(); j++) {
							if (container.getItems().get(j).getStatus()
									.equals("Allocated"))
								listModel.addElement(container.getItems()
										.get(j).getInvoiceNumber());
						}
					}
				} catch (Exception e) {

				}

			}
		}
		if (item.size() == 0) {
			System.out.println("No Item in the list");
		}

	}
}
