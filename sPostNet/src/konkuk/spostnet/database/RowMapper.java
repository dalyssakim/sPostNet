package konkuk.spostnet.database;

import java.sql.ResultSet;
import java.sql.SQLException;


public interface RowMapper <T> {
	@SuppressWarnings("hiding")
	public <T> T  mapRow(ResultSet rs, int rownum) throws SQLException;
}
