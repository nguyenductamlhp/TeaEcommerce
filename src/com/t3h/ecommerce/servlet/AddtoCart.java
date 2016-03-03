package com.t3h.ecommerce.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.t3h.ecommerce.entity.EcomProduct;
import com.t3h.ecommerce.entity.ProductCart;
import com.t3h.ecommerce.service.GetProduct;

/**
 * Servlet implementation class AddtoCart
 */
@WebServlet("/AddtoCart")
public class AddtoCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddtoCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			int productid = Integer.parseInt(request.getParameter("productid")
					.trim());
			int quantity = Integer.parseInt(request.getParameter("quantity").trim());
			List<ProductCart> listProductCart;
			if (request.getSession().getAttribute("listProductCart") == null) {
				listProductCart = new Vector<ProductCart>();
			} else {
				listProductCart = (List<ProductCart>) request.getSession()
						.getAttribute("listProductCart");
			}
			boolean testProduct = false;
			for (int i = 0; i < listProductCart.size(); i++) {
				if (listProductCart.get(i).getEcomProduct().getProductId() == productid) {
					testProduct=true;
					ProductCart productCart=listProductCart.get(i);
					productCart.setQuantity(productCart.getQuantity()+quantity);
					listProductCart.set(i, productCart);
					break;
				}
			}
			if (testProduct==false) {
				GetProduct getProduct=new GetProduct();
				List<com.t3h.ecommerce.entity.EcomProduct> ecomProducts =getProduct.getProduct(productid);
				
				EcomProduct ecomProduct=ecomProducts.remove(0);
				ProductCart productCart=new ProductCart(ecomProduct, quantity);
				listProductCart.add(productCart);
			}
			
			request.getSession().setAttribute("listProductCart", listProductCart);
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		} catch (NumberFormatException e) {

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
