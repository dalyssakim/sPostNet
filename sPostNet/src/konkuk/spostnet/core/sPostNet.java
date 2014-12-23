package konkuk.spostnet.core;

import java.util.ArrayList;
import java.util.List;

import konkuk.spostnet.abstractobject.Mail;
import konkuk.spostnet.model.Employee;
import konkuk.spostnet.proxy.ServiceIF;
import konkuk.spostnet.view.View;

public class sPostNet implements ServiceIF{
	
	private List<Center> centers;
	private List<Employee> employees;
	private List<Employee> activeEmployee;
	private ServiceIF proxy;
	private static sPostNet coreCenter = null;
	private static List<Mail> mails = new ArrayList<Mail>();
	
	/*
	 * add center on request
	 */
	private sPostNet(){
		employees = new ArrayList();
		activeEmployee = new ArrayList();
		employees.add(new Employee(0, "micro9110", "Dajung", "1234", 1, "Clerk","Available"));
		employees.add(new Employee(0, "ysi7764", "Suin", "1234", 1, "Clerk", "Available"));
		employees.add(new Employee(0, "micro1007", "Kate", "1234", 1, "WarehouseManager", "Available"));

		
	}
	
	public List<Center> getCenters() {
		return centers;
	}

	public void setCenters(List<Center> centers) {
		this.centers = centers;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Employee> getActiveEmployee() {
		return activeEmployee;
	}

	public void setActiveEmployee(List<Employee> activeEmployee) {
		this.activeEmployee = activeEmployee;
	}

	public ServiceIF getProxy() {
		return proxy;
	}

	public void setProxy(ServiceIF proxy) {
		this.proxy = proxy;
	}

	public static sPostNet getCoreCenter() {
		return coreCenter;
	}

	public static void setCoreCenter(sPostNet coreCenter) {
		sPostNet.coreCenter = coreCenter;
	}

	public static List<Mail> getMails() {
		return mails;
	}

	public static void setMails(List<Mail> mails) {
		sPostNet.mails = mails;
	}

	public static sPostNet getSPostNet(){
		if(coreCenter == null) coreCenter = new sPostNet();
		return coreCenter;
	}
	
	private Employee employeeCheck(Employee requestEmp){
		for(int i = 0; i<employees.size(); i++){
			Employee temp = employees.get(i);
			if(temp.getUserId().equals(requestEmp.getUserId()) && temp.getPwd().equals(requestEmp.getPwd())){
				return temp;
			}
		}
		
		return null;
	}
	
	public void processRequest(String name, String command, List<Object> objects){
		

		
	}

	@Override
	public boolean updateInsert(String name, List<Object> objects) {
		// TODO Auto-generated method stub
		
		if(name.equals("Mail")){
			mails.add((Mail)objects.get(0));
			int i = mails.size()-1;
			System.out.println("Mail Updated- Sender>"+mails.get(i).getSender().getName()+" & Receiver>"+mails.get(i).getReceiver().getName());
			System.out.println("Invoice:"+mails.get(i).getInvoiceNumber());
			return true;
		}

		return false;
	}

	@Override
	public boolean updateModify(String name, List<Object> objects) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDelete(String name, List<Object> objects) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> List<T> updateSelect(String name, List<Object> objects) {

		
		if(name.equals("Login")){
			List<Employee> lemp = new ArrayList();
			Employee e = employeeCheck((Employee)objects.get(0));
			if(e != null){
				lemp.add(e);
				this.activeEmployee.add(e);
			}
			return  (List<T>) lemp;
		}
		
		if(name.equals("LoadItem")){
			List<Mail> lmail = new ArrayList();
			
		}
		
		return null;
	}
	
	
	/*
	 * do proxy on request
	 */

}
