package konkuk.spostnet.abstractobject;

import konkuk.spostnet.model.Client;
import konkuk.spostnet.model.PaymentSpec;

public abstract class Mail {

	int invoiceNumber;
	Client sender;
	Client receiver;
	PaymentSpec paymentSpec;
	String status;
	int centerId;
	int empId;
	String type;
	
	public void specifyMail(Client sender, Client receiver, PaymentSpec paymentSpec, int invoiceNumber, String status, int centerId, int empId, String type){
		this.sender = sender;
		this.receiver = receiver;
		this.paymentSpec = paymentSpec;
		this.invoiceNumber = invoiceNumber;
		this.status = status;
		this.centerId = centerId;
		this.empId = empId;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	
	public int getCenterId() {
		return centerId;
	}

	public void setCenterId(int centerId) {
		this.centerId = centerId;
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
