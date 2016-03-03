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
	
	public List<User> getUserList() {
		
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
	
	public User getUser(int userId) throws ClassNotFoundException, SQLException {
		
		User returnedUser = new User();
		returnedUser.setID(-1);
		returnedUser.setUserName("client");
		returnedUser.setPassWord("");
		returnedUser.setFullName("Khách");
		
		List<User> UserList = getUserList();
		for (User iUser : UserList) {
			if (iUser.getID() == userId) {
				returnedUser = iUser;
			}
		}
		return returnedUser;
	}
	
	public User getUser(String userName) throws ClassNotFoundException, SQLException {
		
		User returnedUser = new User();
		returnedUser.setID(-1);
		returnedUser.setUserName("client");
		returnedUser.setPassWord("");
		returnedUser.setFullName("Khách");
		
		List<User> UserList = getUserList();
		for (User iUser : UserList) {
			if (iUser.getUserName().equals(userName)) {
				returnedUser = iUser;
			}
		}
		return returnedUser;
	}
//	public User getUser(String userFullName) throws ClassNotFoundException, SQLException {
//		User returnedUser = new User();
//		List<User> UserList = getUserList();
//		for (User iUser : UserList) {
//			if (iUser.getFullName().equals(userFullName)) {
//				returnedUser = iUser;
//			}
//		}
//		return returnedUser;
//	}
	
	public User getUser(String userName, String userPassWord) {
		
		User returnedUser = new User();
		returnedUser.setID(-1);
		returnedUser.setUserName("client");
		returnedUser.setPassWord("");
		returnedUser.setFullName("Khách");
		
		
		List<User> UserList = getUserList();

    	for (User iUser : UserList) {
			if(iUser.getUserName().equals(userName) && iUser.getPassWord().equals(userPassWord)) {
				returnedUser = iUser;
			}
		}
    	return returnedUser;
    }
//	public boolean isIn(String userName, String userPassWord) {
//		
//		List<User> UserList = getUserList();
//
//    	for (User iUser : UserList) {
//			if(iUser.getUserName().equals(userName) && iUser.getPassWord().equals(userPassWord)) {
//				return true;
//			}
//		}
//    	return false;
//
//	}
}
