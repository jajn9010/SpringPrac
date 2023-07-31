package edu.kosa.util;

import java.sql.Connection;

import edu.kosa.dao.UserDAO;

public class DBConnect extends UserDAO {

	@Override
	public Connection getConnection() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Connection getConnection(String dns) throws Exception {

		return null;
	}

	public Connection getConnection(String dns, String user, String pwd) throws Exception {

		return null;
	}
}
