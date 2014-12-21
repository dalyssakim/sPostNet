package konkuk.spostnet.model;

import java.util.ArrayList;
import java.util.List;

import konkuk.spostnet.abstractobject.Role;
import konkuk.spostnet.core.Center;
import konkuk.spostnet.core.InvoiceGenerator;
import konkuk.spostnet.proxy.ServiceIF;
import konkuk.spostnet.proxy.ServiceProxy;

public class Clerk extends Role{

	private Transaction transaction = null;
	private Client sender, receiver;
	double weight;
	int priority;
	
	@Override
	public void doTask(String command, List<Object> objects) {
		// TODO Auto-generated method stub
		System.out.println("Clerk Doing Task"+command);
		/*
		 * if command = ADDITEM
		 * call ADDITEM with the OBJECTS as parameters
		 * ObjectList Nullify
		 */
		
		if(command.equals("ADDITEM")){
			if(transaction == null) transaction = new Transaction();
			sender = (Client) objects.get(0);
			receiver = (Client) objects.get(1);
			weight = (Double) objects.get(2);
			priority = (Integer) objects.get(3);
			
			transaction.addItem(sender, receiver, weight, priority, new InvoiceGenerator().generateInvoice());
			Center.getCenter().addItem(transaction.getMail());

			Center.getCenter().setChanged();
			Center.getCenter().notifyObservers();
			proxy();

			transaction = null;
		}
	}

	@Override
	public void proxy() {
		// TODO Auto-generated method stub
		System.out.println("Sending objects to proxy");
		
		/*
		 * let proxy know this change
		 */
		proxy = (ServiceIF)new ServiceProxy();
		List<Object> objects = new ArrayList();
		objects.add(transaction.getMail());
		proxy.updateInsert("Mail", objects);
		
	}



	
	public int generateInvoiceNumber(){
		return 0;
	}
}
