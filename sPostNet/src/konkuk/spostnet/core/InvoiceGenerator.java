package konkuk.spostnet.core;

public class InvoiceGenerator {

	public int generateInvoice(){
		double ranNum = Math.random();
		double d = ranNum * 100000;
		int ranInt = (int) d;
		return ranInt;
	}
	
}
