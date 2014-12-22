package konkuk.spostnet.proxy;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import konkuk.spostnet.abstractobject.Mail;
import konkuk.spostnet.core.Center;
import konkuk.spostnet.core.sPostNet;
import konkuk.spostnet.model.Client;
import konkuk.spostnet.model.Employee;
import konkuk.spostnet.model.Item;

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
			Mail mail = (Mail) objects.get(0);
			
			try {
				String response = http.sendGet(url+"addmail.do?"
						+"invoicenumber="+mail.getInvoiceNumber()
						+"&sendername="+mail.getSender().getName()
						+"&sendernation="+mail.getSender().getNation()
						+"&sendercity="+mail.getSender().getCity()
						+"&senderaddress="+mail.getSender().getAddress()
						+"&receivername="+mail.getReceiver().getName()
						+"&receivernation="+mail.getReceiver().getNation()
						+"&receivercity="+mail.getReceiver().getCity()
						+"&receiveraddress="+mail.getReceiver().getAddress()
						+"&status="+mail.getStatus()
						+"&centerid="+mail.getCenterId());
				
				System.out.println(response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sPostNet.getSPostNet().updateInsert(name, objects);

			return true;
		}

		return false;
	}

	@Override
	public boolean updateModify(String name, List<Object> objects) {
		// TODO Auto-generated method stub
		
		if(name.equalsIgnoreCase("Classify")){
			Mail mail = (Mail)objects.get(0);
			try {
				String response = http.sendGet(url+"changemailstatus.do?invoicenumber="+mail.getInvoiceNumber()+"&status="+mail.getStatus());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(name.equalsIgnoreCase("UpdateStatus")){
			Employee employee= (Employee)objects.get(0);
			try {
				String response = http.sendGet(url+"employeestatus.do?id="+employee.getId()+"&status="+employee.getStatus());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
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
				Center.getCenter().setCenterId(json.getInt("centerId"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//sPostNet.getSPostNet().updateSelect(name, objects);
			return emplist;
		}

		if (name.equals("LoadMail")) {
			Employee employee = (Employee) objects.get(0);
			List maillist = new ArrayList();
			String response = null;
			try {
				response = http.sendGet(url+"fetchmail.do?centerid="+employee.getCenterId()+"&status=Registered");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				JSONArray jsonarray = new JSONArray(response);
				System.out.println(jsonarray.get(0).toString());
				for(int i = 0; i < jsonarray.length(); i++){
					JSONObject json = new JSONObject(jsonarray.get(i).toString());
					System.out.println(json.toString());
					JSONObject jsender = json.getJSONObject("sender");
					JSONObject jreceiver = json.getJSONObject("receiver");
					
					Mail mail = new Item();
					Client sender = new Client(jsender.getString("name"), jsender.getString("nation")
							, jsender.getString("city"), jsender.getString("address"), jsender.getString("phone"));
					Client receiver = new Client(jreceiver.getString("name"), jreceiver.getString("nation")
							, jreceiver.getString("city"), jreceiver.getString("address"), jreceiver.getString("phone"));
					
					mail.specifyMail(sender, receiver, null, json.getInt("invoiceNumber"), json.getString("status"), json.getInt("centerId"));
					System.out.println("Adding To Mail...");
					Center.getCenter().addItem(mail);
					maillist.add(mail);
				}
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//	sPostNet.getSPostNet().updateSelect(name, objects);
		
			return maillist;
			}

			if(name.equalsIgnoreCase("AvailableDriver")){
			
				String centerid = (String)objects.get(0);
				String status = (String)objects.get(1);
				List emplist = new ArrayList();
				String response = null;
				try {
					response = http.sendGet(url+"getemp.do?centerid="+centerid+"&status=Available");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					JSONArray jsonarray = new JSONArray(response);
					System.out.println(jsonarray.get(0).toString());
					for(int i = 0; i < jsonarray.length(); i++){
						JSONObject json = new JSONObject(jsonarray.get(i).toString());
						System.out.println(json.toString());
					
						Employee emp = new Employee(json.getInt("id"), json.getString("userId"), json.getString("name"), json.getString("pwd"), json.getInt("centerId"), json.getString("roleName"));
			
						emplist.add(emp);
					}
					
					
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return emplist;
			}
		
		return null;
	}

}
