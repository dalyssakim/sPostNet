package konkuk.spostnet.concretefactory;

import konkuk.spostnet.abstractobject.Mail;
import konkuk.spostnet.factory.ActivityToolkit;

public class MailFactory {

	public static Mail createMail(String type) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub

		Class C = Class.forName(type); 
		Mail mail = (Mail) C.newInstance();

		return mail;
	
	}

}
