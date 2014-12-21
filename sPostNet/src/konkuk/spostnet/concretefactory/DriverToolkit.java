package konkuk.spostnet.concretefactory;

import konkuk.spostnet.abstractobject.Role;
import konkuk.spostnet.factory.ActivityToolkit;
import konkuk.spostnet.model.Driver;
import konkuk.spostnet.view.DriverView;
import konkuk.spostnet.view.View;

public class DriverToolkit  extends ActivityToolkit{

	@Override
	public Role createRole() {
		// TODO Auto-generated method stub
		return new Driver();
	}

	@Override
	public View createView() {
		// TODO Auto-generated method stub
		return new DriverView();
	}

}
