package konkuk.spostnet.model;

import java.util.ArrayList;
import java.util.List;

import konkuk.spostnet.abstractobject.Mail;
import konkuk.spostnet.abstractobject.Role;
import konkuk.spostnet.core.Center;
import konkuk.spostnet.core.sPostNet;
import konkuk.spostnet.proxy.ServiceIF;

public class Driver extends Role {

	List<Object> containers ;
	
	public List<Object> getContainers() {
		return containers;
	}

	public void setContainers(List<Object> containers) {
		this.containers = containers;
	}

	public void addContainer(Container container){
		if(containers == null)
			containers = new ArrayList();
		containers.add(container);
	}
	
	@Override
	public void doTask(String command, List<Object> objects) {
		// TODO Auto-generated method stub
		if(command.equals("Completed")){
			int invoice = (Integer) objects.get(0);
			
			System.out.println("[[[[driver]]]"+Center.getCenter().getLmail().size());
			
			for(int i=0 ; i<Center.getCenter().getLcontainer().size();i++){
				Mail temp = (Mail)Center.getCenter().getLcontainer().get(i);
				if(temp.getInvoiceNumber() == invoice){
					
					deliveryItem(temp);
					Center.getCenter().setChanged();
					Center.getCenter().notifyObservers();
					return ;
				}
			}
			
			for(int i = 0; i < Center.getCenter().getLmail().size(); i++){
				System.out.println("-------------------------------------------------");
				Mail temp = (Mail)Center.getCenter().getLmail().get(i);
				System.out.println("====================");
				System.out.println("[[[[driver]]]"+temp.getInvoiceNumber());
				if(temp.getInvoiceNumber() == invoice){
					deliveryItem(temp);
					Center.getCenter().setChanged();
					Center.getCenter().notifyObservers();
					return ;
				}
			}
		}
		
	}
	
	public void deliveryItem(Mail mail){
		mail.setStatus("Completed");
		System.out.println("Class Driver ~ change status");
	}


/*	public void allocateContainer(Container container, String userId){
		//change container_state, notify driver.
		List<Employee> Lemployee = sPostNet.getSPostNet().getActiveEmployee();
		List<Object> Lcontainer = Center.getCenter().getLcontainer();
		
		container.setStatus("Allocated");
		
		if(container.getItems() != null){
			List<Mail> Litem = container.getItems();
			for(int i=0 ; i<Litem.size() ;i++){
				Litem.get(i).setStatus("Allocated");
			}
		}

		for(int i=0; i<Lemployee.size() ; i++){
			if(Lemployee.get(i).getUserId().equals(userId)){
				System.out.println("UserId!!!"+userId);	//notify
				Lemployee.get(i).setState("Deliverying");
				if(Lemployee.get(i).getRole() != null)
					((Driver)(Lemployee.get(i).getRole())).addContainer(container);
				else
				System.out.println("asdf");
			}
		
		
		}*/
	@Override
	public void proxy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServiceIF getProxy() {
		// TODO Auto-generated method stub
		return proxy;
	}

}
