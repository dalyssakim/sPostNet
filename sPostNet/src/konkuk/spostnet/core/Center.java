package konkuk.spostnet.core;

import java.util.ArrayList;
import java.util.List;

import konkuk.spostnet.abstractobject.Mail;
import konkuk.spostnet.factory.ActivityToolkit;
import konkuk.spostnet.model.Client;
import konkuk.spostnet.model.Container;
import konkuk.spostnet.model.Employee;
import konkuk.spostnet.model.Timer;
import konkuk.spostnet.proxy.*;
import konkuk.spostnet.view.LogInView;
import konkuk.spostnet.view.View;

public class Center extends java.util.Observable {

	private int centerId;
	private static CenterInfo ourCenter;
	private List<Client> externalCenters;
	private List<Mail> lmail; // contains all mail info that this particular
								// employee should know
	private List<Mail> lcontainer; // contains all container info
	private List<Object> employees; // contains all employee info
	private static Center sCenter = null;
	private ServiceIF proxy;
	Employee actEmp;

	private Center() {

		proxy = new ServiceProxy();
		setLmail(new ArrayList());
		setLcontainer(new ArrayList());

	}

	public static Center getCenter() {
		if (sCenter == null)
			sCenter = new Center();

		return sCenter;
	}

	public static CenterInfo getCenterInfo() {

		return ourCenter;
	}

	public void startCenter() {

		centerId = 0;
		View v = new LogInView(); // 1.Create()
		v.setModel(this); // 2. setModel

		v.viewInvoker();
	}

	public void fetch() {
		new Timer() {

			@Override
			public void fetch(String roleName) {
				// TODO Auto-generated method stub
				/*
				 * while(true) Call Proxy to get information lmail = lcontainer
				 * = employees =
				 * 
				 * this.setChanged(); this.notifyObservers; sleep(1000);
				 */

				while (true) {

					try {
						List empparam = new ArrayList();
						empparam.add(String.valueOf(actEmp.getCenterId()));
						empparam.add("Available");
						employees = proxy
								.updateSelect("AvailableEmp", empparam);
						if (employees == null) {
							System.out
									.println("Something is wrong - employees");
						}
						List mailparam = new ArrayList();
						mailparam.add(actEmp);
						mailparam.add("All");
						mailparam.add("Item");
						lmail = proxy.updateSelect("LoadMail", mailparam);
			

						mailparam.remove(2);
						mailparam.add("Container");
						lcontainer = proxy.updateSelect("LoadMail", mailparam);
						
						for(int i = 0; i < lcontainer.size(); i++){
							for(int j = 0; j < externalCenters.size(); j++){
								if(((Container)lcontainer.get(i)).getReceiver().getCity().equalsIgnoreCase(externalCenters.get(j).getCity()))
								{((Container)lcontainer.get(i)).setCenter((CenterInfo)externalCenters.get(j));}
							}
						}
						
						
						
						if(lcontainer != null){
						for(int i = 0; i < lcontainer.size(); i++){
							List cparam = new ArrayList();
							if(lcontainer.get(i) != null){
							cparam.add(lcontainer.get(i));
							((Container)lcontainer.get(i)).setItems(proxy.updateSelect("FetchContainer", cparam));
							}
							}
						}
						setChanged();
						notifyObservers();
						
						sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			@Override
			public void run() {
				// TODO Auto-generated method stub
				fetch(actEmp.getRoleName());

			}

		}.start();
	}

	public void addItem(Mail mail) {
		lmail.add(mail);
	}

	public int getCenterId() {
		return centerId;
	}

	public void setCenterId(int centerId) {
		this.centerId = centerId;
	}

	public void setChanged() {
		super.setChanged();
	}

	public boolean processLogin(Employee employee) {

		List<Object> objects = new ArrayList(); // 1 create
		objects.add(employee); // 2 add(employee)
		List<Employee> empList = proxy.updateSelect("Login", objects); // 3
																		// empList:=
																		// updateSelect("Login",
																		// objects)
		if (empList.size() == 0) {
			return false;
		}

		/*
		 * View Related
		 */
		actEmp = empList.get(0); // 4 create
		System.out.println(actEmp.getName() + "-" + actEmp.getRoleName());
		View v = null;
		ActivityToolkit at = null;
		try {
			at = ActivityToolkit.getFactory("konkuk.spostnet.concretefactory."
					+ actEmp.getRoleName() + "Toolkit"); // 5
															// getFactory(actEmp.RoleName)
			actEmp.setRole(at.createRole()); // 6 role:=create , 7 setRole(role)
			v = at.createView(); // 8 v:=create
			v.setModel(actEmp); // 9 setModel(actEmp)

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		v.viewInvoker(); // 10 viewInvoker()

		System.out.println("Loading Data....");
		List object = new ArrayList();
		object.add(actEmp.getCenterId());
		ourCenter = (CenterInfo) proxy.updateSelect("Local", object).get(0);
		externalCenters = proxy.updateSelect("ExternalCenters", object);
		this.fetch();
		this.setChanged();
		this.notifyObservers();

		return true;
	}

	public List<Mail> getLmail() {
		return lmail;
	}

	public void setLmail(List<Mail> lmail) {
		this.lmail = lmail;
	}

	public List<Mail> getLcontainer() {
		return lcontainer;
	}

	public void setLcontainer(List<Mail> lcontainer) {
		this.lcontainer = lcontainer;
	}

	public List<Object> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Object> employees) {
		this.employees = employees;
	}

}
