package com.t3h.ecommerce.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.t3h.ecommerce.entity.EcomProduct;
import com.t3h.ecommerce.service.GetProduct;

/**
 * Servlet implementation class ProductDetail
 */
@WebServlet("/ProductDetail")
public class ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		int productid=Integer.parseInt(request.getParameter("productid").trim());
		GetProduct getProduct=new GetProduct();
		List<EcomProduct> ecomProducts=getProduct.getProduct(productid);;
		if(!ecomProducts.isEmpty()){
			EcomProduct ecomProduct=ecomProducts.remove(0);
			request.setAttribute("ecomProduct", ecomProduct);
			request.getRequestDispatcher("single-product.jsp").forward(request, response);
		}
		}catch(NumberFormatException e){
			
		}catch (NullPointerException  e) {
			request.getRequestDispatcher("single-product.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
