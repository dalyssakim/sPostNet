package konkuk.spostnet.model;

import konkuk.spostnet.abstractobject.Role;

public class Employee {

	private int id;
	private String userId;
	private String name;
	private String pwd;
	private int centerId;
	private Role role;
	private String status;
	private String roleName;
	
	public Employee(String userId, String pwd, int centerId){
		this.setUserId(userId);
		this.pwd = pwd;
		this.role = null;
	}
	
	public Employee(int id, String userId, String name, String pwd, int centerId, String roleName, String status){
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.pwd = pwd;
		this.centerId = centerId;
		this.roleName = roleName;
		this.status = status;
	}
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getCenterId() {
		return centerId;
	}
	public void setCenterId(int centerId) {
		this.centerId = centerId;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
