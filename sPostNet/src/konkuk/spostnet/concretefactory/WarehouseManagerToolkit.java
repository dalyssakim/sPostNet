package konkuk.spostnet.concretefactory;

import konkuk.spostnet.abstractobject.Role;
import konkuk.spostnet.factory.ActivityToolkit;
import konkuk.spostnet.model.WarehouseManager;
import konkuk.spostnet.view.View;
import konkuk.spostnet.view.WarehouseManagerView;


public class WarehouseManagerToolkit  extends ActivityToolkit{

	@Override
	public Role createRole() {
		// TODO Auto-generated method stub
		return new WarehouseManager();
	}

	@Override
	public View createView() {
		// TODO Auto-generated method stub
		return new WarehouseManagerView();
	}

}
