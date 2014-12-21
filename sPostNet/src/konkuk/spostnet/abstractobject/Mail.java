package konkuk.spostnet.abstractobject;

import konkuk.spostnet.model.Client;
import konkuk.spostnet.model.PaymentSpec;

public abstract class Mail {

	int invoiceNumber;
	Client sender;
	Client receiver;
	PaymentSpec paymentSpec;
	String status;
	
	public void specifyMail(Client sender, Client receiver, PaymentSpec paymentSpec, int invoiceNumber, String status){
		this.sender = sender;
		this.receiver = receiver;
		this.paymentSpec = paymentSpec;
		this.invoiceNumber = invoiceNumber;
		this.status = status;
	}

	public int getInvoiceNumber() {
		return invoiceNumber;
	}


	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Client getSender() {
		return sender;
	}

	public void setSender(Client sender) {
		this.sender = sender;
	}

	public Client getReceiver() {
		return receiver;
	}

	public void setReceiver(Client receiver) {
		this.receiver = receiver;
	}

	public PaymentSpec getPaymentSpec() {
		return paymentSpec;
	}

	public void setPaymentSpec(PaymentSpec paymentSpec) {
		this.paymentSpec = paymentSpec;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
