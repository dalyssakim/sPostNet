package konkuk.spostnet.proxy;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import konkuk.spostnet.abstractobject.Mail;
import konkuk.spostnet.core.sPostNet;
import konkuk.spostnet.model.Employee;

public class ServiceProxy implements ServiceIF {

	sPostNetHttpURLConnection http = new sPostNetHttpURLConnection();
	String url = "http://192.168.19.128:8080/dms/";
	
	@Override
	public boolean updateInsert(String name, List<Object> objects) {
		// TODO Auto-generated method stub
		if (name.equals("Mail")) {
			/*
			 * send mail to sPostNet
			 */
			sPostNet.getSPostNet().updateInsert(name, objects);

			return true;
		}

		return false;
	}

	@Override
	public boolean updateModify(String name, List<Object> objects) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean updateDelete(String name, List<Object> objects) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public <T> List<T> updateSelect(String name, List<Object> objects) {
		// TODO Auto-generated method stub

		if (name.equals("Login")) {
			Employee employee = (Employee)objects.get(0);
			List emplist = new ArrayList();
			try {
				String response = http.sendGet(url+"login.do?id="+employee.getUserId()+"&pwd="+employee.getPwd());
				JSONObject json = new JSONObject(response);
				employee.setCenterId(json.getInt("centerId"));
				employee.setId(json.getInt("id"));
				employee.setName(json.getString("name"));
				employee.setRoleName(json.getString("roleName"));
				emplist.add(employee);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//sPostNet.getSPostNet().updateSelect(name, objects);
			return emplist;
		}

		if (name.equals("LoadMail")) {
			return sPostNet.getSPostNet().updateSelect(name, objects);
		}

		
		return null;
	}

}
