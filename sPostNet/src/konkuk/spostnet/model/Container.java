package konkuk.spostnet.model;

import java.util.ArrayList;
import java.util.List;

import konkuk.spostnet.abstractobject.Mail;
import konkuk.spostnet.core.CenterInfo;

public class Container extends Mail{
	
	private CenterInfo center;
	private List<Mail> items = null;

	public Container(CenterInfo center){
		this.setCenter(center);
	}
	
	public List<Mail> getItems() {
		return items;
	}

	public void setItems(List<Mail> items) {
		this.items = items;
	}
	
	public void addSingleItem(Mail mail){
		
		if(items == null) items = new ArrayList();
		
		items.add(mail);
		
	}

	public CenterInfo getCenter() {
		return center;
	}

	public void setCenter(CenterInfo center) {
		this.center = center;
	}
	
	
}
