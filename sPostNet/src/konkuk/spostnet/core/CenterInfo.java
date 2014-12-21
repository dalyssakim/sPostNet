package konkuk.spostnet.core;

import konkuk.spostnet.model.Client;

public abstract class CenterInfo extends Client {

	public CenterInfo(String name, String nation, String city, String address,
			String phone) {
		super(name, nation, city, address, phone);
		// TODO Auto-generated constructor stub
	}
	private int id;
	private String stlocation;
	private int ilocationX;
	private int ilocationY;
	
	public void setCenterInfo(int id, String stlocation, int ilocationX, int ilocationY){
		this.id = id;
		super.setAddress(stlocation);
		this.stlocation = stlocation;
		this.ilocationX = ilocationX;
		this.ilocationY = ilocationY;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStlocation() {
		return stlocation;
	}
	public void setStlocation(String stlocation) {
		this.stlocation = stlocation;
	}
	public int getIlocationX() {
		return ilocationX;
	}
	public void setIlocationX(int ilocationX) {
		this.ilocationX = ilocationX;
	}
	public int getIlocationY() {
		return ilocationY;
	}
	public void setIlocationY(int ilocationY) {
		this.ilocationY = ilocationY;
	}
	
	
}
