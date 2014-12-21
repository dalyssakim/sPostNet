package konkuk.spostnet.proxy;

import java.util.List;

public interface ServiceIF {

	public boolean updateInsert(String name, List<Object> objects);
	public boolean updateModify(String name, List<Object> objects);
	public boolean updateDelete(String name, List<Object> objects);
	public <T> List<T> updateSelect(String name, List<Object> objects);
}
