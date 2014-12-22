package konkuk.spostnet.abstractobject;

import java.util.List;

import konkuk.spostnet.proxy.ServiceIF;

public abstract class Role {
	
	protected String roleName;
	protected List<Object> list;
	protected ServiceIF proxy;
	
	public void logout(){
		System.out.println("Logout");
	}
	
	public abstract void doTask(String command, List<Object> objects);
	public abstract void proxy();
	public abstract ServiceIF getProxy();

}
