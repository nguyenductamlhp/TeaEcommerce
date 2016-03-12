package model.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.data.User;
import utils.ConnectionPoolImpl;

public class UserService {
	
	public List<User> getAllUser() {
		
		List<User> listUser = new ArrayList<User>();
		
		try {
			ConnectionPoolImpl connectionPool = new ConnectionPoolImpl();
			Connection connection = connectionPool.getConnection();

			Statement statement;
			statement = connection.createStatement();
			String selectQuery = "select * from account";
			
			ResultSet resultSet = statement.executeQuery(selectQuery);
			while (resultSet.next()) {
				User user = new User();
				user.setID(resultSet.getInt("id"));
				user.setUserName(resultSet.getString("username"));
				user.setPassWord(resultSet.getString("password"));
				user.setFullName(resultSet.getString("full_name"));
				listUser.add(user);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return listUser;
	}
	
	public User getUserByID(int userId) throws ClassNotFoundException, SQLException {
		
		List<User> listUser = getAllUser();
		for (User user : listUser) {
			if (user.getID() == userId) {
				return user;
			}
		}
		return null;
	}
	
	@SuppressWarnings("null")
	public List<User> getUserByUsername(String userName) throws ClassNotFoundException, SQLException {
		
		List<User> listUser = getAllUser();
		List<User> reListUser = null;
		for (User user : listUser) {
			if (user.getUserName().equals(userName)) {
				reListUser.add(user);
			}
		}
		return reListUser;
	}
	
	public User checkUser(String userName, String userPassWord) {
		
		List<User> listUser = getAllUser();

    	for (User user : listUser) {
			if(user.getUserName().equals(userName) && user.getPassWord().equals(userPassWord)) {
				return user;
			}
		}
    	return null;
    }

}
