import java.util.ArrayList;
import java.util.List;

import model.data.Product;
import model.data.User;
import model.service.ProductService;
import model.service.UserService;

public class test {

	public static void main(String[] args) {

//		List<Product> list = new ArrayList<>();
//		ProductService proService = new ProductService();
//		list = proService.getProductList();
//		for (Product product : list) {
//			System.out.println(product.getImageLink());
//		}
//		
		List<User> listUser = new ArrayList<>();
		UserService userService = new UserService();
		listUser = userService.getAllUser();
		
		User u = new User();
		u.setID(34);
		u.setUserName("root");
		u.setPassWord("root");
		for (User user : listUser) {
			
			System.out.println(userService.checkUser(u.getUserName(), u.getPassWord()).getUserName());
		}
	}

}
