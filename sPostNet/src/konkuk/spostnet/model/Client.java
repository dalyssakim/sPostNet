package konkuk.spostnet.model;

/**
 * @author Dajung
 *
 */
public class Client {

	 private String name;
	 private String address;
	 private String city;
	 private String nation;
	 private String phone;
	 
	 public Client(String name, String nation, String city, String address, String phone){
		 this.name = name;
		 this.address = address;
		 this.city = city;
		 this.nation = nation;
		 this.phone = phone;
	 }
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	 
	 
}
