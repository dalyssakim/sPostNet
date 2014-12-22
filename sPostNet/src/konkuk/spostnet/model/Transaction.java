package konkuk.spostnet.model;

import java.util.ArrayList;
import java.util.List;

import konkuk.spostnet.abstractobject.Mail;
import konkuk.spostnet.concretefactory.MailFactory;
import konkuk.spostnet.core.Center;
import konkuk.spostnet.proxy.ServiceIF;
import konkuk.spostnet.proxy.ServiceProxy;

public class Transaction {

	private Mail mail;
	
	public PaymentSpec generatePaymentSpec(Client sender, Client receiver, int priority, double weight){

		return null;
	}
	
	public void addItem(Client sender, Client receiver, double weight, int priority,  int invoiceNumber){
		try {
			
			mail = MailFactory.createMail("konkuk.spostnet.model.Item");
			PaymentSpec paymentSpec = generatePaymentSpec(sender, receiver, priority, weight);
			mail.specifyMail(sender, receiver, paymentSpec, invoiceNumber, "Registered", Center.getCenter().getCenterId());
			System.out.println("AddItem!!! : "+sender.getName());
			
		
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
				
	}
	
	public Mail getMail(){
		return this.mail;
	}
	
	public double calculateFee(PaymentSpec spec){
		/*
		 * Calculate the fee
		 */
		
		return 0;
	}
	
}
