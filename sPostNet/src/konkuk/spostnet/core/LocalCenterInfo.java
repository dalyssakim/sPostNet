package konkuk.spostnet.core;

import java.util.List;

public class LocalCenterInfo extends CenterInfo{

	public LocalCenterInfo(String name, String nation, String city,
			String address, String phone) {
		super(name, nation, city, address, phone);
		// TODO Auto-generated constructor stub
	}

	public void setLocalCenterInfo(int id, String stlocation, int ilocationX,
			int ilocationY) {
		super.setCenterInfo(id, stlocation, ilocationX, ilocationY);
		// TODO Auto-generated constructor stub
	}

	private List<CenterInfo> externalCenters;

	public List<CenterInfo> getExternalCenters() {
		return externalCenters;
	}

	public void setExternalCenters(List<CenterInfo> externalCenters) {
		this.externalCenters = externalCenters;
	}
}
