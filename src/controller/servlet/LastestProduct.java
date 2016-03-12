package controller.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.data.Product;
import model.service.ProductService;

/**
 * Servlet implementation class LastestProduct
 */
@WebServlet("/LastestProduct")
public class LastestProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LastestProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductService proService = new ProductService();
		List<Product> products = new ArrayList<Product>();
		products = proService.getAllProduct();
		request.setAttribute("products", products);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
