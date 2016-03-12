package model.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.data.Category;
import utils.ConnectionPoolImpl;

public class CategoryService {

	public CategoryService() {

	}

	public List<Category> getAllCategory() {
		List<Category> list = new ArrayList<>();
		
		try {
			ConnectionPoolImpl connectionPool = new ConnectionPoolImpl();
			Connection connection = connectionPool.getConnection();
			String queryCategory = "select * from ecom_Category";
			
			Statement statement;
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(queryCategory);
			
			while (resultSet.next()) {
				Category Category = new Category();
				
				Category.setID(resultSet.getInt("product_category_id"));
				Category.setName(resultSet.getString("category_name"));
				Category.setDescription(resultSet.getString("description"));
				
				list.add(Category);
			}
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		return list;
		
	}
}
