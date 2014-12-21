package konkuk.spostnet.concretefactory;

import konkuk.spostnet.abstractobject.Role;
import konkuk.spostnet.factory.ActivityToolkit;
import konkuk.spostnet.model.SeniorManager;
import konkuk.spostnet.view.SeniorManagerView;
import konkuk.spostnet.view.View;

public class SeniorManagerToolkit  extends ActivityToolkit{

	@Override
	public Role createRole() {
		// TODO Auto-generated method stub
		return new SeniorManager();
	}

	@Override
	public View createView() {
		// TODO Auto-generated method stub
		return new SeniorManagerView();
	}

}
