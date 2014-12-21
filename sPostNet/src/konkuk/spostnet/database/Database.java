package konkuk.spostnet.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public abstract class Database {

	private String databaseName;
	private int iDbType; //iDbType 0 - JDBC Driver
	private String host;
	private String user;
	private String password;
	private String connectString;
	private String stError;
	private int iSqlCount;
	private DbConnect Connect;
	private long lExecuteTime = 0L;
	private int iDebugLevel = 0;
	private String stDebugTrace = "";
	private DecimalFormat decFmt = new DecimalFormat("###.########");
	private Statement[] aStmt = null;
	private ResultSet[] aRs = null;
	private int iMaxStatement = 0;
	
	public Database(String stDbName,int iDbType, String host, String user, String password) {
		try {
			this.iDbType = iDbType;
			this.host = host;
			this.user = user;
			this.password = password;
			this.connectString = "";
			this.databaseName = stDbName;
			// this.Connect = new Connect(this.iDbType, this.stHost,
			// this.stUser,
			// this.stPassword, this.stDbName, this.stConnectString);
			this.Connect = new DbConnect(0, "localhost", "eps", "eps",
					this.databaseName, this.connectString);
			if (this.Connect != null)
				this.stError += " Connection Error";
		} catch (Exception e) {
			this.stError = (this.stError + "<br>Database: " + this.host
					+ " " + this.user + " type: " + this.iDbType
					+ " Exception: " + e);
		}
	}
	
	public void Close() {
		if (this.Connect != null)
			this.Connect.Close();
	}
	
	public ResultSet query(String stSql) {
		long startTime = System.nanoTime();
		try {
			if (this.aStmt == null) {
				this.aStmt = new Statement[20];
				this.aRs = new ResultSet[20];
			}
			Connection dbConn = this.Connect.getConn();
			this.iMaxStatement = ((this.iMaxStatement + 1) % 20);
			this.aStmt[this.iMaxStatement] = dbConn.createStatement(1004, 1007);
			this.aRs[this.iMaxStatement] = this.aStmt[this.iMaxStatement]
					.executeQuery(stSql);
		} catch (Exception e) {
			e.printStackTrace();
			this.stError = (this.stError + "<br>ExecuteSql: " + stSql
					+ " iMaxStatement = " + this.iMaxStatement + " Exception: " + e);
		}
		
		return this.aRs[this.iMaxStatement];
	}
	
	public <T> List<T> executeSql(String query, RowMapper rowMapper){
		ResultSet rs = this.query(query);
		List list = new ArrayList();
		int maxRowNum ;
		try {
			maxRowNum = rs.getRow();
			for(int i = 0; i < maxRowNum; i++){
				list.add(rowMapper.mapRow(rs, i));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
}
