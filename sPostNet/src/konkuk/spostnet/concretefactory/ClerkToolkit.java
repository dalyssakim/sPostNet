package konkuk.spostnet.concretefactory;

import konkuk.spostnet.abstractobject.Role;
import konkuk.spostnet.factory.ActivityToolkit;
import konkuk.spostnet.model.Clerk;
import konkuk.spostnet.view.ClerkView;
import konkuk.spostnet.view.View;

public class ClerkToolkit extends ActivityToolkit {

	@Override
	public Role createRole() {
		// TODO Auto-generated method stub
		return new Clerk();
	}

	@Override
	public View createView() {
		
		return new ClerkView();
	}

}
