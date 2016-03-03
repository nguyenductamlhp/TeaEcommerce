package model.service;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.data.Product;
import utils.ConnectionPoolImpl;

public class ProductService {
	
	@SuppressWarnings("rawtypes")
	public List getProductList()  {
		List<Product> list = new ArrayList<>();
		
		try {
			ConnectionPoolImpl connectionPool = new ConnectionPoolImpl();
			Connection connection = connectionPool.getConnection();
			String queryProduct = "select * from ecom_product";
			
			Statement statement;
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(queryProduct);
			
			while (resultSet.next()) {
				Product product = new Product();
				
				product.setID(resultSet.getInt("product_id"));
				product.setName(resultSet.getString("product_name"));
				product.setPrice(resultSet.getInt("product_price"));
				product.setPrice_promotion(resultSet.getInt("product_price_promotion"));
				product.setDescription(resultSet.getString("description"));
				product.setCategoryID(resultSet.getInt("product_category_id"));
				product.setImageLink(resultSet.getString("product_image"));
				product.setMakerDate(resultSet.getString("maker_date"));
				product.setMaker(resultSet.getString("maker"));
				list.add(product);
			}
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public Product getProduct(int productID) throws SQLException {
		@SuppressWarnings("unchecked")
		List<Product> ProductList = getProductList();
		for (Product product : ProductList) {
			if (product.getID() == productID) {
				return product;
			}
		}
		return null;
	}
	public Product getProduct(String productName) throws SQLException {
		@SuppressWarnings("unchecked")
		List<Product> ProductList = getProductList();
		for (Product product : ProductList) {
			if (product.getName().equals(productName)) {
				return product;
			}
		}
		
		for (Product product : ProductList) {
			if (product.getName().contains(productName)) {
				return product;
			}
		}
		return null;
	}
	
}
