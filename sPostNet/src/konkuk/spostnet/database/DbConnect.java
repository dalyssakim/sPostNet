package konkuk.spostnet.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {

	private String databaseName;
	private int iDbType; //iDbType 0 - JDBC Driver
	private String host;
	private String user;
	private String password;
	private String connectString;
	private String stError;
	private Connection dbConn;

	public DbConnect(int i, String host, String user, String password,
			String databaseName, String connectionString) {
		// TODO Auto-generated constructor stub
		this.iDbType = i;
		this.host = host;
		this.user = user;
		this.password = password;
		this.databaseName = databaseName;
		this.connectString = connectionString;
		
		Connect(iDbType, host, user, password, databaseName, connectString);
		
	}

	public void Connect(int iDbType, String stHost, String stUser,
			String stPassword, String stDbName, String stConnectString) {
		this.dbConn = null;
		this.iDbType = iDbType;
		this.host = stHost;
		this.user = stUser;
		this.password = stPassword;
		this.databaseName = stDbName;
		this.connectString = stConnectString;
		try {
			switch (iDbType) {
			case 0:
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();

					String stUrl = "jdbc:mysql://localhost:3306/" + stDbName
							+ "?zeroDateTimehavior=convertToNull";
					this.dbConn = DriverManager.getConnection(stUrl, "eps",
							"eps");
				} catch (Exception e) {
					e.printStackTrace();
					this.stError = (this.stError
							+ "<br>ERROR  mysql Exception: " + e.toString());
				}
				break;

			case 1:
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					String connectionUrl = "jdbc:sqlserver://" + stHost
							+ ":1433;" + "databaseName=" + stDbName + ";user="
							+ stUser + ";password=" + stPassword + ";";

					this.dbConn = DriverManager.getConnection(connectionUrl);
				} catch (SQLException e) {
					this.stError = (this.stError
							+ "<br>ERROR  sqlserver Exception: " + e.toString());
				} catch (ClassNotFoundException cE) {
					this.stError = (this.stError
							+ "<br>ERROR  Class Not Found Exception: " + cE
							.toString());
				}
				break;

			case 2:
				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					String connectionUrl = "jdbc:odbc:" + stConnectString;
					connectionUrl = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=C:\\tmp\\ederbase.mdb;DriverID=22;READONLY=false;";

					this.dbConn = DriverManager.getConnection(connectionUrl);
				} catch (Exception e) {
					this.stError = (this.stError
							+ "<br>ERROR  odbc Exception: " + e.toString());
				}
				break;

			default:
				this.stError = (this.stError
						+ "<br>ERROR  FATAL ERROR: invalid DB TYPE " + iDbType);
				break;
			}
		} catch (Exception e) {
			this.stError = (this.stError + "<br>ERROR  ERROR Connect: "
					+ stHost + " " + stUser 
					+ " Exception: " + e);
		}
	}

	public Connection getConn() {
		try {
			if (this.dbConn != null) {
				if (this.dbConn.isClosed() == true) {
					this.dbConn = null;
				}
			}
			if (this.dbConn == null) {
				Connect(this.iDbType, this.host, this.user,
						this.password, this.databaseName, this.connectString);
				this.stError += "<BR> getConn is CLOSED ";
			}
		} catch (Exception e) {
			this.stError = (this.stError + "<br> getConn ERROR " + e);
		}
		return this.dbConn;
	}

	
	public void Close() {
		try {
			if (this.dbConn != null) {
				this.dbConn.close();
			}
		} catch (Exception e) {
			this.stError = (this.stError + "Datasbase Close Error: " + e
					.toString());
		}
	}
}
