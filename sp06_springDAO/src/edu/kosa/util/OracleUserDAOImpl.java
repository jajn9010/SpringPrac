package edu.kosa.util;

import java.sql.Connection;
import java.sql.DriverManager;

import edu.kosa.dao.UserDAO;

public class OracleUserDAOImpl extends UserDAO {

	@Override
	public Connection getConnection() throws Exception {
		//1. Driver load ... exception
		Class.forName("oracle.jdbc.OracleDriver");
		
		//2. Connection & Open
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String uid = "jin";
		String pwd = "oracle";
		
		Connection conn = DriverManager.getConnection(url, uid, pwd);
		
		return conn;
	}
}
