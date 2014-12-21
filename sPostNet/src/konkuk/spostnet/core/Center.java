package konkuk.spostnet.core;

import java.util.ArrayList;
import java.util.List;

import konkuk.spostnet.abstractobject.Mail;
import konkuk.spostnet.factory.ActivityToolkit;
import konkuk.spostnet.model.Container;
import konkuk.spostnet.model.Employee;
import konkuk.spostnet.proxy.*;
import konkuk.spostnet.view.LogInView;
import konkuk.spostnet.view.View;

public class Center extends java.util.Observable{
	
	private int centerId;
	private static CenterInfo ourCenter;
	private List<Object> lmail;
	private List<Object> lcontainer;
	private static Center sCenter = null;
	private ServiceIF proxy;
	
	private Center(){
		ourCenter = new LocalCenterInfo("CenterA", "Our Universe", "Earth", "Korea", "82");
		ourCenter.setCenterInfo(1, "Earth", 0, 0);
		proxy = new ServiceProxy();
		setLmail(new ArrayList());
		setLcontainer(new ArrayList());
		

		
		CenterInfo cifoB = new ExternalCenterInfo("CenterB", "Our Universe", "Mars", "Olympus", "1010");
		cifoB.setCenterInfo(0, "Olympus", 100, 200);
		CenterInfo cifoC = new ExternalCenterInfo("CenterC", "Our Universe", "Vinus", "Clouds", "0101");
		cifoC.setCenterInfo(0, "Clouds", 200, 800);
		

		Container c0 = new Container(ourCenter);
		Container c1 = new Container(cifoB);
		Container c2 = new Container(cifoC);
		c1.specifyMail(ourCenter, cifoB, null, new InvoiceGenerator().generateInvoice(), "Idle");
		c2.specifyMail(ourCenter, cifoC, null, new InvoiceGenerator().generateInvoice(), "Idle");
		
		
		lcontainer.add(c0);
		lcontainer.add(c1);
		lcontainer.add(c2);
		/*
		 * Set Sender as Center Info
		 * Receiver External Center Info
		 * Payment Spec null
		 * put new Invoice
		 */
		
	}

	public static Center getCenter(){
		if(sCenter == null) sCenter = new Center();
		
		return sCenter;
	}
	
	public static CenterInfo getCenterInfo(){
		
		return ourCenter;
	}
	
	public void startCenter(){

		centerId = 0;
		View v = new LogInView(); 	// 1.Create()
		v.setModel(this);			// 2. setModel
		
		v.viewInvoker();
	}
	
	public void addItem(Mail mail){
		lmail.add(mail);
	}
	
	
	public int getCenterId() {
		return centerId;
	}

	public void setCenterId(int centerId) {
		this.centerId = centerId;
	}
	
	public void setChanged(){
		super.setChanged();
	}
	
	public boolean processLogin(Employee employee){
		
		List<Object> objects = new ArrayList();		//1 create
		objects.add(employee);						//2 add(employee)
		List<Employee> empList = proxy.updateSelect("Login", objects); //3 empList:= updateSelect("Login", objects)
		if(empList.size() == 0){ 
			return false; 
		}
		
		/*
		 *  View Related
		 */
		Employee actEmp = empList.get(0); 			//4 create
		System.out.println(actEmp.getName()+"-"+actEmp.getRoleName());
		View v = null  ;
		ActivityToolkit at = null;
		try {
			at = ActivityToolkit.getFactory("konkuk.spostnet.concretefactory."+ actEmp.getRoleName() + "Toolkit"); //5 getFactory(actEmp.RoleName)
			actEmp.setRole(at.createRole());			//6 role:=create , 7 setRole(role)
			v = at.createView();						//8 v:=create
			v.setModel(actEmp);							//9 setModel(actEmp)
			
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
		
		v.viewInvoker();								//10 viewInvoker()
		
		return true;
	}

	public List<Object> getLmail() {
		return lmail;
	}

	public void setLmail(List<Object> lmail) {
		this.lmail = lmail;
	}

	public List<Object> getLcontainer() {
		return lcontainer;
	}

	public void setLcontainer(List<Object> lcontainer) {
		this.lcontainer = lcontainer;
	}
	

}
