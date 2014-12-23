package konkuk.spostnet.factory;

import konkuk.spostnet.abstractobject.Role;
import konkuk.spostnet.view.View;
import konkuk.spostnet.concretefactory.*;

public abstract class ActivityToolkit {

	public static ActivityToolkit getFactory(String key) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Class C = Class.forName(key); 
		ActivityToolkit ac = (ActivityToolkit) C.newInstance();

		return ac;
	}
	
	public abstract Role createRole();
	public abstract View createView();
	
}
