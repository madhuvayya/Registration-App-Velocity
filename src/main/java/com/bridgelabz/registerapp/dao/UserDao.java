package com.bridgelabz.registerapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bridgelabz.registerapp.model.User;

public class UserDao {

	private static DBConnection dbConnection = new DBConnection();
	private static Connection connection = dbConnection.getConnection();
	
	
	public boolean registerUser(User user) throws SQLException {
		
		String registerUserQuery = "INSERT INTO user_details (first_name,last_name,phone_number,email_id,password)\r\n" + 
				"VALUES (?,?,?,?,?)";  
		
		PreparedStatement preparedStatement = connection.prepareStatement(registerUserQuery);
		preparedStatement.setString(1, user.getFirstName());
		preparedStatement.setString(2, user.getLastName());
		preparedStatement.setString(3, user.getPhoneNumber());
		preparedStatement.setString(4, user.getEmailId());
		preparedStatement.setString(5, user.getPassword());
		return preparedStatement.executeUpdate() == 1;
	}

}
