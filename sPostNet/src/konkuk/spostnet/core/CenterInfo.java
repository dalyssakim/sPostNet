package konkuk.spostnet.core;

import konkuk.spostnet.model.Client;

public abstract class CenterInfo extends Client {
	
	private String id;

	public CenterInfo(String id, String name, String nation, String city, String address,
			String phone) {
		super(name, nation, city, address, phone);
		this.setId(id);
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
	
}
