package konkuk.spostnet.model;

import java.util.List;

public class LocalCenterInfo extends CenterInfo{

	public LocalCenterInfo(String id, String name, String nation, String city,
			String address, String phone) {
		super(id, name, nation, city, address, phone);
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
