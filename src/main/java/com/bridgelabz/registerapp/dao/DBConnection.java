package com.bridgelabz.registerapp.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	private static Connection connection = null;

	static {
		InputStream propertiesInputStream = DBConnection.class.getClassLoader().getResourceAsStream("/resources/db.properties");
		Properties properties = new Properties();

		try {
			properties.load(propertiesInputStream);
			Class.forName(properties.getProperty("db.driver"));
			connection = DriverManager.getConnection(
					properties.getProperty("db.url"), 
					properties.getProperty("db.username"), 
					properties.getProperty("db.password"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}
}
