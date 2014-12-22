package konkuk.spostnet.core;

import konkuk.spostnet.factory.ActivityToolkit;
import konkuk.spostnet.model.Employee;
import konkuk.spostnet.view.View;

public class protoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		

		Center.getCenter().startCenter();

	/*	
		Employee employee = new Employee(0, "dajung", "1234", 1);
		View v = null  ;
		employee.setRoleName("Clerk");
		ActivityToolkit at = null;
		try {
			at = ActivityToolkit.getFactory("konkuk.spostnet.concretefactory."+ employee.getRoleName() + "Toolkit");
			employee.setRole(at.createRole());
			v = at.createView();
			v.setModel(employee);
			
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
		
		v.viewInvoker();
	
	*/	
	}

}
