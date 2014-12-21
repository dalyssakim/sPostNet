package konkuk.spostnet.model;

import java.util.List;

import konkuk.spostnet.abstractobject.Mail;
import konkuk.spostnet.abstractobject.Role;
import konkuk.spostnet.core.Center;
import konkuk.spostnet.proxy.ServiceProxy;

public class WarehouseManager extends Role{


	public WarehouseManager(){
		proxy = new ServiceProxy();
	}
	
	@Override
	public void doTask(String command, List<Object> objects) {
		// TODO Auto-generated method stub
		if(command.equals("LoadMail")){
			objects = Center.getCenter().getLmail();
			System.out.println(((Mail)objects.get(0)).getSender().getName());
		}
		
		if(command.equals("Classify")){
			int invoice = (Integer) objects.get(0);
			
			for(int i = 0; i < Center.getCenter().getLmail().size(); i++){
				Mail temp = (Mail)Center.getCenter().getLmail().get(i);
				if(temp.getInvoiceNumber() == invoice){
					classifyItemToList((Mail)Center.getCenter().getLmail().get(i));
					System.out.println(((Mail)Center.getCenter().getLmail().get(i)).getStatus());

					Center.getCenter().setChanged();
					Center.getCenter().notifyObservers();
					return ;
				}
			}
		}
		
		if(command.equals("AllocateDriver")){
			
		}
	}

	@Override
	public void proxy() {
		// TODO Auto-generated method stub
		
	}

	public void classifyItemToList(Mail mail){
		mail.setStatus("Classified");
		/*
		 * updateModify Value of this one
		 */
		
			/*
			 * Classifying
			 */
			for(int i = 0; i < Center.getCenter().getLcontainer().size(); i++){	// 1 lcontainer := getLcontainer() , 2 size:=size()
				System.out.println(((Container) Center.getCenter().getLcontainer().get(i)).getCenter().getCity()); // 3 [*i=0...size] temp:=get(i), 4 center:=getCenter(), 5 city:=getCity();
				if(((Container) Center.getCenter().getLcontainer().get(i)).getCenter().getCity().equals(mail.getReceiver().getAddress())){
			((Container) Center.getCenter().getLcontainer().get(i)).addSingleItem(mail); // 6 [city=mail.receiver.getAddress] addSingleItem(mail);
			}
			}
		
			/*
			 * Below is for Debugging
			 */
			for(int i = 0; i < Center.getCenter().getLcontainer().size(); i++){
				
				Container tempCon = (Container)Center.getCenter().getLcontainer().get(i); 
				System.out.println("Container: "+ tempCon.getCenter().getName());
				if(tempCon.getItems() != null && tempCon.getItems().size() != 0){
				for(int j = 0; j < tempCon.getItems().size(); j++){
					Mail m = tempCon.getItems().get(j);
					System.out.println(m.getInvoiceNumber());
				}
				}
			}
			
			/*
			 * Call Proxy to Update Item STatus!!
			 */
			
	}
	
	public void allocateContainer(){
		
	}
	/*
	 * city == lcontainer.externalcenterinfo.city
	 * addSingleItem to the container
	 */
}
